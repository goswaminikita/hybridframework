package com.Amazon.testcases;

import org.apache.log4j.Logger;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Keyword_Base.PomConstantClass;
import com.Keyword_Base.TestBaseClass;
import com.POM.pages.AmazonSignInPage;
import com.POM.pages.AmazonSignInPage2;
import com.POM.pages.HomePageOfAmazon;
import com.POM.pages.TodaysDealLinkPage;

public class AmazonHomePageTest extends TestBaseClass{
	public AmazonSignInPage SignIn1st;
	public AmazonSignInPage2 Signin2nd;
	public HomePageOfAmazon homePage;
	public TodaysDealLinkPage TodayDealPage;
	

	static Logger log=Logger.getLogger(AmazonHomePageTest.class);

	public AmazonHomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		log.info("********************************SetUp method start****************************");
		initialization();
		log.info("Initialization method start");
		openSignInPage();
	
		SignIn1st=new AmazonSignInPage();
		SignIn1st.signIn(PomConstantClass.prop.getProperty("username"));
		Signin2nd=new AmazonSignInPage2();
	    homePage=Signin2nd.enterPasswordText(PomConstantClass.prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyhomePageTitleTest()
	{
		log.info("*************VerifyHomePageTitle***********");
		String homePagTitle=HomePageOfAmazon.verifyHomePageTitle();
		log.info("Title of Home Page "+homePagTitle);
	Assert.assertEquals(homePagTitle, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in","Home Page Title not matched");
	}
	@Test(priority=2)
	public void verifyCustomerNameTest()
	{log.info("starting verify correct customer method-----------");
		Assert.assertTrue(homePage.verifyCorrectCustomerName());
		log.info("verifyed customer name ");
		
	}
	
@Test(priority=3)
public void verifyTodaysDealLinkTest()
{
	TodayDealPage=homePage.clickOnTodaysDealLink();
	log.info("click on todays deal link on amazon  home page");
	
}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		PomConstantClass.driver.quit();
		log.info("*************************closing browser*****************");
	}
	
	
}
