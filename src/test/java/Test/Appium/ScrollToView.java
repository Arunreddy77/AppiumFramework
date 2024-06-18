package Test.Appium;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollToView extends BaseTest {

	
	@Test
	public void SCroll() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//Scrolling by using Element Text on UI
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));            
	}
}
