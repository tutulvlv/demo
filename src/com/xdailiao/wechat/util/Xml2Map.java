package com.xdailiao.wechat.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 消息处理
 * @author viakiba
 *
 */
public final class Xml2Map {
	//Xml转Map
	public static Map<String , String > Xml2Map(HttpServletRequest req) throws Exception{
		SAXReader reader = new SAXReader();
		Map<String , String > map = new HashMap<String,String>();
		
		InputStream ins = req.getInputStream();
		Document doc = reader.read(ins);
		
		Element rootElement = doc.getRootElement();
		List<Element> list = rootElement.elements();
		ins.close();
		
		for(Element e:list){
			map.put(e.getName(), e.getText());
			System.out.println(e.getText());
		}
		return map;
	}
}
