package com.bedrosians.bedlogic.dao;

import java.util.ArrayList;
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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bedrosians.bedlogic.domain.Account;
import com.bedrosians.bedlogic.domain.AccountPhone;
import com.bedrosians.bedlogic.util.PatternMatchMode;
import com.bedrosians.bedlogic.util.RestrictionOperation;


@Repository
public class AccountDaoImpl extends GenericDaoImpl<Account, String> implements AccountDao {
	

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private AccountPhoneDao accountPhoneDao;
	
	protected Session currentSession() {
	    //return sessionFactory.getCurrentSession();
		return sessionFactory.openSession();
	}
		
	@Override
	public Account getAccountById(String accountId) {
		
		return read(accountId);
	}
	
	/*
	@Override
	public List<Account> getAccountsByActivityStatus(String status){
		String queryString = "";
		if ("all".equalsIgnoreCase(status) || status == null || status.length() == 0)
			queryString = "from Account";
		else if ("active".equalsIgnoreCase(status))
			queryString = "from Account a where activityStatus = ' '";
		else if ("inactive".equalsIgnoreCase(status))
		    queryString = "from Account a where activityStatus != ' '";
		Session session = currentSession();
		Query query = session.createQuery(queryString);
		query.setReadOnly(true);
		return (List<Account>)query.list();
	}
	*/
	
/*
	@Override
	public List<Account> getAccountsByActivityStatus(String status){
		String propertyName = "activityStatus";
		Criteria criteria = currentSession().createCriteria(Account.class);
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
		List<Account> list = (List<Account>)criteria.list();
		
		return list;
	}
	
	*/
	@Override
	public List<Account> getAccountsByActivityStatus(String status){
		String propertyName = "activityStatus";
	    List<Account> accounts = null;
		//Criteria criteria = currentSession().createCriteria(Account.class);
	    if  ("all".equalsIgnoreCase(status))
	    	accounts = readByParameter(propertyName, " ", RestrictionOperation.NE);
	
		else if  ("active".equalsIgnoreCase(status))
			accounts = readByParameter(propertyName, " ");
		else if  ("inactive".equalsIgnoreCase(status))	
			accounts = readByParameter(propertyName, " ", RestrictionOperation.NE);
		
		return accounts;
	}
	
	
	
	
	/*@Override
    public List<Account> getAccountsByParameter(String parameterName, String value){
	    String queryString = "from Account where ".concat(parameterName.concat(" = :")).concat(parameterName);
		Session session = currentSession();
		Query query = session.createQuery(queryString);
		query.setParameter(parameterName, value.toUpperCase());
		//query.setMaxResults(10);
		List<Account> list = (List<Account>)query.list();
			
		return list;
		
		Criteria criteria = currentSession().createCriteria(Account.class);
	  	criteria.setReadOnly(true);
	  	System.out.printf("parameterName, value.toUpperCase() = %s, %s ", parameterName, value.toUpperCase());
		criteria.add(Restrictions.eq(parameterName, value.toUpperCase()));
		return (List<Account>)criteria.list();	
	 }
	 */

		
	 @Override
	 public List<Account> getAccountsByParameters(String[] parameterNames, String[] values){
	    String condition = "";
	    List<Account> accountList = null;
	    for(int i = 0; i < parameterNames.length; i++){
	    	if(i < parameterNames.length - 1)
	      	    condition.concat(parameterNames[i].concat(" = :")).concat(parameterNames[i]).concat(" AND ");
	    	else
	    		condition.concat(parameterNames[i].concat(" = :")).concat(parameterNames[i]);	
		}
		String queryString = "from Account where ".concat(condition);
		Session session = currentSession();
		Query query = session.createQuery(queryString);
		for(int i = 0; i < parameterNames.length; i++){
		    query.setParameter(parameterNames[i], values[i]);
		}
			
		accountList = (List<Account>)query.list();
			
		return accountList;
	  }
	 
	 
	 @Override
	 public List<Account> getAccountsByOwnerName(String firstName, String lastName){
		 Criteria criteria = currentSession().createCriteria(Account.class);
		 if(firstName != null){
			 criteria.add(Restrictions.like("firstName",  firstName, MatchMode.START).ignoreCase());
		 }
		 if(lastName != null){
			 criteria.add(Restrictions.like("lastName",  lastName, MatchMode.START).ignoreCase());
		 }
		 criteria.addOrder(Order.asc("lastName"));
		 return (List<Account>)criteria.list();
	 }
	 
	 public Set<Account> getAccountsByPhoneNo(Long phoneNo){
		 List<AccountPhone> accountPhones = accountPhoneDao.readByParameter("number", phoneNo);
	     List<Account> accountList = new ArrayList<Account>();
		 Set<AccountPhone> accountPhoneSet = new HashSet(accountPhones);
		 for (AccountPhone phone : accountPhones){
			 accountList.add(phone.getAccount());
		 }
		 return new LinkedHashSet<Account>(accountList);
	 }
	 
		
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Account> getAccounts(
			String accountName,
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
				.add(Projections.property("accountId"), "accountId")
				.add(Projections.property("accountName"), "accountName")
				.add(Projections.property("creditStatus"), "creditStatus")
				.add(Projections.property("activityStatus"), "activityStatus")
				.add(Projections.property("addressCity"), "addressCity")
				.add(Projections.property("addressState"), "addressState")
				.add(Projections.property("addressZip"), "addressZip");
		Criteria crit = currentSession().createCriteria(Account.class)
			.setProjection(Projections.distinct(projList))
				.setResultTransformer(Transformers.aliasToBean(Account.class));
		if (accountName != null) {
			crit.add(Restrictions.like("accountName", "%".concat(accountName).concat("%")).ignoreCase());
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
	   
	
}
