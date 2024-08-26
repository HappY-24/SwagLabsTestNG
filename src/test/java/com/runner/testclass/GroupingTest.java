package com.runner.testclass;

import org.testng.annotations.Test;

public class GroupingTest {
	
	@Test(groups = "VEG")
	private void sambarrice() {
		
		System.out.println("Sambar rice");	
	}
	
	@Test(groups = "VEG")
	private void curdrice() {
		System.out.println("Curd rice");

	}
	
	@Test(groups ="VEG")
	private void pongal() {
		System.out.println("Pongal");

	}
	
	@Test(groups ="NONVEG")
	private void biriyani() {
		System.out.println("biriyani");

	}
	
	@Test(groups ="NONVEG")
	private void tandoori() {
		System.out.println("Tandoori");

	}
	
	@Test(groups ="NONVEG")
	private void ChickenCurry() {
		System.out.println("ChickenCurry");

	}
	
	@Test(groups ="ELECTRONICS")
	private void Headsets() {
		System.out.println("Headsets");

	}
	
	@Test(groups ="ELECTRONICS")
	private void Laptop() {
		System.out.println("Laptop");

	}
	
	@Test(groups ="ELECTRONICS")
	private void Mobile() {
		System.out.println("Mobile");

	}
	

}
