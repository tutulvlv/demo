package com.xdailiao.service;

import java.util.List;
import java.util.Map;

import com.xdailiao.entity.Admin;

public interface AdminService {
	List<Admin> getAllAdmin();
	Admin getAdmin(String admin_name,String admin_pwd);
	int addAdmin(Admin admin);
	int updateAdmin(Admin admin);
	int deleteAmdin(String id);
}
