package ProjectNew;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ProjectNew.baseComponent.BaseClass;
import ProjectNew.baseComponent.Retry;
import vinay.pageObject.CreateUserPage;
import vinay.pageObject.ProductPage;
import vinay.pageObject.RegisterPage;


public class StandAloneTest extends BaseClass {

	public RegisterPage registerPage;
	public CreateUserPage createUser; 
	 public ProductPage productPage;
	@Test
	public  void registerOnWebsite() throws InterruptedException, IOException {
		String name = "vjatyr";
		String lname = "jaayant";
		String pass = name+lname+"1234";
		String mail = name+lname+"9090@gmail.com";
		registerPage = landingPage.clickOnLogin();
		registerPage.scrollPage("400");
		registerPage.enterEmailId(name+lname+"9090@gmail.com");
		createUser = registerPage.createAccount();
		createUser.selectGender("male");
		createUser.enterFirstName(name);
		createUser.enterLastName(lname);
		createUser.enterEmail(mail);
		createUser.enterPassword(pass);
		createUser.selectDateOfBirth("15", "May", "2001");
		registerPage.scrollPage("200");
		createUser.newsletterCheckBox();
		createUser.offerChekBox();
		createUser.firstName("kapil");
		createUser.lastName("kale");
		createUser.compnyName("relience");
		createUser.address("abc");
		createUser.address2("xyz");
		createUser.city("pune");
		registerPage.scrollPage("200");
		createUser.selectState("Florida");
		createUser.postalCode("00000");
		createUser.otherInformation("dfdffda");
		createUser.homePhoneNumber("12345678");
		createUser.mobilePhoneNumber("98765432");
		createUser.aliasAddress("mumbai");
		createUser.submitAccount();
		String userName =landingPage.getUserName();
		Assert.assertEquals(userName, (name+" "+lname));
		landingPage.clickOnLogOut();
		landingPage.clickOnLogin();
		landingPage.scrollPage("400");
		landingPage.enterEmail(mail);
		landingPage.enterPassword(pass);
		landingPage.clickOnSubmit();
		productPage = landingPage.clickOnWomen();
		productPage.scrollPage("900");
		List<WebElement> a =productPage.getListOfProduct();
		Actions ac = new Actions(driver);
		
		for(WebElement b:a) {
			
			if(b.getText().equalsIgnoreCase("Blouse")) {
				ac.moveToElement(b).build().perform();
				productPage.clickOnCartButton(b);	
			}	
		}
		productPage.proccedToCkeckOut();
		productPage.clickProccedToCkeckOut();
		productPage.cheackAddressProccedToCkeckOut();
		productPage.cheackBox();
		productPage.cheackCarrierProccedToCkeckOut();
		
		String prod = productPage.getProduct("Blouse");
		Assert.assertEquals(prod, "Blouse");
		
	}
	
 
	
	
	
	
	
	
	
	
	

}
