package com.commonUtilities;

import java.util.Iterator;
import java.util.Set;

import com.Keyword_Base.PomConstantClass;
import com.Keyword_Base.TestBaseClass;
import com.POM.pages.ProductAddToCartPage;

public class AmazonCommonUtility extends TestBaseClass{
	

public void switchToFrame()
{
	PomConstantClass.driver.switchTo().frame("DAsis");
	
}

public static void switchOnWindow()
{
	String parentwindowHandle=PomConstantClass.driver.getWindowHandle();
	ProductAddToCartPage.clickOnSearchedProductLink();
	//ProductAddToCartPage.clickOnSearchedProductLink("Apple MacBook Air Core i5 13.3-inch Laptop (8GB/128GB/MacOS Sierra/Silver/1.35kg), MQD32HN/A");
	Set<String> allWindows=PomConstantClass.driver.getWindowHandles();
	Iterator itr=allWindows.iterator();
	for(String child:allWindows)
	{
		if(!parentwindowHandle.equals(child))
				{
			PomConstantClass.driver.switchTo().window(child);

				}
	}	
}
}