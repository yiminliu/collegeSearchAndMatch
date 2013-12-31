package com.bedrosians.bedlogic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bedrosians.bedlogic.dao.AccountBranchDao;
import com.bedrosians.bedlogic.dao.AccountDao;
import com.bedrosians.bedlogic.dao.AccountDaoImpl;
import com.bedrosians.bedlogic.dao.CheckPaymentDao;
import com.bedrosians.bedlogic.domain.AccountBranch;
import com.bedrosians.bedlogic.domain.BranchPK;
import com.bedrosians.bedlogic.domain.CheckPayment;
import com.bedrosians.bedlogic.domain.Account;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
	AccountDaoImpl accountDao;
	
    @Autowired
	AccountBranchDao accountBranchDao;
	
    @Autowired
	CheckPaymentDao checkPaymentDao;
	
    
   	/*@Override
	@Transactional(readOnly=true)
	public Account getAccountById(String id) {
		
		String spaces = "";
		
		int spaceNeeded = 10 - id.length();
		for (int i = 0 ; i < spaceNeeded ; i++){
			spaces = spaces.concat(" ");
		}
		
		Account account = accountDao.read(id.concat(spaces));
		if (account != null){
			account.setCheckPayments(checkPaymentDao.getCheckPaymentsForAccount(id));
		}
		return  account;
	}
	*/
    
    @Override
	@Transactional(readOnly=true)
	public Account getAccountById(String id) {
		
		/*String spaces = "";
		
		int spaceNeeded = 10 - id.length();
		for (int i = 0 ; i < spaceNeeded ; i++){
			spaces = spaces.concat(" ");
		}
		*/
		//Account account = accountDao.getAccountById(id.concat(spaces));
    	Account account = accountDao.getAccountById(id);
		if(account != null){	         		
			account.setCheckPayments(checkPaymentDao.getCheckPaymentsForAccount(id));
		}
		return  account;
	}
	
	@Override
	@Transactional(readOnly=true)
    public List<Account> getAccountsByAccountName(String name){
		return accountDao.getAccountsByParameter("accountName", name);
	}
	
	@Override
	@Transactional(readOnly=true)
    public List<Account> getAccountsByOwnerName(String firstName, String lastName){
		return accountDao.getAccountsByParameters(new String[] {"ownerFirstName, ownerLastName"},
				                                  new String[] {firstName, lastName});
	//  return null;
	
    }

	@Override
	@Transactional(readOnly=true)
	public List<Account> getAccountsByPhoneNo(String phoneNo){
        return null;
		//accountDao.getAccountsByParameter(", value)
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Account> getAccountsByAddress(String streetAddress){

		return accountDao.getAccountsByParameter("addressStreeLine1", streetAddress);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Account> getAccountsByCity(String city){
        return accountDao.getAccountsByParameter("city", city);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Account> getAccountsByZip(String zip){
        return accountDao.getAccountsByParameter("zip", zip);
	}
	
	
	
	public AccountBranch getAccountBranch(BranchPK branchPK) {
		return accountBranchDao.read(branchPK);
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
	    
}
