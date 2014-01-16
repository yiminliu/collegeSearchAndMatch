package com.bedrosians.bedlogic.domain.account;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;

import com.bedrosians.bedlogic.util.ActivityStatus;
import com.bedrosians.bedlogic.util.FormatUtil;


/**
 * @author
 * 
 */
@XmlRootElement(name = "account")
//@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Entity(name = "account")
@Table(name = "arm")
public class Account {

	private String accountId="";
	private String accountName="";
	private String companyName="";
	private String creditStatus="";
	private String activityStatus="";
	private String addressStreeLine1="";
	private String addressStreeLine2="";
	private String city="";
	private String state="";
	private String zip="";
	private String country="";
	
	private String ownerFirstName="";
	private String ownerLastName="";
	private String ownerDriverLicenseNo="";

	
	private String treatAsStore;
	private String isSlabStore;
	private String vendor;
  
	private String apContact;
	private String apPhone;
	private String apExt;
	private String apCellphone;
	private String apFax;
	private String apEmail;
	private String apNotes;
    
	private String accountManager;

	/*
	 * private String slsContact; private String slsPhone; private String
	 * slsExt; private String slsCellphone; private String slsFax; private
	 * String slsEmail; private String slsNotes;
	 */

	// private String bankcruptcyCaseNo;
	// private List<CheckPayment> checkPayments = new
	// ArrayList<CheckPayment>(0);
	// private Set<AccountPhone> accountPhones = new HashSet<AccountPhone>(0);
	// private Set<User> accountUsers = new HashSet<User>(0);
	// private Set<BranchPK> brancheIds = new HashSet<>(0);
	// private Set<AccountBranch> accountBranches = new
	// HashSet<AccountBranch>(0);

	private Set<AccountBranchId> accountBranches = new HashSet<>(0);

	public Account() {
	}

	public Account(String accountId, String accountName, String creditStatus,
			String activityStatus, String city, String state,
			String zip) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.creditStatus = creditStatus;
		this.activityStatus = activityStatus;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	@Id
	@GeneratedValue(generator = "account_id_generator")
	// strategy = GenerationType.IDENTITY)
	// @GeneratedValue()//strategy = GenerationType.AUTO)//,
	// generator="my_entity_seq_gen")
	// @SequenceGenerator(name="my_entity_seq_gen",
	// sequenceName="arm_crapp_seqnbr_seq")
	@GenericGenerator(name = "account_id_generator", strategy = "com.bedrosians.bedlogic.util.IdGenerator")
	// @GenericGenerator(name="account_id_generator",
	// strategy="com.bedrosians.bedlogic.dao.account.IdGenerator")
	@Column(name = "CustCd")
	public String getAccountId() {
		if (accountId != null)
			accountId = accountId.trim();
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@Column(name = "CoName")
	public String getAccountName() {
		if (accountName != null)
			accountName = accountName.trim();
		return new String(accountName);
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	
	@Column(name="Dba") 
	public String getCompanyName() { return
	   FormatUtil.trimAndReplicate(companyName); 
	}
	
	public void setCompanyName(String companyName) { this.companyName =
	 companyName; 
	}
	
	@Column(name = "CreditStatus")
	public String getCreditStatus() {
		return FormatUtil.trimAndReplicate(creditStatus);
	}

	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}

	@Column(name = "InactiveCd")
	public String getActivityStatus() {
		if (activityStatus == null || activityStatus.trim().length() < 1)
			activityStatus = ActivityStatus.ACTIVE.getName();
		else
			activityStatus = ActivityStatus.INACTIVE.getName();
		return activityStatus;
	}

	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}

	@Column(name = "CoAddr1")
	public String getAddressStreeLine1() {
		return FormatUtil.trimAndReplicate(addressStreeLine1);
	}

	public void setAddressStreeLine1(String addressStreeLine1) {
		this.addressStreeLine1 = addressStreeLine1;
	}

	@Column(name = "CoAddr2")
	public String getAddressStreeLine2() {
		return FormatUtil.trimAndReplicate(addressStreeLine2);
	}

	public void setAddressStreeLine2(String addressStreeLine2) {
		this.addressStreeLine2 = addressStreeLine2;
	}

	@Column(name = "CoCity")
	public String getCity() {
		return FormatUtil.trimAndReplicate(city);
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "CoStateCd")
	public String getState() {
		return FormatUtil.trimAndReplicate(state);
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "CoZip")
	public String getZip() {
		return FormatUtil.trimAndReplicate(zip);
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column(name = "CoCountryCd")
	public String getCountry() {
		return FormatUtil.trimAndReplicate(country);
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "TreatAsStore")
	public String getTreatAsStore() {
		return FormatUtil.trimAndReplicate(treatAsStore);
	}

	public void setTreatAsStore(String treatAsStore) {
		this.treatAsStore = treatAsStore;
	}

	@Column(name = "Slab")
	public String getIsSlabStore() {
		return FormatUtil.trimAndReplicate(isSlabStore);
	}

	public void setIsSlabStore(String isSlabStore) {
		this.isSlabStore = isSlabStore;
	}

	@Column(name = "vendor")
	public String getVendor() {
		return FormatUtil.trimAndReplicate(vendor);
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
    
	@Column(name = "OwnerFirstName")
	public String getOwnerFirstName() {
		return FormatUtil.trimAndReplicate(ownerFirstName);
	}

	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}

	@Column(name = "OwnerLastName")
	public String getOwnerLastName() {
		return FormatUtil.trimAndReplicate(ownerLastName);
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}

	@Column(name = "OwnerDriverLicNbr")
	public String getOwnerDriverLicenseNo() {
		return FormatUtil.trimAndReplicate(ownerDriverLicenseNo);
	}

	public void setOwnerDriverLicenseNo(String ownerDriverLicenseNo) {
		this.ownerDriverLicenseNo = ownerDriverLicenseNo;
	}

	/*
	 * @OneToMany(mappedBy="account", fetch=FetchType.EAGER, cascade =
	 * CascadeType.ALL, orphanRemoval=true) public Set<AccountPhone>
	 * getAccountPhones() { return accountPhones; }
	 * 
	 * public void addPhone(AccountPhone newPhone){ if(accountPhones != null) {
	 * newPhone.setAccount(this); accountPhones.add(newPhone);
	 * //setPhoneNumbers(phoneNumbers); } }
	 * 
	 * public void setAccountPhones(Set<AccountPhone> accountPhones) {
	 * this.accountPhones = accountPhones; }
	 */

	@Column(name = "apcontact")
	public String getApContact() {
		return FormatUtil.trimAndReplicate(apContact);
	}

	public void setApContact(String apContact) {
		this.apContact = apContact;
	}

	@Column(name = "apphone")
	public String getApPhone() {
		return FormatUtil.trimAndReplicate(apPhone);
	}

	public void setApPhone(String apPhone) {
		this.apPhone = apPhone;
	}

	@Column(name = "apext")
	public String getApExt() {
		return FormatUtil.trimAndReplicate(apExt);
	}

	public void setApExt(String apExt) {
		this.apExt = apExt;
	}

	@Column(name = "apcellphone")
	public String getApCellphone() {
		return FormatUtil.trimAndReplicate(apCellphone);
	}

	public void setApCellphone(String apCellphone) {
		this.apCellphone = apCellphone;
	}

	@Column(name = "apfax")
	public String getApFax() {
		return FormatUtil.trimAndReplicate(apFax);
	}

	public void setApFax(String apFax) {
		this.apFax = apFax;
	}

	@Column(name = "apemail")
	public String getApEmail() {
		return FormatUtil.trimAndReplicate(apEmail);
	}

	public void setApEmail(String apEmail) {
		this.apEmail = apEmail;
	}

	@Column(name = "apnotes")
	public String getApNotes() {
		return FormatUtil.trimAndReplicate(apNotes);
	}

	public void setApNotes(String apNotes) {
		this.apNotes = apNotes;
	}
    
	@Column(name = "OurArContact")
	public String getAccountManager() {
		return FormatUtil.trimAndReplicate(accountManager);
	}

	public void setAccountManager(String accountManager) {
		this.accountManager = accountManager;
	}

	/*
	 * @Column(name="slscontact") public String getSlsContact() { return
	 * FormatUtil.trimAndReplicate(slsContact); }
	 * 
	 * public void setSlsContact(String slsContact) { this.slsContact =
	 * slsContact; }
	 * 
	 * @Column(name="slsphone") public String getSlsPhone() { return
	 * FormatUtil.trimAndReplicate(slsPhone); }
	 * 
	 * public void setSlsPhone(String slsPhone) { this.slsPhone = slsPhone; }
	 * 
	 * @Column(name="slsext") public String getSlsExt() { return
	 * FormatUtil.trimAndReplicate(slsExt); }
	 * 
	 * public void setSlsExt(String slsext) { this.slsExt = slsExt; }
	 * 
	 * @Column(name="slscellphone") public String getSlsCellphone() { return
	 * FormatUtil.trimAndReplicate(slsCellphone); }
	 * 
	 * public void setSlsCellphone(String slsCellphone) { this.slsCellphone =
	 * slsCellphone; }
	 * 
	 * @Column(name="slsfax") public String getSlsFax() { return
	 * FormatUtil.trimAndReplicate(slsFax); }
	 * 
	 * public void setSlsFax(String slsFax) { this.slsFax = slsFax; }
	 * 
	 * @Column(name="slsemail") public String getSlsEmail() { return
	 * FormatUtil.trimAndReplicate(slsEmail); }
	 * 
	 * public void setSlsEmail(String slsEmail) { this.slsEmail = slsEmail; }
	 * 
	 * @Column(name="slsnotes") public String getSlsNotes() { return
	 * FormatUtil.trimAndReplicate(slsNotes); }
	 * 
	 * public void setSlsNotes(String slsNotes) { this.slsNotes = slsNotes; }
	 */

	/*
	 * public Set<User> getAccountUsers() { return accountUsers; }
	 * 
	 * public void setAccountUsers(Set<User> accountUsers) { this.accountUsers =
	 * accountUsers; }
	 * 
	 * @Transient public List<CheckPayment> getCheckPayments() { return
	 * checkPayments; }
	 * 
	 * public void setCheckPayments(List<CheckPayment> checkPayments) {
	 * this.checkPayments = checkPayments; }
	 */
	@OneToMany(mappedBy = "branchPK.accountId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<AccountBranchId> getAccountBranches() {
		return accountBranches;
	}

	public void setAccountBranches(Set<AccountBranchId> accountBranches) {
		this.accountBranches = accountBranches;
	}

	/*
	 * @OneToMany(mappedBy = "branchPK.accountId", fetch = FetchType.EAGER,
	 * cascade = CascadeType.ALL) public Set<AccountBranch> getAccountBranches()
	 * { return accountBranches; }
	 * 
	 * public void setAccountBranches(Set<AccountBranch> accountBranches) {
	 * this.accountBranches = accountBranches; }
	 */

	/*
	 * @OneToMany(mappedBy = "branchPK.accountId", fetch = FetchType.EAGER,
	 * cascade = CascadeType.ALL) public Set<BranchPK> getBrancheIds() { return
	 * brancheIds; }
	 * 
	 * public void setBrancheds(Set<BranchPK> brancheIds) { this.brancheIds =
	 * brancheIds; }
	 */

	// @Column(name="caseNo")
	// public String getBankcruptcyCaseNo() {
	// return bankcruptcyCaseNo;
	// }

	// public void setBankcruptcyCaseNo(String bankcruptcyCaseNo) {
	// this.bankcruptcyCaseNo = bankcruptcyCaseNo;
	// }

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
		return "Account [accountId=" + accountId + ", accountName="
				+ accountName + ", companyName=" + companyName
				+ ", creditStatus=" + creditStatus + ", activityStatus="
				+ activityStatus + ", addressStreeLine1=" + addressStreeLine1
				+ ", addressStreeLine2=" + addressStreeLine2 + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", country=" + country
				+ ", ownerFirstName=" + ownerFirstName + ", ownerLastName="
				+ ownerLastName + ", ownerDriverLicenseNo="
				+ ownerDriverLicenseNo + ", treatAsStore=" + treatAsStore
				+ ", isSlabStore=" + isSlabStore + ", vendor=" + vendor
				+ ", apContact=" + apContact + ", apPhone=" + apPhone
				+ ", apExt=" + apExt + ", apCellphone=" + apCellphone
				+ ", apFax=" + apFax + ", apEmail=" + apEmail + ", apNotes="
				+ apNotes + ", accountManager=" + accountManager
				+ ", accountBranches=" + accountBranches + "]";
	}


}
