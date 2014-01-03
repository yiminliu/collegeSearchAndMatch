package com.bedrosians.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.collection.internal.PersistentList;
import org.hibernate.collection.internal.PersistentSet;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;

import com.bedrosians.bedlogic.dao.AccountDao;
import com.bedrosians.bedlogic.domain.AccountBranch;
import com.bedrosians.bedlogic.domain.AccountPhone;
import com.bedrosians.bedlogic.domain.Account;
import com.bedrosians.bedlogic.domain.AccountUser;
import com.bedrosians.bedlogic.util.PatternMatchMode;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/Bedlogic-test-context.xml")

public class AccountDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private AccountDao accountDao;

	private static String testAccountId = null;
	private static String testAccountName = null;
	private static String testZip = null;
	private static String testCity = null;
	private static String testAddress = null;
	private static Long testPhoneNo = null;
    private static String testState = null;
	
	@Before
	public void setup(){
		testAccountId = "26818"; //"17884";//
		testAccountName = "STONE AGE TILE";
		testZip = "90640";
		testCity = "anaheim";
		testAddress = "1701 SOUTH STATE COLLEGE";
		testPhoneNo = 7147049293L;
		testState = "NY";
	}
	
	 
	@Test
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
	
	@Test
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
	
	@Test
	public void testGetAccountsByAccountNameParameter(){
		System.out.println("test if the account is returned by searching its parater's name...");
		Account account = accountDao.readByParameter("accountName", testAccountName).get(0);
		assertNotNull("should not be null", account);
		System.out.println("account = " + account.toString());
		assertEquals("account should have 'THE RUG SHOPPE' as account name", testAccountName, account.getAccountName());
	}
	
	@Test
	public void testGetAccountsByZipParameter(){
		System.out.println("test if the account is returned by searching its zip...");
		Account account = accountDao.readByParameter("addressZip", testZip).get(0);
		assertNotNull("should not be null", account);
		System.out.println("account = " + account.toString());
		assertEquals("account should have 'testZip' as account zip ", testZip, account.getAddressZip());
   
	}
	
	@Test
	public void testGetAccountsByCityParameter(){
		System.out.println("test if the account is returned by searching its city...");
		Account account = accountDao.readByParameter("addressCity", testCity).get(0);
		assertNotNull("should not be null", account);
		System.out.println("account = " + account.toString());
		assertEquals("account should have "+ testCity + " as account city ", testCity.toUpperCase(), account.getAddressCity());
	}
	
	@Test
	public void testGetAccountsByMatchAddress(){
		System.out.println("test if the account is returned by searching its address...");
		Account account = accountDao.readByParameterPatternMatch("addressStreeLine1", testAddress, PatternMatchMode.ANYWHERE).get(0);
		assertNotNull("should not be null", account);
		System.out.println("account = " + account.toString());
		assertEquals("account should have "+ testAddress + " as account street address ", testAddress.toUpperCase(), account.getAddressStreeLine1().trim());
	} 
	
	@Test
	public void testGetActiveAccounts(){
		System.out.println("test if all active accounts are returned...");
		List<Account> accountList = accountDao.getAccountsByActivityStatus("active");
	    System.out.printf("%d, active accounts retrieved", accountList == null? 0 : accountList.size());
	}
	
	@Test
	public void testGetInactiveAccounts(){
		System.out.println("test if all inactive accounts are returned...");
		List<Account> accountList = accountDao.getAccountsByActivityStatus("inactive");
	    System.out.printf("%d, inactive accounts retrieved", accountList == null? 0 : accountList.size());
	}
	
	@Test
	public void testGetAllAccounts(){
		System.out.println("test if all accounts are returned...");
		List<Account> accountList = accountDao.getAccountsByActivityStatus("all");
	    System.out.printf("%d, all accounts retrieved", accountList == null? 0 : accountList.size());
	}
		
	@Test
	public void testGetAccountWithPhones(){
		System.out.println("test if the account is returned by searching its ID...");
		//Account account = accountDao.getAccountById(testAccountId);
		Account account = accountDao.readByParameter("addressZip", testZip).get(0);
		assertNotNull("should not be null", account);
		System.out.println("account = " + account.toString());
		System.out.println("test if the account has all the phone numbers");
		Set<AccountPhone> phoneNumbers = account.getAccountPhones();
		assertEquals(PersistentSet.class, phoneNumbers.getClass());
		System.out.println(phoneNumbers.size());
		assertEquals("account " + testAccountId + " has 1 phones ", 1, phoneNumbers.size());
	}
	
	@Test
	public void testGetAccountWithUsers(){
		System.out.println("test if the account is returned by searching its ID...");
		Account account = accountDao.getAccountById(testAccountId);
		assertNotNull("should not be null", account);
		System.out.println("account = " + account.toString());
		System.out.println("test if the account has all the users");
		Set<AccountUser> users = account.getAccountUsers();
		assertEquals(PersistentSet.class, users.getClass());
		System.out.println(users.size());
		assertEquals("account " + testAccountId + " has 1 users ", 1, users.size());
	}
	
	@Test
	public void testGetAccountWithBraches(){
		System.out.println("test if the account has all the branches");
		Account account = accountDao.readByParameter("addressZip", testZip).get(0);
		assertNotNull("should not be null", account);
		System.out.println("account = " + account.toString());		
		Set<AccountBranch> branches = account.getAccountBranches();
		assertEquals(PersistentSet.class, branches.getClass());
		System.out.println(branches.size());
		assertEquals("account " + testZip + " has 1 branch(s) ", 1, branches.size());
	}
	
	@Test
	@Transactional
	//need to run more tests
	public void testUpdateAccount(){
		System.out.println("test update account ...");
		Account account = accountDao.getAccountById(testAccountId);
		System.out.println("An existing account retrieved");
		System.out.println("account = "+ account.toString());
		assertEquals("CA", account.getAddressState());
		System.out.printf("Now, set the state to %s", testState);
        account.setAddressState(testState);
		accountDao.update(account);
		assertNotEquals("CA", account.getAddressState());
		
	}
	
	@Test
	@Transactional
	public void testCreateAccount(){
		System.out.println("test create account ...");
		Account account = new Account();
		account.setAccountId("bedlogictest0001");
		account.setAccountName("TestAccountName");
		account.setActivityStatus("Y");
		account.setAddressStreeLine1(testAddress);
		account.setAddressCity(testCity);
		account.setAddressZip(testZip);
		System.out.println("An new account created in memory");
		System.out.println("account = "+ account.toString());
		System.out.println("Now, save the account.");
       	accountDao.save(account);
       	Account newAccount = accountDao.getAccountById("bedlogictest0001");
       	System.out.println("saved account  = "+ newAccount.toString());
		assertNotEquals(testState, account.getAddressState());
		
	}
}
