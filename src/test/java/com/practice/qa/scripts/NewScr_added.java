package com.practice.qa.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewScr {
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void envSetUp()
	{
	System.setProperty("webdriver.chrome.driver", "D:\\software\\selenium_software\\Seleniumdrivers\\chromedriver.exe");
	 driver=new ChromeDriver();
	
	}
	4444
	//Test
	@Test
	public void testLogin (){
//		driver.navigateTo("http://dev.shortdatefood.com")
		System.out.println("Test");
	}
}