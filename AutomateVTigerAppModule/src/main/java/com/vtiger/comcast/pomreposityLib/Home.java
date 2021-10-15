package com.vtiger.comcast.pomreposityLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
  WebDriver driver;
  public Home(WebDriver driver)
  {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
  }
  
  @FindBy(linkText = "Organizations")
  private WebElement organizationLnk;
  
  @FindBy(linkText = "Products")
  private WebElement productsLnk;
  
  @FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
  private WebElement administatorImg;
	 
  @FindBy(xpath = "//a[.='Sign Out']")
	private WebElement signOutLnk;
  
  public WebElement getOrganizationLink()
  {
	  return organizationLnk;
  }
  
  public WebElement getProductLnk()
  {
	  return productsLnk;
  }
  
  public WebElement getAdministatorImg() {
	  return administatorImg;
  }
  
  public WebElement getSignOutLnk()
  {
	  return signOutLnk;
  }
  public void logout()
  {
	  Actions act = new Actions(driver);
	  act.moveToElement(administatorImg).perform();
  }
}
