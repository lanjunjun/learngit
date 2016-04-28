package com.rentcar.system.domain;

import java.io.Serializable;


public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long departID;
	private String d_Name;
	private int d_HeaderID;
	private String d_Description;
	public long getDepartID() {
		return departID;
	}
	public void setDepartID(long departID) {
		this.departID = departID;
	}
	public String getD_Name() {
		return d_Name;
	}
	public void setD_Name(String d_Name) {
		this.d_Name = d_Name;
	}
	public int getD_HeaderID() {
		return d_HeaderID;
	}
	public void setD_HeaderID(int d_HeaderID) {
		this.d_HeaderID = d_HeaderID;
	}
	public String getD_Description() {
		return d_Description;
	}
	public void setD_Description(String d_Description) {
		this.d_Description = d_Description;
	}
	
	
	

}
