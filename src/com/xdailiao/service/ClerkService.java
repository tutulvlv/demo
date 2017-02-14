package com.xdailiao.service;

import java.util.List;
import java.util.Map;

import com.xdailiao.entity.Clerk;

/**
 * 业务员  service 层  主要处理
 * 		验证业务员
 * 		获取业务员列表
 * @author viakiba
 *
 */
public interface ClerkService {
	/*//验证业务员
	public String confirmClerk(Clerk clerk);*/
	
	/**
	 * 获取业务员的列表
	 * @return
	 */
	public List<Clerk> getAllClerk();
	
	//获取业务员ID通过名字手机
	public Clerk getClerkidByNameTel(String clerkname,String clerktel);
	
	/**
	 * 新增业务员
	 * @param clerk
	 * @return
	 */
	public int insertClerk(Clerk clerk );
	
	/**
	 * 更新业务员
	 * @param clerk
	 * @return
	 */
	public int updateClerk(Clerk clerk );
	
	Clerk getClerkByOpenid(String wciopenid);
}
