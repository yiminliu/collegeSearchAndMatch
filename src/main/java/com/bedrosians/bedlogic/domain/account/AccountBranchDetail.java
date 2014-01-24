package com.bedrosians.bedlogic.domain.account;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.AttributeOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bedrosians.bedlogic.util.FormatUtil;


@Entity(name="accountBranchDetail")
@Table(name="armbr")
public class AccountBranchDetail extends AccountBranch implements Serializable {
	
	private static final long serialVersionUID = 5137707010951170389L;

	
	@Embedded
	private Contact apContact;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="name", column=@Column(name="mgrContact")),
		@AttributeOverride(name="phone.phoneNumber", column=@Column(name="mgrPhone")),
		@AttributeOverride(name="phone.extension", column=@Column(name="mgrExt")),
		@AttributeOverride(name="phone.cellPhoneNumber", column=@Column(name="mgrCellPhone")),
		@AttributeOverride(name="email", column=@Column(name="mgrEmail")),
		@AttributeOverride(name="fax", column=@Column(name="mgrFax")),
		@AttributeOverride(name="notes", column=@Column(name="mgrNotes"))		
	})
	private Contact managerContact;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="name", column=@Column(name="purContact")),
		@AttributeOverride(name="phone.phoneNumber", column=@Column(name="purPhone")),
		@AttributeOverride(name="phone.extension", column=@Column(name="purExt")),
		@AttributeOverride(name="phone.cellPhoneNumber", column=@Column(name="purCellPhone")),
		@AttributeOverride(name="email", column=@Column(name="purEmail")),
		@AttributeOverride(name="fax", column=@Column(name="purFax")),
		@AttributeOverride(name="notes", column=@Column(name="purNotes"))		
	})
	private Contact purchaseContact;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="name", column=@Column(name="slsContact")),
		@AttributeOverride(name="phone.phoneNumber", column=@Column(name="slsPhone")),
		@AttributeOverride(name="phone.extension", column=@Column(name="slsExt")),
		@AttributeOverride(name="phone.cellPhoneNumber", column=@Column(name="slsCellPhone")),
		@AttributeOverride(name="email", column=@Column(name="slsEmail")),
		@AttributeOverride(name="fax", column=@Column(name="slsFax")),
		@AttributeOverride(name="notes", column=@Column(name="slsNotes"))
		
	})
	private Contact salesContact;


	@Column(name="authonly")
	private String authOnly;
	
	@Column(name="b2email")
	private String b2Email;
	
	@Column(name="b2fax")
	private Long b2Fax;
	
	@Column(name="b2fromcorp")
	private String b2FromCorp;
	
	@Column(name="branchsalesnbr")
	private Integer branchSalesNBr;
	
	@Column(name="contractLicnbr")
	private String contractLicNBr;
	
	@Column(name="daystopay")
	private Integer daysToPay;
	
	@Temporal(TemporalType.DATE)
	@Column(name="firstsolddate")
	private Date firstSoldDate;
	
	@Column(name="highbalamt")
	private Float highBalAmt;
	
	@Temporal(TemporalType.DATE)
	@Column(name="highbaldate")
	private Date highBalDate;
	
	@Column(name="invtype")
	private String invType;
	
	@Column(name="laststmtamt")
	private Float lastStmtAmt;
	
	@Temporal(TemporalType.DATE)
	@Column(name="laststmtdate")
	private Date lastStmtDate;
	
	@Column(name="ourarcontact")
	private String accountManager;
	
	@Column(name="resalenbr")
	private String resalEnBr;
	
	@Temporal(TemporalType.DATE)
	@Column(name="setupdate")
	private Date setupDate;
	
	@Column(name="stmtnbr")
	private String stmtNBr;
	
	@Column(name="stmttype")
	private String  stmtType;
	
	@Column(name="storenbr")
	private Integer storeNBr;
		
	@Column(name="taxclass")
	private String taxClass;
	
	@Column(name="totbalamt")
	private Float totbalAmt;
	
	@Temporal(TemporalType.DATE)
	@Column(name="invlaste_date")
	private Date invLasteDate;
	
	@Column(name="batchinv")
	private String  batchInv;
	
	@Column(name="printstmt")
	private String printStmt ;
	
	@Column(name="custgroup")
	private Integer custGroup;
	
	@Column(name="pricegroup")
	private String pricegroup;	
	
	@Temporal(TemporalType.DATE)
	@Column(name="invlastm_date")
	private Date invLastMDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="stmtlaste_date")
	private Date stmtLastEDate;
		
	@Column(name="apemail2")
	private String  apEmail2;
	
	@Column(name="stmtlaste_amt")
	private Float stmtlastEAmt;
	
	@Column(name="wdaystopay")
	private Integer wDaysToPay;
	
	@Column(name="setupby")
	private String setupBy;
	
	@Column(name="notblockcheck")
	private String  notBlockCheck;
	
	@Temporal(TemporalType.DATE)
	@Column(name="resalenbr_expdate")
	private Date resaleNBrExpDate;
	
	@Column(name="groupcd")
	private String groupId;
	
	@Column(name="usercd")
	private String userId;
	
	@Column(name="infoemail1")
	private String infoEmail1;
	@Column(name="infoemail2")
	private String infoEmail2;
	@Column(name="infoemail3")
	private String infoEmail3;
	@Column(name="infoemail4")
	private String infoEmail4;
	@Column(name="infoemail5")
	private String infoEmail5;
	@Column(name="infoemail6")
	private String infoEmail6;
	@Column(name="infoemail7")
	private String infoEmail7;
	@Column(name="infoemail8")
	private String infoEmail8;
	@Column(name="infoemail9")
	private String infoEmail9;
		
	@Column(name="resalenbr2")
	private Integer resaleNB2;
	@Temporal(TemporalType.DATE)
	@Column(name="resalenbr2_expdate")
	private Date resaleNB2ExpDate;
	
	@Column(name="resalenbr3")
	private String resaleNB3;
	@Temporal(TemporalType.DATE)
	@Column(name="resalenbr3_expdate")
	private Date resaleNB3ExpDate;
	@Column(name="resalenbr4")
	private String resaleNB4;
	@Temporal(TemporalType.DATE)
	@Column(name="resalenbr4_expdate")
	private Date resaleNB4ExpDate;
	@Column(name="resalenbr5")
	private String resaleNB5;
	@Temporal(TemporalType.DATE)
	@Column(name="resalenbr5_expdate")
	private Date resaleNB5ExpDate;
		
	@Column(name="resaleNBr1_statecd")
	private String resalenbr1StateCd;
		
	@Column(name="resaleNBr2_statecd")
	private String resalenbr2StateCd;
	@Column(name="resaleNBr3_statecd")
	private String resalenbr3StateCd;
	@Column(name="resaleNBr4_statecd")
	private String resalenbr4StateCd;
	@Column(name="resaleNBr5_statecd")
	private String resalenbr5StateCd;
	
	@Column(name="taxstatecd")
	private String taxStateCd;
	@Column(name="taxlocalcd")
	private String taxLocalCd;
		
	@Temporal(TemporalType.DATE)
	@Column(name="branchSalesnbrdate")
	private Date branchsalesNBrDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="pricegroupdate")
	private Date priceGroupDate;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="streeLine1", column=@Column(name="physAddr1")),
		@AttributeOverride(name="streeLine2", column=@Column(name="physAddr2")),
		@AttributeOverride(name="city", column=@Column(name="physcity")),
		@AttributeOverride(name="state", column=@Column(name="physStateCd")),
		@AttributeOverride(name="zip", column=@Column(name="physZip")),
	})
	private Address physicalAddress;

	     
	public Contact getApContact() {
		return apContact;
	}

	public void setApContact(Contact apContact) {
		this.apContact = apContact;
	}
   
	public Contact getManagerContact() {
		 return managerContact;
	}

	public void setManagerContact(Contact managerContact) {
		this.managerContact = managerContact;
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
	
	public String getAuthOnly() {
		return FormatUtil.process(authOnly);
	}

	public void setAuthOnly(String authOnly) {
		this.authOnly = authOnly;
	}

	public String getB2Email() {
		return FormatUtil.process(b2Email);
	}

	public void setB2Email(String b2Email) {
		this.b2Email = b2Email;
	}

	public Long getB2Fax() {
		return FormatUtil.process(b2Fax);
	}

	public void setB2Fax(Long b2Fax) {
		this.b2Fax = b2Fax;
	}

	public String getB2FromCorp() {
		return FormatUtil.process(b2FromCorp);
	}

	public void setB2FromCorp(String b2FromCorp) {
		this.b2FromCorp = b2FromCorp;
	}

	public Integer getBranchSalesNBr() {
		return FormatUtil.process(branchSalesNBr);
	}

	public void setBranchSalesNBr(Integer branchSalesNBr) {
		this.branchSalesNBr = branchSalesNBr;
	}

	public String getContractLicNBr() {
		return FormatUtil.process(contractLicNBr);
	}

	public void setContractLicNBr(String contractLicNBr) {
		this.contractLicNBr = contractLicNBr;
	}

	public Integer getDaysToPay() {
		return FormatUtil.process(daysToPay);
	}

	public void setDaysToPay(Integer daysToPay) {
		this.daysToPay = daysToPay;
	}

	public Date getFirstSoldDate() {
		return FormatUtil.process(firstSoldDate);
	}

	public void setFirstSoldDate(Date firstSoldDate) {
		this.firstSoldDate = firstSoldDate;
	}

	public Float getHighBalAmt() {
		return FormatUtil.process(highBalAmt);
	}

	public void setHighBalAmt(Float highBalAmt) {
		this.highBalAmt = highBalAmt;
	}

	public Date getHighBalDate() {
		return FormatUtil.process(highBalDate);
	}

	public void setHighBalDate(Date highBalDate) {
		this.highBalDate = highBalDate;
	}

	public String getInvType() {
		return FormatUtil.process(invType);
	}

	public void setInvType(String invType) {
		this.invType = invType;
	}

	public Float getLastStmtAmt() {
		return FormatUtil.process(lastStmtAmt);
	}

	public void setLastStmtAmt(Float lastStmtAmt) {
		this.lastStmtAmt = lastStmtAmt;
	}

	public Date getLastStmtDate() {
		return FormatUtil.process(lastStmtDate);
	}

	public void setLastStmtDate(Date lastStmtDate) {
		this.lastStmtDate = lastStmtDate;
	}

	public String getAccountManager() {
		return FormatUtil.process(accountManager);
	}

	public void setAccountManager(String accountManager) {
		this.accountManager = accountManager;
	}

	public String getResalEnBr() {
		return FormatUtil.process(resalEnBr);
	}

	public void setResalEnBr(String resalEnBr) {
		this.resalEnBr = resalEnBr;
	}

	public Date getSetupDate() {
		return FormatUtil.process(setupDate);
	}

	public void setSetupDate(Date setupDate) {
		this.setupDate = setupDate;
	}

	public String getStmtNBr() {
		return FormatUtil.process(stmtNBr);
	}

	public void setStmtNBr(String stmtNBr) {
		this.stmtNBr = stmtNBr;
	}

	public String getStmtType() {
		return FormatUtil.process(stmtType);
	}

	public void setStmtType(String stmtType) {
		this.stmtType = stmtType;
	}

	public Integer getStoreNBr() {
		return FormatUtil.process(storeNBr);
	}

	public void setStoreNBr(Integer storeNBr) {
		this.storeNBr = storeNBr;
	}

	public String getTaxClass() {
		return FormatUtil.process(taxClass);
	}

	public void setTaxClass(String taxClass) {
		this.taxClass = taxClass;
	}

	public Float getTotbalAmt() {
		return FormatUtil.process(totbalAmt);
	}

	public void setTotbalAmt(Float totbalAmt) {
		this.totbalAmt = totbalAmt;
	}

	public Date getInvLasteDate() {
		return FormatUtil.process(invLasteDate);
	}

	public void setInvLasteDate(Date invLasteDate) {
		this.invLasteDate = invLasteDate;
	}

	public String getBatchInv() {
		return FormatUtil.process(batchInv);
	}

	public void setBatchInv(String batchInv) {
		this.batchInv = batchInv;
	}

	public String getPrintStmt() {
		return FormatUtil.process(printStmt);
	}

	public void setPrintStmt(String printStmt) {
		this.printStmt = printStmt;
	}

	public Integer getCustGroup() {
		return FormatUtil.process(custGroup);
	}

	public void setCustGroup(Integer custGroup) {
		this.custGroup = custGroup;
	}

	public String getPricegroup() {
		return FormatUtil.process(pricegroup);
	}

	public void setPricegroup(String pricegroup) {
		this.pricegroup = pricegroup;
	}

	public Date getInvLastMDate() {
		return FormatUtil.process(invLastMDate);
	}

	public void setInvLastMDate(Date invLastMDate) {
		this.invLastMDate = invLastMDate;
	}

	public Date getStmtLastEDate() {
		return FormatUtil.process(stmtLastEDate);
	}

	public void setStmtLastEDate(Date stmtLastEDate) {
		this.stmtLastEDate = stmtLastEDate;
	}

	public String getApEmail2() {
		return FormatUtil.process(apEmail2);
	}

	public void setApEmail2(String apEmail2) {
		this.apEmail2 = apEmail2;
	}

	public Float getStmtlastEAmt() {
		return FormatUtil.process(stmtlastEAmt);
	}

	public void setStmtlastEAmt(Float stmtlastEAmt) {
		this.stmtlastEAmt = stmtlastEAmt;
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

	public String getNotBlockCheck() {
		return FormatUtil.process(notBlockCheck);
	}

	public void setNotBlockCheck(String notBlockCheck) {
		this.notBlockCheck = notBlockCheck;
	}

	public Date getResaleNBrExpDate() {
		return FormatUtil.process(resaleNBrExpDate);
	}

	public void setResaleNBrExpDate(Date resaleNBrExpDate) {
		this.resaleNBrExpDate = resaleNBrExpDate;
	}

	public String getGroupId() {
		return FormatUtil.process(groupId);
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getUserId() {
		return FormatUtil.process(userId);
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getInfoEmail1() {
		return FormatUtil.process(infoEmail1);
	}

	public void setInfoEmail1(String infoEmail1) {
		this.infoEmail1 = infoEmail1;
	}

	public String getInfoEmail2() {
		return FormatUtil.process(infoEmail2);
	}

	public void setInfoEmail2(String infoEmail2) {
		this.infoEmail2 = infoEmail2;
	}

	public String getInfoEmail3() {
		return FormatUtil.process(infoEmail3);
	}

	public void setInfoEmail3(String infoEmail3) {
		this.infoEmail3 = infoEmail3;
	}

	public String getInfoEmail4() {
		return FormatUtil.process(infoEmail4);
	}

	public void setInfoEmail4(String infoEmail4) {
		this.infoEmail4 = infoEmail4;
	}

	public String getInfoEmail5() {
		return FormatUtil.process(infoEmail5);
	}

	public void setInfoEmail5(String infoEmail5) {
		this.infoEmail5 = infoEmail5;
	}

	public String getInfoEmail6() {
		return FormatUtil.process(infoEmail6);
	}

	public void setInfoEmail6(String infoEmail6) {
		this.infoEmail6 = infoEmail6;
	}

	public String getInfoEmail7() {
		return FormatUtil.process(infoEmail7);
	}

	public void setInfoEmail7(String infoEmail7) {
		this.infoEmail7 = infoEmail7;
	}

	public String getInfoEmail8() {
		return FormatUtil.process(infoEmail8);
	}

	public void setInfoEmail8(String infoEmail8) {
		this.infoEmail8 = infoEmail8;
	}

	public String getInfoEmail9() {
		return FormatUtil.process(infoEmail9);
	}

	public void setInfoEmail9(String infoEmail9) {
		this.infoEmail9 = infoEmail9;
	}

	public Integer getResaleNB2() {
		return FormatUtil.process(resaleNB2);
	}

	public void setResaleNB2(Integer resaleNB2) {
		this.resaleNB2 = resaleNB2;
	}

	public Date getResaleNB2ExpDate() {
		return FormatUtil.process(resaleNB2ExpDate);
	}

	public void setResaleNB2ExpDate(Date resaleNB2ExpDate) {
		this.resaleNB2ExpDate = resaleNB2ExpDate;
	}

	public String getResaleNB3() {
		return FormatUtil.process(resaleNB3);
	}

	public void setResaleNB3(String resaleNB3) {
		this.resaleNB3 = resaleNB3;
	}

	public Date getResaleNB3ExpDate() {
		return FormatUtil.process(resaleNB3ExpDate);
	}

	public void setResaleNB3ExpDate(Date resaleNB3ExpDate) {
		this.resaleNB3ExpDate = resaleNB3ExpDate;
	}

	public String getResaleNB4() {
		return FormatUtil.process(resaleNB4);
	}

	public void setResaleNB4(String resaleNB4) {
		this.resaleNB4 = resaleNB4;
	}

	public Date getResaleNB4ExpDate() {
		return FormatUtil.process(resaleNB4ExpDate);
	}

	public void setResaleNB4ExpDate(Date resaleNB4ExpDate) {
		this.resaleNB4ExpDate = resaleNB4ExpDate;
	}

	public String getResaleNB5() {
		return FormatUtil.process(resaleNB5);
	}

	public void setResaleNB5(String resaleNB5) {
		this.resaleNB5 = resaleNB5;
	}

	public Date getResaleNB5ExpDate() {
		return FormatUtil.process(resaleNB5ExpDate);
	}

	public void setResaleNB5ExpDate(Date resaleNB5ExpDate) {
		this.resaleNB5ExpDate = resaleNB5ExpDate;
	}

	public String getResalenbr1StateCd() {
		return FormatUtil.process(resalenbr1StateCd);
	}

	public void setResalenbr1StateCd(String resalenbr1StateCd) {
		this.resalenbr1StateCd = resalenbr1StateCd;
	}

	public String getResalenbr2StateCd() {
		return FormatUtil.process(resalenbr2StateCd);
	}

	public void setResalenbr2StateCd(String resalenbr2StateCd) {
		this.resalenbr2StateCd = resalenbr2StateCd;
	}

	public String getResalenbr3StateCd() {
		return FormatUtil.process(resalenbr3StateCd);
	}

	public void setResalenbr3StateCd(String resalenbr3StateCd) {
		this.resalenbr3StateCd = resalenbr3StateCd;
	}

	public String getResalenbr4StateCd() {
		return FormatUtil.process(resalenbr4StateCd);
	}

	public void setResalenbr4StateCd(String resalenbr4StateCd) {
		this.resalenbr4StateCd = resalenbr4StateCd;
	}

	public String getResalenbr5StateCd() {
		return FormatUtil.process(resalenbr5StateCd);
	}

	public void setResalenbr5StateCd(String resalenbr5StateCd) {
		this.resalenbr5StateCd = resalenbr5StateCd;
	}

	public String getTaxStateCd() {
		return FormatUtil.process(taxStateCd);
	}

	public void setTaxStateCd(String taxStateCd) {
		this.taxStateCd = taxStateCd;
	}

	public String getTaxLocalCd() {
		return FormatUtil.process(taxLocalCd);
	}

	public void setTaxLocalCd(String taxLocalCd) {
		this.taxLocalCd = taxLocalCd;
	}

	public Date getBranchsalesNBrDate() {
		return FormatUtil.process(branchsalesNBrDate);
	}

	public void setBranchsalesNBrDate(Date branchsalesNBrDate) {
		this.branchsalesNBrDate = branchsalesNBrDate;
	}

	public Date getPriceGroupDate() {
		return FormatUtil.process(priceGroupDate);
	}

	public void setPriceGroupDate(Date priceGroupDate) {
		this.priceGroupDate = priceGroupDate;
	}

	public Address getPhysicalAddress() {
		return physicalAddress;
	}

	public void setPhysicalAddress(Address physicalAddress) {
		this.physicalAddress = physicalAddress;
	}
	
}	
	
	
/*
	   apphone             numeric(13),
	   apext               numeric(4),
	   apcellphone         numeric(13),
	   apfax               numeric(13),
	   apemail             char(50),
	   apnotes             char(25),
	   mgrcontact          char(25),
	   mgrphone            numeric(13),
	   mgrext              numeric(4),
	   mgrcellphone        numeric(13),
	   mgrfax              numeric(13),
	   mgremail            char(50),
	   mgrnotes            char(25),
	   purcontact          char(25),
	   purphone            numeric(13),
	   purext              numeric(4),
	   purcellphone        numeric(13),
	   purfax              numeric(13),
	   puremail            char(50),
	   purnotes            char(25),
	   slscontact          char(25),
	   slsphone            numeric(13),
	   slsext              numeric(4),
	   slscellphone        numeric(13),
	   slsfax              numeric(13),
	   slsemail            char(50),
	   slsnotes            char(40),
	   acctnote1           char(40),
	   acctnote2           char(40),
	   acctnote3           char(40),
	   acctnote4           char(40),
	   authonly            char(1),
	   b2email             char(50),
	   b2fax               numeric(13),
	   b2fromcorp          char(1),
	   branchsalesnbr      numeric(4),
	   contractlicnbr      char(25),
	   daystopay           numeric(4),
	   defshiptocd         char(4),
	   firstsolddate       date,
	   highbalamt          numeric(11,2),
	   highbaldate         date,
	   invtype             char(3),
	   laststmtamt         numeric(11,2),
	   laststmtdate        date,
	   ourarcontact        char(25),
	   resalenbr           char(25),
	   setupdate           date,
	   stmtnbr             numeric(4),
	   stmttype            char(3),
	   storenbr            numeric(3),
	   taxclass            char(1),
	   totbalamt           numeric(11,2)    DEFAULT (0)::numeric,
	   batchinv            char(1),
	   printstmt           char(1),
	   custgroup           char(7),
	   pricegroup          char(10),
	   invlaste_date       date,
	   invlastm_date       date,
	   stmtlaste_date      date,
	   apemail2            char(50),
	   stmtlaste_amt       numeric(11,2),
	   wdaystopay          numeric(5,2),
	   setupby             char(10),
	   notblockcheck       char(1),
	   resalenbr_expdate   date,
	   groupcd             char(2),
	   usercd              char(10),
	   infoemail1          char(50),
	   infoemail2          char(50),
	   infoemail3          char(50),
	   infoemail4          char(50),
	   infoemail5          char(50),
	   infoemail6          char(50),
	   infoemail7          char(50),
	   infoemail8          char(50),
	   infoemail9          char(50),
	   resalenbr2          char(25),
	   resalenbr2_expdate  date,
	   resalenbr3          char(25),
	   resalenbr3_expdate  date,
	   resalenbr4          char(25),
	   resalenbr4_expdate  date,
	   resalenbr5          char(25),
	   resalenbr5_expdate  date,
	   resalenbr1_statecd  char(2),
	   resalenbr2_statecd  char(2),
	   resalenbr3_statecd  char(2),
	   resalenbr4_statecd  char(2),
	   resalenbr5_statecd  char(2),
	   taxstatecd          char(2)          DEFAULT NULL::bpchar,
	   taxlocalcd          char(6)          DEFAULT NULL::bpchar,
	   branchsalesnbrdate  timestamp,
	   pricegroupdate      timestamp        DEFAULT NULL::timestamp without time zone,
	   physaddr1           char(40)         DEFAULT NULL::bpchar,
	   physaddr2           char(40)         DEFAULT NULL::bpchar,
	   physcity            char(30)         DEFAULT NULL::bpchar,
	   physstatecd         char(2)          DEFAULT NULL::bpchar,
	   physzip             char(10)         DEFAULT NULL::bpchar
	   
}*/
