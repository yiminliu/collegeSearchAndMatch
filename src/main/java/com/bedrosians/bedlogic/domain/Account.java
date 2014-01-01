package com.bedrosians.bedlogic.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="arm")
public class Account{

	private String accountId;		
	private String accountName;	
	private String creditStatus;	
	private String activityStatus;	
	private String addressStreeLine1;	
	private String addressStreeLine2;	
	private String addressCity;	
	private String addressState;	
	private String addressZip;		
	private String ownerFirstName;	
	private String ownerLastName;	
	private String ownerDriverLicenseNo;	
	//private String bankcruptcyCaseNo;		
	private List<CheckPayment> checkPayments = new ArrayList<CheckPayment>(0);		
	private Set<AccountPhone> accountPhones = new HashSet<AccountPhone>(0);
	private Set<AccountUser> accountUsers = new HashSet<AccountUser>(0);
	private Set<AccountBranch> accountBranches = new HashSet<AccountBranch>(0);
			
	public Account() {
	}
	
	public Account(String accountId, String accountName,
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

	@Column(name="CoAddr1")
	public String getAddressStreeLine1() {
		return addressStreeLine1;
	}

	public void setAddressStreeLine1(String addressStreeLine1) {
		this.addressStreeLine1 = addressStreeLine1;
	}

	@Column(name="CoAddr2")
	public String getAddressStreeLine2() {
		return addressStreeLine2;
	}

	public void setAddressStreeLine2(String addressStreeLine2) {
		this.addressStreeLine2 = addressStreeLine2;
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

	@Column(name="OwnerFirstName")
	public String getOwnerFirstName() {
		return ownerFirstName;
	}

	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}

	@Column(name="OwnerLastName")
	public String getOwnerLastName() {
		return ownerLastName;
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}

	@Column(name="OwnerDriverLicNbr")
	public String getOwnerDriverLicenseNo() {
		return ownerDriverLicenseNo;
	}

	public void setOwnerDriverLicenseNo(String ownerDriverLicenseNo) {
		this.ownerDriverLicenseNo = ownerDriverLicenseNo;
	}

	@OneToMany(fetch=FetchType.EAGER, mappedBy="account", cascade = CascadeType.ALL)
	//@LazyCollection(LazyCollectionOption.FALSE) 
	public Set<AccountPhone> getAccountPhones() {
		return accountPhones;
	}
	
	public void addPhone(AccountPhone newPhone){
		if(accountPhones != null) {
		   newPhone.setAccount(this); 
		   accountPhones.add(newPhone);
		   //setPhoneNumbers(phoneNumbers);
		}
	}
	    
	public void setAccountPhones(Set<AccountPhone> accountPhones) {
	    this.accountPhones = accountPhones;
	}
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "account", cascade = CascadeType.ALL)
	public Set<AccountUser> getAccountUsers() {
		return accountUsers;
	}

	public void setAccountUsers(Set<AccountUser> accountUsers) {
		this.accountUsers = accountUsers;
	}	

	@OneToMany(mappedBy = "branchPK.custcd", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<AccountBranch> getAccountBranches() {
		return accountBranches;
	}

	public void setAccountBranches(Set<AccountBranch> accountBranches) {
		this.accountBranches = accountBranches;
	}
	
	//@Column(name="caseNo")
	//public String getBankcruptcyCaseNo() {
	//	return bankcruptcyCaseNo;
	//}

	//public void setBankcruptcyCaseNo(String bankcruptcyCaseNo) {
	//	this.bankcruptcyCaseNo = bankcruptcyCaseNo;
	//}

	@Transient
	public List<CheckPayment> getCheckPayments() {
		return checkPayments;
	}

	public void setCheckPayments(List<CheckPayment> checkPayments) {
		this.checkPayments = checkPayments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountId == null) ? 0 : accountId.hashCode());
		result = prime * result
				+ ((accountName == null) ? 0 : accountName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Account))
			return false;
		Account other = (Account) obj;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		if (accountName == null) {
			if (other.accountName != null)
				return false;
		} else if (!accountName.equals(other.accountName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return
				"Account [accountId=" + accountId 
				+ ", accountName=" + accountName 
				+ ", creditStatus=" + creditStatus
				+ ", activityStatus=" + activityStatus 
				+ ", addressStreeLine1=" + addressStreeLine1 
				+ ", addressStreeLine2=" + addressStreeLine2 
				+ ", addressCity=" + addressCity
				+ ", addressState=" + addressState 
				+ ", addressZip="  + addressZip 
				+ ", ownerFirstName=" + ownerFirstName
				+ ", ownerLastName=" + ownerLastName
				+ ", ownerDriverLicenseNo=" + ownerDriverLicenseNo
				+ ", checkPayments=" + checkPayments 
				+ ", accountPhones=" + accountPhones
				+ ", accountBranches=" + accountBranches
				+ "]";
	}
				
}
