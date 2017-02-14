package com.xdailiao.service.impl;


import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xdailiao.dao.ClerkDao;
import com.xdailiao.dao.KindDao;
import com.xdailiao.dao.OrderDao;
import com.xdailiao.dao.PickDao;
import com.xdailiao.dao.RelorderDao;
import com.xdailiao.dao.UserDao;
import com.xdailiao.entity.Orderitem;
import com.xdailiao.entity.json.AdminList;
import com.xdailiao.entity.json.ClerkList;
import com.xdailiao.entity.json.PickList;
import com.xdailiao.service.RelorderService;


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
@Service
public class RelorderServiceImpl implements RelorderService{
	@Resource
	private ClerkDao clerkDao;
	@Resource
	private KindDao kindDao;
	@Resource
	private OrderDao orderDao;
	@Resource
	private PickDao pickDao;
	@Resource
	private RelorderDao relorderDao;
	@Resource
	private UserDao userDao;
	/**
	 * setter 注入
	 * @param clerkDaoImpl
	 */
//	public void setClerkDaoImpl(ClerkDao clerkDaoImpl) {
//		this.clerkDao = clerkDaoImpl;
//	}
//	public void setKindDaoImpl(KindDao kindDaoImpl) {
//		this.kindDao = kindDaoImpl;
//	}
//	public void setOrderDaoImpl(OrderDao orderDaoImpl) {
//		this.orderDao = orderDaoImpl;
//	}
//	public void setPickDaoImpl(PickDao pickDaoImpl) {
//		this.pickDao = pickDaoImpl;
//	}
//	public void setRelorderDaoImpl(RelorderDao relorderDaoImpl) {
//		this.relorderDao = relorderDaoImpl;
//	}
//	public void setUserDaoImpl(UserDao userDaoImpl) {
//		this.userDao = userDaoImpl;
//	}
	/**
	 * 业务员分配
	 */
	public String allotClerk(Integer orderitemid,Integer clerkid) {
		Map map=new HashMap();
		map.put("orderitemid", orderitemid);
		map.put("clerkid", clerkid);
		int flag = relorderDao.setClerkId(map);//这知道关系表中 id
		
		if(flag==1){
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 业务员获取对应的订单列表    clerktel  clerkname  ===》clerkid  ====》List<Orderitem>
	 */
	public List<ClerkList> getClerkOrderList(Integer clerkid,Integer start,Integer pageSize) {
		Map map=new HashMap();
		map.put("clerkid", clerkid);
		map.put("start", start);
		map.put("pageSize", pageSize);
		List<ClerkList> lists = relorderDao.getClerkOrderList(map);//拿到对应的订单列表
		//拿到客户名字列表
		return lists;
	}
	
	/**
	 * controller  需要判空
	 * 业务员提交 验货结果  这里  需要   图片名字(orderimg)    价格 (price)    重量(weight)     详情(orderdet)    还需要   orderitemid
	 */
	public String putClerkInsres(Map map) {
		/*Integer orderitemid =(Integer) map.get("orderitemid");
		String orderimg =(String) map.get("orderimg");
		Double price =(Double) map.get("price");
		Double weight = (Double)map.get("weight");
		String orderdet =(String) map.get("orderdet");*/
		int re = orderDao.setClerkput(map);
		
		if(re!=1){
			return "fail";
		}
		return "success";
	}
	
	/**
	 *   取货人分配
	 */
	public String allotPick(Integer orderitemid,Integer pickid) {
		Map map=new HashMap();
		map.put("orderitemid", orderitemid);
		map.put("pickid", pickid);
		int flag = relorderDao.setPickId(map);//把取货人的id设置到关系表中
		if(flag!=1){
			return "fail";
		}
		return "success";
	}
	/**
	 * 取货人获取对应的订单
	 */
	public List<PickList> getPickOrderList(Integer pickid,Integer start,Integer pageSize) {
		Map map=new HashMap();
		map.put("pickid", pickid);
		map.put("start", start);
		map.put("pageSize", pageSize);
		List<PickList> list = relorderDao.getPickOrderList(map);//订单详情
		return list;
	}
	
	/**
	 * 取货人提交订单详情  relid  putimg_name
	 */
	public String putPickInsres(Map map) {
		int flag = relorderDao.setPickimgByOrderitemId(map);
		System.out.println(map);
		if(flag==1){
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 管理员页面的展示
	 * 
	 */
	public List<AdminList> getAllAdminList(Map map) {
		return orderDao.getAllAdminList(map);
	}
	
	
	/**
	 * 订单生成
	 */
	public int generateListorder(String subnum, String usertel) {
		Map map=new HashMap();
		map.put("subnum", subnum);
		map.put("usertel", usertel);
		if(userDao.getUserByNumTel(map)==null){
			return -1;
		}
		Timestamp ts=new Timestamp(new Date().getTime());
		Map map2=new HashMap();
		map2.put("createtime", ts);
		map2.put("usertel", usertel);
		orderDao.insertOrder(map2);
		int orderitemid=orderDao.getLastOid(map2);
		int userid=userDao.getUserByNumTel(map).getUserid();
		System.out.println(orderitemid+" "+userid);
		Map map3=new HashMap();
		map3.put("orderitemid", orderitemid);
		map3.put("userid", userid);
		relorderDao.insertRelorder(map3);
		return orderitemid;
	}
	
	/**
	 * 管理员入库提交
	 */
	public String putAdminres(Map map) {
		int flag = orderDao.setPutByOrderitemId(map);
		if(flag==1){
			return "success";
		}
		return "fail";
	}
	
	/**
	 * 订单完成
	 */
	public int setPay(Integer id) {
		return orderDao.setPaystatusByOrderitemId(id);
	}
	
	/**
	 * 删除订单
	 * @param id
	 * @return
	 */
	public String deleteOrder(Integer id) {
		System.out.println("删除订单"+id);
		
		int RelFlag = relorderDao.deleteRelorder(id);
		int OrderFlag = orderDao.deleteOrder(id);
		
		System.out.println("RelFlag"+RelFlag+"<<<>>>"+"OrderFlag"+OrderFlag);
		if( RelFlag == 1 || OrderFlag == 1){
			return "success";
		}
		return "fail";
	}
	
	public List<AdminList> getOrderViewByTel(String usertel) {
		return orderDao.getOrderViewByTel(usertel);
	}
	public List<AdminList> getOrderViewByOid(Integer orderitemid) {
		return orderDao.getOrderViewByOid(orderitemid);
	}
	public Integer getTotalAdminList() {
		return orderDao.getTotalAdminList();
	}
	public Integer getTotalClerkOrderList(Integer clerkid) {
		return orderDao.getTotalClerkOrderList(clerkid);
	}
	public Integer getTotalPickOrderList(Integer pickid) {
		return orderDao.getTotalPickOrderList(pickid);
	}

//	@Override
//	public Integer getPickId(String pickname, String picktel) {
//		return null;
//	}

	@Override
	public List<AdminList> getOrderListByCom(String comname, Integer start,
			Integer pageSize) {
		Map map =new HashMap();
		map.put("comname", "%"+comname+"%");
		map.put("start", start);
		map.put("pageSize", pageSize);
		return orderDao.getOrderListByCom(map);
	}

	@Override
	public Integer getTotalOrderListByCom(String comname) {
		return orderDao.getTotalOrderListByCom("%"+comname+"%");
	}
}
