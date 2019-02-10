package com.practice.qa.scripts.cart;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.practice.qa.base.Base;
import com.practice.qa.commommethods.CommonMethods;
import com.practice.qa.pages.CartPage;
import com.practice.qa.util.Util;

public class Cart extends Base{

	CommonMethods cmn;
	CartPage cartpage;
	  static Logger log = Logger.getLogger(Cart.class);
	  Util util;
	  SoftAssert softAssertion= new SoftAssert();
	public Cart() {
		super();
	}
	
	@BeforeClass 
	public void beforClass() throws IOException{
		log.info("********************************Started execution "+Cart.class+"**********************************");
		util=new Util();
		util.getTestData("Cart_TestData.xlsx", "Sheet1");
		
	}
	@BeforeMethod
	public void init() throws IOException{
		
		initialization();
		cmn=new CommonMethods();
		cartpage=new CartPage();
		cmn.selectItemUnderDresses("Summer Dresses", "Printed Chiffon Dress");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		//Capture screenshot on test failure
		if(ITestResult.FAILURE==result.getStatus())
		{
			util.takeSnapShot("D:\\Workspace\\POM\\pomAutomationTest\\src\\main\\java\\Screenshots\\tst.png");	
		}
		
		
		driver.quit();
	}
	
	
	@Test(enabled=true)
	public void verifyItemDescriptionOnCart(){
		log.info("Started verifyItemDescriptionOnCart metod");
		//Use of soft assert
		softAssertion.assertEquals( cartpage.itemDescription.getText(), "Printed Chiffon Dress","Item Name is not matching in Cart");
		System.out.println("test afetr fail");
		softAssertion.assertAll();
	}
	
	@Test(enabled=true)
	public void VerifyItemPriceOnCart() {
		log.info("Started VerifyItemPriceOnCart method");
		Assert.assertEquals(cartpage.itemPrice(), cmn.itemPrice, "Item price in cart is not matching");

	System.out.println("log after test fail");
	
}
}
