package AssertionMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsExercise {
		@Test
		void testTitle1() {
			String exp_title="Santhosh";
			String act_title="Santhosh";
			
			if(exp_title.equals(act_title)) {
				System.out.println("The title are mathcing");
				Assert.assertTrue(true);
			}else {
				System.out.println("The title are not matching");
				Assert.assertTrue(false);
			}
			
			Assert.assertEquals(exp_title, act_title);
		}
}
