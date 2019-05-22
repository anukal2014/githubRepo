package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class FormDetail extends TestNG{
	//public WebDriver driver ;

	String getCurrentUrl;

/*	@BeforeSuite 
	public void SetBrowser()
	{	
		System.out.println("Before Suite execution for form details class");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ktiwari\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}*/

	@Parameters({ "BrowserName" })
	@BeforeClass
	public void SetUp(@Optional("InternetExplorer") String BrowserName)
	{	
		System.out.println("Before Class execution for form and browser is "+ BrowserName);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ktiwari\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.ultimateqa.com/");
		driver.findElement(By.linkText("Automation Exercises")).click();
		driver.findElement(By.linkText("Fill out forms")).click();
		
	}

	@BeforeMethod
	public void LaunchURL() {
		System.out.println("Before Method execution on form submit page");
		
	}
	
	
	@Test(priority=1)
	
	  public void form() {
			
			System.out.println("Actual Test 1 for form submit execution");
	}
	
	 @AfterMethod
	 public void NavigateToPrevPage()
	 {
		 System.out.println("AfterMethod: completed execution for current method Test");
		 
				 
	 }
	 @AfterClass
	 public void close() {
	 	driver.close();
	 }
}
