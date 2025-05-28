package typesOfExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo1 {
	@Test
	public void add() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Reporter.log("Demo1 class");
		Thread.sleep(500);
		driver.close();
	}
}
