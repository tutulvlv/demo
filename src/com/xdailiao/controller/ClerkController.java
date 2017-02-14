package com.xdailiao.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.taobao.api.ApiException;
import com.xdailiao.entity.Clerk;
import com.xdailiao.entity.Pick;
import com.xdailiao.entity.json.AdminList;
import com.xdailiao.entity.json.ClerkList;
import com.xdailiao.service.ClerkService;
import com.xdailiao.service.RelorderService;
import com.xdailiao.utils.Paging;
import com.xdailiao.utils.SendMess;
import com.xdailiao.utils.Upload;

@Controller
@RequestMapping("/clerk")
public class ClerkController {
	@Resource
	ClerkService clerkServiceImpl;
	@Resource
	RelorderService relorderServiceImpl;
	
	/**
	 * 业务员验证
	 * @param request
	 * @return
	 */
	@RequestMapping("/confirm")
	public String confirm(HttpServletRequest request,Clerk clerk){
		Clerk clerk1=clerkServiceImpl.getClerkidByNameTel(clerk.getClerkname(), clerk.getClerktel());
		System.out.println(clerk1);
		if(clerk1==null){
			request.setAttribute("error", "用户名或手机号错误，请返回重新填写！！！");
			return "error";
		}
		request.getSession().setAttribute("clerkid", clerk1.getClerkid());
		String wcopenid=request.getSession().getAttribute("wcopenid")+"";
		clerk1.setWcopenid(wcopenid);
		clerkServiceImpl.updateClerk(clerk1);
		return "redirect:/clerk/getClerkOrderList.action";
	}
	
	/**
	 * 订单列表  获取业务员
	 * @param request
	 * @return
	 */
	@RequestMapping("/getClerkOrderList")
	public String getClerkOrderList(HttpServletRequest request){
		String clerkid=request.getSession().getAttribute("clerkid")+"";
		System.out.println(clerkid);
		String currentPage = request.getParameter("currentPage");
		if(currentPage==null){
			currentPage="1";
		}
		int total=relorderServiceImpl.getTotalClerkOrderList(Integer.valueOf(clerkid));
		Paging pager=new Paging(Integer.valueOf(currentPage),total);
		List<ClerkList> clerkOrderList = relorderServiceImpl.
				getClerkOrderList(Integer.valueOf(clerkid),(Integer.valueOf(currentPage)-1)*pager.getPageSize(),pager.getPageSize());
		request.getSession().setAttribute("orderList", clerkOrderList);
		request.setAttribute("pager", pager);
		return "clerkorderlist";
	}
	
	/**
	 * 业务员提交验货信息
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping("/clerksub")
	public String clerksub(@RequestParam("orderimg") MultipartFile file,HttpServletRequest request){

		String orderitemid = request.getParameter("orderitemid");
		String price = request.getParameter("price");
		String weight = request.getParameter("weight");
		String quantity = request.getParameter("quantity");
		String indet = request.getParameter("indet");
		long date=new Date().getTime();
		Map map = new HashMap();
		map.put("orderitemid", orderitemid);
		map.put("orderimg",date+"_"+file.getOriginalFilename());
		map.put("price", price);
		map.put("weight", weight);
		map.put("indet", indet);
		map.put("quantity", quantity);
		System.out.println(map);
		try {
			Upload.uploadImage(request,file, date);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		relorderServiceImpl.putClerkInsres(map);
		AdminList orderView = relorderServiceImpl.getOrderViewByOid(Integer.valueOf(orderitemid)).get(0);
		try {
			SendMess.insgood(orderView.getUsertel(), orderitemid, weight, quantity, price, orderView.getClerkname());
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
	
	/**
	 * 获取业务员的列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/getAll")
	public String getAllPick(HttpServletRequest request){
		List<Clerk> clerkList = clerkServiceImpl.getAllClerk();
		request.setAttribute("clerkList", clerkList);
		return "view/backtop/admin_clerklist";
	}
	
	
	
	
	
	/**
	 * 更新业务员
	 * @param clerk
	 * @param models
	 * @return
	 */
	@RequestMapping("/updateClerk")
	public String updateClerk(Clerk clerk,Model models){
		int flag = clerkServiceImpl.updateClerk(clerk);
		if(flag == 0){
			return "error";
		}
		return "redirect:/clerk/getAll.action";
	}
	
	
	/**
	 * 新增业务员
	 * @param clerk
	 * @param models
	 * @return
	 */
	@RequestMapping("/insertClerk")
	public String insertClerk(Clerk clerk,Model models){
		int flag = clerkServiceImpl.insertClerk(clerk);
		if(flag == 0){
			return "error";
		}
		return "redirect:/clerk/getAll.action";
	}
}
