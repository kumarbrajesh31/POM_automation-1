package com.practice.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	 
	 public void getTestData(String fileName, String sheetName) throws IOException {
		 File file=new File("D:\\Workspace\\POM\\pomAutomationTest\\src\\main\\java\\com\\practice\\qa\\testdata\\"+fileName);
		 FileInputStream inputStream = new FileInputStream(file);
		 Workbook cartWorkbook = null;
		 String fileExtensionName = fileName.substring(fileName.indexOf("."));
		  if(fileExtensionName.equals(".xlsx")){
		 cartWorkbook=new XSSFWorkbook(inputStream);
		  	}
	
		  else if(fileExtensionName.equals(".xls")){
			  cartWorkbook=new HSSFWorkbook(inputStream);
		  }
	 
		  Sheet cartSheet=cartWorkbook.getSheet(sheetName);
		  int rowcount=cartSheet.getLastRowNum()-cartSheet.getFirstRowNum();
		  for( int i=0; i< rowcount+1;i++)
		  {
			  Row row= cartSheet.getRow(i);
			  for (int j=0; j< row.getLastCellNum();j++)
			  {
				  System.out.print(row.getCell(j).getStringCellValue()+"|| ");
			  }
			  System.out.println();
		  }
	 
}
	 public void takeSnapShot(String fileWithPath) throws Exception{

	        //Convert web driver object to TakeScreenshot

	        TakesScreenshot scrShot =((TakesScreenshot)driver);

	        //Call getScreenshotAs method to create image file

	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	            //Move image file to new destination

	                File DestFile=new File(fileWithPath);

	                //Copy file at destination

	                FileUtils.copyFile(SrcFile, DestFile);

	    }
	 
	 
	 
}

