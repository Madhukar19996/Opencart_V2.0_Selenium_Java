package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	
  @FindBy(xpath="//h2[normalize-space()='My Account']")  // MyAccount Page Heading 
  WebElement MsgHeading;
  
  
  @FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")  // Logout from MyAccount Page
  WebElement Logout_link;
  
  
  public boolean isMyAccountExists()
  { 
	try
    {
	  return  (MsgHeading.isDisplayed());
    }
	catch(Exception e) 
    {
		return false;
	}
  
  }
  
  public void clickLogout()
	 {
	  Logout_link.click();
	 }

	
	
}
