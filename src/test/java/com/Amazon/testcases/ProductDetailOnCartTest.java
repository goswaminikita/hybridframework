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

public class ProductDetailOnCartTest extends TestBaseClass{
	
	public AmazonSignInPage SignIn1st;
	public AmazonSignInPage2 Signin2nd;
	public HomePageOfAmazon homePage;
	public TodaysDealLinkPage TodayDealPage;
	public ProductAddToCartPage productPage;
	public AmazonCommonUtility common;
	public CartPage cartPage;
	public ProductDetailPage productDetail;
	public Keyword_Base keyword;
	static Logger log=Logger.getLogger(ProductDetailOnCartTest.class);
	
	public ProductDetailOnCartTest()
	{
		super();
		
	}
	/**
	 * 
	 */
	@BeforeMethod
	public void setUp()
	{
		log.info("*******************open Browser*******************************");
		initialization();
		log.info("open url of page");
		openSignInPage();
		log.info("open signin page ");
		
		
		TodayDealPage=new TodaysDealLinkPage();
		productPage=new ProductAddToCartPage();
		SignIn1st=new AmazonSignInPage();
		SignIn1st.signIn(PomConstantClass.prop.getProperty("username"));
		Signin2nd=new AmazonSignInPage2();
	homePage=Signin2nd.enterPasswordText(PomConstantClass.prop.getProperty("password"));
	TodayDealPage=homePage.clickOnTodaysDealLink();
	productPage=TodayDealPage.EnterTextOnSearchBox("macbook");

     productPage.clickOnSearchedProductLink();
     common=new AmazonCommonUtility();
     log.info("create instance of commonutility class");
     common.switchOnWindow();
    cartPage= productPage.clickOnAddToCartBtn();
    productDetail = cartPage.clickOnCartBtn();
     
	}
	
	
	@Test(priority=1)
	public void deleteProductFrmCartTest()
	{
		log.info("delete product from cart");
		productDetail.deleteProductFrmCart();
	}


	@AfterMethod
	public void tearDown()
	{
		keyword.takeScreenShotInterface("Product Page");
		log.info("*******************************************Close Browser****************************");
		PomConstantClass.driver.quit();
	}
	
}
