package base_utility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_repository.LoginPage;

public class BaseClass {

	public WebDriver driver;

	public FileUtility fileUtil = new FileUtility();


	@BeforeSuite
	public void bs() {
		System.out.println("DB connection + Report configuration");
	}
 
	@BeforeTest
	public void bt() {
		System.out.println("Pre conditions");
	}

	@BeforeClass
	public void openingBrowser() throws IOException {
		

		String BROWSER = fileUtil.getDataFromPropertiesFile("bro");

		switch (BROWSER.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser specified. Defaulting to Chrome.");
			driver = new ChromeDriver();
			break;
		}
		WebDriverUtility wdUtil = new WebDriverUtility(driver);

		
		wdUtil.maximizeWindow();
		wdUtil.waitForPageLoad();
	}

	@BeforeMethod
	public void login() throws IOException {
		String url = fileUtil.getDataFromPropertiesFile("url");

		driver.get(url);

		LoginPage lp = new LoginPage(driver);
		lp.login();
	}

	@AfterMethod
	public void afme() {
		WebDriverUtility wdUtil = new WebDriverUtility(driver);

		// Logout from vtiger CRM
		WebElement profileImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wdUtil.hover(profileImg);

		driver.findElement(By.linkText("Sign Out")).click();

		System.out.println("Logged out successfully.");
	}

	@AfterClass
	public void closingBrowser() {
		driver.quit();
	}

	@AfterTest
	public void at() {
		System.out.println("Post conditions");
	}

	@AfterSuite
	public void as() {
		System.out.println("DB connection close + report Backup");
	}
}
