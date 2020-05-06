package com.cucumber.APIconnection;

import java.util.HashMap;
import java.util.Map;


public class BaseConnection {
	Map<String, String> header = new HashMap<String, String>();
	public String proxy;
	
	public BaseConnection(Map<String, String> header,String proxy) {
		this.header = header;
		this.proxy = proxy;
	}

	public BaseConnection() {
	}


}
