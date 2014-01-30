package com.bedrosians.bedlogic.dao.account;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bedrosians.bedlogic.dao.GenericDaoImpl;
import com.bedrosians.bedlogic.domain.account.AccountBranchDetail;
import com.bedrosians.bedlogic.domain.account.SimplifiedAccount;
import com.bedrosians.bedlogic.domain.account.AccountBranch;
import com.bedrosians.bedlogic.domain.account.BranchPK;

@Repository
public class AccountBranchDetailDaoImpl extends GenericDaoImpl<AccountBranchDetail, BranchPK> implements AccountBranchDetailDao {

	@Override
	public AccountBranchDetail getAccountBranchById(String accountId, String branchId){
		if(branchId != null && branchId.length() > 0)
			branchId.toUpperCase();	
		BranchPK branchPK = new BranchPK(accountId, branchId);
		return findById(branchPK);
		
	}
	
	@Override
	public AccountBranchDetail getAccountBranchByBranchPK(BranchPK branchPK){
		return findById(branchPK);
		
	}
   
	@Override
	public List<AccountBranchDetail> getAccountBranchByName(String name){
        return null;
   	   		
   	 }
   
}
