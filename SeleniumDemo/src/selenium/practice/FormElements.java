package selenium.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
/**
 * 
 * @author user
 *
 */
public class FormElements {
	
	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, AWTException {

		String url = "D://sangee/workspace/selenium/SeleniumDemo/src/selenium/practice/index.html";
		String videoUrl = "http://w3.org/2010/05/video/mediaevents.html";

		System.setProperty("webdriver.chrome.driver","d:\\lib\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(url);
		
		//checking the radio button
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[1]/input")).click();
		System.out.println("Radio button checked successfully");
		
		// selecting the dropdown list
		Select selectDropDown = new Select(driver.findElement(By.name("selectList")));
		selectDropDown.selectByIndex(3);
		System.out.println("Dropdown selected successfully");
		
		// checkboxes
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td/input[2]")).click();
		System.out.println("Checkboxes checked successfully");
		// play videos
		driver.get(videoUrl);
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("document.getElementById(\"video\").play()");
		Thread.sleep(1000);
		executor.executeScript("document.getElementById(\"video\").pause()");
		executor.executeScript("document.getElementsById(\"video\").load()");
		executor.executeScript("document.getElementById(\"video\").play()");
		
		System.out.println("Video played successfully");
		
		
		WebElement e =driver.findElement(By.id("hplogo"));
		Actions action= new Actions(driver);
		
		action.contextClick(e).build().perform();
		action.sendKeys(Keys.CONTROL,"s").build().perform();
		
		// downloading a file
		driver.get("http://www.contextures.com/xlSampleData01.html");
		switchToTab();	

		driver.findElement(By.linkText("Excel sample data workbook")).click();
				
	}
	
	 public static void switchToTab() throws AWTException {
		  //Switching between tabs using CTRL + tab keys.
		 Robot r = new Robot();
		 r.keyPress(KeyEvent.VK_CONTROL);
		 r.keyPress(KeyEvent.VK_T);
		 r.keyRelease(KeyEvent.VK_CONTROL);
		 r.keyRelease(KeyEvent.VK_T);

	} 
}