package GeneralStore;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Test.Appium.BaseTest;
import io.appium.java_client.AppiumBy;

public class eCommerce extends BaseTest {

	
	@Test
	public void fillform() throws InterruptedException {
//		Thread.sleep(2000);
//		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).click();
		
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Arun Reddy");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"));"));            
		driver.findElement(By.xpath("//android.widget.TextView[@text='Austria']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//Bydefault Tagname for Toast message will be //android.widget.Toast
		String tmessage =  driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		AssertJUnit.assertEquals(tmessage, "Please enter your name");
	}
}
