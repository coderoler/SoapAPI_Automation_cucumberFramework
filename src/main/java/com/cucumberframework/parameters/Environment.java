package com.cucumberframework.parameters;

public enum Environment {
	LOC("proxy1"),
	STG("proxy2");

	Environment(String temp) {
		this.temp = temp;
	}

	private String temp;

	public String getTemp() {
		return temp;
	}
}
