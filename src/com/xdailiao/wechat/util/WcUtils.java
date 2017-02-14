package com.xdailiao.wechat.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 与微信服务器网络交互 get与post提交两种
 * @author viakiba
 *
 */
public class WcUtils {
	//返回json字符串  get
	public static String loadJson (String url) {  
		 StringBuilder json = new StringBuilder();  
		 BufferedReader in = null;
		 try {  
			 System.out.println("进入get请求。。。。。。accessToken");
		     URL urlObject = new URL(url);  
		     URLConnection uc = urlObject.openConnection();  
		     in = new BufferedReader(new InputStreamReader(uc.getInputStream(),"utf-8"));  
		     String inputLine = null;  
		     while ( (inputLine = in.readLine()) != null) {  
		           json.append(inputLine);  
		     	}  
		     in.close();  
		     } catch (Exception e) {  
		       e.printStackTrace();  
		     }finally{
		    	 try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		     }
		     return json.toString();  
	 }
		
	//返回json字符串  post
	public static String loadJson(String strURL,String params){
		System.out.println(strURL);  
        System.out.println(params);  
        OutputStreamWriter out = null;
        InputStream is = null;
        
        try {  
            URL url = new URL(strURL);// 创建连接  
            HttpURLConnection connection = (HttpURLConnection) url  
                    .openConnection();  
            connection.setDoOutput(true);  
            connection.setDoInput(true);  
            connection.setUseCaches(false);  
            connection.setInstanceFollowRedirects(true);  
            connection.setRequestMethod("POST"); // 设置请求方式  
            connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式  
            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式  
            connection.connect();  
            out = new OutputStreamWriter(  
                    connection.getOutputStream(), "UTF-8"); // utf-8编码  
            out.append(params);  
            out.flush();  
            out.close();  
            // 读取响应  
            int length = (int) connection.getContentLength();// 获取长度  
            is = connection.getInputStream();
            if (length != -1) {  
                byte[] data = new byte[length];  
                byte[] temp = new byte[512];  
                int readLen = 0;  
                int destPos = 0;  
                while ((readLen = is.read(temp)) > 0) {  
                    System.arraycopy(temp, 0, data, destPos, readLen);  
                    destPos += readLen;  
                }  
                String result = new String(data, "UTF-8"); // utf-8编码  
                System.out.println(result);  
                return result;  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally{
        	try {
				out.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        return "error"; // 自定义错误信息  
	}
}
