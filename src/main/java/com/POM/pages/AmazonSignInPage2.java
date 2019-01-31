package com.POM.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Keyword_Base.PomConstantClass;
import com.Keyword_Base.TestBaseClass;

public class AmazonSignInPage2 extends TestBaseClass{

	@FindBy(xpath="//input[@type='password']")
	WebElement passText;
	
	
	@FindBy(id="ap_change_login_claim")
	WebElement changeNoLink;
	
	@FindBy(xpath="//a[contains(text(),' Forgot Password')]")
	WebElement forgotPassLink;
	
	@FindBy(id="signInSubmit")
	WebElement loginBtn;
	
	@FindBy(xpath="//span[contains(text(),'Login using an OTP')]")
	WebElement loginUsingOTP;

	/**
	 * constructor is use to all page factory of  WebElements which we define in class
	 * this method call initElements method of page factory class.
	 *   
	 */
public  AmazonSignInPage2 ()
{
	PageFactory.initElements(PomConstantClass.driver, this);
}


/**
 * This method is verify that we open correct page of SignIn or not 
 * Also validate Logo of amazon on this page
 * 
 */


public void validatePage()
{
	AmazonSignInPage.validateAmazonSignInPageTitle();
	AmazonSignInPage.validateAmazonLogo();
}

/**
 * For login complete use of this method to complite process of login successfully
 * @return HomePageOfAmazon
 * @param String
 */
public HomePageOfAmazon enterPasswordText(String pass)
{
	passText.sendKeys(pass);
	loginBtn.click();
	return new HomePageOfAmazon();
	
}


}