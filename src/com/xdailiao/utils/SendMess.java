package com.xdailiao.utils ;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * 短信发送 utils
 * 
 * 客户：
 * 	下单     验货   取货   付款
 * 业务员：
 * 	分配
 * 取货人：
 * 	给业务员
 * 运营：
 * 	田姐：		                入库 付款
 * 	何姐：下单   验货   取货  入库  付款
 * 
 * @author viakiba
 *
 */
public class SendMess {
	public static final String secret="da24075f00511eadda870ddf22dca3e2";
	public static final String appkey = "23497608";
//	public static final String appkey = "";
	public static final String url = "http://gw.api.taobao.com/router/rest";
	
	/*public static void main(String[] args) throws ApiException {
		//SendMess send = new SendMess();
		//send.genorder("黄鹏", "18037650338", "sdasda", "张江");
		//send.genorder("黄鹏", "18037650338", "sdasda", "");
		////send.alottClerk("黄鹏", "18037650338", "sadsad", "18037650338");
		////send.insgood("18037650338", "sdad", "50", "110", "5556", "张江");
		////send.pick("dasd", "黄鹏", "18037650338", "12", "18037650338");
		////send.pickgood("adsd", "黄鹏", "18037650338", "50");
		////send.operate("sdasd", "12-56-24");
		////send.pay("sda", "15-56-54", "150");
	}*/
	
	/**
	 * 客户订单生成 短信通知
	 * 【小呆料】单号sdasda，客户名：黄鹏*张江， 联系方式：18037650338，请于4小时内分配人员和客户取得联系
	 * 【小呆料】已收到单号sdasda的废料|呆料回收申请，服务人员将于24小时内和您取得联系，谢谢
	 * 
	 * 运营：【小呆料】单号sdasda，客户名：黄鹏， 联系方式：18037650338，请于4小时内分配人员和客户取得联系
	 * 客户：【小呆料】已收到单号sdasda的废料|呆料回收申请，服务人员将于24小时内和您取得联系，谢谢
	 * @param username
	 * @param usertel
	 * @param orderid
	 * @throws ApiException
	 */
	public static void genorder(String username,String usertel,int orderid,String comname) throws ApiException{
		//客户
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend( "" );
		req.setSmsType( "normal" );
		req.setSmsFreeSignName( "小呆料" );
		req.setSmsParamString( "{od:'"+orderid+"'}" );
		req.setRecNum( usertel );
		req.setSmsTemplateCode( "SMS_25490096" );
		AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
		
		if(comname == "" || comname == null ){//
			//运营   暂时
			req.setExtend( "" );
			req.setSmsType( "normal" );
			req.setSmsFreeSignName( "小呆料" );
			req.setSmsParamString( "{od:'"+orderid+"',ud:'"+username+"',ut:'"+usertel+"'}" );
			req.setRecNum( "18611727392" );//何姐  18611727392
			req.setSmsTemplateCode( "SMS_25515104" );
			rsp = client.execute(req);
			System.out.println(rsp.getBody());
		}else{
			req.setExtend( "" );
			req.setSmsType( "normal" );
			req.setSmsFreeSignName( "小呆料" );
			req.setSmsParamString( "{od:'"+orderid+"',ud:'"+username+"*"+comname+"',ut:'"+usertel+"'}" );
			req.setRecNum( "18611727392" );//何姐  18611727392
			req.setSmsTemplateCode( "SMS_25515104" );
			rsp = client.execute(req);
			System.out.println(rsp.getBody());
		}
	}
	
	/**
	 * 运营分配业务员后，通知业务员
	 * 【小呆料】单号sadsad，黄鹏 联系方式：18037650338，请于12小时内和客户取得联系
	 * @param username
	 * @param usertel
	 * @param orderid
	 * @param clerktel
	 * @throws ApiException
	 */
	public static void alottClerk(String username,String usertel,String orderid,String clerktel) throws ApiException{
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend( "" );
		req.setSmsType( "normal" );
		req.setSmsFreeSignName( "小呆料" );
		req.setSmsParamString( "{od:'"+orderid+"',ud:'"+username+"',ut:'"+usertel+"'}" );
		req.setRecNum( clerktel );
		req.setSmsTemplateCode( "SMS_25330004" );
		AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
	}
	
	/**
	 * 验货环节  通知运营和用户
	 * 		运营：【小呆料】单号sdad由张江已完成上门确认，总重量为50kg，箱子数量110个，价格5556元，请安排司机上门取货
	 * 		客户：【小呆料】已确认单号sdad的回收总重量50kg，箱子数量110个，价格5556元，如有疑问请致电01082755299，谢谢
	 * 
	 * @param usertel
	 * @param orderid
	 * @param weight
	 * @param num
	 * @param price
	 * @param clerkname
	 * @throws ApiException
	 */
	public static void insgood(String usertel,String orderid,String weight,String num,String price,String clerkname) throws ApiException{
		//客户
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend( "" );
		req.setSmsType( "normal" );
		req.setSmsFreeSignName( "小呆料" );
		req.setSmsParamString( "{od:'"+orderid+"',w:'"+weight+"',num:'"+num+"',p:'"+price+"'}" );
		req.setRecNum( usertel );
		req.setSmsTemplateCode( "SMS_25325066" );
		AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
		
		//运营
		req.setExtend( "" );
		req.setSmsType( "normal" );
		req.setSmsFreeSignName( "小呆料" );
		req.setSmsParamString( "{od:'"+orderid+"',cn:'"+clerkname+"',w:'"+weight+"',num:'"+num+"',p:'"+price+"'}" );
		req.setRecNum( "18611727392" );//何姐  18611727392  田姐  13811093065
		req.setSmsTemplateCode( "SMS_25530022" );
		rsp = client.execute(req);
		System.out.println(rsp.getBody());
	}
	
	/**
	 * 通知司机取货
	 * 
	 * picktel=clerktel  暂时
	 * 
	 * @param orderid
	 * @param username
	 * @param usertel
	 * @param num
	 * @param picktel
	 * @throws ApiException
	 */
	public static void pick(String orderid,String username,String usertel,Integer num,String picktel) throws ApiException{
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
								
		//司机
		req.setExtend( "" );
		req.setSmsType( "normal" );
		req.setSmsFreeSignName( "小呆料" );
		req.setSmsParamString( "{od:'"+orderid+"',ud:'"+username+"',ut:'"+usertel+"',num:'"+num+"'}" );
		req.setRecNum( picktel );//何姐  18611727392   田姐  13811093065
		req.setSmsTemplateCode( "SMS_25515105" );
		AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());	
	}
	
	/**
	 * 取货环节  通知用户 货已经取走
	 * 		客户：【小呆料】单号adsd已完成取货，箱子数量50个，回收款将于72小时内汇入您指定银行账户，谢谢
	 * 
	 * @param orderid
	 * @param username
	 * @param usertel
	 * @param num
	 * @param picktel
	 * @throws ApiException
	 */
	public static void pickgood(String orderid,String username,String usertel,Integer num) throws ApiException{
		//客户
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend( "" );
		req.setSmsType( "normal" );
		req.setSmsFreeSignName( "小呆料" );
		req.setSmsParamString( "{od:'"+orderid+"',num:'"+num+"'}" );
		req.setRecNum( usertel );
		req.setSmsTemplateCode( "SMS_25390019" );
		AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
	}
	
	/**
	 * 运营   入库提示付款
	 * 【小呆料】单号sdasd已完成入库，请于12-56-24日前完成汇款
	 * 
	 * @param orderid
	 * @param date
	 * @throws ApiException
	 */
	public static void operate(String orderid,String date) throws ApiException{
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
								
		//运营
		req.setExtend( "" );
		req.setSmsType( "normal" );
		req.setSmsFreeSignName( "小呆料" );
		req.setSmsParamString( "{od:'"+orderid+"',date:'"+date+"'}" );
		req.setRecNum( "18611727392,13811093065" );//何姐  18611727392  田姐  13811093065
		req.setSmsTemplateCode( "SMS_25415021" );
		AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());	
	}
	
	/**
	 * 运营付款，通知客户
	 * 【小呆料】找芯片网（北京）科技有限公司于15-56-54向您指定的银行账户存入单号sda的回收款150元，谢谢
	 * 
	 * @param orderid
	 * @param date
	 * @param price
	 * @throws ApiException
	 */
	public static void pay(String orderid,String date,Double price,String usertel) throws ApiException{
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
								
		//客户
		req.setExtend( "" );
		req.setSmsType( "normal" );
		req.setSmsFreeSignName( "小呆料" );
		req.setSmsParamString( "{od:'"+orderid+"',date:'"+date+"',p:'"+price+"'}" );
		req.setRecNum(usertel);//何姐  18611727392  田姐  13811093065
		req.setSmsTemplateCode( "SMS_25485038" );
		AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());	
	}
	public static void sendValiCode(int code,String usertel) throws ApiException{
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
								
		//客户
		req.setExtend( "" );
		req.setSmsType( "normal" );
		req.setSmsFreeSignName( "小呆料" );
//		req.setSmsParamString( "{od:'"+orderid+"',date:'"+date+"',p:'"+price+"'}" );
		req.setRecNum(usertel);//何姐  18611727392  田姐  13811093065
		req.setSmsTemplateCode( "SMS_25485038" );
		AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());	
	}
}
