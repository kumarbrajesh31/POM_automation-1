package com.practice.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practice.qa.base.Base;
import com.practice.qa.util.Util;

public class MyAccountPage extends Base {
	
	 Actions action = new Actions(driver);
	 Util util=new Util();
	
	@FindBy(xpath="//ul[contains(@class, 'first-in-line-xs')]/preceding-sibling::a[text()='Dresses']")
	WebElement menuDresses;
	
	@FindBy(xpath="//ul[contains(@class, 'first-in-line-xs')]/li/a[@title='Evening Dresses']")
	WebElement dresses_EveningDresses;
	
	@FindBy(xpath="//ul[contains(@class, 'first-in-line-xs')]/li/a[@title='Summer Dresses']")
	WebElement dresses_SummerDresses;
	
	
	
	
	WebDriverWait wait = new WebDriverWait(driver, 15);
		 
	
	
	
	public MyAccountPage(){
		PageFactory.initElements(driver, this);
	}
	public String verifyMyAccountPageTitle(){
		return driver.getTitle();
	}
	
	public void selectDressCategoryFromMenuDresses(String category) {
		System.out.println("moving mouse");
		action.moveToElement(menuDresses).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class, 'first-in-line-xs')]/li/a[@title='Evening Dresses']")));
		dresses_SummerDresses.click();
		
	}
	

}
