package com.xdailiao.dao;

import java.util.List;
import java.util.Map;

import com.xdailiao.entity.User;
import com.xdailiao.entity.json.UserOrder;


/**
 * Created by tutu on 2016/10/24.
 */
public interface UserDao {
    int addUser(User user); //添加客户
    User getUserByNameTel(Map map); //通过名字手机号获取用户
    User getUserByNumTel(Map map); //通过提交手机号获取用户
    List<User> getAllUser(Map map);
    int getTotalUser();
    int updateUser(User user);
    User getUserByOpenid(String wcopenid);
    List<UserOrder> getUserOrderList(Map map);
    int getUserOrderListNum(Integer oid);
  
}
