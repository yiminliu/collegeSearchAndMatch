package com.bedrosians.test.account;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AccountDaoTest.class, 
	            AccountServiceTest.class 
	            //RestfulWebServiceControllerTest.class, 
	            //IntegrationTest.class 
	         })
public class AllTests {

}
