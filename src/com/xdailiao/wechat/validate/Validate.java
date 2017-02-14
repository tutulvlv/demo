package com.xdailiao.wechat.validate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.xdailiao.entity.Clerk;
import com.xdailiao.entity.Pick;
import com.xdailiao.entity.User;
import com.xdailiao.service.AdminService;
import com.xdailiao.service.ClerkService;
import com.xdailiao.service.PickService;
import com.xdailiao.service.UserService;
import com.xdailiao.wechat.util.WcUtils;
import com.xdailiao.wechat.util.WechatPropertiesUtil;

/**
 * 用户进入的验证绑定页面
 * redirect_uri=REDIRECT_URI
 * scope=snsapi_base
 * @author viakiba
 *
 */
@Controller
@RequestMapping("/auth")
public class Validate {
	@Resource
	private ClerkService clerkServiceImpl;
	@Resource
	private PickService pickServiceImpl;
	@Resource
	private UserService userServiceImpl;
	@Resource
	private AdminService adminService;
	
	private static String appid = WechatPropertiesUtil.getWxappid();
	private static String secret=WechatPropertiesUtil.getWxsecret();
	//  private String redirect_uri="REDIRECT_URI";
	private String scope="snsapi_base";
	
	/**
	 * https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx32f1fdf5edf36bfb&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect
	 * 
	 * 通过此链接进入
	 * 
	 * @param CODE
	 */
	
	@RequestMapping("/entranceUser")
	public String authUser(String code,HttpServletRequest request){
		//  https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx32f1fdf5edf36bfb&secret=00331d6bac9330b7d7020fa8eb6e4721&code=CODE&grant_type=authorization_code
		String wcopenid = Validate.getUserInfoAccessToken(code);
		request.getSession().setAttribute("wcopenid",wcopenid);
		System.out.println("code##########va"+code);
		System.out.println("openid********va"+wcopenid);
		User user=userServiceImpl.getUserByOpenid(wcopenid);
		if(user==null){
			return "querykey";
		}
		request.getSession().setAttribute("user",user);
		return "redirect:/user/getUserOrderList.action";
	}


	/**
	 * https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx32f1fdf5edf36bfb&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect
	 * 
	 * 通过此链接进入
	 * 
	 * @param CODE
	 */
	
	@RequestMapping("/entrancePick")
	public String authPick(String code,HttpServletRequest request){
	//  https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx32f1fdf5edf36bfb&secret=00331d6bac9330b7d7020fa8eb6e4721&code=CODE&grant_type=authorization_code
			System.out.println(appid+"<<<>>>>"+secret);
			String wcopenid = Validate.getUserInfoAccessToken(code);
			request.getSession().setAttribute("wcopenid",wcopenid);
			System.out.println("code##########va"+code);
			System.out.println("openid********va"+wcopenid);
			Pick pick=pickServiceImpl.getPickByOpenid(wcopenid);
			if(pick==null){
				return "pickconfirm";
			}
			request.getSession().setAttribute("pickid",pick.getPickid());
			return "redirect:/pick/getPickOrderList.action";
	}
	
	/**
	 * https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx32f1fdf5edf36bfb&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect
	 * 
	 * 通过此链接进入
	 * 
	 * @param CODE
	 */
	
	@RequestMapping("/entranceClerk")
	public String authClerk(String code,HttpServletRequest request){
	//  https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx32f1fdf5edf36bfb&secret=00331d6bac9330b7d7020fa8eb6e4721&code=CODE&grant_type=authorization_code
		String wcopenid = Validate.getUserInfoAccessToken(code);
		request.getSession().setAttribute("wcopenid",wcopenid);
		System.out.println("code##########va"+code);
		System.out.println("openid********va"+wcopenid);
		Clerk clerk=clerkServiceImpl.getClerkByOpenid(wcopenid);
		if(clerk==null){
			return "clerkconfirm";
		}
		request.getSession().setAttribute("clerkid",clerk.getClerkid());
		return "redirect:/clerk/getClerkOrderList.action";
	}
	
	/**
	 * https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx32f1fdf5edf36bfb&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect
	 * 
	 * 通过此链接进入
	 * 
	 * @param CODE
	 */
	
	@RequestMapping("/entranceAdmin")
	public void authAdmin(String CODE){
		//  https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx32f1fdf5edf36bfb&secret=00331d6bac9330b7d7020fa8eb6e4721&code=CODE&grant_type=authorization_code
		String openid = Validate.getUserInfoAccessToken(CODE);
		
	}
	
	public static String getUserInfoAccessToken(String code) {
		String access_token_uri = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code";
        String openid = WcUtils.loadJson(access_token_uri);
        System.out.println(openid);
        /*
         { "access_token":"ACCESS_TOKEN",    
		 "expires_in":7200,    
		 "refresh_token":"REFRESH_TOKEN",    
		 "openid":"OPENID",    
		 "scope":"SCOPE" } 
         */
        Openid parse = JSON.parseObject(openid,Openid.class);
        //拿到id
        openid = parse.getOpenid();
        return openid;
    }
}
