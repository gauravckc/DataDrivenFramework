package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	/*
	 * WebDriver Properties Logs ExtentReports DB Excel Mail
	 * 
	 */

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;

	@BeforeSuite
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
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (config.getProperty("browser").equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.get(config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
