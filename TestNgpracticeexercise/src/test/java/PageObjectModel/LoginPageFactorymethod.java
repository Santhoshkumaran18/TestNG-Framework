package PageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactorymethod { //using the page factory method
	public WebDriver driver;
	
	public LoginPageFactorymethod(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement username;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement login;
	@FindBy(tagName = "a")
	List<WebElement> links;
	
	public void setUsername(String user) {
		username.sendKeys(user);
	}
	public void setPassword(String pass) {
		password.sendKeys(pass);
	}
	public void login() {
		login.click();
	}
	
}
