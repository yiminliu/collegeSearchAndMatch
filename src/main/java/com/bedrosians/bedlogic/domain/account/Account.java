package com.bedrosians.bedlogic.domain.account;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.stereotype.Component;

import com.bedrosians.bedlogic.util.ActivityStatus;
import com.bedrosians.bedlogic.util.FormatUtil;

@Component
@MappedSuperclass

public class Account {

	@Id
	@GeneratedValue(generator = "account_id_generator")
	@GenericGenerator(name = "account_id_generator", strategy = "com.bedrosians.bedlogic.util.IdGenerator")
	@Column(name = "CustCd")
	private String accountId;
	@Column(name = "CoName")
	private String accountName;
		
	@Column(name = "CoAddr1")
	protected String streeLine1;	
	@Column(name = "CoAddr2")
	protected String streeLine2;	
	@Column(name = "CoCity")
	protected String city;	
	@Column(name = "CoStateCd")
	protected String state;
	@Column(name = "CoZip")
	protected String zip;		
	@Column(name = "CoCountryCd")
	protected String country;
		
	@Column(name = "CreditStatus")
	private String creditStatus;
	@Column(name = "InactiveCd")
	private String activityStatus;
	@Column(name = "OwnerFirstName")
	private String ownerFirstName;
	@Column(name = "OwnerLastName")
	private String ownerLastName;
	@Column(name = "OwnerDriverLicNbr")
	private String ownerDriverLicenseNo;
	@Column(name = "TreatAsStore")
	private String treatAsStore;
	@Column(name = "vendor", columnDefinition = "char default 'N'")
	private String vendor;
	@Column(name = "OurArContact")
    private String accountManager;
	
	@OneToMany(mappedBy = "branchPK.accountId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<AccountBranchId> accountBranches = new HashSet<>(0);

	//@Embedded
    //protected Address address=null;
	
	// private String bankcruptcyCaseNo;
	// private List<CheckPayment> checkPayments = new ArrayList<CheckPayment>(0);
	// private Set<AccountPhone> accountPhones = new HashSet<AccountPhone>(0);
	// private Set<User> accountUsers = new HashSet<User>(0);
	// private Set<BranchPK> brancheIds = new HashSet<>(0);
	
	protected Account() {
	}

	public String getAccountId() {
		return FormatUtil.process(accountId);
	}

	private void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	public String getAccountName() {
		return FormatUtil.process(accountName);
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public String getStreeLine1() {
		return FormatUtil.process(streeLine1);
	}

	public void setStreeLine1(String streeLine1) {
		this.streeLine1 = streeLine1;
	}

	public String getStreeLine2() {
		return FormatUtil.process(streeLine2);
	}

	public void setStreeLine2(String streeLine2) {
		this.streeLine2 = streeLine2;
	}

	public String getCity() {
		return FormatUtil.process(city);
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return FormatUtil.process(state);
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return FormatUtil.process(zip);
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return FormatUtil.process(country);
	}

	public void setCountry(String country) {
		this.country = country;
	}

	//@Column(name = "CreditStatus")
	public String getCreditStatus() {
		return FormatUtil.process(creditStatus);
	}

	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}

	public String getActivityStatus() {
		if (activityStatus == null || activityStatus.trim().length() < 1)
			activityStatus = ActivityStatus.ACTIVE.getName();
		else
			activityStatus = ActivityStatus.INACTIVE.getName();
		return FormatUtil.process(activityStatus);
	}

	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}
  
	public String getTreatAsStore() {
		return FormatUtil.process(treatAsStore);
	}

	public void setTreatAsStore(String treatAsStore) {
		this.treatAsStore = treatAsStore;
	}

	public String getVendor() {
		return FormatUtil.process(vendor);
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
    
	public String getOwnerFirstName() {
		return FormatUtil.process(ownerFirstName);
	}

	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}

	public String getOwnerLastName() {
		return FormatUtil.process(ownerLastName);
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}

	public String getOwnerDriverLicenseNo() {
		return FormatUtil.process(ownerDriverLicenseNo);
	}

	public void setOwnerDriverLicenseNo(String ownerDriverLicenseNo) {
		this.ownerDriverLicenseNo = ownerDriverLicenseNo;
	}

	public String getAccountManager() {
		return FormatUtil.process(accountManager);
	}

	public void setAccountManager(String accountManager) {
		this.accountManager = accountManager;
	}

	//@OneToMany(mappedBy = "branchPK.accountId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<AccountBranchId> getAccountBranches() {
		return accountBranches;
	}

	public void setAccountBranches(Set<AccountBranchId> accountBranches) {
		this.accountBranches = accountBranches;
	}
		
	/*
	 public Set<User> getAccountUsers() { return accountUsers; }
	  
	 public void setAccountUsers(Set<User> accountUsers) { this.accountUsers =
	 accountUsers; }
	  
	 @Transient public List<CheckPayment> getCheckPayments() { return
	 checkPayments; }
	 
	 public void setCheckPayments(List<CheckPayment> checkPayments) {
	 this.checkPayments = checkPayments; }
	 
		
	 @Column(name="caseNo")
	 public String getBankcruptcyCaseNo() {
	 return bankcruptcyCaseNo;
	 }

	 public void setBankcruptcyCaseNo(String bankcruptcyCaseNo) {
	 this.bankcruptcyCaseNo = bankcruptcyCaseNo;
	 }
	*/	 
	
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
		return "Account [accountId=" + accountId + ", "
				+ "accountName=" + accountName
				+ ", creditStatus=" + creditStatus 
				+ ", activityStatus=" + activityStatus
				+ ", streeLine1=" + streeLine1
				+ ", streeLine2=" + streeLine2
				+", city=" + city
				+ ", state=" + state
				+ ", zip=" + zip
				+ ", country=" + country
				+ ", ownerFirstName=" + ownerFirstName 
				+ ", ownerLastName=" + ownerLastName 
				+ ", ownerDriverLicenseNo=" + ownerDriverLicenseNo
				//+ ", treatAsStore=" + treatAsStore
				//+ ", isSlabStore=" + isSlabStore + ", vendor=" + vendor
				//+ ", apContact=" + apContact + ", apPhone=" + apPhone
				//+ ", apExt=" + apExt + ", apCellphone=" + apCellphone
				//+ ", apFax=" + apFax + ", apEmail=" + apEmail + ", apNotes="	+ apNotes
				+  ", accountManager=" + accountManager
				+ ", accountBranches=" + accountBranches + "]";
	}


}
