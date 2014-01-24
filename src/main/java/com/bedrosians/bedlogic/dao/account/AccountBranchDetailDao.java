package com.bedrosians.bedlogic.dao.account;

import java.util.List;

import com.bedrosians.bedlogic.dao.GenericDao;
import com.bedrosians.bedlogic.domain.account.AccountBranch;
import com.bedrosians.bedlogic.domain.account.AccountBranchDetail;
import com.bedrosians.bedlogic.domain.account.BranchPK;

public interface AccountBranchDetailDao extends GenericDao<AccountBranchDetail, BranchPK> {
	
	public AccountBranchDetail getAccountBranchById(String accountId, String branchId); 
	public AccountBranchDetail getAccountBranchByBranchPK(BranchPK branchPK);
    public List<AccountBranchDetail> getAccountBranchByName(String name);

}
