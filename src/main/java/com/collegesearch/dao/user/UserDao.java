package com.collegesearch.dao.user;

import java.util.List;

import org.hibernate.Session;

import com.collegesearch.dao.GenericDao;
import com.collegesearch.domain.user.User;


public interface UserDao extends GenericDao<User, String>{
  
  public User getUserByName(Session session, String userName);
  public User getUserByEmail(Session session, String email);
  public List<User> getAllUsers(Session session);
  public void updateUser(Session session, User user);
  public Integer createUser(User user);
  
}