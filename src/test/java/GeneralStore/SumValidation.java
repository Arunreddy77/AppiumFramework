package GeneralStore;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Test.Appium.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class SumValidation extends BaseTest {

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
		//ArrayList<Integer> myNumbers = new ArrayList<Integer>();
		ArrayList<Double> doubleList = new ArrayList<>();
		int n=0;
		for(int j=0; j<elem.size(); j++ ) {
			String price = elem.get(j).getText();
			//price.substring(1); if "$160.00" is there then this will give "160.00" starts from index 1
			String number = price.replace("$", "").trim();
			//Integer num = (int) Double.parseDouble(number); from String double to integer
			Double num = Double.parseDouble(number);
			System.out.println(num);
			doubleList.add(num);

		}
		double a = doubleList.get(0)+doubleList.get(1);
		String b = "$ "+a;
		System.out.println("Sum Count : "+ b);
		
		
		String sum =driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		
		AssertJUnit.assertEquals(sum, b);
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(5000);
		Set<String> contexts = driver.getContextHandles();
		for(String contexthandle : contexts) {
			System.out.println(contexthandle);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");  //To switch from Android to web view
		driver.findElement(By.name("q")).sendKeys("Rahul shetty Academy"+ "\n");
		System.out.println(driver.getCurrentUrl());
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");   // To switch back to ANdroid app from Web
		
		
		
		
		
	}
}








