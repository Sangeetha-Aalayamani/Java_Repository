package selenium.practice;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * 
 * @author user
 *
 */
public class ReadExcel {
	
	public static void main(String[] args) throws Exception {
			
		FileInputStream input = new FileInputStream("d:\\test.xls");
		XSSFWorkbook workBook = new XSSFWorkbook(input);
		XSSFSheet sheet = workBook.getSheetAt(0);
		
		String header = sheet.getRow(0).getCell(0).getStringCellValue();
		String row1 = sheet.getRow(1).getCell(0).getStringCellValue();
		String row2 = sheet.getRow(2).getCell(0).getStringCellValue();
		String row3 = sheet.getRow(3).getCell(0).getStringCellValue();
		
		System.out.println("Header: " +header);
		System.out.println("row1: " +row1);
		System.out.println("row2: " +row2);
		System.out.println("row3: " +row3);
		
		System.setProperty("webdriver.chrome.driver","d:\\lib\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		
		WebElement element = driver.findElement(By.id("lst-lb"));
		element.sendKeys(row1);
		
		element.submit();
		
	}

}
