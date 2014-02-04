package com.bedrosians.bedlogic.service;

import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bedrosians.bedlogic.dao.item.ItemDao;
import com.bedrosians.bedlogic.dao.item.ItemDetailDao;
import com.bedrosians.bedlogic.domain.item.Item;
import com.bedrosians.bedlogic.domain.item.ItemDetail;
import com.bedrosians.bedlogic.domain.item.SimplifiedItem;
import com.bedrosians.bedlogic.exeception.DataNotFoundException;
import com.bedrosians.bedlogic.util.PatternMatchMode;
import com.bedrosians.bedlogic.util.logger.aspect.LogLevel;
import com.bedrosians.bedlogic.util.logger.aspect.Loggable;


@Service("itemService")
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
	ItemDao itemDao;    
    @Autowired
	ItemDetailDao itemDetailDao;    
    	    	
    @Loggable(value = LogLevel.TRACE)
    @Override
	@Transactional(readOnly=true)
	public Item getItemById(String id) {
    	return itemDetailDao.getItemById(id);
		//if(item != null){	         		
		//	item.setCheckPayments(checkPaymentDao.getCheckPaymentsForItem(id));
		//}
	}
/*	    
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
    public List<SimplifiedItem> getItemsByItemNamePattern(String name){
		return itemDao.findByParameterPattern("itemName", name, PatternMatchMode.START);
	}
	
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
    public List<SimplifiedItem> getItemsByOwnerName(String firstName, String lastName){
		return itemDao.getItemsByOwnerName(firstName, lastName);
	}
	
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<SimplifiedItem> getItemsByAddress(String streetAddress){
		return itemDao.findByParameter("addressLine1", streetAddress);
	}
	
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<SimplifiedItem> getItemsByCity(String city){
		return itemDao.findByParameter("city", city);
	}
	
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<SimplifiedItem> getItemsByState(String state){
   		return itemDao.findByParameter("state", state);
	}
	
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<SimplifiedItem> getItemsByZip(String zip){
     	return itemDao.findByParameter("zip", zip);
	}
		
	@Loggable(value = LogLevel.TRACE)
	@Override
	public ItemBranch getItemBranchById(String itemId, String branchId) {
		BranchPK branchPK = new BranchPK(itemId, branchId);
		return itemBranchDetailDao.findById(branchPK);
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public ItemBranch getItemBranchByBranchPK(BranchPK branchPK) {
		return itemBranchDetailDao.findById(branchPK);
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	public List<SimplifiedItemBranch> getItemBranches(String itemId) {
		return itemBranchDao.getItemBranches(itemId);
	}
	
	
	public List<CheckPayment> getCheckPaymentsForItem(String custcd) {
		return checkPaymentDao.getCheckPaymentsForItem(custcd);
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<SimplifiedItem> getItems(){
		return itemDao.getItemsByActivityStatus("all");
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<SimplifiedItem> getItemsByActivityStatus(String status){
		return itemDao.getItemsByActivityStatus(status);
	}
	*/
    
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<SimplifiedItem> getItems(){
		return null;//itemDao.findByParameters(queryParams);
	}
    
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
    public List<Item> getItemsByDescription(String description){
    	return (List<Item>)itemDao.getItemsByDiscriptionPatternMath(description);
    }
	
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<Item> getItemsByVendorId(String id){
    	return null;
    }
	
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<SimplifiedItem> getByQueryParameters(MultivaluedMap<String, String> queryParams){
		return itemDao.findByParameters(queryParams);
	}
		
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional
	public String createItem(ItemDetail item){
		return itemDetailDao.createItem(item); 
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional
	public void updateItem(String itemId, ItemDetail item){
		Item retrievedItem = null;
		try{
		   retrievedItem = getItemById(itemId);
		   if(retrievedItem == null)
			  throw new DataNotFoundException("No data found"); 
		}
		catch(Exception e){
			throw e;
			
		}
		//if(item instanceof ItemDetail)
		   itemDetailDao.updateItem((ItemDetail)item); 
		//else if(item instanceof SimplifiedItem)
		  // itemDao.update((SimplifiedItem)item); 
	}
	
	@Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional
	public void updateItem(ItemDetail item){
		//if(item instanceof ItemDetail)
		   itemDetailDao.updateItem(item); 
		//else if(item instanceof SimplifiedItem)
		  // itemDao.update((SimplifiedItem)item);
	}	
	
}
