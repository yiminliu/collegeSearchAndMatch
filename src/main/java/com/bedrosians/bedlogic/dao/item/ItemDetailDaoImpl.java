package com.bedrosians.bedlogic.dao.item;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.bedrosians.bedlogic.dao.GenericDaoImpl;
import com.bedrosians.bedlogic.domain.item.ItemDetail;


@Repository("itemDetailDao")
public class ItemDetailDaoImpl extends GenericDaoImpl<ItemDetail, String> implements ItemDetailDao {
						
	@Override
	public ItemDetail getItemById(String itemId) {
		//return findById(itemId);//branch info cannot be linked to the item.
		List<ItemDetail> list = findByParameter("itemId", itemId);
		if(list != null && !list.isEmpty())
		   return list.get(0);
		else return null;
	}
	
	@Override
	public void updateItem(ItemDetail item){
		update(item);
	}
	  
	@Override
	public String createItem(ItemDetail item){
		return (String)save(item);  
	}
}
