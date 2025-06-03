package extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners_utility.LIst_Imp.class)
public class ListeneresExample {
	@Test
	public void case1() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Assert.assertTrue(true);
	}
	
	@Test
	public void case2() {
		Assert.assertTrue(true);
	}
	
	@Test
	public void case3() {
		Assert.assertTrue(false);
	}
}
