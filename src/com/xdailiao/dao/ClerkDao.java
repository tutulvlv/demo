package com.xdailiao.dao;

import com.xdailiao.entity.Clerk;

import java.util.List;
import java.util.Map;

/**
 * Created by 666 on 2016/10/25.
 */
public interface ClerkDao {
	//获取所有业务员
	List<Clerk> getAll();
	
    /*boolean confirmClerk(Clerk clerk);//核实业务员*/  
	//获取业务员的id
	Clerk getClerk(Map map);
	
	/**
	 * 新增业务员
	 * @param map
	 * @return
	 */
	int insertClerk(Clerk clerk);
	
	/**
	 * 修改业务员信息
	 * @param map
	 * @return
	 */
	int updateClerk(Clerk clerk);
	
	Clerk getClerkByOpenid(String wciopenid);
}
