package com.cucumberframework.APIconnection;

import java.util.Map;


public class BaseConnection {
	protected Map<String, String> header;
	protected String proxy;
	
	public BaseConnection(Map<String, String> header,String proxy) {
		this.header = header;
		this.proxy = proxy;
		System.err.println(this.proxy);
	}

}
