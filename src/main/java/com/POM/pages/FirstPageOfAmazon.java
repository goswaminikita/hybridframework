package com.POM.pages;

import org.openqa.selenium.WebElement;


import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Keyword_Base.Keyword_Base;
import com.Keyword_Base.PomConstantClass;
import com.Keyword_Base.TestBaseClass;

public class FirstPageOfAmazon extends TestBaseClass{
	
	@FindBy(xpath="//a[contains(text(),'Your Amazon.in')]")
	static
	WebElement clickOnAmazonInlink;
	
	
	@FindBy(xpath="//a[@class='nav-logo-link']")
	WebElement amazonLogo;
	
	@FindBy(xpath="//span[contains(text(),'Hello, Sign in')]")
	WebElement mouseHoveronSignIn;
	
	/**
	 * constructor of the page is use for page object
	 * 
	 */
	
	public FirstPageOfAmazon()
	{
		PageFactory.initElements(PomConstantClass.driver,this);
	}
	
	
	
/**
 * After login to amazon we check that  reach on correct page or not for it this.
 * @param no parameter
 * @return String
 */
	
	
public String validateTitleOfPage()
{
	
return PomConstantClass.driver.getTitle();
}

/**
 * This method is use to click on amazon link for to see different more pages 
 * for to explore more product. 
 */


public static void clickOnAmazonInLink()
{
	clickOnAmazonInlink.click();
}


/**
 * This method is validate logo of page
 */


public  boolean validateLogoOfPage()
{
	return amazonLogo.isDisplayed();
}

/**
 * This method is use to click on Sign in page 
 */

public void clickOnSignInButton()
{
	    	TestBaseClass.openSignInPage();
	    }
}

