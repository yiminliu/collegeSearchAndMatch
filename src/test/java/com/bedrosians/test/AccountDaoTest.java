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
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;

import com.bedrosians.bedlogic.dao.AccountDao;
import com.bedrosians.bedlogic.domain.AccountPhone;
import com.bedrosians.bedlogic.domain.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/Bedlogic-test-context.xml")

public class AccountDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private AccountDao accountDao;

	private static String testAccountId = null;
	private static String testAccountName = null;
	
	
	@Before
	public void setup(){
		testAccountId = "26818";
		testAccountName = "STONE AGE TILE";
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
		assertEquals("account name for account id = 26818 is STONE AGE TILE", "STONE AGE TILE", account.getAccountName());
		
	}
	
	//@Test
	public void testAccountPhones(){
		System.out.println("test if the account is returned by searching its ID...");
		Account account = accountDao.getAccountById(testAccountId);
		assertNotNull("should not be null", account);
		
		System.out.println("account = " + account.toString());
				
		System.out.println("test if the account has all the phone numbers");
		Set<AccountPhone> phoneNumbers = account.getPhoneNumbers();
		System.out.println(phoneNumbers.size());
		assertEquals("account (id=26818) has 3 phones ", 3, phoneNumbers.size());
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
	public void testGetAccountsByParameter(){
		System.out.println("test if the account is returned by searching its parater's name...");
		Account account = accountDao.getAccountsByParameter("accountName", testAccountName).get(0);
		assertNotNull("should not be null", account);
		
		System.out.println("account = " + account.toString());
		
    	assertEquals("account should have 'THE RUG SHOPPE' as account name", testAccountName, account.getAccountName());
	}
}
