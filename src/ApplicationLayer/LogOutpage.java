package ApplicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public final class LogOutpage {
	WebDriver driver;
	Actions ac;
	public LogOutpage(WebDriver driver)
	{
		this.driver=driver;
	}
	@FindBy(id="welcome")
	WebElement objwelcome;
	@FindBy(linkText="Logout")
	WebElement objlogout;
	public void Verifylogout() throws Throwable 
	{
		ac=new Actions(driver);
		ac.moveToElement(objwelcome).click().perform();
		Thread.sleep(3000);
		ac.moveToElement(objlogout).click().perform();
		Thread.sleep(3000);
	}
	

}
