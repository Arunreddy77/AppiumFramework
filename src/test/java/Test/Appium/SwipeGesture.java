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
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class SwipeGesture extends BaseTest {
	
	@Test
	public void swipe() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		WebElement image1  = driver.findElement(By.xpath("//android.widget.Gallery[@resource-id='io.appium.android.apis:id/gallery']/android.widget.ImageView[1]"));
		image1.click();
		String Attributevalue = image1.getAttribute("focusable");
		//Assert.assertEquals(Attributevalue, "true");
		
		// Java
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement)image1).getId(),
		    "direction", "left",
		    "percent", 0.25
		));
		String Attributevalue1 = image1.getAttribute("focusable");
		AssertJUnit.assertEquals(Attributevalue1, "false");
		
	}

}
