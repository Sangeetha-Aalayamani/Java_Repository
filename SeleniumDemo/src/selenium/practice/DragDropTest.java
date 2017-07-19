package selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
/**
 * 
 * @author user
 *
 */
public class DragDropTest {

	private static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C://Users/user/Downloads/chromedriver_win32 (1)/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("start-maximized");
		options.addArguments("--js-flags=--expose-gc");
		options.addArguments("--enable-precise-memory-info");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-default-apps");
		options.addArguments("test-type=browser");
		options.addArguments("disable-infobars");

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://www.ericbieller.com/examples/dragdrop/");
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.MINUTES);
		 
		Actions act = new Actions(driver);
		WebElement src = driver.findElement(By.xpath("//div[@id='items']/div[1]"));
		WebElement des = driver.findElement(By.id("trash"));
		 
		act.clickAndHold(src).build().perform();
		act.moveToElement(des).build().perform();
		act.release(des).build().perform();
	}
}