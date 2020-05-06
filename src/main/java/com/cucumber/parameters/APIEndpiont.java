package com.cucumber.parameters;

public enum APIEndpiont {
	WEATHERAPI("http://ws.webxml.com.cn/WebServices/TrainTimeWebService.asmx?wsdl", "getStationNameDataSet"),
	DOMESTICAIRLINEAPI("http://ws.webxml.com.cn/webservices/DomesticAirline.asmx?wsdl","getDomesticAirlinesTime");

	private APIEndpiont(String enpointURL, String functionName) {
		this.enpointURL = enpointURL;
		this.functionName = functionName;
	}

	private String enpointURL;
	private String functionName;

	public String getEnpointURL() {
		return enpointURL;
	}

	public void setEnpointURL(String enpointURL) {
		this.enpointURL = enpointURL;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

}
