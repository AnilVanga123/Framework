package DriverFactory;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import CommonFunLibrary.CommonFunctions;
import Utilites.excelFileUtil;
import constant.pbConstant;

public class DriverScript extends pbConstant{
	String inputpath="F:\\December_Selenium\\FrameWorks\\TestInput\\ControllerPbank.xlsx";
	String outputpath="F:\\December_Selenium\\FrameWorks\\TestOutput\\keywordResults.xlsx";
	String TcSheet="TestCases";
	String TsSheet="TestSteps";
	ExtentReports report;
	ExtentTest test;
	File screen;
	@Test
	public void startTest()throws Throwable
	{
		report=new ExtentReports("./Reports/keyword.html");
	excelFileUtil xl=new excelFileUtil(inputpath);
	boolean res=false;
	String tcres="";
	int TCcount=xl.rowcount(TcSheet);
	int TScount=xl.rowcount(TsSheet);
	for(int i=1;i<=TCcount;i++)
	{
		test=report.startTest("start Test");
		String execute=xl.getcelldata(TcSheet, i, 2);
		if(execute.equalsIgnoreCase("Y"))
		{
			String TCid=xl.getcelldata(TcSheet, i, 0);
			for(int j=1;j<=TScount;j++)
			{
			String Description=xl.getcelldata(TcSheet, j, 2);
			String TSid=xl.getcelldata(TsSheet, j, 0);
					if(TCid.equalsIgnoreCase(TSid))
					{
					String keyword=xl.getcelldata(TsSheet, j, 3);
					if(keyword.equalsIgnoreCase("Admin Login"))
					{
						res=CommonFunctions.verifylogin("Admin", "Admin");
						test.log(LogStatus.INFO,Description);
					}
					else if(keyword.equalsIgnoreCase("NewBranchCreation"))
					{
						CommonFunctions.navigateBranches();
						res=CommonFunctions.verifybranchcreation("madanapalli", "Hydrabad", "12345", 1, 1, 1);
						test.log(LogStatus.INFO, Description);
					}
					else if(keyword.equalsIgnoreCase("UpdateBranch"))
					{
						CommonFunctions.navigateBranches();
						res=CommonFunctions.verifyBranchUpdation("kadari1", "kukatpally");
						test.log(LogStatus.INFO, Description);
					}
					else if(keyword.equalsIgnoreCase("Admin Logout"))
					{
						res=CommonFunctions.verifyLogout();
						test.log(LogStatus.INFO, Description);
					}
					String tsres="";
					if(res)
					{
						test.log(LogStatus.PASS, Description);
						tsres="pass";
						xl.setcetcelldata(TsSheet, j, 4, tsres, outputpath);
					}
					else
					{
						screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
						FileUtils.copyFile(screen, new File("‪F:\\December_Selenium\\FrameWorks\\screens\\"+j+"primus.png"));
						tsres="Fail";
						xl.setcetcelldata(TsSheet, j, 4, tsres, outputpath);
						test.log(LogStatus.FAIL, Description);
					}
					if(!tsres.equalsIgnoreCase("Fail"))
					{
						tcres=tsres;
					
					}
			}
					report.endTest(test);
					report.flush();
		}
			xl.setcetcelldata(TcSheet, i, 3, tcres, outputpath);
	}
		else
		{
			xl.setcetcelldata(TcSheet, i, 3, "Not Executed", outputpath);
		}
	}
}
}
