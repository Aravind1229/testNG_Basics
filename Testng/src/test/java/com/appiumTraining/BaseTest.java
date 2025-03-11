package com.appiumTraining;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public AppiumDriverLocalService service;
	public AndroidDriver driver;

	@BeforeSuite
	public void startServer() throws MalformedURLException, URISyntaxException {
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\aviar\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("0.0.0.0").usingPort(4724).build();
		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 9");
		options.setApp("C:\\Users\\aviar\\eclipse-workspace\\Testng\\src\\test\\resources\\General-Store.apk");
		driver = new AndroidDriver(new URI("http://0.0.0.0:4724").toURL(), options);
	}

	@AfterSuite
	public void stopServer() {
		driver.quit();
		service.stop();
	}

	public Double getFormattedAmount(String amountString) {
		Double price = Double.parseDouble(amountString.substring(1));
		return price;
	}
}
