package com.bedrosians.test;

import static org.junit.Assert.*;

import java.net.ConnectException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/Bedlogic-test-context.xml")

public class AccountDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private AccountDao accountDao;

	private static String testAccountId = null;
	private static String testAccountName = null;
	private static String testZip = null;
	private static String testCity = null;
	
	
	
	@Before
	public void setup(){
		testAccountId = "17884";//"26818";
		testAccountName = "STONE AGE TILE";
		testZip = "90640";
		testCity = "anaheim";
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
	public void testGetActiveAccounts(){
		System.out.println("test if the account is returned for some search criteria...");
		
		List<Account> accountList = accountDao.getAccountsByParameter("activityStatus", "Y");
			
		//assertEquals("Only one account should be returned with given criteria", 1, simpleAccountList.size());
	}
	
	@Test
	public void testGetAccountById(){
		System.out.println("test if the account is returned by searching its ID...");
		Account account = accountDao.getAccountById(testAccountId);
		assertNotNull("should not be null", account);
		assertEquals("Account id should be " + testAccountId, testAccountId, account.getAccountId());
	}
			
	@Test
	public void testGetAccountsByActivityStatus(){
		System.out.println("test if the account is returned by searching its status...");
		Account account = accountDao.getAccountsByActivityStatus("inactive").get(0);
		assertNotNull("should not be null", account);
		
		System.out.println("account = " + account.toString());
				
		System.out.println("test if the account has all the phone numbers");
    	assertEquals("account should have inactive status ", "D", account.getActivityStatus());
	}
	
	@Test
	public void testGetAccountsByAccountNameParameter(){
		System.out.println("test if the account is returned by searching its parater's name...");
		Account account = accountDao.getAccountsByParameter("accountName", testAccountName).get(0);
		assertNotNull("should not be null", account);
		
		System.out.println("account = " + account.toString());
		
    	assertEquals("account should have 'THE RUG SHOPPE' as account name", testAccountName, account.getAccountName());
	}
	
	@Test
	public void testGetAccountsByZipParameter(){
		System.out.println("test if the account is returned by searching its zip...");
		Account account = accountDao.getAccountsByParameter("addressZip", testZip).get(0);
		assertNotNull("should not be null", account);
		
		System.out.println("account = " + account.toString());
		
    	assertEquals("account should have 'testZip' as account zip ", testZip, account.getAddressZip());
   
	}
	
	@Test
	public void testGetAccountsByCityParameter(){
		System.out.println("test if the account is returned by searching its zip...");
		Account account = accountDao.getAccountsByParameter("addressCity", testCity).get(0);
		assertNotNull("should not be null", account);
		
		System.out.println("account = " + account.toString());
		
    	assertEquals("account should have "+ testCity + " as account city ", testCity.toUpperCase(), account.getAddressCity());
   
	}
	
	@Test
	public void testAccountPhones(){
		System.out.println("test if the account is returned by searching its ID...");
		//Account account = accountDao.getAccountById(testAccountId);
		Account account = accountDao.getAccountsByParameter("addressZip", testZip).get(0);
		
		assertNotNull("should not be null", account);
		
		//System.out.println("account = " + account.toString());
				
		System.out.println("test if the account has all the phone numbers");
		Set<AccountPhone> phoneNumbers = account.getAccountPhones();
		assertEquals(PersistentSet.class, phoneNumbers.getClass());
		System.out.println(phoneNumbers.size());
		assertEquals("account " + testAccountId + " has 1 phones ", 1, phoneNumbers.size());
	}
	
	//@Test
	public void testAccountUsers(){
		System.out.println("test if the account is returned by searching its ID...");
		Account account = accountDao.getAccountById(testAccountId);
		//Account account = accountDao.getAccountsByParameter("addressZip", testZip).get(0);
		
		assertNotNull("should not be null", account);
		
		//System.out.println("account = " + account.toString());
				
		System.out.println("test if the account has all the users");
		Set<AccountUser> users = account.getAccountUsers();
		assertEquals(PersistentSet.class, users.getClass());
		System.out.println(users.size());
		assertEquals("account " + testAccountId + " has 1 users ", 1, users.size());
	}
	
	@Test
	public void testAccountBraches(){
		System.out.println("test if the account is returned by searching its ID...");
		//Account account = accountDao.getAccountById(testAccountId);
		Account account = accountDao.getAccountsByParameter("addressZip", testZip).get(0);
		
		assertNotNull("should not be null", account);
		
		System.out.println("account = " + account.toString());
				
		System.out.println("test if the account has all the branches");
		Set<AccountBranch> branches = account.getAccountBranches();
		assertEquals(PersistentSet.class, branches.getClass());
		System.out.println(branches.size());
		assertEquals("account " + testZip + " has 1 branch(s) ", 1, branches.size());
	}
}
