package com.POM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Keyword_Base.Keyword_Base;
import com.Keyword_Base.PomConstantClass;
import com.Keyword_Base.TestBaseClass;

public class ProductDetailPage extends TestBaseClass {

	@FindBy(xpath="//span[@class='a-button a-button-dropdown a-button-small a-button-span8 quantity']")
	static
	WebElement clickOnQuantity;

	@FindBy(xpath="//input[@value='Save for later']")
	static
	WebElement clickOnSavForLaterLink;

	@FindBy(xpath="//input[@value='Delete']")
	static
	WebElement ProductdeleteFromCart;

	
	public ProductDetailPage()
	{
		PageFactory.initElements(PomConstantClass.driver, this);
	}
	
	public static void deleteProductFrmCart()
	{
	
	ProductdeleteFromCart.click();
	}
	
	
	public static void clickOnSaveForLaterbtn()
	{
		clickOnSavForLaterLink.click();
	}
	
	
	
	/*
	public static void quantitySelect()
	{
		clickOnQuantity.click();
		Keyword_Base.selectBYIndex("xpath", "//i[@class='a-icon a-icon-dropdown']", 1);
	
	
	}
	*/

}
