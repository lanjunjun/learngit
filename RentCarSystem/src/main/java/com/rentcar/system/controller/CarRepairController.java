package com.rentcar.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.rentcar.system.domain.RepairOrderDetail;
import com.rentcar.system.service.CarService;

@Controller
@RequestMapping("/repair")
public class CarRepairController {

	@Autowired
	CarService carService;
	
	@RequestMapping("/selectRepairOrderDetail.json")
	@ResponseBody
	public Map<String, Object> selectRepairOrderDetailController(long repairOrderID,int page,int rows){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("repairOrderID", repairOrderID);
		map.put("page", (page-1)*rows);
		map.put("rows", rows);
		List<RepairOrderDetail> details= carService.selectRepairOrderDetailService(map);
		Map<String, Object> result=new HashMap<String, Object>();
		result.put("rows", details);
		int count=carService.selectCountOfRepairDetailService(repairOrderID);
		result.put("total", count);
		return result;
	}
	
	@RequestMapping("/agreeRepairDetail.action")
	@ResponseBody
	public Integer agreeRepairDetail(long repairID,int agree,long repairOrderID){
		int r= carService.agreeRepairCarService(repairID, agree);
		if(r>0){
			if (agree==2) {
				int count=carService.selectCountAllOfRepairDetail(repairOrderID);
				int agreeCount=carService.selectCountAgreeOfRepairDetail(repairOrderID);
				if(count==agreeCount){
					carService.updateCarAgreeRepairOrder(repairOrderID);
				}
				
			}
			return 1;
		}else {
			return 0;
		}
	}
}
