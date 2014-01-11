package com.bedrosians.bedlogic.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bedrosians.bedlogic.util.PatternMatchMode;
import com.bedrosians.bedlogic.util.RestrictionOperation;


public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
	private Class<T> type;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session currentSession() {
	    return sessionFactory.getCurrentSession();
	    
	}
		
	@SuppressWarnings("unchecked")
	public GenericDaoImpl(){
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Transactional
	public PK save(T newInstance) {
		return (PK)currentSession().save(newInstance);
	}
	
	@Override
	//@Transactional
	@SuppressWarnings("unchecked")
	public T findById(final PK id) {
		return (T)currentSession().get(type, id);
	}
			
	@Override
	//@Transactional
	public synchronized void update(final T transientObject) {
		try{
           Session session = currentSession();
           if(session.contains(transientObject))
        	  session.saveOrUpdate(transientObject);
           else
        	  session.merge(transientObject);
		}
		catch(DataException e){
			throw e;
		}
		   
   	}
	
	public void delete(T persistentObject) {
		
	}
	
	@Override
    public List<T> findByParameter(final String parameterName, String value){
		if(value != null && value.length() > 0)
		   value = value.toUpperCase();
	  	Criteria criteria = currentSession().createCriteria(type);
	  	criteria.setReadOnly(true);
	  	criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.add(Restrictions.eq(parameterName, value));
		return (List<T>)criteria.list();			
	}
	
	@Override
    public List<T> findByParameter(final String parameterName, String value, final RestrictionOperation op){
		if(value != null && value.length() > 0)
		   value = value.toUpperCase();
	  	Criteria criteria = currentSession().createCriteria(type);
	  	criteria.setReadOnly(true);
	  	// need it? 
	  	criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	  	switch(op) {
	  	  case EQ:
	  		   criteria.add(Restrictions.eq(parameterName, value));  	
	  	  case NE:
	  		   criteria.add(Restrictions.ne(parameterName, value));
	  	  case IN:
	  		   criteria.add(Restrictions.in(parameterName, value.split(",")));	   
	  		   break;
	  	  case NULL:
	  		   criteria.add(Restrictions.isNull(parameterName));	   
	  		   break; 		   
	      case NOTNULL:
	  		   criteria.add(Restrictions.isNotNull(parameterName));	   
	  		   break; 	   
	       case NONE:
	  		   break;	   
	  	  default:
	  		   break;
	  	}		   
		return (List<T>)criteria.list();			
	}
	
	@Override
    public List<T> findByParameter(final String parameterName, Long value){
	  	Criteria criteria = currentSession().createCriteria(type);
	  	criteria.setReadOnly(true);
	  	criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.add(Restrictions.eq(parameterName, value));
		return (List<T>)criteria.list();			
	}
	
	@Override
    public List<T> findByParameterPatternMatch(final String parameterName, String value, final PatternMatchMode matchMode){
	  	Criteria criteria = currentSession().createCriteria(type);
	  	switch(matchMode){
	  		case START:
	  			criteria.add(Restrictions.like(parameterName, value.toUpperCase(), MatchMode.START));
		        break;
	  		case END:
	  			criteria.add(Restrictions.like(parameterName, value.toUpperCase(), MatchMode.END));
			    break;
	  		case ANYWHERE:
	  			criteria.add(Restrictions.like(parameterName, value.toUpperCase(), MatchMode.ANYWHERE));
			    break;
			default:
				criteria.add(Restrictions.like(parameterName, value.toUpperCase(), MatchMode.EXACT));
	  	} 				
	  	criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	  	return (List<T>)criteria.list();
			
	 }
}
