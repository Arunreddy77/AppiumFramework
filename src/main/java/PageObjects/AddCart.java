package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import CodeReuseability.CodeReuseability;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddCart extends CodeReuseability{

	AndroidDriver driver;
	
	public AddCart(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
	List<WebElement> productname;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
	List<WebElement> AddtoCart;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	WebElement OpenCart;
	
	public SumOfCost AddToCart() {
		
		ScrollToView("Jordan Lift Off");
		int count =  productname.size();
		for(int i=0; i<count-1; i++) {
			AddtoCart.get(i).click();
					
		}
		OpenCart.click();
		SumOfCost sc = new SumOfCost(driver);
		return sc;
				
	}
}





