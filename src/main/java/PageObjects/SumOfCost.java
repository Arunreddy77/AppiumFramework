package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import CodeReuseability.CodeReuseability;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SumOfCost extends CodeReuseability{

	AndroidDriver driver;
	
	public SumOfCost(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	List<WebElement> productPrice;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	WebElement TotalCost;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	WebElement Terms;
	
	@AndroidFindBy(className = "android.widget.CheckBox")
	WebElement checkBox;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	WebElement CompletePurchase;
	
	@AndroidFindBy(id = "android:id/button1")
	WebElement close;
	
	public void Sumvalidate() {
		System.out.println("Size : "+ productPrice.size());
		double n=0;
		for(int j=0; j<productPrice.size(); j++ ) {
			String price = productPrice.get(j).getText();
			Double num = Double.parseDouble(price.substring(1));
			n= n+ num;
		}
		System.out.println(n);
		String SumCost = "$ "+n;
		System.out.println("Sum Count : "+ SumCost);
		String tcost = TotalCost.getText();
		
		Assert.assertEquals(tcost, SumCost);
		LongPress(Terms);
		close.click();
		checkBox.click();
		CompletePurchase.click();
		
	}
	
	
}









