package com.xdailiao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.xdailiao.dao.PickDao;
import com.xdailiao.entity.Pick;
import com.xdailiao.service.PickService;
@Service
public class PickServiceImpl implements PickService{
		@Resource
		private PickDao pickDao;
		
		/**
		 * 获取取货人的列表  暂时不用
		 */
		public List<Pick> getAllPick(Map map){
			List<Pick> list = pickDao.getAll(map);
			return list;
		}
		
		/**
		 * 获取取货人的编号
		 */
		public Integer getPickId(String pickname,String picktel) {
			Map map=new HashMap();
			map.put("pickname", pickname);
			map.put("picktel", picktel);
			return pickDao.getPickId(map);
		}
		
		/**
		 * 更新取货人
		 */
		@Override
		public int updatePick(Pick pick){
			int flag = pickDao.updatePick(pick);
			return flag;
		}
		
		/**
		 * 新增取货人
		 * @param pick
		 * @return
		 */
		@Override
		public int insertPick(Pick pick) {
			int flag = pickDao.insertPick(pick);
			return flag;
		}
		
		/**
		 * 获取取货人的总数
		 * @return
		 */
		@Override
		public int getTotalPick() {
			int total = pickDao.getTotalPick();
			return total;
		}

		@Override
		public Pick getPickByOpenid(String wcopenid) {
			return pickDao.getPickByOpenid(wcopenid);
		}
}
