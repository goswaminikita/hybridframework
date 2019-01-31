package com.POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Keyword_Base.PomConstantClass;
import com.Keyword_Base.TestBaseClass;

public class ProductAddToCartPage extends TestBaseClass{
/*
@FindBy(xpath="//*[@id='result_0']")
static
WebElement searchProductLink;
*/

@FindBy(xpath="//a[@id='bcKwText']/span[contains(text(),'macbook')]")
static
WebElement macbookLabel;

@FindBy(id="add-to-cart-button")
static
WebElement clickOnAddToCartBtn;


/**
 * constructor that should use for Initialization of page objects.
 * 
 */

public ProductAddToCartPage()
{
	PageFactory.initElements(PomConstantClass.driver, this);
}

/**
 * This method is use to take product for add to cart we use this method
 * @return CartPage
 */

public static CartPage clickOnSearchedProductLink()
{
PomConstantClass.driver.findElement(By.xpath("//h2[@data-attribute='Apple MacBook Air Core i5 13.3-inch Laptop (8GB/128GB/MacOS Sierra/Silver/1.35kg), MQD32HN/A']")).click();
	return new CartPage();
	
	
}

/**
 * This method is verify we correctly reach on product page or not
 * In This method we use Assertion for to check title of page
 */

public static void verifyTitleOfSearchedProductPage()
{
	String title=PomConstantClass.driver.getTitle();
	Assert.assertEquals(title, "Amazon.in: macbook - Laptops: Computers & Accessories","Title Of Searched Product Is Not Matched");
}


/**
 * This method is use to verify we provided product name is correct or not.
 */


public static void verifyproductNameLabel()
{
	macbookLabel.isDisplayed();
}


/**
 * This method is use to add product in cart for purchase.
 * @return CartPage
 */
public static  CartPage clickOnAddToCartBtn()
{
	clickOnAddToCartBtn.click();
	return new  CartPage();
}
}



/*
public static CartPage clickOnSearchedProductLink(String productNme)
{
PomConstantClass.driver.findElement(By.xpath("//img[@alt='"+productNme+"']")).click();
	return new CartPage();
	
	
}
*/