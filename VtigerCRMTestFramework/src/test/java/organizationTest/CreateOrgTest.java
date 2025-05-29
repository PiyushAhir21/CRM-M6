package organizationTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.WebDriverUtility;

/**
 * This class automates the creation of a new organization in vtiger CRM. It
 * reads configuration from files, launches the configured browser, performs
 * login, creates an organization, verifies success, and logs out safely.
 * 
 * @author Piyush Baldaniya
 * @version 1.1
 */
public class CreateOrgTest extends BaseClass {
	@Test
	public void createOrgTest() throws IOException {
		String orgName = fileUtil.getDataFromExcelFile("org", 3, 0);

//		Creating Organization
		// Navigate to Organizations module
		driver.findElement(By.linkText("Organizations")).click();

		// Click on Create Organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// Enter organization name and save
		driver.findElement(By.name("accountname")).sendKeys(orgName + (int) (Math.random() * 9999));
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Verify organization creation
		WebElement header = driver.findElement(By.className("dvHeaderText"));
		if (header.getText().contains(orgName)) {
			System.out.println("Created Organization successfully!!!");
		} else {
			System.out.println("FAILED to create organization.");
		}
	}
}
