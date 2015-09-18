package com.collegesearch.dao.school;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.collegesearch.dao.GenericDaoImpl;
import com.collegesearch.domain.school.PrincetonReviewPopularMajor;


@Repository("princetonReviewPopularMajorDao")
public class PrincetonReviewPopularMajorDaoImpl extends GenericDaoImpl<PrincetonReviewPopularMajor, Integer> implements PrincetonReviewPopularMajorDao {
						
	@Override
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
	public PrincetonReviewPopularMajor getPrincetonReviewPopularMajorById(Integer majorId){
	   List<PrincetonReviewPopularMajor> majorList = findByParameter("id.majorId", majorId);
	   if(majorList != null && majorList.size()>0)
		  return majorList.get(0); 
	   else
		  return null;
	}
	
	@Override
	//@Transactional(readOnly=true, propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
	public PrincetonReviewPopularMajor getPrincetonReviewPopularMajorByName(String name){
		List<PrincetonReviewPopularMajor> majorList = findByParameter("name", name);
	    if(majorList != null && majorList.size()>0)
		   return majorList.get(0); 
		else
		   return null;
	}
	
	@Override
	//@Transactional(readOnly=true, propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
	public PrincetonReviewPopularMajor getPrincetonReviewPopularMajorByName(String name, Session session){
		List<PrincetonReviewPopularMajor> majorList = findByParameter("name", name);
	    if(majorList != null && majorList.size()>0)
		   return majorList.get(0); 
		else
		   return null;
	}

}
