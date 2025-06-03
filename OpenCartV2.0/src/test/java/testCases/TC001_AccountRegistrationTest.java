package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	public WebDriver driver;
	
	@BeforeTest()
	public void setup() 
	{
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@AfterTest()
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test()
	public void verify_account_registration() throws InterruptedException 
	{
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		
	
		hp.clickRegistration();
		
		AccountRegistrationPage rp= new AccountRegistrationPage(driver);
		Thread.sleep(2000);
		rp.setFirstName(randomString().toUpperCase());
		rp.setlastName(randomString().toUpperCase());
		rp.setEmail(randomString()+"@gmail.com"); //random generated the email
		rp.setTelephone(randomNumber());
		
		String password=randomAlphanumeric();
		rp.setPassword(password);
		
		rp.setCfrmPassword(password);
		rp.setPrivacyPolicy();
	
		rp.setContinue();
		String confmsg=rp.getConfirmationMsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
	}
	

}
