package com.imooc.demo.dao;

import java.util.List;

import com.imooc.demo.entity.Area;

public interface AreaDAO {
	/**
	 * @return
	 */
	List<Area> queryArea();
	
	/**
	 * @param areaId
	 * @return
	 */
	Area queryAreaById(int areaId);
	
	/**
	 * @param area
	 * @return
	 */
	int insertArea(Area area);
	
	/**
	 * @param area
	 * @return
	 */
	int updateArea(Area area);
	
	/**
	 * @param areaId
	 * @return
	 */
	int deleteArea(int areaId);
}
