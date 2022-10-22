package stepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import ProjectNew.baseComponent.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vinay.pageObject.CreateUserPage;
import vinay.pageObject.LandingPage;
import vinay.pageObject.ProductPage;
import vinay.pageObject.RegisterPage;


public class stepDefination extends BaseClass {
	
	public LandingPage landingPage;
    public RegisterPage registerPage;
    public CreateUserPage createUser;
    public ProductPage productPage;
    String name;
    String lname;
   
    
    @Given("I landed on Ecomerse website with {string} {string}")
    public void i_landed_on_ecomerse_website_with(String string, String string2) throws IOException {
    	name = string;
    	lname = string2;
		landingPage = launchApplication();
	}
	
    @Given("Create an account by entering details")
    public void create_an_account_by_entering_details() {
		
		registerPage = landingPage.clickOnLogin();
		registerPage.scrollPage("400");
		registerPage.enterEmailId(name+lname+"9090@gmail.com");
		createUser = registerPage.createAccount();
	}
	
	@When("Fill all details of username and  click register")
	public void fill_all_details_of_username_and_click_register() {
		
		String pass = name+lname+"1234";
		String mail = name+lname+"9090@gmail.com"; 
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
	}
	
	@When("validate currect username and surname is display")
	public void validate_currect_username_and_surname_is_display() {
		String userName =landingPage.getUserName();
		Assert.assertEquals(userName, (name+" "+lname));
	}
	
	@Then("click on logout")
	public void click_on_logout() {
		landingPage.clickOnLogOut();
		tearDown();
	}
	
	@Given("login with username and password")
	public void login_with_username_and_password() throws InterruptedException {
		
		String pass = name+lname+"1234";
		String mail = name+lname+"9090@gmail.com";
		landingPage.clickOnLogin();
		landingPage.scrollPage("400");
		landingPage.enterEmail(mail);
		landingPage.enterPassword(pass);
		Thread.sleep(4000);
		landingPage.clickOnSubmit();
	}
	@When("Add a product to the cart")
	public void add_a_product_to_the_cart() {
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
	}
	@When("Proceed to the checkout page and continue till payments")
	public void proceed_to_the_checkout_page_and_continue_till_payments() {
		productPage.proccedToCkeckOut();
		productPage.clickProccedToCkeckOut();
		productPage.cheackAddressProccedToCkeckOut();
		productPage.cheackBox();
		productPage.cheackCarrierProccedToCkeckOut();
	}
	@Then("Validate on the payments page is the product details are correct.")
	public void validate_on_the_payments_page_is_the_product_details_are_correct() {
		String prod = productPage.getProduct("Blouse");
		Assert.assertEquals(prod, "Blouse");
		tearDown();
	}


}
