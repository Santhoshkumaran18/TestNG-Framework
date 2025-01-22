package GroupingMethods;

import org.testng.annotations.Test;

public class PaymentsTestMethod {
	@Test(groups = {"Santhosh"})
	void paymentInrupeess() {
		System.out.println("Payment in rupees");
	}
	
	@Test (groups = {"Sanity","Regression"})
	void paymentincurrency() {
		System.out.println("This is payment in currencey");
	}
}
