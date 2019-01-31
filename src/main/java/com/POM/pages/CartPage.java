package com.POM.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

import com.Keyword_Base.Keyword_Base;
import com.Keyword_Base.PomConstantClass;
import com.Keyword_Base.TestBaseClass;

public class CartPage extends TestBaseClass {

	
	@FindBy(xpath="//h1[contains(text(),'Added to Cart')]")
	static
	WebElement checkLabelAddTocartVisibleOrNot;
	
	@FindBy(id="hlb-view-cart-announce")
	static
	WebElement cartBtn;
	
	@FindBy(xpath="//a[@aria-label='1 item in cart']")
	WebElement afterClickOnAddToCart;
	
@FindBy(xpath="//a[contains(text(),' Proceed')] ")
static

WebElement checkProceedToCheckOutBtn;



/**
 * constructor of this class which is initialize page object
 * This method is use pagefactory class.
 */
	public CartPage()
	{
		PageFactory.initElements(PomConstantClass.driver, this);
	}
	
	
	/**
	 * Method check we reach correctly on cart page or not ,
	 * method print title of cart page
	 * @param no parameter
	 * @return void
	 */
	public static void verifyTitleOfAddToCartPage()
	{
		String title=PomConstantClass.driver.getTitle();
		System.out.println("Title Of Cart page : "+title);
	}
	
	
	/**
	 * This method is use for to check label on page 
	 * @return Boolean
	 */
	public static void verifyLabelAddedToCart()
	{
		checkLabelAddTocartVisibleOrNot.isDisplayed();
	}
	
	/**
	 * Method is use to click on cart button which is present on cartpage
	 * This is use for to add product successfully in our cart .
	 * @return 
	 * 
	 */
	
	public static ProductDetailPage clickOnCartBtn()
	{
		cartBtn.click();
		return new ProductDetailPage();
	}
	
	
	
	
	/**
	 * This method is use to save product later if we don't want to save now,
	 * after click on it this product is goes inside save to latter
	 * after click on it we also later add this product again
	 */
	
	/**
	 * This method is use to proceed to take product
	 * This method is use to check this button is present on page or not 
	 */
	
	public static void checkProceedToCheckOutBtnPresentOrNot()
	{
		checkProceedToCheckOutBtn.isDisplayed();
	}
	
	
	

}
