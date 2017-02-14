package com.xdailiao.wechat.button;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.xdailiao.wechat.util.WcUtils;
import com.xdailiao.wechat.util.WechatPropertiesUtil;

public class Wcbutton {
	private static String appid = WechatPropertiesUtil.getWxappid();
	private static String secret = WechatPropertiesUtil.getWxsecret();
	
	// post https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN
	/**
	 * 测试使用
	 * @param butjson
	 * @return
	 */
	public static String getButJson(String butjson){
		File file = new File("src/com/xdailiao/utils/wcbut/button.json");
		StringBuffer sb = new StringBuffer();
		
		BufferedReader reader = null;
        try {
            
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                sb.append(tempString);
            }
            reader.close();
        }catch(Exception e){
        	e.printStackTrace();
        }
		return sb.toString();
	}
	
	public static String getAccesstoken() {
		// https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret;
		// {"access_token":"ACCESS_TOKEN","expires_in":7200}
		String accesstoken = WcUtils.loadJson(url);
		Map parseObject = JSON.parseObject(accesstoken, Map.class);
		String access =(String) parseObject.get("access_token");
		return access;
	}
	
	public static String createBut(String button,String accesstoken){
		String url = " https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+accesstoken;
		String mes = WcUtils.loadJson(url, button);
		return mes;
	}
	
	public static String deleteBut(String accesstoken){
		String url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token="+accesstoken;
		String mes = WcUtils.loadJson(url);
		return mes;
	}
	
	
	public static void main(String[] args) throws IOException {
		//System.out.println();
		//System.out.println(getButJson("dsa"));
		System.out.println(getAccesstoken());
		//createBut();
		//deleteBut();
	}
}
