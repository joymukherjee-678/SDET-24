package POMPackage;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.genericUtils.FileUtility;

public class Login {

	FileUtility file = new FileUtility();
	
	@FindBy(xpath = "//input[@type='text' and @name='user_name']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@type='password' and @name='user_password']")
	private WebElement password;
	
	@FindBy(id = "submitButton")
	private WebElement loginButton;

    public Login(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}
    
    public WebElement getUserName()
    {
		return username;
    }
    
    public WebElement getPassword()
    {
		return password;
    }
    
    public WebElement getLoginButton()
    {
		return loginButton;
    }
    
    public void enterURL(WebDriver driver) throws IOException, ParseException {
		
       String url = file.getDataFromJson("url");
       driver.get(url);
    }
    
    public void loginAction() throws IOException, ParseException
    {
    	username.sendKeys(file.getDataFromJson("username"));
    	password.sendKeys(file.getDataFromJson("password"));
    	loginButton.click();
    	
    } 
    
  /*  public void login(String url,String userName,String Password)
    {
    	username.sendKeys(userName);
    	password.sendKeys(Password);
    	loginButton.click();
    	
    } */

	public void login(String userName, String pswd) {
		username.sendKeys(userName);
    	password.sendKeys(pswd);
    	loginButton.click();
		
	}

	
    
    
    
}
