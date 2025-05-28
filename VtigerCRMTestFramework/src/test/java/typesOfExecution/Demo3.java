package typesOfExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo3 {
	@Test
	public void mul() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Reporter.log("Demo3 class");
		Thread.sleep(500);
		driver.close();	}
}
