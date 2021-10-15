package POMPackage;

import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.genericUtils.ExcelUtility;
import com.crm.vtiger.genericUtils.FileUtility;
import com.crm.vtiger.genericUtils.JavaUtility;
import com.crm.vtiger.genericUtils.WedDriverUtility;

public class ConvertLead {
	
	Date dateobj = new Date();
	String currentTimeAndDate = dateobj.toString();
	int month = dateobj.getMonth()+1;
	int date = dateobj.getDate();
	String year = currentTimeAndDate.split(" ")[5];
	String actDate = year+"-"+month+"-"+date;
	
	
    ExcelUtility eu = new ExcelUtility();
    //JavaUtility jv = new JavaUtility();
	
	@FindBy(xpath = "//input[@value='Potentials']")
	private WebElement radiobutton;
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(name="closingdate")
	private WebElement clsdt;
	
	@FindBy(name="Save")
	private WebElement sv;
	
	public ConvertLead(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void popUp(WebDriver driver) throws Throwable
	{
		Thread.sleep(5000);
	    lastname.sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
	    lastname.sendKeys(eu.getExcelData("Sheet1", 8, 2));
	    radiobutton.click();
	    System.out.println(actDate);
	    Thread.sleep(5000);
	    clsdt.sendKeys(actDate);
	    //driver.switchTo().alert().accept();
	    sv.click();
	   // driver.switchTo().alert().accept();
	    //sv.click();
	    Thread.sleep(5000);
	}
}
