package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import CodeReuseability.CodeReuseability;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends CodeReuseability{

	AndroidDriver driver;
	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); //select decorator for page factory
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	WebElement nameField;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
	WebElement female;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
	WebElement male;
	
	@AndroidFindBy(id = "android:id/text1")
	WebElement textbox;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Austria']")
	WebElement State;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	WebElement Letsshop;
	
	
	public AddCart login(String name) {
		nameField.sendKeys(name);
		driver.hideKeyboard();
		female.click();
		male.click();
		textbox.click();
		ScrollToView("Austria");
		State.click();
		Letsshop.click();
		AddCart ac = new AddCart(driver);
		return ac;
	}
	
	
}




