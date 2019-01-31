package com.Amazon.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;



import com.Amazon.testcases.AmazonHomePageTest;
import com.Amazon.testcases.CartPageTest;
import com.Amazon.testcases.ProductDetailOnCartTest;
import com.Keyword_Base.Keyword_Base;
import com.Keyword_Base.PomConstantClass;
import com.Keyword_Base.TestBaseClass;
import com.POM.pages.CartPage;

public class ExecutionClassOfAllTestClasses extends TestBaseClass {
	static Logger log=Logger.getLogger(ExecutionClassOfAllTestClasses.class);
	@Test
	public void Testcases()
	{
		log.info("*************************************************************************************");
		ProductDetailOnCartTest product=new ProductDetailOnCartTest();
			log.info("create object of ProductDetailOnCartTest class");
		product.setUp();
	log.info("CallingSetUpMethod");
		product.deleteProductFrmCartTest();
		
		Keyword_Base screenshot=new Keyword_Base();
		screenshot.fullPageScreenShot("amazon");
}

	}
	

