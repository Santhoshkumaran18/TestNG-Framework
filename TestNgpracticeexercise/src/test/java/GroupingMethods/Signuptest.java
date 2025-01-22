package GroupingMethods;

import org.testng.annotations.Test;

public class Signuptest {
	@Test (groups = {"Regression"})
	void signup() {
		System.out.println("This is signup by email");
	}
	
	@Test (groups = {"Sanity"})
	void signupbytwitter() {
		System.out.println("This is signup by Twitter");
	}
}
