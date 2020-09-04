package com.cucumberframework.tools;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import com.cucumberframework.runsteps.BaseSteps;

import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.DocumentHelper;

public class ParseXML {

	
	public static Document loadXML(String fileName) {
		Document document = null;
		try {
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(new File(System.getProperty("user.dir") + File.separator + "xmlTemplate"
					+ File.separator + BaseSteps.xmlTemplateFolder + File.separator + fileName + ".xml")); // 读取XML文件,获得document对象
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return document;
	}

	
	public static Document updateNodeListValue(Document document, String key, String value) {
		Element rootNode = document.getRootElement();
		Element keyNode = rootNode.element(key);
		keyNode.setText(value);
		return document;
	}
	
	public static Document updateNodeValue(Document document,String xmlType, String path, String key, String value) {
		Element rootNode = document.getRootElement();
		Element node = rootNode.element("Body").element(xmlType).element("arg0");
		String[] pathList = path.split("/");
		for (String s : pathList) {
			node = node.element(s);
		}
		node = node.element(key);
		node.setText(value);
		return document;
	}

	/**
	 * This method is using for add node list
	 * 
	 * @param document     parent XML document
	 * @param documentList son XML document
	 * @param nodeName     name of added node name
	 * @param path         location where add node
	 * @return document after added node
	 */
	public static Document addNodeListUnderNode(Document document, Document documentList,String xmlType, String nodeName,
			String path) {
		Element rootNode = document.getRootElement();
		Element listRootNode = documentList.getRootElement();
		Element node = rootNode.element("Body").element(xmlType);
		String[] pathList = path.split("/");
		for (String s : pathList) {
			node = node.element(s);
		}
		List<Element> parentNode = node.elements();
		List<Node> listNode = listRootNode.content();
		Element nodeListName = DocumentHelper.createElement(nodeName);
		nodeListName.setContent(listNode);
		parentNode.add(nodeListName);
		return document;
	}

	/**
	 * This method is using for change document XML to string XML
	 * 
	 * @param document document which need to be changed to String
	 * @return XML which data type is String
	 */
	public static String xmlToString(Document document) {
		Element root = document.getRootElement();
		return root.asXML();
	}

}
