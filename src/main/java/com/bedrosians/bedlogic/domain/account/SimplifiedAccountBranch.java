package com.bedrosians.bedlogic.domain.account;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;


@Entity(name="simplifiedAccountBranch")
@Table(name="armbr")
@DynamicUpdate(value=true)
@SelectBeforeUpdate(value=true)
@DynamicInsert(value=true)
public class SimplifiedAccountBranch extends AccountBranch implements Serializable {
	public SimplifiedAccountBranch(){}

	@Override
	public String toString() {
		return "SimplifiedAccountBranch [getAccountId()=" + getAccountId()
				+ ", getBranchId()=" + getBranchId() + ", getBranchName()="
				+ getBranchName() + ", getAddress()=" + getAddress()
				+ ", getStatus()=" + getStatus() + "]";
	}
	
	
}
