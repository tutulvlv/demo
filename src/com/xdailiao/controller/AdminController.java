package com.xdailiao.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taobao.api.ApiException;
import com.xdailiao.entity.Admin;
import com.xdailiao.entity.Clerk;
import com.xdailiao.entity.Pick;
import com.xdailiao.entity.json.AdminList;
import com.xdailiao.service.AdminService;
import com.xdailiao.service.ClerkService;
import com.xdailiao.service.PickService;
import com.xdailiao.service.RelorderService;
import com.xdailiao.utils.Paging;
import com.xdailiao.utils.SendMess;
import com.xdailiao.utils.Upload;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource
	private ClerkService clerkServiceImpl;
	@Resource
	private PickService pickServiceImpl;
	@Resource
	private RelorderService relorderServiceImpl;
	@Resource
	private AdminService adminService;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request){
		String admin_name = request.getParameter("admin_name").trim();
		String admin_pwd = request.getParameter("admin_pwd").trim();
		
		Admin re = adminService.getAdmin(admin_name, admin_pwd);
		if(re!=null){
			System.out.println(re);
			Admin admin=new Admin();
			admin.setLogin_time(new Timestamp(new Date().getTime()));
			admin.setAdmin_id(re.getAdmin_id());
			adminService.updateAdmin(admin);
			request.getSession().setAttribute("admin", re);
			return "redirect:/admin/adminlist.action";
		}
		System.out.println(re);
		return "view/backtop/admin_login";
	}
	
	@RequestMapping("/adminlist")
	public String adminlist(HttpServletRequest request){
		String currentPage = request.getParameter("currentPage");
		if(currentPage==null){
			currentPage="1";
		}
		int total=relorderServiceImpl.getTotalAdminList();
		Paging pager=new Paging(Integer.valueOf(currentPage),total);
		Map map=new HashMap();
		map.put("start", (Integer.valueOf(currentPage)-1)*pager.getPageSize());
		map.put("pageSize", pager.getPageSize());
		List<AdminList> orderList = relorderServiceImpl.getAllAdminList(map);
		List<Clerk> clerkList = clerkServiceImpl.getAllClerk();
		//兼容分页    viakiba
		Map mappage = new HashMap();
		mappage.put("start", 0);
		mappage.put("pageSize", 1000);
		List<Pick> pickList = pickServiceImpl.getAllPick(mappage);
		request.setAttribute("orderList", orderList);
		request.setAttribute("clerkList", clerkList);
		request.setAttribute("pickList", pickList);
		request.setAttribute("pager", pager);
		return "view/backtop/admin_orderlist";
	}
	
	@RequestMapping("/getOrderListByCom")
	public String getOrderListByCom(HttpServletRequest request){
		String currentPage = request.getParameter("currentPage");
		String re_comname = request.getParameter("comname");
		Object se_comname=request.getSession().getAttribute("comname");
		String comname=null;
		if(re_comname!=null){
			comname=re_comname;
			request.getSession().setAttribute("comname", comname);
		}else{
			comname=se_comname.toString();
		}
				
		if(currentPage==null){
			currentPage="1";
		}
		int total=relorderServiceImpl.getTotalOrderListByCom(comname);
		Paging pager=new Paging(Integer.valueOf(currentPage),total);
		List<AdminList> orderList = relorderServiceImpl.getOrderListByCom(comname, pager.getStart(), pager.getPageSize());
		List<Clerk> clerkList = clerkServiceImpl.getAllClerk();
		//兼容分页    viakiba
		Map mappage = new HashMap();
		mappage.put("start", 0);
		mappage.put("pageSize", 1000);
		List<Pick> pickList = pickServiceImpl.getAllPick(mappage);
		request.setAttribute("orderList", orderList);
		request.setAttribute("clerkList", clerkList);
		request.setAttribute("pickList", pickList);
		request.setAttribute("pager", pager);
		return "view/backtop/search_orderlist";
	}
	
	@RequestMapping("/setClerk")
	@ResponseBody
	public String setClerk(HttpServletRequest request){
		String orderitemid=request.getParameter("orderitemid");
		String clerkid=request.getParameter("clerkid");
		System.out.println(orderitemid);
		System.out.println(clerkid);
		String re = relorderServiceImpl.allotClerk(Integer.valueOf(orderitemid), Integer.valueOf(clerkid));
		AdminList adminList = relorderServiceImpl.getOrderViewByOid(Integer.valueOf(orderitemid)).get(0);
		if(clerkid!="0"){
			try {
				SendMess.alottClerk(adminList.getUsername(), adminList.getUsertel(), orderitemid, adminList.getClerktel());
			} catch (ApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		System.out.println("分配业务员结果："+re);
		return re;
	}
	@RequestMapping("/setPick")
	@ResponseBody
	public String setPick(HttpServletRequest request){
		String orderitemid=request.getParameter("orderitemid");
		String pickid=request.getParameter("pickid");
		String re = relorderServiceImpl.allotPick(Integer.valueOf(orderitemid), Integer.valueOf(pickid));
		AdminList adminList = relorderServiceImpl.getOrderViewByOid(Integer.valueOf(orderitemid)).get(0);
		try {
			SendMess.pick(orderitemid,adminList.getUsername() , adminList.getUsertel(), adminList.getQuantity(),adminList.getPicktel());
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("分配业务员结果："+re);
		return re;
	}
	/**
	 * 入库提交
	 * @param request
	 * @return
	 */
	@RequestMapping("/setPut")
	public String setPutStatus(@RequestParam("putimg") MultipartFile file,HttpServletRequest request){
		String orderitemid = request.getParameter("orderitemid");
		String putdet = request.getParameter("putdet").trim();
		
		Map newmap = new HashMap();
		long date=new Date().getTime();
		
		newmap.put("orderitemid", orderitemid);
		newmap.put("putimg",date+"_"+file.getOriginalFilename());
		newmap.put("putdet", putdet);
		System.out.println(newmap);
		try {
			Upload.uploadImage(request,file, date);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		relorderServiceImpl.putAdminres(newmap);
		return "redirect:/admin/adminlist.action";
	}
	
	/**
	 * 订单完成付款
	 * @param request
	 * @return
	 */
	@RequestMapping("/setPay")
	@ResponseBody
	public String setPayStatus(HttpServletRequest request){
		String orderitemid = request.getParameter("orderitemid");
		int re = relorderServiceImpl.setPay(Integer.valueOf(orderitemid));
		AdminList orderView = relorderServiceImpl.getOrderViewByOid(Integer.valueOf(orderitemid)).get(0);
		Calendar now=Calendar.getInstance();
		try {
			SendMess.pay(orderitemid,now.get(Calendar.YEAR)+"年"+(now.get(Calendar.MONTH)+1)+"月"+now.get(Calendar.DAY_OF_MONTH)+"日", orderView.getPrice(),orderView.getUsertel());
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("付款结果："+re);
		return "success";
	}
	
	@RequestMapping("/deleteOrder")
	@ResponseBody
	public String deleteOrder(HttpServletRequest request){
		String orderitemid = request.getParameter("orderitemid");
		return relorderServiceImpl.deleteOrder(Integer.valueOf(orderitemid));
	}
	
	@RequestMapping("/showAdminList")
	public String showAdminList(HttpServletRequest request){
		List<Admin> adminList = adminService.getAllAdmin();
		request.getSession().setAttribute("adminList", adminList);
		return "view/backtop/admin_adminlist";
	}
	@RequestMapping("/updateAdmin")
	public String updateAdmin(Model model,Admin admin){
		model.addAttribute("admin", admin);
		adminService.updateAdmin(admin);
		return "redirect:/admin/showAdminList.action";
	}
	@RequestMapping("/deleteAdmin")
	public String deleteAdmin(HttpServletRequest request){
		String admin_id=request.getParameter("admin_id");
		adminService.deleteAmdin(admin_id);
		return "redirect:/admin/showAdminList.action";
	}
	@RequestMapping("/addAdmin")
	public String addAdmin(Admin admin){
//		model.addAttribute("admin", admin);
		adminService.addAdmin(admin);
		return "redirect:/admin/showAdminList.action";
	}
}