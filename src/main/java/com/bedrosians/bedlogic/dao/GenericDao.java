package com.bedrosians.bedlogic.dao;

import java.io.Serializable;
import java.util.List;

import com.bedrosians.bedlogic.util.PatternMatchMode;
import com.bedrosians.bedlogic.util.RestrictionOperation;

public interface GenericDao <T, PK extends Serializable>{
	PK save(T newInstance);
	T findById(PK id);
	void update(T transientObject);
	void delete(T persistentObject);
	List<T> findByParameter(String parameterName, String value);
	List<T> findByParameter(String parameterName, Long value);
	List<T> findByParameter(String parameterName, String value, RestrictionOperation op);
	List<T> findByParameterPatternMatch(String parameterName, String value, PatternMatchMode matchMode);

}
