package com.rentcar.system.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rentcar.system.domain.Area;
import com.rentcar.system.service.AreaService;

@Controller
@RequestMapping(value="/area")
public class AreaController {
	
	@Autowired
	public AreaService areaService;
	
	
	@RequestMapping(value="/getAllArea.json")
	public ResponseEntity<JSONArray> findArea(Integer id){
		if(id==null){
			id=1;
		}
		List<Area> areas=areaService.findAllAreaService(id);
		JSONArray jsonArray=new JSONArray();
		for(Area a:areas)
		{
			JSONObject json=new JSONObject();
			json.put("id", a.getClass_id());
			json.put("text", a.getClass_name());
			if(a.getClass_type()==3)
			{
				json.put("state", "open");
			}else {
				json.put("state", "closed");
			}
			
			jsonArray.add(json);
			
		}
		ResponseEntity<JSONArray> rs=new ResponseEntity<JSONArray>(jsonArray, HttpStatus.OK);
		return rs;
	}

	
}
