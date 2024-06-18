package TestNGFramework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import CodeReuseability.CodeReuseability;
import io.appium.java_client.AppiumDriver;



public class Listeners extends BaseTest implements ITestListener{

	AppiumDriver driver;
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); 
	ExtentReports extent = ExtentReporterNG.getReportObject();
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);  //unique thread id when tests run in parallel
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		try {
			test.addScreenCaptureFromPath(getScreenshot(result.getMethod().getMethodName(), driver),result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		try {
			driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		try {
			test.addScreenCaptureFromPath(getScreenshot(result.getMethod().getMethodName(), driver),result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
