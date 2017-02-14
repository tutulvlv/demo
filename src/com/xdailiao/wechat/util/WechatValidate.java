package com.xdailiao.wechat.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 微信公众账号的配置确认入口
 * @author viakiba
 *
 */
public class WechatValidate extends HttpServlet {
	/**
	 * 服务器验证
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		/***/
		System.out.println("=================================");
		System.out.println(timestamp);
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");
		String token = "viakiba";
		
		//验证配置
		String signCompar = WechatSha.getSHA1(token, timestamp, nonce);
		
		PrintWriter pw = resp.getWriter();
		
		if(signCompar.equals(signature)){
			pw.print(echostr);
		}
	}
	
	/**
	 * 消息接收
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter pw = resp.getWriter();
		try {
			Map<String, String> map = Xml2Map.Xml2Map(req);
			String result = MessageService.serviceMap(map);
			System.out.println(result);
			pw.write(result);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pw.flush();
			pw.close();
		}
	}
}
