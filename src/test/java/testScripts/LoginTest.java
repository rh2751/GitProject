package testScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class LoginTest {
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
	
//	@Test
//	public void validLogin() {
//		driver.get(prop.getProperty("url"));
//		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
//		driver.findElement(By.cssSelector("button.radius")).click();
//		boolean isDisp = driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
//		Assert.assertTrue(isDisp);
//	}
	
	@Test(dataProvider = "loginData")
	public void validLogin(String strUser, String strPwd) {
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(strUser);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(strPwd);
		driver.findElement(By.cssSelector("button.radius")).click();
		boolean isDisp = driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
		Assert.assertTrue(isDisp);
	}
	
//	//reading form .csv file
//	@DataProvider(name = "loginData")
//	public Object[][] getData() throws CsvValidationException, IOException {
//		String path = System.getProperty("user.dir") 
//				+ "//src//test//resources//testData//loginData.csv";
//		CSVReader reader = new CSVReader(new FileReader(path));
//		String cols[];
//		
//		ArrayList<Object> dataList = new ArrayList<Object>();
//		while((cols = reader.readNext())!= null) {
//			Object record[] = {cols[0],cols[1]};
//			dataList.add(record);
//		}
//		reader.close();
//		return dataList.toArray(new Object[dataList.size()][]);
//	}
	
	//reading form .json file
	@DataProvider(name = "loginData")
	public Object[][] getData() throws IOException, ParseException {
		String path = System.getProperty("user.dir") 
				+ "//src//test//resources//testData//loginData.json";
		FileReader reader = new FileReader(path);
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(reader);
		JSONObject jsonObj = (JSONObject) obj;
		JSONArray userArray = (JSONArray)jsonObj.get("userLogins");
		String arr[][] = new String[userArray.size()][];
		for(int i = 0; i < userArray.size(); i++) {
			JSONObject user = (JSONObject)userArray.get(i);
			String strUser = (String)user.get("username");
			String strPwd = (String)user.get("password");
			String record[] = {strUser, strPwd};
			arr[i] = record;
		}
		return arr;
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
