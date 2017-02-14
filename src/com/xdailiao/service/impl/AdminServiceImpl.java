package com.xdailiao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdailiao.dao.AdminDao;
import com.xdailiao.dao.ClerkDao;
import com.xdailiao.entity.Admin;
import com.xdailiao.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
	@Resource
	private AdminDao adminDao;

	public List<Admin> getAllAdmin() {
		return adminDao.getAllAdmin();
	}

	public Admin getAdmin(String admin_name, String admin_pwd) {
		Map map=new HashMap();
		map.put("admin_name", admin_name);
		map.put("admin_pwd", admin_pwd);
		return adminDao.getAdmin(map);
	}
	public int updateAdmin(Admin admin){
		return adminDao.updateAdmin(admin);
	}

	@Override
	public int deleteAmdin(String id) {
		return adminDao.deleteAmdin(Integer.valueOf(id));
	}

	@Override
	public int addAdmin(Admin admin) {
		return adminDao.addAdmin(admin);
	}
}
