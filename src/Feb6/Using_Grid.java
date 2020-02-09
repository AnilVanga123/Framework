package Feb6;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Using_Grid {
	WebDriver driver;
	DesiredCapabilities cap;
	String url="http://orangehrm.qedgetech.com/";
	String node="http://192.168.43.239:4444/wd/hub";
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String brw) throws Throwable
	{
		if(brw.equalsIgnoreCase("chrome"))
		{
			cap=new DesiredCapabilities();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			driver=new RemoteWebDriver(new URL(node),cap);
			driver.get(url);
			driver.manage().window().maximize();
		}
		else
			if(brw.equalsIgnoreCase("firefox"))
			{
				cap=new DesiredCapabilities();
				cap.setBrowserName("firefox");
				cap.setPlatform(Platform.WINDOWS);
				driver=new RemoteWebDriver(new URL(node),cap);
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
