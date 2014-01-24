package com.bedrosians.bedlogic.dao.account;

import java.util.List;

import com.bedrosians.bedlogic.dao.GenericDao;
import com.bedrosians.bedlogic.domain.account.AccountBranch;
import com.bedrosians.bedlogic.domain.account.BranchPK;
import com.bedrosians.bedlogic.domain.account.SimplifiedAccountBranch;

public interface AccountBranchDao extends GenericDao<SimplifiedAccountBranch, BranchPK> {
	
	public SimplifiedAccountBranch getAccountBranchById(String accountId, String branchId); 
	public SimplifiedAccountBranch getAccountBranchByBranchPK(BranchPK branchPK);
    public List<SimplifiedAccountBranch> getAccountBranchByName(String name);

}
