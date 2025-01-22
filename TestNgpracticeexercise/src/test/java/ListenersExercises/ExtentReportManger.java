package ListenersExercises;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManger implements ITestListener{
	public ExtentSparkReporter extentsparkreport;
	public ExtentReports extentreport;
	public ExtentTest test;
	@Override
	public void onStart(ITestContext context) {
		extentsparkreport=new ExtentSparkReporter(System.getProperty("user.dir") +
				"/reports/reports.html");
		
		extentsparkreport.config().setDocumentTitle("Automation Report"); //Title of report
		extentsparkreport.config().setReportName("Functional Testing");//Name of the report
		extentsparkreport.config().setTheme(Theme.STANDARD);
		
		extentreport=new ExtentReports();
		extentreport.attachReporter(extentsparkreport);
		
		extentreport.setSystemInfo("ComputerName","localhost");
		extentreport.setSystemInfo("TesterName", "Santhosh");
		
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test=extentreport.createTest(result.getName());
		test.log(Status.PASS,"Test case passed is: " + result.getName());
	}

	
	@Override
	public void onTestFailure(ITestResult result) {
		test=extentreport.createTest(result.getName());
		test.log(Status.FAIL,"Test case failed is: " + result.getName());
		test.log(Status.FAIL,"Test case failed is: " + result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		extentreport.flush();
	}
	
	
	
	
	
	
}
