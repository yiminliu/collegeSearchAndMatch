package com.bedrosians.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bedrosians.bedlogic.domain.account.Account;
import com.bedrosians.bedlogic.domain.account.AccountBranch;
import com.bedrosians.bedlogic.domain.account.AccountBranchId;
import com.bedrosians.bedlogic.service.AccountService;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/Bedlogic-test-context.xml")
public class AccountServiceTestSave {
		
	//@Mock
	//AccountDao accountDaoMock;
	
	//@InjectMocks
	//AccountServiceImpl accountService;
	
	@Autowired
	AccountService accountService;
	
	
	
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
	
	
	//@Test
	/*public void testCriteriaSearch(){
		
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(new Account("1", "bigTile", "cash", "Y", "la", "ca", "90001"));
		accounts.add(new Account("2", "smallTile", "cash", "D", "sf", "ca", "91123"));
		
		when(accountDaoMock.getAccounts(
				"tile",
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null)).thenReturn(accounts);
		
		accounts = accountService.getAccounts("tile", null, null, null, null, null, null, null, null, null, null);
		
		System.out.println("accounts retrieved:");
		for(Account account : accounts){
			System.out.println(account.getAccountName());
		}
		
		System.out.println("test if the returned data is the same as the input from lower level...");
		assertEquals("two account should be returned with the given criteria", 2, accounts.size());
	}
	*/
	@Test
	public void testGetAccountById(){
		
		System.out.println("test if the account is returned by searching its ID...");
		Account account = accountService.getAccountById(testAccountId);
		assertNotNull("should not be null", account);
		assertEquals("Account id should be " + testAccountId, testAccountId, account.getAccountId());
		assertEquals("account name for account id = 26818 is STONE AGE TILE", "STONE AGE TILE", account.getAccountName());
		
	}
	
	@Test
	public void testAccountWithPhones(){
		System.out.println("test if the account is returned with its phones...");
		Account account = accountService.getAccountById(testAccountId);
		assertNotNull("should not be null", account);
		
		System.out.println("account = " + account.toString());
				
		System.out.println("test if the account has with its branches");
		Set<AccountBranchId> branches = account.getAccountBranches();
		System.out.println(branches.size());
		//assertEquals("account (id=26818) has 3 phones ", 3, phoneNumbers.size());
	}
	
	/*@Test
	public void testAccountWithBranches(){
		System.out.println("test if the account is returned by searching its ID...");
		Account account = accountService.getAccountById(testAccountId);
		assertNotNull("should not be null", account);
		
		System.out.println("account = " + account.toString());
				
		System.out.println("test if the account has all the phone numbers");
		Set<AccountPhone> phoneNumbers = account.getAccountPhones();
		System.out.println(phoneNumbers.size());
		//assertEquals("account (id=26818) has 3 phones ", 3, phoneNumbers.size());
	}
	*/
	
	//@Test
	public void testGetAccountsByActivityStatus(){
		System.out.println("test if the account is returned by searching its status...");
		Account account = accountService.getAccountsByActivityStatus("inactive").get(0);
		assertNotNull("should not be null", account);
		
		System.out.println("account = " + account.toString());
				
		System.out.println("test if the account is returned");
    	//assertEquals("account should have inactive status ", "D", account.getActivityStatus());
	}
	
	@Test
	public void testGetAccountsByAccountNamePatern(){
		System.out.println("test if the account is returned by searching its parater's name...");
		Account account = accountService.getAccountsByAccountNamePattern(testAccountName).get(0);
		assertNotNull("should not be null", account);
		
		System.out.println("account = " + account.toString());
		
    	assertEquals("account should have 'THE RUG SHOPPE' as account name", testAccountName, account.getAccountName());
	}
	
	@Test
	public void testGetAccountsByAddress(){
		System.out.println("test if the account is returned by searching its address...");
		Account account = accountService.getAccountsByAddress(testAddress).get(0);
		assertNotNull("should not be null", account);
		
		System.out.println("account = " + account.toString());
		
    	assertEquals("account should have 'THE RUG SHOPPE' as account name", testAddress, account.getAddressStreeLine1());
	}
	
	@Test
	public void testGetAccountsByCity(){
		System.out.println("test if the account is returned by searching its city...");
		Account account = accountService.getAccountsByCity(testCity).get(0);
		assertNotNull("should not be null", account);
		
		System.out.println("account = " + account.toString());
		
    	assertEquals("account should have " + testCity.toUpperCase() + " as account city ", testCity.toUpperCase(), account.getCity());
	}
	
	@Test
	public void testGetAccountsByZip(){
		System.out.println("test if the account is returned by searching its zip...");
		Account account = accountService.getAccountsByZip(testZip).get(0);
		assertNotNull("should not be null", account);
		
		System.out.println("account = " + account.toString());
		
    	assertEquals("account should have " + testZip + " as account zip ", testZip, account.getZip());
	}
	
	
	//@Test
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
       	accountService.createAccount(account);
       	Account newAccount = accountService.getAccountById(account.getAccountId());
       	System.out.println("retrieved the saved account  = "+ newAccount.toString());
		//assertNotEquals(testState, account.getAddressState());
		
	}
}
