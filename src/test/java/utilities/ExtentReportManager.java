package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter Sparkreporter; // UI of the report
	public ExtentReports report; // Common info
	public ExtentTest test;  // For creating test entries
	
	 public void onStart(ITestContext context) {
		 Sparkreporter = new ExtentSparkReporter("./reports/MyExtReport.html");  
		 
		 Sparkreporter.config().setDocumentTitle("Automation Testing");
		 Sparkreporter.config().setReportName("Functional Testing");
		 Sparkreporter.config().setTheme(Theme.DARK);
		 
		 report = new ExtentReports();
		 report.attachReporter(Sparkreporter);
		 
		 report.setSystemInfo("Computer Name", "Localhost");
		 report.setSystemInfo("Environment", "QA");
		 report.setSystemInfo("Operating System", "MacOS");
		 report.setSystemInfo("Tester Name", "Alok Tiwari");
		 report.setSystemInfo("Browser Name", "Chrome");
		 
	  }
	 
	 
	 public void onTestSuccess(ITestResult result) {
		 test = report.createTest(result.getName()); // create new entry in report
		 test.log(Status.PASS, "Testcase passed: " + result.getName()); //update status Pass/Fail/Skip
	  }

	  
	 public void onTestFailure(ITestResult result) {
	    test = report.createTest(result.getName());
	    test.log(Status.FAIL, "Testcase failed: " + result.getName());
	  }

	  
	  public void onTestSkipped(ITestResult result) {
	    test = report.createTest(result.getName());
	    test.log(Status.SKIP, "Testcase skipped: "+ result.getName());
	  }
	  
	 

		 
	   public void onFinish(ITestContext context) {
		    report.flush();
		  }
}
