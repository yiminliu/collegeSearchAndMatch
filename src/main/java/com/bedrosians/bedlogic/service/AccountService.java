package com.bedrosians.bedlogic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bedrosians.bedlogic.domain.AccountBranch;
import com.bedrosians.bedlogic.domain.BranchPK;
import com.bedrosians.bedlogic.domain.CheckPayment;
import com.bedrosians.bedlogic.domain.Account;

@Service
public interface AccountService {
	
    List<Account> getAccounts();
	
	//List<Account> getActiveAccounts();
	
	List<Account> getAccountsByActivityStatus(String status);
	
	Account getAccountById(String id);
	
	List<Account> getAccountsByAccountName(String name);
	
	List<Account> getAccountsByPhoneNo(String phoneNo);
	
	List<Account> getAccountsByOwnerName(String firstName, String lastName);
	
	List<Account> getAccountsByAddress(String address);
	
	List<Account> getAccountsByCity(String city);
	
	List<Account> getAccountsByZip(String zip);
		
	List<Account> getAccounts(
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
