package com.xdailiao.wechat.pay;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

import com.xdailiao.wechat.entity.PersonCollectionSendBean;
import com.xdailiao.wechat.entity.RedpacketSendbean;
import com.xdailiao.wechat.util.Bean2TextXml;
import com.xdailiao.wechat.util.ClientCustomSSL;
import com.xdailiao.wechat.util.GenOrderId;
import com.xdailiao.wechat.util.Md5Util;
import com.xdailiao.wechat.util.WechatPropertiesUtil;

/**
 * 企业付款业务是基于微信支付商户平台的资金管理能力，协助商户方便地实现企业向个人付款
 * 
 * 未找到开通位置 没测试
 * @author viakiba
 *
 */
public class PersonCollectionUtil {
	/**
	 * 企业付款。。。。
	 * openid 用户的openid  num 金额
	 * @throws ClassNotFoundException 
	 * @throws Exception 
	 * @throws FileNotFoundException 
	 */
	public static String PersonCollectionService(String openid,String name,String num ,String desc) throws ClassNotFoundException, FileNotFoundException, Exception{
		StringBuffer sb = new StringBuffer();
		PersonCollectionSendBean person = new PersonCollectionSendBean();
		String genstr = GenOrderId.GenString();
		String[] temp = genstr.split("_");
		//设置完成 除sign外的所有信息
		person.setMch_appid(WechatPropertiesUtil.getWxappid());
		person.setMchid(WechatPropertiesUtil.getMch_id());
		//设备号  略
		person.setNonce_str(temp[0]);
		//签名 略
		person.setPartner_trade_no(WechatPropertiesUtil.getMch_id()+temp[1]);
		person.setOpenid(openid);
		person.setCheck_name("NO_CHECK");//NO_CHECK：不校验真实姓名  FORCE_CHECK：强校验真实姓名（未实名认证的用户会校验失败，无法转账）  OPTION_CHECK：针对已实名认证的用户才校验真实姓名（未实名认证用户不校验，可以转账成功）
		person.setRe_user_name(name);
		person.setAmount(num);
		person.setDesc(desc);
		person.setSpbill_create_ip(WechatPropertiesUtil.getClient_ip());
		
		//生成sign
		//拿到属性名称  属性值不为空
		Field[] fileds = person.getClass().getDeclaredFields();
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
				method = person.getClass().getMethod("get"+temp[i]);
				value = method.invoke(person);
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
		person.setSign(str);
		str = Bean2TextXml.beantoTextXmlPersonCollection(person);
		return str;
	}
	
	public static void main(String[] args) throws Exception, FileNotFoundException, Exception {
		String personCollectionService = PersonCollectionService("oDGWpvxjuPbJfUBxYXq2a87CsJZQ", "黄鹏", "50",	 "测试");
		String sendtoWecat = ClientCustomSSL.sendtoWecat(personCollectionService,WechatPropertiesUtil.getPayurl());
		System.out.println(sendtoWecat);
		
	}
}
