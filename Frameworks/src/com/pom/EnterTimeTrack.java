//package com.pom;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.generic.BaseTest;
//
//public class EnterTimeTrack extends BaseTest{
//
//	public EnterTimeTrack(WebDriver driver)
//	{
//		PageFactory.initElements(driver, this);
//	}
//
//
//		public void verifyHomePageDisplayed(WebDriver driver,long ETO,String title)
//		{
//			WebDriverWait ww=new WebDriverWait(driver, 10);
//			ww.until(ExpectedConditions.titleContains("Enter"));
//		}
//}
//		
package com.pom;

import java.io.IOException;

import com.generic.Excel;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.generic.GetPhoto;
import com.generic.IAutoConst;



public class EnterTimeTrack implements IAutoConst{
	public EnterTimeTrack(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public  void verifyHomePageIsDisplayed(WebDriver driver,long ETO,String title) throws EncryptedDocumentException, InvalidFormatException 
	{	
		try 
		{
			WebDriverWait ww = new WebDriverWait(driver, ETO);
			ww.until(ExpectedConditions.titleContains(title));
			Reporter.log("HomePage is Displayed",true);
//			Excel.setStatus(XL_PATH, SHEET_NAME, 2, 3, "Pass");
		}
		catch(Exception e)
		{
			Reporter.log("Home Page is not displayed",true);
//			try {
//				GetPhoto.getSnap(driver, title);
//				Excel.setStatus(XL_PATH, SHEET_NAME, 2, 3, "Fail");
//			
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
			Assert.fail();
		}
	}
}
