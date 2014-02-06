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

import com.bedrosians.bedlogic.domain.item.Item;
import com.bedrosians.bedlogic.domain.item.ItemDetail;
import com.bedrosians.bedlogic.exeception.DataNotFoundException;
import com.bedrosians.bedlogic.service.ItemService;
import com.bedrosians.bedlogic.util.JsonUtil;
import com.bedrosians.bedlogic.util.logger.aspect.LogLevel;
import com.bedrosians.bedlogic.util.logger.aspect.Loggable;
import com.sun.jersey.core.util.MultivaluedMapImpl;



/**
 * This is a restful web service resource class. It acts as the logical resource of Item Service to provide CRUD operations on items and branches.
 * This web service resource is used via HTTP request method (GET, POST, PUT, DELETE). JSON is the only format supported for message exchange by this resource.
 * This class uses "/items" as its endpoint. Item branches are logically mapped to the "/items" endpoint.
 *
 */

@Component
@Path("/items")
//@Scope("prototype")
public class ItemRestService {

	@Autowired
    ItemService itemService;
				
	/**
	   * This method retrieves an item for the given item id.
	   * @param  itemId   item id string. 
	   * @return Response    object to include the status and a json object.
	   * @exception WebApplicationException on input error and server side condition errors as well.
	   * @see WebApplicationException
	   */
    @GET
    @Path("{itemId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable(value = LogLevel.TRACE)
	public Response getItemById(@PathParam("itemId") final String itemId) throws WebApplicationException{
		if (itemId == null || itemId.length() == 0) {
    	    throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity("A valid item Id is required").build());
    	}   		
		try {
			Item item = itemService.getItemById(itemId);
			if (item == null)
				return Response.status(Response.Status.NOT_FOUND).build();
			else
		       return Response.status(Response.Status.OK).entity(JsonUtil.toJson(item)).build();
		}
		catch(Exception e){
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}
        
    
    /**
	   * This method retrieves a list of items for the given query condition, or a list of all items if no query condition is specified .
	   * @param  UriInfo     represents query condition in the form of name/value pairs. 
	   * @return Response    object to include the status and a json object.
	   * @exception WebApplicationException on input error and server side condition errors as well.
	   * @see WebApplicationException
	   */
    @GET
  	//@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Loggable(value = LogLevel.TRACE)
  	public Response getItems(@Context UriInfo uriInfo) throws WebApplicationException{
    	MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
    	List<Item> items = null;
    	if(queryParams == null || queryParams.isEmpty()) {
    	   items = (List<Item>)itemService.getItems();
    	}
    	try{
    		items = (List<Item>)itemService.getByQueryParameters(queryParams);
		}
		catch(Exception e){
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
    	 if (items == null || items.size() <= 0)
	         return Response.status(Response.Status.NOT_FOUND).build();				
         else
	         return Response.status(Response.Status.OK).entity(JsonUtil.toJson(items)).build();
    }
   
   
    /**
	   * This method retrieves an item branch for the given item id and branch id.
	   * @param itemId   item id. 
	   * @param itemId   branch id. 
	   * @return Response     object to include the status and a json object.
	   * @exception WebApplicationException on input error and server side condition errors as well.
	   * @see WebApplicationException
	   */
       
    @PUT
    @Path("{itemId}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response updateItem(@PathParam("itemId") final String itemId, final ItemDetail item) throws Exception{
        try{
			itemService.updateItem(itemId, item);
		}
        catch(DataNotFoundException dnfe){
        	throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
		return Response.status(Response.Status.NO_CONTENT).entity(JsonUtil.toJson(itemId)).build();
	}
    
    
    /**
	   * This method updates an item based on the given item info.
	   * @param itemId   item object. 
	   * @return Response   object to include the status and a json object representing the updated item.
	   * @exception WebApplicationException on input error and server side condition errors as well.
	   * @see WebApplicationException
	   */
    @Loggable(value=LogLevel.TRACE)
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response updateItem(ItemDetail item) throws Exception{
		if (item == null){
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		System.out.println("In updateItem, input item: "+ item.toString());
		try {
		    itemService.updateItem(item);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
		return Response.status(Response.Status.NO_CONTENT).entity(JsonUtil.toJson(item)).build();
	}
    	
    /**
	   * This method creates an item based on the given item info.
	   * @param itemId   item object. 
	   * @return Response   object to include the status and a json object representing the updated item.
	   * @exception WebApplicationException on input error and server side condition errors as well.
	   * @see WebApplicationException
	   */
    @Loggable(value=LogLevel.TRACE)
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response createItem(ItemDetail item){
		
		if (item == null){
			throw new WebApplicationException(Response.Status.NOT_FOUND);
	 	}
		try {
			itemService.createItem(item);
		}
		catch(Exception e){
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
		
		return Response.status(Response.Status.NO_CONTENT).entity(JsonUtil.toJson(item)).build();
	}		    
        
    
}
