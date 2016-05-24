package com.collegesearch.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;




//import javax.ws.rs.core.MultivaluedMap;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.collegesearch.domain.school.ASchoolForBStudent;
import com.collegesearch.domain.school.BestSchoolMajor;
import com.collegesearch.domain.school.School;


@Service
public interface SchoolService {
	
	public List<School> getAllSchools();
	public School getSchoolById(Integer id);
	public School getSchoolById(Integer id, Session session);
	public School getSchoolByName(String name);
	public List<School> getSchoolsByMatchNamePattern(String name);
	//public List<Applicant> getSchoolsByMajor(String major);
	public List<School> getSchoolsBySpeciality(String speciality);
	//public List<? extends Applicant> getSchools(MultivaluedMap<String, String> queryParams);
	public List<School> getSchools(LinkedHashMap<String, List<String>> queryParams);
	//public List<Applicant> getUsNewsBestSchoolPrograms(String programName);
	//public List<Applicant> getPrincetonReviewGreatSchoolMajor(String major);
	public List<BestSchoolMajor> getBestSchoolMajors(String majorName);
	public Integer createSchool(School school);
	//public String createSchool(MultivaluedMap<String, String> queryParams);
	public School updateSchool(School school);
	public void deleteSchool(School school);
	//public void updateSchool(MultivaluedMap<String, String> queryParams);
    public List<School> getAllASchoolsForBStudents();
    //public List<Applicant> matchEngine(List<Applicant> oriSchoolList, final LinkedHashMap<String, List<String>> queryParams);
    public List<School> searchEngine(final LinkedHashMap<String, List<String>> queryParams);
    public List<School> matchEngineUS(final LinkedHashMap<String, List<String>> queryParams);
    public List<School> matchEngineInternational(final LinkedHashMap<String, List<String>> queryParams);
}
