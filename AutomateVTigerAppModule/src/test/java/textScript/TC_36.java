package textScript;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.genericUtils.BaseClass;
import com.crm.vtiger.genericUtils.DriverPathConstant;
import com.crm.vtiger.genericUtils.ExcelUtility;
import com.crm.vtiger.genericUtils.FileUtility;
import com.crm.vtiger.genericUtils.JavaUtility;
import com.crm.vtiger.genericUtils.WedDriverUtility;

import POMPackage.ConvertLead;
import POMPackage.CreateLead;
import POMPackage.HomePage;
import POMPackage.Lead;
import POMPackage.LeadInfoPage;
import POMPackage.Login;
import POMPackage.Organisation;

public class TC_36 extends BaseClass{
	
static {
		
		System.setProperty("webdriver.gecko.driver", DriverPathConstant.FIREFOX_DRIVER_PATH);  
		System.setProperty("webdriver.chrome.driver", DriverPathConstant.CHROME_DRIVER_PATH);
		System.setProperty("webdriver.opera.driver", DriverPathConstant.OPERA_DRIVER_PATH);
	}
	
	@Test
	public void tc_36() throws  Throwable
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
	   String firstName = elib.getExcelData("Sheet1", 1, 1);
	   String lasttName = elib.getExcelData("Sheet1", 1, 2);
	   String company = elib.getExcelData("Sheet1", 1, 3)+"_"+jlib.getRandomData();
	   
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
	   lp.login(USERNAME,PASSWORD);
	   
	   //step 3: navigate to Home page
	   HomePage hp = new HomePage(driver);
	   hp.clickOnLead1().click();
	   
	  //step 4: navigate to create Lead page
	   Lead ld = new Lead(driver);
	   ld.createLead1().click();
	   
	  //step 5: create Lead
	   CreateLead cl =new CreateLead(driver);
	   cl.dropDown();
	   cl.getFirstName().sendKeys(firstName);
	   cl.getlastName().sendKeys(lasttName);
	   cl.getCompanyName().sendKeys(company);
	   cl.clickOnButton().click();
	  // cl.createLead1(firstName,lasttName,company);
	   Thread.sleep(5000);
	   
	   //step 6: verify
	   LeadInfoPage lip = new LeadInfoPage(driver);
	   String fn = lip.getFirstName().getText();
	   String ln = lip.getLastName().getText();
	   String com = lip.getCompanyName().getText();
	   if(fn.equals(firstName)&&ln.equals(lasttName)&& com.equals(company))
	   {
		   
		   System.out.println("Lead Information created sucessfully");
		   //Thread.sleep(5000);
	   }
	   else
		   System.out.println("not created sucessfully");
	   
	   //step 7: convert Lead
	   lip.convertLead();
	   Thread.sleep(5000);
	   ConvertLead cvl = new ConvertLead(driver);
	   cvl.popUp(driver);
	   Thread.sleep(5000);
	   
	   //step 8: verify whether organization page displayed or not
	   Organisation org = new Organisation(driver);
	   org.verifyResult(driver);
	   Thread.sleep(5000);
	   
	   //step 9: logout
	   hp.logout(driver).click();
	   
	   //step 10: close the browser
	   driver.close(); 
	   
	} 
	
	
	   
}

