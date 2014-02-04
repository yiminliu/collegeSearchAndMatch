package com.bedrosians.bedlogic.service;

import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.springframework.stereotype.Service;

import com.bedrosians.bedlogic.domain.item.Item;
import com.bedrosians.bedlogic.domain.item.ItemDetail;

@Service
public interface ItemService {
	
    public List<? extends Item> getItems();
	
	public Item getItemById(String id);
	
	public List<? extends Item> getItemsByDescription(String description);
	
	public List<? extends Item> getItemsByVendorId(String id);
		
	public List<? extends Item> getByQueryParameters(MultivaluedMap<String, String> queryParams);
	
	public String createItem(ItemDetail item);
	
	public void updateItem(ItemDetail item);
	
	public void updateItem(String itemId, ItemDetail item);

}
