package com.cucumberframework.seleniumlibrary;


import org.openqa.selenium.WebDriver;

public class PageObject {

	private WebDriver driver;

	private volatile static PageObject instance = null;
	
	public static PageObject getInstance(WebDriver driver) {
		if(instance == null) {
			synchronized (PageObject.class) {
				if(instance == null) {
					instance = new PageObject(driver);
				}
			}
		}
		return instance;
	}
	
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
