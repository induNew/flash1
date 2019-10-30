package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(id="username")
	private WebElement userName;
	
	@FindBy(name="pwd")
	private WebElement passWord;
	
	@FindBy(id="loginButton")
	private WebElement click1;
	
	
			
			
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void sendUsername(String ss) {
		userName.sendKeys(ss);
		
	}
	
	public void sendPwd(String ss1) {
		passWord.sendKeys(ss1);
		
	}
	
	public void LoginButton() {
		
		click1.click();
		
	}
	
	
	
	


	
	
	
	
	
	
	
	
	
	

}
