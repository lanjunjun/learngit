package com.rentcar.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rentcar.system.domain.CarInfo;
import com.rentcar.system.domain.Contract;
import com.rentcar.system.domain.ContractDetail;
import com.rentcar.system.domain.RepairOrder;
import com.rentcar.system.domain.Standard;
import com.rentcar.system.service.CarService;

@Controller
@RequestMapping("/carorder")
public class CarOrderController {
	
	@Autowired
	CarService carService;

	@RequestMapping("/processContract.json")
	@ResponseBody
	public List<Contract> processContracts(long networkID){
		return carService.processContracts(networkID);
	}
	
	@RequestMapping("/selectContractDetail.json")
	@ResponseBody
	public List<ContractDetail> selectContractDetails(long contractID){
		return carService.selectContractDetailService(contractID);
	}
	@RequestMapping("/matchingCar.json")
	@ResponseBody
	public ResponseEntity<JSONArray> matchingCar(String brand,String type){
		List<CarInfo> carInfos=carService.mappingCarService(brand, type);
		JSONArray jsonArray=new JSONArray();
		for(CarInfo carInfo:carInfos){
			JSONObject json=new JSONObject();
			json.put("id", carInfo.getCarID());
			json.put("text", carInfo.getC_LicensePlate());
			jsonArray.add(json);
		}
		ResponseEntity<JSONArray> rs=new ResponseEntity<JSONArray>(jsonArray, HttpStatus.OK);
		return rs;
	}
	
	@RequestMapping("/getOpearctingCenter.json")
	public ResponseEntity<JSONArray> getOperactingCenter(String id){
		ResponseEntity<JSONArray> rs;
		JSONArray jsonArray=new JSONArray();
		if(id==null){
			List<Standard> ocs=carService.getgetOpearctingCenterService();
			for(Standard oc:ocs){
				JSONObject json=new JSONObject();
				json.put("id", oc.getId());
				json.put("text", oc.getText());
				json.put("state", "closed");
				jsonArray.add(json);
			}
			rs=new ResponseEntity<JSONArray>(jsonArray, HttpStatus.OK);
		}else {
			List<Standard> networks=carService.selectNetworkByOcIDService(Long.parseLong(id));
			for(Standard network:networks){
				JSONObject nwJson=new JSONObject();
				nwJson.put("id", network.getId());
				nwJson.put("text", network.getText());
				jsonArray.add(nwJson);
			}
			rs=new ResponseEntity<JSONArray>(jsonArray, HttpStatus.OK);
		}
		return rs;
	}
	
	@RequestMapping("/getOC.json")
	@ResponseBody
	public List<Standard> getOnlyOpracting(){
		return carService.getgetOpearctingCenterService();
	}
	@RequestMapping("/getMaintainOrder.json")
	@ResponseBody
	public List<RepairOrder> process(long ocID){
		return carService.processMaintainRepairService(ocID);
	}
	
}
