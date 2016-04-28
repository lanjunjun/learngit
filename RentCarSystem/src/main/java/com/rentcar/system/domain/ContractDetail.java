package com.rentcar.system.domain;

import java.io.Serializable;

public class ContractDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5195711734476748073L;
	
	private long numberID;
	private String car_Brand;
	private String car_Type;
	private String car_Deposit;
	private long contractID;
	public long getNumberID() {
		return numberID;
	}
	public void setNumberID(long numberID) {
		this.numberID = numberID;
	}
	public String getCar_Brand() {
		return car_Brand;
	}
	public void setCar_Brand(String car_Brand) {
		this.car_Brand = car_Brand;
	}
	public String getCar_Type() {
		return car_Type;
	}
	public void setCar_Type(String car_Type) {
		this.car_Type = car_Type;
	}
	public String getCar_Deposit() {
		return car_Deposit;
	}
	public void setCar_Deposit(String car_Deposit) {
		this.car_Deposit = car_Deposit;
	}
	public long getContractID() {
		return contractID;
	}
	public void setContractID(long contractID) {
		this.contractID = contractID;
	}
	
	

}
