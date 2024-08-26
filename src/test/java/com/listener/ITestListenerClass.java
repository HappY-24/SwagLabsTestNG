package com.listener;

import java.io.IOException;

import org.base.BaseClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;

public class ITestListenerClass extends BaseClass implements ITestListener{

	public String testName;
	public String methodName;
	@Override
	public void onTestStart(ITestResult result) {

		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		
		try {
			ExtentReport_Test.extenttest.pass(result.getMethod().getMethodName()+ ":" + "Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
		
		try {
			ExtentReport_Test.extenttest.fail(result.getMethod().getMethodName()+ ":" + "Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}
	@Override
	public void onStart(ITestContext context) {
		
	}
	@Override
	public void onFinish(ITestContext context) {
		
	}
	
	
	
	
}
