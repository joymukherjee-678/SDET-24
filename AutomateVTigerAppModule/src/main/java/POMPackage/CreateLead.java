package POMPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.genericUtils.ExcelUtility;
import com.crm.vtiger.genericUtils.WedDriverUtility;

public class CreateLead {
	String ldn;
	WedDriverUtility wbutility = new WedDriverUtility();
	ExcelUtility eu = new ExcelUtility();
	
	@FindBy(xpath = "//img[@alt='Create Lead...']")
	private WebElement createlead;
	
	@FindBy(name="salutationtype")
	private WebElement drpdwn;
	
	@FindBy(name="firstname")
	private WebElement firstname;
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(name="company")
	private WebElement company;
	
	@FindBy(xpath = "//input[@accesskey='S']")
	private WebElement saveButton;
	
	public CreateLead(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
   
    public void createLead() {
    	createlead.click();
	}
    
    public void createLead1(String firstName,String lastName,String Company) {
    	wbutility.SelectOption(drpdwn, "Mr.");
    	firstname.sendKeys(firstName);
    	lastname.sendKeys(lastName);
    	company.sendKeys(Company);
    	saveButton.click();
	}
    
    public WebElement getFirstName()
    {
    	return firstname;
    }
    
    public WebElement getlastName()
    {
    	return lastname;
    }
    
    public WebElement getCompanyName()
    {
    	return company;
    }
    public WebElement clickOnButton()
    {
    	return saveButton;
    }
    
    public void dropDown() throws Throwable
    {
    	wbutility.SelectOption(drpdwn, eu.getExcelData("Sheet1", 32, 1));
    }
    
    public void selectOptions() throws Throwable
    {
    	wbutility.SelectOption(drpdwn, eu.getExcelData("Sheet1", 32, 1));
    }
    
    public void components(String dat, String dat1, String dat2) {
		firstname.sendKeys(dat);
		lastname.sendKeys(dat1);
		company.sendKeys(dat2);
		saveButton.click();
	}
    
    
    
}
