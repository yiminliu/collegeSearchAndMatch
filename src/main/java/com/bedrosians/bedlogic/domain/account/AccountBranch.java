package com.bedrosians.bedlogic.domain.account;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.AttributeOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.springframework.stereotype.Component;

import com.bedrosians.bedlogic.util.ActivityStatus;
import com.bedrosians.bedlogic.util.FormatUtil;


@Component
@MappedSuperclass
public class AccountBranch implements Serializable {
	
	private static final long serialVersionUID = 5137707010951170389L;

	@EmbeddedId
	private BranchPK branchPK;
	
	@Column(name="brname") 
	private String branchName;
		
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="streeLine1", column=@Column(name="brAddr1")),
		@AttributeOverride(name="streeLine2", column=@Column(name="brAddr2")),
		@AttributeOverride(name="city", column=@Column(name="brcity")),
		@AttributeOverride(name="state", column=@Column(name="brStateCd")),
		@AttributeOverride(name="zip", column=@Column(name="brZip")),
		@AttributeOverride(name="country", column=@Column(name="brCountryCd"))
	})
	private Address address;

	public AccountBranch(){
	}
		
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "custcd", nullable = false)
	public String getAccountId() {
		return FormatUtil.process(branchPK.getAccountId());
	}

	public String getBranchId() {
		return FormatUtil.process(branchPK.getBranchId());
	}
	
	public String getBranchName() {
		return FormatUtil.process(branchName);
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	public Address getAddress() {
		return address;
	}
  
	public void setAddress(Address address) {
		this.address = address;
	}
    
	@Column(name="InactiveCd")
	private String activityStatus;
			
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

}
