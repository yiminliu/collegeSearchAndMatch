package com.bedrosians.bedlogic.domain.account;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.bedrosians.bedlogic.domain.user.User;


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
	//private List<CheckPayment> checkPayments = new ArrayList<CheckPayment>(0);		
	//private Set<AccountPhone> accountPhones = new HashSet<AccountPhone>(0);
	//private Set<User> accountUsers = new HashSet<User>(0);
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
	@GeneratedValue(generator="account_id_generator") //strategy = GenerationType.IDENTITY) 
	//@GeneratedValue()//strategy = GenerationType.AUTO)//, generator="my_entity_seq_gen")
	//@SequenceGenerator(name="my_entity_seq_gen", sequenceName="arm_crapp_seqnbr_seq")
	@GenericGenerator(name="account_id_generator", strategy="com.bedrosians.bedlogic.util.IdGenerator")
	//@GenericGenerator(name="account_id_generator", strategy="com.bedrosians.bedlogic.dao.account.IdGenerator")
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
		return new String(accountName);
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	@Column(name="CreditStatus")
	public String getCreditStatus() {
		if (creditStatus != null) creditStatus= creditStatus.trim();
		return new String(creditStatus);
	}
	
	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}
	
	@Column(name="InactiveCd")
	public String getActivityStatus() {
		if (activityStatus != null) activityStatus = activityStatus.trim();
		return new String(activityStatus);
	}
	
	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}

	@Column(name="CoAddr1")
	public String getAddressStreeLine1() {
		if (addressStreeLine1 != null) 
			addressStreeLine1 = addressStreeLine1.trim();
		return new String (addressStreeLine1);
	}

	public void setAddressStreeLine1(String addressStreeLine1) {
		this.addressStreeLine1 = addressStreeLine1;
	}

	@Column(name="CoAddr2")
	public String getAddressStreeLine2() {
		if (addressStreeLine2 != null) 
			addressStreeLine2 = addressStreeLine2.trim();
		return new String(addressStreeLine2);
	}

	public void setAddressStreeLine2(String addressStreeLine2) {
		this.addressStreeLine2 = addressStreeLine2;
	}
	
	@Column(name="CoCity")
	public String getAddressCity() {
		if (addressCity != null) addressCity = addressCity.trim();
		return new String(addressCity);
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	
	@Column(name="CoStateCd")
	public String getAddressState() {
		if (addressState != null) addressState = addressState.trim();
		return new String(addressState);
	}
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}
	
	@Column(name="CoZip")
	public String getAddressZip() {
		if (addressZip != null) addressZip = addressZip.trim(); 
		return new String(addressZip);
	}
	
	public void setAddressZip(String addressZip) {
		this.addressZip = addressZip;
	}

	@Column(name="OwnerFirstName")
	public String getOwnerFirstName() {
		if (ownerFirstName != null) ownerFirstName = ownerFirstName.trim(); 
		return new String(ownerFirstName);
	}

	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}

	@Column(name="OwnerLastName")
	public String getOwnerLastName() {
		if (ownerLastName != null) ownerLastName = ownerLastName.trim(); 
		return new String(ownerLastName);
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}

	@Column(name="OwnerDriverLicNbr")
	public String getOwnerDriverLicenseNo() {
		if (ownerDriverLicenseNo != null) ownerDriverLicenseNo = ownerDriverLicenseNo.trim(); 
		return new String(ownerDriverLicenseNo);
	}

	public void setOwnerDriverLicenseNo(String ownerDriverLicenseNo) {
		this.ownerDriverLicenseNo = ownerDriverLicenseNo;
	}

	/*@OneToMany(mappedBy="account", fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
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
	*/
	
	/*
	public Set<User> getAccountUsers() {
		return accountUsers;
	}

	public void setAccountUsers(Set<User> accountUsers) {
		this.accountUsers = accountUsers;
	}	
	
	@Transient
	public List<CheckPayment> getCheckPayments() {
		return checkPayments;
	}

	public void setCheckPayments(List<CheckPayment> checkPayments) {
		this.checkPayments = checkPayments;
	}
    */
	
	@OneToMany(mappedBy = "branchPK.accountId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

	/*@Override
	public String toString() {
		return
				try {
		            // takes advantage of toString() implementation to format {"a":"b"}
		            return new JSONObject().put("fn", fn).put("ln", ln).toString();
		        } catch (JSONException e) {
		            return null;
		        }
		
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
				//+ ", checkPayments=" + checkPayments 
				//+ ", accountPhones=" + accountPhones
				//+ ", accountBranches=" + accountBranches
				+ "]";
	}*/
	
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
				//+ ", checkPayments=" + checkPayments 
				//+ ", accountPhones=" + accountPhones
				//+ ", accountBranches=" + accountBranches
				+ "]";
	}
				
}
