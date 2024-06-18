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

public class DragandDrop extends BaseTest{

	
	@Test
	public void DragDrpop() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement Source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		// Java
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement) Source).getId(),
		    "endX", 700,
		    "endY", 583
		));
		Thread.sleep(3000);
		String text = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		AssertJUnit.assertEquals(text, "Dropped!");
	}
}
