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

import com.bedrosians.bedlogic.dao.account.AccountDetailDao;
import com.bedrosians.bedlogic.domain.account.Account;
import com.bedrosians.bedlogic.domain.account.AccountDetail;
import com.bedrosians.bedlogic.domain.account.SimplifiedAccount;
import com.bedrosians.bedlogic.domain.account.AccountBranch;
import com.bedrosians.bedlogic.domain.account.AccountBranchId;
import com.bedrosians.bedlogic.domain.account.BranchPK;
import com.bedrosians.bedlogic.service.AccountService;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/Bedlogic-test-context.xml")
public class AccountServiceTest {
		
	//@Mock
	//AccountDao accountDaoMock;
	
	//@InjectMocks
	//AccountServiceImpl accountService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired 
	AccountDetailDao accountDetailDao;
	
	
	
	private static String testAccountId = null;
	private static String testBranchId = null;
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
		testBranchId = "2";
	}
	
	@Test
	public void testGetAccountById(){
		
		System.out.println("test if the account is returned by searching its ID...");
		Account account = accountService.getAccountById(testAccountId);
		System.out.println("Account = " + account);
		assertNotNull("should not be null", account);
		String name = account.getClass().getName();
		assertEquals("Account id should be " + testAccountId, testAccountId, account.getAccountId());
		//assertEquals("account name for account id = 26818 is STONE AGE TILE", "STONE AGE TILE", account.getAccountName());
		
	}
	
	@Test
	public void testGetAccountDetailById(){
		
		System.out.println("test if the account is returned by searching its ID...");
		Account account = accountService.getAccountById(testAccountId);
		assertNotNull("should not be null", account);
		assertEquals("Account id should be " + testAccountId, testAccountId, account.getAccountId());
		//assertEquals("account name for account id = 26818 is STONE AGE TILE", "STONE AGE TILE", account.getAccountName());
		
	}
	
	/*@Test
	public void testAccountWithPhones(){
		System.out.println("test if the account is returned with its phones...");
		SimplifiedAccount simplifiedAccount = accountService.getAccountById(testAccountId);
		assertNotNull("should not be null", simplifiedAccount);
		
		System.out.println("account = " + simplifiedAccount.toString());
				
		System.out.println("test if the account has with its branches");
		Set<AccountBranchId> branches = simplifiedAccount.getAccountBranches();
		System.out.println(branches.size());
		//assertEquals("account (id=26818) has 3 phones ", 3, phoneNumbers.size());
	}
	
	@Test
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
		
    	//assertEquals("account should have 'THE RUG SHOPPE' as account name", testAccountName, simplifiedAccount.getAccountName());
	}
	
	/*@Test
	public void testGetAccountsByAddress(){
		System.out.println("test if the account is returned by searching its address...");
		SimplifiedAccount simplifiedAccount = accountService.getAccountsByAddress(testAddress).get(0);
		assertNotNull("should not be null", simplifiedAccount);
		
		System.out.println("account = " + simplifiedAccount.toString());
		
 //   	assertEquals("account should have 'THE RUG SHOPPE' as account name", testAddress, account.getAddressStreeLine1());
	}
	
	@Test
	public void testGetAccountsByCity(){
		System.out.println("test if the account is returned by searching its city...");
		SimplifiedAccount simplifiedAccount = accountService.getAccountsByCity(testCity).get(0);
		assertNotNull("should not be null", simplifiedAccount);
		
		System.out.println("account = " + simplifiedAccount.toString());
		
   // 	assertEquals("account should have " + testCity.toUpperCase() + " as account city ", testCity.toUpperCase(), account.getCity());
	}
	
	@Test
	public void testGetAccountsByZip(){
		System.out.println("test if the account is returned by searching its zip...");
		SimplifiedAccount simplifiedAccount = accountService.getAccountsByZip(testZip).get(0);
		assertNotNull("should not be null", simplifiedAccount);
		
		System.out.println("account = " + simplifiedAccount.toString());
		
    	//assertEquals("account should have " + testZip + " as account zip ", testZip, account.getZip());
	}
	*/
	
	@Test
	public void testGetBranchesByBranchId(){
		System.out.println("test if the account branches is returned by searching its ID...");
		AccountBranch branch = accountService.getAccountBranchById(testAccountId, testBranchId);
		System.out.println("account = " + branch.toString());
		assertNotNull("should not be null", branch);
		assertEquals("Account id should be " + testAccountId, testAccountId, branch.getAccountId());
	}
	
	@Test
	public void testGetBranchesByBranchPK(){
		System.out.println("test if the account branches is returned by searching its ID...");
		BranchPK branchPK = new BranchPK(testAccountId, testBranchId);
		AccountBranch branch = accountService.getAccountBranchByBranchPK(branchPK);
		System.out.println("account = " + branch.toString());
		assertNotNull("should not be null", branch);
		assertEquals("Account id should be " + testAccountId, testAccountId, branch.getAccountId());
	}
	
	@Test
	@Transactional
	//need to run more tests
	public void testUpdateAccount(){
		System.out.println("test update account ...");
		AccountDetail account = (AccountDetail)accountService.getAccountById("398477");
		System.out.println("An existing account retrieved");
		System.out.println("account = "+ account.toString());
		//assertEquals("CA", account.getState());
		System.out.printf("Now, set the state to %s, %s", testState, " And save it to DB...");
        account.setAccountName("Test");
		//account.setState("NY");
		account.setCity("ABC");
        accountService.updateAccount(account);
		account = (AccountDetail)accountService.getAccountById(account.getAccountId());
		System.out.println("Retrieved the upated account");
		System.out.println("account = "+ account.toString());
		//assertNotEquals("CA", account.getState());
		
	}
	
	
	@Test
	@Transactional
	public void testCreateAccount(){
		System.out.println("test create account ...");
		AccountDetail account = new AccountDetail();
		//account.setAccountId("bedlogic0001");
		account.setAccountName("TestAccountName");
		account.setActivityStatus("Y");
		account.setCity(testCity);
		account.setState(testState);
		account.setZip(testZip);
		System.out.println("An new account created in memory");
		System.out.println("account = "+ account.toString());
		System.out.println("Now, save the account.");
		//System.out.println("New account ID = " + accountDetailDao.createAccount(account));
		System.out.println("New account ID = " + accountService.createAccount(account));
       //	Account newAccount = accountDao.getAccountById(account.getAccountId());
       	//System.out.println("retrieved the saved account  = "+ newAccount.toString());
		//assertNotEquals(testState, account.getAddressState());
		
	}
	
	
}
