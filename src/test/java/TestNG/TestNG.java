package TestNG;

import org.testng.Reporter;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class TestNG {

	
	public WebDriver driver ;

public String getCurrentUrl;

@Parameters({"BrowserName"})
@BeforeSuite
public void SetBrowser(@Optional("InternetExplorer") String BrowserName)
{	
	System.out.println("Before Suite execution and driver is "+BrowserName);
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ktiwari\\Downloads\\chromedriver.exe");
	driver = new ChromeDriver();
	
}

@BeforeClass
public void SetUp()
{	
	System.out.println("Before Class execution");
	driver.manage().window().maximize();
	driver.get("https://www.ultimateqa.com/");
	driver.findElement(By.linkText("Automation Exercises")).click();
	driver.findElement(By.linkText("Interactions with simple elements")).click();
	
}

@BeforeMethod
public void LaunchURL() {
	System.out.println("Before Method execution");

	 Reporter.log("Verification Passed for Product Price");

	String handle = driver.getWindowHandle();
	getCurrentUrl = driver.switchTo().window(handle).getCurrentUrl();
}

@Parameters({"BrowserName", "user","email" })
@Test
public void loginOnUltimatePage(@Optional("InternetExplorer") String BrowserName, String user,String email) {
		
		System.out.printf("Actual Test 1 for login function execution BrowserName "+BrowserName, " User: "+user+ " email: "+email);

/*		
		//Open link in new tab
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		driver.findElement(By.id("idExample")).sendKeys(selectLinkOpeninNewTab);;
			
		//Handle Multiple windows
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		WebDriver SwitchToNewWindow =	driver.switchTo().window(tabs.get(1));	
		String URLofCurrentWindow = SwitchToNewWindow.getCurrentUrl();
		System.out.println("URLofCurrentWindow : "+URLofCurrentWindow);
		if(URLofCurrentWindow != null) {
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			driver.close();
		}
		
		driver.switchTo().window(tabs.get(0));
*/		
		
		
		/*
		driver.findElement(By.id("idExample")).click();
		String newHandle = driver.getWindowHandle();
		String getNewUrl = driver.switchTo().window(newHandle).getCurrentUrl();
		if(!getCurrentUrl.equals(getNewUrl))
		{
			driver.navigate().back();
		}
		*/
		Actions actions =new Actions(driver);
		//actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		// fill Data for email me
		WebElement name = driver.findElement(By.xpath("//*[@type='text' and @id='et_pb_contact_name_0']"));
		name.sendKeys(user);
		WebElement findEmailPath = driver.findElement(By.xpath("//*[@type='text' and @id='et_pb_contact_email_0']"));
		findEmailPath.sendKeys(email);
		driver.findElement(By.xpath("//*[@type='submit' and @class='et_pb_contact_submit et_pb_button']")).submit();
		
		
  }
 

public void fillData()
{
	System.out.println("Actual Test 2 for fill data function execution");
	Actions actions =new Actions(driver);
	//actions.sendKeys(Keys.PAGE_DOWN).perform();
	driver.findElement(By.xpath("//*[@type='radio' and @value='female']")).click();
	
	driver.findElement(By.xpath("//*[@type='checkbox' and @value='Bike']")).click();
	driver.findElement(By.xpath("//*[@type='checkbox' and @value='Car']")).click();
	
	actions.sendKeys(Keys.PAGE_DOWN).perform();
	WebElement dropDownValue = driver.findElement(By.xpath("//select"));
	Select options = new Select(dropDownValue);
	options.selectByVisibleText("Opel");
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
	actions.sendKeys(Keys.PAGE_DOWN).perform();
	
	java.util.List<WebElement> buttons =  driver.findElements(By.xpath("//button[@id='button1']"));
	buttons.get(1).click();
	
	//buttons.get(2).click();
	
}

 @AfterMethod
 public void BackToCurrentTab()
 {
	 System.out.println("AfterMethod: completed execution for current method Test");
		String newHandle = driver.getWindowHandle();
		String getNewUrl = driver.switchTo().window(newHandle).getCurrentUrl();
		
		if((!getCurrentUrl.equals(getNewUrl)) && (getCurrentUrl != null))
		{
			driver.navigate().back();
		}
	 
 }
 
@AfterClass
public void close() {
	driver.close();
}
}
