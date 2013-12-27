package com.bedrosians.bedlogic.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="arm")
public class SimpleAccount extends Account{

	private String accountId;
	
	private String accountName;
	
	private String creditStatus;
	
	private String activityStatus;
	
	private String addressCity;
	
	private String addressState;
	
	private String addressZip;

	public SimpleAccount() {
		super();
	}
	
	public SimpleAccount(String accountId, String accountName,
			String creditStatus, String activityStatus, String addressCity,
			String addressState, String addressZip) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.creditStatus = creditStatus;
		this.activityStatus = activityStatus;
		this.addressCity = addressCity;
		this.addressState = addressState;
		this.addressZip = addressZip;
	}

	@Id
	@Column(name="CustCd")
	public String getAccountId() {
		if (accountId != null) accountId = accountId.trim();
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	@Column(name="CoName")
	public String getAccountName() {
		if (accountName != null) accountName = accountName.trim();
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	@Column(name="CreditStatus")
	public String getCreditStatus() {
		if (creditStatus != null) creditStatus= creditStatus.trim();
		return creditStatus;
	}
	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}
	
	@Column(name="InactiveCd")
	public String getActivityStatus() {
		if (activityStatus != null) activityStatus = activityStatus.trim();
		return activityStatus;
	}
	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}
	
	@Column(name="CoCity")
	public String getAddressCity() {
		if (addressCity != null) addressCity = addressCity.trim();
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	
	@Column(name="CoStateCd")
	public String getAddressState() {
		if (addressState != null) addressState = addressState.trim();
		return addressState;
	}
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}
	
	@Column(name="CoZip")
	public String getAddressZip() {
		if (addressZip != null) addressZip = addressZip.trim(); 
		return addressZip;
	}
	public void setAddressZip(String addressZip) {
		this.addressZip = addressZip;
	}
	
}
