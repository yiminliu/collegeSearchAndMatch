package com.bedrosians.bedlogic.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="armbr")
public class SimpleAccountBranch implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2605648415898228188L;
	
	@EmbeddedId
	private SimpleBranchPK simpleBranchPK;
	
	@Column(name="brname")
	private String branchName;
	
	@Column(name="brcity")
	private String branchAddressCity;
	
	@Column(name="brstatecd")
	private String branchAddressState;
	
	public String getBranchcd(){
		return simpleBranchPK.getBranchcd().trim();
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

	public String getBranchAddressState() {
		return branchAddressState;
	}

	public void setBranchAddressState(String branchAddressState) {
		this.branchAddressState = branchAddressState;
	}
	
}
