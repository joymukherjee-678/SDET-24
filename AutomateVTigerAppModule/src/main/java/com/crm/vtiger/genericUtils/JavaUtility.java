package com.crm.vtiger.genericUtils;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
 /*
  *  author @ joy
  */
 /**
  * This method is generate random number to avoid duplicates
  * @returns 
  */
 public static String getRandomData()
 {
	 Random random = new Random();
	 int ran=random.nextInt();
	 return ""+ran;
 }
 /**
  * @Joy
  * this method is used to generate currentdate
  * @return currentdate
  */
 public static String getCurrentDate()
 {
	 Date date=new Date();
	 String currentDate = date.toString();
	return currentDate;
	 
 }
}
