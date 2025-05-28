package typesOfExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo4 {
	@Test
	public void div() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Reporter.log("Demo4 class");
		Thread.sleep(500);
		driver.close();	}
}
