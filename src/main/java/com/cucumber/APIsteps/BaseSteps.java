package com.cucumber.APIsteps;

import java.util.HashMap;
import java.util.Map;

import com.cucumber.APIconnection.APIConnection;

public class BaseSteps {

//	private Logger logger = Logger.getLogger(BaseSteps.class);
	APIConnection connection;
	Map<String, String> header = new HashMap<String, String>();

	static {
		String env = System.getProperty("test_env");
		String site = System.getProperty("test_site");
//		System.out.println("+===========================================================================================================+");
//		System.out.println("|                                                                                                           |");
//		System.out.println("|                                                                                                           |");
//		System.out.println("|              ##           ##           ##    ####               ####       ###########                    |");
//		System.out.println("|              ##           ##           ##    #####             #####      ###        ###                  |");
//		System.out.println("|              ##          ####          ##    ##  ##           ##  ##     ###          ##                  |");
//		System.out.println("|              ##         ##  ##         ##    ##   ##         ##   ##     ###                              |");
//		System.out.println("|               ##       ##    ##       ##     ##    ##       ##    ##      #############                   |");
//		System.out.println("|                ##     ##      ##     ##      ##     ##     ##     ##       #############                  |");
//		System.out.println("|                 ##   ##        ##   ##       ##      ##   ##      ##                  ###                 |");
//		System.out.println("|                  #####          #####        ##       #####       ##      ##          ###                 |");
//		System.out.println("|                   ###            ###         ##        ###        ##      ###        ###                  |");
//		System.out.println("|                   ###            ###         ##        ###        ##       ############                   |");
//		System.out.println("|                                                                                                           |");
//		System.out.println("|                                                                                                           |");
		System.out.println("+================================   Initialize Test Environment   ==========================================+");
		System.out.println("+===============                Run Automation in " + env  + " Test Environment           ===========================+" );
		System.out.println("+===============                Run Automation in " + site + " Test Site               ===========================+" );
		System.out.println("+===========================================================================================================+");
		//TODO
		//加载配置文件给公有变量，如endpoint，proxy等
	}
	
	public String proxy;
	public void beforeSuit() {
		header = initializeHeader();
		connection = APIConnection.getInstance(header,proxy);
	}

	public void afterSuit() {
	}

	public Map<String, String> initializeHeader() {
		header.put("Content-Type", "text/xml;charset=UTF-8");
		header.put("User-Agent", "Apache-HttpClient/4.1.1 (java 1.5)");
		return header;
	}
}
