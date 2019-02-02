package com.practice.qa.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.qa.base.Base;
import com.practice.qa.pages.LoginPage;
import com.practice.qa.pages.MyAccountPage;
import com.practice.qa.pages.SummerDresses;
import com.practice.qa.util.Util;

public class EndToEndFlowTest extends Base {
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	SummerDresses summerDresses;
	Util util;
	public EndToEndFlowTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		initialization();
		myAccountPage= new MyAccountPage();
		loginPage=new LoginPage();
		summerDresses=new SummerDresses();
		util=new Util();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void loginTest() throws InterruptedException{
		loginPage.clickLoginbutton();
		loginPage.login();
//		myAccountPage=loginPage.login();
	String pageTitle=myAccountPage.verifyMyAccountPageTitle();	//verifying my account page is open
	System.out.println(pageTitle);//printing page title
	Assert.assertEquals( pageTitle,"My account - My Store", "My Account Page Title is not matching");//asserting my account page title
	myAccountPage.selectDressCategoryFromMenuDresses("dress_SummerDresses");//selecting summer dresses from menu
	util.selectSizeFilter("L");//selecting size filter
	util.selectColorFilter("Yellow");//selecting color filter
	String price=summerDresses.productprice("Printed Chiffon Dress");//getting  price of the product 
	System.out.println(price);//printing price
	Assert.assertEquals("$16.40", price);//asserting the price
	summerDresses.addToCart("Printed Chiffon Dress");//adding dress to cart
	Thread.sleep(5000);
	Assert.assertEquals(summerDresses.productSuccessfullyAddedToCartMsgText(), "Product successfully added to your shopping cart", "Product is not added to the cart");//Asserting the successfully added message
	summerDresses.clickProceedToCheckout();//Clicking proceed to checkout on confirmation popup
	
	
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
