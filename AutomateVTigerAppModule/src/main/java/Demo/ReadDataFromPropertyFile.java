package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadDataFromPropertyFile {
@Test
public void readDataFromPropertyFile() throws IOException
{
	/*read the data from properties file*/
	//step 1: get the java representation object of the physical file*/
	FileInputStream fis=new FileInputStream("./data/CommonData.properties");
	//step 2: create an object of the properties class & load the all keys:value pair
	Properties pobj = new Properties();
	pobj.load(fis);
	//step 3:read the value using getProperty("key")
	String URL = pobj.getProperty("url");
	String BROWSER = pobj.getProperty("browser");
	String US = pobj.getProperty("username");
	String PASSWORD = pobj.getProperty("password");
	System.out.println(URL);
	System.out.println(BROWSER);
	System.out.println(US);
	System.out.println(PASSWORD);
	
}
	
}



