package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
@FindBy(xpath="//span[normalize-space()='My Account']")
WebElement MyAccount_link;

@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
WebElement Register_link;


@FindBy(xpath="//a[normalize-space()='Login']")   // Update by adding login link element by Step 5 
WebElement login_link;



public void clickMyAccount()
{
	MyAccount_link.click();
}


public void clickRegistration()
{
	Register_link.click();
}


public void clickLogin()
{
	login_link.click();
}


}
