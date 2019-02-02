package com.practice.qa.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.qa.base.Base;
import com.practice.qa.pages.LoginPage;
import com.practice.qa.pages.MyAccountPage;

public class EndToEndFlowTest extends Base {
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	public EndToEndFlowTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		initialization();
		myAccountPage= new MyAccountPage();
		loginPage=new LoginPage();
		
	}
	
	@Test
	public void loginTest() throws InterruptedException{
		loginPage.clickLoginbutton();
		loginPage.login();
//		myAccountPage=loginPage.login();
	String pageTitle=myAccountPage.verifyMyAccountPageTitle();
	System.out.println(pageTitle);
	Assert.assertEquals( pageTitle,"My account - My Store", "My Account Page Title is not matching");
	myAccountPage.movemousehoverSelectEveningDresses();
	}
	
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
//		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
