package listeners_utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners_utility.List_imp2.class)
public class DemoForListener {

	WebDriver driver;
	static WebDriver sdriver;

	@BeforeClass
	public void openBro() {
		driver = new ChromeDriver();
		sdriver = driver;
	}

//	@Test
//	public void case1() {
//		System.out.println("------case1------");
//		driver.get("http://shadi.com/");
//		Assert.assertTrue(true);
//		driver.close();
//	}

	@Test
	public void case1() throws InterruptedException {
		System.out.println("------case2------");
		driver.get("https://www.facebook.com/");
		driver.findElement(By.linkText("Create new account")).click();
		Thread.sleep(5000);
		Assert.assertTrue(false);
		driver.close();
	}

//	@Test
//	public void case3() {
//		System.out.println("------case3------");
//		driver.get("http://shadi.com/");
//		Assert.assertTrue(true);
//		driver.close();
//	}
}
