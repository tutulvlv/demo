package com.xdailiao.wechat.entity;

/**
 * 企业付款业务是基于微信支付商户平台的资金管理能力，协助商户方便地实现企业向个人付款
 * 接收实体类
 * @author viakiba
 *
 */
public class PersonCollectionReceiveBean {
	private String return_code;//返回状态码 SUCCESS/FAI 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
	private String return_msg;//返回信息 返回信息，如非空，为错误原因  签名失败  参数格式校验错误
	
	//以下字段在return_code为SUCCESS的时候有返回
	private String mch_appid;//商户appid
	private String mchid;//商户号
	private String device_info;//设备号
	private String nonce_str;//随机字符串
	private String result_code;//业务结果
	private String err_code;//错误代码
	private String err_code_des;//错误代码描述
	
	//以下字段在return_code 和result_code都为SUCCESS的时候有返回
	private String partner_trade_no;//商户订单号，需保持唯一性
	private String payment_no;//企业付款成功，返回的微信订单号
	private String payment_time;//企业付款成功时间
	public String getReturn_code() {
		return return_code;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	public String getReturn_msg() {
		return return_msg;
	}
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}
	public String getMch_appid() {
		return mch_appid;
	}
	public void setMch_appid(String mch_appid) {
		this.mch_appid = mch_appid;
	}
	public String getMchid() {
		return mchid;
	}
	public void setMchid(String mchid) {
		this.mchid = mchid;
	}
	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getErr_code() {
		return err_code;
	}
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	public String getErr_code_des() {
		return err_code_des;
	}
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}
	public String getPartner_trade_no() {
		return partner_trade_no;
	}
	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
	}
	public String getPayment_no() {
		return payment_no;
	}
	public void setPayment_no(String payment_no) {
		this.payment_no = payment_no;
	}
	public String getPayment_time() {
		return payment_time;
	}
	public void setPayment_time(String payment_time) {
		this.payment_time = payment_time;
	}
}
