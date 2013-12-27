package com.bedrosians.bedlogic.dao;

import java.util.List;

import com.bedrosians.bedlogic.domain.FullAccount;
import com.bedrosians.bedlogic.domain.Account;

public interface AccountDao extends GenericDao<FullAccount, String>{
  public List<Account> getAccounts(
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