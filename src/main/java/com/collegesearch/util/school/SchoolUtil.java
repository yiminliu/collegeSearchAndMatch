package com.collegesearch.util.school;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.persistence.Transient;

public class SchoolUtil {

	public static String getValue(final LinkedHashMap<String, List<String>> queryParams, String searchKey) {	
	    Set<Map.Entry<String, List<String>>> set = queryParams.entrySet();
		Iterator<Entry<String, List<String>>> it = set.iterator(); 
		String key = null;
		String value = null;
		while(it.hasNext()) {
		   	Entry<String, List<String>> entry = (Entry<String, List<String>>)it.next();
		   	key = (String)entry.getKey();
		   	if(key.equalsIgnoreCase(searchKey)) {
		   		 try{
		   	         value = ((List<String>)entry.getValue()).get(0);
		   		 }
		   		 catch(ClassCastException cce) {
		   		   Object obj = entry.getValue();	
		   	       //if(obj instanceof String)
		   		   value = (String)obj;
		   		 }  
		   	}	
		} 
		return value;
	}

	public static int getMaxResults(final LinkedHashMap<String, List<String>> queryParams){
		int maxResults = 0;
		String data = getValue(queryParams, "maxResults");
		if(data != null && !data.isEmpty()){
			try {
			    maxResults = Integer.parseInt(data);
			}
			catch(NumberFormatException e){
				//e.printStackTrace();
			}
		}
		return maxResults;
	}
	
	public static boolean applicantDataExist(final LinkedHashMap<String, List<String>> queryParams){
		return getValue(queryParams, "toefl") !=null? true : 
			   getValue(queryParams, "itee") !=null? true : 
			   getValue(queryParams, "sat1Score") != null? true : 
			   getValue(queryParams, "actScore") !=null? true :	
			   getValue(queryParams, "gpa") !=null? true : false;
	}

	@Transient
	public static Integer adjustSchoolStandardforSatOrActScores(int percentile25, int percentile75, float acceptRate) {
		
		if(percentile25 <= 0 || percentile75 <= 0) {
		   return 0;
		}	
		float cap = 2100.0f;
		float percentile50 = (percentile25 + percentile75)/2.0f;
		float ajustedThreashold = 0.0f;
		if(acceptRate <= 10) 
			ajustedThreashold = ((percentile75) * 1.3f < cap? percentile75 * 1.2f : cap); //for top 10 return 120% of Percentile75;
		else if(acceptRate > 10 && acceptRate <= 20) 
			ajustedThreashold = percentile75 * 1.2f; //for top 10-25 return 115% of Percentile75
		else if(acceptRate > 20 && acceptRate <= 30) 
			ajustedThreashold = percentile75 * 1.15f; //for top 20-30 return 110% of Percentile75
		else if(acceptRate > 30 && acceptRate <= 40)
			ajustedThreashold = percentile75 * 1.1f; //for top 30-40 return 105% of Percentile75
		else if(acceptRate > 40 && acceptRate <= 50) 
			ajustedThreashold = percentile75 * 1.0f;  //for top 40-50 return 100% of Percentile75
		else if(acceptRate > 50 && acceptRate <= 60) 
			ajustedThreashold = ((percentile75 * 0.9f) > percentile50? (percentile75 * 0.9f) : percentile50);  
		else if(acceptRate > 60 && acceptRate <= 70) //for top 40-60 return (Percentile25 + Percentile75)/2
			ajustedThreashold = ((percentile75 * 0.8f) > percentile50? (percentile75 * 0.8f) : percentile50);    //for top 60-70 return 80% of Percentile75
			//adjustedActStandard = (percentile25 + percentile75)/2; //for top 50-60 return 90% of Percentile75
		else if(acceptRate > 70 && acceptRate <= 80)                     //for top > 60 Percentile25
			ajustedThreashold = ((percentile50 * 0.9f) > percentile25? (percentile50 * 0.9f) : percentile25);  
		else if(acceptRate > 80 && acceptRate <= 90)                     //for top > 60 Percentile25
			ajustedThreashold = ((percentile50 * 0.8f) > percentile25? (percentile50 * 0.8f) : percentile25);  
		else if(acceptRate > 90)
			ajustedThreashold = percentile25;
		return Math.round(ajustedThreashold);
	}
	
	@Transient
	public static Integer adjustSchoolStandardByConvertActToSatScores(int actPercentile25, int actPercentile75, float acceptRate) {
		
		if(actPercentile25 <= 0 || actPercentile75 <= 0) {
		   return 0;
		}	
		
		float cap = 2100.0f;
		int percentile25 = SchoolUtil.convertActToSat(actPercentile25);
		int percentile75 = SchoolUtil.convertActToSat(actPercentile75);
		float percentile50 = (percentile25 + percentile75)/2.0f;
		float ajustedThreashold = 0.0f;
		if(acceptRate <= 10) 
			ajustedThreashold = ((percentile75) * 1.3f < cap? percentile75 * 1.2f : cap); //for top 10 return 120% of Percentile75;
		else if(acceptRate > 10 && acceptRate <= 20) 
			ajustedThreashold = percentile75 * 1.2f; //for top 10-25 return 115% of Percentile75
		else if(acceptRate > 20 && acceptRate <= 30) 
			ajustedThreashold = percentile75 * 1.15f; //for top 20-30 return 110% of Percentile75
		else if(acceptRate > 30 && acceptRate <= 40)
			ajustedThreashold = percentile75 * 1.1f; //for top 30-40 return 105% of Percentile75
		else if(acceptRate > 40 && acceptRate <= 50) 
			ajustedThreashold = percentile75 * 1.0f;  //for top 40-50 return 100% of Percentile75
		else if(acceptRate > 50 && acceptRate <= 60) 
			ajustedThreashold = ((percentile75 * 0.9f) > percentile50? (percentile75 * 0.9f) : percentile50);  
		else if(acceptRate > 60 && acceptRate <= 70) //for top 40-60 return (Percentile25 + Percentile75)/2
			ajustedThreashold = ((percentile75 * 0.8f) > percentile50? (percentile75 * 0.8f) : percentile50);    //for top 60-70 return 80% of Percentile75
			//adjustedActStandard = (percentile25 + percentile75)/2; //for top 50-60 return 90% of Percentile75
		else if(acceptRate > 70 && acceptRate <= 80)                     //for top > 60 Percentile25
			ajustedThreashold = ((percentile50 * 0.9f) > percentile25? (percentile50 * 0.9f) : percentile25);  
		else if(acceptRate > 80 && acceptRate <= 90)                     //for top > 60 Percentile25
			ajustedThreashold = ((percentile50 * 0.8f) > percentile25? (percentile50 * 0.8f) : percentile25);  
		else if(acceptRate > 90)
			ajustedThreashold = percentile25;
		return Math.round(ajustedThreashold);
	}
	
	public static boolean isTestScoreSatisfied(int testScore, int percentile25, int percentile75, float acceptRate){
		int standardValue = 0;
		standardValue = adjustSchoolStandardforSatOrActScores(percentile25, percentile75, acceptRate);
		if(standardValue  == 0 )
		   return false;	
		else
		   return (testScore >= standardValue);
	}
	
	public static int convertActToSat(int act){
		int sat = 0;
		switch(act){
		   case 36:
			   sat = 1600;
			   break;
		   case 35:
			   sat = 1560;
			   break;
		   case 34:
			   sat = 1510;
			   break;
		   case 33:
			   sat = 1460;
			   break;
		   case 32:
			   sat = 1420;
			   break;
		   case 31:
			   sat = 1380;
			   break;
		   case 30:
			   sat = 1380;
			   break;	   
		   case 29:
			   sat = 1300;
			   break;
		   case 28:
			   sat = 1260;
			   break;
		   case 27:
			   sat = 1220;
			   break;
		   case 26:
			   sat = 1190;
			   break;
		   case 25:
			   sat = 1150;
			   break;
		   case 24:
			   sat = 1110;
			   break;	
		   case 23:
			   sat = 1070;
			   break;
		   case 22:
			   sat = 1030;
			   break;
		   case 21:
			   sat = 990;
			   break;	   
		   case 20:
			   sat = 950;
			   break;
		   case 19:
			   sat = 910;
			   break;
		   case 18:
			   sat = 870;
			   break;
		   case 17:
			   sat = 830;
			   break;
		   case 16:
			   sat = 790;
			   break;
		   case 15:
			   sat = 740;
			   break;
		   case 14:
			   sat = 690;
			   break;
		   case 13:
			   sat = 640;
			   break;
		   case 12:
			   sat = 590;
			   break;
		   case 11:
			   sat = 530;
			   break;
		   default:
			   sat = 0;
			   break;
		}
		return sat;
	}
}
