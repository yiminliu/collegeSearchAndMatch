package com.collegesearch.dao.school;

import java.util.List;

import com.collegesearch.dao.GenericDao;
import com.collegesearch.domain.school.UsNewsBestSchoolProgram;

public interface UsNewsBestSchoolProgramDao extends GenericDao<UsNewsBestSchoolProgram, Integer>{
  
  public List<UsNewsBestSchoolProgram> getUsNewsBestSchoolProgramsByProgramId(Integer programId);
  
}