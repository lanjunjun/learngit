package com.rentcar.system.domain;

import java.io.Serializable;

public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long roleID;
	private String r_Name;
	private String r_Description;
	public long getRoleID() {
		return roleID;
	}
	public void setRoleID(long roleID) {
		this.roleID = roleID;
	}
	public String getR_Name() {
		return r_Name;
	}
	public void setR_Name(String r_Name) {
		this.r_Name = r_Name;
	}
	public String getR_Description() {
		return r_Description;
	}
	public void setR_Description(String r_Description) {
		this.r_Description = r_Description;
	}
	
	

}
