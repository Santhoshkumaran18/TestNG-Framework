package TestNGPractise;

import org.testng.annotations.Test;

public class OpenApplication {
	@Test(priority = -1)
	void openapp() {
		System.out.println("This is open application");
		
	}
	@Test (priority = 1)
	void login() {
		System.out.println("This is login application");
	}
	
	@Test
	void logout() {
		System.out.println("This is logout application");
	}
	
}
