package GeneralStore;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Test.Appium.BaseTest;
import io.appium.java_client.AppiumBy;

public class SumValidationLogic extends BaseTest {

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
		System.out.println("Product count : " + productcount);
		for(int i=0; i<productcount-1; i++) {
			pname =  driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();

			driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();

		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		List<WebElement> elem = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		System.out.println("Size : "+ elem.size());
		double n=0;
		for(int j=0; j<elem.size(); j++ ) {
			String price = elem.get(j).getText();
			Double num = Double.parseDouble(price.substring(1));
			n= n+ num;
		}
		
		System.out.println(n);
		String b = "$ "+n;
		System.out.println("Sum Count : "+ b);
		String sum =driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		
		AssertJUnit.assertEquals(sum, b);
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(2000);
		//System.out.println(driver.getCurrentUrl());
		
		
		
		
	}
}








