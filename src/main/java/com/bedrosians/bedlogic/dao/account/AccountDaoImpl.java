package com.bedrosians.bedlogic.dao.account;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.bedrosians.bedlogic.dao.GenericDaoImpl;
import com.bedrosians.bedlogic.domain.account.Account;
import com.bedrosians.bedlogic.domain.account.SimplifiedAccount;


@Repository("accountDao")
public class AccountDaoImpl extends GenericDaoImpl<SimplifiedAccount, String> implements AccountDao {
	
				
	@Override
	public List<SimplifiedAccount> getAllAccounts() {
		return (List<SimplifiedAccount>)findAll();
	}
	
	@Override
	public Account getAccountById(String accountId) {
		SimplifiedAccount account = (SimplifiedAccount)findById(accountId);
		//account.setAccountBranches(account.getAccountBranches());
	    //account.getAccountBranches();
		return account;
		//return findByParameter("accountId", accountId).get(0);
	}
	
	@Cacheable("accounts")
	@Override
	public List<SimplifiedAccount> getAccountsByStatus(String status){
		String queryString = "";
		if ("all".equalsIgnoreCase(status) || status == null || status.length() == 0)
			queryString = "from SimplifiedAccount";
		else if ("active".equalsIgnoreCase(status))
			queryString = "from SimplifiedAccount where status = ' '";
		else if ("inactive".equalsIgnoreCase(status))
		    queryString = "from SimplifiedAccount where status is not null";
		Session session = currentSession();
		Query query = session.createQuery(queryString);
		query.setReadOnly(true);
		return (List<SimplifiedAccount>)query.list();
	}
	
	
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
	/*@Override
	public List<Account> getAccountsByActivityStatus(String status){
		String propertyName = "activityStatus";
	    List<Account> accounts = null;
		if  ("all".equalsIgnoreCase(status))
	    	accounts = readByParameter(propertyName, " ", RestrictionOperation.NONE);	
		else if  ("active".equalsIgnoreCase(status))
			accounts = readByParameter(propertyName, " ");
		else if  ("inactive".equalsIgnoreCase(status))	
			accounts = readByParameter(propertyName, " ", RestrictionOperation.NOTNULL);
		
		return accounts;
	}
	*/
		
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
	
		
	 @Override
	 public List<SimplifiedAccount> getAccountsByParameters(String[] parameterNames, String[] values){
	    String condition = "";
	    List<SimplifiedAccount> accountList = null;
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
		accountList = (List<SimplifiedAccount>)query.list();
		return accountList;
	  }
	  */ 
	 
	 //@Override
	 public List<SimplifiedAccount> getAccountsByOwnerName(String firstName, String lastName){
		 Criteria criteria = currentSession().createCriteria(SimplifiedAccount.class);
		 if(firstName != null){
			 criteria.add(Restrictions.like("ownerFirstName",  firstName, MatchMode.START).ignoreCase());
		 }
		 if(lastName != null){
			 criteria.add(Restrictions.like("ownerLastName",  lastName, MatchMode.START).ignoreCase());
		 }
		 criteria.setReadOnly(true);
		 criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		 criteria.addOrder(Order.asc("ownerLastName"));
		 return (List<SimplifiedAccount>)criteria.list();
	 }

	 @Override
	 public String createAccount(SimplifiedAccount simplifiedAccount){
		 return save(simplifiedAccount);
	}
	 
	 @Override
	 public void updateAccount(SimplifiedAccount account){
		 updateAccount(account);
	 }
	 
	
}
