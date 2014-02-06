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

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.bedrosians.bedlogic.util.FormatUtil;


@Entity(name="accountBranchDetail")
@Table(name="armbr")
@DynamicUpdate(value=true)
@SelectBeforeUpdate(value=true)
@DynamicInsert(value=true)
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
	private Integer branchSalesNo;
	
	@Column(name="contractLicnbr")
	private String contractLicenseNo;
	
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
	private Float lastStatementAmount;
	
	@Temporal(TemporalType.DATE)
	@Column(name="laststmtdate")
	private Date lastStatmentDate;
	
	@Column(name="ourarcontact")
	private String accountManager;
	
	@Column(name="resalenbr")
	private String resaleNo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="setupdate")
	private Date setupDate;
	
	@Column(name="stmtnbr")
	private String statementNo;
	
	@Column(name="stmttype")
	private String  statementType;
	
	@Column(name="storenbr")
	private Integer storeNo;
		
	@Column(name="taxclass")
	private String taxClass;
	
	@Column(name="totbalamt")
	private Float totbalAmount;
	
	@Temporal(TemporalType.DATE)
	@Column(name="invlaste_date")
	private Date invLasteDate;
	
	@Column(name="batchinv")
	private String batchInventory;
	
	@Column(name="printstmt")
	private String printStatement ;
	
	@Column(name="custgroup")
	private Integer customerGroup;
	
	@Column(name="pricegroup")
	private String priceGroup;	
	
	@Temporal(TemporalType.DATE)
	@Column(name="invlastm_date")
	private Date inventoryLastMDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="stmtlaste_date")
	private Date statementLastEDate;
		
	@Column(name="apemail2")
	private String  apEmail2;
	
	@Column(name="stmtlaste_amt")
	private Float statementLastEAmount;
	
	@Column(name="wdaystopay")
	private Integer wDaysToPay;
	
	@Column(name="setupby")
	private String setupBy;
	
	@Column(name="notblockcheck")
	private String  notBlockCheck;
	
	@Temporal(TemporalType.DATE)
	@Column(name="resalenbr_expdate")
	private Date resaleNumberExpDate;
	
	@Column(name="groupcd")
	private String groupId;
	
	@Column(name="usercd")
	private String userId;
	
	@Column(name="infoEmail1")
	private String infoEmail1;
	@Column(name="infoEmail2")
	private String infoEmail2;
	@Column(name="infoEmail3")
	private String infoEmail3;
	@Column(name="infoEmail4")
	private String infoEmail4;
	@Column(name="infoEmail5")
	private String infoEmail5;
	@Column(name="infoEmail6")
	private String infoEmail6;
	@Column(name="infoEmail7")
	private String infoEmail7;
	@Column(name="infoEmail8")
	private String infoEmail8;
	@Column(name="infoEmail9")
	private String infoEmail9;
		
	@Column(name="resalenbr2")
	private Integer resaleNumber2;
	@Temporal(TemporalType.DATE)
	@Column(name="resalenbr2_expdate")
	private Date resaleNumber2ExpDate;
	
	@Column(name="resalenbr3")
	private String resaleNumber3;
	@Temporal(TemporalType.DATE)
	@Column(name="resalenbr3_expdate")
	private Date resaleNumber3ExpDate;
	@Column(name="resalenbr4")
	private String resaleNumnber4;
	@Temporal(TemporalType.DATE)
	@Column(name="resalenbr4_expdate")
	private Date resaleNumber4ExpDate;
	@Column(name="resalenbr5")
	private String resaleNumber5;
	@Temporal(TemporalType.DATE)
	@Column(name="resalenbr5_expdate")
	private Date resaleNumber5ExpDate;
		
	@Column(name="resaleNBr1_statecd")
	private String resaleNumber1StateCode;
		
	@Column(name="resaleNBr2_statecd")
	private String resaleNumber2StateCode;
	@Column(name="resaleNBr3_statecd")
	private String resaleNumber3StateCode;
	@Column(name="resaleNBr4_statecd")
	private String resaleNumber4StateCode;
	@Column(name="resaleNBr5_statecd")
	private String resaleNumber5StateCode;
	
	@Column(name="taxstatecd")
	private String taxStateId;
	@Column(name="taxlocalcd")
	private String taxLocalId;
		
	@Temporal(TemporalType.DATE)
	@Column(name="branchSalesnbrdate")
	private Date branchSalesNumberDate;
	
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
		return authOnly;
	}

	public void setAuthOnly(String authOnly) {
		this.authOnly = authOnly;
	}

	public String getB2Email() {
		return b2Email;
	}

	public void setB2Email(String b2Email) {
		this.b2Email = b2Email;
	}

	public Long getB2Fax() {
		return b2Fax;
	}

	public void setB2Fax(Long b2Fax) {
		this.b2Fax = b2Fax;
	}

	public String getB2FromCorp() {
		return b2FromCorp;
	}

	public void setB2FromCorp(String b2FromCorp) {
		this.b2FromCorp = b2FromCorp;
	}

	public Integer getBranchSalesNo() {
		return branchSalesNo;
	}

	public void setBranchSalesNo(Integer branchSalesNo) {
		this.branchSalesNo = branchSalesNo;
	}

	public String getContractLicenseNo() {
		return contractLicenseNo;
	}

	public void setContractLicenseNo(String contractLicenseNo) {
		this.contractLicenseNo = contractLicenseNo;
	}

	public Integer getDaysToPay() {
		return daysToPay;
	}

	public void setDaysToPay(Integer daysToPay) {
		this.daysToPay = daysToPay;
	}

	public Date getFirstSoldDate() {
		return firstSoldDate;
	}

	public void setFirstSoldDate(Date firstSoldDate) {
		this.firstSoldDate = firstSoldDate;
	}

	public Float getHighBalAmt() {
		return highBalAmt;
	}

	public void setHighBalAmt(Float highBalAmt) {
		this.highBalAmt = highBalAmt;
	}

	public Date getHighBalDate() {
		return highBalDate;
	}

	public void setHighBalDate(Date highBalDate) {
		this.highBalDate = highBalDate;
	}

	public String getInvType() {
		return invType;
	}

	public void setInvType(String invType) {
		this.invType = invType;
	}

	public Float getLastStatementAmount() {
		return lastStatementAmount;
	}

	public void setLastStatementAmount(Float lastStatementAmount) {
		this.lastStatementAmount = lastStatementAmount;
	}

	public Date getLastStatmentDate() {
		return lastStatmentDate;
	}

	public void setLastStatmentDate(Date lastStatmentDate) {
		this.lastStatmentDate = lastStatmentDate;
	}

	public String getAccountManager() {
		return accountManager;
	}

	public void setAccountManager(String accountManager) {
		this.accountManager = accountManager;
	}

	public String getResaleNo() {
		return resaleNo;
	}

	public void setResaleNo(String resaleNo) {
		this.resaleNo = resaleNo;
	}

	public Date getSetupDate() {
		return setupDate;
	}

	public void setSetupDate(Date setupDate) {
		this.setupDate = setupDate;
	}

	public String getStatementNo() {
		return statementNo;
	}

	public void setStatementNo(String statementNo) {
		this.statementNo = statementNo;
	}

	public String getStatementType() {
		return statementType;
	}

	public void setStatementType(String statementType) {
		this.statementType = statementType;
	}

	public Integer getStoreNo() {
		return storeNo;
	}

	public void setStoreNo(Integer storeNo) {
		this.storeNo = storeNo;
	}

	public String getTaxClass() {
		return taxClass;
	}

	public void setTaxClass(String taxClass) {
		this.taxClass = taxClass;
	}

	public Float getTotbalAmount() {
		return totbalAmount;
	}

	public void setTotbalAmount(Float totbalAmount) {
		this.totbalAmount = totbalAmount;
	}

	public Date getInvLasteDate() {
		return invLasteDate;
	}

	public void setInvLasteDate(Date invLasteDate) {
		this.invLasteDate = invLasteDate;
	}

	public String getBatchInventory() {
		return batchInventory;
	}

	public void setBatchInventory(String batchInventory) {
		this.batchInventory = batchInventory;
	}

	public String getPrintStatement() {
		return printStatement;
	}

	public void setPrintStatement(String printStatement) {
		this.printStatement = printStatement;
	}

	public Integer getCustomerGroup() {
		return customerGroup;
	}

	public void setCustomerGroup(Integer customerGroup) {
		this.customerGroup = customerGroup;
	}

	public String getPriceGroup() {
		return priceGroup;
	}

	public void setPriceGroup(String priceGroup) {
		this.priceGroup = priceGroup;
	}

	public Date getInventoryLastMDate() {
		return inventoryLastMDate;
	}

	public void setInventoryLastMDate(Date inventoryLastMDate) {
		this.inventoryLastMDate = inventoryLastMDate;
	}

	public Date getStatementLastEDate() {
		return statementLastEDate;
	}

	public void setStatementLastEDate(Date statementLastEDate) {
		this.statementLastEDate = statementLastEDate;
	}

	public String getApEmail2() {
		return apEmail2;
	}

	public void setApEmail2(String apEmail2) {
		this.apEmail2 = apEmail2;
	}

	public Float getStatementLastEAmount() {
		return statementLastEAmount;
	}

	public void setStatementLastEAmount(Float statementLastEAmount) {
		this.statementLastEAmount = statementLastEAmount;
	}

	public Integer getwDaysToPay() {
		return wDaysToPay;
	}

	public void setwDaysToPay(Integer wDaysToPay) {
		this.wDaysToPay = wDaysToPay;
	}

	public String getSetupBy() {
		return setupBy;
	}

	public void setSetupBy(String setupBy) {
		this.setupBy = setupBy;
	}

	public String getNotBlockCheck() {
		return notBlockCheck;
	}

	public void setNotBlockCheck(String notBlockCheck) {
		this.notBlockCheck = notBlockCheck;
	}

	public Date getResaleNumberExpDate() {
		return resaleNumberExpDate;
	}

	public void setResaleNumberExpDate(Date resaleNumberExpDate) {
		this.resaleNumberExpDate = resaleNumberExpDate;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getInfoEmail1() {
		return infoEmail1;
	}

	public void setInfoEmail1(String infoEmail1) {
		this.infoEmail1 = infoEmail1;
	}

	public String getInfoEmail2() {
		return infoEmail2;
	}

	public void setInfoEmail2(String infoEmail2) {
		this.infoEmail2 = infoEmail2;
	}

	public String getInfoEmail3() {
		return infoEmail3;
	}

	public void setInfoEmail3(String infoEmail3) {
		this.infoEmail3 = infoEmail3;
	}

	public String getInfoEmail4() {
		return infoEmail4;
	}

	public void setInfoEmail4(String infoEmail4) {
		this.infoEmail4 = infoEmail4;
	}

	public String getInfoEmail5() {
		return infoEmail5;
	}

	public void setInfoEmail5(String infoEmail5) {
		this.infoEmail5 = infoEmail5;
	}

	public String getInfoEmail6() {
		return infoEmail6;
	}

	public void setInfoEmail6(String infoEmail6) {
		this.infoEmail6 = infoEmail6;
	}

	public String getInfoEmail7() {
		return infoEmail7;
	}

	public void setInfoEmail7(String infoEmail7) {
		this.infoEmail7 = infoEmail7;
	}

	public String getInfoEmail8() {
		return infoEmail8;
	}

	public void setInfoEmail8(String infoEmail8) {
		this.infoEmail8 = infoEmail8;
	}

	public String getInfoEmail9() {
		return infoEmail9;
	}

	public void setInfoEmail9(String infoEmail9) {
		this.infoEmail9 = infoEmail9;
	}

	public Integer getResaleNumber2() {
		return resaleNumber2;
	}

	public void setResaleNumber2(Integer resaleNumber2) {
		this.resaleNumber2 = resaleNumber2;
	}

	public Date getResaleNumber2ExpDate() {
		return resaleNumber2ExpDate;
	}

	public void setResaleNumber2ExpDate(Date resaleNumber2ExpDate) {
		this.resaleNumber2ExpDate = resaleNumber2ExpDate;
	}

	public String getResaleNumber3() {
		return resaleNumber3;
	}

	public void setResaleNumber3(String resaleNumber3) {
		this.resaleNumber3 = resaleNumber3;
	}

	public Date getResaleNumber3ExpDate() {
		return resaleNumber3ExpDate;
	}

	public void setResaleNumber3ExpDate(Date resaleNumber3ExpDate) {
		this.resaleNumber3ExpDate = resaleNumber3ExpDate;
	}

	public String getResaleNumnber4() {
		return resaleNumnber4;
	}

	public void setResaleNumnber4(String resaleNumnber4) {
		this.resaleNumnber4 = resaleNumnber4;
	}

	public Date getResaleNumber4ExpDate() {
		return resaleNumber4ExpDate;
	}

	public void setResaleNumber4ExpDate(Date resaleNumber4ExpDate) {
		this.resaleNumber4ExpDate = resaleNumber4ExpDate;
	}

	public String getResaleNumber5() {
		return resaleNumber5;
	}

	public void setResaleNumber5(String resaleNumber5) {
		this.resaleNumber5 = resaleNumber5;
	}

	public Date getResaleNumber5ExpDate() {
		return resaleNumber5ExpDate;
	}

	public void setResaleNumber5ExpDate(Date resaleNumber5ExpDate) {
		this.resaleNumber5ExpDate = resaleNumber5ExpDate;
	}

	public String getResaleNumber1StateCode() {
		return resaleNumber1StateCode;
	}

	public void setResaleNumber1StateCode(String resaleNumber1StateCode) {
		this.resaleNumber1StateCode = resaleNumber1StateCode;
	}

	public String getResaleNumber2StateCode() {
		return resaleNumber2StateCode;
	}

	public void setResaleNumber2StateCode(String resaleNumber2StateCode) {
		this.resaleNumber2StateCode = resaleNumber2StateCode;
	}

	public String getResaleNumber3StateCode() {
		return resaleNumber3StateCode;
	}

	public void setResaleNumber3StateCode(String resaleNumber3StateCode) {
		this.resaleNumber3StateCode = resaleNumber3StateCode;
	}

	public String getResaleNumber4StateCode() {
		return resaleNumber4StateCode;
	}

	public void setResaleNumber4StateCode(String resaleNumber4StateCode) {
		this.resaleNumber4StateCode = resaleNumber4StateCode;
	}

	public String getResaleNumber5StateCode() {
		return resaleNumber5StateCode;
	}

	public void setResaleNumber5StateCode(String resaleNumber5StateCode) {
		this.resaleNumber5StateCode = resaleNumber5StateCode;
	}

	public String getTaxStateId() {
		return taxStateId;
	}

	public void setTaxStateId(String taxStateId) {
		this.taxStateId = taxStateId;
	}

	public String getTaxLocalId() {
		return taxLocalId;
	}

	public void setTaxLocalId(String taxLocalId) {
		this.taxLocalId = taxLocalId;
	}

	public Date getBranchSalesNumberDate() {
		return branchSalesNumberDate;
	}

	public void setBranchSalesNumberDate(Date branchSalesNumberDate) {
		this.branchSalesNumberDate = branchSalesNumberDate;
	}

	public Date getPriceGroupDate() {
		return priceGroupDate;
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
