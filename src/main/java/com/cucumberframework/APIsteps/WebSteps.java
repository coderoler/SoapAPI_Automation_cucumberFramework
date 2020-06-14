package com.cucumberframework.APIsteps;

import com.cucumberframework.seleniumlibrary.PageObject;

import cucumber.api.java.en.Given;

public class WebSteps extends BaseSteps{

	private PageObject po = BaseSteps.po;
	
	@Given("^open web page$")
	public void getPage() {
		po.getPage("http://www.google.com");
	}
}
