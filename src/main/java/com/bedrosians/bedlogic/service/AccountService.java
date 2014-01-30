package com.bedrosians.bedlogic.service;

import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.springframework.stereotype.Service;

import com.bedrosians.bedlogic.domain.account.Account;
import com.bedrosians.bedlogic.domain.account.AccountBranch;
import com.bedrosians.bedlogic.domain.account.AccountDetail;
import com.bedrosians.bedlogic.domain.account.BranchPK;
import com.bedrosians.bedlogic.domain.account.CheckPayment;

@Service
public interface AccountService {
	
    public List<? extends Account> getAccounts();
	
	public Account getAccountById(String id);
	
	public List<? extends Account> getAccountsByAccountNamePattern(String name);
	
	public List<? extends Account> getAccountsByActivityStatus(String status);
	
	public List<? extends Account> getAccountsByOwnerName(String firstName, String lastName);
	
	public List<? extends Account> getAccountsByAddress(String address);
	
	public List<? extends Account> getAccountsByCity(String city);
	
	public List<? extends Account> getAccountsByState(String city);
	
	public List<? extends Account> getAccountsByZip(String zip);
	
	public List<? extends Account> getByQueryParameters(MultivaluedMap<String, String> queryParams);
	
	public String createAccount(AccountDetail account);
	
	public void updateAccount(AccountDetail account);
	
	public void updateAccount(String accountId, AccountDetail account);
		
	public List<? extends AccountBranch> getAccountBranches(String accountId);
	
	AccountBranch getAccountBranchById(String accountId, String branchId);
	
	AccountBranch getAccountBranchByBranchPK(BranchPK branchId);
	
	List<CheckPayment> getCheckPaymentsForAccount(String custcd);
}
