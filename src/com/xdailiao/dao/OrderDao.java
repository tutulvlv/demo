package com.xdailiao.dao;


import java.util.List;
import java.util.Map;

import com.xdailiao.entity.json.AdminList;

/**
 * Created by tutu on 2016/10/24.
 */
public interface OrderDao {
	/**
	 * 首次插入orderitem表
	 * @param date
	 * @param usertel
	 * @return
	 */
    int insertOrder(Map map); 
    /**
     * 获取最新插入的Orderitemid 
     * @param subnum
     * @param usertel
     * @return
     */
    Integer getLastOid(Map map); 
    /**
     * 
     * @param map
     * @return  成功或者失败
     */
    int setClerkput(Map map);
    /**
     * 通过订单ID设置付款状态
     * @param id
     * @return
     */
    int setPaystatusByOrderitemId(Integer id);
    /**
     * 管理员获取全部订单
     * @param map
     * @return
     */
    List<AdminList> getAllAdminList(Map map);
    /**
     * 通过ID设置入库信息
     * @param map
     * @return
     */
    int setPutByOrderitemId(Map map);
    /**
     * 通过usertel获取管理员列表
     * @param usertel
     * @return
     */
    List<AdminList> getOrderViewByTel(String usertel);
    /**
     * 通过orderitemid获取管理员列表
     * @param orderitemid
     * @return
     */
    List<AdminList> getOrderViewByOid(Integer orderitemid);
    /**
     * 获取管理员订单列表总数
     * @return
     */
    Integer getTotalAdminList();
    /**
     * 获取业务员订单总数
     * @param clerkid
     * @return
     */
	Integer getTotalClerkOrderList(Integer clerkid);
	/**
	 * 获取取货人订单总数
	 * @param pickid
	 * @return
	 */
	Integer getTotalPickOrderList(Integer pickid);	
	/**
	 * 删除指定订单号的订单表
	 * @param orderid
	 * @return
	 */
	int deleteOrder(Integer orderid);	
	/**
	 * 按公司名查询订单
	 * @param map（公司名，start，pageSize）
	 * @return
	 */
	List<AdminList> getOrderListByCom(Map map);
	Integer getTotalOrderListByCom(String comname);
}
