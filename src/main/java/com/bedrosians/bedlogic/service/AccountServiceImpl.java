package com.bedrosians.bedlogic.service;

import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bedrosians.bedlogic.dao.account.AccountBranchDao;
import com.bedrosians.bedlogic.dao.account.AccountBranchDetailDao;
import com.bedrosians.bedlogic.dao.account.AccountDao;
import com.bedrosians.bedlogic.dao.account.AccountDetailDao;
import com.bedrosians.bedlogic.dao.account.CheckPaymentDao;
import com.bedrosians.bedlogic.domain.account.Account;
import com.bedrosians.bedlogic.domain.account.AccountBranchDetail;
import com.bedrosians.bedlogic.domain.account.AccountDetail;
import com.bedrosians.bedlogic.domain.account.SimplifiedAccount;
import com.bedrosians.bedlogic.domain.account.AccountBranch;
import com.bedrosians.bedlogic.domain.account.BranchPK;
import com.bedrosians.bedlogic.domain.account.CheckPayment;
import com.bedrosians.bedlogic.domain.account.SimplifiedAccountBranch;
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
	AccountDetailDao accountDetailDao;    
    @Autowired
	AccountBranchDao accountBranchDao;
    @Autowired
	AccountBranchDetailDao accountBranchDetailDao;
	
    @Autowired
	CheckPaymentDao checkPaymentDao;
	    	
    @Loggable(value = LogLevel.TRACE)
    @Override
	@Transactional(readOnly=true)
	public Account getAccountById(String id) {
    	return accountDetailDao.getAccountById(id);
		//if(account != null){	         		
		//	account.setCheckPayments(checkPaymentDao.getCheckPaymentsForAccount(id));
		//}
	}
	    
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
    public List<SimplifiedAccount> getAccountsByAccountNamePattern(String name){
		return accountDao.findByParameterPattern("accountName", name, PatternMatchMode.START);
	}
	
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
    public List<SimplifiedAccount> getAccountsByOwnerName(String firstName, String lastName){
		return accountDao.getAccountsByOwnerName(firstName, lastName);
	}
	
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<SimplifiedAccount> getAccountsByAddress(String streetAddress){
		return accountDao.findByParameter("addressLine1", streetAddress);
	}
	
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<SimplifiedAccount> getAccountsByCity(String city){
		return accountDao.findByParameter("city", city);
	}
	
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<SimplifiedAccount> getAccountsByState(String state){
   		return accountDao.findByParameter("state", state);
	}
	
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<SimplifiedAccount> getAccountsByZip(String zip){
     	return accountDao.findByParameter("zip", zip);
	}
		
	@Loggable(value = LogLevel.TRACE)
	@Override
	public AccountBranch getAccountBranchById(String accountId, String branchId) {
		BranchPK branchPK = new BranchPK(accountId, branchId);
		return accountBranchDetailDao.findById(branchPK);
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public AccountBranch getAccountBranchByBranchPK(BranchPK branchPK) {
		return accountBranchDetailDao.findById(branchPK);
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	public List<SimplifiedAccountBranch> getAccountBranches(String accountId) {
		return accountBranchDao.getAccountBranches(accountId);
	}
	
	
	public List<CheckPayment> getCheckPaymentsForAccount(String custcd) {
		return checkPaymentDao.getCheckPaymentsForAccount(custcd);
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<SimplifiedAccount> getAccounts(){
		return accountDao.getAccountsByActivityStatus("all");
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<SimplifiedAccount> getAccountsByActivityStatus(String status){
		return accountDao.getAccountsByActivityStatus(status);
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<SimplifiedAccount> getByQueryParameters(MultivaluedMap<String, String> queryParams){
		return accountDao.findByParameters(queryParams);
	}
		
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional
	public String createAccount(AccountDetail account){
		return accountDetailDao.createAccount(account); 
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional
	public void updateAccount(String accountId, AccountDetail account){
		Account retrievedAccount = null;
		try{
		   retrievedAccount = getAccountById(accountId);
		   if(retrievedAccount == null)
			  throw new DataNotFoundException("No data found"); 
		}
		catch(Exception e){
			throw e;
			
		}
		//if(account instanceof AccountDetail)
		   accountDetailDao.updateAccount((AccountDetail)account); 
		//else if(account instanceof SimplifiedAccount)
		  // accountDao.update((SimplifiedAccount)account); 
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional
	public void updateAccount(AccountDetail account){
		//if(account instanceof AccountDetail)
		   accountDetailDao.updateAccount(account); 
		//else if(account instanceof SimplifiedAccount)
		  // accountDao.update((SimplifiedAccount)account);
	}	
	
}
