package com.cucumberframework.APIsteps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.cucumberframework.parameters.APIEndpiont;
import com.cucumberframework.tools.ParseFile;
import com.cucumberframework.tools.ParseXML;
import com.jayway.restassured.response.Response;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class APISteps extends BaseSteps {

//	private Logger logger = Logger.getLogger(APISteps.class);

	private Document requestData;
	private Document nodeList;
	
	private String xmlType;

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

	@When("^load \"([^\"]*)\" xml template$")
	public void loadXML(String fileName) {
		requestData = ParseXML.loadXML(fileName);
		xmlType = fileName;
	}

	@Then("^load \"([^\"]*)\" xml template to prapre complex data modelList$")
	public void loadSonXML(String fileName) {
		nodeList = ParseXML.loadXML(fileName);
	}

	@Then("^update node under \"([^\"]*)\" with data table as below$")
	public void updateNodeValue(String path, DataTable table) {
		List<Map<String, String>> keyValue = table.asMaps(String.class, String.class);
		for (Map<String, String> line : keyValue) {
			String key = line.get("nodeKey");
			String value = line.get("value");
			requestData = ParseXML.updateNodeValue(requestData,xmlType, path, key, value);
		}
	}

	@Then("^add \"([^\"]*)\" under \"([^\"]*)\" with value as data table$")
	public void addSonList(String listName, String path, DataTable table) {
		List<Map<String, String>> keyValue = table.asMaps(String.class, String.class);
		for (Map<String, String> line : keyValue) {
			String key = line.get("nodeKey");
			String value = line.get("value");
			nodeList = ParseXML.updateNodeListValue(nodeList, listName, key, value);
		}
		requestData = ParseXML.addNodeListUnderNode(requestData, nodeList,xmlType, listName, path);
	}
	
	@Given("^I send \"([^\"]*)\" request to get response with param datatable$")
	public void sendSoapAPIRqeuest(String functionName, DataTable dataTable) {
		System.out.println(xmlTempleteFolder);
		String URL = null;
//		switch (functionName) {
//		case "createProduct":
//			URL = APIEndpiont.CREATEPRODUCT.getEnpointURL();
//			requestData = ParseFile.loadXML(functionName);
//			System.out.println(requestData);
//			break;
//		case "getStationName":
//			URL = APIEndpiont.CREATEPRODUCT.getEnpointURL();
//			requestData = ParseFile.loadXML(functionName);
//			break;
//		case "getDomesticAirlinesTime":
//			URL = APIEndpiont.DOMESTICAIRLINEAPI.getEnpointURL();
//			requestData = ParseFile.loadXML(functionName);
//			break;
//		default:
//			break;
//		}
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
//		Response response = connection.sendSOAPRequest(URL,requestData);
//		mappingData = response.asString();
	}
}
