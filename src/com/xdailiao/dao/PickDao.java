package com.xdailiao.dao;

import com.xdailiao.entity.Pick;

import java.util.List;
import java.util.Map;

/**
 * Created by 666 on 2016/10/25.
 */
public interface PickDao {
	/**
	 * 获取所有取货人
	 * @return
	 */
    List<Pick> getAll(Map map);
    
    int getTotalPick();
    /**
     * 查找取货人id
     * @param pickname
     * @return
     */
    Integer getPickId(Map map);
    
    /**
     * 修改业务员
     * @param map
     * @return
     */
    int updatePick(Pick pick);
    
    /**
     * 新增业务员
     * @param map
     * @return
     */
    int insertPick(Pick pick);
    
    Pick getPickByOpenid(String wcopenid);
}
