package selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormElements {

	public static void main(String[] args) throws InterruptedException {

		String url = "D://sangee/workspace/selenium/SeleniumDemo/src/selenium/practice/index.html";
		//String videoUrl = "http://w3.org/2010/05/video/mediaevents.html";

		System.setProperty("webdriver.chrome.driver","d:\\lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
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
		/*driver.get(videoUrl);
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("document.getElementById(\"video\").play()");
		Thread.sleep(1000);
		executor.executeScript("document.getElementById(\"video\").pause()");
		executor.executeScript("document.getElementsById(\"video\").load()");
		executor.executeScript("document.getElementById(\"video\").play()");
		
		System.out.println("Video played successfully");*/
		
		
		/*WebElement e =driver.findElement(By.id("hplogo"));
		Actions action= new Actions(driver);
		
		action.contextClick(e).build().perform();
		action.sendKeys(Keys.CONTROL,"s").build().perform();*/
		
		// downloading a file
		driver.get("http://www.contextures.com/xlSampleData01.html");
		
		driver.findElement(By.linkText("Excel sample data workbook")).click();
		
		
	}
}