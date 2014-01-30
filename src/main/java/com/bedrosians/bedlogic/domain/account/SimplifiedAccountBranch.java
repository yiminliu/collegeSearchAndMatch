package com.bedrosians.bedlogic.domain.account;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;


@Entity(name="simplifiedAccountBranch")
@Table(name="armbr")
@DynamicUpdate
public class SimplifiedAccountBranch extends AccountBranch implements Serializable {
	public SimplifiedAccountBranch(){}

	@Override
	public String toString() {
		return "SimplifiedAccountBranch [getAccountId()=" + getAccountId()
				+ ", getBranchId()=" + getBranchId() + ", getBranchName()="
				+ getBranchName() + ", getAddress()=" + getAddress()
				+ ", getActivityStatus()=" + getActivityStatus() + "]";
	}
	
	
}
