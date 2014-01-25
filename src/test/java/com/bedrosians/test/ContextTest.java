package com.bedrosians.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.collection.internal.PersistentSet;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;

import com.bedrosians.bedlogic.dao.account.AccountDao;
import com.bedrosians.bedlogic.domain.account.SimplifiedAccount;
import com.bedrosians.bedlogic.domain.account.AccountBranch;
import com.bedrosians.bedlogic.domain.account.AccountPhone;

import com.bedrosians.bedlogic.service.AccountService;
import com.bedrosians.bedlogic.util.PatternMatchMode;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/Bedlogic-test-context.xml")
//@ContextConfiguration(locations = {"classpath*/appContext/bedlogic-context.xml", "classpath*/appContext/bedlogic-persistence.xml"})

public class ContextTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private ApplicationContext appContext;
	
    @Autowired
    private SessionFactory sessionFactory;
	
	@Before
	public void setup(){
	
	}
	
	@Test
	public void testGetCurrentSession(){
		assert sessionFactory.getCurrentSession()==sessionFactory.getCurrentSession();
	}
	
	@Test
	public void testGetAccountDao(){
		System.out.println("test if the account is returned for some search criteria...");
		AccountDao accountDao = (AccountDao)appContext.getBean("accountDao");
		assertNotNull(accountDao);
		//try{
		//assertEquals(AccountDao.class, ((org.springframework.aop.framework.Advised)accountDao).getTargetSource().getTarget());
		//}
		//catch(Exception e){
		//e.printStackTrace();
		//}
	}
	
	@Test
	public void testGetAccountService(){
		System.out.println("test if the account is returned for some search criteria...");
		AccountService accountService = (AccountService)appContext.getBean("accountService");
		assertNotNull(accountService);
		//assertEquals("Account", accountDao.getClass().getName());
	}
	
	
}
