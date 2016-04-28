package com.rentcar.system.domain;

import java.io.Serializable;
import java.util.Date;

public class CarInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long carID;          //车辆ID
	private String c_LicensePlate;  //车牌号
	private String c_Brand;
	private String c_Type;       //车辆型号
	private Double c_Price;
	private String c_VIN; 	     //车架号
	private String c_Motor;      //发动机号
	private String c_Color;      //车身颜色
	private long c_Owner;        //车主ID
	private String c_FuelType;   //燃油型号
	private Date c_BuyDate;      //购买日期
	private Double c_Legend;     //入库里程
	private Double c_MaintenanceKilometers;   //保养公里数
	private int c_Source;        //来源，1自购  2挂靠
	private long c_OperatingID;  //运营中心ID
	private long c_NetworkID;    //网点ID
	private long c_CurNetworkID;  //当前停靠网点
	private long c_RecordID;      //录入人
	private Date c_RecordTime;    //录入时间
	private int c_AuditStatus;    //审核状态（1待审核2审核中3审核通过）
	private int c_AuditPersonID;  //审核人ID
	private Date c_AuditTime;     //审核人ID
	private long c_ModifyPersonID;  //修改人ID
	private Date c_ModifyTime;      //修改时间
	public long getCarID() {
		return carID;
	}
	public void setCarID(long carID) {
		this.carID = carID;
	}
	
	public Double getC_Price() {
		return c_Price;
	}
	public void setC_Price(Double c_Price) {
		this.c_Price = c_Price;
	}
	public String getC_LicensePlate() {
		return c_LicensePlate;
	}
	public void setC_LicensePlate(String c_LicensePlate) {
		this.c_LicensePlate = c_LicensePlate;
	}
	
	public String getC_Brand() {
		return c_Brand;
	}
	public void setC_Brand(String c_Brand) {
		this.c_Brand = c_Brand;
	}
	public String getC_Type() {
		return c_Type;
	}
	public void setC_Type(String c_Type) {
		this.c_Type = c_Type;
	}
	public String getC_VIN() {
		return c_VIN;
	}
	public void setC_VIN(String c_VIN) {
		this.c_VIN = c_VIN;
	}
	public String getC_Motor() {
		return c_Motor;
	}
	public void setC_Motor(String c_Motor) {
		this.c_Motor = c_Motor;
	}
	public String getC_Color() {
		return c_Color;
	}
	public void setC_Color(String c_Color) {
		this.c_Color = c_Color;
	}
	public long getC_Owner() {
		return c_Owner;
	}
	public void setC_Owner(long c_Owner) {
		this.c_Owner = c_Owner;
	}
	public String getC_FuelType() {
		return c_FuelType;
	}
	public void setC_FuelType(String c_FuelType) {
		this.c_FuelType = c_FuelType;
	}
	public Date getC_BuyDate() {
		return c_BuyDate;
	}
	public void setC_BuyDate(Date c_BuyDate) {
		this.c_BuyDate = c_BuyDate;
	}
	public Double getC_Legend() {
		return c_Legend;
	}
	public void setC_Legend(Double c_Legend) {
		this.c_Legend = c_Legend;
	}
	public Double getC_MaintenanceKilometers() {
		return c_MaintenanceKilometers;
	}
	public void setC_MaintenanceKilometers(Double c_MaintenanceKilometers) {
		this.c_MaintenanceKilometers = c_MaintenanceKilometers;
	}
	public int getC_Source() {
		return c_Source;
	}
	public void setC_Source(int c_Source) {
		this.c_Source = c_Source;
	}
	public long getC_OperatingID() {
		return c_OperatingID;
	}
	public void setC_OperatingID(long c_OperatingID) {
		this.c_OperatingID = c_OperatingID;
	}
	public long getC_NetworkID() {
		return c_NetworkID;
	}
	public void setC_NetworkID(long c_NetworkID) {
		this.c_NetworkID = c_NetworkID;
	}
	public long getC_CurNetworkID() {
		return c_CurNetworkID;
	}
	public void setC_CurNetworkID(long c_CurNetworkID) {
		this.c_CurNetworkID = c_CurNetworkID;
	}
	public long getC_RecordID() {
		return c_RecordID;
	}
	public void setC_RecordID(long c_RecordID) {
		this.c_RecordID = c_RecordID;
	}
	public Date getC_RecordTime() {
		return c_RecordTime;
	}
	public void setC_RecordTime(Date c_RecordTime) {
		this.c_RecordTime = c_RecordTime;
	}
	public int getC_AuditStatus() {
		return c_AuditStatus;
	}
	public void setC_AuditStatus(int c_AuditStatus) {
		this.c_AuditStatus = c_AuditStatus;
	}
	public int getC_AuditPersonID() {
		return c_AuditPersonID;
	}
	public void setC_AuditPersonID(int c_AuditPersonID) {
		this.c_AuditPersonID = c_AuditPersonID;
	}
	public Date getC_AuditTime() {
		return c_AuditTime;
	}
	public void setC_AuditTime(Date c_AuditTime) {
		this.c_AuditTime = c_AuditTime;
	}
	public long getC_ModifyPersonID() {
		return c_ModifyPersonID;
	}
	public void setC_ModifyPersonID(long c_ModifyPersonID) {
		this.c_ModifyPersonID = c_ModifyPersonID;
	}
	public Date getC_ModifyTime() {
		return c_ModifyTime;
	}
	public void setC_ModifyTime(Date c_ModifyTime) {
		this.c_ModifyTime = c_ModifyTime;
	}
	
	

}
