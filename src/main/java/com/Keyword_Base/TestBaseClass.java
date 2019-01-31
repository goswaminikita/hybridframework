package com.Keyword_Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass {
	
	public TestBaseClass(){
		try{
			PomConstantClass.prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\eclipse\\FinalPOM_DDFramework\\src\\main\\java\\com\\amazon\\config\\config.properties");
			PomConstantClass.prop.load(ip);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		String browserName=PomConstantClass.prop.getProperty("browser");
		if(browserName.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			PomConstantClass.driver=new ChromeDriver();
		}else
			if(browserName.equals("FF"))
			{
				WebDriverManager.firefoxdriver().setup();
				PomConstantClass.driver=new FirefoxDriver();
				
			}
			else if(browserName.equals("IE"))
			{
				WebDriverManager.iedriver().setup();
				PomConstantClass.driver=new InternetExplorerDriver();
			}else if(browserName.equals("Opera"))
			{
				WebDriverManager.operadriver().setup();
				PomConstantClass.driver=new OperaDriver();
			}
		PomConstantClass.driver.manage().window().maximize();
		PomConstantClass.driver.manage().deleteAllCookies();
		PomConstantClass.driver.get(PomConstantClass.prop.getProperty("url"));
	}
	
	 public static  void openSignInPage(){
	WebElement signIn=PomConstantClass.driver.findElement(By.xpath("//span[contains(text(),'Hello, Sign in')]"));
	Actions action=new Actions(PomConstantClass.driver);
	action.moveToElement(signIn).build().perform();
PomConstantClass.driver.findElement(By.xpath("//span[@class='nav-action-inner']")).click();

	}
	 
	}


