package com.Amazon.testcases;

import java.util.concurrent.TimeUnit;


import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Keyword_Base.PomConstantClass;
import com.Keyword_Base.TestBaseClass;
import com.POM.pages.AmazonSignInPage;
import com.POM.pages.AmazonSignInPage2;
import com.POM.pages.CartPage;
import com.POM.pages.HomePageOfAmazon;
import com.POM.pages.ProductAddToCartPage;
import com.POM.pages.TodaysDealLinkPage;
import com.commonUtilities.AmazonCommonUtility;

public class AmazonProductAddToCartTest extends TestBaseClass {
	public AmazonSignInPage SignIn1st;
	public AmazonSignInPage2 Signin2nd;
	public HomePageOfAmazon homePage;
	public TodaysDealLinkPage TodayDealPage;
	public ProductAddToCartPage productPage;
	public AmazonCommonUtility common;
	public CartPage cartPage;
	
	static Logger log=Logger.getLogger(AmazonProductAddToCartTest.class);
	public AmazonProductAddToCartTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		log.info("*****************Open Browser**********************");
		initialization();
		log.info("*Open Url and all initial methods");
		openSignInPage();
		
		//common=new AmazonCommonUtility();
		
		TodayDealPage=new TodaysDealLinkPage();
		productPage=new ProductAddToCartPage();
		SignIn1st=new AmazonSignInPage();
		SignIn1st.signIn(PomConstantClass.prop.getProperty("username"));
		Signin2nd=new AmazonSignInPage2();
	homePage=Signin2nd.enterPasswordText(PomConstantClass.prop.getProperty("password"));
	TodayDealPage=homePage.clickOnTodaysDealLink();
	productPage=TodayDealPage.EnterTextOnSearchBox("macbook");
	

	}
	
	@Test(priority=1)
	public void verifyTitleOfSearchProductTest()
	{
		log.info("verify title of product page");
		productPage.verifyTitleOfSearchedProductPage();
	}
	
	@Test(priority=3)
	public void clickOnSearchProductLink()
	{
		log.info("start click on search product link method");
		cartPage=productPage.clickOnSearchedProductLink();
		log.info("successfully click on search product link");
	
	}
	
	
	
	
	@Test(priority=3)
	public void clickOnAddToCartBtnTest()
	{
		log.info("click on add  to cart btn method");
		//PomConstantClass.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		common.switchOnWindow();
		log.info("switch on window");
		cartPage=productPage.clickOnAddToCartBtn();
		log.info("successfully click on addToCart Button");
	}
	
	/*
	@Test(priority=2)
	public void verifyLabelOfSearchProductTest()
	{
		productPage.verifyproductNameLabel();
		log.info("verify product name label on page of product ");
	}
	
	*/

@AfterMethod
public void tearDown()
{
	log.info("***************browser Close********************************");
	PomConstantClass.driver.quit();
}

}

