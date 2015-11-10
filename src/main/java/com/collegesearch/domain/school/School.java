package com.collegesearch.domain.school;

// Generated Jul 11, 2015 5:53:42 PM by Hibernate Tools 4.0.0

import java.util.Comparator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.hibernate.annotations.Fetch;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.Boost;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;


/**
 * SchoolId generated by hbm2java
 */
@Entity
@Table (name="School")
@Indexed
@Analyzer(impl = StandardAnalyzer.class)
public class School implements java.io.Serializable {

	private static final long serialVersionUID = 6749990758703320L;
	private Integer id;
	private String  name;
	private String  type;
	private String  city;
	private String  state;
	private String  setting;
	private Integer size;
	private Integer tuitionFee;
	private Integer instateTuitionFee;
	private Integer roomBoard;
	private String  applicationDeadline;
	private String  satActReceivedDeadline;
	private String  earlyDecisionDeadline;
	private Float   percentageClassesFewerThan20Students;
    private Float   percentageClassesMoreThan50Students;
    private Float   percentageClassesBetween25And50Students;
  	private Integer applicationFee;
	private Integer sat1Percentile25;
	private Integer sat1Percentile75;
	private Integer actPercentile25;
	private Integer actPercentile75;
	private Integer sat1Score;
	private Integer actScore;
	private String  satActNotRequired;
	private Integer numberOfRequiredSat2;
	private Float   acceptRate;
	private Integer averageFreshmanRetentionRate;
    private Integer sixYearGraduationRate;
	private Integer rankOverall;
	private Float   reputationScore;
	private String  selectivity;
	private Integer hsClassTop10Percentage;
	private Float   studentFacultyRatio;
	private String  category;
	private String  calendar;
	private String  Phone;
	private String  website;
	private Integer maxResults;
	private Integer totalCost;
	private InternationalStudentApplication internationalStudentApplication;
	private Float anticipationIndex;
	private String applicationNote;
	
	
	
	/*private Set<PrincetonReviewPopularMajor> goodAtMajors = new HashSet<PrincetonReviewPopularMajor>();
	@OneToMany(fetch=FetchType.EAGER, mappedBy="item", cascade={CascadeType.ALL, CascadeType.REMOVE})//, orphanRemoval=true)
	//@Fetch(FetchMode.SUBSELECT)
	public Set<PrincetonReviewPopularMajor> getGoodAtMajors() {
		return this.goodAtMajors;
	}

	public void setGoodAtMajors(Set<PrincetonReviewPopularMajor> goodAtMajors) {
		this.goodAtMajors = goodAtMajors;
	}
   
	public void addColorhue(PrincetonReviewPopularMajor major){
		major.setSchool(this);
		if(goodAtMajors == null)
			goodAtMajors = new HashSet<PrincetonReviewPopularMajor>();
		goodAtMajors.add(major);
	}
	*/
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
	//@Fetch(FetchMode.JOIN)
	//@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	@IndexedEmbedded
	public InternationalStudentApplication getInternationalStudentApplication() {
		return internationalStudentApplication;
	}

	public void setInternationalStudentApplication(
			InternationalStudentApplication internationalStudentApplication) {
		this.internationalStudentApplication = internationalStudentApplication;
	}
	
	/*
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
	@Fetch(FetchMode.JOIN)
	//@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	@IndexedEmbedded
	public ImsNewFeature getNewFeature() {	
	    return this.newFeature;
	}
	public void setNewFeature(ImsNewFeature newFeature) {
		this.newFeature = newFeature;
	}
	
	public void addNewFeature(ImsNewFeature newFeature ){
		if(getNewFeature() != null)
			setNewFeature(null);
		//if(newFeature.getItemCode() == null || !newFeature.getItemCode().equalsIgnoreCase(getItemcode()))
		//	newFeature.setItemCode(getItemcode());
		newFeature.setItem(this);
		this.newFeature = newFeature;
	}
	*/
	@DocumentId
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "Id", unique = true, nullable = false)
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    
	@Field(index=Index.YES, analyze=Analyze.NO, store=Store.YES)
	@Boost(1.5f)
    @Column(name = "Name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Type", length = 10)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "City", length = 80)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Field(index=Index.YES, analyze=Analyze.NO, store=Store.YES)
	@Boost(1.5f)
	@Column(name = "State", length = 2)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "Setting", length = 15)
	public String getSetting() {
		return this.setting;
	}

	public void setSetting(String setting) {
		this.setting = setting;
	}

	@Column(name = "Size")
	public Integer getSize() {
		return this.size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Column(name = "Tuition_Fee")
	public Integer getTuitionFee() {
		return this.tuitionFee;
	}

	public void setTuitionFee(Integer tuitionFee) {
		this.tuitionFee = tuitionFee;
	}

	@Column(name = "In_State_Tuition_Fee")
	public Integer getInstateTuitionFee() {
		return instateTuitionFee;
	}

	public void setInstateTuitionFee(Integer instateTuitionFee) {
		this.instateTuitionFee = instateTuitionFee;
	}

	@Column(name = "Room_Board")
	public Integer getRoomBoard() {
		return this.roomBoard;
	}

	public void setRoomBoard(Integer roomBoard) {
		this.roomBoard = roomBoard;
	}

	@Column(name = "Application_Deadline", length = 10)
	public String getApplicationDeadline() {
		return this.applicationDeadline;
	}

	public void setApplicationDeadline(String applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
	}

	@Column(name = "Application_Fee")
	public Integer getApplicationFee() {
		return this.applicationFee;
	}

	public void setApplicationFee(Integer applicationFee) {
		this.applicationFee = applicationFee;
	}

	@Column(name = "SAT1_percentile_25")
	public Integer getSat1Percentile25() {
		return this.sat1Percentile25;
	}

	public void setSat1Percentile25(Integer sat1Percentile25) {
		this.sat1Percentile25 = sat1Percentile25;
	}

	@Column(name = "SAT1_percentile_75")
	public Integer getSat1Percentile75() {
		return this.sat1Percentile75;
	}

	public void setSat1Percentile75(Integer sat1Percentile75) {
		this.sat1Percentile75 = sat1Percentile75;
	}
	
	@Transient
	public Integer getSat1Score() {
		return sat1Score;
	}

	public void setSat1Score(Integer sat1Score) {
		this.sat1Score = sat1Score;
	}
	
	@Transient
	public Integer getActScore() {
		return actScore;
	}

	public void setActScore(Integer actScore) {
		this.actScore = actScore;
	}

	@Column(name = "ACT_percentile_25")
	public Integer getActPercentile25() {
		return actPercentile25;
	}

	public void setActPercentile25(Integer actPercentile25) {
		this.actPercentile25 = actPercentile25;
	}

	@Column(name = "ACt_percentile_75")
	public Integer getActPercentile75() {
		return actPercentile75;
	}

	public void setActPercentile75(Integer actPercentile75) {
		this.actPercentile75 = actPercentile75;
	}
	
	/*
	@Transient
	public Integer getAdjustedSat1Standard() {
		if(sat1Percentile25 <= 0 || sat1Percentile75 <= 0) {
			adjustedSat1Standard = 0;
			return 0;
		}	
		float sat = 0.0f;
		if(acceptRate <= 10) 
		   sat = actPercentile75 * 1.2f; //for top 10 return 120% of Percentile75;
		else if(acceptRate > 10 && acceptRate <= 20) 
			  sat = actPercentile75 * 1.15f; //for top 10-25 return 115% of Percentile75
		else if(acceptRate > 20 && acceptRate <= 30) 
			   sat = actPercentile75 * 1.1f; //for top 20-30 return 110% of Percentile75
		else if(acceptRate > 30 && acceptRate <= 40)
			   sat = actPercentile75 * 1.05f; //for top 30-40 return 105% of Percentile75
		else if(acceptRate > 40 && acceptRate <= 50) 
			   sat = actPercentile75 * 1.0f;  //for top 40-50 return 100% of Percentile75
		else if(acceptRate > 50 && acceptRate <= 60) 
			   sat = actPercentile75 * 0.9f;  
		else if(acceptRate > 60 && acceptRate <= 70) //for top 40-60 return (Percentile25 + Percentile75)/2
			   sat = actPercentile75 * 0.8f;  //for top 60-70 return 80% of Percentile75
			//adjustedActStandard = (actPercentile25 + actPercentile75)/2; //for top 50-60 return 90% of Percentile75
		else if(acceptRate > 70)                     //for top > 60 Percentile25
			   sat = actPercentile25;
		adjustedSat1Standard = Math.round(sat);
		return adjustedSat1Standard;
	}

	public void setAdjustedSat1Standard(Integer adjustedSat1Standard) {
		this.adjustedSat1Standard = adjustedSat1Standard;
	}
	
	@Transient
	public boolean isSat1ScoreSatisfied(int sat1Score){
		if(getAdjustedSat1Standard() == 0 )
		   return false;	
		return (sat1Score >= getAdjustedSat1Standard());
	}
	
	@Transient
	public Integer getAdjustedActStandard() {
		if(actPercentile25 <= 0 || actPercentile75 <= 0) {
			adjustedActStandard = 0;
			return 0;
		}	
		float act = 0.0f;
		if(acceptRate <= 10) 
		   act = actPercentile75 * 1.2f; //for top 10 return 120% of Percentile75;
		else if(acceptRate > 10 && acceptRate <= 20) 
			  act = actPercentile75 * 1.15f; //for top 10-25 return 115% of Percentile75
		else if(acceptRate > 20 && acceptRate <= 30) 
			   act = actPercentile75 * 1.1f; //for top 20-30 return 110% of Percentile75
		else if(acceptRate > 30 && acceptRate <= 40)
			   act = actPercentile75 * 1.05f; //for top 30-40 return 105% of Percentile75
		else if(acceptRate > 40 && acceptRate <= 50) 
			   act = actPercentile75 * 1.0f;  //for top 40-50 return 100% of Percentile75
		else if(acceptRate > 50 && acceptRate <= 60) 
			   act = actPercentile75 * 0.9f;  
		else if(acceptRate > 60 && acceptRate <= 70) //for top 40-60 return (Percentile25 + Percentile75)/2
			   act = actPercentile75 * 0.8f;  //for top 60-70 return 80% of Percentile75
			//adjustedActStandard = (actPercentile25 + actPercentile75)/2; //for top 50-60 return 90% of Percentile75
		else if(acceptRate > 70)                     //for top > 60 Percentile25
			   act = actPercentile25;
		adjustedActStandard = Math.round(act);
		return adjustedActStandard;
	}

	public void setAdjustedActStandard(Integer adjustedActStandard) {
		this.adjustedActStandard = adjustedActStandard;
	}
	
	@Transient
	public boolean isActScoreSatisfied(int actScore){
		if(getAdjustedActStandard() == 0 )
		   return false;	
		return (actScore >= getAdjustedActStandard());
	}
	*/
	
	@Column(name="SAT_ACT_Not_Required", length=5)
	public String getSatActNotRequired() {
		return satActNotRequired;
	}

	public void setSatActNotRequired(String satActNotRequired) {
		this.satActNotRequired = satActNotRequired;
	}

	@Column(name = "SAT2_Required")
	public Integer getNumberOfRequiredSat2() {
		return this.numberOfRequiredSat2;
	}

	public void setNumberOfRequiredSat2(Integer numberOfRequiredSat2) {
		this.numberOfRequiredSat2 = numberOfRequiredSat2;
	}
	
    @Column(name="Percentage_Classes_Fewer_Than_20_students", precision=12, scale=0)
    public Float getPercentageClassesFewerThan20Students() {
        return this.percentageClassesFewerThan20Students;
    }
    
    public void setPercentageClassesFewerThan20Students(Float percentageClassesFewerThan20Students) {
        this.percentageClassesFewerThan20Students = percentageClassesFewerThan20Students;
    }

    
    @Column(name="Percentage_Classes_More_Than_50_students", precision=12, scale=0)
    public Float getPercentageClassesMoreThan50Students() {
        return this.percentageClassesMoreThan50Students;
    }
    
    public void setPercentageClassesMoreThan50Students(Float percentageClassesMoreThan50Students) {
        this.percentageClassesMoreThan50Students = percentageClassesMoreThan50Students;
    }
    
    @Transient    
    public Float getPercentageClassesBetween25And50Students() {
		//return percentageClassesBetween25And50Students;
    	if(percentageClassesFewerThan20Students != null && percentageClassesFewerThan20Students > 0 &&
    	   percentageClassesMoreThan50Students != null && percentageClassesMoreThan50Students > 0)		
    	   percentageClassesBetween25And50Students = 100 - percentageClassesFewerThan20Students - percentageClassesMoreThan50Students;
    	   return percentageClassesBetween25And50Students;
    }

	public void setPercentageClassesBetween25And50Students(Float percentageClassesBetween25And50Students) {
		if(percentageClassesFewerThan20Students != null && percentageClassesFewerThan20Students > 0 &&
		   percentageClassesMoreThan50Students != null && percentageClassesMoreThan50Students > 0)		
		   percentageClassesBetween25And50Students = 100 - percentageClassesFewerThan20Students - percentageClassesMoreThan50Students;
		   this.percentageClassesBetween25And50Students = 100 - percentageClassesFewerThan20Students - percentageClassesMoreThan50Students;
	}

	@Column(name="SAT_ACT_Received_Deadline", length=10)
    public String getSatActReceivedDeadline() {
        return this.satActReceivedDeadline;
    }
    
    public void setSatActReceivedDeadline(String satActReceivedDeadline) {
        this.satActReceivedDeadline = satActReceivedDeadline;
    }

    
    @Column(name="Early_Decision_Deadline", length=10)
	public String getEarlyDecisionDeadline() {
		return earlyDecisionDeadline;
	}

	public void setEarlyDecisionDeadline(String earlyDecisionDeadline) {
		this.earlyDecisionDeadline = earlyDecisionDeadline;
	}

	@Transient
	public Integer getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(Integer maxResults) {
		this.maxResults = maxResults;
	}
 
	@Transient
	public Integer getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}
		
	@Column(name = "Accept_Rate")
	public Float getAcceptRate() {
		return this.acceptRate;
	}

	public void setAcceptRate(Float acceptRate) {
		this.acceptRate = acceptRate;
	}
	
	@Column(name = "Average_Freshman_Retention_Rate")
	public Integer getAverageFreshmanRetentionRate() {
		return averageFreshmanRetentionRate;
	}

	public void setAverageFreshmanRetentionRate(Integer averageFreshmanRetentionRate) {
		this.averageFreshmanRetentionRate = averageFreshmanRetentionRate;
	}

	@Column(name = "Six_Year_Graduation_Rate")
	public Integer getSixYearGraduationRate() {
		return sixYearGraduationRate;
	}

	public void setSixYearGraduationRate(Integer sixYearGraduationRate) {
		this.sixYearGraduationRate = sixYearGraduationRate;
	}

	@Column(name = "Rank_Overall")
	public Integer getRankOverall() {
		return this.rankOverall;
	}

	public void setRankOverall(Integer rankOverall) {
		this.rankOverall = rankOverall;
	}

	@Column(name = "Reputation_Score")
	public Float getReputationScore() {
		return this.reputationScore;
	}

	public void setReputationScore(Float reputationScore) {
		this.reputationScore = reputationScore;
	}

	@Column(name = "Selectivity", length = 15)
	public String getSelectivity() {
		return this.selectivity;
	}

	public void setSelectivity(String selectivity) {
		this.selectivity = selectivity;
	}

	@Column(name = "HS_Class_Top_10_Percentage")
	public Integer getHsClassTop10Percentage() {
		return this.hsClassTop10Percentage;
	}

	public void setHsClassTop10Percentage(Integer hsClassTop10Percentage) {
		this.hsClassTop10Percentage = hsClassTop10Percentage;
	}

	@Column(name = "Student_Faculty_Ratio")
	public Float getStudentFacultyRatio() {
		return this.studentFacultyRatio;
	}

	public void setStudentFacultyRatio(Float studentFacultyRatio) {
		this.studentFacultyRatio = studentFacultyRatio;
	}

	@Column(name = "Category", length = 40)
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "Calendar", length = 10)
	public String getCalendar() {
		return this.calendar;
	}

	public void setCalendar(String calendar) {
		this.calendar = calendar;
	}

	@Column(name = "phone", length = 15)
	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}
	
	@Column(name = "Website", length = 100)
	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Transient
	public Float getAnticipationIndex() {
		return anticipationIndex;
	}

	public void setAnticipationIndex(Float anticipationIndex) {
		this.anticipationIndex = anticipationIndex;
	}
	
	@Transient	
	public String getApplicationNote() {
		return applicationNote;
	}

	public void setApplicationNote(String applicationNote) {
		this.applicationNote = applicationNote;
	}

	public School() {
	}

	public School(String name) {
		this.name = name;
	}

	public School(Integer id, String name, String type, String city, String state,
			String setting, Integer size, Integer tuitionFee,
			Integer roomBoard, String applicationDeadline,
			Integer applicationFee, Integer toefl, Integer sat1Percentile25,
			Integer sat1Percentile75, Integer sat2, Float acceptRate,
			Integer rankOverall, Float reputationScore, String selectivity,
			Integer hsClassTop10Percentage, Float studentFacultyRatio,
			String category, String intFinacialAid, String calendar,
			String website) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.city = city;
		this.state = state;
		this.setting = setting;
		this.size = size;
		this.tuitionFee = tuitionFee;
		this.roomBoard = roomBoard;
		this.applicationDeadline = applicationDeadline;
		this.applicationFee = applicationFee;
		this.sat1Percentile25 = sat1Percentile25;
		this.sat1Percentile75 = sat1Percentile75;
		this.numberOfRequiredSat2 = sat2;
		this.acceptRate = acceptRate;
		this.rankOverall = rankOverall;
		this.reputationScore = reputationScore;
		this.selectivity = selectivity;
		this.hsClassTop10Percentage = hsClassTop10Percentage;
		this.studentFacultyRatio = studentFacultyRatio;
		this.category = category;
		this.calendar = calendar;
		this.website = website;
	}
	
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof School))
			return false;
		School castOther = (School) other;

		return ((this.getName() == castOther.getName()) || 
				(this.getName() != null	&& castOther.getName() != null && this.getName().equals(
				castOther.getName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "School [name=" + name + ", type=" + type + ", city=" + city
				+ ", state=" + state + ", setting=" + setting + ", size="
				+ size + ", tuitionFee=" + tuitionFee + ", roomBoard="
				+ roomBoard + ", applicationDeadline=" + applicationDeadline
				+ ", applicationFee=" + applicationFee 
				+ ", sat1Percentile25=" + sat1Percentile25 + ", sat1Percentile75="
				+ sat1Percentile75 + ", sat2=" + numberOfRequiredSat2 + ", acceptRate="
				+ acceptRate + ", rankOverall=" + rankOverall
				+ ", reputationScore=" + reputationScore + ", selectivity="
				+ selectivity + ", hsClassTop10Percentage=" + hsClassTop10Percentage
				+ ", studentFacultyRatio=" + studentFacultyRatio
				+ ", category=" + category + ", intFinacialAid="
				+ ", calendar=" + calendar + ", website="
				+ website + "]";
	}

	public static class RankComparator implements Comparator<School>{
	   public int compare(School school1, School school2){
		  int result = 1;
		  result = school1.getCategory().compareTo(school2.getCategory());
		  if(result > 1)
			 return 1;
		  
		  if(school1.getRankOverall() > 0){
		    try{
		       if(school1.getRankOverall() < school2.getRankOverall())
		    	  result = -1;
		       else if(school1.getRankOverall() > school2.getRankOverall())
		    	   result = 1;
		       else
		    	   result = 0;
		       
		      // if(result == 0){
		    	//  if(school1.getName().compareTo(school2.getName()) < 0)
		    		// result = -1; 
		    	  //else if(school1.getName().compareTo(school2.getName()) > 0)
			    	// result = 1;
		    	  //else
		    		//  result = 0;
		       //}  
		    }
		    catch(Exception e){
		 	   e.printStackTrace();
		 	   System.out.println("school1 name/rank="+school1.getName() + "/" +school1.getRankOverall());
		 	   System.out.println("school2 name/rank="+school2.getName() + "/" +school2.getRankOverall());
		    }	
	      } 
		  return result;
	   }
	}
	
	public static class NameComparator implements Comparator<School>{
	   public int compare(School school1, School school2){
		  return school1.getName().compareToIgnoreCase(school2.getName());
	   }
	}
}
