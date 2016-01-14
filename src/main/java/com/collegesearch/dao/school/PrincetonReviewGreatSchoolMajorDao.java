package com.collegesearch.dao.school;

import java.util.List;

import org.hibernate.Session;

import com.collegesearch.dao.GenericDao;
import com.collegesearch.domain.school.PrincetonReviewGreatSchoolInPopularMajor;

public interface PrincetonReviewGreatSchoolMajorDao extends GenericDao<PrincetonReviewGreatSchoolInPopularMajor, Integer>{
  
  public List<PrincetonReviewGreatSchoolInPopularMajor> getPrincetonReviewGreatSchoolMajorsByMajorId(Integer programId);
  
  public List<PrincetonReviewGreatSchoolInPopularMajor> getPrincetonReviewGreatSchoolMajorsByMajorId(Integer programId, Session session);
  
}