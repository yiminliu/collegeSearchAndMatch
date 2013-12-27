package com.bedrosians.bedlogic.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class BranchPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6402519899819097510L;
	
	@Column(name="custcd")
	private String custcd;
	
	@Column(name="branchcd")
	private String branchcd;

	public BranchPK(String custcd, String branchcd) {
		super();
		this.custcd = custcd;
		this.branchcd = branchcd;
	}
	public String getCustcd() {
		return custcd;
	}
	public void setCustcd(String custcd) {
		this.custcd = custcd;
	}
	public String getBranchcd() {
		return branchcd;
	}
	public void setBranchcd(String branchcd) {
		this.branchcd = branchcd;
	}

}
