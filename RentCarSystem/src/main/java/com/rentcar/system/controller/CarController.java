package com.rentcar.system.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.rentcar.system.domain.CarInfo;
import com.rentcar.system.service.CarService;

@Controller
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	CarService carService;
	
	@RequestMapping("/selectCarInfo.json")
	@ResponseBody
	public Map<String, Object> selectCarInfo(int areaID,int page,int rows){
		
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("areaID", areaID);
		map.put("page", (page-1)*rows);
		map.put("rows", rows);
		List<CarInfo> carInfos= carService.selectCarInfoByAreaIDService(map);
		int count=carService.getCarInfoByAreaCountService(areaID);
		Map<String, Object> result=new HashMap<String, Object>();
		result.put("total", count);
		result.put("rows", carInfos);
		return result;
	}

	@RequestMapping("/agreeCarInfo.action")
	public void agreeCarInfoController(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String carID=request.getParameter("carID");
		int r=carService.agreeCarInfoService(Long.parseLong(carID));
		if(r>0){
			response.getWriter().write("1");
		}else {
			response.getWriter().write("0");
		}
		
	}
	
	@RequestMapping("/notAgreeCarInfo.action")
	public void notagreeCarInfoController(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String carID=request.getParameter("carID");
		System.out.println(carID);
		int r=carService.notAgreeCarInfoService(Long.parseLong(carID));
		if(r>0){
			response.getWriter().write("1");
		}else {
			response.getWriter().write("0");
		}
		
	}
	
	@RequestMapping("/submitCarInfo.action")
	@ResponseBody
	public Integer submitCarInfo(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String c_Brand=request.getParameter("c_Brand");
		String c_Type=request.getParameter("c_Type");
		String c_Price=request.getParameter("c_Price");
		String c_LicensePlate=request.getParameter("c_LicensePlate");
		String c_VIN=request.getParameter("c_VIN");
		String c_FuelType=request.getParameter("c_FuelType");
		String c_Motor=request.getParameter("c_Motor");
		String c_Color=request.getParameter("c_Color");
		String c_BuyDate=request.getParameter("c_BuyDate");
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date=dateFormat.parse(c_BuyDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		CarInfo carInfo=new CarInfo();
		carInfo.setC_Brand(c_Brand);
		carInfo.setC_Type(c_Type);
		carInfo.setC_Price(Double.parseDouble(c_Price));
		carInfo.setC_LicensePlate(c_LicensePlate);
		carInfo.setC_VIN(c_VIN);
		carInfo.setC_FuelType(c_FuelType);
		carInfo.setC_Motor(c_Motor);
		carInfo.setC_Color(c_Color);
		carInfo.setC_BuyDate(date);
		carInfo.setC_RecordTime(new Date());
		carInfo.setC_AuditStatus(2);
		carInfo.setC_Source(1);
		int r=carService.insertCarInfoService(carInfo);
		System.out.println(r);
		return r;
		
	}
	
}//最外层
