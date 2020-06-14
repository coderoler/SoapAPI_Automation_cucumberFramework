package com.cucumberframework.APIsteps;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.cucumberframework.APIconnection.APIConnection;
import com.cucumberframework.parameters.Environment;
import com.cucumberframework.seleniumlibrary.PageObject;
import com.cucumberframework.seleniumlibrary.SeleniumLibrary;

public class BaseSteps {
	
	private static String env;
	private static String site;
	public static String xmlTempleteFolder;
	protected static String proxy;
	public WebDriver driver;
	public static PageObject po;
	
	static {
		env = System.getProperty("test_env");
	    site = System.getProperty("test_site");
		System.out.println("+================================   Initialize Test Environment   ==========================================+");
		System.out.println("+===============                Run Automation in " + env  + " Test Environment           ===========================+" );
		System.out.println("+===============                Run Automation in " + site + " Test Site               ===========================+" );
		System.out.println("+===========================================================================================================+");
		initializeXmlTempletePath(site);
		proxy = env.contains("stg") ? Environment.STG.getTemp() : Environment.LOC.getTemp();
		
	}
//	private Logger logger = Logger.getLogger(BaseSteps.class);
	APIConnection connection;
	Map<String, String> header = new HashMap<String, String>();

	public void before() {
		header = initializeHeader();
		connection = APIConnection.getInstance(header,proxy);
		driver = SeleniumLibrary.setUpDriver(proxy);
		po = new PageObject(driver);
	}
	
	public void after() {
		driver.close();
		driver.quit();
	}

	public Map<String, String> initializeHeader() {
		header.put("Content-Type", "text/xml;charset=UTF-8");
		header.put("User-Agent", "Apache-HttpClient/4.1.1 (java 1.5)");
		return header;
	}
	
	public static void initializeXmlTempletePath(String siteType) {
		switch (siteType) {
		case "ichiba":
			xmlTempleteFolder = "Env_1_xml_template";
			break;

		default:
			break;
		}
	}
}
