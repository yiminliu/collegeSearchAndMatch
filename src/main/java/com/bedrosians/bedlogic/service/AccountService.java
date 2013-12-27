package com.bedrosians.bedlogic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bedrosians.bedlogic.domain.Account;
import com.bedrosians.bedlogic.domain.AccountBranch;
import com.bedrosians.bedlogic.domain.BranchPK;
import com.bedrosians.bedlogic.domain.CheckPayment;
import com.bedrosians.bedlogic.domain.SimpleAccount;

@Service
public interface AccountService {
	
    List<Account> getAllAccounts();
	
	List<Account> getActiveAccounts();
	
	Account getAccountById(String id);
	
	Account getAccountByName(String name);
	
	Account getAccountByPhoneNo(String phoneNo);
	
	Account getAccountByOwnerDriverLicenseNo(String driverLicenseNo);
	
	List<SimpleAccount> getSimpleAccounts(
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
