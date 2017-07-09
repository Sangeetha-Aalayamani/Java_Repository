package selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeleniumDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"d:\\lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://google.com/");

		String title = driver.getTitle();

		// assert to verify the page title
		Assert.assertTrue(title.contains("Google"));

		WebElement element = driver.findElement(By.id("lst-ib"));
		element.sendKeys("Selenium Java");
		element.sendKeys(Keys.RETURN);	
		
		element = driver.findElement(By.className("jsb"));
		element.click();
		
		//File inputFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {			
			//capture screenshot
			//FileUtils.copyFile(inputFile, new File("d://picts/God's Love.jpg"));
			
			// clear the text
			//element.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}