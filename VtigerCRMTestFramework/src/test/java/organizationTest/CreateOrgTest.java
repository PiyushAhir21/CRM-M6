package organizationTest;

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

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;

/**
 * This class automates the creation of a new organization in vtiger CRM.
 * It reads configuration from files, launches the configured browser,
 * performs login, creates an organization, verifies success,
 * and logs out safely.
 * 
 * @author Piyush Baldaniya
 * @version 1.1
 */
public class CreateOrgTest {

    public static void main(String[] args) throws IOException {

        FileUtility fileUtil = new FileUtility();
        String browser = fileUtil.getDataFromPropertiesFile("bro");
        String url = fileUtil.getDataFromPropertiesFile("url");
        String username = fileUtil.getDataFromPropertiesFile("un");
        String password = fileUtil.getDataFromPropertiesFile("pwd");
        String orgName = fileUtil.getDataFromExcelFile("org", 3, 0);

        WebDriver driver = null;

        try {
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
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user_name"))).sendKeys(username);
            driver.findElement(By.name("user_password")).sendKeys(password);
            driver.findElement(By.id("submitButton")).click();

            // Navigate to Organizations module
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Organizations"))).click();

            // Click on Create Organization
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@title='Create Organization...']"))).click();

            // Enter organization name and save
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("accountname"))).sendKeys(orgName);
            driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

            // Verify organization creation
            WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dvHeaderText")));
            if (header.getText().contains(orgName)) {
                System.out.println("Created Organization successfully!!!");
            } else {
                System.out.println("FAILED to create organization.");
            }

            // Logout from vtiger CRM
            WebElement profileImg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
            wdUtil.hover(profileImg);

            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Out"))).click();

            System.out.println("Logged out successfully.");

        } catch (Exception e) {
            System.err.println("Test failed due to exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
