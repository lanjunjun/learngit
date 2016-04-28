package com.rentcar.system.test;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rentcar.system.dao.AreaDao;
import com.rentcar.system.dao.CarDao;
import com.rentcar.system.dao.DepartmentDao;
import com.rentcar.system.domain.Department;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:/applicationContext-resources.xml", "classpath:applicationContext-dao.xml"})
public class DepartmentTest {
	
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@Autowired
	AreaDao areaDao;
	
	@Autowired
	CarDao carDao;
	
	@Test
	public void setDepart(){
		Department department=new Department();
		department.setD_Name("车辆部2");
		department.setD_Description("负责车辆信息的维护和车辆的管理2");
		departmentDao.setDepartment(department);
	}
	
	@Test
	public void ss(){
		Date date=new Date("2016-04-21");
		System.out.println(date);
	}

}
