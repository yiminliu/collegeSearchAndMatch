package com.bedrosians.bedlogic.dao;

import java.util.List;

import com.bedrosians.bedlogic.domain.FullAccount;
import com.bedrosians.bedlogic.domain.Account;

public interface AccountDao extends GenericDao<Account, String>{
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
  
  
  public List<Account> getAllAccounts();	
 	
  public List<Account> getActiveAccounts();
  
  //public List<Account> getInactiveAccounts();
  
  public List<Account> getAccountsByActivityStatus(String status);
  
  //public List<Account> getAccountById(String accountId);
  
  //public List<Account> getAccountByName(String accountName);
  
  public List<Account> getAccountsByParameter(String parameterName, String value);
  
  //public List<Account> getAccountByParameter(String parameterName, String value);
}