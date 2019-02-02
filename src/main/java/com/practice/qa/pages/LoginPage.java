package com.practice.qa.pages;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.qa.base.Base;

public class LoginPage extends Base {

	//--page Factory--
	
	@FindBy(xpath="//a[contains(text(), 'Sign in')]")
	WebElement signinlink;
	
	@FindBy(xpath="//input[contains(@class, 'control') and @id='email']")
	WebElement emailAddress;
	
	@FindBy(xpath="//input[contains(@class, 'control') and @id='passwd']")
	WebElement password;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement submitLogin;
	
	//--Initializing the page object--
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
		//Actions
		
		public void clickLoginbutton(){
			signinlink.click();
		}
		
		public void login(){
			emailAddress.sendKeys(prop.getProperty("UserID"));
			password.sendKeys(prop.getProperty("Password"));
			submitLogin.click();
//			return new MyAccountPage();
		}
	
}

