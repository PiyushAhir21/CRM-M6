package extra;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class WorkingWithAdvanceReports {

	ExtentReports report;

	@BeforeSuite
	public void bs() {
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

	@Test
	public void case1() {

		ExtentTest test = report.createTest("case1");
		test.log(Status.INFO, "This is information");
		test.log(Status.PASS, "This is pass");
		test.log(Status.SKIP, "This is skip");
		test.log(Status.WARNING, "This is just warning");
		test.log(Status.FAIL, "This is finally failed");

	}

	@Test
	public void case2() {

		ExtentTest test = report.createTest("case2");
		test.log(Status.INFO, "This is information");
		test.log(Status.PASS, "This is pass");
	}

	@Test
	public void case3() {

		ExtentTest test = report.createTest("case3");
		test.log(Status.INFO, "This is information");
		test.log(Status.PASS, "This is pass");
	}

	@AfterSuite
	public void repBackup() {
		report.flush();

	}
}
