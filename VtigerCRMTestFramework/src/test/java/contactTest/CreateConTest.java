package contactTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base_utility.BaseClass;

/**
 * This class automates the creation of a new organization in vtiger CRM. It
 * reads configuration from files, launches the configured browser, performs
 * login, creates an organization, verifies success, and logs out safely.
 * 
 * @author Piyush Baldaniya
 * @version 1.1
 */
public class CreateConTest extends BaseClass {
	@Test
	public void createConTest() throws IOException {
		String lastName = fileUtil.getDataFromExcelFile("contact", 3, 0);

//		Creating Contact
		// Navigate to Organizations module
		driver.findElement(By.linkText("Contacts")).click();

		// Click on Create Organization
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// Enter organization name and save
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

// 		Verify contact creation
		WebElement header = driver.findElement(By.className("dvHeaderText"));
		if (header.getText().contains(lastName)) {
			System.out.println("Created Contact successfully!!!");
		} else {
			System.out.println("FAILED to create contact.");
		}

	}
}
