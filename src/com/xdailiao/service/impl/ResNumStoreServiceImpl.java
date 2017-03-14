package com.xdailiao.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xdailiao.dao.ResNumStoreDAO;
import com.xdailiao.service.ResNumStoreService;
@Service
public class ResNumStoreServiceImpl implements ResNumStoreService {
	@Resource
	ResNumStoreDAO resNumStoreDAO;
	@Override
	public Integer selectDeptCode(String dept_code) {
		return resNumStoreDAO.selectDeptCode(dept_code);
	}

	@Override
	public int updateDeptCode(Integer store_id,String dept_code) {
		Map map=new HashMap();
		map.put("store_id", store_id);
		map.put("dept_code", dept_code);
		return resNumStoreDAO.updateDeptCode(map);
	}

	@Override
	public int insertDeptCode(String dept_code) {
		return resNumStoreDAO.insertDeptCode(dept_code);
	}

}
