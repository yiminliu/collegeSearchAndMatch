package com.bedrosians.bedlogic.dao.item;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bedrosians.bedlogic.dao.GenericDaoImpl;
import com.bedrosians.bedlogic.domain.account.SimplifiedAccount;
import com.bedrosians.bedlogic.domain.item.Item;
import com.bedrosians.bedlogic.domain.item.SimplifiedItem;
import com.bedrosians.bedlogic.domain.item.ItemDetail;
import com.bedrosians.bedlogic.util.PatternMatchMode;
import com.bedrosians.bedlogic.util.RestrictionOperation;


@Repository("itemDao")
public class ItemDaoImpl extends GenericDaoImpl<SimplifiedItem, String> implements ItemDao {
	

	//@Autowired
	//private SessionFactory sessionFactory;
		
	@Override
	//@Transactional
	public Item getItemById(String itemId) {
		
		return findById(itemId);
		//return findByParameter("itemId", itemId).get(0);
	}
		
	@Override
	//@Cacheable("items")
	public List<? extends Item> getItemsByIdPatternMatch(String id){
		return (List<SimplifiedItem>)findByParameterPattern("itemId", id, PatternMatchMode.START);
	}
	
/*
	@Override
	public List<Item> getItemsByActivityStatus(String status){
		String propertyName = "activityStatus";
		Criteria criteria = currentSession().createCriteria(Item.class);
		if  ("all".equalsIgnoreCase(status)){
			//do nothing
		}
		else if  ("active".equalsIgnoreCase(status))
			//criteria.add(
			  //  Restrictions.or(Restrictions.isNull(propertyName),
            //                    		Restrictions.eq(propertyName, " ")));
			//criteria.add(Restrictions.eq(propertyName, ""));
			criteria.add(Restrictions.isNull(propertyName));
		else if  ("inactive".equalsIgnoreCase(status))	
		   //criteria.add(Restrictions.eq(propertyName, "D").ignoreCase());
			criteria.add(Restrictions.isNotNull(propertyName));
		List<Item> list = (List<Item>)criteria.list();
		
		return list;
	}
	
	*/
	/*@Override
	public List<Item> getItemsByActivityStatus(String status){
		String propertyName = "activityStatus";
	    List<Item> items = null;
		if  ("all".equalsIgnoreCase(status))
	    	items = readByParameter(propertyName, " ", RestrictionOperation.NONE);	
		else if  ("active".equalsIgnoreCase(status))
			items = readByParameter(propertyName, " ");
		else if  ("inactive".equalsIgnoreCase(status))	
			items = readByParameter(propertyName, " ", RestrictionOperation.NOTNULL);
		
		return items;
	}
	*/
		
	/*@Override
    public List<Item> getItemsByParameter(String parameterName, String value){
	    String queryString = "from Item where ".concat(parameterName.concat(" = :")).concat(parameterName);
		Session session = currentSession();
		Query query = session.createQuery(queryString);
		query.setParameter(parameterName, value.toUpperCase());
		//query.setMaxResults(10);
		List<Item> list = (List<Item>)query.list();
			
		return list;
		
		Criteria criteria = currentSession().createCriteria(Item.class);
	  	criteria.setReadOnly(true);
	  	System.out.printf("parameterName, value.toUpperCase() = %s, %s ", parameterName, value.toUpperCase());
		criteria.add(Restrictions.eq(parameterName, value.toUpperCase()));
		return (List<Item>)criteria.list();	
	 }
	
		
	 @Override
	 public List<SimplifiedItem> getItemsByParameters(String[] parameterNames, String[] values){
	    String condition = "";
	    List<SimplifiedItem> itemList = null;
	    for(int i = 0; i < parameterNames.length; i++){
	    	if(i < parameterNames.length - 1)
	      	    condition.concat(parameterNames[i].concat(" = :")).concat(parameterNames[i]).concat(" AND ");
	    	else
	    		condition.concat(parameterNames[i].concat(" = :")).concat(parameterNames[i]);	
		}
		String queryString = "from Item where ".concat(condition);
		Session session = currentSession();
		Query query = session.createQuery(queryString);
		for(int i = 0; i < parameterNames.length; i++){
		    query.setParameter(parameterNames[i], values[i]);
		}			
		itemList = (List<SimplifiedItem>)query.list();
		return itemList;
	  }
	  */ 
	 
	 @Override
	 public List<SimplifiedItem> getAllItems(){
	   return (List<SimplifiedItem>)findAll();
	 }
	 
	 
	 @Override
		public List<SimplifiedItem> getItemByStatus(String status){
			String queryString = "";
			if ("all".equalsIgnoreCase(status) || status == null || status.length() == 0)
				queryString = "from Item";
			else if ("active".equalsIgnoreCase(status) || "N".equalsIgnoreCase(status))
				queryString = "from Item where status = 'N'";
			else if ("discontinued".equalsIgnoreCase(status) || "Y".equalsIgnoreCase(status) || ("inactive".equalsIgnoreCase(status)))
			    queryString = "from Item where status = 'Y' ";
			else if ("deleted".equalsIgnoreCase(status) || "D".equalsIgnoreCase(status))
			    queryString = "from Item where status = 'D' ";
			Session session = currentSession();
			Query query = session.createQuery(queryString);
			query.setReadOnly(true);
			return (List<SimplifiedItem>)query.list();
		}
	 

	 @Override
	 public List<SimplifiedItem> getItemsByDiscriptionPatternMatch(String description){
		 return (List<SimplifiedItem>)findByParameterPattern("itemDescription", description, PatternMatchMode.START);
	 }

	 @Override
	 public String createItem(SimplifiedItem simplifiedItem){
		 return save(simplifiedItem);
	}
	 
	 @Override
	 public void updateItem(SimplifiedItem item){
		 updateItem(item);
	 }
	 
	
	 /*@SuppressWarnings("unchecked")
     @Override
	 public Set<Item> getItemsByPhoneNo(Long phoneNo){
	 	 List<ItemPhone> itemPhones = itemPhoneDao.findByParameter("number", phoneNo);
		 //List<Item> itemList = new ArrayList<Item>();
		 Set<Item> itemSet = new HashSet<Item>();
		 for (ItemPhone phone : itemPhones){
			 itemSet.add(phone.getItem());
		 }
		return itemSet;
	 } 
	 */
   /*
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Item> getItems(
			String itemName,
			String addressStreetLine1,
			String addressCity,
			String addressState,
			String addressZip,
			String caseNo,
			String ownerFirstName,
			String ownerLastName,
			String ownerDriverLicenseNo,
			String phoneNo,
			String activityStatus){
		
		ProjectionList projList = Projections.projectionList()
				.add(Projections.property("itemId"), "itemId")
				.add(Projections.property("itemName"), "itemName")
				.add(Projections.property("creditStatus"), "creditStatus")
				.add(Projections.property("activityStatus"), "activityStatus")
				.add(Projections.property("addressCity"), "addressCity")
				.add(Projections.property("addressState"), "addressState")
				.add(Projections.property("addressZip"), "addressZip");
		Criteria crit = currentSession().createCriteria(Item.class)
			.setProjection(Projections.distinct(projList))
				.setResultTransformer(Transformers.aliasToBean(Item.class));
		if (itemName != null) {
			crit.add(Restrictions.like("itemName", "%".concat(itemName).concat("%")).ignoreCase());
		}
		
		if (addressStreetLine1 != null){
			crit.add(Restrictions.like("addressStreetLine1", "%".concat(addressStreetLine1).concat("%")).ignoreCase());
		}

		if (addressCity != null){
			crit.add(Restrictions.eq("addressCity", addressCity).ignoreCase());
		}
		
		if (addressState != null){
			crit.add(Restrictions.eq("addressState", addressState).ignoreCase());
		}
		
		if (addressZip != null){
			crit.add(Restrictions.eq("addressZip", addressZip).ignoreCase());
		}
		
		if (caseNo != null){
			crit.add(Restrictions.eq("caseNo", caseNo).ignoreCase());
		}
		
		if (ownerFirstName != null){
			crit.add(Restrictions.eq("ownerFirstName", ownerDriverLicenseNo).ignoreCase());
		}
		
		if (ownerLastName != null){
			crit.add(Restrictions.eq("ownerLastName", ownerLastName).ignoreCase());
		}
		
		if (ownerDriverLicenseNo != null){
			crit.add(Restrictions.eq("ownerDriverLicenseNo", ownerLastName).ignoreCase());
		}
		
		if (activityStatus != null){
			activityStatus = activityStatus.toLowerCase();
			if (activityStatus.compareTo("all") != 0){
				if (activityStatus.equals("active")) {
					activityStatus = "Y";
				} else if (activityStatus.equals("inactive")){
					activityStatus = "D";
				}
				crit.add(Restrictions.eq("activityStatus", activityStatus).ignoreCase());
			}
		}
		
		if (phoneNo != null){
			StringBuilder phoneSb = new StringBuilder();
			for (int i = 0 ; i < phoneNo.length() ; i++){
				char c = phoneNo.charAt(i);
				if (c >= 0 && c <= '9'){
					phoneSb.append(c);
				}
			}
			crit.createCriteria("phoneNumbers")
				.add(Restrictions.eq("number", Long.valueOf(phoneSb.toString())));
		}

		return crit.list();
	} 		
	 */  
	
}
