package com.imooc.demo.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.imooc.demo.entity.Area;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDAOTest {
	@Autowired
	private AreaDAO areaDAO;
	
	@Test
	@Ignore
	public void testQueryArea() {
		List<Area> areaList = areaDAO.queryArea();
		for(Area area : areaList){
			System.out.println(area.getAreaName());
			System.out.println(area.getAreaId());
			System.out.println(area.getCreateTime());
			System.out.println(area.getLastEditTime());
			System.out.println(area.getPriority());
		}
		
		assertEquals(2, areaList.size());
	}

	@Test
	@Ignore
	public void testQueryAreaById() {
		Area area = areaDAO.queryAreaById(1);
		System.out.println(area.getAreaName());
		System.out.println(area.getAreaId());
		System.out.println(area.getCreateTime());
		System.out.println(area.getLastEditTime());
		System.out.println(area.getPriority());
		assertEquals("东苑", area.getAreaName());
	}

	@Test
	@Ignore
	public void testInsertArea() {
		Area area = new Area();
		area.setAreaName("南苑");
		area.setPriority(1);
		area.setCreateTime(new Date());
		int effectiveNum = areaDAO.insertArea(area);
		assertEquals(1, effectiveNum);
	}

	@Test
	@Ignore
	public void testUpdateArea() {
		Area area = new Area();
		area.setAreaName("西苑");
		area.setAreaId(3);
		area.setLastEditTime(new Date());
		int effectiveNUm = areaDAO.updateArea(area);
		assertEquals(1, effectiveNUm);
	}

	@Test
	@Ignore
	public void testDeleteArea() {
		fail("Not yet implemented");
	}

}
