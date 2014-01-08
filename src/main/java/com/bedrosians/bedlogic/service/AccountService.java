package com.bedrosians.bedlogic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bedrosians.bedlogic.domain.AccountBranch;
import com.bedrosians.bedlogic.domain.BranchPK;
import com.bedrosians.bedlogic.domain.CheckPayment;
import com.bedrosians.bedlogic.domain.Account;

@Service
public interface AccountService {
	
    public List<Account> getAccounts();
	
	//List<Account> getActiveAccounts();
	
	public List<Account> getAccountsByActivityStatus(String status);
	
	public Account getAccountById(String id);
	
	public List<Account> getAccountsByAccountName(String name);
	
	public List<Account> getAccountsByPhoneNo(String phoneNo);
	
	public List<Account> getAccountsByOwnerName(String firstName, String lastName);
	
	public List<Account> getAccountsByAddress(String address);
	
	public List<Account> getAccountsByCity(String city);
	
	public List<Account> getAccountsByState(String city);
	
	public List<Account> getAccountsByZip(String zip);
	
	public String createAccount(Account account);
	
	public void updateAccount(Account account);
		
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
		
	AccountBranch getAccountBranch(BranchPK branchId);
	
	List<CheckPayment> getCheckPaymentsForAccount(String custcd);
}
