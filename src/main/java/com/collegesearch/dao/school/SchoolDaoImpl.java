package com.collegesearch.dao.school;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;




import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.search.query.dsl.TermContext;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.collegesearch.dao.GenericDaoImpl;
import com.collegesearch.domain.school.School;
import com.collegesearch.util.school.SchoolUtil;


@Repository("schoolDao")
public class SchoolDaoImpl extends GenericDaoImpl<School, Integer> implements SchoolDao {
						
	@Override
	public School getSchoolByName(String name) {
	   List<School> list = findByParameter("name", normalizeKey(name));
	   if(list != null && !list.isEmpty())
		  return list.get(0);
	   else return null;
	}
	
	@Override
	public School getSchoolByName(Session session, String name) {
		session.setCacheMode(CacheMode.REFRESH);
    	Query query = session.createQuery("From School where name = :name");
        query.setString("name", normalizeKey(name));
		//return (School)query.setCacheable(false).uniqueResult();
		return (School)query.uniqueResult();
	}
	
	@Override
	public List<School> getSchoolsByMatchNamePattern(String name) {
		return (List<School>)searchByKeywordQuery("name", name, "wildcard");
		//return (List<School>)searchByPhraseQuery("name", name);
	}
	
	@Override
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
	@SuppressWarnings("unchecked")
	public List<School> getSchools(LinkedHashMap<String,List<String>> queryParams){
	   if(queryParams == null) 
		  return null;
	   List<School> schools = null;
	   boolean exactMatch = queryParams.containsKey("exactmatch")? true : queryParams.containsKey("exactMatch")? true : false;
	   int maxResults = 0;
	   if(SchoolUtil.getValue(queryParams, "maxResults") != null) 
		  maxResults = Integer.valueOf(SchoolUtil.getValue(queryParams, "maxResults"));
	   Set<Map.Entry<String, List<String>>> entrySet = queryParams.entrySet();
	   Iterator<Map.Entry<String, List<String>>> it = entrySet.iterator();
	   DetachedCriteria internationalApplicationCriteria = null;
	   DetachedCriteria schoolCriteria = DetachedCriteria.forClass(School.class);
	   String key, value = null;
	   List<String> values = null;
	   String stringValue = null;
    		
	   while(it.hasNext()) {
		    //--------------- Process the input data --------------//
	     	Entry<String, List<String>> entry = (Entry<String, List<String>>)it.next();
	 	    key = normalizeKey((String)entry.getKey());
	 	    if(key == null || key.isEmpty())
	           continue;
	 	    value = null;
	 	    Object obj = entry.getValue();
	 	    if(obj instanceof String)
	 	    	value = (String)obj;
	 	    else
	   	   	   values = (List<String>)entry.getValue();
	  	   	if((values == null || values.isEmpty()) && value == null)
	 	   	   continue;
	 	   	else if(values != null && values.size() == 1 && values.toString().contains(",")) { //the input contains multiple values for a key, but in String format
	 	   		stringValue = values.toString();
	 	   		stringValue =stringValue.substring(stringValue.indexOf("[")+1);
	 	     	stringValue =stringValue.substring(0, stringValue.lastIndexOf("]"));
	 	   		values = Arrays.asList(stringValue.split(","));  
	 	   	}
	  	    //if((values != null && !values.isEmpty()) && value == null)
	  	    if(values != null && !values.isEmpty())	
	        value = values.get(0) == null? values.get(0) : values.get(0).trim();
	        if(value == null || value.isEmpty())
	           continue;	
	        if(key.equalsIgnoreCase("rankOverall") && value.startsWith("Top"))
	           value = value.substring(4);
	        if(key.equalsIgnoreCase("acceptRate") && value.endsWith("%"))
		       value = value.replace("%", "");
	        if((key.equalsIgnoreCase("tuitionFee") || key.equalsIgnoreCase("roomBoard")) && value.startsWith("<"))
		       value = value.substring(2);
	       
	        //----------- Compose hibernate criteria -------------//
	 		//------ conditional pattern match -------//
    		if(!exactMatch && ("itemcode".equalsIgnoreCase(key) || ("material.materialcategory".equalsIgnoreCase(key)))){
    		   if(values != null && values.size() > 1)	
    			   schoolCriteria = generateWildcardDisjunctionCriteria(schoolCriteria, key, values);
    		   else
    			   schoolCriteria.add(Restrictions.ilike(key, value.toUpperCase(), MatchMode.START));
	           continue;
            }
    		//------ unconditional pattern match -------//
   	     
		    if("itemdesc.fulldesc".equalsIgnoreCase(key) || "itemdesc.itemdesc1".equalsIgnoreCase(key) || "colorcategory".equalsIgnoreCase(key)){
		      	if(values != null && values.size() > 1)	
	     		   schoolCriteria = generateWildcardDisjunctionCriteria(schoolCriteria, key, values);
	     		else
			       schoolCriteria.add(Restrictions.ilike(key, value, MatchMode.ANYWHERE));
			    continue;
		    }  	
	        //----- take care of multiple values case other than "size" ------//
	 	   	if(!"size7".equals(key) && (values != null && values.size() > 1)){
	 	   	    schoolCriteria =  generateEqualsDisjunctionCriteria(schoolCriteria, key, values); //Case insensitive
	 		    continue;
	 	   	}  
    		//------- add association criteria --------//
	 	  // 	if(SchoolNewFeature.allProperties().contains(key) && value != null && !value.isEmpty()) {	
	   	  //	   if(newFeatureCriteria == null)
	      //	      newFeatureCriteria = schoolCriteria.createCriteria("newFeature", JoinType.LEFT_OUTER_JOIN);
	   	  //     newFeatureCriteria = addNewFeatureRestrictions(newFeatureCriteria, key, value);
	      // 	   continue;
		  //  }
	 	  //newFeatureCriteria.add(Restrictions.eq(key, Grade.instanceOf(value)));
	 	  
	 	   	switch(key) {
	  	   	   case "rankOverall": case "tuitionFee": case "roomBoard": 
	 	   		   schoolCriteria.add(Restrictions.le(key, Integer.parseInt(value))); 
	 	   		   break;
	  	   	   case "applicationFee":	
	  	   		   schoolCriteria.add(Restrictions.eq(key, Integer.parseInt(value))); 
	  	   		   break;
	  	       //case "totalCost": 
	 	   	   //	   schoolCriteria.add(Restrictions.le(sum("tuitionFee", "roomBoard"), Integer.parseInt(value))); 
	 	   	   //	   break;
	 	   	   case "toefl":
	 	   	       schoolCriteria.add(Restrictions.le(key, Integer.parseInt(value))); 
	 	   	       schoolCriteria.add(Restrictions.gt(key, 0)); 
		   	       break;
	 	       case "internationalStudentApplication.ieltsScore":
		 		   key = "minimumIeltsScore"; 
		 		   if(internationalApplicationCriteria == null)
		 			  internationalApplicationCriteria = schoolCriteria.createCriteria("internationalStudentApplication", JoinType.LEFT_OUTER_JOIN);
		 	       internationalApplicationCriteria.add(Restrictions.le(key, Integer.parseInt(value)));
		 	       internationalApplicationCriteria.add(Restrictions.gt(key, 0));
		 		   break;   
		       case "internationalStudentApplication.toeflScore":
		 		   key = "minimumToeflScore"; 
		 		   if(internationalApplicationCriteria == null)
		 			  internationalApplicationCriteria = schoolCriteria.createCriteria("internationalStudentApplication", JoinType.LEFT_OUTER_JOIN);
		 	       internationalApplicationCriteria.add(Restrictions.le(key, Integer.parseInt(value)));
		 	       internationalApplicationCriteria.add(Restrictions.gt(key, 0));
		   	       break;  
		       case "internationalStudentApplication.toeflAcceptedInsteadOfSatOrAct":
			       key = "toeflAcceptedInsteadOfSatOrAct"; 
				   if(internationalApplicationCriteria == null)
				   	  internationalApplicationCriteria = schoolCriteria.createCriteria("internationalStudentApplication", JoinType.LEFT_OUTER_JOIN);
				   internationalApplicationCriteria.add(Restrictions.eq(key, value).ignoreCase()); 
				   break;   
		       case "internationalStudentApplication.conditionalAdmissionOffered":
		    	   key = "conditionalAdmissionOffered"; 
			 	   if(internationalApplicationCriteria == null)
			 		  internationalApplicationCriteria = schoolCriteria.createCriteria("internationalStudentApplication", JoinType.LEFT_OUTER_JOIN);
			 	   internationalApplicationCriteria.add(Restrictions.eq(key, value).ignoreCase()); 
			   	   break;  
		       case "sat1Score": case "actScore": case "exactMatch": case "maxresults": case "maxResults": case "totalCost": case "submit":
 	   		       break;  
		       case "size": case "acceptRate":   
 	   		       if(value.indexOf("between") >= 0){
 		              String lowerValue = value.substring(value.indexOf("between") + 8, value.indexOf("and")-1);
 		           String upperValue = value.substring(value.indexOf("and") + 4);
 		           if(key.equalsIgnoreCase("size")){
 		              schoolCriteria.add(Restrictions.le(key, Integer.parseInt(upperValue)));
 		              schoolCriteria.add(Restrictions.gt(key, Integer.parseInt(lowerValue))); 
 		           }
 		           else if(key.equalsIgnoreCase("acceptRate")){
			        	 schoolCriteria.add(Restrictions.le(key, Float.parseFloat(upperValue)));
			        	 schoolCriteria.add(Restrictions.gt(key, Float.parseFloat(lowerValue)));
 		           }
 		         }
 	   		     else if(value.indexOf("<") >= 0) {
 			          if(key.equalsIgnoreCase("size")){
 			        	 value = value.substring(value.indexOf("<") + 1, value.indexOf(")")); 
 			             schoolCriteria.add(Restrictions.le(key, Integer.parseInt(value))); 
 			          }
 			          else if(key.equalsIgnoreCase("acceptRate")){
 			        	 value = value.substring(value.indexOf("<") + 1);
 			             schoolCriteria.add(Restrictions.le(key, Float.parseFloat(value)));
 			          }   
 	   		     }
 	   		     else if(value.indexOf(">") >= 0){
 	   		    	  if(value.indexOf(")") >= 0)
 				         value = value.substring(value.indexOf(">") + 1, value.indexOf(")"));
 	   		    	  else
 	   		    		value = value.substring(value.indexOf(">") + 1); 
 				      if(key.equalsIgnoreCase("size"))
 			             schoolCriteria.add(Restrictions.gt(key, Integer.parseInt(value))); 
 			          else if(key.equalsIgnoreCase("acceptRate"))
 			            	 schoolCriteria.add(Restrictions.gt(key, Float.parseFloat(value)));
 			     }	 
 	   		     else
 	   		    	schoolCriteria.add(Restrictions.eq(key, Float.parseFloat(value)));
 	   		     break; 
	 	   	   default:     
	 	   		   schoolCriteria.add(Restrictions.eq(key, value).ignoreCase());
	 	   		   break;
	 	   	}	      	    	
	    }
        schoolCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        //schoolCriteria.addOrder(Order.asc("itemcode"));
        System.out.println("getItemsByQueryParameters() using criteria = " +schoolCriteria.toString());
        System.out.println("maxResults="+maxResults);
		try {
			//if(maxResults > 0) 
		    //   schools =  (List<School>)schoolCriteria.getExecutableCriteria(getSession()).setLockMode(LockMode.NONE).setFlushMode(FlushMode.COMMIT).setMaxResults(maxResults).setCacheable(true).list();//executeCriteria(schoolCriteria);//(List<Product>)schoolCriteria.list();			
			//else
			   schools =  (List<School>)schoolCriteria.getExecutableCriteria(getSession()).setLockMode(LockMode.NONE).setFlushMode(FlushMode.COMMIT).setCacheable(true).list();	
		}
		catch(Exception e){
		     throw e;	
		}
		System.out.println(schools == null? 0 : schools.size() + " schools returned");       
        return schools;	
    }
	
	
	//The purpose of this method is to compare the performance of Hibernate Search and regular Hibernate query 
	//@Override
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
	@SuppressWarnings("unchecked")
    public List<School> searchSchoolByNameByLuceneQuery(String name){
	   FullTextSession fullTextSession = Search.getFullTextSession(getSession());
		
	   QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(School.class).get();
	   // create native Lucene query
	   org.apache.lucene.search.Query luceneQuery = queryBuilder.bool()
		   	                                       //.must(queryBuilder.keyword().onField("inactivecode").matching("N  ").createQuery())//School table uses char type which may need some padding to match index id 
	   	                                           .must(queryBuilder.keyword().onField("name").matching(name).createQuery()).createQuery();   
	   // wrap Lucene query in a javax.persistence.Query
	   org.hibernate.Query fullTextQuery = fullTextSession.createFullTextQuery(luceneQuery, School.class); 
	   
	   return (List<School>)fullTextQuery.list();     
	}
    
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
	@SuppressWarnings("unchecked")
    public List<School> searchByKeywordQuery(String field, String keyword, String searchType){
	   FullTextSession fullTextSession = Search.getFullTextSession(getSession());
	   //create query builder	
	   QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(School.class).get();
	   // create native Lucene keyword query
	   org.apache.lucene.search.Query luceneQuery = null;
	   TermContext termContext = queryBuilder.keyword();
	   switch(searchType) {
	     case("wildcard"):
		     luceneQuery = termContext.wildcard().onField(field).boostedTo(3).matching("*"+keyword+"*").createQuery();
		     break;
	     case("fuzzy"):
		     luceneQuery = termContext.fuzzy().withThreshold(0.75f).onField(field).boostedTo(3).matching(keyword).createQuery();
		     break;
	     case("keyword"): default:    
			 luceneQuery = termContext.onField(field).boostedTo(3).matching(keyword).createQuery();
	   }
	   // wrap Lucene query in a javax.persistence.Query
	   org.hibernate.Query fullTextQuery = fullTextSession.createFullTextQuery(luceneQuery, School.class).setCacheable(true);
	   // retrieve item list
	   return (List<School>)fullTextQuery.list();     
	}
	
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
	@SuppressWarnings("unchecked")
    public List<School> searchByPhraseQuery(String field, String keyword){
	   FullTextSession fullTextSession = Search.getFullTextSession(getSession());
	   //create query builder	
	   QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(School.class).get();
	   // create native Lucene keyword query
	   org.apache.lucene.search.Query luceneQuery = queryBuilder.phrase()
			      .withSlop(4)
			      .onField(field).boostedTo(3)
			      .sentence(keyword)
			      .createQuery();	 
	   // wrap Lucene query in a javax.persistence.Query
	   org.hibernate.Query fullTextQuery = fullTextSession.createFullTextQuery(luceneQuery, School.class).setCacheable(true);
	   // retrieve item list
	   return (List<School>)fullTextQuery.list();     
	}
	
	@Override
	public void updateSchool(Session session, School school){
		update(session, school.getId(), school);
	}
	  
	@Override
	public Integer createSchool(School school){
		return (Integer)save(school);  
	}
	
	@Override
	public void deleteSchool(School school){
		delete(school);
	}
	
	//------------------- internal helper methods ------------------//
	
		private String normalizeKey(String key){
	       switch(key) {
	      
			  case "Intl_Financial_Aid": 
		   		 key = "internationalFinancialAid";
		   		 break;
			  case "Washington University in St":
		 		 key = "Washington University in St. Louis"; 
		   	     break;
			  //case "internationalStudentApplication.ieltsScore":
			  //		 key = "internationalStudentApplication.minimumIeltsScore"; 
			  // 	     break;   
			  //case "internationalStudentApplication.toeflScore":
			  //		 key = "internationalStudentApplication.minimumToeflScore"; 
			  // 	     break;  	     
		   	  case "itemdesc1": case "itemDesc1":
			   	 key = "itemdesc.itemdesc1";
			   	 break;
			 
			  case "colorhues": case "colorHues": case "colorhue": case "colorHue": 
	   		     key = "colorHue";
	   		     break;
			  case "_colorhues": case "_material":
		   	     key = "";
		   		 break;
		      case "purchaser":	
		   		 key = "purchasers.purchaser";
		   		 break;
		      case "cost": 
		   		 key = "cost.cost";
				 break;	 
		      case "cost1": 
			   	 key = "cost.cost1";
				 break;	
		      case "newFeature.status": 
			   	 key = "status";
				 break;	 
	       }
	       if(key.endsWith("_colorHue")){
	    	   if(!key.endsWith("_colorhues"))
	    	       key ="colorHue";
	    	   else
	    		   key = "";
	       }	   
	        return key;
		}    
				
		
	   private DetachedCriteria generateWildcardDisjunctionCriteria(DetachedCriteria criteria, String name, List<String> values){
		    Disjunction or = Restrictions.disjunction();
			for(String value : values) {
				if("colorcategory".equalsIgnoreCase(name) || name.startsWith("itemdesc"))
				   or.add(Restrictions.ilike(name, value, MatchMode.ANYWHERE));
				else
				   or.add(Restrictions.ilike(name, value, MatchMode.START));
		    }  
		   	criteria.add(or);
			return criteria;
	   }	
		
	   private DetachedCriteria generateEqualsDisjunctionCriteria(DetachedCriteria criteria, String name, List<String> values){
		    Disjunction or = Restrictions.disjunction();
			for(String value : values) {
				or.add(Restrictions.eq(name, value.trim()).ignoreCase());
		    }  
		   	criteria.add(or);
			return criteria;
	   }	
}
