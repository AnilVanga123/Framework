package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ApplicationLayer.AddEmployee;
import ApplicationLayer.AddUserpage;
import ApplicationLayer.LogOutpage;
import ApplicationLayer.LoginPage;

public class TestScript {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	@BeforeTest
	public void generatereport() 
	{
		report=new ExtentReports("./Reports/pom.html");
	}
	@BeforeMethod
	public void setUp()
	{
	System.setProperty("webdriver.chrome.driver", "F:\\December_Selenium\\FrameWorks\\CommonDrivers\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("http://orangehrm.qedgetech.com/");
	driver.manage().window().maximize();
	LoginPage login=PageFactory.initElements(driver, LoginPage.class);
	login.VerifyLogin("Admin", "Qedge123!@#");
	}
	@Test(priority=1)
	public void UserCreation() throws Throwable
	{
		test=report.startTest("usercreation");
		AddUserpage user=PageFactory.initElements(driver, AddUserpage.class);
		user.verifyaddress("Aarya Santhosh", "powerstar","Akhilesh@9000", "Akhilesh@9000");
		if(driver.getCurrentUrl().contains("viewSystemUsers"))	
		{
			test.log(LogStatus.PASS, "user Creation Success");
			Reporter.log("user Creation Success",true);
			
		}
		else
		{
			test.log(LogStatus.FAIL, "user Creation Fail");
			Reporter.log("user Creation Fail",true);
		}
	}
	@Test(priority=0)
	public void empcreaton() throws Throwable
	{
		test=report.startTest("emp creation");
		AddEmployee emp=PageFactory.initElements(driver, AddEmployee.class);
		emp.verifyemp("pavan", "kalyan");
		if(driver.getCurrentUrl().contains("empNumber"))
		{
			Reporter.log("Emp Creation Success",true);
			test.log(LogStatus.PASS, "Emp Creation Success");
		}
		else
		{
			Reporter.log("Emp Creation fail",true);
			test.log(LogStatus.FAIL, "Emp Creation fail");
		}
		
	}
	@AfterMethod
	public void tearDown()throws Throwable
	{
	report.endTest(test);
	report.flush();
	LogOutpage logout=PageFactory.initElements(driver, LogOutpage.class);
	logout.Verifylogout();
	driver.close();

}
}