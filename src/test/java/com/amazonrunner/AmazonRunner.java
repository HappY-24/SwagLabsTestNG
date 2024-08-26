package com.amazonrunner;

import java.io.IOException;

import org.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.listener.ExtentReport_Test;
import com.listener.ITestListenerClass;
import com.pom.LoginPage;

@Listeners(ITestListenerClass.class)

public class AmazonRunner extends BaseClass{
	
	public static WebDriver driver;

	
	@BeforeTest()
	public void setup() {
		
		driver = BaseClass.browserLaunch("chrome");

	}
	@Test(priority = 1)
	public static void loginTest() {
		
	ExtentReport_Test.extenttest = extentReports.createTest("LoginTest" + 
	Thread.currentThread().getStackTrace()[1].getMethodName().toString())
	.info("Valid Emailid with Valid password");
	
	LoginPage lp = new LoginPage(driver);
	
	Assert.assertTrue(lp.validLogin(ExtentReport_Test.extenttest));
	}
	
	@Test(priority=-4)
	public static void validMobileNowithInvalidPassword() {
		
		
		ExtentReport_Test.extenttest = extentReports.createTest("LoginTest" + 
		Thread.currentThread().getStackTrace()[1].getMethodName().toString())
		.info("Valid Emailid with Invalid password");
		
		LoginPage lp = new LoginPage(driver);
		lp.validUsernameWithInvalidPassword();

		}
	
	@Test(priority = -3)
	public static void validMobileNowithEmptyPassword() {
		
		ExtentReport_Test.extenttest = extentReports.createTest("LoginTest" + 
		Thread.currentThread().getStackTrace()[1].getMethodName().toString())
		.info("Valid Emailid with Empty Password");
		
		LoginPage lp = new LoginPage(driver);
		lp.validUsernameWithEmptyPassword();

		}
	
	@Test(priority = -2)	
	public static void InvalidMobileNowithValidPassword() {
		
		ExtentReport_Test.extenttest = extentReports.createTest("LoginTest" + 
		Thread.currentThread().getStackTrace()[1].getMethodName().toString())
		.info("InValid Emailid with valid Password");
		
		LoginPage lp = new LoginPage(driver);
		lp.InvalidUsernameWithValidPassword();
		

		}
	
	@BeforeSuite
	public void extentStartUp() {
		extentReportStart("C:\\Users\\gayat\\Open_Mrs\\Reports");

	}
	
	@AfterSuite
	public void extentTear() throws IOException {
		extentReportTearDown("C:\\Users\\gayat\\Open_Mrs\\Reports\\index.html");

	}

//	@AfterMethod
//	public void browerclose() {
//		close();
//
//	}
	

}
