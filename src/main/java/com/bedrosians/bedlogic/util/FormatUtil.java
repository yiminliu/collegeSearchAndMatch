package com.bedrosians.bedlogic.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtil {
  /*
	public static Object process(Object obj){
		String newString = "";
		if (obj != null) {
		   if(obj.getClass().isInstance(String.class)) {
			  return process((String)obj);
		   }
		   else if(obj.getClass().isInstance(Integer.class)) {
			   return process((Integer)obj);
		   }
		   else if(obj.getClass().isInstance(Long.class)) {
			   return process((Long)obj);
		   }
		   else if(obj.getClass().isInstance(Float.class)) {
			   return process((Float)obj);
		   }
		   else if(obj.getClass().isInstance(Date.class)) {
			   return process((Date)obj);
		   }
		}   
		return newString;
	}
	*/		
	public static String process(String data){
		
		if (data == null)
			return new String("");
		else {
			data = data.trim(); 
		    return new String(data);
		}    
	}
	
	public static Integer process(Integer data){
		Integer newInt = Integer.valueOf(0);
		if (data != null)
			newInt = Integer.valueOf((String.valueOf(data).trim()));
	    return newInt;
	}
	
	public static Long process(Long data){
		Long newData = Long.valueOf(0);
		if (data != null)
			newData = Long.valueOf((String.valueOf(data).trim()));
	    return newData;
	}
	
	public static Float process(Float data){
		Float newData = Float.valueOf(0);
		if (data != null)
			newData = Float.valueOf((String.valueOf(data).trim()));
	    return newData;
	}
		
	public static Date process(Date date) {
					
		if (date == null) {
			Date emptyDate = new Date();
			emptyDate.setTime(0);
			return emptyDate;
		}	
		else
			return date;
	}
}
