package com.collegesearch.service;

import java.util.LinkedHashMap;
import java.util.List;

//import javax.ws.rs.core.MultivaluedMap;






import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.collegesearch.domain.school.School;
import com.collegesearch.domain.school.UsNewsBestSchoolProgram;


@Service
public interface SchoolService {
	
	public School getSchoolById(Integer id);
	public School getSchoolById(Integer id, Session session);
	public School getSchoolByName(String name);
	public List<School> getSchoolsByMatchNamePattern(String name);
	public List<School> getSchoolsByMajor(String major);
	
    public List<School> getAllSchools();
	
	//public List<? extends School> getSchools(MultivaluedMap<String, String> queryParams);
	public List<School> getSchools(LinkedHashMap<String, List<String>> queryParams);
	public List<School> getUsNewsBestSchoolPrograms(String programName);
	public List<School> getPrincetonReviewGreatSchoolMajor(String major);
	public Integer createSchool(School school);
	
	//public String createSchool(MultivaluedMap<String, String> queryParams);
	
	public School updateSchool(School school);
		
	public void deleteSchool(School school);
	
	//public void updateSchool(MultivaluedMap<String, String> queryParams);

}