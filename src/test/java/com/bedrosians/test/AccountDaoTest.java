package com.bedrosians.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.collection.internal.PersistentSet;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;

import com.bedrosians.bedlogic.dao.account.AccountDao;
import com.bedrosians.bedlogic.dao.miscellaneous.ObmhDao;
import com.bedrosians.bedlogic.domain.account.Account;
import com.bedrosians.bedlogic.domain.account.AccountBranch;
import com.bedrosians.bedlogic.domain.account.AccountBranchId;
import com.bedrosians.bedlogic.domain.account.AccountPhone;
import com.bedrosians.bedlogic.domain.account.BranchPK;
import com.bedrosians.bedlogic.domain.account.User;
import com.bedrosians.bedlogic.util.PatternMatchMode;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/Bedlogic-test-context.xml")
//@ContextConfiguration(locations = {"classpath*/appContext/bedlogic-context.xml", "classpath*/appContext/bedlogic-persistence.xml"})
//@ContextConfiguration(locations = {"classpath*/appContext/bedlogic-persistence.xml"})


public class AccountDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private ObmhDao obmhDao;

	private static String testAccountId = null;
	private static String testAccountName = null;
	private static String testZip = null;
	private static String testCity = null;
	private static String testAddress = null;
	private static Long testPhoneNo = null;
    private static String testState = null;
    private static String testFirstName = null;
    private static String testLastName = null;
	
	
	@Before
	public void setup(){
		testAccountId = "26818"; //"17884";//
		testAccountName = "STONE AGE TILE";
		testZip = "90640";
		testCity = "anaheim";
		testAddress = "1701 SOUTH STATE COLLEGE";
		testPhoneNo = 7147049293L;
		testState = "NY";
		testFirstName = "LARRY/ROGER/HAT";
		testLastName = "HAJALI";
	}
	
	 
	/*@Test
	public void testGetAccounts(){
		System.out.println("test if the account is returned for some search criteria...");
		
		List<Account> accountList = accountDao.getAccounts(
				"stone age tile",
				null,
				"anaheim",
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				"all");
		//assertEquals("Only one account should be returned with given criteria", 1, simpleAccountList.size());
	}
	*/	
	@Test
	public void testGetAccountById(){
		System.out.println("test if the account is returned by searching its ID...");
		Account account = accountDao.getAccountById(testAccountId);
		System.out.println("account = " + account.toString());
		assertNotNull("should not be null", account);
		assertEquals("Account id should be " + testAccountId, testAccountId, account.getAccountId());
	}
			
	//@Test
	public void testGetAccountsByActivityStatus(){
		System.out.println("test if the account is returned by searching its status...");
		Account account = accountDao.getAccountsByActivityStatus("inactive").get(0);
		assertNotNull("should not be null", account);
		System.out.println("account = " + account.toString());
		assertEquals("account should have inactive status ", "D", account.getActivityStatus());
	}
	
	/*@Test
	public void testGetAccountByPhoneNo(){
		System.out.println("test if the account by phone number");
		Set<Account> accounts = accountDao.getAccountsByPhoneNo(testPhoneNo);
		assertNotNull("should not be null", accounts);
		System.out.println(accounts.size());
		for(Account account : accounts) {
  		    System.out.println("account = " + account.toString());		
  		    for(AccountPhone phone : account.getAccountPhones()){
  		        assertEquals(account, phone.getAccount());
  		    	assertEquals(testPhoneNo, phone.getNumber());
  		    }	
		}		
	}
	*/
	
	@Test
	public void testGetAccountsByAccountNameParameter(){
		System.out.println("test if the account is returned by searching its parameter's name...");
		Account account = accountDao.findByParameter("accountName", testAccountName).get(0);
		assertNotNull("should not be null", account);
		System.out.println("account = " + account.toString());
		assertEquals("account should have 'THE RUG SHOPPE' as account name", testAccountName, account.getAccountName());
	}
	
	@Test
	public void testGetAccountsByAccountNamePattern(){
		System.out.println("test if the account is returned by searching its parameter's name...");
		List<Account> accounts = accountDao.findByParameterPattern("accountName", "STONE", PatternMatchMode.START);
		assertNotNull("should not be null", accounts);
		for(Account account : accounts) {
		   System.out.println("account name = " + account.getAccountName());
		   //assertEquals("account should have 'THE RUG SHOPPE' as account name", testAccountName, account.getAccountName());
	
		}
	}	
	
	@Test
	public void testGetAccountsByOwnerName(){
		System.out.println("test if the account is returned by searching its owner's name...");
		List<Account> accounts = accountDao.getAccountsByOwnerName(testFirstName, testLastName);
		assertNotNull("should not be null", accounts);
		for(Account account : accounts) {
		   System.out.println("account = " + account.toString());
		   assertEquals("account should have 'THE RUG SHOPPE' as account name", testAccountName, account.getAccountName());
	    }
	
	}
	
	@Test
	public void testGetAccountsByZipParameter(){
		System.out.println("test if the account is returned by searching its zip...");
		Account account = accountDao.findByParameter("zip", testZip).get(0);
		assertNotNull("should not be null", account);
		System.out.println("account = " + account.toString());
		assertEquals("account should have 'testZip' as account zip ", testZip, account.getZip());
   
	}
	
	@Test
	public void testGetAccountsByCityParameter(){
		System.out.println("test if the account is returned by searching its city...");
		Account account = accountDao.findByParameter("city", testCity).get(0);
		assertNotNull("should not be null", account);
		System.out.println("account = " + account.toString());
		assertEquals("account should have "+ testCity + " as account city ", testCity.toUpperCase(), account.getCity());
	}
	
	@Test
	public void testGetAccountsByMatchAddress(){
		System.out.println("test if the account is returned by searching its address...");
		Account account = accountDao.findByParameterPattern("addressStreeLine1", testAddress, PatternMatchMode.ANYWHERE).get(0);
		assertNotNull("should not be null", account);
		System.out.println("account = " + account.toString());
		assertEquals("account should have "+ testAddress + " as account street address ", testAddress.toUpperCase(), account.getAddressStreeLine1().trim());
	} 
	
//	@Test
	public void testGetActiveAccounts(){
		System.out.println("test if all active accounts are returned...");
		List<Account> accountList = accountDao.getAccountsByActivityStatus("active");
	    System.out.printf("%d, active accounts retrieved", accountList == null? 0 : accountList.size());
	}
	
	//@Test
	public void testGetInactiveAccounts(){
		System.out.println("test if all inactive accounts are returned...");
		List<Account> accountList = accountDao.getAccountsByActivityStatus("inactive");
	    System.out.printf("%d, inactive accounts retrieved", accountList == null? 0 : accountList.size());
	}
	
	//@Test
	public void testGetAllAccounts(){
		System.out.println("test if all accounts are returned...");
		List<Account> accountList = accountDao.getAccountsByActivityStatus("all");
	    System.out.printf("%d, all accounts retrieved", accountList == null? 0 : accountList.size());
	}
		
	/*@Test
	public void testGetAccountWithUsers(){
		System.out.println("test if the account is returned by searching its ID...");
		Account account = accountDao.getAccountById(testAccountId);
		assertNotNull("should not be null", account);
		System.out.println("account = " + account.toString());
		System.out.println("test if the account has all the users");
		Set<User> users = account.getAccountUsers();
		assertEquals(PersistentSet.class, users.getClass());
		System.out.println(users.size());
		assertEquals("account " + testAccountId + " has 0 users ", 0, users.size());
	}
	*/
	
	/*@Test
	public void testGetAccountWithBraches(){
		System.out.println("test if the account has all the branches");
		//Account account = accountDao.findByParameter("addressZip", testZip).get(0);
		//Account account = accountDao.findById(testAccountId);
		Account account = accountDao.findByParameter("accountId", testAccountId).get(0);
		assertNotNull("should not be null", account);
		System.out.println("account = " + account.toString());		
		//Set<AccountBranch> branches = account.getAccountBranches();
		//Set<AccountBranchId> branches = account.getAccountBranches();
		assertEquals(PersistentSet.class, branches.getClass());
		System.out.println(branches.size());
		assertEquals("account " + testZip + " has 3 branch(s) ", 3, branches.size());
	}
	/*
	@Test
	public void testGetAccountWithBracheIds(){
		System.out.println("test if the account has all the branches");
		//Account account = accountDao.findByParameter("addressZip", testZip).get(0);
		//Account account = accountDao.findById(testAccountId);
		Account account = accountDao.findByParameter("accountId", testAccountId).get(0);
		assertNotNull("should not be null", account);
		System.out.println("account = " + account.toString());		
		Set<BranchPK> branches = account.getBrancheIds();
		assertEquals(PersistentSet.class, branches.getClass());
		System.out.println(branches.size());
		assertEquals("account " + testZip + " has 3 branch(s) ", 3, branches.size());
	}
	*/
	@Test
	@Transactional
	//need to run more tests
	public void testUpdateAccount(){
		System.out.println("test update account ...");
		Account account = accountDao.getAccountById(testAccountId);
		System.out.println("An existing account retrieved");
		System.out.println("account = "+ account.toString());
		assertEquals("CA", account.getState());
		System.out.printf("Now, set the state to %s, %s", testState, " And save it to DB...");
        account.setState(testState);
		accountDao.update(account);
		account = accountDao.getAccountById(account.getAccountId());
		System.out.println("Retrieved the upated account");
		System.out.println("account = "+ account.toString());
		assertNotEquals("CA", account.getState());
		
	}

	/*@Test
	@Transactional
	public void testGenerateId(){
		System.out.println("test generate a new id ...");
		long newId = obmhDao.generateId();
        System.out.printf("Got the new id,  %d", newId);		
	    assertNotNull(newId);
	    assertNotEquals(0, newId);
	    System.out.println("Done with test generate a new id.");
	}
	*/
	@Test
	@Transactional
	public void testCreateAccount(){
		System.out.println("test create account ...");
		Account account = new Account();
		//account.setAccountId("bedlogic0001");
		account.setAccountName("TestAccountName");
		account.setActivityStatus("Y");
		account.setAddressStreeLine1(testAddress);
		account.setCity(testCity);
		account.setZip(testZip);
		System.out.println("An new account created in memory");
		System.out.println("account = "+ account.toString());
		System.out.println("Now, save the account.");
       	accountDao.save(account);
       	Account newAccount = accountDao.getAccountById(account.getAccountId());
       	System.out.println("retrieved the saved account  = "+ newAccount.toString());
		//assertNotEquals(testState, account.getAddressState());
		
	}
}
