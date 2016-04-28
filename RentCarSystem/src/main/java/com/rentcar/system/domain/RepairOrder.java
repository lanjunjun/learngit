package com.rentcar.system.domain;

import java.io.Serializable;
import java.util.Date;

public class RepairOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long repairOrderID;
	private long operactingID;
	private String operactingName;
	private String car_LicensePlate;
	private int repair_Maintain;
	private Date apply_Time;
	private Date auditCar_Time;
	private String auditCar_Person;
	private Date auditFinance_Time;
	private String auditFinance_Person;
	private int status;
	public long getRepairOrderID() {
		return repairOrderID;
	}
	public void setRepairOrderID(long repairOrderID) {
		this.repairOrderID = repairOrderID;
	}
	public long getOperactingID() {
		return operactingID;
	}
	public void setOperactingID(long operactingID) {
		this.operactingID = operactingID;
	}
	public String getOperactingName() {
		return operactingName;
	}
	public void setOperactingName(String operactingName) {
		this.operactingName = operactingName;
	}
	public String getCar_LicensePlate() {
		return car_LicensePlate;
	}
	public void setCar_LicensePlate(String car_LicensePlate) {
		this.car_LicensePlate = car_LicensePlate;
	}
	public int getRepair_Maintain() {
		return repair_Maintain;
	}
	public void setRepair_Maintain(int repair_Maintain) {
		this.repair_Maintain = repair_Maintain;
	}
	public Date getApply_Time() {
		return apply_Time;
	}
	public void setApply_Time(Date apply_Time) {
		this.apply_Time = apply_Time;
	}
	public Date getAuditCar_Time() {
		return auditCar_Time;
	}
	public void setAuditCar_Time(Date auditCar_Time) {
		this.auditCar_Time = auditCar_Time;
	}
	public String getAuditCar_Person() {
		return auditCar_Person;
	}
	public void setAuditCar_Person(String auditCar_Person) {
		this.auditCar_Person = auditCar_Person;
	}
	public Date getAuditFinance_Time() {
		return auditFinance_Time;
	}
	public void setAuditFinance_Time(Date auditFinance_Time) {
		this.auditFinance_Time = auditFinance_Time;
	}
	public String getAuditFinance_Person() {
		return auditFinance_Person;
	}
	public void setAuditFinance_Person(String auditFinance_Person) {
		this.auditFinance_Person = auditFinance_Person;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	

}
