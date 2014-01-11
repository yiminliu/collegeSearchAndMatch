package com.bedrosians.bedlogic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bedrosians.bedlogic.dao.account.AccountBranchDao;
import com.bedrosians.bedlogic.dao.account.AccountDao;
import com.bedrosians.bedlogic.dao.account.CheckPaymentDao;
import com.bedrosians.bedlogic.domain.account.Account;
import com.bedrosians.bedlogic.domain.account.AccountBranch;
import com.bedrosians.bedlogic.domain.account.BranchPK;
import com.bedrosians.bedlogic.domain.account.CheckPayment;

@Service("accountService")
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
	public Account getAccountById(String id) {
    	Account account = null;
		//accountDao.getAccountById(id);
		List<Account> accountList = (List<Account>)accountDao.findByParameter("accountId", id);
		if(accountList != null && accountList.size() > 0)
		account =  accountList.get(0);
		//if(account != null){	         		
		//	account.setCheckPayments(checkPaymentDao.getCheckPaymentsForAccount(id));
		//}
		return  account;
	}
	
	@Override
	@Transactional(readOnly=true)
    public List<Account> getAccountsByAccountName(String name){
		return accountDao.findByParameter("accountName", name);
	}
	
	@Override
	@Transactional(readOnly=true)
    public List<Account> getAccountsByOwnerName(String firstName, String lastName){
		return accountDao.getAccountsByOwnerName(firstName, lastName);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Account> getAccountsByPhoneNo(String phoneNo){
      // accountDao.getAccountsByParameter(", value)
		return null;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Account> getAccountsByAddress(String streetAddress){
		return accountDao.findByParameter("addressStreeLine1", streetAddress);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Account> getAccountsByCity(String city){
		return accountDao.findByParameter("addressCity", city);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Account> getAccountsByState(String state){
        //return accountDao.getAccountsByParameter("city", city);
		return accountDao.findByParameter("addressState", state);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Account> getAccountsByZip(String zip){
        //return accountDao.getAccountsByParameter("zip", zip);
		return accountDao.findByParameter("addressZip", zip);
	}
		
	@Override
	public AccountBranch getAccountBranchById(String accountId, String branchId) {
		BranchPK branchPK = new BranchPK(accountId, branchId);
		return accountBranchDao.findById(branchPK);
	}
	
	@Override
	public AccountBranch getAccountBranchById(BranchPK branchPK) {
		return accountBranchDao.findById(branchPK);
	}
	
	public List<CheckPayment> getCheckPaymentsForAccount(String custcd) {
		return checkPaymentDao.getCheckPaymentsForAccount(custcd);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Account> getAccounts(){
		return accountDao.getAccountsByActivityStatus("all");
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Account> getAccountsByActivityStatus(String status){
		return accountDao.getAccountsByActivityStatus(status);
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
	@Transactional
	public String createAccount(Account account){
		return accountDao.save(account); 
	}
	
	@Override
	@Transactional
	public void updateAccount(Account account){
		accountDao.update(account); 
	}
	    
}
