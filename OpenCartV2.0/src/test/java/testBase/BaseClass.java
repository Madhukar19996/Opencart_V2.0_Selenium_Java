package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;




public class BaseClass {
	
     public WebDriver driver;
     public Logger logger;  // LOG4j2 
     public Properties p;
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException 
	{
		
		//Loading Config.properties file
		FileReader file=new FileReader(".//src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		
	    logger=LogManager.getLogger(this.getClass());//Log4j
		
	    switch(br.toLowerCase())
	    {
	    case "chrome": driver=new ChromeDriver(); break;
	    case "edge" :  driver=new EdgeDriver();   break;
	    case "firefox" :  driver=new FirefoxDriver();   break;
	    default  : System.out.println("Invalid browser name..."); return ;
	    }
	    
	    
	    
		
	    
	    
	    
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appurl2")); // Reading Url from properties file. 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@AfterClass()
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@SuppressWarnings("deprecation")
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(6);
		return generatedString;
	}
	
	@SuppressWarnings("deprecation")
	public String randomNumber()
	{
		String generatednumber = RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	
	@SuppressWarnings("deprecation")
	public String randomAlphanumeric()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(4);
		String generatednumber = RandomStringUtils.randomNumeric(3);
		return (generatedString+generatednumber+"@");
	}
	
	

}
