package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {

	/*
	 * WebDriver Properties Logs ExtentReports DB Excel Mail
	 * 
	 */

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	
	@BeforeMethod
	public void setUp() throws Exception {
		if (driver == null) {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			config.load(fis);
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			OR.load(fis);
		}

		if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver",
//					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			WebDriverManager.chromedriver().setup(); // Using WebDriverManager
			driver = new ChromeDriver();
		} else if (config.getProperty("browser").equalsIgnoreCase("ie")) {
//			System.setProperty("webdriver.ie.driver",
//					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
			WebDriverManager.iedriver().setup(); // Using WebDriverManager
			driver = new InternetExplorerDriver();
		}
		driver.get(config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);
	}

	public boolean isElementPresent(WebElement ele) {
		
//			driver.findElement((By) ele);

		
		if (ele.isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}

	public boolean waitForElementVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) (element)));
		return true;
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
