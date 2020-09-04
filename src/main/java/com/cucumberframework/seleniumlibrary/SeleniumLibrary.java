package com.cucumberframework.seleniumlibrary;

import java.io.File;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumLibrary {

	public static WebDriver driver = null;

	public static WebDriver setUpDriver(String proxy) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "web_driver" + File.separator + "chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		Proxy webProxy = new Proxy();
		webProxy.setSslProxy(proxy);
//		options.setCapability(ChromeOptions.CAPABILITY, webProxy);
		driver = new ChromeDriver(options);
		return driver;
	}
}
