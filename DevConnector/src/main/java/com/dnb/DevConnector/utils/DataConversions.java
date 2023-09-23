package com.dnb.DevConnector.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataConversions {
public static String arrayToString(List<String> arr) {
	  String result = String.join(",", arr);
	  return result;
}

public List<String> StringToArray(String str){
	 ArrayList<String> list = new ArrayList<>(Arrays.asList(str.split(",")));
	 return list;
}
}
