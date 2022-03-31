package Framework.SeleniumJava;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportUtility;
import resources.base;

public class Listeners extends base implements ITestListener {

	ExtentTest test;
	ExtentReports extent = ExtentReportUtility.getReportObject();
	//while parallel execution threadlocal is used
	// as the objects are send in the poll and will not be overridden and it will take care while running tests in parallel
	ThreadLocal<ExtentTest>extentTest = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); //parallel execution
	

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//test.log(Status.PASS,"Test Passed");//single execution
		extentTest.get().log(Status.PASS, "Test Passed"); //parallel execution
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		//test.fail(result.getThrowable());//single execution
		extentTest.get().fail(result.getMethod().getMethodName());//parallel execution
		
		WebDriver driver = null;
		String testMethod = result.getMethod().getMethodName();
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}  catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//code to capture screenshot
		try {
			//take the screenschot in the extent report
			extentTest.get().addScreenCaptureFromPath(getScreenshotPath(testMethod,driver), result.getMethod().getMethodName());
			//getScreenshotPath(testMethod,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

}
