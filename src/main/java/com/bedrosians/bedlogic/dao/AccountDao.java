package com.bedrosians.bedlogic.dao;

import java.util.List;
import java.util.Set;

import com.bedrosians.bedlogic.domain.Account;

public interface AccountDao extends GenericDao<Account, String>{
  
  public Account getAccountById(String accountId);  
  public List<Account> getAccountsByActivityStatus(String activityStatus);	
  public List<Account> getAccountsByOwnerName(String firstName, String lastName);
  public Set<Account> getAccountsByPhoneNo(Long phoneNo);
  List<Account> getAccountsByParameters(String[] parameterNames, String[] values);
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