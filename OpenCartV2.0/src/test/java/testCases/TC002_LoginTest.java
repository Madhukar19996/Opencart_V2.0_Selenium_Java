package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("***** Started TC002_LoginTest *****");
		
		try 
		{
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(p.getProperty("email2"));
		lp.setPassword(p.getProperty("password2"));
		lp.clickLogin();
		
		
		//MyAccount Page
		
		MyAccountPage macc=new MyAccountPage(driver);
		
		boolean target_page= macc.isMyAccountExists();
		
		//Assert.assertEquals(target_page, true,"Login Failed");
		
		Assert.assertTrue(target_page);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***** Finished TC002_LoginTest *****");
		
		
	}
	
	

}
