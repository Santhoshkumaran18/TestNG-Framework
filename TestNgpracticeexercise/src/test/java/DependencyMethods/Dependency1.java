package DependencyMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dependency1 {
	@Test
	void openapp() {
		Assert.assertTrue(true);
	}
	
	@Test(dependsOnMethods = {"openapp"})
	void login() {
		System.out.println("open app is passed");
	}
	
	@Test(dependsOnMethods= {"login"})
	void search() {
		System.out.println("This is search");
	}
	
	@Test (dependsOnMethods = {"search","login"})
	void advsearch() {
		System.out.println("Search is passed");
	}
	
	@Test(dependsOnMethods = {"advsearch"})
	void logout() {
		System.out.println("Advsearch is passed");
	}
	
}
