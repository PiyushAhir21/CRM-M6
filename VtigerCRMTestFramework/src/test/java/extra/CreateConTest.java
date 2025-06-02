package extra;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_repository.LoginPage;

/**
 * This class automates the creation of a new organization in vtiger CRM. It
 * reads configuration from files, launches the configured browser, performs
 * login, creates an organization, verifies success, and logs out safely.
 * 
 * @author Piyush Baldaniya
 * @version 1.1
 */
public class CreateConTest {
	@Test
	public void createOrgTest() throws IOException {
		FileUtility fileUtil = new FileUtility();
		String browser = fileUtil.getDataFromPropertiesFile("bro");
		String url = fileUtil.getDataFromPropertiesFile("url");
		String lastName = fileUtil.getDataFromExcelFile("contact", 3, 0);

		WebDriver driver = null;

		// Initialize WebDriver based on browser config
		switch (browser.toLowerCase()) {
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

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Open URL and login
		driver.get(url);

//		WebElement un = driver.findElement(By.name("user_name"));
//		un.sendKeys(username);
//
//		WebElement pwd = driver.findElement(By.name("user_password"));
//		pwd.sendKeys(password);
//
//		WebElement loginBtn = driver.findElement(By.id("submitButton"));
//		loginBtn.click();

//		Login
		LoginPage lp = new LoginPage(driver);
//		lp.getUn().sendKeys("admin");
//		lp.getPwd().sendKeys("password");
//		lp.getLoginBtn().click();

		lp.login();

		// Navigate to Organizations module
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Contacts"))).click();

		// Click on Create Organization
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@title='Create Contact...']"))).click();

		// Enter organization name and save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastname"))).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Verify organization creation
		WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dvHeaderText")));
		if (header.getText().contains(lastName)) {
			System.out.println("Created Contact successfully!!!");
		} else {
			System.out.println("FAILED to create contact.");
		}

		// Logout from vtiger CRM
		WebElement profileImg = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		wdUtil.hover(profileImg);

		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Out"))).click();

		System.out.println("Logged out successfully.");

		driver.quit();
	}
}