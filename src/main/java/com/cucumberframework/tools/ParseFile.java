package com.cucumberframework.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import com.cucumberframework.runsteps.BaseSteps;

public class ParseFile {

	public static String loadXML(String name) {
		String temp = null;
		StringBuffer xmlParam = new StringBuffer();
		File file = new File(System.getProperty("user.dir") + File.separator + "xmlTemplate" + File.separator
				+ BaseSteps.xmlTemplateFolder + File.separator + name + ".xml");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while ((temp = reader.readLine()) != null) {
				xmlParam.append(temp);
			}
			reader.close();
			return xmlParam.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp;

	}

	/**
	 * This method is used to read files
	 * 
	 * @param filePath   FilePath
	 * @param charseName CharseName
	 * @return A string that stores the contents of a file
	 */
	public static String readFile(String filePath, String charseName) {

		String line = null;
		StringBuffer stringBuffer = new StringBuffer();
		try {
			FileInputStream file = new FileInputStream(filePath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(file, charseName));
			while ((line = reader.readLine()) != null) {
				stringBuffer.append(line.trim());
			}
			reader.close();
			return stringBuffer.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Properties getProperties(String filePath) {
		
		try {
			FileInputStream inputFile = new FileInputStream(filePath);
			Properties properties = new Properties();
			properties.load(inputFile);
			inputFile.close();
			return properties;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
//	public static void main(String arg[]) {
//
//		Properties properties = ParseFile.getProperties(System.getProperty("user.dir") + File.separator + "configure" + File.separator + "env_1.properties");
//		System.err.println(properties.get("cli"));
//	}

}
