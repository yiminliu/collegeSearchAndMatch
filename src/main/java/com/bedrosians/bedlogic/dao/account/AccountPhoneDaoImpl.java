package com.bedrosians.bedlogic.dao.account;

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

import com.bedrosians.bedlogic.dao.GenericDaoImpl;
import com.bedrosians.bedlogic.domain.account.Account;
import com.bedrosians.bedlogic.domain.account.AccountPhone;
import com.bedrosians.bedlogic.util.PatternMatchMode;


@Repository("accountPhoneDao")
public class AccountPhoneDaoImpl extends GenericDaoImpl<AccountPhone, String> implements AccountPhoneDao {
	

	@Autowired
	private SessionFactory sessionFactory;
	
	//protected Session currentSession() {
	    //return sessionFactory.getCurrentSession();
		//return sessionFactory.openSession();
	//}
		
	@Override
	public AccountPhone getAccountPhoneById(String accountId) {
		
		return findById(accountId);
	}

	public Set<Account> getAccountsByPhoneNo(Long phoneNo){
		 List<AccountPhone> accountPhones = findByParameter("number", phoneNo);
	     List<Account> accountList = new ArrayList<Account>();
		 Set<AccountPhone> accountPhoneSet = new HashSet(accountPhones);
		 for (AccountPhone phone : accountPhones){
			 accountList.add(phone.getAccount());
		 }
		 return new LinkedHashSet<Account>(accountList);
	 }
				
	
}
