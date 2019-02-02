package com.practice.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.qa.base.Base;

public class SummerDresses extends Base{
	
	 Actions action = new Actions(driver);
	 
	 
	@FindBy(xpath="//h1[contains(@class, 'product-listing')]//span[contains(text(), 'Summer Dresses')]")
	WebElement summerDressesPageTitle;
	
	@FindBy(xpath="//ul[@class='product_list grid row']//li//div//div//div//a[@title='Printed Summer Dress']//child::*")
	WebElement productImage;
	
	@FindBy(xpath="//a[contains(text(), 'Chiffon')]//ancestor::h5//following-sibling::div//following-sibling::div//a[@title='Add to cart']")
	WebElement addToCart;

	@FindBy(xpath="//div[@id= 'layer_cart']/div/div/span/following-sibling::h2")
	WebElement productSuccessfullyAddedToCartMsg;
	
	@FindBy(xpath="//div[contains(@class, 'layer_cart_cart')]//div[contains(@class, 'button-container')]//a[@title='Proceed to checkout']")
	WebElement proceedToCheckoutOnConfirmationPopup;
	
	@FindBy(xpath="//div[@id='layer_cart']")
	WebElement addedToCartConfirmationPopup;
	
	
	
	
	
	public SummerDresses(){
		PageFactory.initElements(driver, this);
	}
	
	public String productprice(String productName){
		
		String price=driver.findElement(By.xpath("//a[contains(text(), '"+productName+"')]//ancestor::h5//following-sibling::div//span[@class='price product-price']")).getText();
//		System.out.println(price);
		return price;
		
	}
	
	
	public void addToCart(String productName){
		action.moveToElement(driver.findElement(By.xpath("//ul[@class='product_list grid row']//li//div//div//div//a[@title='"+productName+"']//child::*"))).build().perform();
	driver.findElement(By.xpath("//a[contains(text(), '"+productName+"')]//ancestor::h5//following-sibling::div//following-sibling::div//a[@title='Add to cart']")).click();
	}
	
	public String productSuccessfullyAddedToCartMsgText(){
		System.out.println("test");
		String successMsg = productSuccessfullyAddedToCartMsg.getText();
		return successMsg;
	}
	
	public void clickProceedToCheckout(){
		proceedToCheckoutOnConfirmationPopup.click();
	}
	
}
