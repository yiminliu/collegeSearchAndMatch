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

import com.bedrosians.bedlogic.util.FormatUtil;

@XmlRootElement(name="accountBrancheIds")
@Entity
@Table(name="armbr")
public class AccountBranchId implements Serializable {
	
	private static final long serialVersionUID = 5137707010951170389L;

	@EmbeddedId
	private BranchPK branchPK;
		
	public AccountBranchId(){}
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "custcd", nullable = false)
	public String getAccountId() {
		return FormatUtil.process(branchPK.getAccountId());
	}
    */
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "custcd", nullable = false)
	public String getBranchId() {
		return FormatUtil.process(branchPK == null? "" : branchPK.getBranchId());
	}
	
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((branchPK == null) ? 0 : branchPK.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountBranchId other = (AccountBranchId) obj;
		if (branchPK == null) {
			if (other.branchPK != null)
				return false;
		} else if (!branchPK.equals(other.branchPK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "branchId=" + getBranchId();
	}
	
	
}
