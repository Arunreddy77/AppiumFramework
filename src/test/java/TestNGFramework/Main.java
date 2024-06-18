package TestNGFramework;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AddCart;
import PageObjects.FormPage;
import PageObjects.SumOfCost;

public class Main extends BaseTest{

	
	@Test
	public void AddCart() {
		FormPage formpage = new FormPage(driver);
		AddCart ac = formpage.login("Arun reddy");
		SumOfCost sc = ac.AddToCart();
		sc.Sumvalidate();
	}
	
	@Test
	public void ErrorValidation() {
		FormPage formpage = new FormPage(driver);
		AddCart ac = formpage.login("");
		String tmessage =  driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		AssertJUnit.assertEquals(tmessage, "Please enter your name");
	}
}
