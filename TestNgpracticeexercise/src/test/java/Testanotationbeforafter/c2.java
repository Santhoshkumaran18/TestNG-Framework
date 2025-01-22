package Testanotationbeforafter;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class c2 {
		@Test
		void xyz() {
			System.out.println("This is normal test method in 2nd class");
		}
		
		@AfterTest
		void at() {
			System.out.println("This is after test method");
		}
}
