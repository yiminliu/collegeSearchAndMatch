package com.collegesearch.dao.school;

import org.hibernate.Session;

import com.collegesearch.dao.GenericDao;
import com.collegesearch.domain.school.PrincetonReviewPopularMajor;

public interface PrincetonReviewPopularMajorDao extends GenericDao<PrincetonReviewPopularMajor, Integer>{
  
  public PrincetonReviewPopularMajor getPrincetonReviewPopularMajorById(Integer id);
  public PrincetonReviewPopularMajor getPrincetonReviewPopularMajorByName(String name);
  public PrincetonReviewPopularMajor getPrincetonReviewPopularMajorByName(String name, Session session);
}