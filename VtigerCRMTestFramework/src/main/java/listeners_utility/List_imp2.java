package listeners_utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class List_imp2 implements ITestListener, ISuiteListener {

	ExtentReports report;
	ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("DB conn + Rep config");
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
		System.out.println("DB close + Rep backup");
		report.flush();
	}
	

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("It got passed...");
		test.log(Status.PASS,"It got passed...");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("it got failed...");
		test.log(Status.FAIL, "it got failed...");
		
		TakesScreenshot tks = (TakesScreenshot) DemoForListener.sdriver;
//		File src = tks.getScreenshotAs(OutputType.FILE);
//		File dest = new File(
//				"C:/Users/User/git/VtigerCRMM6/VtigerCRMTestFramework/src/main/java/listeners_utility/ss.png");
//
//		try {
//			FileHandler.copy(src, dest);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		String ss = tks.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(ss, "Screenshot1");
		System.out.println("Taken screenshot....");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("SKipped...");
		test.log(Status.SKIP, "it got skipped...");
	}
}
