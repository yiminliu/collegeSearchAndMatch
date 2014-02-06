package com.bedrosians.bedlogic.dao.account;

import java.util.List;
import java.util.Set;

import com.bedrosians.bedlogic.dao.GenericDao;
import com.bedrosians.bedlogic.domain.account.Account;
import com.bedrosians.bedlogic.domain.account.SimplifiedAccount;
import com.bedrosians.bedlogic.domain.account.AccountDetail;

public interface AccountDao extends GenericDao<SimplifiedAccount, String>{
  
  public List<? extends Account> getAllAccounts();
  public Account getAccountById(String accountId);  
  public List<? extends Account> getAccountsByStatus(String status);	
  public List<? extends Account> getAccountsByOwnerName(String firstName, String lastName);
  public String createAccount(SimplifiedAccount symolifiedAccount);
  public void updateAccount(SimplifiedAccount account);
  //public String createAccount(Account account);
    
}