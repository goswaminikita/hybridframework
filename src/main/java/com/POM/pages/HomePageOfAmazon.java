package com.POM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Keyword_Base.PomConstantClass;
import com.Keyword_Base.TestBaseClass;

public class HomePageOfAmazon extends TestBaseClass{
@FindBy(xpath="//span[contains(text(),'Hello, nikitagoswami')]")
static
WebElement CustomerNameLabel;

@FindBy(id="nav-your-amazon-text")
static
WebElement clickOnAmazon_InLink;


@FindBy(xpath="//a[contains(text(),' Deals')]")
static
WebElement clickOnTodaysDealLink;


@FindBy(xpath="//a[@class='nav-a nav-a-2 nav-active']")
static
WebElement clickOnYourListsLink;


@FindBy(xpath="//span[@class='nav-cart-icon nav-sprite']")
WebElement clickOnCartLink;


/**
 * constructor of current page object 
 * 
 */

public HomePageOfAmazon()
{
	PageFactory.initElements(PomConstantClass.driver, this);
}

/**
 * This method verify we reach on HomePage or not correctly
 * This method returns String This method gives us title of current page
 * @return String
 */

public static  String verifyHomePageTitle()
{
	return PomConstantClass.driver.getTitle();
}

/**
 * This method is verify correct customer is login or not it verify name of customer 
 * @return void
 * @param no parameter
 */

public static boolean verifyCorrectCustomerName()
{
	return CustomerNameLabel.isDisplayed();
}

/**
 *This method is  use to click on Amazon_in Link
 * @return Amazon_inLinksMoreToExplorePage
 */

public static Amazon_inLinksMoreToExplorePage clickOnAmazon_InLink()
{
	clickOnAmazon_InLink.click();
	return new Amazon_inLinksMoreToExplorePage();
}

/**
 * This method is gives us all product detail which are present today
 * @return TodaysDealLinkPage
 */
public static TodaysDealLinkPage clickOnTodaysDealLink()
{
	clickOnTodaysDealLink.click();
	return new TodaysDealLinkPage();
	
}

/**
 * This method gives us our shopping List.give list of all items of our shopping
 * @return ListPage
 */
public static ListPage clickOnYourListLink()
{
	clickOnYourListsLink.click();
	return new ListPage();
}

/**
 * This method gives us shopping cart detail,if we add product to cart then it gives in it
 * @return ProductAddToCartPage
 */
public ProductAddToCartPage clickOnCartLink()
{
	clickOnCartLink.click();
	return new ProductAddToCartPage();
	
}

	
	
}
