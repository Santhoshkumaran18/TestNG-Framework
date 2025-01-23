package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTests { //Without using pagefactory modal
	WebDriver driver;
	
	//Constructor
	 LoginTests(WebDriver driver) {
		this.driver=driver;
	}
	
	//Locators
	By username=By.xpath("//input[@name='username']");
	By Password=By.xpath("//input[@name='password']");
	By Login=By.xpath("//button[@type='submit']");
	
	//Actions method
	public void setUserName(String user) {
		driver.findElement(username).sendKeys(user);
		
		driver.findElement(Login).click();
	}
	
	public void setPassword(String pas) {
		driver.findElement(Password).sendKeys(pas);
	}
	
	public void login() {
		driver.findElement(Login).click();
	}
}
