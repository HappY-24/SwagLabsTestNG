package com.runner.testclass;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReTest implements IRetryAnalyzer {
		private int retrycount = 0;
		
		final private int maxcount =5;
		
	@Override
	public boolean retry(ITestResult result) {
		
		
		if(retrycount<maxcount) {
			retrycount++;
			return true;		
			
		}
		return false;
	}
	
	
}
