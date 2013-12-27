package com.bedrosians.bedlogic.dao;

import java.util.List;

import com.bedrosians.bedlogic.domain.Account;
import com.bedrosians.bedlogic.domain.SimpleAccount;

public interface AccountDao extends GenericDao<Account, String>{
  public List<SimpleAccount> getSimpleAccounts(
		String accountName,
		String addressStreetLine1,
		String addressCity,
		String addressState,
		String addressZip,
		String caseNo,
		String ownerFirstName,
		String ownerLastName,
		String ownerDriverLicenseNo,
		String phoneNo,
		String activityStatus);
}