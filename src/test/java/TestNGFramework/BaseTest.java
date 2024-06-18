package TestNGFramework;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.FormPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AndroidDriver driver;


	@BeforeMethod
	public void config() throws IOException {
		//		AppiumDriverLocalService service  = new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/nodejs/lib/node_modules/appium/lib/main.js"))
		//				.withIPAddress("127.0.0.1").usingPort(4723).build();
		//		service.start();
		//		
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("AppiumTestEmulator");
		options.setChromedriverExecutable("/home/arunkumar/Downloads/chromedriver-linux64/chromedriver");
		options.setApp("/home/arunkumar/eclipse-workspace/AppiumFramework/src/test/java/Resources/General-Store.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
	
	public String getScreenshot(String testCaseName, AppiumDriver driver) throws IOException {

		File source = driver.getScreenshotAs (OutputType.FILE);
		String destinationfile = System.getProperty("user.dir") + "/reports/" + testCaseName + ".png"; 
		FileUtils.copyFile(source, new File(destinationfile));
		return destinationfile;
	}
}
