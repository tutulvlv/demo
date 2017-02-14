package com.xdailiao.wechat.util;

import com.thoughtworks.xstream.XStream;
import com.xdailiao.wechat.entity.PersonCollectionSendBean;
import com.xdailiao.wechat.entity.RedpacketSendbean;

/**
 * 这里可以完善 成一个
 * 
 * 实体类转xml cdata块
 * @author viakiba
 *
 */
public class Bean2TextXml {
	public static String beantoTextXml(TextMessageBean mtb){
		XStream xst = new XStream();
		
		xst.alias("xml", mtb.getClass());//标签对与属性名一致
		
		String mtbBean2Str=xst.toXML(mtb);
		
		return mtbBean2Str;
	}
	
	public static String beantoTextXmlRead(RedpacketSendbean mtb){
		XStream xst = new XStream();
		
		xst.alias("xml", mtb.getClass());//标签对与属性名一致
		
		String mtbBean2Str=xst.toXML(mtb).replaceAll("__", "_");
		System.out.println(mtbBean2Str);
		
		return mtbBean2Str;
	}
	
	public static String beantoTextXmlPersonCollection(PersonCollectionSendBean mtb){
		XStream xst = new XStream();
		
		xst.alias("xml", mtb.getClass());//标签对与属性名一致
		
		String mtbBean2Str=xst.toXML(mtb).replaceAll("__", "_");
		System.out.println(mtbBean2Str);
		
		return mtbBean2Str;
	}
	
	public static String beantoXml(Object mtb){
		XStream xst = new XStream();
		PersonCollectionSendBean m = null;
		if(mtb instanceof PersonCollectionSendBean){
			m = (PersonCollectionSendBean) mtb;
		}
		xst.alias("xml", m.getClass());//标签对与属性名一致
		String mtbBean2Str=xst.toXML(m).replaceAll("__", "_");
		return mtbBean2Str;
	}
	
}
