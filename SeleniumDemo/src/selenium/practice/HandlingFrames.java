package selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
/**
 * 
 * @author user
 *
 */
public class HandlingFrames {
	
	private static WebDriver driver;
	
	public static void main(String[] args) {
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
		driver.get("http://timesofindia.indiatimes.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		List<WebElement> forms= driver.findElements(By.tagName("iframe"));  //Frame List
		System.out.println(forms.size());
		for(int i=0;i<forms.size();i++) 
		{
		 System.out.println(forms.get(i).equals(driver.getPageSource().contains("src")));
		}

	}

}
