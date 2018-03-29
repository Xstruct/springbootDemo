package com.imooc.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.imooc.demo.dao.AreaDAO;
import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	private AreaDAO areaDAO;
	
	@Override
	public List<Area> queryArea() {
		return areaDAO.queryArea();
	}

	@Override
	public Area queryAreaById(int areaId) {
		return areaDAO.queryAreaById(areaId);
	}

	
	@Override
	@Transactional
	public boolean addArea(Area area) throws Exception{
		
		if (!StringUtils.isEmpty(area.getAreaName())) {
			area.setCreateTime(new Date());
			area.setLastEditTime(new Date());
			try {
				int effectiveNum = areaDAO.insertArea(area);
				if(effectiveNum > 0){
					return true;
				}
			} catch (Exception e) {
				throw new RuntimeException("Process for adding area info fails" + e.getMessage());
			}
		}else{
			throw new RuntimeException("Area info should not be null");
		}
		
		return false;

	}

	@Override
	public boolean modifyArea(Area area) {
		if (!StringUtils.isEmpty(area.getAreaName())) {
			area.setLastEditTime(new Date());
			try {
				int effectiveNum = areaDAO.updateArea(area);
				if(effectiveNum > 0){
					return true;
				}
			} catch (Exception e) {
				throw new RuntimeException("Process for modifying area info fails" + e.getMessage());
			}
		}else{
			throw new RuntimeException("Area info should not be null");
		}
		
		return false;
	}

	@Override
	public boolean deleteArea(int areaId) {
		if (areaId > 0) {
			try {
				int effectiveNum = areaDAO.deleteArea(areaId);
				if(effectiveNum > 0){
					return true;
				}
			} catch (Exception e) {
				throw new RuntimeException("Process for deleting area info fails" + e.getMessage());
			}
		}else{
			throw new RuntimeException("Area id should larger than 0");
		}
		
		return false;
	}
	
}
