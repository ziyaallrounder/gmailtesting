package generic_libraries;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Generic_Test implements Auto_Const
{
	public WebDriver driver;
	public ExtentReports reports;
	public ExtentTest tests;
	
	
	static 
	{
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	@BeforeSuite
	public void extentreport123()
	{
		reports=new ExtentReports("./report/r.html",false);
	}
	
	@BeforeTest
	public void starttest123()
	{
		tests=reports.startTest("Testscript 1");
	}
	
	
	@BeforeMethod
	public void openAppln() throws FileNotFoundException, IOException
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		String iw=Property_files.getData(PROPERTY_PATH, "iw");
		long iw1=Long.parseLong(iw);
		driver.manage().timeouts().implicitlyWait(iw1, TimeUnit.SECONDS);
		String url=Property_files.getData(PROPERTY_PATH, "url");
		
		driver.get(url);
	}
	
	@AfterMethod
	public void closeAppln(ITestResult res) throws IOException
	{
		int status=res.getStatus();
		if(status==1)
		{
			tests.log(LogStatus.PASS, "TEST CASE IS PASSED");
		}
		else
		{
			tests.log(LogStatus.FAIL, "TEST CASE IS FAILED");
			Screenshot.getPhoto(driver);
			
		}
		reports.endTest(tests);
		reports.flush();
		driver.quit();
	}
	

}
