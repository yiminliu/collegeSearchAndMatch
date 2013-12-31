package com.bedrosians.bedlogic.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="armbr")
public class AccountBranch implements Serializable {
	
	private static final long serialVersionUID = 5137707010951170389L;

	@EmbeddedId
	private BranchPK branchPK;
	
	@Column(name="brname")
	private String branchName;
	
	@Column(name="brcity")
	private String branchAddressCity;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "custcd", nullable = false)
	public String getCustcd() {
		return branchPK.getCustcd();
	}

	public String getBranchcd() {
		return branchPK.getBranchcd();
	}

	public String getBranchName() {
		if (branchName != null) branchName = branchName.trim();
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchAddressCity() {
		if (branchAddressCity != null) branchAddressCity = branchAddressCity.trim();
		return branchAddressCity;
	}

	public void setBranchAddressCity(String branchAddressCity) {
		this.branchAddressCity = branchAddressCity;
	}

	
}
