package vinay.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vinay.AbstactComponents.AbstactComponent;

public class RegisterPage extends AbstactComponent{

	  WebDriver driver;
		
	  public RegisterPage(WebDriver driver) {
		  super(driver);
		  this.driver = driver;
		  PageFactory.initElements(driver, this); 
	  }
	  
	  
	  
	  @FindBy(id="email_create")
	  WebElement email;
	  
	  @FindBy(id="SubmitCreate")
	  WebElement create;
	  
	  public void enterEmailId(String mailId) {
		 email.sendKeys(mailId); 
	  }
	  
	  public CreateUserPage createAccount() {
		  create.click();
		  CreateUserPage createUser = new CreateUserPage(driver);
		  return createUser;
	 }
	  
}
