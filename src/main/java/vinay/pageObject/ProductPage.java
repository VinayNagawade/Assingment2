package vinay.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vinay.AbstactComponents.AbstactComponent;

public class ProductPage extends AbstactComponent{

	  WebDriver driver;
		
	  public ProductPage(WebDriver driver) {
		  super(driver);
		  this.driver = driver;
		  PageFactory.initElements(driver, this); 
	  }
	  By elem = By.xpath("parent::h5/parent::div/div/a[1]");
	  
	  @FindBy(css=".product-name")
	  List<WebElement> ele;
	  
	  @FindBy(xpath="//a[@title='Proceed to checkout']")
	  WebElement checkOut;
	
	  @FindBy(xpath="//p[@class='cart_navigation clearfix'] //a[@title='Proceed to checkout']")
	  WebElement checkOut2;
	  
      @FindBy(css="button[name='processAddress']")
	  WebElement checkOut3;
      
      @FindBy(css="button[name='processCarrier']")
	  WebElement checkOut4;
      
      @FindBy(xpath="//div[@id='uniform-cgv']")
	  WebElement checkBox;
      
      @FindBy(css=".product-name")
	  List<WebElement> cart;
      
      public String getProduct(String name) {
    	  String product="";
    	  for(WebElement ele : cart) {
    		  if(ele.getText().contains(name)) {
    			return  product =ele.getText();
    		  }
    	  }
    	  return product;
      }
      
      public void cheackBox() {
    	  waitForWebElementAppear(checkBox);
			 checkBox.click();
		  }
      
      public void cheackCarrierProccedToCkeckOut() {
			 checkOut4.click();
		  }
      
      public void cheackAddressProccedToCkeckOut() {
			 checkOut3.click();
		  }
	  
	  public void clickProccedToCkeckOut() {
			 checkOut2.click();
		  }
	  
	  public void proccedToCkeckOut() {
			 checkOut.click();
		  }
	  
	  public void clickOnCartButton(WebElement b) {
		 b.findElement(elem).click();
	  }
	  
	  
	  public List<WebElement> getListOfProduct() {
		  return ele;
	  }
	  
}
