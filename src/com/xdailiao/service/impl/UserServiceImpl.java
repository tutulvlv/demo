package com.xdailiao.service.impl;

import com.xdailiao.dao.UserDao;
import com.xdailiao.entity.User;
import com.xdailiao.entity.json.UserOrder;
import com.xdailiao.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * Created by tutu on 2016/10/24.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
	private UserDao userDao;
  
//	public void setUserDaoImpl(UserDao userDaoImpl) {
//		this.userDaoImpl = userDaoImpl;
//	}
	//    新增用户
    public String addUser(User user) {
    	Map map=new HashMap();
    	map.put("username", user.getUsername());
    	map.put("usertel",user.getUsertel());
    	//验证
    	User flag = userDao.getUserByNameTel(map);
    	if(flag != null){
    		return  "flase";
    	}
    	//插入
    	// 默认自动生成 密码 和 提交码
    	Random ran = new Random();
    	String subnum = String.valueOf(ran.nextInt(100)).replace('4', '6').replace('7', '8');
    	String password = String.valueOf(ran.nextInt(10000));
    	user.setSubnum(subnum);
    	user.setPassword(password);
    	userDao.addUser(user);
    	return "您的提交码是"+subnum+",请妥善保管！！！";
    }
//   获取 查询码
    public User getUserByTel(String username,String usertel) {
    	Map map=new HashMap();
    	map.put("username", username);
    	map.put("usertel", usertel);
       return userDao.getUserByNameTel(map);
    }
	@Override
	public List<User> getAllUser(int start, int pageSize) {
		Map map=new HashMap();
		map.put("start", start);
		map.put("pageSize", pageSize);
		return userDao.getAllUser(map);
	}
	
	@Override
	public int getTotalUser() {
		return userDao.getTotalUser();
	}
	
	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}
	@Override
	public List<UserOrder> getOrderUserList(String userid,Integer getPageSize,int i) {
		//先拿到总数
		Map map = new HashMap();
		
		map.put("start", i);
		map.put("pageSize", getPageSize);
		map.put("userid", userid);
		List<UserOrder> orderlist = userDao.getUserOrderList(map); 
		
		return orderlist;
	}
	@Override
	public User getUserByOpenid(String wcopenid) {
		return userDao.getUserByOpenid(wcopenid);
	}
}
