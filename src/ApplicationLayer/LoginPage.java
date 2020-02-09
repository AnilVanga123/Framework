package ApplicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	Actions ac;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	@FindBy(id="txtUsername")
	WebElement objuseraname;
	@FindBy(id="txtPassword")
	WebElement objpassword;
	@FindBy(id="btnLogin")
	WebElement objlogin;
	public void VerifyLogin(String username,String password)
	{
		ac=new Actions(driver);
		objuseraname.sendKeys(username);
		objpassword.sendKeys(password);
		objlogin.click();
	}
}
