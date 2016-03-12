package com.collegesearch.dao.school;

import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Session;

import com.collegesearch.dao.GenericDao;
import com.collegesearch.domain.school.School;

public interface SchoolDao extends GenericDao<School, Integer>{
  
  public School getSchoolByName(String schoolName);  
  public School getSchoolByName(Session session, String name);
  public List<School> getSchoolsByMatchNamePattern(String name);
  public List<School> getSchools(LinkedHashMap<String, List<String>> queryParams);
  public Integer createSchool(School school);
  public void updateSchool(Session session, School school);
  public void deleteSchool(School school);
  
}