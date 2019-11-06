package scripts;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExtendReportDemo 
{
	@Test
	public void test1()
	{
		ExtentReports reports=new ExtentReports("./report/r.html",false);
		ExtentTest tests=reports.startTest("test scripts");
		
		tests.log(LogStatus.PASS, "test case is passed");
		tests.log(LogStatus.FAIL, "test case is failed");
		tests.log(LogStatus.SKIP, "test case is skipped");
		tests.log(LogStatus.ERROR, "ERROR");
		tests.log(LogStatus.WARNING, "warning");
		tests.log(LogStatus.FATAL, "blocker");
		
		reports.endTest(tests);
		reports.flush();
	}

}
