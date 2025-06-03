package listeners_utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class List_imp2 implements ITestListener, ISuiteListener{
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("it got passed...");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("it got failed");
		TakesScreenshot tks = (TakesScreenshot) DemoForListener.sdriver;
		File src =  tks.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:/Users/User/git/VtigerCRMM6/VtigerCRMTestFramework/src/main/java/listeners_utility/ss.png");
		
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
