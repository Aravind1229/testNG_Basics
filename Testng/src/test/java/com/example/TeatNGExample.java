package com.example;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TeatNGExample {
	@BeforeSuite
	public void welcomeMessage() {
		System.out.println("Welcome!....");
	}

	@Test(groups = "assertTests", dataProvider = "addProvider")
	public void addNumbers(int x, int y) {
		assertTrue(x + y > 10);
	}

	@Test
	public void subtractNumbers() {
		int x = 5;
		int y = 6;
		assertFalse(x - y > 11);
	}

	@DataProvider(name = "addProvider")
	public Object[][] addProvider() {
		return new Object[][] { { 12, 23 }, { 23, 12 } };
	}

	@AfterSuite
	public void goodByeMessage() {
		System.out.println("GoodBye!....");
	}
}
