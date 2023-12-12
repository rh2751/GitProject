package testScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelObjTest {
	WebDriver driver;
	Properties prop;
	
	@BeforeMethod
	public void setup() throws IOException {
		String path = System.getProperty("user.dir") 
				+ "//src//test//resources//configFiles//config.properties";
		FileInputStream fin = new FileInputStream(path);
		prop = new Properties();
		prop.load(fin);
		String strBrowser = prop.getProperty("browser");
		if (strBrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (strBrowser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@Test
	public void validLogin() {
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("button.radius")).click();
		boolean isDisp = driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
		Assert.assertTrue(isDisp);
	}
	
	public String readObjPath(String objName) throws IOException {
		String objPath = "";
		String path = System.getProperty("user.dir") 
				+ "//src//test//resources//testData//exlData.xlsx";
		FileInputStream fin = new FileInputStream(path);
		//.xlsx
		XSSFWorkbook workbook = new XSSFWorkbook(fin);
		//.xls -- HSSFxxxx
		
		XSSFSheet sheet = workbook.getSheet("loginPage");
		int numRows = sheet.getLastRowNum();
		for(int i=1; i<=numRows; i++) {
			XSSFRow row = sheet.getRow(i);
			
			if(row.getCell(0).getStringCellValue().equalsIgnoreCase(objName)) {
				objPath = row.getCell(1).getStringCellValue();
				System.out.println(objPath);
			}
		}
		return objPath;
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
