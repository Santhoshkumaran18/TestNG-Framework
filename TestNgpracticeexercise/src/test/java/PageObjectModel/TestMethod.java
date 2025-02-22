package PageObjectModel;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestMethod {
	public WebDriver driver;
	@BeforeClass
	void setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test
	void Test() throws InterruptedException {
		LoginTests lt=new LoginTests(driver);
		LoginPageFactorymethod lt1=new LoginPageFactorymethod(driver);
		lt1.setUsername("Admin");
		lt1.setPassword("admin123");
		lt1.login(); 
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
	}
	
	@AfterClass
	void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}

