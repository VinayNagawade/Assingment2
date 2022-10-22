package vinay.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vinay.AbstactComponents.AbstactComponent;

public class CreateUserPage extends AbstactComponent{

	  WebDriver driver;
		
	  public CreateUserPage(WebDriver driver) {
		  super(driver);
		  this.driver = driver;
		  PageFactory.initElements(driver, this); 
	  }
	
	  @FindBy(id="id_gender1")
	  WebElement mr;
	  
	  @FindBy(id="id_gender2")
	  WebElement mrs;
	  
	  @FindBy(id="customer_firstname")
	  WebElement fName;
	 
	  @FindBy(id="customer_lastname")
	  WebElement lName;
	  
	  @FindBy(id="email")
	  WebElement email;
	  
	  @FindBy(id="passwd")
	  WebElement pass;
	  
	  @FindBy(id="days")
	  WebElement day;
	  
	  @FindBy(id="months")
	  WebElement mont;
	  
	  @FindBy(id="years")
	  WebElement year;
	  
	  @FindBy(id="newsletter")
	  WebElement chek;
	  
	  @FindBy(id="optin")
	  WebElement options;
	  
	  @FindBy(id="firstname")
	  WebElement first;
	  
	  @FindBy(id="lastname")
	  WebElement last;
	  
	  @FindBy(id="company")
	  WebElement comp;
	  
	  @FindBy(id="address1")
	  WebElement add;
	  
	  @FindBy(id="address2")
	  WebElement add2;
	  
	  @FindBy(id="city")
	  WebElement cit;
	  
	  @FindBy(id="id_state")
	  WebElement stat;
	  
	  @FindBy(id="postcode")
	  WebElement code;
	  
	  @FindBy(id="other")
	  WebElement othe;
	  
	  @FindBy(id="phone")
	  WebElement phon;
	  
	  @FindBy(id="phone_mobile")
	  WebElement mobile;
	  
	  @FindBy(id="alias")
	  WebElement ali;
	  
	  @FindBy(id="submitAccount")
	  WebElement submit;
	  
	  public void submitAccount() {
		  submit.click(); 
	  }
	  
	  public void aliasAddress(String add) {
		  ali.sendKeys(add); 
	  }
	  
	  public void mobilePhoneNumber(String num) {
		  mobile.sendKeys(num); 
	  }
	  
	  public void homePhoneNumber(String num) {
		  phon.sendKeys(num); 
	  }
	  
	  public void otherInformation(String other) {
		  othe.sendKeys(other); 
	  }
	  
	  public void postalCode(String pCode) {
		  code.sendKeys(pCode); 
	  }
	  
	  public void selectState(String sta) {
		  selectFromDropdown(stat , sta); 
	  }
	  
	  public void city(String name) {
		  cit.sendKeys(name);
	  }
	  
	  public void address2(String name) {
		  add2.sendKeys(name);
	  }
	  
	  public void address(String name) {
		  add.sendKeys(name);
	  }
	  
	  public void compnyName(String name) {
		  comp.sendKeys(name);
	  }
	  
	  public void lastName(String name) {
		  last.sendKeys(name);
	  }
	  
	  public void firstName(String name) {
		  first.sendKeys(name);
	  }
	  public void offerChekBox() {
		  options.click();
	  }
	 
	  public void newsletterCheckBox() {
		  chek.click();
	  }
	 
	  public void selectDateOfBirth(String date, String month, String years) {
		  selectFromDropdown(day , date); 
		  selectFromDropdown(mont , month);
		  selectFromDropdown(year , years);
	  }
	  public void enterPassword(String password) {
		  pass.sendKeys(password);
	  }
	  public void enterEmail(String mail) {
		  email.clear();
		  email.sendKeys(mail);
	  }
	  public void enterLastName(String name) {
		  lName.sendKeys(name);
	  }
	  public void enterFirstName(String name) {
		  fName.sendKeys(name);
	  }
	  
	  public void selectGender(String gender) {
		  if(gender.contains("male"))
		     mr.click();
		  else
			  mrs.click();
			  
	  }
}
