package practiceAssertion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertPractice {
	@Test
	public void case1() {
		WebDriver driver = new ChromeDriver();
		Assert.assertTrue(true); // true
//		Assert.assertFalse(true); // false

//		Assert.assertTrue(false); // false
		Assert.assertFalse(false); // true

		String x = "abc";
		String y = "abc";
		String z = "def";

		Assert.assertEquals(x, y); // true
//		Assert.assertEquals(y, z); // false

//		Assert.assertNotEquals(x, y);// false
		Assert.assertNotEquals(x, z);// true

		Object obj1 = null;
		Object obj2 = new Object();

		Assert.assertNull(obj1); // true
//		Assert.assertNull(obj2); // false

//		Assert.assertNotNull(obj1); // false
		Assert.assertNotNull(obj2); // true

		driver.quit();

	}
}
