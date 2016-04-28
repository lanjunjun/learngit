package com.rentcar.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentcar.system.dao.AreaDao;
import com.rentcar.system.domain.Area;

@Service
public class AreaService {
	
	@Autowired
	AreaDao areaDao;
	
	public List<Area> findAllAreaService(Integer id){
		return areaDao.findAllArea(id);
	}
	

}
