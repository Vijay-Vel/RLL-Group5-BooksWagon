package com.BooksWagon.Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class MyListener implements ITestListener{
	
	public static ExtentReports extentreports;
	public static ExtentTest extentTest;
	public ScreenshotUtility s;
	public void onTestFailure(ITestResult result) {
	    try {
	    	//extentTest.addScreenCaptureFromPath(ScreenshotUtility.takeScreenshot());
	    	System.out.println("Taking screenshot");
	    	//extentTest.fail(result.getThrowable());
	    	//extentTest.log(Status.FAIL, "Test case Failed");
	    	String screenshotPath = ScreenshotUtility.takeScreenshot();
	    	extentTest.fail("Test case is Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath, "Failed Test Screenshot").build());
	    	
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	  }
	public void onStart(ITestContext context) {
		 s=new ScreenshotUtility();
		 
		 System.out.println("message");
		 ExtentSparkReporter sparkreporter = new ExtentSparkReporter("Test-Report.html");
		 extentreports = new ExtentReports();
			extentreports.attachReporter(sparkreporter);			
			extentTest=	extentreports.createTest(context.getName());
			
				
		  }
	public  void onTestSuccess(ITestResult result) {
		  extentTest.log(Status.PASS, " Test Scenario is successfully pass");
	  }
	  
	public void onFinish(ITestContext context) {
		extentreports.flush();
		try {
			Desktop.getDesktop().browse(new File("Test-Report.html").toURI());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
