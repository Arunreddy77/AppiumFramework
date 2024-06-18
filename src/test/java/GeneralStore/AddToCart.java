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

public class AddToCart extends BaseTest {

	public String pname;
	
	@Test
	public void fillform() throws InterruptedException {
//		Thread.sleep(2000);
//		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Arun Reddy");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"));"));            
		driver.findElement(By.xpath("//android.widget.TextView[@text='Austria']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"));"));            
		int productcount =  driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for(int i=0; i<productcount; i++) {
			 pname =  driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(pname.equalsIgnoreCase("Jordan Lift Off")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		String cartPname = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText(); 
		AssertJUnit.assertEquals(cartPname, "Jordan Lift Off");
		
	}
}
