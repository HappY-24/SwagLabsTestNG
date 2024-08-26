package com.swagrunner;

import java.io.IOException;

import org.base.BaseClass;
import org.junit.Assert;
import org.testng.ITestListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Swagpom.SwagLoginPage;
import com.listener.ExtentReport_Test;
import com.listener.ITestListenerClass;
import com.swag_POM_ManagerFiles.SwagPageObjectManager;

@Listeners(ITestListenerClass.class)
public class SwagRunner extends BaseClass{
	
	@BeforeSuite
	public void extentReportStartUp() {
		
		extentReportStart("C:\\Users\\gayat\\Open_Mrs\\report");
	}
	
	@BeforeTest()
	public void setup() {
		
		driver = BaseClass.browserLaunch("chrome");
	}
	
	@Test(priority = 0)
	public void LoginMethods() throws IOException {
		ExtentReport_Test.extenttest = extentReports.createTest("LoginTest" + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
					.info("Valid Emailid with Valid password");	
			
			SwagLoginPage sl = new SwagLoginPage(driver);
			
			Assert.assertTrue(sl.getLoginElements(ExtentReport_Test.extenttest));
			
	}
		@Test(priority = -1)
		public void InvalidLoginMethods() throws IOException {
			ExtentReport_Test.extenttest = extentReports.createTest("LoginTest" + 
					Thread.currentThread().getStackTrace()[1].getMethodName().toString())
					.info("InValid Emailid with Valid password");	
			
			SwagLoginPage sl = new SwagLoginPage(driver);
			
			sl.getInValidLoginElements();
			
		}
		
		@Test(priority = 1)
		public void getItemOne() throws IOException {
			ExtentReport_Test.extenttest = extentReports.createTest("LoginTest" + 
					Thread.currentThread().getStackTrace()[1].getMethodName().toString())
					.info("InValid Emailid with Valid password");	
			
			SwagLoginPage sl = new SwagLoginPage(driver);
			
			sl.getProductOne();
			
		}
	
		@Test(priority = 2)
		public void getItemTwo() throws IOException {
			ExtentReport_Test.extenttest = extentReports.createTest("LoginTest" + 
					Thread.currentThread().getStackTrace()[1].getMethodName().toString())
					.info("InValid Emailid with Valid password");	
			
			SwagLoginPage sl = new SwagLoginPage(driver);
			
			sl.getProductTwo();
			
		}
	
		@Test(priority = 3)
		public void getItemThree() throws IOException {
			ExtentReport_Test.extenttest = extentReports.createTest("LoginTest" + 
					Thread.currentThread().getStackTrace()[1].getMethodName().toString())
					.info("InValid Emailid with Valid password");	
			
			SwagLoginPage sl = new SwagLoginPage(driver);
			
			sl.getProductThree();
			
		}
	
		@Test(priority = 4)
		public void getItemFour() throws IOException {
			ExtentReport_Test.extenttest = extentReports.createTest("LoginTest" + 
					Thread.currentThread().getStackTrace()[1].getMethodName().toString())
					.info("InValid Emailid with Valid password");	
			
			SwagLoginPage sl = new SwagLoginPage(driver);
			
			sl.getProductFour();
			
		}
	
		@Test(priority = 5)
		public void getItemFive() throws IOException {
			ExtentReport_Test.extenttest = extentReports.createTest("LoginTest" + 
					Thread.currentThread().getStackTrace()[1].getMethodName().toString())
					.info("InValid Emailid with Valid password");	
			
			SwagLoginPage sl = new SwagLoginPage(driver);
			
			sl.getProductFive();
			
		}
		
		
		@AfterSuite
		public void extentTearDown() throws IOException {
			extentReportTearDown("C:\\Users\\gayat\\Open_Mrs\\report\\index.html");

		}

}
