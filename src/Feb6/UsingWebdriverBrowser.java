package Feb6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UsingWebdriverBrowser {
	WebDriver driver;
	String url="http://orangehrm.qedgetech.com/";
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String brw) throws Throwable
	{
		if(brw.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\December_Selenium\\FrameWorks\\CommonDrivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
		}
		else
			if(brw.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "F:\\December_Selenium\\FrameWorks\\CommonDrivers\\geckodriver.exe");
				driver=new FirefoxDriver();
				driver.get(url);
				driver.manage().window().maximize();
		}
		}
		@Test
		public void Login()throws Throwable
		{
			driver.findElement(By.name("txtUsername")).sendKeys("Admin");
			driver.findElement(By.name("txtPassword")).sendKeys("Qedge123!@#");
			driver.findElement(By.name("Submit")).click();
			Thread.sleep(4000);
			if(driver.getCurrentUrl().contains("dash"))
			{
				System.out.println("Log in Success");
			}
			else
			{
				System.out.println("Log in Fail");
			}	
		}
		@AfterTest
		public void tearDown()
		{
			driver.close();
		
	}
}
