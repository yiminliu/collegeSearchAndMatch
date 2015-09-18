package com.collegesearch.dao.school;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.collegesearch.dao.GenericDaoImpl;
import com.collegesearch.domain.school.UsNewsBestSchoolProgram;


@Repository("usNewsBestSchoolProgramDao")
public class UsNewsBestSchoolProgramDaoImpl extends GenericDaoImpl<UsNewsBestSchoolProgram, Integer> implements UsNewsBestSchoolProgramDao {
						
	@Override
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
	public List<UsNewsBestSchoolProgram> getUsNewsBestSchoolProgramsByProgramId(Integer programId){
	    //String sqlString = "From UsNewsBestScholProgram Where "
		//Integer id = findByParameter("name", name);
		return findByParameter("id.programId", programId);
	}	
}
