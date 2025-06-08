package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;



public class TC003_LoginDDT extends BaseClass 
{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="DataDriven")  //Getting Data Provider from different class
	public void verify_loginDDT(String email , String pwd,String exp)
	{   
		
		logger.info("*****Starting TC_003_LoginDDT ****** ");
		//HomePage
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
				
		//LoginPage
		LoginPage lp=new LoginPage(driver);
				
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
				
				
		//MyAccount Page
		
		MyAccountPage macc=new MyAccountPage(driver);
				
		boolean target_page= macc.isMyAccountExists();
		
		/* Data is valid -->login success-->test pass-->logout
		   Data is valid -->login failed --> test fail
		   
		   Data is invalid -->login success-->test fail-->logout
		   Data is invalid -->login failed--> test pass
		 */
		
		
		if(exp.equalsIgnoreCase("Valid")) 
		{
			if(target_page==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
		
		   else
		   {
			Assert.assertTrue(false);
		   }
	   }
		
		
		if(exp.equalsIgnoreCase("Invalid"))
			
		{
			if(target_page==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
		
		else
		{
			Assert.assertTrue(true);
		}
	}
    
	}catch(Exception e )
	{
		Assert.fail();
	}
	logger.info("*****Finished TC_003_LoginDDT ****** ");

    }
 }
  
