package com.cucumber.APIsteps;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cucumber.filetools.parseFile;
import com.cucumber.parameters.APIEndpiont;
import com.cucumber.parseXMLtool.ParseXML;
import com.jayway.restassured.response.Response;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class APISteps extends BaseSteps{

//	private Logger logger = Logger.getLogger(APISteps.class);

	private String mappingData = "";
	public String requestData = "";
	
	@Override
	@Before
	public void beforeSuit() {
		super.beforeSuit();
	}

	@Override
	@After
	public void afterSuit() {
		super.afterSuit();
	}

	public APISteps() {
	}

	@Given("^I send \"([^\"]*)\" request to get response with param datatable$")
	public void sendSoapAPIRqeuest(String functionName, DataTable dataTable) {
		String URL = null;
		switch (functionName) {
		case "getStationNameDataSet":
			URL = APIEndpiont.WEATHERAPI.getEnpointURL();
			break;
		case "getStationName":
			URL = APIEndpiont.WEATHERAPI.getEnpointURL();
			requestData = parseFile.getXML(functionName);
			break;
		case "getDomesticAirlinesTime":
			URL = APIEndpiont.DOMESTICAIRLINEAPI.getEnpointURL();
			requestData = parseFile.getXML(functionName);
			break;
		default:
			break;
		}
		List<Map<String, String>> keyValue = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> comlu : keyValue) {
			String key = comlu.get("key");
			String value = comlu.get("value");
		}
		
		
//		System.err.println(dataTable);
//		for(int i =0 ;i<dataTable.size();i++) {
//			keyValue = dataTable.get(i);
//			String key = keyValue.keySet().toString();
//			String value = keyValue.get(key);
////			requestData = ParseXML.updateXML(requestData,key,value);
//		}
		Response response = connection.sendSOAPRequest(URL,requestData);
		mappingData = response.asString();
	}
}
