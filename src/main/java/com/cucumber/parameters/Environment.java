package com.cucumber.parameters;

public enum Environment {
	loc("loc"),
	stg("stg");

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
