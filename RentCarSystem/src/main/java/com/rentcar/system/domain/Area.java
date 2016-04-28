package com.rentcar.system.domain;

import java.io.Serializable;

public class Area implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int class_id;
	private String class_name;
	private int class_type;
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public int getClass_type() {
		return class_type;
	}
	public void setClass_type(int class_type) {
		this.class_type = class_type;
	}
	
	
	

}
