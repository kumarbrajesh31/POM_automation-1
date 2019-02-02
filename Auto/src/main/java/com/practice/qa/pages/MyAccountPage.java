package com.practice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.qa.base.Base;

public class MyAccountPage extends Base {
	
	 Actions action = new Actions(driver);
	
	@FindBy(xpath="//ul[contains(@class, 'submenu-container clearfix first-in-line-xs')]//a[@title='Dresses']")
	WebElement menuDresses;
	
	@FindBy(xpath="//ul[contains(@class, 'submenu-container clearfix first-in-line-xs')]//a[@title='Dresses']//following::a[6]")
	WebElement mouseHoverEveningDresses;
	
	
	
	
	
	public MyAccountPage(){
		PageFactory.initElements(driver, this);
	}
	public String verifyMyAccountPageTitle(){
		return driver.getTitle();
	}
	
	public void movemousehoverSelectEveningDresses() throws InterruptedException{
		System.out.println("moving mouse");
		Thread.sleep(5000);
		action.moveToElement(menuDresses).build().perform();
		
		System.out.println("Moved moude hover");
		mouseHoverEveningDresses.click();
	}

}
