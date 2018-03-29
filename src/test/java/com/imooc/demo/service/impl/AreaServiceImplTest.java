package com.imooc.demo.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceImplTest {
	@Autowired
	private AreaService areaService;
	
	@Test
	public void testAddArea() throws Exception {
		Area area = new Area();
		area.setAreaName("南苑");
		area.setPriority(3);
		areaService.addArea(area);
	}

}
