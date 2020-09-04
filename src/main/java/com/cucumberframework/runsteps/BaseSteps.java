package com.cucumberframework.runsteps;

import org.openqa.selenium.WebDriver;
import com.cucumberframework.APIconnection.APIConnection;
import com.cucumberframework.parameters.Environment;
import com.cucumberframework.seleniumlibrary.PageObject;
import com.cucumberframework.seleniumlibrary.SeleniumLibrary;

import cucumber.api.Scenario;

import java.util.HashMap;
import java.util.Map;

public class BaseSteps {

    public static String xmlTemplateFolder;
    protected static String proxy;
    public static WebDriver driver;
    public static PageObject po;

    static {
        String env = System.getProperty("testEnv");
        String site = System.getProperty("testSite");
        System.out.println("+================================   Initialize Test Environment   ==========================================+");
        System.out.println("+===============                Run Automation in " + env + " Test Environment           ===========================+");
        System.out.println("+===============                Run Automation in " + site + " Test Site               ===========================+");
        System.out.println("+===========================================================================================================+");
        initializeXmlTemplatePath(site);
        proxy = env.contains("stg") ? Environment.STG.getTemp() : Environment.LOC.getTemp();
//        driver = SeleniumLibrary.setUpDriver(proxy);

    }

    //	private Logger logger = Logger.getLogger(BaseSteps.class);
    APIConnection connection;
    Map<String, String> header = new HashMap<>();

    public void before(Scenario scenario) {
        header = initializeHeader();
        connection = APIConnection.getInstance(header, proxy);
        po = PageObject.getInstance(driver);
    }

    public void after() {

    }

    public Map<String, String> initializeHeader() {
        header.put("Content-Type", "text/xml;charset=UTF-8");
        header.put("User-Agent", "Apache-HttpClient/4.1.1 (java 1.5)");
        return header;
    }

    private static void initializeXmlTemplatePath(String siteType) {
        switch (siteType) {
            case "Beijing":
                xmlTemplateFolder = "Env_1_xml_template";
                break;
            case "Shanghai":
                xmlTemplateFolder = "Env_2_xml_template";
                break;
            case "Hangzhou":
                xmlTemplateFolder = "Env_3_xml_template";
                break;
            case "Haiku":
                xmlTemplateFolder = "Env_4_xml_template";
                break;
            default:
                break;
        }
    }
}
