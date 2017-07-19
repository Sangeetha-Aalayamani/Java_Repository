package selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestGmail {

	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

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
		driver.get("https://accounts.google.com/ServiceLogin?");
		// gmail login
		driver.findElement(By.id("identifierId")).sendKeys("************");
		driver.findElement(By.xpath("//*[@id='identifierNext']/content/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("password")).sendKeys("************");
		driver.findElement(By.xpath("//*[@id='passwordNext']/content/span")).click();
		System.out.println("Logged in successfully");
	}
}
