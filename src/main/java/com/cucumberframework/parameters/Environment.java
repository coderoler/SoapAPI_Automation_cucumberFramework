package com.cucumberframework.parameters;

public enum Environment {
	LOC("proxy1"),
	STG("proxy2");

	private Environment(String temp) {
		this.temp = temp;
	}
	
	private String temp;

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}
	
	
	}
