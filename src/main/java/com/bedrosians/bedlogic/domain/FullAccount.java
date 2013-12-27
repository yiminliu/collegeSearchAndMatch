package com.bedrosians.bedlogic.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="arm")
public class FullAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 674944990758703320L;

	@Id
	@Column(name="CustCd")
	private String accountId;
	
	@Column(name="CoName")
	private String accountName;
	
	@Column(name="Dba")
	private String dba;
	
	@Column(name="CoAddr1")
	private String addressStreeLine1;
	
	@Column(name="CoAddr2")
	private String addressStreeLine2;
	
	@Column(name="CoCity")
	private String addressCity;
	
	@Column(name="CoStateCd")
	private String addressState;
	
	@Column(name="CoZip")
	private String addressZip;
	
	@Column(name="CoCountryCd")
	private String addressCountry;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="account")
	@Cascade(CascadeType.ALL)
	private Set<AccountPhone> phoneNumbers;
	
	@Column(name="InactiveCd")
	private String activityStatus;

	@Column(name="Slab")
	private String isSlabStore;
	
	@Column(name="Judment_Date")
	private String judgementDate;
	
	@Column(name="BuyingGroup")
	private String buyingGroup;
	
	/*
	@Column(name="")
	private String vendorNo;
	
	@Column(name="")
	private String contractorNo;
	*/
	
	@Column(name="OwnerFirstName")
	private String ownerFirstName;
	
	@Column(name="OwnerLastName")
	private String ownerLastName;
	
	@Column(name="OwnerDriverLicNbr")
	private String ownerDriverLicenseNo;
	
	@Column(name="TreatAsStore")
	private String treatAsStore;
	
	/*
	@Column(name="")
	private String websiteURL;
	*/
	/*
	@OneToMany(fetch=FetchType.EAGER, mappedBy="account")
	@Cascade(CascadeType.ALL)
	private Set<TransactionNote> notes = new HashSet<TransactionNote>();
	*/
	
	@Column(name="StmtFreq_M")
	private String paperStatementMailingFrequency;
	
	@Column(name="StmtFreq_E")
	private String emailStatementMailingFrequency;
	
	@Column(name="InvFreq_M")
	private String paperInvoiceMailingFrequency;
	
	@Column(name="InvFreq_E")
	private String emailInvoiceMailingFrequency;
	
	@Column(name="nsf_count")
	private int nonSufficientFundChecks;
	
	@Transient
	private List<CheckPayment> checkPayments;
	
	@Column(name="CreditLimit")
	private String creditLimit;
	
	@Column(name="Lock_Hold")
	private String lockHold;
	
	@Column(name="CreditStatus")
	private String creditStatus;
	
	@Column(name="CredStatNote")
	private String creditARNote;
	
	@Column(name="PmtTermsCd")
	private String paymentTerm;
	
	/*
	@Column(name="")
	private String bankcruptcyCaseNo;
	*/
	
	@Column(name="PoRequired")
	private String PORequired;
	
	@Column(name="JointCheck")
	private String jointCheck;
	
	@Column(name="PreLienReq")
	private String preLienRequired;
	
	@Column(name="PreLienLimit")
	private String preLienLimit;
	
	@Column(name="FinChgRate")
	private String latePaymentChargeRate;
	
	@Column(name="LastCredApRecvdDate")
	private String lastCreditApprovalDate;
	
	@Column(name="Voucher")
	private String isVoucherAccount;
	
	@Column(name="ConsolidStmt")
	private String isConsolidatedPayment;
	
	@Column(name="PrintPricingOnInv")
	private String priceOnInvoice;
	
	@Column(name="RequireJobInfo")
	private String requireJobInfo;
	
	@Column(name="BusEstablishDate")
	private String bizEstablishedDate;
	
	/*
	@OneToMany(fetch=FetchType.EAGER, mappedBy="account")
	@Cascade(CascadeType.ALL)
	private List<TransactionNote> accountSales = new ArrayList<TransactionNote>();
	*/
	
	@Column(name="OurArContact")
	private String accountManager;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="account")
	@Cascade(CascadeType.ALL)
	private Set<AccountUser> contacts;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="simpleBranchPK.account")
	@Cascade(CascadeType.ALL)
	private Set<SimpleAccountBranch> branches;

	public FullAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FullAccount(String accountId, String accountName, String dba,
			String addressStreeLine1, String addressStreeLine2,
			String addressCity, String addressState, String addressZip,
			String addressCountry, Set<AccountPhone> phoneNumbers,
			String activityStatus, String isSlabStore, String judgementDate,
			String buyingGroup, String ownerFirstName, String ownerLastName,
			String ownerDriverLicenseNo, String treatAsStore,
			String paperStatementMailingFrequency,
			String emailStatementMailingFrequency,
			String paperInvoiceMailingFrequency,
			String emailInvoiceMailingFrequency, String creditLimit,
			String lockHold, String creditStatus, String creditARNote,
			String paymentTerm, String pORequired, String jointCheck,
			String preLienRequired, String preLienLimit,
			String latePaymentChargeRate, String lastCreditApprovalDate,
			String isVoucherAccount, String isConsolidatedPayment,
			String priceOnInvoice, String requireJobInfo,
			String bizEstablishedDate, String accountManager,
			Set<AccountUser> contacts, Set<SimpleAccountBranch> branches) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.dba = dba;
		this.addressStreeLine1 = addressStreeLine1;
		this.addressStreeLine2 = addressStreeLine2;
		this.addressCity = addressCity;
		this.addressState = addressState;
		this.addressZip = addressZip;
		this.addressCountry = addressCountry;
		this.phoneNumbers = phoneNumbers;
		this.activityStatus = activityStatus;
		this.isSlabStore = isSlabStore;
		this.judgementDate = judgementDate;
		this.buyingGroup = buyingGroup;
		this.ownerFirstName = ownerFirstName;
		this.ownerLastName = ownerLastName;
		this.ownerDriverLicenseNo = ownerDriverLicenseNo;
		this.treatAsStore = treatAsStore;
		this.paperStatementMailingFrequency = paperStatementMailingFrequency;
		this.emailStatementMailingFrequency = emailStatementMailingFrequency;
		this.paperInvoiceMailingFrequency = paperInvoiceMailingFrequency;
		this.emailInvoiceMailingFrequency = emailInvoiceMailingFrequency;
		this.creditLimit = creditLimit;
		this.lockHold = lockHold;
		this.creditStatus = creditStatus;
		this.creditARNote = creditARNote;
		this.paymentTerm = paymentTerm;
		PORequired = pORequired;
		this.jointCheck = jointCheck;
		this.preLienRequired = preLienRequired;
		this.preLienLimit = preLienLimit;
		this.latePaymentChargeRate = latePaymentChargeRate;
		this.lastCreditApprovalDate = lastCreditApprovalDate;
		this.isVoucherAccount = isVoucherAccount;
		this.isConsolidatedPayment = isConsolidatedPayment;
		this.priceOnInvoice = priceOnInvoice;
		this.requireJobInfo = requireJobInfo;
		this.bizEstablishedDate = bizEstablishedDate;
		this.accountManager = accountManager;
		this.contacts = contacts;
		this.branches = branches;
	}

	public String getAccountId() {
		if (accountId != null) accountId = accountId.trim();
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		if (accountName != null) accountName = accountName.trim();
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getDba() {
		if (dba != null) dba = dba.trim();
		return dba;
	}

	public void setDba(String dba) {
		this.dba = dba;
	}

	public String getAddressStreeLine1() {
		if (addressStreeLine1 != null) addressStreeLine1 = addressStreeLine1.trim();
		return addressStreeLine1;
	}

	public void setAddressStreeLine1(String addressStreeLine1) {
		this.addressStreeLine1 = addressStreeLine1;
	}

	public String getAddressStreeLine2() {
		if (addressStreeLine2 != null) addressStreeLine2 = addressStreeLine2.trim();
		return addressStreeLine2;
	}

	public void setAddressStreeLine2(String addressStreeLine2) {
		this.addressStreeLine2 = addressStreeLine2;
	}

	public String getAddressCity() {
		if (addressCity != null) addressCity = addressCity.trim();
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressState() {
		if (addressState != null) addressState = addressState.trim();
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	public String getAddressZip() {
		if (addressZip != null) addressZip = addressZip.trim();
		return addressZip;
	}

	public void setAddressZip(String addressZip) {
		this.addressZip = addressZip;
	}

	public String getAddressCountry() {
		if (addressCountry != null) addressCountry = addressCountry.trim();
		return addressCountry;
	}

	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}

	public Set<AccountPhone> getPhoneNumbers() {
		return phoneNumbers;
	}

	public Set<AccountUser> getContacts() {
		return contacts;
	}

	public void setContacts(Set<AccountUser> contacts) {
		this.contacts = contacts;
	}

	public void setPhoneNumbers(Set<AccountPhone> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public String getActivityStatus() {
		if (activityStatus != null) activityStatus = activityStatus.trim();
		return activityStatus;
	}

	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}

	public String getIsSlabStore() {
		if (isSlabStore != null) isSlabStore = isSlabStore.trim();
		return isSlabStore;
	}

	public void setIsSlabStore(String isSlabStore) {
		this.isSlabStore = isSlabStore;
	}

	public String getJudgementDate() {
		if (judgementDate != null) judgementDate = judgementDate.trim();
		return judgementDate;
	}

	public void setJudgementDate(String judgementDate) {
		this.judgementDate = judgementDate;
	}

	public String getBuyingGroup() {
		if (buyingGroup != null) buyingGroup = buyingGroup.trim();
		return buyingGroup;
	}

	public void setBuyingGroup(String buyingGroup) {
		this.buyingGroup = buyingGroup;
	}

	public String getOwnerFirstName() {
		if (ownerFirstName != null) ownerFirstName = ownerFirstName.trim();
		return ownerFirstName;
	}

	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}

	public String getOwnerLastName() {
		if (ownerLastName != null) ownerLastName = ownerLastName.trim();
		return ownerLastName;
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}

	public String getOwnerDriverLicenseNo() {
		if (ownerDriverLicenseNo != null) ownerDriverLicenseNo = ownerDriverLicenseNo.trim();
		return ownerDriverLicenseNo;
	}

	public void setOwnerDriverLicenseNo(String ownerDriverLicenseNo) {
		this.ownerDriverLicenseNo = ownerDriverLicenseNo;
	}

	public String getTreatAsStore() {
		if (treatAsStore != null) treatAsStore= treatAsStore.trim();
		return treatAsStore;
	}

	public void setTreatAsStore(String treatAsStore) {
		this.treatAsStore = treatAsStore;
	}

	public String getPaperStatementMailingFrequency() {
		if (paperStatementMailingFrequency != null) paperStatementMailingFrequency = paperStatementMailingFrequency.trim();
		return paperStatementMailingFrequency;
	}

	public void setPaperStatementMailingFrequency(
			String paperStatementMailingFrequency) {
		this.paperStatementMailingFrequency = paperStatementMailingFrequency;
	}

	public String getEmailStatementMailingFrequency() {
		if (emailStatementMailingFrequency != null) emailStatementMailingFrequency = emailStatementMailingFrequency.trim();
		return emailStatementMailingFrequency;
	}

	public void setEmailStatementMailingFrequency(
			String emailStatementMailingFrequency) {
		this.emailStatementMailingFrequency = emailStatementMailingFrequency;
	}

	public String getPaperInvoiceMailingFrequency() {
		if (paperInvoiceMailingFrequency != null) paperInvoiceMailingFrequency = paperInvoiceMailingFrequency.trim();
		return paperInvoiceMailingFrequency;
	}

	public void setPaperInvoiceMailingFrequency(String paperInvoiceMailingFrequency) {
		this.paperInvoiceMailingFrequency = paperInvoiceMailingFrequency;
	}

	public String getEmailInvoiceMailingFrequency() {
		if (emailInvoiceMailingFrequency != null) emailInvoiceMailingFrequency = emailInvoiceMailingFrequency.trim();
		return emailInvoiceMailingFrequency;
	}

	public void setEmailInvoiceMailingFrequency(String emailInvoiceMailingFrequency) {
		this.emailInvoiceMailingFrequency = emailInvoiceMailingFrequency;
	}

	public int getNonSufficientFundChecks() {
		return nonSufficientFundChecks;
	}

	public void setNonSufficientFundChecks(int nonSufficientFundChecks) {
		this.nonSufficientFundChecks = nonSufficientFundChecks;
	}

	public List<CheckPayment> getCheckPayments() {
		return checkPayments;
	}

	public void setCheckPayments(List<CheckPayment> checkPayments) {
		this.checkPayments = checkPayments;
	}

	public String getCreditLimit() {
		if (creditLimit != null) creditLimit = creditLimit.trim();
		return creditLimit;
	}

	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getLockHold() {
		if (lockHold != null) lockHold = lockHold.trim();
		return lockHold;
	}

	public void setLockHold(String lockHold) {
		this.lockHold = lockHold;
	}

	public String getCreditStatus() {
		if (creditStatus != null) creditStatus = creditStatus.trim();
		return creditStatus;
	}

	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}

	public String getCreditARNote() {
		if (creditARNote != null) creditARNote = creditARNote.trim();
		return creditARNote;
	}

	public void setCreditARNote(String creditARNote) {
		this.creditARNote = creditARNote;
	}

	public String getPaymentTerm() {
		if (paymentTerm != null) paymentTerm = paymentTerm.trim();
		return paymentTerm;
	}

	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public String getPORequired() {
		if (PORequired != null) PORequired = PORequired.trim();
		return PORequired;
	}

	public void setPORequired(String pORequired) {
		PORequired = pORequired;
	}

	public String getJointCheck() {
		if (jointCheck != null) jointCheck = jointCheck.trim();
		return jointCheck;
	}

	public void setJointCheck(String jointCheck) {
		this.jointCheck = jointCheck;
	}

	public String getPreLienRequired() {
		if (preLienRequired != null) preLienRequired = preLienRequired.trim();
		return preLienRequired;
	}

	public void setPreLienRequired(String preLienRequired) {
		this.preLienRequired = preLienRequired;
	}

	public String getPreLienLimit() {
		if (preLienLimit != null) preLienLimit = preLienLimit.trim();
		return preLienLimit;
	}

	public void setPreLienLimit(String preLienLimit) {
		this.preLienLimit = preLienLimit;
	}

	public String getLatePaymentChargeRate() {
		if (latePaymentChargeRate != null) latePaymentChargeRate = latePaymentChargeRate.trim();
		return latePaymentChargeRate;
	}

	public void setLatePaymentChargeRate(String latePaymentChargeRate) {
		this.latePaymentChargeRate = latePaymentChargeRate;
	}

	public String getLastCreditApprovalDate() {
		if (lastCreditApprovalDate != null) lastCreditApprovalDate = lastCreditApprovalDate.trim();
		return lastCreditApprovalDate;
	}

	public void setLastCreditApprovalDate(String lastCreditApprovalDate) {
		this.lastCreditApprovalDate = lastCreditApprovalDate;
	}

	public String getIsVoucherAccount() {
		if (isVoucherAccount != null) isVoucherAccount = isVoucherAccount.trim();
		return isVoucherAccount;
	}

	public void setIsVoucherAccount(String isVoucherAccount) {
		this.isVoucherAccount = isVoucherAccount;
	}

	public String getIsConsolidatedPayment() {
		if (isConsolidatedPayment != null) isConsolidatedPayment = isConsolidatedPayment.trim(); 
		return isConsolidatedPayment;
	}

	public void setIsConsolidatedPayment(String isConsolidatedPayment) {
		this.isConsolidatedPayment = isConsolidatedPayment;
	}

	public String getPriceOnInvoice() {
		if (priceOnInvoice != null) priceOnInvoice = priceOnInvoice.trim();
		return priceOnInvoice;
	}

	public void setPriceOnInvoice(String priceOnInvoice) {
		this.priceOnInvoice = priceOnInvoice;
	}

	public String getRequireJobInfo() {
		if (requireJobInfo != null) requireJobInfo = requireJobInfo.trim();
		return requireJobInfo;
	}

	public void setRequireJobInfo(String requireJobInfo) {
		this.requireJobInfo = requireJobInfo;
	}

	public String getBizEstablishedDate() {
		if (bizEstablishedDate != null) bizEstablishedDate = bizEstablishedDate.trim();
		return bizEstablishedDate;
	}

	public void setBizEstablishedDate(String bizEstablishedDate) {
		this.bizEstablishedDate = bizEstablishedDate;
	}

	public String getAccountManager() {
		if (accountManager != null) accountManager = accountManager.trim();
		return accountManager;
	}

	public void setAccountManager(String accountManager) {
		this.accountManager = accountManager;
	}

	public Set<SimpleAccountBranch> getBranches() {
		return branches;
	}

	public void setBranches(Set<SimpleAccountBranch> branches) {
		this.branches = branches;
	}
	
}
