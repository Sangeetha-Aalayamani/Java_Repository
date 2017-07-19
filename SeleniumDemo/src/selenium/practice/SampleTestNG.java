package selenium.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
/**
 * 
 * @author user
 *
 */
public class SampleTestNG {

	protected static WebDriver wd;
	protected static String result;

	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver","d:\\lib\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Test
	void Testcase1() {

		wd.get("http://www.floraindia.com");

		wd.findElement(By.id("kwsch")).sendKeys("Red");

		wd.findElement(By.xpath("//input[@src='images/go.gif']")).click();

		result = wd.findElement(
				By.xpath("//font[text()='Total Items  :']//following::td[1]"))
				.getText();

		Assert.assertEquals(result, "115");

	}

	@Test
	void Testcase2() {

		wd.get("http://www.floraindia.com");

		wd.findElement(By.id("kwsch")).sendKeys("Blue");

		wd.findElement(By.xpath("//input[@src='images/go.gif']")).click();

		result = wd.findElement(
				By.xpath("//font[text()='Total Items  :']//following::td[1]"))
				.getText();

		Assert.assertEquals(result, "13");

	}

	@Test
	void Testcase3() {

		wd.get("http://www.floraindia.com");

		wd.findElement(By.id("kwsch")).sendKeys("Yellow");

		wd.findElement(By.xpath("//input[@src='images/go.gif']")).click();

		result = wd.findElement(
				By.xpath("//font[text()='Total Items  :']//following::td[1]"))
				.getText();

		Assert.assertEquals(result, "27");

	}

	@Test
	void Testcase4() {

		wd.get("http://www.floraindia.com");

		wd.findElement(By.id("kwsch")).sendKeys("Purple");

		wd.findElement(By.xpath("//input[@src='images/go.gif']")).click();

		result = wd.findElement(
				By.xpath("//font[text()='Total Items  :']//following::td[1]"))
				.getText();

		Assert.assertEquals(result, "10");

	}

	@AfterClass
	public static void teardown() {

		wd.close();
		wd.quit();

	}

}
