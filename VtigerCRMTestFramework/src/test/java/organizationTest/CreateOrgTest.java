package organizationTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrgTest {

	public static void main(String[] args) throws InterruptedException, IOException {

//		Get the java representation object of the physical file
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\User\\Basic_Selenium\\VtigerCRMTestFramework\\src\\test\\resources\\commonData.properties");

//		fetch keys, by using load method of Properties class
		Properties pObj = new Properties();
		pObj.load(fis);

//		get values, by using getProperty method
		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");

		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		Login in vtiger crm
		driver.get(URL);

		WebElement un = driver.findElement(By.name("user_name"));
		un.sendKeys(USERNAME);
		
		WebElement pwd = driver.findElement(By.name("user_password"));
		pwd.sendKeys(PASSWORD);

		WebElement loginBtn = driver.findElement(By.id("submitButton"));
		loginBtn.click();

//		Creating Organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

//		Filling Data
		String orgName = "Gobhi_" + (int) (Math.random() * 1000);
		WebElement orgField = driver.findElement(By.name("accountname"));
		orgField.sendKeys(orgName);

//		Save
		WebElement saveBtn = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		saveBtn.click();

//		Verification 
		WebElement header = driver.findElement(By.className("dvHeaderText"));
		String actOrgName = header.getText();

		if (actOrgName.contains(orgName)) {
			System.out.println("Created Organization successfully!!!");
		} else {
			System.out.println("FAILED!!!");
		}

////		Logout
//		WebElement profile = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		Actions act = new Actions(driver);
//		act.moveToElement(profile).perform();
//		Thread.sleep(2000);
//		driver.findElement(By.linkText("Sign Out")).click();
//		
		driver.quit();
	}
}
