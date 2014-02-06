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

    
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
	public List<SimplifiedItem> getItems(){
		return itemDao.findAll();
	}
    
    @Loggable(value = LogLevel.TRACE)
	@Override
	@Transactional(readOnly=true)
    public List<Item> getItemsByDescription(String description){
    	return (List<Item>)itemDao.getItemsByDiscriptionPatternMatch(description);
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
		itemDetailDao.updateItem(item); 
	}	
	
}
