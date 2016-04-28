package com.rentcar.system.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rentcar.system.domain.Area;

@Repository
public interface AreaDao {

	List<Area> findAllArea(Integer id);
}
