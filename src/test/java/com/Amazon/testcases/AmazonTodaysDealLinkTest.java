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
import com.POM.pages.ProductAddToCartPage;
import com.POM.pages.TodaysDealLinkPage;

public class AmazonTodaysDealLinkTest extends TestBaseClass{
	public AmazonSignInPage SignIn1st;
	public AmazonSignInPage2 Signin2nd;
	public HomePageOfAmazon homePage;
	public TodaysDealLinkPage TodayDealPage;
	public ProductAddToCartPage productPage;
	public Keyword_Base keyword;
	
	static Logger log=Logger.getLogger(AmazonTodaysDealLinkTest.class);

public AmazonTodaysDealLinkTest()
{
	super();
	
}
@BeforeMethod
public void setUp()
{
	log.info("*************************************open Browser*******************************");
	initialization();
	log.info("initialization method start------------------");
	openSignInPage();
	TodayDealPage=new TodaysDealLinkPage();
	SignIn1st=new AmazonSignInPage();
	SignIn1st.signIn(PomConstantClass.prop.getProperty("username"));
	log.info("create  instance of sign in page");
	Signin2nd=new AmazonSignInPage2();
homePage=Signin2nd.enterPasswordText(PomConstantClass.prop.getProperty("password"));
TodayDealPage=homePage.clickOnTodaysDealLink();

}
@Test(priority=1)
public  void verifyTitleOfTodaysDeadTest()
{log.info("verify title of Todays deal page of amazon");
	String title=TodayDealPage.verifyTitleOfTodaysDealPage();
	log.info("title of page is :"+title);
	
	
}
@Test(priority=2)
public void verifyHeaderTextOfTodaysDealTest()
{
	log.info("verify header text of tadays deal page");
	boolean headetText=TodayDealPage.verifyHeaderTextOfPage();
	log.info("header text is :"+headetText);
	//Assert.assertEquals(headetText, "Today's Deals","header Text is not matched");
}

@Test(priority=3)
public void clickOnAnyALinkTest()
{
	log.info("click on any link of todays dea page ");
	TodayDealPage.clickOnAnyALinks("Upcoming", "Upcoming");
	log.info("click on upcoming link on todays deal page");
}

@Test(priority=4)
public void enterTextONSearchBox()
{
	log.info("Enter text on search box");
	productPage=TodayDealPage.EnterTextOnSearchBox("macBook");
	log.info("enter macbook on search box ");
}


@AfterMethod
public void tearDown()
{
	keyword.takeScreenShotInterface("TodaysDealLink");
	log.info("************************Close Browser*******************************");
	PomConstantClass.driver.quit();
}


}
