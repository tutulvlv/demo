package com.xdailiao.dao;

import java.util.List;
import java.util.Map;

import com.xdailiao.entity.Admin;

public interface AdminDao {
	List<Admin> getAllAdmin();
	Admin getAdmin(Map map);
	int addAdmin(Admin admin);
	int updateAdmin(Admin admin);
	int deleteAmdin(Integer id);
}
