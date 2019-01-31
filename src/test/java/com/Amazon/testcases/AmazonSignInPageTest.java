package com.Amazon.testcases;

import org.apache.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Keyword_Base.Keyword_Base;
import com.Keyword_Base.PomConstantClass;
import com.Keyword_Base.TestBaseClass;
import com.POM.pages.AmazonSignInPage;
import com.POM.pages.AmazonSignInPage2;
import com.POM.pages.HomePageOfAmazon;

public class AmazonSignInPageTest extends TestBaseClass {
	public AmazonSignInPage SignIn1st;
	public AmazonSignInPage2 Signin2nd;
	public HomePageOfAmazon homePage;
	
	static Logger log=Logger.getLogger(AmazonSignInPageTest.class);
	public AmazonSignInPageTest() {
		super();
	}
	
	@BeforeMethod
public void setUp()
{
		log.info("***************************Start Browser**************************************************");
	initialization();
	log.info("Open sign in page first");
	openSignInPage();
	SignIn1st=new AmazonSignInPage();
	
}
	
	@Test(priority=1)
	public void signInPageTitleTest()
	{
		log.info("verify sign in page title----------------------");
	String title=	AmazonSignInPage.validateAmazonSignInPageTitle();
	log.info("title of sign in page is*************"+title);
	Assert.assertEquals(title, "Amazon Sign In");
	
	Keyword_Base screenshot=new Keyword_Base();
	screenshot.takeScreenShotInterface("amazon !st SignIn Page");
	}
	@Test(priority=2)
	public void AmazonLogoImageTest()
	{
		log.info("verify logo of Amazon on page");
		boolean flag=AmazonSignInPage.validateAmazonLogo();
	Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void SignInTest()
	{
		log.info("Sign in test method is start");
		Signin2nd=AmazonSignInPage.signIn(PomConstantClass.prop.getProperty("username"));
		log.info("enter username of customer");
		homePage=Signin2nd.enterPasswordText(PomConstantClass.prop.getProperty("password"));
		log.info("enter password of customer to signin customer correctly");
		
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		log.info("*************************************************Browser Close*********************************************************");
		PomConstantClass.driver.quit();
	}
	
}
