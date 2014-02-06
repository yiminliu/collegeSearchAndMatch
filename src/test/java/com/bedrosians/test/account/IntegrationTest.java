package com.bedrosians.test.account;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "/IntegrationTest-context.xml")
@Transactional
public class IntegrationTest {

	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	//@Test
	public void testGetSimpleAccountsByName() throws Exception {
		this.mockMvc.perform(get("/accounts")
				.accept(MediaType.parseMediaType("application/json"))
				.param("accountName", "WEST CAL TILE & MARBLE")
				.param("activityStatus", "all"))
		.andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(jsonPath("$[0].accountName").value("WEST CAL TILE & MARBLE"));
	}
	
	//@Test
	public void testGetSimpleAccountsByPhoneNo() throws Exception {
		this.mockMvc.perform(get("/accounts")
				.accept(MediaType.parseMediaType("application/json"))
				.param("phoneNo", "7147049293")
				.param("activityStatus", "all"))
		.andDo(print())
        //.andExpect(status().isOk())
         .andExpect(status().isAccepted())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(jsonPath("$[0].accountName").value("STONE AGE TILE"));
	}

	//@Test
	public void testGetAccountById() throws Exception {
		this.mockMvc.perform(get("/accounts/26818")
				.accept(MediaType.parseMediaType("application/json")))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.accountName").value("STONE AGE TILE"));
	}
	
	//@Test
	public void testNonExistingAccount() throws Exception {
		this.mockMvc.perform(get("/accounts/26846")
				.accept(MediaType.parseMediaType("application/json")))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$").doesNotExist());
				
	}
	
	@Test
	public void testNonExistingAccount1() {}
}
