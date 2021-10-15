package textScript;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.vtiger.genericUtils.DriverPathConstant;
import com.crm.vtiger.genericUtils.ExcelUtility;
import com.crm.vtiger.genericUtils.FileUtility;
import com.crm.vtiger.genericUtils.IPathConstant;
import com.crm.vtiger.genericUtils.WedDriverUtility;

import POMPackage.ConvertLead;
import POMPackage.CreateLead;
import POMPackage.HomePage;
import POMPackage.Lead;
import POMPackage.LeadInfoPage;
import POMPackage.Login;
import POMPackage.Organisation;

public class TC_36ConvertLeadToOpertuinitiesBySelectingAllTheCheckboxsAndChangeLastName {
	
static {
		
		System.setProperty("webdriver.gecko.driver", DriverPathConstant.FIREFOX_DRIVER_PATH);  
		System.setProperty("webdriver.chrome.driver", DriverPathConstant.CHROME_DRIVER_PATH);
		System.setProperty("webdriver.opera.driver", DriverPathConstant.OPERA_DRIVER_PATH);
	}

    @Test
	public void convertLeadToOpportuinities() throws  Throwable
	{
    	
    	
        FileInputStream ff =new FileInputStream(IPathConstant.EXCELPATH);
    	Workbook workbook = WorkbookFactory.create(ff);
    //	System.out.println(workbook.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue());
    //	System.out.println(workbook.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue());
    //	System.out.println(workbook.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue());
    	
    	ExcelUtility excel= new ExcelUtility();
        
    	
    	String dat = excel.getExcelData("Sheet1", 1, 1);
    	String dat1 = excel.getExcelData("Sheet1", 1, 2);
    	String dat2 = excel.getExcelData("Sheet1", 1, 3);
    	
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
    	wbutility.waitUntilPageLoad(driver);
    	login.enterURL(driver);
    	login.loginAction();
    	
    	
    	
  /*  	driver.findElement(By.xpath("//input[@type='text' and @name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password' and @name='user_password']")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click(); */
		Thread.sleep(5000);
	/*	driver.findElement(By.xpath("//a[.='Leads']")).click();
		Thread.sleep(5000); */
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
		lip.leadAddress();
		Thread.sleep(5000);
		lip.convertLead();
		Thread.sleep(5000);
		ConvertLead cvl = new ConvertLead(driver);
		cvl.popUp(driver);
		Thread.sleep(5000);
		Organisation org = new Organisation(driver);
		org.verifyResult(driver);hm.logout(driver).click();
	/*	driver.findElement(By.name("lastname")).sendKeys(dat1);
		driver.findElement(By.name("company")).sendKeys(dat2);
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		Thread.sleep(5000); 
	//	ldn = driver.findElement(By.xpath("//td[contains(text(),'LEA')]")).getText();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Convert Lead")).click();
		Thread.sleep(5000);
	//	driver.findElement(By.xpath("//a[.='Leads']")).click();
	//	driver.findElement(By.xpath("//input[@value='Potentials']")).click();
		driver.findElement(By.name("lastname")).sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
		driver.findElement(By.name("lastname")).sendKeys("Banerjee");
	//	ln = driver.findElement(By.name("lastname")).getText();
		driver.findElement(By.xpath("//input[@value='Potentials']")).click();
		driver.findElement(By.name("closingdate")).sendKeys("2021-10-1");;
	//	Thread.sleep(5000);
	//	driver.findElement(By.linkText("Convert Lead")).click();
		//Thread.sleep(5000);
	//	driver.findElement(By.xpath("//input[@value='Potentials']")).click();
		driver.findElement(By.name("Save")).click();
		Thread.sleep(5000);
		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
		String ExpectedTitle = "Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM";
		SoftAssert s = new SoftAssert();
		s.assertEquals(ActualTitle, ExpectedTitle);
	//	com = driver.findElement(By.xpath("//span[text()='Test Yantra']")).getText();
		WebElement moveElement=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wbutility.mouseOver(driver, moveElement);
	//	a.moveToElement(moveElement).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		s.assertAll(); */
}
     
}
