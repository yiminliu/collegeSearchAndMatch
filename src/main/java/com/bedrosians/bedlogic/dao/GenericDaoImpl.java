package com.bedrosians.bedlogic.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;



public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
	private Class<T> type;
	
	//@Resource(name="sessionFactory")
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session currentSession() {
	//    return sessionFactory.getCurrentSession();
		return sessionFactory.openSession();
	}
	
	@SuppressWarnings("unchecked")
	public GenericDaoImpl(){
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public PK create(T newInstance) {
		return null;
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public T read(PK id) {
		return (T)currentSession().get(type, id);
	}
	public void update(T transientObject) {
		
	}
	public void delete(T persistentObject) {
		
	}
}
