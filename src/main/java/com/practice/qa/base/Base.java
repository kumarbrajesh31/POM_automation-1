package com.practice.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.practice.qa.util.Util;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public Base(){
		try{
			prop=new Properties();
			FileInputStream ip=new FileInputStream("src/main/java/com/practice/qa/config/config.properties");
		prop.load(ip);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
			catch(IOException e){
				e.printStackTrace();
			}
		}
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\software\\selenium_software\\Seleniumdrivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox")){
			System.setProperty("webdriver.geco.driver", "D:\\software\\selenium_software\\Seleniumdrivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("Url"));
		driver.manage().timeouts().pageLoadTimeout(Util.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Util.Implicit_Wait, TimeUnit.SECONDS);
	}

}
