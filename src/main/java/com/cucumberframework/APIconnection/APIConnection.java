package com.cucumberframework.APIconnection;

import static com.jayway.restassured.RestAssured.given;

import java.util.Map;

import com.jayway.restassured.response.Response;


public class APIConnection extends BaseConnection {

	private volatile static APIConnection instance = null;

	public APIConnection(Map<String, String> header,String proxy) {
		super(header,proxy);
	}

	public static APIConnection getInstance(Map<String, String> header,String proxy) {
		if(instance == null) {
			synchronized (APIConnection.class) {
				if(instance == null) {
					instance = new APIConnection(header,proxy);
				}
			}
		}
		return instance;
	}

	public Response sendSOAPRequest(String URL, String paramter) {
		System.out.println("#################################### Request ####################################");
		Response response = given()
							.headers(header)
							.body(paramter.trim())
							.when()
							.log()
							.all()
							.post(URL);
		System.out.println("################################### Response ###################################");
		response.getBody().prettyPrint();
		System.out.println("################################################################################");
		return response;
	}

}
