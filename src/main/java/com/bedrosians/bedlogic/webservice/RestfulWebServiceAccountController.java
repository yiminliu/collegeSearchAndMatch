package com.bedrosians.bedlogic.webservice;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bedrosians.bedlogic.domain.AccountBranch;
import com.bedrosians.bedlogic.domain.BranchPK;
import com.bedrosians.bedlogic.domain.Account;
import com.bedrosians.bedlogic.exeception.DataNotFoundException;
import com.bedrosians.bedlogic.exeception.InvalidRequestParameterException;
import com.bedrosians.bedlogic.exeception.RestError;
import com.bedrosians.bedlogic.service.AccountService;

@Controller
@RequestMapping("/accounts")
public class RestfulWebServiceAccountController {

	@Autowired
    AccountService accountService;
		
	@RequestMapping(value={"/lookup/{activityStatus}"}, method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK )
	@ResponseBody
	public List<Account> getAccounts(@PathVariable String activityStatus) {
			
		List<Account> accounts = null;
				
		if ("all".equalsIgnoreCase(activityStatus)    ||
            "active".equalsIgnoreCase(activityStatus) ||
		    "inactive".equalsIgnoreCase(activityStatus))
		
			accountService.getAccountsByActivityStatus(activityStatus);
		else
			throw new IllegalArgumentException("Valid values for parameter 'activityStatus' are all, active, or inactive");
				
		if (accounts.size() == 0){
			throw new DataNotFoundException();
		}
		
		return accounts;
	}
			
	@RequestMapping(value="/lookup/accountId/{accountId}", method=RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	@ResponseStatus( HttpStatus.OK )
	//public Account getAccountById(@RequestParam String accountId, HttpServletRequest request) throws Exception{
	public Account getAccountById(@PathVariable String accountId, HttpServletRequest request) throws Exception{
		
		Account account = accountService.getAccountById(accountId);
		if (account == null){
			throw new DataNotFoundException();
		}
		return account;
	}
	
	@RequestMapping(value="/lookup/payment/accountId/{accountId}", method=RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	@ResponseStatus( HttpStatus.OK )
	public Account getAccountWithPaymentInfoById(@PathVariable String accountId, HttpServletRequest request) throws Exception{
		
		Account account = accountService.getAccountById(accountId);
		if (account == null){
			throw new DataNotFoundException();
		}
		return account;
	}
	
	@RequestMapping(value="/lookup/user/accountId/{accountId}", method=RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	@ResponseStatus( HttpStatus.OK )
	public Account getAccountWithUsesrsById(@PathVariable String accountId, HttpServletRequest request) throws Exception{
		
		Account account = accountService.getAccountById(accountId);
		if (account == null){
			throw new DataNotFoundException();
		}
		return account;
	}
	
	
	
	@RequestMapping(value="/lookup/accountName/{accountName}", method=RequestMethod.GET)
	@ResponseBody
	@ResponseStatus( HttpStatus.OK )
	public List<Account> getAccountByAccountName(@PathVariable String accountName, HttpServletRequest request) throws Exception{
				
		List<Account> accountList = accountService.getAccountsByAccountName(accountName);
		if (accountList == null || accountList.size() < 1){
			throw new DataNotFoundException();
		}
		return accountList;
	}
	
	@RequestMapping(value="/lookup/ownerName/{firtName}/{lastName}", method=RequestMethod.GET)
	@ResponseBody
	@ResponseStatus( HttpStatus.OK )
	public List<Account> getAccountByOwnerName(@PathVariable String firstName, @PathVariable String lastName, HttpServletRequest request) throws Exception{
				
		List<Account> accountList = accountService.getAccountsByOwnerName(firstName, lastName);
		if (accountList == null || accountList.size() < 1){
			throw new DataNotFoundException();
		}
		return accountList;
	}
	
	@RequestMapping(value="/lookup/phoneNo/{phoneNo}", method=RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	//public List<Account> getAccountByPhoneNo(@RequestParam String phoneNo, HttpServletRequest request) throws Exception{
	public List<Account> getAccountByPhoneNo(@PathVariable String phoneNo, HttpServletRequest request) throws Exception{
		
		List<Account> accountList = accountService.getAccountsByPhoneNo(phoneNo);
		if (accountList == null || accountList.size() < 1){
			throw new DataNotFoundException();
		}
		return accountList;
	}
	
	@RequestMapping(value="/lookup/address/{address}", method=RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	//public List<Account> getAccountByAddress(@RequestParam String address, HttpServletRequest request) throws Exception{
	public List<Account> getAccountByAddress(@PathVariable String address, HttpServletRequest request) throws Exception{
		List<Account> accountList = accountService.getAccountsByAddress(address);
		if (accountList == null || accountList.size() < 1){
			throw new DataNotFoundException();
		}
		return accountList;
	}
	
	@RequestMapping(value="/lookup/city/{city}", method=RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	//public List<Account> getAccountByCity(@RequestParam String city, HttpServletRequest request) throws Exception{
	public List<Account> getAccountByCity(@PathVariable String city, HttpServletRequest request) throws Exception{
		
		List<Account> accountList = accountService.getAccountsByCity(city);
		if (accountList == null || accountList.size() < 1){
			throw new DataNotFoundException();
		}
		return accountList;
	}
	
	@RequestMapping(value="/lookup/zip/{zip}", method=RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	//public List<Account> getAccountByZip(@RequestParam String zip, HttpServletRequest request) throws Exception{
    public List<Account> getAccountByZip(@PathVariable String zip, HttpServletRequest request) throws Exception{
				
		List<Account> accountList = accountService.getAccountsByZip(zip);
		if (accountList == null || accountList.size() < 1){
			throw new DataNotFoundException();
		}
		return accountList;
	}
		
	
	@RequestMapping(value="/{accountId}/{branchId}", method=RequestMethod.GET)
	@ResponseBody
	public AccountBranch getAccountBranchById(@PathVariable String accountId, @PathVariable String branchId, HttpServletRequest request) throws Exception{
		BranchPK branchPK = new BranchPK(accountId, branchId);
		AccountBranch accountBranch = accountService.getAccountBranch(branchPK);
		if (accountBranch == null){
			throw new DataNotFoundException();
		}
		return accountBranch;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ResponseEntity createAccount(@RequestBody Account account){
		
		 try {
             accountService.createAccount(account);
         } catch(Exception e) {
             e.printStackTrace();
             throw new RuntimeException(e);
         }
         return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public ResponseEntity updateAccount(@RequestBody Account account){
		
		 try {
             accountService.updateAccount(account);
         } catch(Exception e) {
             e.printStackTrace();
             throw new RuntimeException(e);
         }
         return new ResponseEntity(HttpStatus.OK);
	}
		
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK )
	@ResponseBody
	public List<Account> getAccounts(
			@RequestParam(value="accountName", required=false) String accountName,
			@RequestParam(value="addressStreetLine1", required=false) String addressStreetLine1,
			@RequestParam(value="addressCity", required=false) String addressCity,
			@RequestParam(value="addressState", required=false) String addressState,
			@RequestParam(value="addressZip", required=false) String addressZip,
			@RequestParam(value="caseNo", required=false) String caseNo,
			@RequestParam(value="ownerFirstName", required=false) String ownerFirstName,
			@RequestParam(value="ownerLastName", required=false) String ownerLastName,
			@RequestParam(value="ownerDriverLicenseNo", required=false) String ownerDriverLicenseNo,
			@RequestParam(value="phoneNo", required=false) String phoneNo,
			@RequestParam(value="activityStatus", required=true) String activityStatus, 
			HttpServletRequest request) throws Exception {
	
		if (activityStatus.equals("all") || activityStatus.equals("active") || activityStatus.equals("inactive")){

			List<Account> accounts = accountService.getAccounts(
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
			if (accounts.size() == 0){
				throw new DataNotFoundException();
			}
		
			return accounts;
			
		}
		else{
			throw new InvalidRequestParameterException("Valid values for parameter 'activityStatus' are all, active, or inactive");
		}
	}
	
	@ExceptionHandler(DataNotFoundException.class)
	@ResponseBody
	public List<Object> handleDataNotFoundException(){
		return new ArrayList<Object>(0);
	}
	
	@ExceptionHandler(ServletRequestBindingException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public Map<String, Object> handleIServletRequestBindingException(ServletRequestBindingException ex){
		String[] messages = {ex.getMessage()};
		return this.composeJsonErrorMap(messages);
	}
	
	@ExceptionHandler(TransactionException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public Map<String, Object> handleTransactionException(){
		String[] messages = {"Database is busy or unavailable"};
		return this.composeJsonErrorMap(messages);
	}
	
	@ExceptionHandler(DataAccessException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public Map<String, Object> handleDataAccessException(){
		String[] messages = {"Database access error"};
		return this.composeJsonErrorMap(messages);
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public Map<String, Object> handleRuntimeException(RuntimeException ex){
		ex.printStackTrace();
		String[] messages = {"Internal server error"};
		return this.composeJsonErrorMap(messages);
	}
		
	private Map<String, Object> composeJsonErrorMap(String[] messages){
		Map<String, Object> map = new HashMap<String, Object>();
		List<RestError> restErrors = new LinkedList<RestError>();
		for (String msg : messages){
			System.out.println("error: " + msg);
			restErrors.add(new RestError(msg));
		}
		map.put("errors", restErrors);
		return map;
	}
}
