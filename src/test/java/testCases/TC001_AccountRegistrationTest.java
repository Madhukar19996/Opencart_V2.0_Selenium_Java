package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
public class TC001_AccountRegistrationTest extends BaseClass {
	

	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	   {   
		
		logger.info("****--- Starting TC001_AccountRegistrationTest ---****");
		try 
		{
			
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		
		logger.info("****--- Clicked on MyAccount link ---****");
		
		hp.clickRegistration();
		
		logger.info("****--- Clicked on Register link ---****");
		
		AccountRegistrationPage rp= new AccountRegistrationPage(driver);
		
		logger.info("****--- Providing Customer Details ---****");
		
		
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
		
		
		
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{   logger.info("Confirmation message received: " + confmsg);
			logger.info("TC001_AccountRegistrationTest Passed");
			Assert.assertTrue(true);
		}
		else
			
		{   logger.error("Test Failed...");
		    logger.debug("Debug logs...");
			Assert.assertTrue(false);
		}
		 //Assert.assertEquals(confmsg,"Your Account Has Been Created!!"); This is Hard Assertion .
		                                                                 //when H.S is executed after the piece of code is not executed 
		}
		catch (Exception e)
		 {
			
			Assert.fail();
		 }
		
		logger.info("****---Finished TC001_AccountRegistrationTest---****");
	  }
	

}
