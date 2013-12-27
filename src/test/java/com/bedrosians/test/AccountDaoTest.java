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
import org.junit.Test;

import com.bedrosians.bedlogic.dao.AccountDao;
import com.bedrosians.bedlogic.domain.FullAccount;
import com.bedrosians.bedlogic.domain.AccountPhone;
import com.bedrosians.bedlogic.domain.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/AccountDaoTest-context.xml")

public class AccountDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private AccountDao accountDao;
	
	@Test
	public void testGetAccounts(){
		System.out.println("test if the account is returned for some search criteria...");
		
		List<Account> simpleAccountList = accountDao.getAccounts(
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
	public void testRead(){
		System.out.println("test if the account is returned by searching its ID...");
		Account account = accountDao.read("26818     ");
		assertNotNull("should not be null", account);
		assertEquals("account name for account id = 26818 is STONE AGE TILE", "STONE AGE TILE", account.getAccountName());

		System.out.println("test if the account has all the phone numbers");
		Set<AccountPhone> phoneNumbers = account.getPhoneNumbers();
		System.out.println(phoneNumbers.size());
		assertEquals("account (id=26818) has 3 phones ", 3, phoneNumbers.size());
	}
}
