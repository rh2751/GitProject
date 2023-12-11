package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GooglePageTest {
	WebDriver driver;
	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	
	@BeforeTest
	public void setupExtent() {
		extentReports = new ExtentReports();
		spark = new ExtentSparkReporter("test-output/SparkReport.htlm");
		extentReports.attachReporter(spark);
		
	}
	
  @Test
  @Parameters("browser")
  public void javaSearchTest(String strBrowser) {
	  	extentTest = extentReports.createTest("Java Search Test");
		if(strBrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(strBrowser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
	  	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		System.out.println(driver.getTitle());
		driver.get("https://www.google.com/");
		WebElement srcBox = driver.findElement(By.id("APjFqb"));
		srcBox.sendKeys("Java Tutorial");
		srcBox.submit();
		driver.close();
  }
  
  @AfterTest
  public void finishTest() {
	  extentReports.flush();
  }
	
//	 @Test
//	  public void javaSearchTest(String strBrowser) {
//			if(strBrowser.equalsIgnoreCase("chrome")) {
//				driver = new ChromeDriver();
//			}
//			else if(strBrowser.equalsIgnoreCase("edge")) {
//				driver = new EdgeDriver();
//			}
//		  	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
//			driver.manage().window().maximize();
//			driver.manage().deleteAllCookies();
//			SoftAssert softAssert = new SoftAssert();
//			System.out.println(driver.getTitle());
//			softAssert.assertEquals(driver.getTitle(), "Google");
//			driver.get("https://www.google.com/");
//			WebElement srcBox = driver.findElement(By.id("APjFqb"));
//			srcBox.sendKeys("Java Tutorial");
//			srcBox.submit();
//			softAssert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
//			driver.close();
//			//to be included at end of method in case of soft assert used
//			softAssert.assertAll();
//	  }
  
//  @Test
//  public void javaSearchTest() {
//	  	WebDriver driver = new ChromeDriver();
//	  	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.get("https://www.google.com/");
//		//hard assert
//		Assert.assertEquals(driver.getTitle(), "Google1");
//		WebElement srcBox = driver.findElement(By.id("APjFqb"));
//		srcBox.sendKeys("Java Tutorial");
//		srcBox.submit();
//		Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
//		driver.close();
//  }
}
