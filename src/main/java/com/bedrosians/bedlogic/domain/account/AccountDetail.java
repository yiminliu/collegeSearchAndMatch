package com.bedrosians.bedlogic.domain.account;

	
import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.bedrosians.bedlogic.util.FormatUtil;

@Entity(name="accountDetail")
@Table(name="arm")
@DynamicUpdate(value=true)
@SelectBeforeUpdate(value=true)
@DynamicInsert(value=true)
//@OptimisticLock = OptimisticLockType.ALL
public class AccountDetail extends Account implements Serializable {
	
	private static final long serialVersionUID = 674944990758703320L;
			
	@Embedded
	private Contact apContact;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="name", column=@Column(name="ceoContact")),
		@AttributeOverride(name="email", column=@Column(name="ceoEmail")),
		@AttributeOverride(name="fax", column=@Column(name="ceoFax")),
		@AttributeOverride(name="notes", column=@Column(name="ceoNotes")),
		@AttributeOverride(name="phone.phoneNumber", column=@Column(name="ceoPhone")),
		@AttributeOverride(name="phone.extension", column=@Column(name="ceoExt")),
		@AttributeOverride(name="phone.cellPhoneNumber", column=@Column(name="ceoCellPhone"))
	})
	private Contact ceoContact;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="name", column=@Column(name="cfoContact")),
		@AttributeOverride(name="email", column=@Column(name="cfoEmail")),
		@AttributeOverride(name="fax", column=@Column(name="cfoFax")),
		@AttributeOverride(name="notes", column=@Column(name="cfoNotes")),
		@AttributeOverride(name="phone.phoneNumber", column=@Column(name="cfoPhone")),
		@AttributeOverride(name="phone.extension", column=@Column(name="cfoExt")),
		@AttributeOverride(name="phone.cellPhoneNumber", column=@Column(name="cfoCellPhone"))
	})
	private Contact cfoContact;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="name", column=@Column(name="purContact")),
		@AttributeOverride(name="email", column=@Column(name="purEmail")),
		@AttributeOverride(name="fax", column=@Column(name="purFax")),
		@AttributeOverride(name="notes", column=@Column(name="purNotes")),
		@AttributeOverride(name="phone.phoneNumber", column=@Column(name="purPhone")),
		@AttributeOverride(name="phone.extension", column=@Column(name="purExt")),
		@AttributeOverride(name="phone.cellPhoneNumber", column=@Column(name="purCellPhone"))
	})
	private Contact purchaseContact;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="name", column=@Column(name="slsContact")),
		@AttributeOverride(name="email", column=@Column(name="slsEmail")),
		@AttributeOverride(name="fax", column=@Column(name="slsFax")),
		@AttributeOverride(name="notes", column=@Column(name="slsNotes")),
		@AttributeOverride(name="phone.phoneNumber", column=@Column(name="slsPhone")),
		@AttributeOverride(name="phone.extension", column=@Column(name="slsExt")),
		@AttributeOverride(name="phone.cellPhoneNumber", column=@Column(name="slsCellPhone"))
	})
	private Contact salesContact;

	
	@Column(name="Dba")
	private String companyName;
	@Column(name="b2Fax")
	private Integer b2Fax;
	@Column(name="b2Email")
	private String b2Email;
	@Temporal(TemporalType.DATE)
	@Column(name="busestablishdate", columnDefinition = "date default current_date")
	private Date bizEstablishedDate;
	@Column(name="BuyingGroup")
	private String buyingGroup;
	
	@Column(name="cashdiscallowed")
	private String cashDiscAllowed;
 	@Column(name="ConsolidStmt")
	private String isConsolidatedPayment;
	@Column(name="CreditLimit")
	private Float creditLimit;
	//@Column(name="CreditStatus")
	//private String creditStatus;
	@Temporal(TemporalType.DATE)
	@Column(name="credstatchgdate")
	private Date credStatChgDate;
	@Column(name="credstatnote")
	private String  credStatNote ;
	@Column(name="daystopay")
	private Integer daysToPay;
	@Column(name="defbranchcd")
	private String defBranchId;
	@Column(name="finchgcd")
	private String latePaymentChargeId;
	@Column(name="FinChgRate")
	private Integer latePaymentChargeRate;
	@Column(name="guaranteesigned")
	private String guaranteeSigned;
	@Temporal(TemporalType.DATE)
	@Column(name="guaranteeexpdate")
	private Date  guaranteeExpdDate;
	@Column(name="highbalamt")
	private Float highBalanceAmount;
	@Temporal(TemporalType.DATE)
	@Column(name="highbaldate")
	private Date highBalanceDate;
	@Column(name="invtype")
	private String invoiceType;
	@Column(name="JointCheck")
	private String jointCheck;
	@Temporal(TemporalType.DATE)
	@Column(name="LastCredApRecvdDate")
	private Date lastCreditApprovalDate;
	@Column(name="laststmtamt")
	private Float lastStatementAmount;
	@Temporal(TemporalType.DATE)
	@Column(name="laststmtdate")
	private Date lastStatementDate;
	//@Column(name="OurArContact")
	//private String accountManager;
	@Column(name="ownershiptype")
	private String ownershipType;
	@Column(name="PmtTermsCd")
	private String paymentTerm;
	@Column(name="PoRequired")
	private String PoRequired;    
	@Column(name="PreLienLimit")
	private Float preLienLimit;
	@Column(name="PreLienReq")
	private String preLienRequired;
	@Column(name="PrintPricingOnInv")
	private String priceOnInvoice;
	@Column(name="RequireJobInfo")
	private String requireJobInfo;
	@Column(name="stmtnbr")
	private Integer statementnBr;
	@Column(name="stmttype")
	private String statementType;             
	//@Column(name = "TreatAsStore")
	//private String treatAsStore;
	@Column(name="totbalamt", columnDefinition = "numeric default 0")
	private Float totalBalanceAmount;
	@Column(name = "crarnote")
	private String crarNote;
	@Column(name="StmtFreq_M")
	private String paperStatementMailingFrequency;
	@Column(name="StmtFreq_E")
	private String emailStatementMailingFrequency;
	@Column(name="InvFreq_M")
	private String paperInvoiceMailingFrequency;
	@Column(name="InvFreq_E")
	private String emailInvoiceMailingFrequency;
	@Temporal(TemporalType.DATE)
	@Column(name="stmtdate")
	private Date statementDate;
	@Column(name="stmtamt")
	private Float statementAmount;    
	//@Column(name = "vendor")
	//private String vendor;
	@Column(name="wdaystopay")
	private Integer wDaysToPay; 
	@Column(name = "setupby")
	private String setupBy;
	@Column(name="edi_receiverid")
	private Integer ediReceiverId; 
	@Column(name = "email_server")
	private String emailServer;
	@Column(name="Slab")
	private String isSlabStore;
	@Column(name="cg_credit")
	private String cgCredit;
	@Column(name="nsf_count", columnDefinition = "numeric default 0")
	private Integer nonSufficientFundChecks; 
	@Column(name="highbalance6amt", columnDefinition = "numeric default 0")
	private Float highBalance6Amt; 
	@Temporal(TemporalType.DATE)
	@Column(name="highbalance6date")
	private Date highBalance6Date;        
	@Column(name="obnotes")
	private String obNotes;
	@Column(name="Voucher")
	private String isVoucherAccount;
	@Temporal(TemporalType.DATE)
	@Column(name="Judment_Date")
	private Date judgementDate;        
	@Column(name="Lock_Hold")
	private String lockHold;
	@Temporal(TemporalType.DATE)
	@Column(name="obepedate")
	private Date obepeDate;	
	@Temporal(TemporalType.DATE)
	@Column(name="contract_sdate")
	private Date contractStartDate;
	@Temporal(TemporalType.DATE)
	@Column(name="contract_edate")
	private Date contractEndDate;
	@Column(name="frt_rate_cwt", columnDefinition = "numeric default 0")
	private Integer frtRateCwt; 
	@Column(name="print_alt_forms")
	private String printAltForms; 
	@Column(name="last_pmt_amt", columnDefinition = "numeric default 0")
	private Float lastPaymentAmount; 
	@Temporal(TemporalType.DATE)
	@Column(name="last_pmt_date")
	private Date lastPaymentDate;
	public Contact getApContact() {
		return apContact;
	}
	public void setApContact(Contact apContact) {
		this.apContact = apContact;
	}
	public Contact getCeoContact() {
		return ceoContact;
	}
	public void setCeoContact(Contact ceoContact) {
		this.ceoContact = ceoContact;
	}
	public Contact getCfoContact() {
		return cfoContact;
	}
	public void setCfoContact(Contact cfoContact) {
		this.cfoContact = cfoContact;
	}
	public Contact getPurchaseContact() {
		return purchaseContact;
	}
	public void setPurchaseContact(Contact purchaseContact) {
		this.purchaseContact = purchaseContact;
	}
	public Contact getSalesContact() {
		return salesContact;
	}
	public void setSalesContact(Contact salesContact) {
		this.salesContact = salesContact;
	}
	public String getCompanyName() {
		return FormatUtil.process(companyName);
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Integer getB2Fax() {
		return FormatUtil.process(b2Fax);
	}
	public void setB2Fax(Integer b2Fax) {
		this.b2Fax = b2Fax;
	}
	public String getB2Email() {
		return FormatUtil.process(b2Email);
	}
	public void setB2Email(String b2Email) {
		this.b2Email = b2Email;
	}
	public Date getBizEstablishedDate() {
		return FormatUtil.process(bizEstablishedDate);
	}
	public void setBizEstablishedDate(Date bizEstablishedDate) {
		this.bizEstablishedDate = bizEstablishedDate;
	}
	public String getBuyingGroup() {
		return FormatUtil.process(buyingGroup);
	}
	public void setBuyingGroup(String buyingGroup) {
		this.buyingGroup = buyingGroup;
	}
	public String getCashDiscAllowed() {
		return FormatUtil.process(cashDiscAllowed);
	}
	public void setCashDiscAllowed(String cashDiscAllowed) {
		this.cashDiscAllowed = cashDiscAllowed;
	}
	public String getIsConsolidatedPayment() {
		return FormatUtil.process(isConsolidatedPayment);
	}
	public void setIsConsolidatedPayment(String isConsolidatedPayment) {
		this.isConsolidatedPayment = isConsolidatedPayment;
	}
	public Float getCreditLimit() {
		return FormatUtil.process(creditLimit);
	}
	public void setCreditLimit(Float creditLimit) {
		this.creditLimit = creditLimit;
	}
	public Date getCredStatChgDate() {
		return FormatUtil.process(credStatChgDate);
	}
	public void setCredStatChgDate(Date credStatChgDate) {
		this.credStatChgDate = credStatChgDate;
	}
	public String getCredStatNote() {
		return FormatUtil.process(credStatNote);
	}
	public void setCredStatNote(String credStatNote) {
		this.credStatNote = credStatNote;
	}
	public Integer getDaysToPay() {
		return FormatUtil.process(daysToPay);
	}
	public void setDaysToPay(Integer daysToPay) {
		this.daysToPay = daysToPay;
	}
	public String getDefBranchId() {
		return FormatUtil.process(defBranchId);
	}
	public void setDefBranchId(String defBranchId) {
		this.defBranchId = defBranchId;
	}
	public String getLatePaymentChargeId() {
		return FormatUtil.process(latePaymentChargeId);
	}
	public void setLatePaymentChargeId(String latePaymentChargeId) {
		this.latePaymentChargeId = latePaymentChargeId;
	}
	public Integer getLatePaymentChargeRate() {
		return FormatUtil.process(latePaymentChargeRate);
	}
	public void setLatePaymentChargeRate(Integer latePaymentChargeRate) {
		this.latePaymentChargeRate = latePaymentChargeRate;
	}
	public String getGuaranteeSigned() {
		return FormatUtil.process(guaranteeSigned);
	}
	public void setGuaranteeSigned(String guaranteeSigned) {
		this.guaranteeSigned = guaranteeSigned;
	}
	public Date getGuaranteeExpdDate() {
		return FormatUtil.process(guaranteeExpdDate);
	}
	public void setGuaranteeExpdDate(Date guaranteeExpdDate) {
		this.guaranteeExpdDate = guaranteeExpdDate;
	}
	public Float getHighBalanceAmount() {
		return FormatUtil.process(highBalanceAmount);
	}
	public void setHighBalanceAmount(Float highBalanceAmount) {
		this.highBalanceAmount = highBalanceAmount;
	}
	public Date getHighBalanceDate() {
		return FormatUtil.process(highBalanceDate);
	}
	public void setHighBalanceDate(Date highBalanceDate) {
		this.highBalanceDate = highBalanceDate;
	}
	public String getInvoiceType() {
		return FormatUtil.process(invoiceType);
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getJointCheck() {
		return FormatUtil.process(jointCheck);
	}
	public void setJointCheck(String jointCheck) {
		this.jointCheck = jointCheck;
	}
	public Date getLastCreditApprovalDate() {
		return FormatUtil.process(lastCreditApprovalDate);
	}
	public void setLastCreditApprovalDate(Date lastCreditApprovalDate) {
		this.lastCreditApprovalDate = lastCreditApprovalDate;
	}
	public Float getLastStatementAmount() {
		return FormatUtil.process(lastStatementAmount);
	}
	public void setLastStatementAmount(Float lastStatementAmount) {
		this.lastStatementAmount = lastStatementAmount;
	}
	public Date getLastStatementDate() {
		return FormatUtil.process(lastStatementDate);
	}
	public void setLastStatementDate(Date lastStatementDate) {
		this.lastStatementDate = lastStatementDate;
	}
	public String getOwnershipType() {
		return FormatUtil.process(ownershipType);
	}
	public void setOwnershipType(String ownershipType) {
		this.ownershipType = ownershipType;
	}
	public String getPaymentTerm() {
		return FormatUtil.process(paymentTerm);
	}
	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}
	public String getPoRequired() {
		return FormatUtil.process(PoRequired);
	}
	public void setPoRequired(String poRequired) {
		PoRequired = poRequired;
	}
	public Float getPreLienLimit() {
		return FormatUtil.process(preLienLimit);
	}
	public void setPreLienLimit(Float preLienLimit) {
		this.preLienLimit = preLienLimit;
	}
	public String getPreLienRequired() {
		return FormatUtil.process(preLienRequired);
	}
	public void setPreLienRequired(String preLienRequired) {
		this.preLienRequired = preLienRequired;
	}
	public String getPriceOnInvoice() {
		return FormatUtil.process(priceOnInvoice);
	}
	public void setPriceOnInvoice(String priceOnInvoice) {
		this.priceOnInvoice = priceOnInvoice;
	}
	public String getRequireJobInfo() {
		return FormatUtil.process(requireJobInfo);
	}
	public void setRequireJobInfo(String requireJobInfo) {
		this.requireJobInfo = requireJobInfo;
	}
	public Integer getStatementnBr() {
		return FormatUtil.process(statementnBr);
	}
	public void setStatementnBr(Integer statementnBr) {
		this.statementnBr = statementnBr;
	}
	public String getStatementType() {
		return FormatUtil.process(statementType);
	}
	public void setStatementType(String statementType) {
		this.statementType = statementType;
	}
	public Float getTotalBalanceAmount() {
		return FormatUtil.process(totalBalanceAmount);
	}
	public void setTotalBalanceAmount(Float totalBalanceAmount) {
		this.totalBalanceAmount = totalBalanceAmount;
	}
	public String getCrarNote() {
		return FormatUtil.process(crarNote);
	}
	public void setCrarNote(String crarNote) {
		this.crarNote = crarNote;
	}
	public String getPaperStatementMailingFrequency() {
		return FormatUtil.process(paperStatementMailingFrequency);
	}
	public void setPaperStatementMailingFrequency(
			String paperStatementMailingFrequency) {
		this.paperStatementMailingFrequency = paperStatementMailingFrequency;
	}
	public String getEmailStatementMailingFrequency() {
		return FormatUtil.process(emailStatementMailingFrequency);
	}
	public void setEmailStatementMailingFrequency(
			String emailStatementMailingFrequency) {
		this.emailStatementMailingFrequency = emailStatementMailingFrequency;
	}
	public String getPaperInvoiceMailingFrequency() {
		return FormatUtil.process(paperInvoiceMailingFrequency);
	}
	public void setPaperInvoiceMailingFrequency(String paperInvoiceMailingFrequency) {
		this.paperInvoiceMailingFrequency = paperInvoiceMailingFrequency;
	}
	public String getEmailInvoiceMailingFrequency() {
		return FormatUtil.process(emailInvoiceMailingFrequency);
	}
	public void setEmailInvoiceMailingFrequency(String emailInvoiceMailingFrequency) {
		this.emailInvoiceMailingFrequency = emailInvoiceMailingFrequency;
	}
	public Date getStatementDate() {
		return FormatUtil.process(statementDate);
	}
	public void setStatementDate(Date statementDate) {
		this.statementDate = statementDate;
	}
	public Float getStatementAmount() {
		return FormatUtil.process(statementAmount);
	}
	public void setStatementAmount(Float statementAmount) {
		this.statementAmount = statementAmount;
	}
	public Integer getwDaysToPay() {
		return FormatUtil.process(wDaysToPay);
	}
	public void setwDaysToPay(Integer wDaysToPay) {
		this.wDaysToPay = wDaysToPay;
	}
	public String getSetupBy() {
		return FormatUtil.process(setupBy);
	}
	public void setSetupBy(String setupBy) {
		this.setupBy = setupBy;
	}
	public Integer getEdiReceiverId() {
		return FormatUtil.process(ediReceiverId);
	}
	public void setEdiReceiverId(Integer ediReceiverId) {
		this.ediReceiverId = ediReceiverId;
	}
	public String getEmailServer() {
		return FormatUtil.process(emailServer);
	}
	public void setEmailServer(String emailServer) {
		this.emailServer = emailServer;
	}
	public String getIsSlabStore() {
		return FormatUtil.process(isSlabStore);
	}
	public void setIsSlabStore(String isSlabStore) {
		this.isSlabStore = isSlabStore;
	}
	public String getCgCredit() {
		return FormatUtil.process(cgCredit);
	}
	public void setCgCredit(String cgCredit) {
		this.cgCredit = cgCredit;
	}
	public Integer getNonSufficientFundChecks() {
		return FormatUtil.process(nonSufficientFundChecks);
	}
	public void setNonSufficientFundChecks(Integer nonSufficientFundChecks) {
		this.nonSufficientFundChecks = nonSufficientFundChecks;
	}
	public Float getHighBalance6Amt() {
		return FormatUtil.process(highBalance6Amt);
	}
	public void setHighBalance6Amt(Float highBalance6Amt) {
		this.highBalance6Amt = highBalance6Amt;
	}
	public Date getHighBalance6Date() {
		return FormatUtil.process(highBalance6Date);
	}
	public void setHighBalance6Date(Date highBalance6Date) {
		this.highBalance6Date = highBalance6Date;
	}
	public String getObNotes() {
		return FormatUtil.process(obNotes);
	}
	public void setObNotes(String obNotes) {
		this.obNotes = obNotes;
	}
	public String getIsVoucherAccount() {
		return FormatUtil.process(isVoucherAccount);
	}
	public void setIsVoucherAccount(String isVoucherAccount) {
		this.isVoucherAccount = isVoucherAccount;
	}
	public Date getJudgementDate() {
		return FormatUtil.process(judgementDate);
	}
	public void setJudgementDate(Date judgementDate) {
		this.judgementDate = judgementDate;
	}
	public String getLockHold() {
		return FormatUtil.process(lockHold);
	}
	public void setLockHold(String lockHold) {
		this.lockHold = lockHold;
	}
	public Date getObepeDate() {
		return FormatUtil.process(obepeDate);
	}
	public void setObepeDate(Date obepeDate) {
		this.obepeDate = obepeDate;
	}
	public Date getContractStartDate() {
		return FormatUtil.process(contractStartDate);
	}
	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}
	public Date getContractEndDate() {
		return FormatUtil.process(contractEndDate);
	}
	public void setContractEndDate(Date contractEndDate) {
		this.contractEndDate = contractEndDate;
	}
	public Integer getFrtRateCwt() {
		return FormatUtil.process(frtRateCwt);
	}
	public void setFrtRateCwt(Integer frtRateCwt) {
		this.frtRateCwt = frtRateCwt;
	}
	public String getPrintAltForms() {
		return FormatUtil.process(printAltForms);
	}
	public void setPrintAltForms(String printAltForms) {
		this.printAltForms = printAltForms;
	}
	public Float getLastPaymentAmount() {
		return FormatUtil.process(lastPaymentAmount);
	}
	public void setLastPaymentAmount(Float lastPaymentAmount) {
		this.lastPaymentAmount = lastPaymentAmount;
	}
	public Date getLastPaymentDate() {
		return FormatUtil.process(lastPaymentDate);
	}
	public void setLastPaymentDate(Date lastPaymentDate) {
		this.lastPaymentDate = lastPaymentDate;
	}
		
	//@Column(name="")
	//private String bankcruptcyCaseNo;

	 //@Transient
	//private List<CheckPayment> checkPayments;
    //@Column(name="")
	//private String vendorNo;
	
    //@Column(name="")
	//private String contractorNo;	
	

	
}