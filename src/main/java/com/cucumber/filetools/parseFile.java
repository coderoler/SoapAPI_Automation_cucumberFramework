package com.cucumber.filetools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class parseFile {

	public static String getXML(String name) {
		String temp = null;
		StringBuffer xmlParam = new StringBuffer();
		File file = new File(
				System.getProperty("user.dir") + File.separator + "xmlTemplate" + File.separator + name + ".xml");
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

}
