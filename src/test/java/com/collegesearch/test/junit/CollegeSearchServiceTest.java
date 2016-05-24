package com.collegesearch.test.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
//import java.util.Map;

import java.util.Set;


//import org.hibernate.Session;
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

import com.collegesearch.dao.school.ASchoolForBStudentDao;
import com.collegesearch.dao.school.BestSchoolMajorDao;
import com.collegesearch.domain.school.Major;
//import com.collegesearch.domain.school.PrincetonReviewGreatSchoolInPopularMajor;
//import com.collegesearch.domain.school.Major;
import com.collegesearch.domain.school.School;
import com.collegesearch.domain.school.BestSchoolMajor;
//import com.collegesearch.domain.school.School.NameComparator;
import com.collegesearch.domain.school.School.RankComparator;
import com.collegesearch.domain.school.School.RankByCategoryComparator;
import com.collegesearch.domain.school.School.ToeflComparator;
//import com.collegesearch.domain.school.School.AcceptanceRateComparator;
import com.collegesearch.domain.school.BestSchoolMajor.MajorRankComparator;
import com.collegesearch.domain.user.User;
import com.collegesearch.service.SchoolService;
import com.collegesearch.service.system.IndexService;
import com.collegesearch.service.user.UserService;
import com.collegesearch.util.school.SchoolUtil;
//import com.collegesearch.util.school.SchoolUtil;

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
	
	@Autowired
	BestSchoolMajorDao bestSchoolMajorDao;
	
	@Autowired
	ASchoolForBStudentDao aSchoolForBStudentDao;
	
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
		Integer id = 5;
		School school = schoolService.getSchoolById(id);
		assertNotNull(school);
		assertEquals(id, school.getId());
		assertEquals("Philadelphia", school.getCity());
		assertEquals("PA", school.getState());
		System.out.println("Applicant name = " + school.getName());
	}

	@Test
	public void testGetSchoolByName() {
		String name = "Drexel University";
		School school = schoolService.getSchoolByName(name);
		assertNotNull(school);
		assertEquals(name, school.getName());
		assertEquals("Philadelphia", school.getCity());
		assertEquals("PA", school.getState());
		System.out.println("Applicant name = " + school.getName());
	}

	@Test
	public void testGetSchoolByName2() {
		String name = "Washington University in St. Louis";
		School school = schoolService.getSchoolByName(name);
		assertNotNull(school);
		assertEquals(name, school.getName());
		System.out.println("Applicant name = " + school.getName());
	}
	
	@Test
	public void testGetSchoolsByMatchNamePattern() {
		indexService.initializeIndex();
		String name = "yale";
		List<School> schools = schoolService.getSchoolsByMatchNamePattern(name);
		assertNotNull(schools);
		System.out.println("number of schools " + schools.size()); 
		//School school = schools.get(0);
		//assertNotNull(school);
		for(School school : schools){
		//assertEquals(name, school.getName());
		   System.out.println("school name = " + school.getName());
		}   
	}
	
	@Test
	public void testGetSchools() {
		
		LinkedHashMap<String, List<String>> params = new LinkedHashMap<String, List<String>>();
		params.put("category", Arrays.asList(new String[]{"NU"}));
		params.put("maxResults", Arrays.asList(new String[]{"50"}));
		List<School> schools = schoolService.getSchools(params);
		System.out.println(schools.size() + " schools returned.");
		
		assertNotNull(schools);
	}
	
	//@Test
	public void testGetSchoolsByAcceptaRate() {
		LinkedHashMap<String, List<String>> params = new LinkedHashMap<String, List<String>>();
		//params.put("acceptRate", Arrays.asList(new String[]{">99"}));
		params.put("acceptRate", Arrays.asList(new String[]{"(between 25% and 50%)"}));
		List<School> schools = schoolService.getSchools(params);
		System.out.println(schools.size() + " schools returned.");
		Collections.sort(schools,  new RankComparator());
		for(School school : schools){
		    //System.out.printf("school: %s, rank: %f %n", school.getName(), school.getRankOverall());
		}			
		assertNotNull(schools);
	}
	
	@Test
	public void testGetSchoolsBySize() {
		LinkedHashMap<String, List<String>> params = new LinkedHashMap<String, List<String>>();
		params.put("size", Arrays.asList(new String[]{"(between 2000 and 15000)"}));
		List<School> schools = schoolService.getSchools(params);
		System.out.println(schools.size() + " schools returned.");
		Collections.sort(schools,  new RankComparator());
		assertNotNull(schools);
	}
	
	@Test
	public void testGetTrimedSchoolsByAcceptaRate() {
		//LinkedHashMap<String, List<String>> params = new LinkedHashMap<String, List<String>>();
		//params.put("acceptRate", Arrays.asList(new String[]{">95"}));
		List<School> schools = schoolService.getAllSchools();
		//System.out.println(schools.size() + " schools returned.");
		System.out.println("Now sorting the list...");
		//Collections.sort(schools,  new AcceptanceRateComparator());
		System.out.println(schools.size() + " schools returned.");
		
		assertNotNull(schools);
	}
	
	@Test
	public void testGetSchoolsWithLowToefl() {
		LinkedHashMap<String, List<String>> params = new LinkedHashMap<String, List<String>>();
		//params.put("internationalStudentApplication.minimumToeflScore", Arrays.asList(new String[]{"90"}));
		params.put("randomApplicant.toeflScore", Arrays.asList(new String[]{"90"}));
		List<School> schools = schoolService.getSchools(params);
		Collections.sort(schools, new ToeflComparator()); 
		//System.out.println(schools.size() + " schools returned.");
		System.out.println("Now sorting the list...");
		//Collections.sort(schools,  new AcceptanceRateComparator());
		System.out.println(schools.size() + " schools returned.");
		
		assertNotNull(schools);
	}
    
	@Test
	public void testGetSchoolsByApplicationFee() {
		LinkedHashMap<String, List<String>> params = new LinkedHashMap<String, List<String>>();
		params.put("applicationFee", Arrays.asList(new String[]{"0"}));
		List<School> schools = schoolService.getSchools(params);
		System.out.println(schools.size() + " schools returned.");
		Collections.sort(schools,  new RankComparator());
		assertNotNull(schools);
	}
	
	@Test
	public void testGetBestSchoolMajor() {
		String name = "Accounting";
		//String name = "Engineering";
		//String name = "Mechanical";
		//String name = "Health Services";
		//String name = "Computer_Doctorate";
		//List<Applicant> pList = schoolService.getPrincetonReviewGreatSchoolMajor(name);
		List<BestSchoolMajor> pList = schoolService.getBestSchoolMajors(name);
		//List<BestSchoolMajor> pList = bestSchoolMajorDao.getBestSchoolMajorsByMajorId("COMM1");
		//Collections.sort(pList,  new MajorRankComparator());
		assertNotNull(pList);
		assertNotEquals(0, pList.size());
		System.out.println("# of school = " + pList.size());
		Collections.sort(pList, new MajorRankComparator());
		for(BestSchoolMajor s : pList){
			System.out.println(s.getRank() + ": " +"school = " + s.getSchool().getName());
		}
		//assertEquals(name, school.getName());
		//assertEquals("Philadelphia", school.getCity());
		//assertEquals("PA", school.getState());
	}
	/*
	@Test
	public void testgetSchoolsByMajor() {
		//String name = "Business";
		//String name = "Engineering";
		String name = "Mechanical Engineering";
		//String name = "Health Services";
		//String name = "Communications";
		List<Applicant> pList = schoolService.getSchoolsByMajor(name);
		assertNotNull(pList);
		assertNotEquals(0, pList.size());
		for(Applicant s : pList){
			System.out.println("school = " + s.toString());
		}
		//assertEquals(name, school.getName());
		//assertEquals("Philadelphia", school.getCity());
		//assertEquals("PA", school.getState());
	}
	*/
	
	@Test
	public void testGetSchoolsBySpeciality() {
		String speciality = "Engineering_Doctorate";
		List<School> pList = schoolService.getSchoolsBySpeciality(speciality);
		assertNotNull(pList);
		assertNotEquals(0, pList.size());
		for(School s : pList){
			System.out.println("school : rank = " + s.getName() + ": "+ s.getSchoolRankInSpeciality().getRank());
		}
		//assertEquals(name, school.getName());
		//assertEquals("Philadelphia", school.getCity());
		//assertEquals("PA", school.getState());
	}
	
	@Test
	public void testgetArtSchools() {
		LinkedHashMap<String, List<String>> params = new LinkedHashMap<String, List<String>>();
		params.put("category", Arrays.asList(new String[]{"Art Schools"}));
		List<School> schools = schoolService.getSchools(params);
		assertNotNull(schools);
		assertNotEquals(0,schools.size());
		for(School s : schools){
			System.out.println("school : name = " + s.getName());
		}
	}

	@Test
	public void testGetSchoolsByQueryParameters() {
		//MultivaluedMap<String,String> params = new MultivaluedMapImpl();
		//params.put("inactivecode", Arrays.asList(new String[]{"N"}));
		LinkedHashMap<String, List<String>> params = new LinkedHashMap<String, List<String>>();
		//params.put("internationalFinancialAid", Arrays.asList(new String[]{"Yes"}));
		//params.put("toefl", Arrays.asList(new String[]{"95"}));
		//params.put("rankOverall", Arrays.asList(new String[]{"Top 25"}));
		params.put("type", Arrays.asList(new String[]{"Private"}));
		params.put("state", Arrays.asList(new String[]{"CA"}));
		params.put("averageGpa", Arrays.asList(new String[]{"< 3.5"}));
		//params.put("category", Arrays.asList(new String[]{"NU"}));
		//params.put("tuitionFee", Arrays.asList(new String[]{"< 20000"}));
		//params.put("roomBoard", Arrays.asList(new String[]{"< 20000"}));
		//params.put("totalCost", Arrays.asList(new String[]{"<20000"}));
		//params.put("sat1Score", Arrays.asList(new String[]{"1800"}));
		//params.put("size", Arrays.asList(new String[]{"Small(<2000)"}));
		//params.put("size", Arrays.asList(new String[]{"between 2000 and 15000"}));
		//params.put("acceptRate", Arrays.asList(new String[]{">95%"}));
		//params.put("acceptRate", Arrays.asList(new String[]{"between 20% and 50%"}));
		//params.put("satActNotRequired", Arrays.asList(new String[]{"Yes"}));
		
		List<School> pList = schoolService.getSchools(params);
		Collections.sort(pList,  new RankByCategoryComparator());
		assertNotNull(pList);
		assertNotEquals(0, pList.size());
		System.out.println(pList.size() + " schools returned");
		//for(Applicant s : pList){
		//	System.out.println("school = " + s.toString());
		//}
	}
	
	@Test
	public void testGetScholsBySAT1QueryParameters() {
		//MultivaluedMap<String,String> params = new MultivaluedMapImpl();
		//params.put("inactivecode", Arrays.asList(new String[]{"N"}));
		LinkedHashMap<String, List<String>> params = new LinkedHashMap<String, List<String>>();
		
		String sat1Score = "600";
		String actScore = "28";
		//params.put("randomApplicant.sat1Score", Arrays.asList(new String[]{sat1Score}));
		params.put("randomApplicant.sat1ReadingScore", Arrays.asList(new String[]{sat1Score}));
		params.put("randomApplicant.sat1MathScore", Arrays.asList(new String[]{sat1Score}));
		
		List<School> sList = schoolService.getSchools(params);
		List<School> schoolsAdjustedBySAT1Standard = new ArrayList<School>(sList.size());
		//for(Applicant school : sList){
		//    if(Integer.valueOf(sat1Score) >= SchoolUtil.adjustSchoolStandardforSatOrActScores(school.getSat1Percentile25(), school.getSat1Percentile75(), school.getAcceptRate()))
		//      schoolsAdjustedBySAT1Standard.add(school);
		//} 
		//assertNotNull(schoolsAdjustedBySAT1Standard);
		System.out.println("number of schools returned = "+sList.size()); 
		assertNotEquals(0, sList.size());
		//for(Applicant s : pList){
		//	System.out.println("school = " + s.toString());
		//}
	}
	
	@Test
	public void testGetScholsByTOEFLQueryParameters() {
		//MultivaluedMap<String,String> params = new MultivaluedMapImpl();
		//params.put("inactivecode", Arrays.asList(new String[]{"N"}));
		LinkedHashMap<String, List<String>> params = new LinkedHashMap<String, List<String>>();
		String toeflScore = "60";
		//String ieltsScore = "8";
		//params.put("internationalStudentApplication.toeflScore", Arrays.asList(new String[]{toeflScore}));
		//params.put("internationalStudentApplication.ieltsScore", Arrays.asList(new String[]{ieltsScore}));
		//params.put("internationalStudentApplication.conditionalAdmissionOffered", Arrays.asList(new String[]{"Yes"}));
		params.put("internationalStudentApplication.toeflAcceptedInsteadOfSatOrAct", Arrays.asList(new String[]{"Yes"}));
		
		
		List<School> sList = schoolService.getSchools(params);
		Collections.sort(sList, new RankComparator());
		List<School> schoolsAdjustedBySAT1Standard = new ArrayList<School>(sList.size());
		//for(Applicant school : sList){
		//    if(Integer.valueOf(sat1Score) >= SchoolUtil.adjustSchoolStandardforSatOrActScores(school.getSat1Percentile25(), school.getSat1Percentile75(), school.getAcceptRate()))
		//      schoolsAdjustedBySAT1Standard.add(school);
		//} 
		//assertNotNull(schoolsAdjustedBySAT1Standard);
		System.out.println("number of schools returned = "+sList.size()); 
		assertNotEquals(0, sList.size());
		//for(Applicant s : pList){
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
		//for(Applicant s : pList){
		//	System.out.println("school = " + s.toString());
		//}
	}
	
	@Test
	public void testGetWebsiteFromInternationalContact() {
		//indexService.initializeIndex();
		//MultivaluedMap<String,String> params = new MultivaluedMapImpl();
		//params.put("inactivecode", Arrays.asList(new String[]{"N"}));
		//String name = "University of Pennsylvania";
		String name = "University of the West";
		School school = schoolService.getSchoolByName(name);
		
		//assertNotNull(schoolsAdjustedBySAT1Standard);
		System.out.println("data = "+school.getInternationalStudentApplication().getWebsite()); 
			//for(Applicant s : pList){
		//	System.out.println("school = " + s.toString());
		//}
		//org.hibernate.SessionFactory sf = new org.hibernate.SessionFactory();
		//.close();
	}
	 
	@Test
	public void testGetGreatMajors() {
		String name = "Drexel University";
		School school = schoolService.getSchoolByName(name);
		Set<Major> bestMajors = school.getBestMajors();
		//assertNotNull(schoolsAdjustedBySAT1Standard);
		//System.out.println("data = "+school.getGoodAtMajors()); 
		System.out.println("# of best majors = " + bestMajors.size());
		//System.out.println("best majors = " + bestMajors.get(0).getMajor().getName());
		for(Major sm : bestMajors){
	//		System.out.println("major = " + sm.getMajor().getName());
		}
	}

	
	/*
	@Test
	public void testSearchSchools() {
		//MultivaluedMap<String,String> params = new MultivaluedMapImpl();
		//params.put("inactivecode", Arrays.asList(new String[]{"N"}));
		LinkedHashMap<String, List<String>> params = new LinkedHashMap<String, List<String>>();
		params.put("getInternationalStudentApplication().financialAid", Arrays.asList(new String[]{"Yes"}));
		
		List<Applicant> pList = schoolService.getSchools(params);
		assertNotNull(pList);
		assertNotEquals(0, pList.size());
		for(Applicant s : pList){
			System.out.println("school = " + s.toString());
		}
	}
	*/
	@Test
	public void testConvertActToSat() throws Exception {
	   
	    int actScore = 22;
	    int satScore = SchoolUtil.convertActToSat(actScore);
	    System.out.println("actScore = " + actScore + " : " + "satScore = " + satScore );
		//Applicant updatedSchool = schoolService.getSchoolByName(name);
	}
	
	@Test
	public void testMatchEngine() {
		LinkedHashMap<String, List<String>> params = new LinkedHashMap<String, List<String>>();
		//params.put("state", Arrays.asList(new String[]{"PA"}));
		//params.put("name", Arrays.asList(new String[]{"Yale University"}));
		params.put("category", Arrays.asList(new String[]{"NU"}));
		String sat1Score = "650";
		//String actScore = "28";
		//params.put("randomApplicant.sat1Score", Arrays.asList(new String[]{sat1Score}));
		params.put("randomApplicant.toeflScore", Arrays.asList(new String[]{"90"}));
		params.put("randomApplicant.gpaScore", Arrays.asList(new String[]{"3.5"}));
		params.put("randomApplicant.sat1ReadingScore", Arrays.asList(new String[]{sat1Score}));
		params.put("randomApplicant.sat1MathScore", Arrays.asList(new String[]{sat1Score}));
		//params.put("randomApplicant.satSubjects", Arrays.asList(new String[]{"Math Level1", "Biology"}));
				
		//params.put("totalCost", Arrays.asList(new String[]{"<20000"}));
		//params.put("randomApplicant.sat1Score", Arrays.asList(new String[]{"1400"}));
		
		//params.put("actScore", Arrays.asList(new String[]{"25"}));
		//params.put("ieltsScore", Arrays.asList(new String[]{"6"}));
		//params.put("randomApplicant.gpaScore", Arrays.asList(new String[]{"3.5"}));
		List<School> schools = schoolService.matchEngineInternational(params);
		assertNotNull(schools);
		//assertNotEquals(0,schools.size());
		System.out.println(schools.size() + " returned back to client.");
		for(School s : schools){
			System.out.printf("school: %s, gpa: %f %n", s.getName(), s.getAverageGpa());
			//System.out.printf("25perc SAT: %d, 50perc SAT: %d, 25perc Act: %d, %n", s.getSat1Percentile25(), s.getAverageSAT(), s.getActPercentile25());
			//System.out.printf("minToefl: %d, aveToefl: %d, ielts: %d, %n", s.getInternationalStudentApplication().getMinimumToeflScore(), s.getInternationalStudentApplication().getAverageToeflScore(), s.getInternationalStudentApplication().getAverageIeltsScore());
			//System.out.println("********");

		}
		//assertEquals(name, school.getName());
		//assertEquals("Philadelphia", school.getCity());
		//assertEquals("PA", school.getState());
	}
	
	@Test
	public void testGetASchoolForBStudent() {
		List<School> schools = schoolService.getAllASchoolsForBStudents();
		assertNotNull(schools);
		for(School school : schools){
			System.out.println("school: " + school.getName());
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
	    //Applicant school = new Applicant("Yale University");
	    School school = schoolService.getSchoolByName(name);
	    school.setAcceptRate(10.1f);
	    schoolService.updateSchool(school);
	    //assertEquals(school.getAcceptRate(), 10.0F);
	    System.out.println("school accept rate = " + school.getAcceptRate());
	    System.out.println("school = " + school.toString());
		//Applicant updatedSchool = schoolService.getSchoolByName(name);
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
