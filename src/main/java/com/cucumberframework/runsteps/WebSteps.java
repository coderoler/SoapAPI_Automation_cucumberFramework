package com.cucumberframework.runsteps;

import com.cucumberframework.seleniumlibrary.PageObject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class WebSteps extends BaseSteps{

	private PageObject po = BaseSteps.po;

	@Given("^open web page$")
	public void getPage() {
		po.getPage("http://www.google.com");
	}
	
	@Then("^close browser$")
	public void closeBrowser() {
		po.closeBrowser();
	}

}
