package com.rentcar.system.domain;

import java.io.Serializable;
import java.util.Date;

public class Contract implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long contractID;
	private String partyA;
	private String partyB;
	private long network_ID;
	private long recordPersonID;
	private String recordPersonName;
	private Date recordTime;
	private long auditPersonID;
	private String auditPersonName;
	private Date auditTime;
	private int status;
	public long getContractID() {
		return contractID;
	}
	public void setContractID(long contractID) {
		this.contractID = contractID;
	}
	public String getPartyA() {
		return partyA;
	}
	public void setPartyA(String partyA) {
		this.partyA = partyA;
	}
	public String getPartyB() {
		return partyB;
	}
	public void setPartyB(String partyB) {
		this.partyB = partyB;
	}
	public long getNetwork_ID() {
		return network_ID;
	}
	public void setNetwork_ID(long network_ID) {
		this.network_ID = network_ID;
	}
	public long getRecordPersonID() {
		return recordPersonID;
	}
	public void setRecordPersonID(long recordPersonID) {
		this.recordPersonID = recordPersonID;
	}
	public String getRecordPersonName() {
		return recordPersonName;
	}
	public void setRecordPersonName(String recordPersonName) {
		this.recordPersonName = recordPersonName;
	}
	public Date getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
	public long getAuditPersonID() {
		return auditPersonID;
	}
	public void setAuditPersonID(long auditPersonID) {
		this.auditPersonID = auditPersonID;
	}
	public String getAuditPersonName() {
		return auditPersonName;
	}
	public void setAuditPersonName(String auditPersonName) {
		this.auditPersonName = auditPersonName;
	}
	public Date getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	

}
