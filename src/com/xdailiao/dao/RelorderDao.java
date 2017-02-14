package com.xdailiao.dao;

import com.xdailiao.entity.json.ClerkList;
import com.xdailiao.entity.json.PickList;

import java.util.List;
import java.util.Map;

/**
 * Created by tutu on 2016/10/25.
 */
public interface RelorderDao {
	//插入order关系表
	int insertRelorder(Map map);
	/**
	 * 设置业务员id
	 * @param relid
	 * @param clerkId
	 * @return
	 */
    int setClerkId(Map map); 
    
    /**
     * 获取业务员对应的订单列表
     * @param clerkid
     * @return
     */
    List<ClerkList> getClerkOrderList(Map map);
    /**
     * 设置取货人id
     * @param relid
     * @param clerkId
     * @return
     */
    int setPickId(Map map);
    /**
     * 获取取货人对应的订单列表
     * @param pickid
     * @return
     */
    List<PickList> getPickOrderList(Map map);
    /**
     * pick 提交订单
     * @param map
     * @return
     */
    int setPickimgByOrderitemId(Map map);
    
    /**
	 * 删除指定订单号的关系表
	 * @param orderid
	 * @return
	 */
	int deleteRelorder(Integer orderitemid);
}
