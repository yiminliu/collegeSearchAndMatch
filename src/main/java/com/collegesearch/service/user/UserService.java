package com.collegesearch.service.user;

//import javax.ws.rs.core.MultivaluedMap;

import com.collegesearch.domain.user.User;
import com.collegesearch.exception.CollegeSearchException;
import com.collegesearch.exception.DatabaseOperationException;

public interface UserService {
	
	public User getUserById(String id) throws DatabaseOperationException;
		
	public User getUserByName(String userName);
	
	public User getUserByEmail(String email);
	
	public Integer createUser(User user)throws DatabaseOperationException, CollegeSearchException;
	
	//public String createUser(MultivaluedMap<String, String> queryParams) throws BedDAOBadParamException, BedDAOException, BedResException;
	
	public void updateUser(User user) throws DatabaseOperationException, CollegeSearchException;
	
	public void updateUser(String userName, User user) throws DatabaseOperationException, CollegeSearchException;
	
}
