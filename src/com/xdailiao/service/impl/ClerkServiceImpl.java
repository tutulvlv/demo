package com.xdailiao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xdailiao.dao.ClerkDao;
import com.xdailiao.entity.Clerk;
import com.xdailiao.service.ClerkService;
@Service
public class ClerkServiceImpl implements ClerkService{
	@Resource
	private ClerkDao clerkDao;
	
	/**
	 * 获取业务员的列表
	 */
	public List<Clerk> getAllClerk() {
		List<Clerk> list = clerkDao.getAll();
		return list;
	}
	
	//获取业务员ID通过名字手机
	public Clerk getClerkidByNameTel(String clerkname, String clerktel) {
		Map map=new HashMap();
		map.put("clerkname", clerkname);
		map.put("clerktel", clerktel);
		return clerkDao.getClerk(map);
	}
	
	/**
	 * 新增业务员
	 */
	@Override
	public int insertClerk(Clerk clerk) {
		int flag = clerkDao.insertClerk(clerk);
		return flag;
	}
	
	/**
	 * 更新业务员
	 */
	@Override
	public int updateClerk(Clerk clerk) {
		int flag = clerkDao.updateClerk(clerk);
		return flag;
	}

	@Override
	public Clerk getClerkByOpenid(String wciopenid) {
		return clerkDao.getClerkByOpenid(wciopenid);
	}
	
}
