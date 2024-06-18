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
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DriverCommand;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Landscape extends BaseTest {

	
	@Test
	public void test() throws IOException {
		
		// to know the current screen path - App package and app activity in linux
		//adb shell dumpsys window | grep -E 'mCurrentFocus'
	 
		// Start the activity
		// Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
        // driver.startActivity(activity);
		
		 ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
         

        
//		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//	    driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
	    driver.findElement(By.id("android:id/checkbox")).click();
	    DeviceRotation landscape = new DeviceRotation(0,0,90);
	    driver.rotate(landscape);
	    driver.findElement(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();           
	    driver.setClipboardText("Arun Reddy");
	    driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
	    driver.findElement(By.id("android:id/button1")).click();
	    driver.rotate(ScreenOrientation.PORTRAIT);
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    driver.pressKey(new KeyEvent(AndroidKey.HOME));
	    
	    
	    
	}

}



