package com.bedrosians.bedlogic.dao;

import java.util.List;

import com.bedrosians.bedlogic.domain.Account;
import com.bedrosians.bedlogic.domain.AccountPhone;
import com.bedrosians.bedlogic.util.PatternMatchMode;


public interface AccountPhoneDao extends GenericDao<AccountPhone, String>{
  
  public AccountPhone getAccountPhoneById(String accountId);  

	    
}