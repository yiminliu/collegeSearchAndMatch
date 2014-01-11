package com.bedrosians.bedlogic.domain.account;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bedrosians.bedlogic.util.FormatUtil;

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

	public String getBranchAddressCity() {
		return FormatUtil.trimAndReplicate(branchAddressCity);
	}

	public void setBranchAddressCity(String branchAddressCity) {
		this.branchAddressCity = branchAddressCity;
	}
	
}
