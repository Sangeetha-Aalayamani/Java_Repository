/**
 * Sample to illustrate the page navigation
 */
package selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
/**
 * 
 * @author sangeetha
 *
 */
public class SeleniumTest {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","d:\\lib\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://google.co.in");
		System.out.println("Get Title=" + driver.getTitle());
		System.out.println("Get URL=" + driver.getCurrentUrl());

		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Selenium Java");
		element.sendKeys(Keys.ENTER);			
		
		element = driver.findElement(By.name("btnI"));
		element.submit();
		
		System.out.println("Google Search done successfully\n");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Redirect to next page
		WebElement e = driver.findElement(By.xpath("//*[@id='rso']/div/div/div[4]/div/div/h3/a"));
		Assert.assertTrue(e.getText().contains("Downloads - Selenium"));
		e.click();
		System.out.println("Redirecting to Downloads - Selenium page sucessfully\n");
		
		WebElement e1 = driver.findElement(By.xpath("//*[@id='menu_projects']/a"));
		e1.click();
		
		System.out.println("Redirecting to Projects page sucessfully");
		
		WebElement e2 = driver.findElement(By.xpath("//*[@id='mainContent']/div/h3[1]/a"));
		e2.click();		
		System.out.println("Go to search in selenium page ");
		
		WebElement e3 = driver.findElement(By.name("q"));		
		e3.sendKeys("Java");
		e3.sendKeys(Keys.ENTER);
		
		e3 = driver.findElement(By.xpath("//*[@id='submit']"));
		e3.submit();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Search done successfully in the selenium screen \n");
			
		driver.close();
	}
}