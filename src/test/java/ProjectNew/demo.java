package ProjectNew;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo {

	@Test
	public void abd() {
		
		WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		
		 driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
		 driver.findElement(By.cssSelector(".sfHoverForce")).click();
		 JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,900)");
			
			List<WebElement> a =driver.findElements(By.cssSelector(".product-name"));
			Actions ac = new Actions(driver);
			
			for(WebElement b:a) {
				
				if(b.getText().equalsIgnoreCase("Blouse")) {
					
					ac.moveToElement(b).build().perform();
					b.findElement(By.xpath("parent::h5/parent::div/div/a[1]")).click();
				}
				
			}
			driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
			driver.findElement(By.xpath("//p[@class='cart_navigation clearfix'] //a[@title='Proceed to checkout']")).click();
			driver.findElement(By.xpath("button[name='processAddress']")).click();
			driver.findElement(By.xpath("//div[@id='uniform-cgv']")).click();
			driver.findElement(By.xpath("button[name='processCarrier']")).click();
		
	}
}
