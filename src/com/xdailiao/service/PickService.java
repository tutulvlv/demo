package com.xdailiao.service;

import java.util.List;
import java.util.Map;

import com.xdailiao.entity.Pick;

public interface PickService {
	/*//验证取货人
	public String confirmPick(String pickname,String picktel);*/
			
	/**
	 * 获取取货人的列表
	 * @return
	 */
	public List<Pick> getAllPick(Map map);
	
	/**
	 * 获取取货人总数
	 * @return
	 */
	public int getTotalPick();
	
	/**
	 * 获取取货人的id
	 * @param pickname
	 * @param picktel
	 * @return
	 */
	public Integer getPickId(String pickname,String picktel);

	/**
	 * 更新取货人
	 * @param pick
	 * @return
	 */
	public int updatePick(Pick pick);

	/**
	 * 新增取货人
	 * @param pick
	 * @return
	 */
	public int insertPick(Pick pick);
	
	Pick getPickByOpenid(String wcopenid);
}
