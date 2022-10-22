package vinay.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vinay.AbstactComponents.AbstactComponent;

public class LandingPage extends AbstactComponent {

	  WebDriver driver;
	
	  public LandingPage(WebDriver driver) {
		  super(driver);
		  this.driver = driver;
		  PageFactory.initElements(driver, this); 
	  }
	  
	  @FindBy(id="email")
	  WebElement mail;
	  
	  @FindBy(css=".login")
	  WebElement login;
	  
	  @FindBy(css=".logout")
	  WebElement logot;
	  
	  @FindBy(css=".account")
	  WebElement acc;
	  
	  @FindBy(id="passwd")
	  WebElement pas;
	  
	  @FindBy(id="SubmitLogin")
	  WebElement submit;
	  
	  @FindBy(xpath="//a[@title='Women']")
	  WebElement woman;
	  
	  public ProductPage clickOnWomen() {
		  waitForWebElementAppear(woman);
			woman.click();
			ProductPage productPage = new ProductPage(driver);
			return productPage;
		}
	  
	  public void clickOnSubmit() {
			submit.click();
		}
	  
	  public void enterPassword(String pass) {
			 pas.sendKeys(pass);
		}
	  
	  public void enterEmail(String email) {
			 mail.sendKeys(email);
		}
	  
	  public void clickOnLogOut() {
		 logot.click();
	}
	 
	  public String getUserName() {
		String name =  acc.getText();
		return name;
	  }
	  
	  public void goTo() {
		  driver.get("http://automationpractice.com/index.php");
		  driver.manage().window().maximize();
		  
	  }
	  
	public RegisterPage clickOnLogin() {
		login.click();
		RegisterPage registerPage = new RegisterPage(driver);
		return registerPage;
	}

	
 	  
	  
	  
	  
}
