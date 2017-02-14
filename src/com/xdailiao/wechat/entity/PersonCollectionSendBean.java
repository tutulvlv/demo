package com.xdailiao.wechat.entity;

/**
 * 企业付款业务是基于微信支付商户平台的资金管理能力，协助商户方便地实现企业向个人付款
 * 发送实体类
 * @author viakiba
 *
 */
public class PersonCollectionSendBean {
	private String nonce_str;//随机字符串 1
	private String sign;//签名 1
	private String partner_trade_no;//商户订单号 1
	private String mchid ;//商户号 1
	private String mch_appid;//公众账号appid 1
	private String openid;//用户openid 1
	private String check_name;//校验用户姓名选项 1
	private String re_user_name;//收款用户姓名 1
	private String amount;//付款金额 1
	private String spbill_create_ip;//Ip地址 1
	private String desc;//描述 1
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getPartner_trade_no() {
		return partner_trade_no;
	}
	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
	}
	public String getMchid() {
		return mchid;
	}
	public void setMchid(String mchid) {
		this.mchid = mchid;
	}
	public String getMch_appid() {
		return mch_appid;
	}
	public void setMch_appid(String mch_appid) {
		this.mch_appid = mch_appid;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getCheck_name() {
		return check_name;
	}
	public void setCheck_name(String check_name) {
		this.check_name = check_name;
	}
	public String getRe_user_name() {
		return re_user_name;
	}
	public void setRe_user_name(String re_user_name) {
		this.re_user_name = re_user_name;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
