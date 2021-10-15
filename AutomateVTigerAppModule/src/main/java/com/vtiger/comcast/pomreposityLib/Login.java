package com.vtiger.comcast.pomreposityLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	  public Login(WebDriver driver)
	  {
		  PageFactory.initElements(driver, this);
	  }
	  
	  @FindBy(xpath = "//input[@type='text' and @name='user_name']")
		private WebElement userNameEdt;
		
		@FindBy(xpath = "//input[@type='password' and @name='user_password']")
		private WebElement userPasswordEdt;
		
	@FindAll({@FindBy(id = "submitButton"),@FindBy(xpath="//input[@id='submitButton']")})
	private WebElement loginBtn;
		
		//@FindBy(id = "submitButton")
	//	private WebElement loginButton;
	
	public WebElement getUserNameEdt()
	{
		return userNameEdt;
		
	}
	
	public WebElement getPasswordEdt()
	{
		return userPasswordEdt;
		
	} 
	
	public WebElement getLoginBtn()
	{
		return loginBtn;
		
	}
	
	public void loginToApp(String userName,String password) {
		/* step 1 : login */
		userNameEdt.sendKeys(userName);
		userPasswordEdt.sendKeys(password);
		loginBtn.click();
	}
		

}
