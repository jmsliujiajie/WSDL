package com.lll.util.xml;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;

public class XMLUtils {
	public static Document CreateXMLDocument(String inputXml, String createType) {
		/**
		 * createType:file 根据xml模板路径创建文件。 createType:str 根据xml报文创建文件。
		 * */
		// System.out.println("===========inputXml " + inputXml);
		Document document = null;
		SAXReader saxReader = new SAXReader();
		try {
			if ("file".equals(createType)) {
				File rootFile = new File(inputXml);
				document = saxReader.read(rootFile);
			} else if ("str".equals(createType)) {
				document = DocumentHelper.parseText(inputXml);
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return document;
	}
}
