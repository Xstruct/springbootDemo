package com.imooc.demo.service;

import java.util.List;

import com.imooc.demo.entity.Area;

public interface AreaService {
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
	 * @throws Exception 
	 */
	boolean addArea(Area area) throws Exception;
	
	/**
	 * @param area
	 * @return
	 */
	boolean modifyArea(Area area);
	
	/**
	 * @param areaId
	 * @return
	 */
	boolean deleteArea(int areaId);
}
