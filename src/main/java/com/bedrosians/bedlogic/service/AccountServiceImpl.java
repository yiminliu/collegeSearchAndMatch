package com.bedrosians.bedlogic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bedrosians.bedlogic.dao.AccountBranchDao;
import com.bedrosians.bedlogic.dao.AccountDao;
import com.bedrosians.bedlogic.dao.CheckPaymentDao;
import com.bedrosians.bedlogic.domain.FullAccount;
import com.bedrosians.bedlogic.domain.AccountBranch;
import com.bedrosians.bedlogic.domain.BranchPK;
import com.bedrosians.bedlogic.domain.CheckPayment;
import com.bedrosians.bedlogic.domain.Account;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
	AccountDao accountDao;
	
    @Autowired
	AccountBranchDao accountBranchDao;
	
    @Autowired
	CheckPaymentDao checkPaymentDao;
	
    @Override
	@Transactional(readOnly=true)
	public List<FullAccount> getAllAccounts(){
    	List<FullAccount> accountList = null;
    	return accountList;
    }    
	
    @Override
	@Transactional(readOnly=true)
	public List<FullAccount> getActiveAccounts(){
    	List<FullAccount> accountList = null;
    	return accountList;
    }
	    
	@Override
	@Transactional(readOnly=true)
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
			String activityStatus) {
		return accountDao.getAccounts(
				accountName,
				addressStreetLine1,
				addressCity,
				addressState,
				addressZip,
				caseNo,
				ownerFirstName,
				ownerLastName,
				ownerDriverLicenseNo,
				phoneNo,
				activityStatus);
	}

	@Override
	@Transactional(readOnly=true)
	public FullAccount getAccountById(String id) {
		
		String spaces = "";
		
		int spaceNeeded = 10 - id.length();
		for (int i = 0 ; i < spaceNeeded ; i++){
			spaces = spaces.concat(" ");
		}
		
		FullAccount account = accountDao.read(id.concat(spaces));
		if (account != null){
			account.setCheckPayments(checkPaymentDao.getCheckPaymentsForAccount(id));
		}
		return  account;
	}
	
	@Override
	@Transactional(readOnly=true)
    public FullAccount getAccountByName(String name){
		FullAccount account = null;
		return account;
	}

	@Override
	@Transactional(readOnly=true)
	public FullAccount getAccountByPhoneNo(String phoneNo){
		FullAccount account = null;
		return account;
	}
	
	@Override
	@Transactional(readOnly=true)
	public FullAccount getAccountByOwnerDriverLicenseNo(String driverLicenseNo){
		FullAccount account = null;
		return account;
	}
	
	public AccountBranch getAccountBranch(BranchPK branchPK) {
		return accountBranchDao.read(branchPK);
	}
	
	public List<CheckPayment> getCheckPaymentsForAccount(String custcd) {
		return checkPaymentDao.getCheckPaymentsForAccount(custcd);
	}
}
