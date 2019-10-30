package com.generic;

import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConst{

		
	public static String b_name;
	public static String fis;
	public static String con;
	public static WebDriver driver;
	
	
	
	
	@BeforeMethod
	
	public void setUp(String b_name)throws Exception
	{
		Properties con=new Properties();
		FileInputStream fis=new FileInputStream(CONFIG_PATH);
		con.load(fis);
		
		b_name=con.getProperty("browser");
		System.out.println(b_name);
		if(b_name.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver.get("url");
			
		}
		else if(b_name.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver.get("url");
		}
		
	}
	@AfterMethod
	
	public void closeApp(ITestResult result)throws Exception
	{
	
			System.out.println(result.getName());
			System.out.println(result.getStatus());
			if(result.getStatus()==1)
			{
				System.out.println("pass");
				
			}
			
			
			else
			{
				System.out.println("fail");
			}
			
			
			}
					
	}
	
	
	

