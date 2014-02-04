package com.bedrosians.bedlogic.dao.item;

import com.bedrosians.bedlogic.dao.GenericDao;
import com.bedrosians.bedlogic.domain.item.Item;
import com.bedrosians.bedlogic.domain.item.ItemDetail;

public interface ItemDetailDao extends GenericDao<ItemDetail, String>{
  
  public ItemDetail getItemById(String itemId);  
  public void updateItem(ItemDetail item);
  public String createItem(ItemDetail item);
  
}