package com.generic;

import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConst {

	public static String b_name;
	public static String fis;
	public static String con;
	public static WebDriver driver;
	public static String url;

	@BeforeMethod

	public void setUp() throws Exception {
		Properties con = new Properties();
		FileInputStream fis = new FileInputStream(CONFIG_PATH);
		con.load(fis);

		b_name = con.getProperty("browser");
		System.out.println(b_name);
		if (b_name.equalsIgnoreCase("firefox")) {
			System.setProperty(FIREFOX_KEY, FIREFOX_VALUE);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			url = con.getProperty("url");
			driver.get(url);

		} else if (b_name.equalsIgnoreCase("chrome")) {
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			url = con.getProperty("url");
			driver.get(url);
		}

	}

	@AfterMethod

	public void closeApp(ITestResult result) throws Exception {

		System.out.println(result.getName());
		String testCase=result.getName();
		System.out.println(result.getStatus());
		if (result.getStatus() == 1) {
			Reporter.log("test case pass",true);

		}

		else {
			Reporter.log("test case fail",true);
			GetPhoto.getSnap(driver, testCase);
		}
		driver.quit();

	}

}
