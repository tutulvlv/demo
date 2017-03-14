package com.xdailiao.dao;

import java.util.Map;

public interface ResNumStoreDAO {
	Integer selectDeptCode(String dept_code);
	int updateDeptCode(Map map);
	int insertDeptCode(String dept_code);
}
