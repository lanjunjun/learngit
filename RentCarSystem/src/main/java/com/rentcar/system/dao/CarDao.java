package com.rentcar.system.dao;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.rentcar.system.domain.CarInfo;
import com.rentcar.system.domain.Contract;
import com.rentcar.system.domain.ContractDetail;
import com.rentcar.system.domain.RepairOrder;
import com.rentcar.system.domain.RepairOrderDetail;
import com.rentcar.system.domain.Standard;

@Repository
public interface CarDao {

	int insertCarInfo(CarInfo carInfo);
	List<CarInfo> selectCarInfoByAreaID(Map<String, Integer> map);
	int agreeCarInfo(Long carID);
	int getCarInfoByAreaCountDao(int areaID);
	int notAgreeCarInfo(Long carID);
	List<Contract> processOrder(long networkID);
	List<ContractDetail> selectContractDetail(long contractID);
	List<CarInfo> mappingCar(String brand,String type);
	List<Standard> getOpearctingCenter();
	List<Standard> selectNetworkByOcID(long ocID);
	List<RepairOrder> processMaintainRepair(long ocID);
	List<RepairOrderDetail> selectRepairOrderDetail(Map<String, Object> map);
	Integer agreeRepairCar(long repairID,int agree);
	int selectCountOfRepairDetail(long repairOrderID);
	int selectCountAllOfRepairDetail(long repairOrderID);
	int selectCountAgreeOfRepairDetail(long repairOrderID);
	int updateCarAgreeRepairOrder(long repairOrderID);
}
