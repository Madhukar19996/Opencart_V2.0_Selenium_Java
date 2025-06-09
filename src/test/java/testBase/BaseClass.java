package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;




public class BaseClass {
	
     public static WebDriver driver;
     public Logger logger;  // LOG4j2 
     public Properties p;
	
	@SuppressWarnings("deprecation")
	@BeforeClass(groups={"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException 
	{
		
		//Loading Config.properties file
		FileReader file=new FileReader(".//src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		
	    logger=LogManager.getLogger(this.getClass());//Log4j
		
	    if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
	    { 
	    	DesiredCapabilities cap=new DesiredCapabilities();
	    	
	    	//O.S
	    	if(os.equalsIgnoreCase("Linux"))
	    	{
	    	  cap.setPlatform(Platform.LINUX);
	    	}
	    	else if (os.equalsIgnoreCase("mac"))
	    	{
	    	  cap.setPlatform(Platform.MAC);
	    	}
	    	
	    	else 
	    	{
	    	  System.out.println("No Matching OS");
	    	}
	    	
	    	
	    	//browser
	    	 switch(br.toLowerCase())
	 	    {
	 	    case "chrome": cap.setBrowserName("chrome"); break;
	 	    case "edge" :  cap.setBrowserName("MicrosoftEdge"); break;
	 	    case "firefox" :cap.setBrowserName("firefox"); break;
	 	    default  : System.out.println("No matching browser name..."); return ;
	 	    }
	    	
	    	driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
	    }
	    
	    if(p.getProperty("execution_env").equalsIgnoreCase("local"))
	    {
	    	switch(br.toLowerCase())
		    {
		    case "chrome": driver=new ChromeDriver(); break;
		    case "edge" :  driver=new EdgeDriver();   break;
		    case "firefox" :  driver=new FirefoxDriver();   break;
		    default  : System.out.println("Invalid browser name..."); return ;
		    }	
	    }
	      
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appurl2")); // Reading Url from properties file. 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@AfterClass(groups={"Sanity","Regression","Master"})
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
	
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	
	

}
