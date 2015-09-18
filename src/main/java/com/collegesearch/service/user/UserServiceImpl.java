package com.collegesearch.service.user;

//import javax.ws.rs.core.MultivaluedMap;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegesearch.dao.user.UserDao;
import com.collegesearch.exception.CollegeSearchException;
import com.collegesearch.exception.DatabaseOperationException;
import com.collegesearch.exception.InputParamException;
import com.collegesearch.domain.user.User;

@Service("userService")
public class UserServiceImpl implements UserService{
					
	 @Autowired
	 private UserDao userDao;  
	    
	 @Autowired
	 private SessionFactory sessionFactory;
     
	@Override
	public User getUserByName(String userName){
		User user = null;
		Session session = sessionFactory.openSession();
	    try{
	    	user = userDao.getUserByName(session, userName);
	    }
	    catch(HibernateException e){
	     	e.printStackTrace();
	    	throw new DatabaseOperationException("Error occured while retrieve user from database. Reason: " + e.getMessage(), e);
	    }
	    catch(Exception e){
	    	throw new DatabaseOperationException("Error occured while retrieve user from database. Reason: " + e.getMessage(), e);
	    }
	    return user;
	}
	
	@Override
	public User getUserById(String id) throws CollegeSearchException{
		return null;
	}

	@Override
	  public User getUserByEmail(String email){ 
		  return null;
	  }
	 
	  @Override 
	  public void updateUser(User user){};
	  
	  @Override
	  public void updateUser(String userName, User user) throws InputParamException, CollegeSearchException{
		  
	  }
	  
	  @Override
	  public Integer createUser(User user){ 
		  return userDao.createUser(user);
	  }
	  
	  //@Override
	  //public String createUser(MultivaluedMap<String, String> queryParams) throws InputParamException, CollegeSearchException{
		//  return null;
	  //}

	  
	
	
	
}
