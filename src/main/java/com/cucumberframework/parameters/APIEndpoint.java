package com.cucumberframework.parameters;

public enum APIEndpoint {
	CREATE_PRODUCT("http://ws.webxml.com.cn/WebServices/TrainTimeWebService.asmx?wsdl", "createProduct"),
	CREATE_INBOUD("http://ws.webxml.com.cn/webservices/DomesticAirline.asmx?wsdl","getDomesticAirlinesTime");

	private APIEndpoint(String endpoint, String functionName) {
		this.endpoint = endpoint;
		this.functionName = functionName;
	}

	private String endpoint;
	private String functionName;

	public String getEndpoint() {

		return endpoint;
	}

	public String getFunctionName() {

		return functionName;
	}

}
