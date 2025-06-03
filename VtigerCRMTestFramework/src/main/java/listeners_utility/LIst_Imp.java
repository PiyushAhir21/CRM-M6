package listeners_utility;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LIst_Imp implements ITestListener,ISuiteListener{
	ExtentReports report;

	@Override
	public void onStart(ISuite suite) {
		ExtentSparkReporter spark = new ExtentSparkReporter(
				"C:\\Users\\User\\git\\VtigerCRMM6\\VtigerCRMTestFramework\\AdvanceReports\\dummRep.html");
		spark.config().setDocumentTitle("Dummy Report");
		spark.config().setReportName("First Report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();

		report.attachReporter(spark);

	
		
		report.setSystemInfo("browser", "chrome");
		report.setSystemInfo("windows", "11");
		report.setSystemInfo("date", "02 - June - 2025");

	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

	@Override
	public void onTestSuccess(ITestResult result) {
//		test.log(Status.PASS, "This is pass");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " method is running");
		ExtentTest test = report.createTest(result.getMethod().getMethodName());
		System.out.println(result.getMethod().getMethodName() + " method got executed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
//		System.out.println("Ohh nooo!!! It got failed !!! we need to take ss");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
//		System.out.println("Sheyyyy !!! It got skipped....");
	}
	
}
