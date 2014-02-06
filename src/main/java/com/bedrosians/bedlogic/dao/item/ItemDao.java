package com.bedrosians.bedlogic.dao.item;

import java.util.List;
import java.util.Set;

import com.bedrosians.bedlogic.dao.GenericDao;
import com.bedrosians.bedlogic.domain.account.SimplifiedAccount;
import com.bedrosians.bedlogic.domain.item.Item;
import com.bedrosians.bedlogic.domain.item.SimplifiedItem;
import com.bedrosians.bedlogic.domain.item.ItemDetail;

public interface ItemDao extends GenericDao<SimplifiedItem, String>{
  
  public Item getItemById(String itemId);  
  public List<? extends Item> getAllItems();  
  public List<? extends Item> getItemsByIdPatternMatch(String Id);
  public List<? extends Item> getItemsByDiscriptionPatternMatch(String description);
  public List<SimplifiedItem> getItemByStatus(String status);
  public String createItem(SimplifiedItem symolifiedItem);
  public void updateItem(SimplifiedItem item);
  //public String createItem(Item item);
    
}