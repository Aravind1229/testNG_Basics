package com.appiumTraining;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AppiumBasics extends BaseTest {
	@Test
	public void AppiumTest() throws MalformedURLException, URISyntaxException {
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Aravind");
	}

}
