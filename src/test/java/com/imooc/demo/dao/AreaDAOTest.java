package com.imooc.demo.dao;

import static org.junit.Assert.*;

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
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testInsertArea() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testUpdateArea() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testDeleteArea() {
		fail("Not yet implemented");
	}

}
