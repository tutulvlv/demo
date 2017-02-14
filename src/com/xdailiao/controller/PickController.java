package com.xdailiao.controller;

import java.io.IOException;
import java.util.Calendar;
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
import com.xdailiao.entity.Pick;
import com.xdailiao.entity.json.AdminList;
import com.xdailiao.entity.json.PickList;
import com.xdailiao.service.PickService;
import com.xdailiao.service.RelorderService;
import com.xdailiao.utils.Paging;
import com.xdailiao.utils.SendMess;
import com.xdailiao.utils.Upload;

@Controller
@RequestMapping("/pick")
public class PickController {
	@Resource
	PickService pickServiceImpl;
	@Resource
	RelorderService relorderServiceImpl;
	
	/**
	 * 取货人认证
	 * @param request
	 * @return
	 */
	@RequestMapping("/confirm")
	public String confirm(HttpServletRequest request,Pick pick){
		Integer pickid=pickServiceImpl.getPickId(pick.getPickname(), pick.getPicktel());
		if(pickid==null){
			request.setAttribute("error", "用户名或手机号错误，请返回重新操作！！！");
			return "error";
		}
		request.getSession().setAttribute("pickid", pickid);
		String wcopenid=request.getSession().getAttribute("wcopenid")+"";
		pick.setWcopenid(wcopenid);
		pick.setPickid(pickid);
		System.out.println(pick);
		pickServiceImpl.updatePick(pick);
		return "redirect:/pick/getPickOrderList.action";
	}
	
	/**
	 * 获取取货人列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/getPickOrderList")
	public String getPickOrderList(HttpServletRequest request){
		String pickid=request.getSession().getAttribute("pickid")+"";
		String currentPage = request.getParameter("currentPage");
		if(currentPage==null){
			currentPage="1";
		}
		int total=relorderServiceImpl.getTotalPickOrderList(Integer.valueOf(pickid));
		Paging pager=new Paging(Integer.valueOf(currentPage),total);
		List<PickList> pickOrderList = relorderServiceImpl.getPickOrderList(Integer.valueOf(pickid),(Integer.valueOf(currentPage)-1)*pager.getPageSize(),pager.getPageSize());
		request.setAttribute("orderList", pickOrderList);
		request.setAttribute("pager", pager);
		return "pickorderlist";
	}
	
	/**
	 * 取货人提交照片
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping("/picksub")
	public String picksub(@RequestParam("pickimg") MultipartFile file,HttpServletRequest request){

		String orderitemid = request.getParameter("orderitemid");
		long date=new Date().getTime();
		Map map = new HashMap();
		map.put("orderitemid", orderitemid);
		map.put("pickimg",date+"_"+file.getOriginalFilename());
		System.out.println(map);
		try {
			Upload.uploadImage(request,file, date);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		relorderServiceImpl.putPickInsres(map);
		AdminList orderView = relorderServiceImpl.getOrderViewByOid(Integer.valueOf(orderitemid)).get(0);
		try {
			SendMess.pickgood(orderitemid, orderView.getUsername(), orderView.getUsertel(), orderView.getQuantity());
			Date date1=new Date();
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(date1);
			calendar.add(Calendar.DAY_OF_MONTH,+2);
			date1=calendar.getTime();
			SendMess.operate(orderitemid,calendar.get(Calendar.YEAR)+"年"+(calendar.get(Calendar.MONTH)+1)+"月"+calendar.get(Calendar.DAY_OF_MONTH));
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 获取取货人的列表   分页
	 * @param request
	 * @return
	 */
	@RequestMapping("/getAll")
	public String getAllPick(HttpServletRequest request){
		Map map = new HashMap();
		
		String currentPage = request.getParameter("currentPage");
		if(currentPage==null){
			currentPage="1";
		}
		
		//先拿到总数
		int total = pickServiceImpl.getTotalPick();
		//System.out.println(total+"============================================");
		Paging pager=new Paging(Integer.valueOf(currentPage),total);
		
		//计算开始行  与 取得数量
		int i=(Integer.valueOf(currentPage)-1)*pager.getPageSize();
		map.put("start",i );
		map.put("pageSize", pager.getPageSize());
		
		//查询
		List<Pick> pickList = pickServiceImpl.getAllPick(map);
		
		
		request.setAttribute("pickList", pickList);
		request.setAttribute("pager", pager);
		return "view/backtop/admin_picklist";
	}
	
	/**
	 * 更新取货人
	 * @param pick
	 * @param model
	 * @return
	 */
	@RequestMapping("/updatePick")
	public String updatePick(Pick pick,Model model){
		int flag = pickServiceImpl.updatePick(pick);
		if(flag == 0){
			return "error";
		}
		return "redirect:/pick/getAll.action";
	}
	
	/**
	 * 新增取货人
	 * @param pick
	 * @param model
	 * @return
	 */
	@RequestMapping("/insertPick")
	public String insertPick(Pick pick,Model model){
		int flag = pickServiceImpl.insertPick(pick);
		if(flag == 0){
			return "error";
		}
		return "redirect:/pick/getAll.action";
	}
	
	
}