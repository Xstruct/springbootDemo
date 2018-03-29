package com.imooc.demo.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;

@RestController
@RequestMapping("/superadmin")
public class AreaController {
	@Autowired
	private AreaService areaService;
	
	@RequestMapping(value="/listarea", method=RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> listArea(){
		Map<String, Object> modelMap = new HashMap<String,Object>();
		List<Area> areaList = areaService.queryArea();
		modelMap.put("areaList", areaList);
		return modelMap;
	}
	
	@RequestMapping(value="/getareaidbyid/{areaId}",method=RequestMethod.GET)
	private Map<String, Object> getAreaById(@PathVariable int areaId){
		Map<String, Object> modelMap = new HashMap<>();
		Area area = areaService.queryAreaById(areaId);
		modelMap.put("area", area);
		return modelMap;
	}
	
	@RequestMapping(value="/addarea",method=RequestMethod.POST)
	private Map<String, Object> addArea(@RequestBody Area area){
		Map<String, Object> modelMap = new HashMap<>();
		try {
			modelMap.put("success", areaService.addArea(area));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelMap;
	}
	
	@RequestMapping(value="/modifyarea",method=RequestMethod.POST)
	private Map<String, Object> modifyArea(@RequestBody Area area){
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("success", areaService.modifyArea(area));
		return modelMap;
	}
	
	@RequestMapping(value="/removearea", method=RequestMethod.POST)
	private Map<String, Object> removeArea(int areaId){
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("success", areaService.deleteArea(areaId));
		return modelMap;
	}
}
