package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	
@FindBy(xpath="//input[@id='input-email']")
WebElement EmailAddress_txt;

@FindBy(xpath="//input[@id='input-password']")
WebElement Password_txt;


@FindBy(xpath="//input[@value='Login']")
WebElement login_button;


public void setEmail(String email)
{
	EmailAddress_txt.sendKeys(email);
}


public void setPassword(String password)
{
	Password_txt.sendKeys(password);
}


public void clickLogin()
{
	login_button.click();
}


}


