package com.cucumberframework.tools;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.cucumberframework.APIsteps.BaseSteps;

public class ParseXML {

	public static Document loadXML(String fileName) {
		Document document = null;
		try {
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(new File(System.getProperty("user.dir") + File.separator + "xmlTemplate"
					+ File.separator + BaseSteps.xmlTempleteFolder + File.separator + fileName + ".xml")); // 读取XML文件,获得document对象
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return document;
	}

	public static Element getNode(Element element) {
		return element;
	}

	// TODO
	public static Document updateNodeListValue(Document document,String path, String key, String value) {
		Element rootNode = document.getRootElement();
		Element keyNode = rootNode.element(key);
		keyNode.setText(value);
		return document;
	}
	
	public static Document updateNodeValue(Document document,String xmlType, String path, String key, String value) {
		Element rootNode = document.getRootElement();
		Element node = rootNode.element("Body").element(xmlType).element("arg0");
		String[] pathList = path.split("/");
		for(int i = 0; i< pathList.length;i++) {
			node = node.element(pathList[i]);
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
		List<Element> node = rootNode.element("Body").element(xmlType).element(path).elements();
		List<Node> listNode = listRootNode.content();
		Element nodeListName = DocumentHelper.createElement(nodeName);
		nodeListName.setContent(listNode);
		node.add(nodeListName);
		System.out.println(document.asXML());
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

	public static void main(String[] args) {
		Document dom = ParseXML.loadXML("createProduct");
		Document chilDom = ParseXML.loadXML("productModelList");
//		dom = addNodeListUnderNode(dom, chilDom, "productModelList", "createProduct");
		System.out.println(xmlToString(dom));

	}
}