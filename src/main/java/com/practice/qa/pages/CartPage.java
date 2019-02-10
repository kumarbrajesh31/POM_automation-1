package com.practice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.qa.base.Base;

public class CartPage extends Base {




@FindBy(xpath="//td[@class='cart_description']//p[@class='product-name']//a")
public WebElement itemDescription;

@FindBy(xpath="//span[@class='price special-price']")
public WebElement itemPriceInCart;

public CartPage() {
	PageFactory.initElements(driver, this);
}

public String itemPrice() {
	return itemPriceInCart.getText();
}








}
