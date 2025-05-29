package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

//	initialize

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	Declaration
//	@FindBy(name = "user_name")
//	private WebElement un;

//	input[type='text'] 
//	name = "user_name"
	
//	AutoHealing
	@FindAll({@FindBy(name = "user_name"),
				@FindBy(css = "input[type='text']")
			})
	private WebElement un;

	
	@FindBy(name = "user_password")
	private WebElement pwd;

	@FindBy(id = "submitButton")
	private WebElement loginBtn;

//	Getters
	public WebElement getUn() {
		return un;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void login() {
		getUn().sendKeys("admin");
		getPwd().sendKeys("admin");
		getLoginBtn().click();
	}

}
