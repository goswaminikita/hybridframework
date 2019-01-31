package com.POM.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import com.Keyword_Base.TestBaseClass;

public class AllDealsPage extends TestBaseClass {
	
	

	@FindBy(xpath="//div[@class='a-row dealTile']")
	WebElement todaysUpcomingDeals;
	
	@FindBy(xpath="//span[@class='a-button-text a-declarative']")
	WebElement dealsDetailOfDealspage;

}
