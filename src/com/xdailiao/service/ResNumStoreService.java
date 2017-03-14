package com.xdailiao.service;

import java.util.Map;

public interface ResNumStoreService {
	Integer selectDeptCode(String dept_code);
	int updateDeptCode(Integer store_id,String dept_code);
	int insertDeptCode(String dept_code);
}
