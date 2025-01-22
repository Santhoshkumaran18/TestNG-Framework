package GroupingMethods;

import org.testng.annotations.Test;

public class GroupingConcepts {
	@Test (groups = {"Sanity"})
	void loginByEmail() {
		System.out.println("This is login by email");
	}
	
	@Test(groups = {"Regression","Functional"})
	void loginFacebook() {
		System.out.println("This is facebook");
	}
	
	@Test (groups = {"Sanity","Regression"})
	void logoutfacebook() {
		System.out.println("Thsi is logout facebook");
	}
}
