package com.xdailiao.controller;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taobao.api.ApiException;
import com.xdailiao.dao.UserDao;
import com.xdailiao.entity.Pick;
import com.xdailiao.entity.User;
import com.xdailiao.entity.json.AdminList;
import com.xdailiao.entity.json.UserOrder;
import com.xdailiao.service.RelorderService;
import com.xdailiao.service.UserService;
import com.xdailiao.utils.Paging;
import com.xdailiao.utils.SendMess;
import com.xdailiao.wechat.pay.RedPacketUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserDao userDaoImpl;
	@Resource
	private UserService userServiceImpl;
	@Resource
	private RelorderService relorderServiceImpl;
	@RequestMapping("/register")
	public String addUser(HttpServletRequest request,User user){
		String username = request.getParameter("username");
		String usertel=request.getParameter("usertel");
		User flag = userServiceImpl.getUserByTel(username, usertel);
		if(flag!=null){
			request.setAttribute("error", "用户名和手机号已存在！！！");
			return "error";
		}
		String wcopenid=request.getSession().getAttribute("wcopenid")+"";
		
		System.out.println("session_register##########"+wcopenid);
		
		user.setWcopenid(wcopenid);
		
		userServiceImpl.addUser(user);
		User user2=userServiceImpl.getUserByTel(username, usertel);
		request.getSession().setAttribute("user", user2);
		return "redirect:/user/getUserOrderList.action";
	}
	@RequestMapping("/querykey")
	public String queryKey(HttpServletRequest request){
		
		String username = request.getParameter("username");
		String usertel=request.getParameter("usertel");
		String wcopenid=request.getSession().getAttribute("wcopenid")+"";
		
		System.out.println(wcopenid);
		User user=userServiceImpl.getUserByTel(username, usertel);
		if(user==null){
			request.setAttribute("error", "用户名或手机号错误，请返回重新操作！！！");
			return "error";
		}
		user.setWcopenid(wcopenid);
		userServiceImpl.updateUser(user);
		request.getSession().setAttribute("user",user);
		return "redirect:/user/getUserOrderList.action";
	}
	@RequestMapping("/suborder")
	public String subOrder(HttpServletRequest request){
		String subnum = request.getParameter("subnum");
		String usertel=request.getParameter("usertel");
		int orderitemid=relorderServiceImpl.generateListorder(subnum, usertel);
		if(orderitemid==-1){
			request.setAttribute("error", "手机号或提交码错误，请查询提交码！！！");
			return "error";
		}
		User user=(User)request.getSession().getAttribute("user");
//		if(user.getStatus()>0){
//			try {
//				RedPacketUtil.RedPacketService(user.getWcopenid(), "100");
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			user.setStatus(user.getStatus()-1);
//			System.out.println(user.getStatus()+"status");
//			userServiceImpl.updateUser(user);
//			System.out.println(user);
//		}
		
		AdminList adminList = relorderServiceImpl.getOrderViewByOid(orderitemid).get(0);
		try {
			SendMess.genorder(adminList.getUsername(), usertel, adminList.getOrderitemid(), adminList.getComname());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return "success";
	}
	@RequestMapping("/getAllUser")
	public String getAllUser(HttpServletRequest request){
		String currentPage = request.getParameter("currentPage");
		if(currentPage==null){
			currentPage="1";
		}
		//先拿到总数
		int total = userServiceImpl.getTotalUser();
		Paging pager=new Paging(Integer.valueOf(currentPage),total);
		System.out.println(total);
		//查询
		List<User> userList = userServiceImpl.getAllUser((Integer.valueOf(currentPage)-1)*pager.getPageSize(),pager.getPageSize());
		System.out.println(userList.size());
		request.setAttribute("userList", userList);
		request.setAttribute("pager", pager);
		return "view/backtop/admin_userlist";
	}
	@RequestMapping("/updateUser")
	public String updateUser(HttpServletRequest request,User user){
		String role=request.getParameter("role");
		int flag = userServiceImpl.updateUser(user);
		request.getSession().setAttribute("user",user);
		System.out.println(role+user);
		if("user".equals(role)){
			return "user_setting";
		}
		if(flag == 0){
			return "error";
		}
		return "redirect:/user/getAllUser.action";
	}

	@RequestMapping("/getUserOrderList")
	public String getUserOrderList(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		Integer userid=user.getUserid();
		String currentPage = request.getParameter("currentPage");
		if(currentPage==null){
			currentPage="1";
		}
		int total = userDaoImpl.getUserOrderListNum(userid);
		Paging pager = new Paging(Integer.valueOf(currentPage),total);
		int i = ( ( Integer.valueOf(currentPage) - 1 ) * pager.getPageSize() );//起始行
		List<UserOrder> orderUserList = userServiceImpl.getOrderUserList(userid+"",pager.getPageSize(),i);
		request.setAttribute("pager", pager);
		request.setAttribute("orderList", orderUserList);
		return "user_orderlist";
	}
	//发送手机验证码
//	@RequestMapping("/sendValiCode")
//	@ResponseBody
//	public String sendValiCode(HttpServletRequest request){
//		String usertel = request.getParameter("usertel");
//		int code=(int)((Math.random()*9+1)*100000);
//        final HttpSession session = request.getSession();
//        session.setAttribute("code",code);
//        try {
//            SendMess.sendValiCode(code, usertel);
//            //TimerTask实现5分钟后从session中删除checkCode
//            final Timer timer=new Timer();
//            timer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    session.removeAttribute("code");
//                    System.out.println("code删除成功");
//                    timer.cancel();
//                }
//            },5*60*1000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//		return "success";
//	}
}
