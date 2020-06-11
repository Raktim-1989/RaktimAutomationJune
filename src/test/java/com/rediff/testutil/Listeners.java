package com.rediff.testutil;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.rediff.base.Base;


import resources.ExtentReporterNG;

public class Listeners extends Base implements ITestListener {
	ExtentTest test;

	ExtentReports extent = ExtentReporterNG.getReportObject();
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
       test = extent.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("Test Case passed " + result.getName());
		test.log(Status.PASS, "Test Case passed is " + result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
	    String testmethodname = result.getMethod().getMethodName();
		Listeners.getFailedScreenshot(testmethodname);
		
		try {
				test.addScreenCaptureFromPath(Listeners.getFailedScreenshot(testmethodname),testmethodname );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
			
	}
	
	public static String getFailedScreenshot(String methodname)
	{
		 TakesScreenshot ts = (TakesScreenshot)driver ;
		 File src = ts.getScreenshotAs(OutputType.FILE);
		 //mention rrlative path here
		 String destinationpath = "/Reports/" +methodname+ ".png";
		 try {
			FileUtils.copyFile(src, new File(destinationpath));
		} catch (IOException e) {
		e.printStackTrace();
		}
		 return destinationpath; 
		 
	}
	
	
}
