package com.bedrosians.bedlogic.dao.account;

import java.util.List;
import java.util.Set;

import com.bedrosians.bedlogic.dao.GenericDao;
import com.bedrosians.bedlogic.domain.account.Account;
import com.bedrosians.bedlogic.domain.account.AccountDetail;

public interface AccountDao extends GenericDao<Account, String>{
  
  public Account getAccountById(String accountId);  
  public List<Account> getAccountsByActivityStatus(String activityStatus);	
  public List<Account> getAccountsByOwnerName(String firstName, String lastName);
  List<Account> getAccountsByParameters(String[] parameterNames, String[] values);
  /* public List<Account> getAccounts(
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
   */	    
}