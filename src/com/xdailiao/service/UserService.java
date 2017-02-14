package com.xdailiao.service;

import java.util.List;
import java.util.Map;

import com.xdailiao.entity.User;
import com.xdailiao.entity.json.UserOrder;


/**
 * Created by tutu on 2016/10/24.
 */

public interface UserService {
    String addUser(User user); //注册用户
    User getUserByTel(String username,String usertel);//查询提交码
    List<User> getAllUser(int start,int pageSize);
    int getTotalUser();
    int updateUser(User user);
    User getUserByOpenid(String wcopenid);
    List<UserOrder> getOrderUserList(String userid,Integer getPageSize,int i);
}
