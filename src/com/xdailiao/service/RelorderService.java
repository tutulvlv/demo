package com.xdailiao.service;

import java.util.List;
import java.util.Map;

import com.xdailiao.entity.Orderitem;
import com.xdailiao.entity.json.AdminList;
import com.xdailiao.entity.json.ClerkList;
import com.xdailiao.entity.json.PickList;


/**
 * 这是订单的处理页面
 * 
 * 		1.业务员分配
 * 		2.取货人分配
 * 		3.订单的生成
 * 		4.业务员 获取对应列表
 * 			业务员提交订单
 * 		5.取货人获取对应列表
 * 			取货人提交订单
 * 		6.入库提交
 * 		7.管理员页面展示
 * 		8.订单完成 付款（短信）
 * 		
 * @author viakiba
 *
 */
public interface RelorderService {
	/**
	 * 业务员分配
	 * @param relid
	 * @param clerkName
	 * @return
	 */
	public String allotClerk(Integer relid,Integer clerkid);

	/**
	 * 业务员获取对应的订单列表
	 * @param clerkname
	 * @param clerktel
	 * @return
	 */
	public List<ClerkList> getClerkOrderList(Integer clerkid,Integer start,Integer pageSize);
	
	/**
	 * 业务员提交 验货结果
	 * @param map
	 * @return
	 */
	public String putClerkInsres(Map map);
	
	/**
	 * 取货人分配
	 * @param relid
	 * @param pickname
	 * @return
	 */
	public String allotPick(Integer relid,Integer pickid);
	
	//通过姓名电话获取取货人ID
//	public Integer getPickId(String pickname, String picktel);
	/**
	 * 取货人获取对应的订单
	 */
	public List<PickList> getPickOrderList(Integer pickid,Integer start,Integer pageSize);
	
	/**
	 * 取货人提交订单详情
	 * @param map
	 * @return
	 */
	public String putPickInsres(Map map);
	
	/**
	 * 订单生成
	 * @param subnum
	 * @param usertel
	 * @return
	 */
	public int generateListorder(String subnum,String usertel);
	
	/**
	 * 管理员入库提交
	 * @param map
	 * @return
	 */
	public String putAdminres(Map map);
	
	/**
	 * 管理员付款
	 * @param map
	 * @return
	 */
	public int setPay(Integer id);
	
	/**
	 * 删除订单
	 * @param id
	 * @return
	 */
	public String deleteOrder(Integer id) ;
	
	//获取全部order信息
	List<AdminList> getAllAdminList(Map map);
	//通过usertel获取管理员列表
    public List<AdminList> getOrderViewByTel(String usertel);
    //通过orderitemid获取管理员列表
    public List<AdminList> getOrderViewByOid(Integer orderitemid);
    //获取管理员订单总数
    public Integer getTotalAdminList();
    //获取业务员订单总数
    public Integer getTotalClerkOrderList(Integer clerkid);
    //获取取货员订单总数
    public Integer getTotalPickOrderList(Integer pickid);
    //按公司名查询订单
    List<AdminList> getOrderListByCom(String comname,Integer start,Integer pageSize);
	Integer getTotalOrderListByCom(String comname);
}
