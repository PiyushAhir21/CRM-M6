package organizationTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;

public class CreateOrgTest {

	public static void main(String[] args) throws InterruptedException, IOException {

//		Get data from properties file
		FileUtility fUtil = new FileUtility();
		
		String BROWSER = fUtil.getDataFromPropertiesFile("bro");
		String URL = fUtil.getDataFromPropertiesFile("url");
		String USERNAME = fUtil.getDataFromPropertiesFile("un");
		String PASSWORD = fUtil.getDataFromPropertiesFile("pwd");

//		Get data from excel file
		String orgName = fUtil.getDataFromExcelFile("org", 3, 0);
		
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
		
		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		wdUtil.maximizeWindow();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		Login in vtiger crm
		driver.get(URL);

		WebElement un = driver.findElement(By.name("user_name"));
		un.sendKeys(USERNAME);

		WebElement pwd = driver.findElement(By.name("user_password"));
		pwd.sendKeys(PASSWORD);

		WebElement loginBtn = driver.findElement(By.id("submitButton"));
		loginBtn.click();

////		Creating Organization
//		driver.findElement(By.linkText("Organizations")).click();
//		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//
////		Filling Data
////		String orgName = "Gobhi_" + (int) (Math.random() * 1000);
//		WebElement orgField = driver.findElement(By.name("accountname"));
//		orgField.sendKeys(orgName);
//
////		Save
//		WebElement saveBtn = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
//		saveBtn.click();
//
////		Verification 
//		WebElement header = driver.findElement(By.className("dvHeaderText"));
//		String actOrgName = header.getText();
//
//		if (actOrgName.contains(orgName)) {
//			System.out.println("Created Organization successfully!!!");
//		} else {
//			System.out.println("FAILED!!!");
//		}

////		Logout
		WebElement profile = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		Hover
//		Actions act = new Actions(driver);
//		act.moveToElement(profile).perform();
		
		wdUtil.hover(profile);
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();
	}
}
