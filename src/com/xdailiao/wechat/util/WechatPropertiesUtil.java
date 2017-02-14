package com.xdailiao.wechat.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

/**
 * 微信相关配置文件读取
 * @author viakiba
 *
 */
public class WechatPropertiesUtil {
	private static String wxappid = null;
	private static String send_name = null;
	private static String mch_id = null;
	private static String total_num = null;
	private static String wishing = null;
	private static String act_name = null;
	private static String client_ip = null;
	private static String remark = null;
	private static String paykey = null;
	private static String wxsecret = null;
	private static String sendredurl = null;
	private static String payurl = null;
	
	static{
		try {
			WechatPropertiesUtil.init();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void init() throws FileNotFoundException, IOException{
		String url = WechatPropertiesUtil.class.getClassLoader().getResource("wechat.properties").toString();
		url = url.substring(6);
		Properties prop = new Properties();
		prop.load((new FileInputStream(url)));
		wxappid = (String) prop.get("wxappid");
		send_name = (String) prop.get("send_name");
		mch_id = (String) prop.get("mch_id");
		total_num = (String) prop.get("total_num");
		wishing = (String) prop.get("wishing");
		act_name = (String) prop.get("act_name");
		client_ip = (String) prop.get("client_ip");
		remark = (String) prop.get("remark");
		paykey = (String) prop.get("paykey");
		wxsecret = (String) prop.get("wxsecret");
		sendredurl = (String) prop.get("sendredurl");
		payurl = (String) prop.get("payurl");
	}

	public static String getWxappid() {
		return wxappid;
	}
	
	public static String getSendredurl() {
		return sendredurl;
	}
	
	public static String getPayurl() {
		return payurl;
	}
	
	public static String getWxsecret() {
		return wxsecret;
	}
	
	public static String getPaykey() {
		return paykey;
	}

	public static String getSend_name() {
		return send_name;
	}

	public static String getMch_id() {
		return mch_id;
	}

	public static String getTotal_num() {
		return total_num;
	}

	public static String getWishing() {
		return wishing;
	}

	public static String getAct_name() {
		return act_name;
	}

	public static String getClient_ip() {
		return client_ip;
	}

	public static String getRemark() {
		return remark;
	}
}
