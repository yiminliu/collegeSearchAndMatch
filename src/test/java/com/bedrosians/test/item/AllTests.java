package com.bedrosians.test.item;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ItemDaoTest.class, 
	            ItemServiceTest.class 
	            //RestfulWebServiceControllerTest.class, 
	            //IntegrationTest.class 
	         })
public class AllTests {

}
