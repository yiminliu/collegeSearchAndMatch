package com.bedrosians.bedlogic.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

import org.hibernate.Query;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.bedrosians.bedlogic.domain.miscellaneous.Obmh;
import com.bedrosians.bedlogic.util.logger.aspect.LogLevel;
import com.bedrosians.bedlogic.util.logger.aspect.Loggable;

@Scope("singleton")
public class IdGenerator implements IdentifierGenerator{
  
  public IdGenerator(){}
  
  @Loggable(value=LogLevel.TRACE)
  @Transactional
  public Serializable generate(SessionImplementor session,  Object object) throws DataAccessException, UnsupportedOperationException {
	 long newId = 0l;
	 Query query = session.getNamedQuery("findLastCustCd");
	 try{
	    session.connection().setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
	  
	 Obmh record = (Obmh)query.uniqueResult();
	 if (record != null)
	    newId = new AtomicLong((Long)record.getLastCustId()).incrementAndGet(); 
	 }catch(SQLException sqle){
		 session.getTransactionCoordinator().getTransaction().rollback();
	 }	
	 finally{
		 try{
		    session.connection().setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		 }catch(SQLException sqle){
		 }   
	 }
	 return String.valueOf(newId);
 }
  
  //@Transactional
 /* private long fetchLastUserId() throws DataAccessException, UnsupportedOperationException {
    try {
      //List<Integer> list = getHibernateTemplate().find("select max(user.userId) from User user");
      	Query query = currentSession().createQuery("from Obmh");
    	Obmh record = (Obmh)query.uniqueResult();
    	if ((record == null)) {
             return 0;
        }
        return (Long)record.getLastCustId();
    }
    catch (DataAccessException dae)
    {
      throw dae;
    }
    catch (ClassCastException cce)
    {
      throw new UnsupportedOperationException("Only numeric type user id filed is allowed!");
    }
    catch (Exception e)
    {
      throw new RuntimeException("Exception occured : " + e.getMessage() + ".  Unable to determin user id.");
    }
  }*/  
  
 }
