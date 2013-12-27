package com.bedrosians.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import com.bedrosians.bedlogic.dao.AccountDao;
import com.bedrosians.bedlogic.domain.Account;
import com.bedrosians.bedlogic.service.AccountServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {
	
	@Mock
	AccountDao accountDaoMock;
	
	@InjectMocks
	AccountServiceImpl accountService;
	
	@Test
	public void testCriteriaSearch(){
		
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
	
	@Test
	public void testGetActiveAccounts() {

		List<Account> accounts = new ArrayList<Account>();
		
		accounts = accountService.getActiveAccounts();
		
	}
}
