package com.crm.vtiger.genericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

//import Demo.FileReader;

public class FileUtility {
/*
 * author @Joy
 * 
 */
/**
 * method to read data from Properties and return the value based on key specified	
 * @param key
 * @return
 * @throws Throwable
 */
	@Test
	public String getPropertyKeyValue(String key) throws IOException {

		/*read the data from properties file*/
		//step 1: get the java representation object of the physical file*/
		FileInputStream fis=new FileInputStream(IPathConstant.PROPERTY_FILEPATH);
		//step 2: create an object of the properties class & load the all keys:value pair
		Properties pobj = new Properties();
	 	pobj.load(fis);
		return pobj.getProperty(key);

		}	
	
/**
 * method to read data from Json and return the value based on key specified	
 * @param jsonKey
 * @return
 * @throws IOException, ParseException
 */	
		public String getDataFromJson(String jsonKey) throws IOException, ParseException {
		
		//	 get Java representative object of physical file
		    java.io.FileReader reader = new java.io.FileReader(IPathConstant.JSONFILEPATH);
		// JSONParser object is created for parsing purpose
		    JSONParser parser = new JSONParser();
		// parsing JSON object into corresponding Java object
		  Object object = parser.parse(reader);
		// create JSON object
		  JSONObject jsonObject = (JSONObject)object;
		// get all the data from JSON file
		 String value = jsonObject.get(jsonKey).toString();
		 return value;
		
		}


	
}
