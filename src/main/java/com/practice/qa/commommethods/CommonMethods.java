package com.practice.qa.commommethods;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practice.qa.base.Base;
import com.practice.qa.pages.SummerDresses;


public class CommonMethods extends Base {
	
	Actions action=new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 15);
	SummerDresses summerdresses=new SummerDresses();
	public String itemPrice;
	static Logger log = Logger.getLogger(CommonMethods.class);
	
	public void selectItemUnderDresses(String category, String itemName) {
		action.moveToElement(driver.findElement(By.xpath("//ul[contains(@class, 'first-in-line-xs')]/preceding-sibling::a[text()='Dresses']"))).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class, 'first-in-line-xs')]/li/a[@title='"+category+"']")));
		driver.findElement(By.xpath("//ul[contains(@class, 'first-in-line-xs')]/li/a[@title='"+category+"']")).click();
		itemPrice=summerdresses.productprice(itemName) ;
		log.info("Item price is: "+itemPrice);
		action.moveToElement(driver.findElement(By.xpath("//ul[@class='product_list grid row']//li//div//div//div//a[@title='"+itemName+"']//child::*"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(), '"+itemName+"')]//ancestor::h5//following-sibling::div//following-sibling::div//a[@title='Add to cart']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Close window']")));
		driver.findElement(By.xpath("//span[@title='Close window']")).click();
		driver.findElement(By.xpath("//a[@title='View my shopping cart']")).click();
	}
	
	
	
	
}
