package POMPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.crm.vtiger.genericUtils.ExcelUtility;
import com.crm.vtiger.genericUtils.LeadTitle;
import com.crm.vtiger.genericUtils.WedDriverUtility;

public class Lead {
	String ln,fn,com;
	 SoftAssert s = new SoftAssert();

	WedDriverUtility wdu = new WedDriverUtility();
	ExcelUtility eu = new ExcelUtility();
	
	@FindBy(xpath = "//img[@alt='Create Lead...']")
	private WebElement createlead;
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement srchld;
	
	@FindBy(name = "search_field")
	private WebElement srchfld;
	
	@FindBy(xpath = "//input[@value=' Search Now ']")
	private WebElement srchbtn;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement moveElement;
	
	

    public Lead(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}
   
    public void createLead() {
    	createlead.click();
	}
    
    public WebElement createLead1() {
    	//createlead.click();
		return createlead;
	}
    
  /*  public void searchLead(String ldn)
    {
    	srchld.sendKeys(ldn);
    } */
    
    public WebElement searchLead() throws InterruptedException
    {
    	Thread.sleep(5000);
    	return srchld;
    }
    
    public void selectOption() throws Throwable
    {
    	wdu.SelectOption(srchfld, eu.getExcelData("Sheet1", 25, 1));
    }
    
    public void selectOption1() throws Throwable
    {
    	wdu.SelectOption(srchfld, eu.getExcelData("Sheet1", 26, 1));
    }
    
    public void selectOption2() throws Throwable
    {
    	wdu.SelectOption(srchfld, eu.getExcelData("Sheet1", 27, 1));
    }
    
    public void selectOption3() throws Throwable
    {
    	wdu.SelectOption(srchfld, eu.getExcelData("Sheet1", 28, 1));
    }
    
    public void searchNowButton()
    {
    	srchbtn.click();
    }
    
    public void searchLastName() throws Throwable
    {
    	//srchfld.sendKeys(dat1);
    	ln=eu.getExcelData("Sheet1", 8, 2);
    	srchld.sendKeys(ln);
    	
    } 
    
    public WebElement searchLastName1() throws Throwable
    {
    	//srchfld.sendKeys(dat1);
    	ln=eu.getExcelData("Sheet1", 8, 2);
    	
		return srchld;
    	
    }
    
    public void searchFirstName() throws Throwable
    {
    	//srchfld.sendKeys(dat1);
    	fn=eu.getExcelData("Sheet1", 11, 1);
    	srchld.sendKeys(fn);
    	
    }
    
    public void searchCompany() throws Throwable
    {
    	//srchfld.sendKeys(dat1);
    	com=eu.getExcelData("Sheet1", 14, 3);
    	srchld.sendKeys(com);
    	
    }
    
    
    
    public void verifyResult(WebDriver driver)
	{
	String ActualTitle = driver.getTitle();
	System.out.println(ActualTitle);
	String ExpectedTitle = LeadTitle.ExpectedTitle;
	s.assertEquals(ActualTitle, ExpectedTitle);
	s.assertAll();
	}
	
	

	
}
