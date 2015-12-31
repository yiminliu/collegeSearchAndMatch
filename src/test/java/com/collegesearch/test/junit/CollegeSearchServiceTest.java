package com.collegesearch.test.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.collegesearch.domain.school.PrincetonReviewGreatSchoolMajor;
import com.collegesearch.domain.school.School;
import com.collegesearch.domain.school.UsNewsBestSchoolProgram;
import com.collegesearch.domain.school.School.RankComparator;
import com.collegesearch.domain.user.User;
import com.collegesearch.service.SchoolService;
import com.collegesearch.service.system.IndexService;
import com.collegesearch.service.user.UserService;
import com.collegesearch.util.school.SchoolUtil;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "/collegesearch-test-context.xml")
@ContextConfiguration(locations = {"/application_context/collegeSearch-context.xml", "/application_context/collegeSearch-persistence.xml"})
@TransactionConfiguration(defaultRollback = false)

public class CollegeSearchServiceTest {

	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private IndexService indexService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//indexService.initializeIndex();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetSchoolById() {
		Integer id = 4;
		School school = schoolService.getSchoolById(id);
		assertNotNull(school);
		assertEquals(id, school.getId());
		assertEquals("Philadelphia", school.getCity());
		assertEquals("PA", school.getState());
		System.out.println("School name = " + school.getName());
	}

	@Test
	public void testGetSchoolByName() {
		String name = "Drexel University";
		School school = schoolService.getSchoolByName(name);
		assertNotNull(school);
		assertEquals(name, school.getName());
		assertEquals("Philadelphia", school.getCity());
		assertEquals("PA", school.getState());
		System.out.println("School name = " + school.getName());
	}

	@Test
	public void testGetSchoolByName2() {
		String name = "Washington University in St. Louis";
		School school = schoolService.getSchoolByName(name);
		assertNotNull(school);
		assertEquals(name, school.getName());
		System.out.println("School name = " + school.getName());
	}
	
	@Test
	public void testGetSchoolsByMatchNamePattern() {
		//indexService.initializeIndex();
		String name = "Penn";
		List<School> schools = schoolService.getSchoolsByMatchNamePattern(name);
		assertNotNull(schools);
		School school = schools.get(0);
		assertNotNull(school);
		//assertEquals(name, school.getName());
		System.out.println("School name = " + school.getName());
	}
	
	@Test
	public void testGetSchools() {
		List<School> schools = schoolService.getAllSchools();
		assertNotNull(schools);
	}
	
	@Test
	public void testGetUsNewsBestSchoolPrograms() {
		//String name = "Business";
		String name = "Engineering";
		List<School> pList = schoolService.getUsNewsBestSchoolPrograms(name);
		assertNotNull(pList);
		//assertEquals(name, school.getName());
		//assertEquals("Philadelphia", school.getCity());
		//assertEquals("PA", school.getState());
	}
	
	@Test
	public void testPrincetonReviewGreatSchoolMajor() {
		//String name = "Business";
		//String name = "Engineering";
		String name = "Mechanical Engineering";
		//String name = "Health Services";
		//String name = "Communications";
		List<School> pList = schoolService.getPrincetonReviewGreatSchoolMajor(name);
		assertNotNull(pList);
		assertNotEquals(0, pList.size());
		for(School s : pList){
			System.out.println("school = " + s.toString());
		}
		//assertEquals(name, school.getName());
		//assertEquals("Philadelphia", school.getCity());
		//assertEquals("PA", school.getState());
	}
	
	@Test
	public void testgetSchoolsByMajor() {
		//String name = "Business";
		//String name = "Engineering";
		String name = "Mechanical Engineering";
		//String name = "Health Services";
		//String name = "Communications";
		List<School> pList = schoolService.getSchoolsByMajor(name);
		assertNotNull(pList);
		assertNotEquals(0, pList.size());
		for(School s : pList){
			System.out.println("school = " + s.toString());
		}
		//assertEquals(name, school.getName());
		//assertEquals("Philadelphia", school.getCity());
		//assertEquals("PA", school.getState());
	}
/*
	@Test
	public void testGetUsNewsBestSchoolPrograms() {
		String name = "Business";
		List<UsNewsBestSchoolProgram> pList = schoolService.getUsNewsBestSchoolPrograms(name);
		assertNotNull(pList);
		//assertEquals(name, school.getName());
		//assertEquals("Philadelphia", school.getCity());
		//assertEquals("PA", school.getState());
		List<School> sList = new ArrayList<School>(pList.size());
		for(UsNewsBestSchoolProgram p : pList){
			System.out.println("pList = " + p.toString());
			School s = schoolService.getSchoolById(p.getId().getSchoolId());
			s.setRankOverall(p.getRank());
			System.out.println("school="+s.toString());
			sList.add(s);
		}
		
	}
	*/
	@Test
	public void testGetByQueryParameters() {
		//MultivaluedMap<String,String> params = new MultivaluedMapImpl();
		//params.put("inactivecode", Arrays.asList(new String[]{"N"}));
		LinkedHashMap<String, List<String>> params = new LinkedHashMap<String, List<String>>();
		//params.put("internationalFinancialAid", Arrays.asList(new String[]{"Yes"}));
		//params.put("toefl", Arrays.asList(new String[]{"95"}));
		//params.put("rankOverall", Arrays.asList(new String[]{"Top 25"}));
		//params.put("type", Arrays.asList(new String[]{"Private"}));
		//params.put("state", Arrays.asList(new String[]{"CA"}));
		params.put("category", Arrays.asList(new String[]{"National University"}));
		//params.put("tuitionFee", Arrays.asList(new String[]{"< 20000"}));
		//params.put("roomBoard", Arrays.asList(new String[]{"< 20000"}));
		//params.put("totalCost", Arrays.asList(new String[]{"<20000"}));
		//params.put("sat1Score", Arrays.asList(new String[]{"1800"}));
		//params.put("size", Arrays.asList(new String[]{"Small(<2000)"}));
		//params.put("size", Arrays.asList(new String[]{"between 2000 and 15000"}));
		params.put("acceptRate", Arrays.asList(new String[]{"<25%"}));
		//params.put("acceptRate", Arrays.asList(new String[]{"between 20% and 50%"}));
		
		List<School> pList = schoolService.getSchools(params);
		Collections.sort(pList,  new RankComparator());
		assertNotNull(pList);
		assertNotEquals(0, pList.size());
		for(School s : pList){
			System.out.println("school = " + s.toString());
		}
	}
	
	@Test
	public void testGetScholsBySAT1QueryParameters() {
		//MultivaluedMap<String,String> params = new MultivaluedMapImpl();
		//params.put("inactivecode", Arrays.asList(new String[]{"N"}));
		LinkedHashMap<String, List<String>> params = new LinkedHashMap<String, List<String>>();
		String sat1Score = "1200";
		String actScore = "28";
		//params.put("sat1Score", Arrays.asList(new String[]{sat1Score}));
		params.put("actScore", Arrays.asList(new String[]{actScore}));
		
		List<School> sList = schoolService.getSchools(params);
		List<School> schoolsAdjustedBySAT1Standard = new ArrayList<School>(sList.size());
		//for(School school : sList){
		//    if(Integer.valueOf(sat1Score) >= SchoolUtil.adjustSchoolStandardforSatOrActScores(school.getSat1Percentile25(), school.getSat1Percentile75(), school.getAcceptRate()))
		//      schoolsAdjustedBySAT1Standard.add(school);
		//} 
		//assertNotNull(schoolsAdjustedBySAT1Standard);
		System.out.println("number of schools returned = "+sList.size()); 
		assertNotEquals(0, sList.size());
		//for(School s : pList){
		//	System.out.println("school = " + s.toString());
		//}
	}
	
	@Test
	public void testGetScholsByTOEFLQueryParameters() {
		//MultivaluedMap<String,String> params = new MultivaluedMapImpl();
		//params.put("inactivecode", Arrays.asList(new String[]{"N"}));
		LinkedHashMap<String, List<String>> params = new LinkedHashMap<String, List<String>>();
		String toeflScore = "60";
		String ieltsScore = "8";
		//params.put("internationalStudentApplication.toeflScore", Arrays.asList(new String[]{toeflScore}));
		//params.put("internationalStudentApplication.ieltsScore", Arrays.asList(new String[]{ieltsScore}));
		//params.put("internationalStudentApplication.conditionalAdmissionOffered", Arrays.asList(new String[]{"Yes"}));
		params.put("internationalStudentApplication.toeflAcceptedInsteadOfSatOrAct", Arrays.asList(new String[]{"Yes"}));
		
		
		List<School> sList = schoolService.getSchools(params);
		List<School> schoolsAdjustedBySAT1Standard = new ArrayList<School>(sList.size());
		//for(School school : sList){
		//    if(Integer.valueOf(sat1Score) >= SchoolUtil.adjustSchoolStandardforSatOrActScores(school.getSat1Percentile25(), school.getSat1Percentile75(), school.getAcceptRate()))
		//      schoolsAdjustedBySAT1Standard.add(school);
		//} 
		//assertNotNull(schoolsAdjustedBySAT1Standard);
		System.out.println("number of schools returned = "+sList.size()); 
		assertNotEquals(0, sList.size());
		//for(School s : pList){
		//	System.out.println("school = " + s.toString());
		//}
	}
	
	@Test
	public void testGetInternationalStudentData() {
		//MultivaluedMap<String,String> params = new MultivaluedMapImpl();
		//params.put("inactivecode", Arrays.asList(new String[]{"N"}));
		String name = "United States Coast Guard Academy";
		School school = schoolService.getSchoolByName(name);
		
		//assertNotNull(schoolsAdjustedBySAT1Standard);
		System.out.println("data = "+school.getInternationalStudentApplication().getInternationalStudentAcceptRate()); 
		System.out.println("data = "+school.getInternationalStudentApplication().getInternationalStudentRetentionRate()); 
		//for(School s : pList){
		//	System.out.println("school = " + s.toString());
		//}
	}
	
	@Test
	public void testGetWebsiteFromInternationalContact() {
		//indexService.initializeIndex();
		//MultivaluedMap<String,String> params = new MultivaluedMapImpl();
		//params.put("inactivecode", Arrays.asList(new String[]{"N"}));
		//String name = "University of Pennsylvania";
		String name = "United States Coast Guard Academy";
		School school = schoolService.getSchoolByName(name);
		
		//assertNotNull(schoolsAdjustedBySAT1Standard);
		System.out.println("data = "+school.getInternationalStudentApplication().getWebsite()); 
			//for(School s : pList){
		//	System.out.println("school = " + s.toString());
		//}
		//org.hibernate.SessionFactory sf = new org.hibernate.SessionFactory();
		//.close();
	}
	 

	@Test
	public void testSearchSchools() {
		//MultivaluedMap<String,String> params = new MultivaluedMapImpl();
		//params.put("inactivecode", Arrays.asList(new String[]{"N"}));
		LinkedHashMap<String, List<String>> params = new LinkedHashMap<String, List<String>>();
		params.put("internationalFinancialAid", Arrays.asList(new String[]{"Yes"}));
		
		List<School> pList = schoolService.getSchools(params);
		assertNotNull(pList);
		assertNotEquals(0, pList.size());
		for(School s : pList){
			System.out.println("school = " + s.toString());
		}
	}
	
	//@Test
	public void testCreateSchool() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateSchool() throws Exception {
	    System.out.println("testUpdateItemWithJsonObject: ");
	    String name = "Yale University";
	    //School school = new School("Yale University");
	    School school = schoolService.getSchoolByName(name);
	    school.setAcceptRate(10.1f);
	    schoolService.updateSchool(school);
	    //assertEquals(school.getAcceptRate(), 10.0F);
	    System.out.println("school accept rate = " + school.getAcceptRate());
	    System.out.println("school = " + school.toString());
		//School updatedSchool = schoolService.getSchoolByName(name);
		}
	
	@Test
	public void testUserService(){
	User user = null;
	long startTime = System.currentTimeMillis();
	String userName="test";
	//Session session = new SessionFactory().openSession();
    try{
      //session.getTransaction().begin();
      System.out.println("Start 1st round test");
      user = userService.getUserByName(userName);
     
      //session.getTransaction().commit();
      //session.close();
       //sessionFactory.getStatistics().logSummary();
    }
    catch(Exception e){
	   e.printStackTrace();
    }
    long totalTime = System.currentTimeMillis() - startTime;
    System.out.println("user: " + user);
	}

}
