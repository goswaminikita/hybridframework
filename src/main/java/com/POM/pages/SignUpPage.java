package com.POM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Keyword_Base.Keyword_Base;
import com.Keyword_Base.TestBaseClass;

public class SignUpPage extends TestBaseClass {
	
	
	@FindBy(xpath="//input[@name='customerName']")
	WebElement customerName;

	@FindBy(xpath="//input[@id='ap_phone_number']")
	WebElement phoneNumber;

	@FindBy(name="secondaryLoginClaim")
	WebElement emailID;

	@FindBy(xpath="//input[@name='password']")
	WebElement pass;

	@FindBy(xpath="//input[@id='continue']")
	WebElement continueBtn;
	
	public void createAccountOnAmazon(String cname ,String phonenum,String email,String pas)
	{
		Keyword_Base k1=new Keyword_Base();
		
		customerName.sendKeys(cname);
		phoneNumber.sendKeys(phonenum);
		emailID.sendKeys(email);
		pass.sendKeys(pas);
		continueBtn.click();
		
	}

}
