package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);//to initialize web elements
	}
	@FindBy(xpath="//input[@id = 'loginform-username']")WebElement userNameField;
	@FindBy(xpath="//input[@id = 'loginform-password']")WebElement passwordField;
	@FindBy(xpath="//button[@class = 'btn btn-default']")WebElement loginButton;
	@FindBy(xpath="//p[text()='Welcome to Payroll Application']")WebElement welcomeText;
	@FindBy(xpath="//p[text() = 'Incorrect username or password.']")WebElement alertMessage;
	
	public void enterUsernameonUsernameField(String username) {
		userNameField.sendKeys(username);
		
	}
	public void enterPasswordOnpasswordField(String password) {
		passwordField.sendKeys(password);
		
	}
	public void loginButtonClick() {
		loginButton.click();
	}
	public boolean ishomePageLoded() {
		return welcomeText.isDisplayed();
	}
	public boolean isalertdisplayed() {
		return alertMessage.isDisplayed();
		
	}

}
