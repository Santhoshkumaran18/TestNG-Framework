package Testanotationbeforafter;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class c1 {
		@Test
		void abc() {
			System.out.println("This is normal test method");
		}
		
		@BeforeTest
		void bt() {
			System.out.println("This is before test method");
		}
}
