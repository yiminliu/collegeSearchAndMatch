package com.bedrosians.bedlogic.dao.account;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.bedrosians.bedlogic.dao.GenericDaoImpl;
import com.bedrosians.bedlogic.domain.account.AccountDetail;


@Repository("accountDetailDao")
public class AccountDetailDaoImpl extends GenericDaoImpl<AccountDetail, String> implements AccountDetailDao {
						
	@Override
	public AccountDetail getAccountById(String accountId) {
		//return findById(accountId);//branch info cannot be linked to the account.
		List<AccountDetail> accounts =  findByParameter("accountId", accountId);
		if(accounts != null && !accounts.isEmpty())
 		   return (AccountDetail)accounts.get(0);
		  //ad.getAccountBranches();
		else
		   return null;
	}
	
	@Override
	public void updateAccount(AccountDetail account){
		update(account);
	}
	  
	@Override
	public String createAccount(AccountDetail account){
		return (String)save(account);  
	}
}
