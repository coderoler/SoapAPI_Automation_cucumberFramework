package com.cucumberframework.seleniumlibrary;

import org.openqa.selenium.WebDriver;

public class PageObject {

	private WebDriver driver;

	
	public PageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void getPage(String url) {
		driver.get(url);
	}
	
	public void closeBorwser() {
		System.out.println("close borwser");
		driver.close();
		driver.quit();
	}
}
