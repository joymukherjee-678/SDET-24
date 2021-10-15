package Demo;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Object;

public class ReadDataFromJsonFile {
 @Test
  /**
   * This Method will print Json value based on Json key 
   * @throws throwable 
   */
   public void getDataFromJson() throws Throwable{
  /*	 get Java representative object of physical file
     FileReader reader = new FileReader("./Data/CommonData.json");
     // JSONParser object is created for parsing purpose
     JSONParser parser = new JSONParser();
     // parsing JSON object into corresponding Java object
     Object object = parser.parse(reader);
     // create JSON object
     JSONObject jsonObject = (JSONObject)object;
     // get all the data from JSON file
     String Url = jsonObject.get("url").toString();
     String Browser = jsonObject.get("browser").toString();
     String US = jsonObject.get("username").toString();
     String Password = jsonObject.get("password").toString();
	 System.out.println(Url);
	 System.out.println(Browser);
	 System.out.println(US);
	 System.out.println(Password); */
	 
	 // -------------------------------------------------------------------------------
	 
	 //read the data from json file
	 FileReader file = new FileReader("./Data/CommonData.json");
	 
	 //convert the json file into java project
	 JSONParser jsonobj = new JSONParser();
	 java.lang.Object jobj = jsonobj.parse(file);
	 
	 //type cast java ob to hashmap
	 HashMap map = (HashMap)jobj;
	 String USERNAME = map.get("username").toString();
	 System.out.println(USERNAME);
	 String PASSWORD = map.get("password").toString();
	 System.out.println(PASSWORD);
	 String URL = map.get("url").toString();
	 System.out.println(URL);
   } 
 
    
}
