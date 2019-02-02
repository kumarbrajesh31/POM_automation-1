package com.practice.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practice.qa.base.Base;

public class Util extends Base {

	public static long Page_Load_Timeout=10;
	 public static long Implicit_Wait=20;
	 
	 public void switchToFrame(){
		// driver.switchTo().frame("")//add frame name
	 }
	 
	 public void selectColorFilter(String color){
		 driver.findElement(By.xpath("//a[text()='"+color+"']/parent::label/parent::li/input[@type='button']")).click();
		System.out.println("Color filter "+color+" is selected");
	 }
	 
	 public void selectSizeFilter(String size){
		 driver.findElement(By.xpath("//a[text()='"+size+"']/parent::label/parent::li/div/span/input[@class='checkbox']")).click();
		System.out.println("Size filter "+size+" is selected");
	 }
	 
	 
	
	 
	 
}
