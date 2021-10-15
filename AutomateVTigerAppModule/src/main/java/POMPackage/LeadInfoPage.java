package POMPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mysql.cj.jdbc.Driver;

public class LeadInfoPage {
	String ldn;
	
	@FindBy(xpath = "//td[contains(text(),'LEA')]")
	private WebElement ldaddr;
	

	@FindBy(linkText ="Convert Lead")
	private WebElement cnvrtld;
	
	@FindBy(xpath = "//span[@id='dtlview_First Name']")
	private WebElement frstnm;
	
	@FindBy(xpath = "//span[@id='dtlview_Last Name']")
	private WebElement lastnm;
	
	@FindBy(xpath = "//span[@id='dtlview_Company']")
	private WebElement comnm;
	
	public LeadInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String leadAddress()
    {
    	 ldn = ldaddr.getText();
    	 return ldn;
    	 
    }
	
	public void convertLead()
    {
    	cnvrtld.click();
    }
	
	public WebElement getFirstName()
	{
		
		return frstnm;
	}
	
	public WebElement getLastName()
	{
		
		return lastnm;
	}
	
	public WebElement getCompanyName()
	{
		
		return comnm;
	}
}
