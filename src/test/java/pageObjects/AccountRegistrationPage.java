package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage  {
		
		public AccountRegistrationPage(WebDriver driver)
		{
			super(driver);
		}
		
		
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement Firstname_txt;

	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement Lastname_txt;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Email_txt;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement Telephone_txt;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement Password_txt;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement ConfirmPassword_txt;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement CheckPolicy_chkbox;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement Continue_btn;
	
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement Confirmation_msg;
	
	public void setFirstName(String fname) {
		Firstname_txt.sendKeys(fname);
	}
	
	
	public void setlastName(String lname) {
		Lastname_txt.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		Email_txt.sendKeys(email);
	}
	
	public void setTelephone(String telephone) {
		Telephone_txt.sendKeys(telephone);
	}
	
	public void setPassword(String pwd) {
		Password_txt.sendKeys(pwd);
	}
	
	public void setCfrmPassword(String pwd) {
		ConfirmPassword_txt.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy() {
		CheckPolicy_chkbox.click();
	}
	
	public void setContinue() {
		//Sol 1
		Continue_btn.click();
		
		/*
		//Sol 2
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",Continue_btn);
		*/
	}
	
public String getConfirmationMsg() {
	try {
		return (Confirmation_msg.getText());
	} catch(Exception e) {
		return(e.getMessage());
	}
}


}
