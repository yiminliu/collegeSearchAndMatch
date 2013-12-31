package com.bedrosians.bedlogic.dao;

import java.util.List;

import com.bedrosians.bedlogic.domain.Account;
import com.bedrosians.bedlogic.domain.AccountPhone;


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
    
  public Account getAccountById(String accountId);
  
  public List<Account> getAccountsByActivityStatus(String activityStatus);	
 
  List<Account> getAccountsByParameter(String parameterName, String value);
  
  List<Account> getAccountsByParameters(String[] parameterNames, String[] values);
  
  //public AccountPhone getAccountPhone(String id);
  
  
  //public List<Account> getInactiveAccounts();
  
 
  
  //public List<Account> getAccountByName(String accountName);
  
   
  //public List<Account> getAccountByParameter(String parameterName, String value);
}