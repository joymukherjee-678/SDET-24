package com.vtiger.comcast.organizationtest;

import java.io.IOException;

import org.apache.commons.collections4.map.StaticBucketMap;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.vtiger.genericUtils.ExcelUtility;
import com.crm.vtiger.genericUtils.FileUtility;
import com.crm.vtiger.genericUtils.JavaUtility;
import com.crm.vtiger.genericUtils.WedDriverUtility;
import com.crm.vtiger.genericUtils.BaseClass;
import com.mysql.cj.jdbc.Driver;
import com.vtiger.comcast.pomreposityLib.CreateNewOrganization;
import com.vtiger.comcast.pomreposityLib.Home;
import com.vtiger.comcast.pomreposityLib.Login;
import com.vtiger.comcast.pomreposityLib.OrganizationInfo;
import com.vtiger.comcast.pomreposityLib.Organizations;

public class CreateOrganization extends BaseClass{

	 

	public static void main(String[] args)  throws Throwable
	  {
		// create Objects
		   ExcelUtility elib = new ExcelUtility();
		   FileUtility flib = new FileUtility();
		   JavaUtility jlib = new JavaUtility();
		   WedDriverUtility wlib = new WedDriverUtility(); 
		   WebDriver driver = null;
		   
		   /*read common data */
		   String BROWSER = flib.getDataFromJson("browser");
		   String URL =     flib.getDataFromJson("url");
		   String USERNAME = flib.getDataFromJson("username");
		   String PASSWORD = flib.getDataFromJson("password");
		   
		   /*read test data*/
		  // String orgName = elib.getExcelData("Sheet1", 1, 1);
		  // String lasttName = elib.getExcelData("Sheet1", 1, 2);
		   String orgName = elib.getExcelData("Sheet1", 19, 1)+"_"+jlib.getRandomData();
		   
		   // step 1: launch the browser
		   if(BROWSER.equals("firefox"))
			   
		   {
			   driver = new FirefoxDriver();
		   }
		   else if(BROWSER.equals("chrome")) {
			   driver = new ChromeDriver();
		   }
		   else if(BROWSER.equals("ie")) {
			   driver = new InternetExplorerDriver();
		   } 
	             	   
		   //step 2: login to app
		   wlib.waitUntilPageLoad(driver);
		   driver.get(URL);
		   Login lp = new Login(driver);
		   lp.loginToApp(USERNAME,PASSWORD);
		   
		   //step 3: navigate to Org
		   Home hp = new Home(driver);
		   hp.getOrganizationLink().click();
		   
		   //step 4: navigate to create Org Page
		   Organizations op = new Organizations(driver);
		   op.getCreateOrgImg();
		   
		   //step 5: create org
		   CreateNewOrganization cnop = new CreateNewOrganization(driver);
		   cnop.createOrg(orgName);
		   
		   //step 6: verify
		   OrganizationInfo oinfop = new OrganizationInfo(driver);
		   wlib.waitForElementVisibility(driver, oinfop.getSuccesfullMsg());
		   String actSucMsg = oinfop.getSuccesfullMsg().getText();
		   if(actSucMsg.contains(orgName)) {
			   System.out.println("org is created successfully==>PASS");
		   }
		   else {
   					System.out.println("org is not created successfully==>FAIL");
		   }
		   
		   //Step 7: logout
		   hp.logout();
	  }
		
	

}
