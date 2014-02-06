package com.bedrosians.test;

import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import com.bedrosians.bedlogic.domain.account.AccountDetail;
import com.bedrosians.bedlogic.domain.account.SimplifiedAccount;
//import com.jayway.jsonpath.spi.impl.JacksonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;



public class JerseyRestfulTestClient {
	
	  private static final String mediaTypeJson = MediaType.APPLICATION_JSON;
	  private static final String rootPath = "bedlogic";
	  private static final String appPath = "accounts";
	  
	  private static final String testAccountId = "26818";
	  
	  private static WebResource service =null;
	  private static Client client = null;
	  
	  public static void main(String[] args) {
	    init();
	    
	    // Fluent interfaces
	   // System.out.println(service.path(rootPath).path(appPath).accept(mediaTypeJson).get(ClientResponse.class).toString());
	   //testGetAccountById(testAccountId);
	    testUpdateAccount();
	    
	    //testGetAccounts();
	    // System.out.println(service.path(rootPath).path(appPath).accept(mediaTypeJson).get(String.class));
	    // Get account by id
	   // System.out.println(service.path(rootPath).path(appPath).accept(mediaTypeJson).get(ClientResponse.class, testAccountId);
	    
	  }
	  
	  private static void init(){
		  ClientConfig config = new DefaultClientConfig();
		  //config.getClasses().add(JacksonJsonProvider.class);
		  client = Client.create(config);
	  }
	  
	  private static void setMediaType(){
		  service.accept(mediaTypeJson);
	  }
	  private static void testGetAccounts(){
		  service.method("GET");
		  ClientResponse response = service.get(ClientResponse.class);
		  
		  int status = response.getStatus();
		  System.out.println("Response's status : "+ status);
		  
		  Map map = response.getProperties();
		  System.out.println("properties:" +map.size());
		  Set set = map.entrySet();
		  
		  Iterator it =  set.iterator();
		  while (it.hasNext()){
			  System.out.println("properties:");
		  Entry<String, List<String>> entry = (Entry<String, List<String>>)it.next();
 		   String	key = (String)entry.getKey();
 	     String	value = ((List<String>)entry.getValue()).get(0);//.toString();
 	    	//if(value != null && value.length() > 0)
		    //   value = value.toUpperCase();
 	    	System.out.printf(" key = %s, value = %s", key, value);
 	    	System.out.println();
 	    			  }
		 
		  String account = response.getEntity(String.class);
		  System.out.println("Output = " + account.toString());
	  }
	  
	  private static void testGetAccountById(String accountId){
		  service = client.resource(getTestBaseURI());  
		  //service.path(rootPath).path(appPath).accept(mediaTypeJson);
		  //service.path("accountId/" + accountId);
		  //setMediaType();
		 		  
		  service.accept(mediaTypeJson);
		  service.type(mediaTypeJson);
		  
		  System.out.println("Resource URL = " + service.getURI().toASCIIString());
		 		    
		  service.method("GET");
		  ClientResponse response = service.get(ClientResponse.class);
		  int status = response.getStatus();
		  System.out.println("Response status : "+ status);
		 	  		  
		  SimplifiedAccount simplifiedAccount = response.getEntity(SimplifiedAccount.class);
		  System.out.println("Output = " + simplifiedAccount.toString());
		  
	  }
	  
	  private static void testUpdateAccount(){
		 		  
		  service = client.resource(getTestBaseURI());  
		  //service.path(rootPath).path(appPath).accept(mediaTypeJson);
		  //service.path("accountId/" + accountId);
		  //setMediaType();
		  service = client.resource(UriBuilder.fromUri("http://localhost:8080/" + rootPath + "/" + appPath).build());		  
		  service.accept(mediaTypeJson);
		  service.type(mediaTypeJson);
		 
		  //String input = "{\"accountId\":\"398477\", \"state\":\"NC\", \"city\":\"Test\",\"companyName\":\"Test dba\"}";
		  String input = "{'accountId':'398477', 'state':'NC','city':'Test','companyName':'Test dba'}";

		  
		  AccountDetail account = new AccountDetail();
		  account.setAccountId("26818");
		  account.setAccountManager("Test");
		  
		// JSONObject post = baseResource.path("login")
			 //           .queryParam("service", "ABC").queryParam("auth", authParam)
			 //           .accept(MediaType.APPLICATION_JSON_TYPE).post(JSONObject.class);
		  
		  
		  System.out.println("Resource URL = " + service.getURI().toASCIIString());
		 		    
		  service.method("PUT");
		  ClientResponse response = service.put(ClientResponse.class, account);
		  int status = response.getStatus();
		  System.out.println("Response status : "+ status);
		 	  		  
		  //Account account = response.getEntity(Account.class);
		  System.out.println("Output = " + account.toString());
		  
	  }
	  

	  private static URI getTestBaseURI() {
	    return UriBuilder.fromUri("http://localhost:8080/" + rootPath + "/" + appPath + "/" + testAccountId).build();
		//  return UriBuilder.fromUri("http://localhost:8080/" + rootPath).build();
	  }
	  
	  private static URI getByIdTestURI(String id) {
		    return UriBuilder.fromUri("http://localhost:8080/" + rootPath + "/" + appPath + "/" + testAccountId).build();
			//  return UriBuilder.fromUri("http://localhost:8080/" + rootPath).build();
		  }
	  
	  private static URI getTestURI(String query) {
		    return UriBuilder.fromUri("http://localhost:8080/" + rootPath + "/" + appPath + "/" + testAccountId).build();
			//  return UriBuilder.fromUri("http://localhost:8080/" + rootPath).build();
		  }
	  
	  private static URI getTestService() {
		    return UriBuilder.fromUri("http://localhost:8080/" + rootPath + "/" + appPath + "/accountId/" + testAccountId).build();
		  //  return UriBuilder.fromUri("http://localhost:8080/" + rootPath).build();
		  }
	  
	  //private static WebResource getTestBaseURI2() {
	//	    return UriBuilder.fromUri("http://localhost:8080/" + rootPath + "/" + appPath + "/accountId/" + testAccountId).build().accept(mediaTypeJson);
		//  }
	  
	  private static URI getProdBaseURI() {
	    return UriBuilder.fromUri("http://localhost:8080/" + appPath).build();
	  }

	} 
