package textScript;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import org.testng.annotations.Test;

import com.crm.vtiger.genericUtils.BaseClass;

import POMPackage.ConvertLead;
import POMPackage.CreateLead;
import POMPackage.HomePage;
import POMPackage.Lead;
//import POMPackage.Login;
import POMPackage.Organisation;
import POMPackage.LeadInfoPage;

public class TCase_40 extends BaseClass{
	@Test(groups= {"smokeTest"})
	public void tcase_40() throws  Throwable
	{
       
	/*read test data*/
	   String firstName = elib.getExcelData("Sheet1", 1, 1);
	   String lasttName = elib.getExcelData("Sheet1", 1, 2);
	   String company = elib.getExcelData("Sheet1", 1, 3)+"_"+jlib.getRandomData();
	   
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
	   //cl.createLead1(firstName,lasttName,company);
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
	 
	   
	   //step 9: navigate to Lead module then click on Lead link
	   Organisation org = new Organisation(driver);
	   org.clickOnleadModule().click();
		Thread.sleep(5000);
		org.clickOnleadLink().click();
		Thread.sleep(5000);
		
	  //step 10: search for Last Name in Lead Page
		ld.searchCompany();
		ld.selectOption3();
		Thread.sleep(5000);
		ld.searchNowButton();
		
		 //step 12: verify whether Lead page displayed or not
		   ld.verifyResult(driver);
		   Thread.sleep(5000);
		  
	   
	} 
}
