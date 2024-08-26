package com.runner.testclass;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


public class TestClass extends BaseClass{
	@Test(invocationCount = 2)
	
	private void browser(){
		
		browserLaunch("chrome");
		launchingUrl("https://www.amazon.in/");
		
	}
	@Test
	@Ignore
	private void edgebrowser(){
		
		browserLaunch("edge");
		launchingUrl("https://www.amazon.in/");
		
	}
	@Test(timeOut=3000)
	private void firefoxbrowser(){
		
		browserLaunch("firefox");
		launchingUrl("https://www.amazon.in/");
		
	}
	
//	@Test(priority = -3)
//	private void search(){
//		
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobiles");		
//	}
//	@Test(priority = 1)
//	private void close() {
//		driver.quit();
//	}
//	
}
