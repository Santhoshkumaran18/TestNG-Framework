package DataDrivenTesting;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FdCalculator {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(
				"https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		;
		String xlfile = System.getProperty("user.dir") + "/testdata/caldata.xlsx";
		int totalrows = ExcelUtilities.getRowCount(xlfile, "Sheet1");
		int totalcolumns = ExcelUtilities.getcellcount(xlfile, "Sheet1", totalrows);
		System.out.println(totalrows);
		System.out.println(totalcolumns);
		for (int r = 1; r <= totalrows; r++) {
			// 1} read data from excel
			String pri = ExcelUtilities.getCellData(xlfile, "Sheet1", r, 0);
			String rateofInterest = ExcelUtilities.getCellData(xlfile, "Sheet1", r, 1);
			String periodNumber = ExcelUtilities.getCellData(xlfile, "Sheet1", r, 2);
			String periodYears = ExcelUtilities.getCellData(xlfile, "Sheet1", r, 3);
			String fre = ExcelUtilities.getCellData(xlfile, "Sheet1", r, 4);
			String exp_maturityVaoue = ExcelUtilities.getCellData(xlfile, "Sheet1", r, 5);
			// pass above the data

			WebElement principal = driver.findElement(By.xpath("//input[@name='principal']"));
			WebElement interest = driver.findElement(By.xpath("//input[@name='interest']"));
			WebElement periodNummber = driver.findElement(By.xpath("//input[@name='tenure']"));
			WebElement periodYear1 = driver.findElement(By.xpath("//select[@id='tenurePeriod']"));
			WebElement dropdownpe = driver.findElement(By.xpath("//select[@id='tenurePeriod']"));
			Select select = new Select(dropdownpe);
			WebElement dropdownfre = driver.findElement(By.xpath("//select[@id='frequency']"));
			Select selectfre = new Select(dropdownfre);
			principal.sendKeys(pri);
			interest.sendKeys(rateofInterest);
			periodNummber.sendKeys(periodNumber);
			select.selectByVisibleText(periodYears);
			selectfre.selectByVisibleText(fre);

			WebElement calculate = driver.findElement(By.xpath("//a[@onclick='return getfdMatVal(this);']"));
			calculate.click();

			// validation

			String act_maturityValue = driver.findElement(By.xpath("//span[@class='gL_27'][@id='resp_matval']/strong"))
					.getText();
			if (Double.parseDouble(exp_maturityVaoue) == Double.parseDouble(act_maturityValue)) {
				System.out.println("Test Passed");
				ExcelUtilities.setCellData(xlfile, "Sheet1", r, 7, "Passed");
				ExcelUtilities.fillGreenColour(xlfile, "Sheet1", r, 7);
			} else {
				System.out.println("Test Failed");
				ExcelUtilities.setCellData(xlfile, "Sheet1", r, 7, "Failed");
				ExcelUtilities.fillRedColour(xlfile, "Sheet1", r, 7);
			}
			Thread.sleep(6000);
			WebElement clear = driver.findElement(By.xpath("//a[@href='javascript:void(0);']/img[@class='PL5']"));
			clear.click();

		}
		driver.quit();

	}
}
