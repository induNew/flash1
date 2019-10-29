package com.generic;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class GetPhoto implements IAutoConst{
	
	public static void getSnap(WebDriver driver,String title) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File sc = ts.getScreenshotAs(OutputType.FILE);
	File ff = new File("Error"+GET_SNAP);
	Files.copy(sc,ff);
	}
}
