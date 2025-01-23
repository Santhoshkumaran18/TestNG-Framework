package ListenersExercises;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ListernersExerceise {
public WebDriver driver;
	
	@Parameters({"browser"})
	@BeforeClass
	void setup(String browser) {
		
		switch (browser.toLowerCase()) {
		case "chrome":driver = new ChromeDriver();break;
		case "edge":driver=new EdgeDriver();break;
		default:{
			driver = new ChromeDriver();break;
		}
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}
	
	@Test(priority = 1)
	void testLogo() throws InterruptedException {
		Thread.sleep(5000);
		WebElement logo=driver.findElement(By.xpath("//img[@alt='company-branding']"));
		boolean logod=logo.isDisplayed();
		if(logod) {
			System.out.println("Logo is displayed");
		}else {
			System.out.println("Logo is not displayed");
		}
		Assert.assertEquals(true, logod);
		
	}
	
	@Test(priority = 2)
	void testURL() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test(priority = 3,dependsOnMethods = {"testURL"})
	void testTitle() {
		Assert.assertEquals(driver.getTitle(), "OrangeHR");
	}
	
	
	
	@AfterClass()
	void tearDown() {
		driver.quit();
	}
}
