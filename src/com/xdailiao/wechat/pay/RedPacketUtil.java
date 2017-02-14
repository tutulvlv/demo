package com.xdailiao.wechat.pay;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.xdailiao.wechat.entity.RedpacketSendbean;
import com.xdailiao.wechat.util.Bean2TextXml;
import com.xdailiao.wechat.util.ClientCustomSSL;
import com.xdailiao.wechat.util.GenOrderId;
import com.xdailiao.wechat.util.Md5Util;
import com.xdailiao.wechat.util.WechatPropertiesUtil;

@Repository
public class RedPacketUtil {
	
	/**
	 * 
	 * openid 用户的openid  num 红包金额
	 * @throws ClassNotFoundException 
	 * @throws Exception 
	 * @throws FileNotFoundException 
	 */
	public static String RedPacketService(String openid,String num ) throws ClassNotFoundException, FileNotFoundException, Exception{
		StringBuffer sb = new StringBuffer();
		RedpacketSendbean redpack = new RedpacketSendbean();
		String genstr = GenOrderId.GenString();
		String[] temp = genstr.split("_");
		System.out.println(temp[1]);
		//设置完成 除sign外的所有信息
		redpack.setNonce_str(temp[0]);
		redpack.setMch_billno(WechatPropertiesUtil.getMch_id()+temp[1]);
		System.out.println((WechatPropertiesUtil.getMch_id()+temp[1]).length());
		redpack.setMch_id(WechatPropertiesUtil.getMch_id());
		redpack.setWxappid(WechatPropertiesUtil.getWxappid());
		redpack.setSend_name(WechatPropertiesUtil.getSend_name());
		redpack.setRe_openid(openid);
		redpack.setTotal_amount(num);
		redpack.setTotal_num(WechatPropertiesUtil.getTotal_num());
		redpack.setWishing(WechatPropertiesUtil.getWishing());
		redpack.setClient_ip(WechatPropertiesUtil.getClient_ip());
		redpack.setAct_name(WechatPropertiesUtil.getAct_name());
		redpack.setRemark(WechatPropertiesUtil.getRemark());
		
		//生成sign
		//拿到属性名称  属性值不为空
		Field[] fileds = redpack.getClass().getDeclaredFields();
		temp = new String[fileds.length];
		for(int i=0;i<fileds.length;i++){
			temp[i] = fileds[i].getName();
		}
		//进行名称排序
		Arrays.sort(temp);
		//获取value 并进行 字符串拼接
		for(int i=0;i<temp.length;i++){
			Method method = null;
			Object value = null;
			try{
				temp[i] = temp[i].substring(0, 1).toUpperCase()+temp[i].substring(1);
				method = redpack.getClass().getMethod("get"+temp[i]);
				value = method.invoke(redpack);
				if(value != null & value != null){
					sb.append(temp[i].toLowerCase()+"="+value+"&");
				}
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("setter和getter 异常");
			}
		}
		String str = sb.toString().substring(0, sb.toString().length()-1);
		str = Md5Util.GenMd5(str+"&key="+WechatPropertiesUtil.getPaykey()).toUpperCase();
		redpack.setSign(str);
		str = Bean2TextXml.beantoTextXmlRead(redpack);
		return str;
	}
	
	
	/**
	 * 使用流程  num 以分为单位
	 * @param args
	 * @throws Exception
	 * @throws FileNotFoundException
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception, FileNotFoundException, Exception {
		String personCollectionService = RedPacketService("oDGWpvxjuPbJfUBxYXq2a87CsJZQ",  "150");
		String sendtoWecat = ClientCustomSSL.sendtoWecat(personCollectionService,WechatPropertiesUtil.getSendredurl());
		System.out.println(sendtoWecat);
		
	}
}
