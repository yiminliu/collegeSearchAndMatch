package com.bedrosians.bedlogic.domain.account;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class SimpleBranchPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6979876835672884610L;

	@Column(name="branchcd")
	private String branchcd;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="custcd")
	private Account account;

	public String getBranchcd() {
		return branchcd;
	}

	public void setBranchcd(String branchcd) {
		this.branchcd = branchcd;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
