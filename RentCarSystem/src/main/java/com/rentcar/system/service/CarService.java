package com.rentcar.system.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rentcar.system.dao.CarDao;
import com.rentcar.system.domain.CarInfo;
import com.rentcar.system.domain.Contract;
import com.rentcar.system.domain.ContractDetail;
import com.rentcar.system.domain.RepairOrder;
import com.rentcar.system.domain.RepairOrderDetail;
import com.rentcar.system.domain.Standard;

@Service
public class CarService {
	
	@Autowired
	CarDao carDao;
	
	public int insertCarInfoService(CarInfo carInfo){
		return carDao.insertCarInfo(carInfo);
	}
	
	public List<CarInfo> selectCarInfoByAreaIDService(Map<String, Integer> map){
		
		return carDao.selectCarInfoByAreaID(map);
	}
	public int getCarInfoByAreaCountService(int areaID){
		return carDao.getCarInfoByAreaCountDao(areaID);
	}
	public int agreeCarInfoService(Long carID){
		return carDao.agreeCarInfo(carID);
	}
	public int notAgreeCarInfoService(Long carID){
		return carDao.notAgreeCarInfo(carID);
	}
	
	public List<Contract> processContracts(long networkID){
		return carDao.processOrder(networkID);
	}
	
	public List<ContractDetail> selectContractDetailService(long contractID){
		return carDao.selectContractDetail(contractID);
	}
	
	public List<CarInfo> mappingCarService(String brand,String type){
		return carDao.mappingCar(brand, type);
	}
	
	public List<Standard> getgetOpearctingCenterService(){
		return carDao.getOpearctingCenter();
	}
	public List<Standard> selectNetworkByOcIDService(long ocID){
		return carDao.selectNetworkByOcID(ocID);
	}
	
	public List<RepairOrder> processMaintainRepairService(long ocID){
		return carDao.processMaintainRepair(ocID);
	}
	
	public List<RepairOrderDetail> selectRepairOrderDetailService(Map<String,Object> map){
		return carDao.selectRepairOrderDetail(map);
	}
	
	public Integer agreeRepairCarService(long repairID,int agree){
		return carDao.agreeRepairCar(repairID, agree);
	}
	
	public int selectCountOfRepairDetailService(long repairOrderID){
		return carDao.selectCountOfRepairDetail(repairOrderID);
	}
	
	public int selectCountAllOfRepairDetail(long repairOrderID){
		return carDao.selectCountAllOfRepairDetail(repairOrderID);
	}
	public int selectCountAgreeOfRepairDetail(long repairOrderID){
		return carDao.selectCountAgreeOfRepairDetail(repairOrderID);
	}
	
	public int updateCarAgreeRepairOrder(long repairOrderID){
		return carDao.updateCarAgreeRepairOrder(repairOrderID);
	}
}
