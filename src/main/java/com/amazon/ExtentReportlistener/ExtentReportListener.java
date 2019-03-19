/*
package com.amazon.ExtentReportlistener;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.IReporter;
import com.relevantcodes.extentreports.model.Test;

public class ExtentReportListener implements IReporter {
	public ExtentReports extent;
	public void generateReport(List <XmlSuite> xmlSuites,List<ISuite> suites,String outputDirectory)
	{
		extent=new ExtentReports(outputDirectory+File.separator +"Extent.html",true);
		for(ISuite suite:suites)
		{
			Map<String, ISuiteResult>result=suite.getResults();
			
			for(ISuiteResult r:result.values())
			{
				ITestContext context=r.getTestContext();
				builtTestNodes(context
				
				
			}
		}
	}
	@Override
	public void addTest(Test arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setTestRunnerLogs() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void start(Report arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

}
*/