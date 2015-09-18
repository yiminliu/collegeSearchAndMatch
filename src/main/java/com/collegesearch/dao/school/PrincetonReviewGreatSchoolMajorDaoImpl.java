package com.collegesearch.dao.school;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.collegesearch.dao.GenericDaoImpl;
import com.collegesearch.domain.school.PrincetonReviewGreatSchoolMajor;
import com.collegesearch.domain.school.UsNewsBestSchoolProgram;


@Repository("princetonReviewGreatSchoolMajorDaoDao")
public class PrincetonReviewGreatSchoolMajorDaoImpl extends GenericDaoImpl<PrincetonReviewGreatSchoolMajor, Integer> implements PrincetonReviewGreatSchoolMajorDao {
	
	@Override
	//@Transactional(readOnly=true, propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
	public List<PrincetonReviewGreatSchoolMajor> getPrincetonReviewGreatSchoolMajorsByMajorId(Integer id){
		return findByParameter("id.majorId", id);
	}
	
	@Override
	//@Transactional(readOnly=true, propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
	public List<PrincetonReviewGreatSchoolMajor> getPrincetonReviewGreatSchoolMajorsByMajorId(Integer id, Session session){
		return findByParameter("id.majorId", id, session);
	}	
}
