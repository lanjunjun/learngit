package com.rentcar.system.dao;

import org.springframework.stereotype.Repository;

import com.rentcar.system.domain.Department;

@Repository
public interface DepartmentDao {
	
	int setDepartment(Department department);

}
