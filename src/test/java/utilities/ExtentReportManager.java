package utilities;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
		   String repName;
	 public void onStart(ITestContext context) {
		 
		 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 repName = "Test-Report"+ timeStamp+".html";
		 Sparkreporter = new ExtentSparkReporter("./reports"+ repName);  
		 
		 Sparkreporter.config().setDocumentTitle("Opencart Automation Testing Report");
		 Sparkreporter.config().setReportName("Opencart Functional Testing");
		 Sparkreporter.config().setTheme(Theme.DARK);
		 
		 report = new ExtentReports();
		 report.attachReporter(Sparkreporter);
		 
		 report.setSystemInfo("Application", "Opencart");
		 report.setSystemInfo("Module","Admin");
		 report.setSystemInfo("SubModule", "customer");
		 report.setSystemInfo("Username", System.getProperty("user.name"));
		 report.setSystemInfo("Environment", "QA");
		 String os = context.getCurrentXmlTest().getParameter("os");
		 report.setSystemInfo("Operating System", os);
		 String browser = context.getCurrentXmlTest().getParameter("browser");
		 report.setSystemInfo("Browser Name", browser);
		 report.setSystemInfo("Tester Name", "Alok Tiwari");
		 
		 List<String> IncludedGroups = context.getCurrentXmlTest().getIncludedGroups();
		 if(!IncludedGroups.isEmpty()) {
			 report.setSystemInfo("Groups", IncludedGroups.toString());
		 }
	  }
	 
	 
	 public void onTestSuccess(ITestResult result) {
		 test = report.createTest(result.getTestClass().getName()); // create new entry in report
		 test.assignCategory(result.getMethod().getGroups()); // to display groups in report
		 test.log(Status.PASS, result.getName()+ " Testcase got successfully executed"); //update status Pass/Fail/Skip
	  }

	  
	 public void onTestFailure(ITestResult result) {
	    test = report.createTest(result.getName());
	    test.assignCategory(result.getMethod().getGroups());
	    test.log(Status.FAIL, result.getName() + " Testcase got failed" );
	  }

	  
	  public void onTestSkipped(ITestResult result) {
	    test = report.createTest(result.getName());
	    test.assignCategory(result.getMethod().getGroups());
	    test.log(Status.SKIP, result.getName()+ " Testcase got skipped");
	  }
	  
	 

		 
	   public void onFinish(ITestContext context) {
		    report.flush();
		  }
}
