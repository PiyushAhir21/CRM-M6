package typesOfExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo2 {
	@Test(groups =  "regression")
	public void sub() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Reporter.log("Demo2 class");
		Thread.sleep(500);
		driver.close();	}
}
