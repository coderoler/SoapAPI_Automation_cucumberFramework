package com.cucumberframework.APIsteps;

import java.util.List;
import java.util.Map;

import org.dom4j.Document;

import com.cucumberframework.parameters.APIEndpiont;
import com.cucumberframework.tools.ParseXML;
import com.jayway.restassured.response.Response;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class APISteps extends BaseSteps {

//	private Logger logger = Logger.getLogger(APISteps.class);

	private Document requestData;
	private Document sonNodeList;
	private String xmlType;
	@SuppressWarnings("unused")
	private Response response;

	@Override
	@Before
	public void before() {
		super.before();
	}
	
	@Override
	@After
	public void after() {
		super.after();
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
		sonNodeList = ParseXML.loadXML(fileName);
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
			sonNodeList = ParseXML.updateNodeListValue(sonNodeList, listName, key, value);
		}
		requestData = ParseXML.addNodeListUnderNode(requestData, sonNodeList,xmlType, listName, path);
	}
	
	@Then("^send \"([^\"]*)\" request$")
	public void sendSoapAPIRqeuest(String functionName) {
		String URL = null;
		switch (functionName) {
		case "createProduct":
			URL = APIEndpiont.CREATEPRODUCT.getEnpointURL();
			break;
		case "createInbound":
			URL = APIEndpiont.CREATEINBOUD.getEnpointURL();
			break;
		default:
			break;
		}
		response = connection.sendSOAPRequest(URL,ParseXML.xmlToString(requestData));
	}
}
