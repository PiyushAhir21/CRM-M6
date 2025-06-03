package practiceAssertion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertPractice {
	@Test
	public void case1() {
		WebDriver driver = new ChromeDriver();

		SoftAssert sa = new SoftAssert();
		sa.assertTrue(true);
		sa.assertFalse(false);

		String x = "abc";
		String y = "abc";
		String z = "def";
		
		sa.assertEquals(x, y);
		sa.assertNotEquals(x, z);

		Object obj1 = null;
		Object obj2 = new Object();
		
		sa.assertNull(obj1);
		sa.assertNotNull(obj1);


		driver.quit();
		System.out.println("stopped");
		sa.assertAll(); // Because we dont wanna stop the execution
	}
}
