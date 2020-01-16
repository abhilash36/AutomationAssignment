package org.testyantra.com.AmazonAndFlipkart.genericlibrary;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import org.testyantra.com.AmazonAndFlipkart.genericlibrary.BaseClass;

/**
 * 
 * @author Abhilash
 *
 */
public class ListenerImpClass implements ITestListener
{
	public void onTestStart(ITestResult result) 
	{
		// TODO Auto-generated method stub
	}

	public void onTestSuccess(ITestResult result) 
	{
		// TODO Auto-generated method stub
	}

	/**
	 * Capture the failed test case name and its screen shot
	 * @param result
	 *
	 */
	public void onTestFailure(ITestResult result)
	{
		String failedTestName = result.getMethod().getMethodName();
		System.out.println("============Fail============"+failedTestName);
		EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.driver);
		File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
		File dstFile = new File("./ScreenShot/"+failedTestName+".png");
		try 
		{
			FileUtils.copyFile(srcFile, dstFile);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

			public void onStart(ITestContext context) 
			{
				// TODO Auto-generated method stub
			}

			public void onFinish(ITestContext context) 
			{
				// TODO Auto-generated method stub		
			}	
	}


