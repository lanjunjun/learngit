package com.rentcar.system.domain;

import java.io.Serializable;

public class RepairOrderDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long repairID;
	private String project;
	private double forecast_Cost;
	private double actual_Cost;
	private float taskTime;
	private long repairOrderID;
	public long getRepairID() {
		return repairID;
	}
	public void setRepairID(long repairID) {
		this.repairID = repairID;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public double getForecast_Cost() {
		return forecast_Cost;
	}
	public void setForecast_Cost(double forecast_Cost) {
		this.forecast_Cost = forecast_Cost;
	}
	public double getActual_Cost() {
		return actual_Cost;
	}
	public void setActual_Cost(double actual_Cost) {
		this.actual_Cost = actual_Cost;
	}
	public float getTaskTime() {
		return taskTime;
	}
	public void setTaskTime(float taskTime) {
		this.taskTime = taskTime;
	}
	public long getRepairOrderID() {
		return repairOrderID;
	}
	public void setRepairOrderID(long repairOrderID) {
		this.repairOrderID = repairOrderID;
	}
	
	
}
