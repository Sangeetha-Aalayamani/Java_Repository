package selenium.practice;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Basics {
	
	public static void main(String[] args) throws URISyntaxException {
		
		System.setProperty("webdriver.chrome.driver","d:\\lib\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		org.openqa.selenium.Capabilities capabilities = ((RemoteWebDriver)driver).getCapabilities();
		driver.get("http://wikipedia.org/");
		
		// get browser name and version
		String browserName = capabilities.getBrowserName();
		String browserVersion = capabilities.getVersion();
		
		System.out.println("browserName=="+browserName);
		System.out.println("browserVersion=="+browserVersion);
		
		// to execute javascript in selenium wd
		JavascriptExecutor executor =(JavascriptExecutor)driver;
		//executor.executeScript("window.confirm('Do you agree');");			
				
		//use of xpath
		//driver.findElement(By.xpath("//*[@id='searchInput']")).sendKeys("Be kind to one another");
		//driver.findElement(By.xpath("//*[@id='search-form']/fieldset/button")).submit();
		
		//find all links using selenium
		List<WebElement> list = driver.findElements(By.tagName("a"));
		for(WebElement e: list) {
			System.out.println("Elements:" +e.getAttribute("href"));
		}
		
		// click link by text
		//driver.findElement(By.linkText("Wikimedia Foundation")).click();
		
		// partial link text
		//driver.findElement(By.partialLinkText("Privacy")).click();
		
		// get domain name
		String currentUrl=  driver.getCurrentUrl();
		URI domain = new URI(currentUrl);		
		System.out.println("domain:" +domain);
		
		// mouse hover actions using selenium wd
		driver.get("http://en.wikipedia.org");
		
		Actions actions = new Actions(driver);
		
		WebElement e = driver.findElement(By.linkText("History"));
		actions.moveToElement(e);
		actions.click().build().perform();
		System.out.println("Mouse hover event captured");
		
		//scrolling to the bottom of the page
		executor.executeScript("scrollBy(0,4500)");
		
		// select text in a web page
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"a");
		
		// refresh webpage using wd		
		driver.navigate().refresh();
		
		
		//driver.close();
	}

}
