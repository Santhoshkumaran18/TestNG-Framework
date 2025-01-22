package ListenersExercises;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test onTestStart......");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test onTestSuccess......");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test onTestFailure......");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test onTestSkipped......");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test onTestFailedButWithinSuccessPercentage......");
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Test onTestFailedWithTimeout......");
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test onStart......");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test onFinish......");
	}
		
}
