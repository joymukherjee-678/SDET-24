package POMPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.genericUtils.WedDriverUtility;

public class HomePage {
	
	WedDriverUtility wdu = new WedDriverUtility();

	@FindBy(xpath = "//a[.='Leads']")
	private WebElement clicklead;
	
	@FindBy(xpath = "//img[@alt='Create Lead...']")
	private WebElement createlead;
	
	@FindBy(id = "submitButton")
	private WebElement loginButton;
	
	@FindBy(xpath = "//a[.='Sign Out']")
	private WebElement clckonsignout;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement moveElement;

    public HomePage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}
    
    public void clickOnLead() {
		clicklead.click();
    }
    
    public WebElement clickOnLead1() {
		
		return clicklead;
    }
    
    public void createLead() {
    	createlead.click();
		
	}
    
    public WebElement logout(WebDriver driver)
	{
		wdu.mouseOver(driver, moveElement);
		return clckonsignout;
		//s.assertAll();
	}
	
}
