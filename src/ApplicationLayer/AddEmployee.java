package ApplicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddEmployee {
	WebDriver driver;
	Actions AC;
	public AddEmployee(WebDriver driver)
	{
		this.driver=driver;
	}
	@FindBy(id="menu_pim_viewPimModule")
	WebElement objpim;
	@FindBy(css="#btnAdd")
	WebElement objadd;
	@FindBy(css="#firstName")
	WebElement objfname;
	@FindBy(css="#lastName")
	WebElement objlname;
	@FindBy(css="#btnSave")
	WebElement objsave;
	public void verifyemp(String fname,String lname) throws Throwable
	{
		AC=new Actions(driver);
		AC.moveToElement(objpim).click().perform();
		Thread.sleep(3000);
		AC.moveToElement(objadd).click().perform();
		Thread.sleep(3000);
		objfname.sendKeys(fname);
		objlname.sendKeys(lname);
		AC.moveToElement(objsave).click().perform();
		Thread.sleep(3000);
		
	}

}
