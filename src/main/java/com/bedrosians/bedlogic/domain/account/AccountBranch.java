package com.bedrosians.bedlogic.domain.account;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.bedrosians.bedlogic.util.ActivityStatus;
import com.bedrosians.bedlogic.util.FormatUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name="accountBranch")
@JsonInclude(Include.NON_NULL)
@Entity
@Table(name="armbr")
public class AccountBranch implements Serializable {
	
	private static final long serialVersionUID = 5137707010951170389L;

	@EmbeddedId
	private BranchPK branchPK;

	@Column(name="brname") 
	private String branchName;
		
	@Column(name="braddr1")
	private String addressLine1;
		
	@Column(name="braddr2")
	private String addressLine2;
	
	@Column(name="brcity")
	private String city;
	
	@Column(name="brstatecd")
	private String state;
	
	@Column(name="brzip")
	private String zip;
	
	@Column(name="brcountrycd")
	private String country;
	
	@Column(name="InactiveCd")
	private String activityStatus;
	
	@Column(name="apcontact")
	private String apContact;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "custcd", nullable = false)
	public String getAccountId() {
		return FormatUtil.trimAndReplicate(branchPK.getAccountId());
	}

	public String getBranchId() {
		return FormatUtil.trimAndReplicate(branchPK.getBranchId());
	}
	
	public String getBranchName() {
		return FormatUtil.trimAndReplicate(branchName);
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getCity() {
		return FormatUtil.trimAndReplicate(city);
	}

	public String getAddressLine1() {
		return FormatUtil.trimAndReplicate(addressLine1);
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return FormatUtil.trimAndReplicate(addressLine2);
	}

	public void setaddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return FormatUtil.trimAndReplicate(state);
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return FormatUtil.trimAndReplicate(zip);
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return FormatUtil.trimAndReplicate(country);
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getApContact() {
		return FormatUtil.trimAndReplicate(apContact);
	}

	public void setApContact(String apContact) {
		this.apContact = apContact;
	}

	//@Column(name="InactiveCd")
	public String getActivityStatus() {
		if(activityStatus == null || activityStatus.trim().length()<1)
			activityStatus = ActivityStatus.ACTIVE.getName();
		else
		    activityStatus = ActivityStatus.INACTIVE.getName();
		return activityStatus;
	}
		
	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
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
	  */ 
}
