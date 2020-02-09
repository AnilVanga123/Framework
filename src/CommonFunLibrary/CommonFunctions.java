package CommonFunLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import constant.pbConstant;

public class CommonFunctions extends pbConstant{
	/*Project name=PrimusBank
	 * Author name=Anil
	 * Module name=Admim Login
	 * CreatedDate=01/02/2020
	 */
	public static boolean verifylogin(String username,String password) throws Throwable
	{
		driver.findElement(By.xpath("Objusername")).sendKeys(username);
		driver.findElement(By.xpath("Objpassword")).sendKeys(password);
		driver.findElement(By.xpath("ObjLogin")).click();
		Thread.sleep(4000);
		String ExpVal="adminflow";
		String ActVal=driver.getCurrentUrl();
		if(ActVal.toLowerCase().contains(ExpVal.toLowerCase()))
		{
			Reporter.log("login success",true);
			return true;
			
		}
		else {
		Reporter.log("login fail",true);
		return false;
		}
		
	}
	/*Project name=PrimusBank
	 * Author name=Ranga
	 * Module name=navigate branches
	 * CreatedDate=01/02/2020
	 */
	public static void navigateBranches()throws Throwable{
		driver.findElement(By.xpath(p.getProperty("Objbranches"))).click();
		Thread.sleep(4000);
	}
	public static boolean verifybranchcreation(String bname,String address,String zipcode,int county,int state,int city )throws Throwable
	{
		driver.findElement(By.xpath(p.getProperty("Objnewbranch"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(p.getProperty("objbname"))).sendKeys(bname);
		driver.findElement(By.xpath(p.getProperty("objaddress1"))).sendKeys(address);
		driver.findElement(By.xpath(p.getProperty("objzipcode"))).sendKeys(zipcode);
		new Select(driver.findElement(By.xpath(p.getProperty("objcountry")))).selectByIndex(city);
		Thread.sleep(4000);
		new Select(driver.findElement(By.xpath(p.getProperty("objstate")))).selectByIndex(state);
		Thread.sleep(4000);
		new Select(driver.findElement(By.xpath(p.getProperty("objcity")))).selectByIndex(city);
		Thread.sleep(4000);
		driver.findElement(By.xpath(p.getProperty("objsubmit"))).click();
		Thread.sleep(4000);
		String alertmassage=driver.switchTo().alert().getText();
		System.out.println(alertmassage);
		driver.switchTo().alert().accept();
		String ExpVal="new baranch";
				if(alertmassage.toLowerCase().contains(ExpVal.toLowerCase()))
				{
					Reporter.log("Branch Creation Sucess",true);
					return true;
				}
				else {
					Reporter.log("Branch Creation ids Fail",true);
					return false;
				}
	}
	/*Project name=PrimusBank
	 * Author name=Anil
	 * Module name=UpdateBranch
	 * CreatedDate=01/02/2020
	 */
	public static boolean verifyBranchUpdation(String bname,String address1)throws Throwable
	{
		driver.findElement(By.xpath(p.getProperty("objedit"))).click();
		WebElement branch=driver.findElement(By.xpath(p.getProperty("objubname")));
		branch.clear();
		Thread.sleep(2000);
		branch.sendKeys(bname);
		WebElement address=driver.findElement(By.xpath(p.getProperty("objaddress")));
		address.clear();
		Thread.sleep(5000);
		address.sendKeys(address1);
		driver.findElement(By.xpath(p.getProperty("objupdate"))).click();
		String updatebranchalert=driver.switchTo().alert().getText();
		System.out.println(updatebranchalert);
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		String Expval="BranchUpdated";
		if(updatebranchalert.toLowerCase().contains(Expval.toLowerCase()))
		{
			Reporter.log("Branch Update sucess",true);
			return true;
		}
		else
		{
			Reporter.log("Branch Update fail",true);
			return false;
		}
			
	}
	/*Project name=PrimusBank
	 * Author name=Anil
	 * Module name=AdminLogout
	 * CreatedDate=01/02/2020
	 */
	public static boolean verifyLogout()throws Throwable
	{
		driver.findElement(By.xpath(p.getProperty("objlogout"))).click();
		Thread.sleep(4000);
		if(driver.findElement(By.xpath(p.getProperty("ObjLogin"))).isDisplayed())
		{
		Reporter.log("logout sucess",true);
		return true;
		}
		else
		{
			Reporter.log("logout fail",true);
			return false;
		}
	}
	

}
