package com.bedrosians.bedlogic.dao.account;

import java.util.List;

import com.bedrosians.bedlogic.dao.GenericDao;
import com.bedrosians.bedlogic.domain.account.Account;
import com.bedrosians.bedlogic.domain.account.AccountPhone;
import com.bedrosians.bedlogic.util.PatternMatchMode;


public interface AccountPhoneDao extends GenericDao<AccountPhone, String>{
  
  public AccountPhone getAccountPhoneById(String accountId);  

	    
}