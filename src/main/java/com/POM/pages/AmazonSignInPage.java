package com.POM.pages;

import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Keyword_Base.PomConstantClass;
import com.Keyword_Base.TestBaseClass;

public class AmazonSignInPage extends TestBaseClass {
	@FindBy(xpath="//h1[contains(text(),'Login')]")
	WebElement headerText;
	
	@FindBy(xpath="//a[@class='a-link-nav-icon']")
	static
	WebElement amazonLogo;
	
	@FindBy(xpath="//input[@name='email']")
	static
	WebElement emailText;
	
	@FindBy(xpath="//input[@id='continue']")
	static
	WebElement clickOnContinue;
	
	@FindBy(xpath="//span[contains(text(),' Need help?')]")
	WebElement needHelpLink;
	
	@FindBy(xpath="//a[@id='createAccountSubmit']")
	WebElement createAmazonAccountBtn;
	
	
	
	/**
	 * A constructor that should use for Initialization of page objects
	 * @param Take no parameter.
	 */
	
	
	
	public AmazonSignInPage()
	{
		PageFactory.initElements(PomConstantClass.driver, this);
	}
	
	
	/**
	 * This method is use to validate title of sign in first page.
	 * This method is return string
	 * @param Take No Parameter
	 * @return String
	 */
	
	

	public static String validateAmazonSignInPageTitle()
	{
		return  PomConstantClass.driver.getTitle();
	}
	
	
	/**
	 * This method validate to Logo of amazon page.
	 * @return Boolean
	 */
	
	public static boolean validateAmazonLogo()
	{
		return amazonLogo.isDisplayed();
	}
	
	
	/**
	 * This method is use to verify header text of page  for we reach to
	 *  correct page or not.
	 * this method returns boolean as true or false.
	 * @param no parameter
	 * @return Boolean
	 */
	public boolean validateHeaderOfSigninPage()
	{
		return headerText.isDisplayed();
	}
	
	
	/**
	 * This method is second page of SignIn after pass string as parameter
	 * This method returns string ,This method is use for successful login 
	 * @param String
	 * @return AmazonSignInPage2
	 */
	public static  AmazonSignInPage2  signIn(String un)
	{
		emailText.sendKeys(un);
		clickOnContinue.click();
		return new AmazonSignInPage2 ();
	}
	
	

}
