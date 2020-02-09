package constant;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class pbConstant {
	public static Properties p;
	public static FileInputStream fi;
	public static WebDriver driver;
	@BeforeMethod
	public void SetUp()throws Throwable
	{
		p=new Properties();
		fi=new FileInputStream("F:\\December_Selenium\\FrameWorks\\PropertyFile\\Primus.Properties");
		p.load(fi);
		if(p.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\December_Selenium\\FrameWorks\\CommonDrivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get(p.getProperty("Url"));
			driver.manage().window().maximize();
			
		}
		else if(p.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.geck.driver", "F:\\December_Selenium\\FrameWorks\\CommonDrivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.get(p.getProperty("url"));
		}
		else
		{
			System.out.println("browser not matchig");
		}
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
