package com.bedrosians.bedlogic.webservice;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bedrosians.bedlogic.domain.account.Account;
import com.bedrosians.bedlogic.domain.account.AccountBranch;
import com.bedrosians.bedlogic.domain.account.AccountDetail;
import com.bedrosians.bedlogic.exeception.DataNotFoundException;
import com.bedrosians.bedlogic.service.AccountService;
import com.bedrosians.bedlogic.util.JsonUtil;
import com.bedrosians.bedlogic.util.logger.aspect.LogLevel;
import com.bedrosians.bedlogic.util.logger.aspect.Loggable;
import com.sun.jersey.core.util.MultivaluedMapImpl;



/**
 * This is a restful web service resource class. It acts as the logical resource of Account Service to provide CRUD operations on accounts and branches.
 * This web service resource is used via HTTP request method (GET, POST, PUT, DELETE). JSON is the only format supported for message exchange by this resource.
 * This class uses "/accounts" as its endpoint. Account branches are logically mapped to the "/accounts" endpoint.
 *
 */

@Component
@Path("/accounts")
//@Scope("prototype")
public class AccountRestService {

	@Autowired
    AccountService accountService;
				
	/**
	   * This method retrieves an account for the given account id.
	   * @param  accountId   account id string. 
	   * @return Response    object to include the status and a json object.
	   * @exception WebApplicationException on input error and server side condition errors as well.
	   * @see WebApplicationException
	   */
    @GET
    @Path("{accountId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable(value = LogLevel.TRACE)
	public Response getAccountById(@PathParam("accountId") final String accountId) throws WebApplicationException{
		if (accountId == null || accountId.length() == 0) {
    	    throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity("A valid account Id is required").build());
    	}   		
		try {
			Account account = accountService.getAccountById(accountId);
			if (account == null)
				return Response.status(Response.Status.NOT_FOUND).build();
			else
		       return Response.status(Response.Status.OK).entity(JsonUtil.toJson(account)).build();
		}
		catch(Exception e){
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}
        
    
    /**
	   * This method retrieves a list of accounts for the given query condition, or a list of all accounts if no query condition is specified .
	   * @param  UriInfo     represents query condition in the form of name/value pairs. If no query is specified, the all accounts will be returned.
	   * @return Response    object contains the status and a json object.
	   * @exception WebApplicationException on input error and server side condition errors as well.
	   * @see WebApplicationException
	   */
    @GET
  	//@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable(value = LogLevel.TRACE)
  	public Response getAccounts(@Context UriInfo uriInfo) throws WebApplicationException{
    	MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
    	List<Account> accounts = null;
    	if(queryParams == null || queryParams.isEmpty()) {
    		//throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity("Please specify your query.").build());	
    		//queryParams = new MultivaluedMapImpl();
	        //queryParams.add("activityStatus", "all");
    		accounts = (List<Account>)accountService.getAllAccounts();
    	}
    	else {
    		
    	   	try{
    	    	 accounts = (List<Account>)accountService.getByQueryParameters(queryParams);
		   	}
    	    catch(Exception e){
			     throw new WebApplicationException(Response.Status.NOT_FOUND);
		    }
    	}
    	 if (accounts == null || accounts.size() <= 0)
		        return Response.status(Response.Status.NOT_FOUND).build();				
		 else
		        return Response.status(Response.Status.OK).entity(JsonUtil.toJson(accounts)).build();
   }
    
    /**
	   * This method retrieves a list of accounts for the given query condition, or a list of all accounts if no query condition is specified .
	   * @param accountName   a string of account name. 
	   * @return Response     object to include the status and a json object.
	   * @exception WebApplicationException on input error and server side condition errors as well.
	   * @see WebApplicationException
	   */
    @GET
    @Path("accountName/{accountName}")
	@Produces(MediaType.APPLICATION_JSON)
    @Loggable(value = LogLevel.DEBUG)
	public Response getAccountsByAccountNamePattern(@PathParam("accountName") String accountName) {
    	if(accountName == null || accountName.length() < 1) {
    		throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity("Please specify your parameter.").build());	
    	}
    	try{
    	    List<Account> accounts = (List<Account>)accountService.getAccountsByAccountNamePattern(accountName);
		    if (accounts == null || accounts.size() <= 0)
		        return Response.status(Response.Status.NOT_FOUND).build();				
		    else
		        return Response.status(Response.Status.OK).entity(JsonUtil.toJson(accounts)).build();
		}
		catch(Exception e){
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
    }
    
   
    /**
	   * This method retrieves an account branch for the given account id and branch id.
	   * @param accountId   account id. 
	   * @param accountId   branch id. 
	   * @return Response     object to include the status and a json object.
	   * @exception WebApplicationException on input error and server side condition errors as well.
	   * @see WebApplicationException
	   */
    @GET
    @Path("{accountId}/{branchId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable(value = LogLevel.TRACE)
	public Response getAccountBranchById(@PathParam("accountId") String accountId, @PathParam("branchId") String branchId) throws WebApplicationException{
		if (accountId == null || accountId.length() == 0 || branchId == null || branchId.length() == 0) {
    	    throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity("Valid account Id and Branch Id are required").build());
    	}    
		try {
    	    AccountBranch accountBranch = accountService.getAccountBranchById(accountId, branchId);
		    if (accountBranch == null)
				return Response.status(Response.Status.NOT_FOUND).build();
		    else
		    	return Response.status(Response.Status.OK).entity(JsonUtil.toJson(accountBranch)).build();
		}
		catch(Exception e){
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}
    
    /**
	   * This method retrieves a list of account branches associated with the given account.
	   * @param accountId   account id. 
	   * @return Response   object to include the status and a json object.
	   * @exception WebApplicationException on input error and server side condition errors as well.
	   * @see WebApplicationException
	   */
    @GET
    @Path("{accountId}/branches")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable(value = LogLevel.TRACE)
	public Response getAccountBranches(@PathParam("accountId") String accountId) throws WebApplicationException{
		if (accountId == null || accountId.length() == 0) {
    	    throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity("Valid account Id is required").build());
    	}    
		try {
    	    List<AccountBranch> accountBranches = (List<AccountBranch>)accountService.getAccountBranches(accountId);
		    if (accountBranches == null || accountBranches.size() <= 0 )
				return Response.status(Response.Status.NOT_FOUND).build();
		    else
		    	return Response.status(Response.Status.OK).entity(JsonUtil.toJson(accountBranches)).build();
		}
		catch(Exception e){
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}
    
    @PUT
    @Path("{accountId}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response updateAccount(@PathParam("accountId") final String accountId, final AccountDetail account) throws Exception{
        try{
			accountService.updateAccount(accountId, account);
		}
        catch(DataNotFoundException dnfe){
        	throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
		return Response.status(Response.Status.NO_CONTENT).entity(JsonUtil.toJson(accountId)).build();
	}
    
    
    /**
	   * This method updates an account based on the given account info.
	   * @param accountId   account object. 
	   * @return Response   object to include the status and a json object representing the updated account.
	   * @exception WebApplicationException on input error and server side condition errors as well.
	   * @see WebApplicationException
	   */
    @Loggable(value=LogLevel.TRACE)
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response updateAccount(AccountDetail account) throws Exception{
		if (account == null){
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		System.out.println("In updateAccount, input account: "+ account.toString());
		try {
		    accountService.updateAccount(account);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
		return Response.status(Response.Status.NO_CONTENT).entity(JsonUtil.toJson(account)).build();
	}
    	
    /**
	   * This method creates an account based on the given account info.
	   * @param accountId   account object. 
	   * @return Response   object to include the status and a json object representing the updated account.
	   * @exception WebApplicationException on input error and server side condition errors as well.
	   * @see WebApplicationException
	   */
    @Loggable(value=LogLevel.TRACE)
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response createAccount(AccountDetail account){
		
		if (account == null){
			throw new WebApplicationException(Response.Status.NOT_FOUND);
	 	}
		try {
			accountService.createAccount(account);
		}
		catch(Exception e){
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
		
		return Response.status(Response.Status.NO_CONTENT).entity(JsonUtil.toJson(account)).build();
	}		    
      
    
    /*
    @GET
	@Path("/query")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAccounts(
			@QueryParam("accountName") String accountName,
			@QueryParam("addressStreetLine1") String addressStreetLine1,
			@QueryParam("addressCity") String addressCity,
			@QueryParam("addressState") String addressState,
			@QueryParam("addressZip") String addressZip,
			@QueryParam("caseNo") String caseNo,
			@QueryParam("ownerFirstName") String ownerFirstName,
			@QueryParam("ownerLastName") String ownerLastName,
			@QueryParam("ownerDriverLicenseNo") String ownerDriverLicenseNo,
			@QueryParam("phoneNo") String phoneNo,
			@DefaultValue("ctive") @QueryParam("activityStatus") String activityStatus ) throws Exception {
		
		
    	List<Account> accounts = null;
		accounts = accountService.getAccounts(
				accountName,
				addressStreetLine1,
				addressCity,
				addressState,
				addressZip,
				caseNo,
				ownerFirstName,
				ownerLastName,
				ownerDriverLicenseNo,
				phoneNo,
				activityStatus);
			
		    //if (accounts.size() == 0){
			//	 return Response.status(Response.Status.NOT_FOUND).entity("Data not found for account id: ").build();				
			//}
		
			return Response.status(Response.Status.OK).entity(JsonUtil.toJson(accounts)).build();
		
	}
    
    /*
    @GET
	@Produces(MediaType.APPLICATION_JSON)
    public Response getAccounts(
			@RequestParam(value="accountName", required=false) String accountName,
			@RequestParam(value="addressStreetLine1", required=false) String addressStreetLine1,
			@RequestParam(value="addressCity", required=false) String addressCity,
			@RequestParam(value="addressState", required=false) String addressState,
			@RequestParam(value="addressZip", required=false) String addressZip,
			@RequestParam(value="caseNo", required=false) String caseNo,
			@RequestParam(value="ownerFirstName", required=false) String ownerFirstName,
			@RequestParam(value="ownerLastName", required=false) String ownerLastName,
			@RequestParam(value="ownerDriverLicenseNo", required=false) String ownerDriverLicenseNo,
			@RequestParam(value="phoneNo", required=false) String phoneNo,
			@RequestParam(value="activityStatus", required=true) String activityStatus, 
			HttpServletRequest request) throws Exception {
	
    	List<Account> accounts = null;
    	
		if (activityStatus.equals("all") || activityStatus.equals("active") || activityStatus.equals("inactive")){

			accounts = accountService.getAccounts(
				accountName,
				addressStreetLine1,
				addressCity,
				addressState,
				addressZip,
				caseNo,
				ownerFirstName,
				ownerLastName,
				ownerDriverLicenseNo,
				phoneNo,
				activityStatus);
			if (accounts.size() == 0){
				 return Response.status(Response.Status.NOT_FOUND).entity("Data not found for account id: ").build();				
				
			}
					
		}
		else{
			throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
	    	        .entity("Account Id and Branch Id parameters are required")
	    	        .build());
		}	
			//throw new Exception("Valid values for parameter 'activityStatus' are all, active, or inactive");
			return Response.status(Response.Status.OK).entity(JsonUtil.toJson(accounts)).build();
		
	}
    */
   	
    
	
	
/*	@PUT
	@Consumes("application/json")
	public ResponseEntity updateAccount(@RequestBody Account account){
		
		 try {
             accountService.updateAccount(account);
         } catch(Exception e) {
             e.printStackTrace();
             throw new RuntimeException(e);
         }
         return new ResponseEntity(HttpStatus.OK);
	}
	*/

	/*
	@ExceptionHandler(DataNotFoundException.class)
	@ResponseBody
	public List<Object> handleDataNotFoundException(){
		return new ArrayList<Object>(0);
	}
	
	@ExceptionHandler(ServletRequestBindingException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public Map<String, Object> handleIServletRequestBindingException(ServletRequestBindingException ex){
		String[] messages = {ex.getMessage()};
		return this.composeJsonErrorMap(messages);
	}
	
	@ExceptionHandler(TransactionException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public Map<String, Object> handleTransactionException(){
		String[] messages = {"Database is busy or unavailable"};
		return this.composeJsonErrorMap(messages);
	}
	
	@ExceptionHandler(DataAccessException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public Map<String, Object> handleDataAccessException(){
		String[] messages = {"Database access error"};
		return this.composeJsonErrorMap(messages);
	}
	
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public Map<String, Object> handleRuntimeException(RuntimeException ex){
		ex.printStackTrace();
		String[] messages = {"Internal server error"};
		return this.composeJsonErrorMap(messages);
	}
		
	private Map<String, Object> composeJsonErrorMap(String[] messages){
		Map<String, Object> map = new HashMap<String, Object>();
		List<RestError> restErrors = new LinkedList<RestError>();
		for (String msg : messages){
			System.out.println("error: " + msg);
			restErrors.add(new RestError(msg));
		}
		map.put("errors", restErrors);
		return map;
	}*/
}
