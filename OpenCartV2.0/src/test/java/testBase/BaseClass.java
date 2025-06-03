package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
public WebDriver driver;
	
	@BeforeTest()
	public void setup() throws InterruptedException
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
