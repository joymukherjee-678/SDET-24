package textScript;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.vtiger.genericUtils.ExcelUtility;
import com.crm.vtiger.genericUtils.FileUtility;
import com.crm.vtiger.genericUtils.IPathConstant;
import com.crm.vtiger.genericUtils.JavaUtility;
import com.crm.vtiger.genericUtils.WedDriverUtility;

import POMPackage.ConvertLead;
import POMPackage.CreateLead;
import POMPackage.HomePage;
import POMPackage.Lead;
import POMPackage.LeadInfoPage;
import POMPackage.Login;
import POMPackage.Organisation;

public class TC_40SearchLeadByClickingOnCompany  {
static {
		
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");  
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver1.exe");
		System.setProperty("webdriver.opera.driver", "./driver/operadriver.exe");
	}

    @Test
	public void SearchLeadByClickingOnLastName() throws  Throwable
	{
    	FileInputStream ff =new FileInputStream(IPathConstant.EXCELPATH);
    	Workbook workbook = WorkbookFactory.create(ff);
    //	System.out.println(workbook.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue());
    //	System.out.println(workbook.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue());
    //	System.out.println(workbook.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue());
    	
    	ExcelUtility excel= new ExcelUtility();
        
    	
    	String dat = excel.getExcelData("Sheet1", 11, 1);
    	String dat1 = excel.getExcelData("Sheet1", 11, 2);
    	String dat2 = excel.getExcelData("Sheet1", 11, 3);
    	
    	System.out.println(dat);
    	System.out.println(dat1);
    	System.out.println(dat2);
    	//WebDriver driver = new FirefoxDriver();
    	WebDriver driver = new ChromeDriver();
    	//WebDriver driver = new OperaDriver();
    /*	FileUtility file = new FileUtility();*/	WedDriverUtility wbutility = new WedDriverUtility();
    	
    	Login login = new Login(driver);
    /*	String url=file.getDataFromJson("url");
    	String username=file.getDataFromJson("username");
    	String password = file.getDataFromJson("password");
    	driver.get(url); */
    	
    	login.enterURL(driver);
    	login.loginAction();
    	
    	
    	
  /*  	driver.findElement(By.xpath("//input[@type='text' and @name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password' and @name='user_password']")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click(); */
		Thread.sleep(5000);
		HomePage hm = new HomePage(driver);
		hm.clickOnLead();
	/*	driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
		wbutility.SelectOption(driver.findElement(By.name("salutationtype")),"Mr."); */
		Thread.sleep(5000);
		Lead lp = new Lead(driver);
		lp.createLead();
		Thread.sleep(5000);
		CreateLead cl = new CreateLead(driver);
	//	cl.selectOptions();
		Thread.sleep(5000);
	//	String dat = excel.getExcelData("Sheet1", 1, 1);
		cl.components(dat,dat1,dat2);
	//	driver.findElement(By.name("firstname")).sendKeys(dat);
	//	fn = driver.findElement(By.name("firstname")).getText();
	//	String data2 = excel.getExcelData("Sheet1", 1, 2);
	//	driver.findElement(By.name("lastname")).sendKeys(dat1);
	//	String data3 = excel.getExcelData("Sheet1", 1, 3);
	 //   driver.findElement(By.name("company")).sendKeys(dat2);
	/*	driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		driver.switchTo().alert().accept(); */
		Thread.sleep(5000);
		LeadInfoPage lip =new LeadInfoPage(driver);
		//String ldn = lip.leadAddress();
		lip.convertLead();
		Thread.sleep(5000);
		ConvertLead cvl = new ConvertLead(driver);
		cvl.popUp(driver);
		Thread.sleep(5000);
		Organisation org = new Organisation(driver);
		org.clickOnleadModule().click();
		Thread.sleep(5000);
		org.clickOnleadLink().click();
		Thread.sleep(5000);
		//TC_36ConvertLeadToOpertuinitiesBySelectingAllTheCheckboxsAndChangeLastName tc= new TC_36ConvertLeadToOpertuinitiesBySelectingAllTheCheckboxsAndChangeLastName();
		//String idn =tc.leadno();
		Lead ld = new Lead(driver);
		Thread.sleep(5000);
		ld.searchCompany();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(ldn);
		//Lead ld1 = new Lead(driver);
		ld.selectOption3();
		Thread.sleep(5000);
		//Lead ld = new Lead(driver);
		ld.searchNowButton();
		//wbutility.SelectOption(driver.findElement(By.name("search_field")),0);
		//driver.findElement(By.xpath("//input[@value=' Search Now ']")).click();;
		Thread.sleep(5000);
		ld.verifyResult(driver);
		Thread.sleep(5000);
		hm.logout(driver).click();
	  /*	String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
		String ExpectedTitle = "Administrator - Leads - vtiger CRM 5 - Commercial Open Source CRM";
		SoftAssert s = new SoftAssert();
		s.assertEquals(ActualTitle, ExpectedTitle); */
	/*	WebElement moveElement=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wbutility.mouseOver(driver, moveElement);
		//a.moveToElement(moveElement).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		s.assertAll(); */
}
}

