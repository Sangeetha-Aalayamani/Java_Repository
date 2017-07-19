package selenium.practice;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
/**
 * 
 * @author user
 *
 */
public class CreateAccount {
	
	public static WebDriver driver;
	public Alert alert;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
		driver.get(System.getProperty("user.dir")+"/src/CreateAccount.html");
	}

	@Test
	public void testCreateAccount() throws InterruptedException {
		
		navigatetoWebpage(driver,System.getProperty("user.dir")+"/src/CreateAccount.html");
		typeinEditbox(driver,"name","FirstName","Soniya");
		typeinEditbox(driver,"name","Lname","A");
		typeinEditbox(driver,"xpath","//textarea[@name='street']","No. 777, 7th Main, 7th Cross Street");
		selectValue(driver,"Chennai");
		selectValue(driver,"Tamilnadu");
		selectValue(driver,"Germany");
		selectRadiobutton(driver,"name","female");
		selectCheckbox(driver,"name","english","ON");
		selectCheckbox(driver,"name","tamil","ON");
		selectCheckbox(driver,"name","hindi","ON");
		clickButton(driver,"name","Save");
		closeJscriptPopup(driver,alert);
		
		Thread.sleep(50);
		clickLink(driver,"xpath","//a[@href='CustomerInfo.html']");
		
		Thread.sleep(50);
		clickLink(driver,"xpath","//a[@href='CreateAccount.html']");
	}
	
	public static void closeJscriptPopup(WebDriver driver, Alert alert){
		alert = driver.switchTo().alert();
		alert.accept();
	}

	public static void navigatetoWebpage(WebDriver driver, String url){
		driver.get(url);
	}
	public static void clickButton(WebDriver driver, String identifyBy, String locator){
		if (identifyBy.equalsIgnoreCase("xpath")){
			driver.findElement(By.xpath(locator)).click();
		}else if (identifyBy.equalsIgnoreCase("id")){
			driver.findElement(By.id(locator)).click();	
		}else if (identifyBy.equalsIgnoreCase("name")){
			driver.findElement(By.name(locator)).click();	
		}
		
	}
	
	public static void clickLink(WebDriver driver, String identifyBy, String locator){
		if (identifyBy.equalsIgnoreCase("xpath")){
			driver.findElement(By.xpath(locator)).click();
		}else if (identifyBy.equalsIgnoreCase("id")){
			driver.findElement(By.id(locator)).click();	
		}else if (identifyBy.equalsIgnoreCase("name")){
			driver.findElement(By.name(locator)).click();	
		}else if (identifyBy.equalsIgnoreCase("name")){
			driver.findElement(By.linkText(locator)).click();	
		}else if (identifyBy.equalsIgnoreCase("name")){
			driver.findElement(By.partialLinkText(locator)).click();	
		}
	}
	
	public static void typeinEditbox(WebDriver driver, String identifyBy, String locator, String valuetoType){
		if (identifyBy.equalsIgnoreCase("xpath")){
			driver.findElement(By.xpath(locator)).sendKeys(valuetoType);
		}else if (identifyBy.equalsIgnoreCase("id")){
			driver.findElement(By.id(locator)).sendKeys(valuetoType);	
		}else if (identifyBy.equalsIgnoreCase("name")){
			driver.findElement(By.name(locator)).sendKeys(valuetoType);	
		}
		
	}
	
	public static void selectRadiobutton(WebDriver driver, String identifyBy, String locator){
		if (identifyBy.equalsIgnoreCase("xpath")){
			driver.findElement(By.xpath(locator)).click();
		}else if (identifyBy.equalsIgnoreCase("id")){
			driver.findElement(By.id(locator)).click();	
		}else if (identifyBy.equalsIgnoreCase("name")){
			driver.findElement(By.name(locator)).click();	
		}
		
	}
	
	public static void selectCheckbox(WebDriver driver, String identifyBy, String locator, String checkFlag){
		if (identifyBy.equalsIgnoreCase("xpath")){
			if ((checkFlag).equalsIgnoreCase("ON")){
				if (!(driver.findElement(By.xpath(locator)).isSelected())){
					driver.findElement(By.xpath(locator)).click();
				}
			}
		}else if (identifyBy.equalsIgnoreCase("id")){
			if ((checkFlag).equalsIgnoreCase("ON")){
				if (!(driver.findElement(By.id(locator)).isSelected())){
					driver.findElement(By.id(locator)).click();
				}
			}
		}else if (identifyBy.equalsIgnoreCase("name")){
			if ((checkFlag).equalsIgnoreCase("ON")){
				if (!(driver.findElement(By.name(locator)).isSelected())){
					driver.findElement(By.name(locator)).click();	
				}
			}
		}
	}

	public static void selectValue(WebDriver driver, String valToBeSelected){
        List <WebElement> options = driver.findElements(By.tagName("option"));
		for (WebElement option : options) {
			if (valToBeSelected.equalsIgnoreCase(option.getText())){
				option.click();
			}
		    } 
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Execution completed.....");
	}

}
