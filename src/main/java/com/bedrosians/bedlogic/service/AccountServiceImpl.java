package com.bedrosians.bedlogic.service;

import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bedrosians.bedlogic.dao.account.AccountBranchDao;
import com.bedrosians.bedlogic.dao.account.AccountDao;
import com.bedrosians.bedlogic.dao.account.CheckPaymentDao;
import com.bedrosians.bedlogic.dao.miscellaneous.ObmhDao;
import com.bedrosians.bedlogic.domain.account.Account;
import com.bedrosians.bedlogic.domain.account.AccountBranch;
import com.bedrosians.bedlogic.domain.account.BranchPK;
import com.bedrosians.bedlogic.domain.account.CheckPayment;
import com.bedrosians.bedlogic.exeception.DataNotFoundException;
import com.bedrosians.bedlogic.util.PatternMatchMode;
import com.bedrosians.bedlogic.util.logger.aspect.LogLevel;
import com.bedrosians.bedlogic.util.logger.aspect.Loggable;


@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
	AccountDao accountDao;
    
    @Autowired
	AccountDao accountDetailDao;
	
    @Autowired
    ObmhDao obmhDao;
    
    @Autowired
	AccountBranchDao accountBranchDao;
	
    @Autowired
	CheckPaymentDao checkPaymentDao;
	    	
    @Loggable(value = LogLevel.TRACE)
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
	    
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
    public List<Account> getAccountsByAccountNamePattern(String name){
		return accountDao.findByParameterPattern("accountName", name, PatternMatchMode.START);
	}
	
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
    public List<Account> getAccountsByOwnerName(String firstName, String lastName){
		return accountDao.getAccountsByOwnerName(firstName, lastName);
	}

    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<Account> getAccountsByPhoneNo(String phoneNo){
      // accountDao.getAccountsByParameter(", value)
		return null;
	}
	
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<Account> getAccountsByAddress(String streetAddress){
		return accountDao.findByParameter("addressStreeLine1", streetAddress);
	}
	
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<Account> getAccountsByCity(String city){
		return accountDao.findByParameter("city", city);
	}
	
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<Account> getAccountsByState(String state){
   		return accountDao.findByParameter("state", state);
	}
	
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<Account> getAccountsByZip(String zip){
     	return accountDao.findByParameter("zip", zip);
	}
		
	@Loggable(value = LogLevel.TRACE)
	@Override
	public AccountBranch getAccountBranchById(String accountId, String branchId) {
		BranchPK branchPK = new BranchPK(accountId, branchId);
		return accountBranchDao.findById(branchPK);
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public AccountBranch getAccountBranchById(BranchPK branchPK) {
		return accountBranchDao.findById(branchPK);
	}
	
	public List<CheckPayment> getCheckPaymentsForAccount(String custcd) {
		return checkPaymentDao.getCheckPaymentsForAccount(custcd);
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<Account> getAccounts(){
		return accountDao.getAccountsByActivityStatus("all");
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<Account> getAccountsByActivityStatus(String status){
		return accountDao.getAccountsByActivityStatus(status);
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<Account> getByQueryParameters(MultivaluedMap<String, String> queryParams){
		return accountDao.findByParameters(queryParams);
	}
		
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional
	public String createAccount(Account account){
		return accountDao.save(account); 
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional
	public void updateAccount(String accountId, Account account){
		Account retrievedAccount = null;
		try{
		   retrievedAccount = getAccountById(accountId);
		   if(retrievedAccount == null)
			  throw new DataNotFoundException("No data found"); 
		}
		catch(Exception e){
			throw e;
			
		}
		accountDao.update(account); 
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional
	public void updateAccount(Account account){
		accountDao.update(account); 
	}
	
	/*@Override
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
	*/	
}
