package extra;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMExecution {

	WebDriver driver;

//	initialization
	public POMExecution(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	Declaration
	@FindBy(name = "user_name")
	private WebElement un;

	public WebElement getUn() {
		return un;
	}

	@FindBy(name = "user_password")
	private WebElement pwd;

	public WebElement getPwd() {
		return pwd;
	}

	@FindBy(id = "submitButton")
	private WebElement loginBtn;

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("http://localhost:8888/");

//		WebElement un = driver.findElement(By.name("user_name"));
//		driver.navigate().refresh();
//		un.sendKeys("admin"); // SERE

//		Utilization
		POMExecution pom = new POMExecution(driver);

		WebElement un = pom.getUn();
		un.sendKeys("admin");

//		WebElement pwd = driver.findElement(By.name("user_password"));
//		pwd.sendKeys("password");

		pom.getPwd().sendKeys("password");

//		WebElement loginBtn = driver.findElement(By.id("submitButton"));
//		loginBtn.click();

		pom.getLoginBtn().click();

		Thread.sleep(10000);
		driver.close();
	}
}
