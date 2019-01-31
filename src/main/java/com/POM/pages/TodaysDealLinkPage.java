package com.POM.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Keyword_Base.PomConstantClass;
import com.Keyword_Base.TestBaseClass;

public class TodaysDealLinkPage extends TestBaseClass {

	@FindBy(xpath="//h1[@style='margin:0px;']/div[contains(text(),'Deal')]")
	static
	WebElement HeaderText;
	
	@FindBy(xpath="//a[contains(text(),' View Deal')]")
	WebElement viewDealBtn;
	/*
	@FindBy(xpath="//a[@aria-label='Upcoming']/span[contains(text(),'Upcoming')]")
	WebElement clickOnUpcomingLink;
	*/
	
	@FindBy(xpath="//div[@id='nav-subnav']/a[2]/span[contains(text(),'All Deals')]")
	WebElement clickOnAllDealsLink;
	
	@FindBy(xpath="//span[contains(text(),' Watched Deals')]")
	WebElement clickOnWatchedDealsLink;
	
	@FindBy(xpath="//div[@id='nav-subnav']/a[4]")
	WebElement Subscribe_SaveLink;
	
	@FindBy(xpath="//div[@class='a-row layer backGround']")
	WebElement anyItemInUpcomingDetails;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	static
	WebElement enterTextInSearchTextBox;

	@FindBy(xpath="//input[@type='submit']")
	static
	WebElement clickOnSearchBtn;

	
	//@FindBy(xpath="//img[@alt='Devinez Clove Essential Oil, 100% Pure, Natural & Undiluted']")
	//TodaysDealLinkPageWebElement product;
	
	
	@FindBy(xpath="//span[@class='a-size-base a-color-secondary stateTab ']")
	WebElement allDealsOfTheDayLink;
	
		/**
		 * constructor that should use for Initialization of page objects.
		 */
	public TodaysDealLinkPage(){
		PageFactory.initElements(PomConstantClass.driver, this);
	}
	
	/**
	 * This method gives all detail of product detail of all product.
	 * @return String
	 */
	
	public static  String verifyTitleOfTodaysDealPage()
	{
		String title=PomConstantClass.driver.getTitle();
		return title;

	}
	
	/**
	 * Verify page text
	 * @return Boolean
	 */
	public static boolean verifyHeaderTextOfPage()
	{
		return HeaderText.isDisplayed();
	}
	/*
	public static void mouseHoverOnCategory()
	{
		WebElement category=PomConstantClass.driver.findElement(By.xpath("//a[@class='a-popover-trigger a-declarative']"));
		Actions action=new Actions(PomConstantClass.driver);
		action.moveToElement(category).build().perform();
		
	}
	*/
	
	/**
	 * This method is use to see all available product or upcoming products 
	 * @param String,String
	 * @return Void
	 */
	 public static void clickOnAnyALinks(String arialLabel,String Text)
	 
	 {
	PomConstantClass.driver.findElement(By.xpath("//a[@aria-label='"+arialLabel+"']/span[contains(text(),'"+Text+"')]")).click();

	 }
	 
	 /**
	  * This method is use to purchase any product to search on search box
	  * @param String
	  * @return ProductAddToCartPage
	  */
	 
	public static  ProductAddToCartPage EnterTextOnSearchBox(String productName)
	{
		enterTextInSearchTextBox.sendKeys(productName);
		clickOnSearchBtn.click();
		return new ProductAddToCartPage();
		
	
		
	}
	
	
}
