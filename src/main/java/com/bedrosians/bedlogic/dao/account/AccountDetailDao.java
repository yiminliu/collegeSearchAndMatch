package com.bedrosians.bedlogic.dao.account;

import com.bedrosians.bedlogic.dao.GenericDao;
import com.bedrosians.bedlogic.domain.account.Account;
import com.bedrosians.bedlogic.domain.account.AccountDetail;

public interface AccountDetailDao extends GenericDao<AccountDetail, String>{
  
  public AccountDetail getAccountById(String accountId);  
  public void updateAccount(AccountDetail account);
  public String createAccount(AccountDetail account);
  
}