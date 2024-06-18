package Test.Appium;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BasicAppium extends BaseTest {

	
	@Test
	public void test() throws IOException {
	 
	    driver.findElement(AppiumBy.accessibilityId("Preference")).click();
	    driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
	    driver.findElement(By.id("android:id/checkbox")).click();
	    driver.findElement(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();           
	    driver.findElement(By.id("android:id/edit")).sendKeys("Arun Reddy");
	    driver.findElement(By.id("android:id/button1")).click();
	    
	}

}



