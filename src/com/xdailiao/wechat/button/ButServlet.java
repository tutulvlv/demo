package com.xdailiao.wechat.button;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public class ButServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String button = request.getParameter("button");
		System.out.println(button);
		
		//拿到accesstoken
		String accesstoken = Wcbutton.getAccesstoken();
		//执行删除操作
		//String deleteMes = Wcbutton.deleteBut(accesstoken);
		//创建新的按钮
		String createMes = Wcbutton.createBut(button,accesstoken);
		
//		Map delMes = JSON.parseObject(deleteMes, Map.class);
		Map creMes = JSON.parseObject(createMes, Map.class);
		System.out.println(createMes);
		if(((String) creMes.get("errmsg")).equalsIgnoreCase("ok") ){
			response.sendRedirect(request.getContextPath()+"/success.jsp");
		}else{
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		}
		
		response.sendRedirect(request.getContextPath()+"/success.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
