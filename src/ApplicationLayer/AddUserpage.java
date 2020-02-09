package ApplicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddUserpage {
	WebDriver driver;
	Actions ac;
	public AddUserpage(WebDriver driver)
	{
	this.driver=driver;	
	}
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement objAdmin;
	@FindBy(id="menu_admin_UserManagement")
	WebElement objUserManagment;
	@FindBy(id="menu_admin_viewSystemUsers")
	WebElement objuser;
	@FindBy(id="btnAdd")
	WebElement objadd;
	@FindBy(id="systemUser_employeeName_empName")
	WebElement ename;
	@FindBy(id="systemUser_userName")
	WebElement objusername;
	@FindBy(id="systemUser_password")
	WebElement objpassword;
	@FindBy(id="systemUser_confirmPassword")
	WebElement objCpassword;
	@FindBy(id="btnSave")
	WebElement objsave;
	public void verifyaddress(String ename,String username,String password,String Cpassword) throws Throwable
	{
		ac=new Actions(driver);
		ac.moveToElement(objAdmin).perform();
		Thread.sleep(3000);
		ac.moveToElement(objUserManagment).perform();
		Thread.sleep(3000);
		ac.moveToElement(objuser).click().perform();
		Thread.sleep(3000);
		ac.moveToElement(objadd).click().perform();
		Thread.sleep(3000);
		this.ename.sendKeys(ename);
		this.objusername.sendKeys(username);
		this.objCpassword.sendKeys(Cpassword);
		ac.moveToElement(objsave).click().perform();
		Thread.sleep(3000);
		}
}
