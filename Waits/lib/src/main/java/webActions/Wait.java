package webActions;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	WebDriver driver = null;

	/**
	 * use this method to initialize the browser.
	 */
	public WebDriver startBrowser() throws MalformedURLException {
		// Code to Launch Browser using Zalenium in Crio workspace
		final DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(BrowserType.CHROME);
		driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);

		return driver;
	}

	public static void snippet1(WebDriver driver) {
		// 1. Open the web page
		driver.get("https://web-locators-static-site-qa.vercel.app/Wait%20onTime");
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// 2. Find the element with class "upload". This is the “Click to make me
		// Disappear” button

		WebElement buttonToClick = driver.findElement(By.className("upload"));

		// 3. Click on the element
		buttonToClick.click();

	}

	public static void snippet2(WebDriver driver) {
		driver.get("https://web-locators-static-site-qa.vercel.app/Wait%20onTime");
		// buttonToClick = driver.findElement(By.className("upload"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("upload")));
		driver.findElement(By.className("upload")).click();
		//ExpectedConditions.
		WebElement buttonDisappear = driver.findElement(By.className("uploadContent"));
		buttonDisappear.click();
	}

	public static void snippet4(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://web-locators-static-site-qa.vercel.app/Wait%20onTime");
		
		WebElement buttonToClick = driver.findElement(By.className("upload"));
		buttonToClick.click();
	}

	public static void snippet5_task(WebDriver driver)  {
		String expectedResult ="I am Captain Dhoni";
		//expectedResult=expectedResult.trim();
		System.out.println("Start Executing snippet5_task");
        driver.get("https://web-locators-static-site-qa.vercel.app/Wait%20onTime");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.className("upload")).click();
		WebDriverWait wdw = new WebDriverWait(driver, 30);
		wdw.until(ExpectedConditions.textToBePresentInElementLocated(By.className("WaitOnTime_FullyLoaded"), expectedResult));
		 String str = driver.findElement(By.className("WaitOnTime_FullyLoaded")).getText();
		System.out.println(str);
		if (str.equals("I am Captain Dhoni")){
           System.out.println("Test Case Passed ");
		}
		else {
			System.out.println("Test Case Failed");
		}

	}

	public static void snippet5(WebDriver driver) {
		driver.get("https://web-locators-static-site-qa.vercel.app/Wait%20onTime");

		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("upload")));
		WebElement buttonToClick = driver.findElement(By.className("upload"));
		buttonToClick.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("uploadContent")));
		WebElement byeButton = driver.findElement(By.className("uploadContent"));
		byeButton.click();

	}

	public static void snippet6(WebDriver driver) {
		driver.get("https://web-locators-static-site-qa.vercel.app/Wait%20onTime");

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout((Duration.ofSeconds(20L)))
				.pollingEvery(Duration.ofMillis(250)).ignoring(Exception.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("upload")));
		driver.findElement(By.className("upload")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("uploadContent")));
		WebElement byeButton = driver.findElement(By.className("uploadContent"));

		byeButton.click();
	}

	public static void snippet5_measure(WebDriver driver) {
		long start = System.currentTimeMillis();

		driver.get("https://web-locators-static-site-qa.vercel.app/Wait%20onTime");

		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("upload")));
		WebElement buttonToClick = driver.findElement(By.className("upload"));
		buttonToClick.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("uploadContent")));
		WebElement byeButton = driver.findElement(By.className("uploadContent"));
		byeButton.click();

		long end = System.currentTimeMillis();
		long elapsedTime = end - start;
		System.out.println("snippet6_measure "+elapsedTime);
		System.out.println("snippet5 took: " + (float) elapsedTime / 1000 + "seconds");
	}

	public static void snippet6_measure(WebDriver driver) {
		long start = System.currentTimeMillis();

		driver.get("https://web-locators-static-site-qa.vercel.app/Wait%20onTime");

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout((Duration.ofSeconds(20L)))
				.pollingEvery(Duration.ofMillis(250)).ignoring(Exception.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("upload")));
		driver.findElement(By.className("upload")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("uploadContent")));
		WebElement byeButton = driver.findElement(By.className("uploadContent"));

		byeButton.click();

		long end = System.currentTimeMillis();
		long elapsedTime = end - start;
		System.out.println("snippet6_measure "+elapsedTime);
		System.out.println("snippet6 took: " + (float) elapsedTime / 1000 + "seconds");
	}

	public static void snippet7(WebDriver driver) {
     driver.navigate().to("https://selenium-waits-mysterious-page.vercel.app/");
	 WebElement randomElement=driver.findElement(By.id("heading_random"));
	 WebElement selectButton=driver.findElement(By.tagName("button"));
     FluentWait<WebDriver> fw = new FluentWait<>(driver);

	 fw.withTimeout(Duration.ofSeconds(30L)).pollingEvery(Duration.ofMillis(300)).ignoring(Exception.class);
	 fw.until(ExpectedConditions.textToBePresentInElement(randomElement, "7"));
	 selectButton.click();

	}

	public static void main(String[] args) throws InterruptedException, MalformedURLException, ParseException {

		// Create the object of Wait class
		Wait wait = new Wait();

		// Start the browser
		WebDriver driver = wait.startBrowser();

		//Uncomment for Milestone 1 Activity 1
		//snippet1(driver);

		// Uncomment for Milestone 2 Activity 2
		// snippet2(driver);

		// Uncomment for Milestone 3 Activity 2
		// snippet3_1(driver);

		// Uncomment for Milestone 4 Activity 1
		// snippet4(driver);

		// Uncomment for Milestone 5 Activity 2
	//	snippet5_task(driver);

		// Uncomment for Milestone 6 Activity 1
		// snippet5(driver);
		// snippet6(driver);

		// snippet5_measure(driver);
		// snippet6_measure(driver);

		// Uncomment for Milestone 6 Activity 2
		 snippet7(driver);
	}

}
