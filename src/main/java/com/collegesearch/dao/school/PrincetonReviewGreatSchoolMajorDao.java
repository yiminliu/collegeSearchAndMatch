package com.collegesearch.dao.school;

import java.util.List;

import org.hibernate.Session;

import com.collegesearch.dao.GenericDao;
import com.collegesearch.domain.school.PrincetonReviewGreatSchoolMajor;

public interface PrincetonReviewGreatSchoolMajorDao extends GenericDao<PrincetonReviewGreatSchoolMajor, Integer>{
  
  public List<PrincetonReviewGreatSchoolMajor> getPrincetonReviewGreatSchoolMajorsByMajorId(Integer programId);
  
  public List<PrincetonReviewGreatSchoolMajor> getPrincetonReviewGreatSchoolMajorsByMajorId(Integer programId, Session session);
  
}