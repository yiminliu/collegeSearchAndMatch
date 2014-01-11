package com.bedrosians.bedlogic.util;

public class FormatUtil {

	public static String trimAndReplicate(String oriString){
		if (oriString != null) oriString = oriString.trim(); 
		return new String(oriString);
	}
}
