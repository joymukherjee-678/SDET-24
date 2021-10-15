package POMPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.crm.vtiger.genericUtils.ExcelUtility;
import com.crm.vtiger.genericUtils.OrganizationTitle;
import com.crm.vtiger.genericUtils.WedDriverUtility;

public class Organisation {
    WedDriverUtility wdu = new WedDriverUtility();
    ExcelUtility eu = new ExcelUtility();
    SoftAssert s = new SoftAssert();
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement moveElement;
	
	@FindBy(xpath = "//a[.='Sign Out']")
	private WebElement clckonsignout;
	
	@FindBy(xpath = "//a[.='Leads']")
	private WebElement ldmdl;
	
	@FindBy(xpath = "//a[@class='hdrLink']")
	private WebElement ldlink;
	
	@FindBy(xpath = "//td[@class='dvtCellLabel']/following-sibling::td/following-sibling::td/following-sibling::td")
	private WebElement orgnolnk;
	
	@FindBy(xpath = "//span[contains(text(),'Organization Information')]")
	private WebElement orgtitle;
	
	@FindBy(xpath = "//span[@id='dtlview_Organization Name']")
	private WebElement orgtlink;
	
//	@FindBy(xpath = "//span[@class='dvHeaderText']")
	//private WebElement ldlink;
	
	public Organisation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void verifyResult(WebDriver driver) throws Throwable
	{
		String orgno = orgnolnk.getText();
		String orgt = orgtlink.getText();
		String ExpectedTitle = "["+orgno+" ] "+orgt+" - "+eu.getExcelData("Sheet1", 40, 1);
		System.out.println(ExpectedTitle); 
     	String ActualTitle = orgtitle.getText();
	    System.out.println(ActualTitle);
	    //String ExpectedTitle1 = OrganizationTitle.ExpectedTitle;
		s.assertEquals(ActualTitle, ExpectedTitle);
		s.assertAll();
	}
	
	/*public void logout(WebDriver driver)
	{
		wdu.mouseOver(driver, moveElement);
		clckonsignout.click();
		//s.assertAll();
	} */
	
	public WebElement logout(WebDriver driver)
	{
		wdu.mouseOver(driver, moveElement);
		return clckonsignout;
		//s.assertAll();
	}
	
/*	public void clickOnleadModule()
	{
		ldmdl.click();
	} */
	
	public WebElement clickOnleadModule()
	{
		return ldmdl;
	}
	
/*	public void clickOnleadLink()
	{
		ldlink.click();
	} */
	
	public WebElement clickOnleadLink()
	{
		return ldlink;
	}
}
