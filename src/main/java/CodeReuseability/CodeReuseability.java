package CodeReuseability;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class CodeReuseability {
	public WebDriver driver;
	public WebDriverWait wait;
	Actions actions;

	public CodeReuseability(WebDriver driver) {

		this.driver = driver;
	}


	public void DragAndDrop(WebElement Source) {   //Drop using Co-Ordinates
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) Source).getId(),
				"endX", 700,
				"endY", 583
				));
	}

	public void StartActivity(String ActivityScreen) {
		// to know the current screen path - App package and app activity in linux
		//First open the required screen in Emulator
		//adb shell dumpsys window | grep -E 'mCurrentFocus'
		//Ex: "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"

		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent",ActivityScreen));

	}

	public void landscape() {
		DeviceRotation landscape = new DeviceRotation(0,0,90);
		//driver.rotate(landscape);
	}

	public void LongPress(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) element).getId(),
				"duration",2000));
	}

	public void ScrollToView(String TexToView) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+TexToView+"\"));"));            

	}

	public void SwipeGesture(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)element).getId(),
				"direction", "left",	
				"percent", 0.25
				));
	}
	
	




}