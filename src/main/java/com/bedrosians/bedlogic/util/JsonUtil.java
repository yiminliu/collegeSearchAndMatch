package com.bedrosians.bedlogic.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
//import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonUtil<ObjectT> {
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static String toJson(Object obj){
		mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
		mapper.setSerializationInclusion(Include.NON_NULL);
		//mapper.getSerializerProvider().setNullKeySerializer(new MyNullKeySerializer());
		  
		String jSon = "";
		try{
		   jSon = mapper.writeValueAsString(obj);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return jSon;
	}
	
	static class MyNullKeySerializer extends JsonSerializer<Object>
	{
	  @Override
	  public void serialize(Object nullKey, JsonGenerator jsonGenerator, SerializerProvider unused) 
	      throws IOException, JsonProcessingException
	  {
	    jsonGenerator.writeFieldName("");
	  }
	}
}
