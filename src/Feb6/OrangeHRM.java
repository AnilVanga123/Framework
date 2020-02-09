package Feb6;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class OrangeHRM {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	@BeforeTest
	public void SetUp() {
		report=new ExtentReports("./Reports/dataprovider.html");
		System.setProperty("webdriver.chrome.driver", "F:\\December_Selenium\\FrameWorks\\CommonDrivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}
  @Test(dataProvider = "datasupply")
  public void VerifyLogin(String username, String password) throws Throwable
  {
	  test =report.startTest("Dataprovider");
	  driver.get("http://orangehrm.qedgetech.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Thread.sleep(2000);
		if(driver.getCurrentUrl().contains("dashboard"))
		{
			Reporter.log("Login Success",true);	
			test.log(LogStatus.PASS, "Login Success");
			}
		else
		{
			Reporter.log("Login Success",true);	
			test.log(LogStatus.PASS, "Login Success");
		}
  }

  @DataProvider
  public void Dataprovider() {
	  Object[][]login=new Object[5][2];
	   login[0][0]="Admin";
	   login[0][1]="Qedge123!@#";
	   login[1][0]="Admin";
	   login[1][1]="Admin";
	   login[2][0]="Admin";
	   login[2][1]="Qedge123!@#";
	   login[3][0]="Admin";
	   login[3][1]="Admin";
	   login[4][0]="Admin";
	   login[4][1]="Qedge123!@#";
    
  }
 
  @AfterTest
  public void tearDown() {
	  report.endTest(test);
	  report.flush();
	  driver.close();
	  
	  
  }

}
