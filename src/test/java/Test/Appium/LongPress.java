package Test.Appium;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest {
	
	@Test
	public void longpress() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement elem = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		
		// Java
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement) elem).getId(),
		    "duration",2000));
		String text = driver.findElement(By.id("android:id/title")).getText();
		AssertJUnit.assertEquals(text, "Sample menu");
	}
	

}
