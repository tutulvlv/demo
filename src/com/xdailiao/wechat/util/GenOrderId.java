package com.xdailiao.wechat.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class GenOrderId {
	//生成随机字符串  防重复  防止并发 重现
		public synchronized static String GenString(){
			//随机字符串
			String nonce_str = UUID.randomUUID().toString().replace("-", "");
			//商户订单号
			SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
			Date date = new Date();
			String ymd = sf.format(date);
			long time = date.getTime();
			String oid = String.valueOf(time).substring(2, 12);
			return nonce_str+"_"+ymd+oid;
		}
}
