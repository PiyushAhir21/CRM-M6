package extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

public class demofortest {

	@Test
	public void addTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		// https://testpages.herokuapp.com/styled/basic-html-form-test.html
		driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
		WebElement w4 = driver.findElement(By.name("dropdown"));
		w4.click();
		driver.findElement(By.cssSelector("option[value='dd2']")).click();
		Thread.sleep(5000);
		driver.close();
	}

	@Test
	public void badTest() {
		System.out.println("second");
	}

	@Test
	public void chadTest() {
		System.out.println("Third");
	}
}
