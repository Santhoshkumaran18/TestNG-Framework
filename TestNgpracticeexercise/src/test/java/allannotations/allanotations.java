package allannotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class allanotations {
	@BeforeSuite
	void abc() {
		System.out.println("This is before suite method");
	}
	
	@AfterSuite
	void bt() {
		System.out.println("This is after suite method");
	}
	@BeforeTest
	void bt1() {
		System.out.println("This is before test method");
	}
	@AfterTest
	void bt2() {
		System.out.println("This is after test method");
	}
	@BeforeMethod
	void bt3() {
		System.out.println("This is before  method");
	}
	@AfterMethod
	void bt4() {
		System.out.println("This is after  method");
	}
	@Test
	void bt5() {
		System.out.println("This is test1 method");
	}
	@Test
	void bt9() {
		System.out.println("This is test2 method");
	}
	@BeforeClass
	void bt6() {
		System.out.println("This is before class method");
	}
	@AfterClass
	void bt7() {
		System.out.println("This is after class method");
	}
}
