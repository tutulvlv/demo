package com.xdailiao.wechat.util;

import java.util.Date;
import java.util.Map;

/**
 * 微信消息回复
 * @author viakiba
 *
 */
public class MessageService {
	
	//  三个事件  文本消息  事件消息   关注消息
	public static String serviceMap(Map<String,String> map){
		String MsgType = map.get("MsgType");
		String result = null;
		TextMessageBean mtb = new TextMessageBean();
		
		switch(MsgType){	
			//文本消息
			case "text":
				mtb = textResult(map);
				break;
			case "event":
				mtb = eventResult(map);
				break;
			default :
				mtb = textResult(map);
				break;
		} 
		
		result = Bean2TextXml.beantoTextXml(mtb);
		
		return result;
	}
	
	public static TextMessageBean eventResult(Map<String,String> map){
		TextMessageBean mtb = new TextMessageBean();
		String event = map.get("Event");
		switch(event){	
		//文本消息
		case "subscribe":
			mtb = textResult(map);
			break;
		case "CLICK":
			mtb = clikResult(map);
			break;
		default :
			mtb = textResult(map);
			break;
		}
		
		return mtb;
	}
	
	
	/*
	 点击回复消息
	 <xml>
		<ToUserName><![CDATA[toUser]]></ToUserName>
		<FromUserName><![CDATA[FromUser]]></FromUserName>
		<CreateTime>123456789</CreateTime>
		<MsgType><![CDATA[event]]></MsgType>
		<Event><![CDATA[CLICK]]></Event>
		<EventKey><![CDATA[EVENTKEY]]></EventKey>
	 </xml>
	 */
	public static TextMessageBean clikResult(Map<String,String> map){
		TextMessageBean mtb = new TextMessageBean();
		
		mtb.setToUserName(map.get("FromUserName"));
		mtb.setFromUserName(map.get("ToUserName"));
		mtb.setCreateTime((new Date()).getTime());
		mtb.setMsgId(map.get("MsgId"));
		mtb.setMsgType("text");
		mtb.setContent("客服：\n木香微信：\n1356610  \n手机：\n13911281198");//这里写回复消息
		
		return mtb;
	}
	
	public static TextMessageBean textResult(Map<String,String> map){
		TextMessageBean mtb = new TextMessageBean();
		mtb.setToUserName(map.get("FromUserName"));
		mtb.setFromUserName(map.get("ToUserName"));
		mtb.setCreateTime((new Date()).getTime());
		mtb.setMsgId(map.get("MsgId"));
		mtb.setMsgType("text");
		if(map.get("MsgType").equals("text")){
			if(map.get("Content").equals("锡渣")){
				mtb.setContent(" 锡渣用量频率登记表：\nhttps://jinshuju.net/f/BoxS9X \n\n料盘/锡渣/废料封箱照片: https://jinshuju.net/f/22GDdx \n\n填写客户银行卡号：https://jinshuju.net/f/LhsX8S ");//这里写回复消息     这里可以实现关键字回复
			}else if(map.get("Content").equals("业务")){
				mtb.setContent("业务     http://wechat.xdailiao.com/demo/clerkconfirm.jsp");//这里写回复消息     这里可以实现关键字回复
			}else if(map.get("Content").equals("xdailiao_list_admin")){
				mtb.setContent("管理员管理页面，请注意保存不要泄露：\nhttp://wechat.xdailiao.com/demo/admin/adminlist.action");//这里写回复消息     这里可以实现关键字回复
			}else if(map.get("Content").equals("客户")){
				mtb.setContent("客户：\n订单生成：  \nhttp://wechat.xdailiao.com/demo/suborder.jsp  \n\n客户注册：  http://wechat.xdailiao.com/demo/register.jsp \n\n提交码查询：  http://wechat.xdailiao.com/demo/querykey.jsp");//这里写回复消息     这里可以实现关键字回复
			}else if(map.get("Content").equals("取货")){
				mtb.setContent("取货人:\n取货   \n\nhttp://wechat.xdailiao.com/demo/pickconfirm.jsp \n\n取货人 金数据 https://jinshuju.net/f/ovZfsn");//这里写回复消息     这里可以实现关键字回复
			}else if(map.get("Content").equals("admin_message")){
				mtb.setContent("短信备用系统： \nhttp://wechat.xdailiao.com/messerver/index.jsp");//这里写回复消息     这里可以实现关键字回复
			}else if(map.get("Content").equals("收料")){
				mtb.setContent("客户：	\n\n订单生成：    \nhttp://wechat.xdailiao.com/demo/suborder.jsp	\n\n客户注册：    \nhttp://wechat.xdailiao.com/demo/register.jsp	\n\n提交码查询：  http://wechat.xdailiao.com/demo/querykey.jsp \n业务员： \n http://wechat.xdailiao.com/demo/clerkconfirm.jsp \n取货人: \n取货：   http://wechat.xdailiao.com/demo/pickconfirm.jsp \n金数据：https://jinshuju.net/f/ovZfsn");//这里写回复消息     这里可以实现关键字回复
			}else{
				mtb.setContent("暂不支持此回复");//这里写回复消息     这里可以实现关键字回复
			}
		}else if("subscribe".equals(map.get("Event"))){
			mtb.setContent("啊哈，你的废料、呆滞料就交给小呆帮你处理吧[憨笑]");//这里是头次关注推送的消息
		}else{
			mtb.setContent("");//这里写回复消息
		}
		return mtb;
	}
	
}
