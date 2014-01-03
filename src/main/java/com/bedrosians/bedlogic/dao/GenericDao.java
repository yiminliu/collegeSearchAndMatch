package com.bedrosians.bedlogic.dao;

import java.io.Serializable;
import java.util.List;

import com.bedrosians.bedlogic.util.PatternMatchMode;
import com.bedrosians.bedlogic.util.RestrictionOperation;

public interface GenericDao <T, PK extends Serializable>{
	PK save(T newInstance);
	T read(PK id);
	List<T> readMultipleRecords(PK id);
	void update(T transientObject);
	void delete(T persistentObject);
	List<T> readByParameter(String parameterName, String value);
	List<T> readByParameter(String parameterName, Long value);
	List<T> readByParameter(String parameterName, String value, RestrictionOperation op);
	List<T> readByParameterPatternMatch(String parameterName, String value, PatternMatchMode matchMode);

}
