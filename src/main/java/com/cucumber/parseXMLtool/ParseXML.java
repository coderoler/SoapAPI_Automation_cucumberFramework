package com.cucumber.parseXMLtool;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Node;
import org.w3c.dom.Document;

public class ParseXML {

//	public static String updateXML(String xmlString, String key, String value) {
//		SAXReader reader = new SAXReader();
//		Document document = null;
//		try {
//			document = reader.read(new File(System.getProperty("user.dir") + File.separator + "xmlTemplate"
//					+ File.separator + "getDomesticAirlinesTime.xml"));
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Element rootElem = document.getRootElement();
//		Attribute rootattr = rootElem.
//		Attribute node = rootElem.attribute("web:startCity");
//		System.err.println(node);
//		System.err.println(key);
//		System.err.println(value);
//		node.setValue("北京");
//		String xmlValue = document.toString();
//		System.err.println(xmlValue);
//		return xmlValue;
//	}

	/**
	 * 
	 * @param document
	 *            Document对象（读xml生成的）
	 * @return String字符串
	 * @throws Throwable
	 */
	public String xmlToString(Document document) throws Throwable {
		TransformerFactory ft = TransformerFactory.newInstance();
		Transformer ff = ft.newTransformer();
//		ff.setOutputProperty("encoding", "GB2312");
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ff.transform(new DOMSource(document), new StreamResult(bos));
		return bos.toString();
	}

	/**
	 * 
	 * @param xml形状的str串
	 * @return Document 对象
	 */
	public Document StringTOXml(String str) {

		StringBuilder sXML = new StringBuilder();
		sXML.append(str);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		Document doc = null;
		try {
			InputStream is = new ByteArrayInputStream(sXML.toString().getBytes("utf-8"));
			doc = dbf.newDocumentBuilder().parse(is);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doc;
	}

	/**
	 * 
	 * @param document
	 * @return 某个节点的值 前提是需要知道xml格式，知道需要取的节点相对根节点所在位置
	 */
	public String getNodeValue(Document document, String nodePaht) {
		XPathFactory xpfactory = XPathFactory.newInstance();
		XPath path = xpfactory.newXPath();
		String servInitrBrch = "";
		try {
			servInitrBrch = path.evaluate(nodePaht, document);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return servInitrBrch;
	}

	/**
	 * 
	 * @param document
	 * @param nodePath
	 *            需要修改的节点相对根节点所在位置
	 * @param vodeValue
	 *            替换的值
	 */
	public void setNodeValue(Document document, String nodePath, String vodeValue) {
		XPathFactory xpfactory = XPathFactory.newInstance();
		XPath path = xpfactory.newXPath();
		Node node = null;
		;
		try {
			node = (Node) path.evaluate(nodePath, document, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		node.setTextContent(vodeValue);
	}

	public static void main(String[] args) throws Throwable {
		// 读取xml文件，生成document对象
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		// 文件的位置在工作空间的根目录（位置随意，只要写对就ok）
		Document document = (Document) builder.parse(new File(System.getProperty("user.dir") + File.separator + "xmlTemplate"+File.separator + "getDomesticAirlinesTime.xml"));

		ParseXML t = new ParseXML();
		// XML————》String
		String str = t.xmlToString(document);
		System.out.println("str:" + str);
		// String ————》XML
		Document doc = t.StringTOXml(str);
		String nodePath = "/Envelope/Body/getDomesticAirlinesTime/startCity";
		// getNodeValue
		String nodeValue = t.getNodeValue(doc, nodePath);
		System.out.println("修改前nodeValue：" + nodeValue);
		// setNodeValue
		t.setNodeValue(doc, nodePath, nodeValue + "hello");
		System.out.println("修改后nodeValue：" + t.getNodeValue(doc, nodePath));
		String after = t.xmlToString(doc);
		System.err.println(after);
	}
}
