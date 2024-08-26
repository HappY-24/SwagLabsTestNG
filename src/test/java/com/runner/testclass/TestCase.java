package com.runner.testclass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase {
	
	public WebDriver driver;
	
	@BeforeTest
	private void beforeTest() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	
	@AfterTest
	private void afterTest() {
		driver.close();

	}
	
	@Test(retryAnalyzer = ReTest.class)
	
	private void testMethod() {
		
		String title = driver.getTitle();
		assertEquals(title,"google");

	}
	
	
}
