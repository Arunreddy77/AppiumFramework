package TestNGFramework;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	static ExtentReports extent;

	@BeforeTest
	public static ExtentReports getReportObject()
	{
		// ExtentReports, ExtentSparkReporter
		String path =System.getProperty("user.dir")+"/reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter (path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");

		extent =new ExtentReports();
		extent.attachReporter (reporter);
		extent.setSystemInfo("Tester", "Arun Reddy");
		return extent;
	}
}
