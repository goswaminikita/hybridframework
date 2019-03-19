package com.Keyword_Base;

import java.io.File;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Keyword_Base {

	 
	    /**
	     * This method is used to open browser
	     *
	     * @parameter browserName
	     */
	    public static void openBrowser(String browserName) {
	        switch (browserName) {
	        case "Chrome":
	            WebDriverManager.chromedriver().setup();
	        	PomConstantClass.driver = new ChromeDriver();
	      
	            break;
	        case "Firefox":
	            WebDriverManager.firefoxdriver().setup();
	        	PomConstantClass.driver = new FirefoxDriver();
	            break;
	        case "IE":
	            WebDriverManager.iedriver().setup();
	        	PomConstantClass.driver = new InternetExplorerDriver();
	            break;
	        case "Opera":
	            WebDriverManager.operadriver().setup();
	        	PomConstantClass.driver = new OperaDriver();
	            break;
	        default:
	            System.out.println("Invalid browser name");
	            
	            break;
	        }
	    }
	    
	    /**
	     * This method opens the specified url
	     *
	     * @parameter is url in form of @String
	     */
	    public static void openUrl(String url) {
	    	PomConstantClass.driver.get(url);
	  
	    }
	    
	    public static WebElement getWebElement(String locatorType, String locatorValue) {
	        switch (locatorType) {
	        case "xpath":
	        	PomConstantClass.element = PomConstantClass.driver.findElement(By.xpath(locatorValue));
	            break;
	        case "id":
	        	PomConstantClass.element = PomConstantClass.driver.findElement(By.id(locatorValue));
	            break;
	        case "name":
	        	PomConstantClass.element = PomConstantClass.driver.findElement(By.name(locatorValue));
	            break;
	        case "linkText":
	        	PomConstantClass.element = PomConstantClass.driver.findElement(By.linkText(locatorValue));
	            break;
	        case "partialLinkText":
	        	PomConstantClass.element = PomConstantClass.driver.findElement(By.partialLinkText(locatorValue));
	            break;
	        case "cssSelector":
	        	PomConstantClass.element = PomConstantClass.driver.findElement(By.cssSelector(locatorValue));
	            break;
	        case "className":
	        	PomConstantClass.element = PomConstantClass.driver.findElement(By.className(locatorValue));
	            break;
	        default:
	            System.out.println("Invalid Selector: "+locatorType);
	            break;
	        }
	        return 	PomConstantClass.element;
	    }
	    
	    /**
	     *This method is enter text
	     *@param String,String,String
	     * 
	     */
	    
	    public static void enterText(String locatorType, String locatorValue, String textToEnter) {
	        getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	      
	    }
	    /**
	     * This method is click on Webelement
	     * @param String String
	     */
	    public static void click(String locatorType, String locatorValue) {
	        getWebElement(locatorType, locatorValue).click();
	        
	   
	    }
	    /**
	     * This method is maximize window
	     */
	    public static void maximizeWindow()
	    {
	    	PomConstantClass.driver.manage().window().maximize();
	    }
	    
	    /**
	     * This method is minimize window
	     */
	    
	    public static void minimizeWindow()
	    {
	    	Dimension d=new Dimension(400,400);
	    	
	    	PomConstantClass.driver.manage().window().setSize((Dimension) (d));
	    }
	    
	    /**
	     * This methodis close browser
	     */
	    public static void close()
	    {
	    	PomConstantClass.driver.close();
	    }
	    
	    /**
	     * This method is mouse hover on perticular webelement
	     * @param String String
	     */
	    public static void mouseHover(String locatorType,String locatorValue )
	    {
	    	Actions action=new Actions(	PomConstantClass.driver);
	    	PomConstantClass.element=getWebElement(locatorType, locatorValue);
	    	action.moveToElement(PomConstantClass.element).build().perform();
	    }
	   
	    
	    /**
	     * This method is use in drop down for select by index
	     * @param String String Integer
	     */
	    public static void selectBYIndex(String locatorType,String locatorValue,int byindex )
	    {
	    	PomConstantClass.element=getWebElement(locatorType, locatorValue);
	    	PomConstantClass.select=new Select(	PomConstantClass.element);
	    	PomConstantClass.select.selectByIndex(byindex);
	    }
	    
	    /**
	     * This method for DopDown for select by value
	     * @param String String String
	     */
	    public static void selectByValue(String locatorType,String locatorValue,String byValue)
	    {
	    	PomConstantClass.element=getWebElement(locatorType, locatorValue);
	    	PomConstantClass.select=new Select(	PomConstantClass.element);
	    	PomConstantClass.select.selectByValue(byValue);
	    }
	    
	    /**
	     * This method is use for drop Down select by visible text.
	     * @param String String String
	     * @return void
	     */
	    public static void selectBYVisibleText(String locatorType,String locatorValue,String visibleText)
	    {
	    	PomConstantClass.element=getWebElement(locatorType, locatorValue);
	    	PomConstantClass.select=new Select(	PomConstantClass.element);
	    	PomConstantClass.select.selectByVisibleText(visibleText);
	    }
	    
	    /**
	     * This method is use to take full page screenshot
	     * This method is use external library .
	     * @param String
	     */
	    public static void fullPageScreenShot(String title )
	    {
	    	AShot ashot=new AShot();
	    	Screenshot sc=ashot.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(	PomConstantClass.driver);
	    	try {
	    	String path = "C:\\eclipse\\KDD\\Screenshot\\facebook";
	    	path=path.concat(title);
	    	
				ImageIO.write(sc.getImage(), "jpg", new File(path));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	    	
	    	
	    }	
	    /**
	     * This method is use to take screen shot by using takeScreenShotInterface.
	     * @param String
	     * @return String 
	     */
	    public static String takeScreenShotInterface(String title)
	    {
	    	String dest = null;
	    	TakesScreenshot ts=(TakesScreenshot)PomConstantClass.driver;
	    	File source=ts.getScreenshotAs(OutputType.FILE);
	    	
	    	try {
	    		dest=System.getProperty("user.dir")+"//Test-ScreenShots//"+"title"+".png";
				File target=new File(dest);
	    		FileUtils.copyFile(source, target);
	    		
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	    	System.out.println("screenshot taken");	
	    	return dest;
	    }

public static void switchToAlertAccept()
{
	PomConstantClass.driver.switchTo().alert().accept();
}
/*
public static void alertDismiss()
{
	Constants.driver.switchTo().alert().dismiss();
}
*/
public static void radioButton(String locatorType,String locatorValue)
{
	PomConstantClass.element=getWebElement(locatorType, locatorValue);
	
}
/*
	
public static void PageLoadTimeOut()
	{
		PomConstantClas
	}
	*/
}


