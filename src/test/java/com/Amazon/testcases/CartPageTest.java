package com.Amazon.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Keyword_Base.Keyword_Base;
import com.Keyword_Base.PomConstantClass;
import com.Keyword_Base.TestBaseClass;
import com.POM.pages.AmazonSignInPage;
import com.POM.pages.AmazonSignInPage2;
import com.POM.pages.CartPage;
import com.POM.pages.HomePageOfAmazon;
import com.POM.pages.ProductAddToCartPage;
import com.POM.pages.ProductDetailPage;
import com.POM.pages.ShoppingCartPage;
import com.POM.pages.TodaysDealLinkPage;
import com.commonUtilities.AmazonCommonUtility;

public class CartPageTest extends TestBaseClass{
	public AmazonSignInPage SignIn1st;
	public AmazonSignInPage2 Signin2nd;
	public HomePageOfAmazon homePage;
	public TodaysDealLinkPage TodayDealPage;
	public ProductAddToCartPage productPage;
	public AmazonCommonUtility common;
	public CartPage cartPage;
	static Logger log=Logger.getLogger(CartPageTest.class);
	public ProductDetailPage productDetail;
	public Keyword_Base keyword;
	
	public CartPageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		log.info("***********************************open Browser***********************************");
		initialization();
		log.info("Open url");
		openSignInPage();
		
		
		TodayDealPage=new TodaysDealLinkPage();
		productPage=new ProductAddToCartPage();
		SignIn1st=new AmazonSignInPage();
		SignIn1st.signIn(PomConstantClass.prop.getProperty("username"));
		log.info("enter username of customer to sign in ");
		Signin2nd=new AmazonSignInPage2();
		log.info("initializing object of signin page 2");
	homePage=Signin2nd.enterPasswordText(PomConstantClass.prop.getProperty("password"));
	log.info("enter password of customer to Signin");
	TodayDealPage=homePage.clickOnTodaysDealLink();
	log.info("create instance of clickOnTodaysDealLink class");
	productPage=TodayDealPage.EnterTextOnSearchBox("macbook");
	log.info("enter product name in seach box");

     productPage.clickOnSearchedProductLink();
     common=new AmazonCommonUtility();
     common.switchOnWindow();
     productPage.clickOnAddToCartBtn();
	

	}
	
	
	@Test(priority=1)
	public void verifyTitleOfAddToCartPageTest()
	{
		log.info("verify title of AddTocart page");
		cartPage.verifyTitleOfAddToCartPage();
	}
	
	@Test(priority=2)
	
	public void verifyLabelAddedToCartTest()
	{
		log.info("verify label of page");
		cartPage.verifyLabelAddedToCart();
	}
	
	
	@Test(priority=3)
	public ProductDetailPage clickOnCartBtnTest()
	{
		log.info("click on add To Cart Button");
		return cartPage.clickOnCartBtn();
		
	
	}
	
		
	@Test(priority=4)
	public void checkProceedToCheckOutBtnPresentOrNotTest()
	{
		cartPage.checkProceedToCheckOutBtnPresentOrNot();
		log.info("verify Proccedto check button is present or not");
	}
	

	
	@AfterMethod
	public void tearDown()
	{
		keyword.takeScreenShotInterface("CartPage");
		log.info("*******************************************Close Browser****************************");
		PomConstantClass.driver.quit();
	}

	
}
