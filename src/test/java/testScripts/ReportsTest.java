package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import commonUtils.Utility;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class ReportsTest {
		WebDriver driver;
		ExtentReports extentReports;
		ExtentSparkReporter spark;
		ExtentTest extentTest;
		
		@BeforeTest
		public void setupExtent() {
			extentReports = new ExtentReports();
			spark = new ExtentSparkReporter("test-output/SparkReport.html")
					.viewConfigurer()
					.viewOrder()
					.as(new ViewName[] {
							ViewName.DASHBOARD,
							ViewName.TEST,
							ViewName.AUTHOR,
							ViewName.DEVICE,
							ViewName.LOG
						}).apply();
			extentReports.attachReporter(spark);
		}
		
		@BeforeMethod
		  public void setup() {
			  	driver = new ChromeDriver();
			  	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
		  }
		
	  @Test
	  public void javaSearchTest() {
		  extentTest = extentReports.createTest("Java Search Test");
		  	driver.get("https://www.google.com/");
			WebElement srcBox = driver.findElement(By.id("APjFqb"));
			srcBox.sendKeys("Java Tutorial");
			srcBox.submit();
			Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
//			driver.close();
	  }
	  
	  
	  @Test(retryAnalyzer = RetryAnalyzerSample.class)
	  public void pythonSearchTest() {
		  extentTest = extentReports.createTest("Python Search Test");
		  	driver.get("https://www.google.com/");
			WebElement srcBox = driver.findElement(By.id("APjFqb"));
			srcBox.sendKeys("Python Tutorial");
			srcBox.submit();
			Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
//			driver.close();
	  }
	  
	  @AfterMethod
	  public void teardown(ITestResult result) {
		  extentTest.assignAuthor("AutoTester")
		  .assignCategory("Regression")
		  .assignDevice(System.getProperty("os.name"))
		  .assignDevice(System.getProperty("os.version"));
		  if(ITestResult.FAILURE == result.getStatus()) {
			  extentTest.log(Status.FAIL, result.getThrowable().getMessage());
			  String strPath = Utility.getScreenshotPath(driver);
			  extentTest.fail(
			  MediaEntityBuilder.createScreenCaptureFromPath(strPath).build());
		  }
		  driver.close();
	  }
	  
	  @AfterTest
	  public void finishTest() {
		  extentReports.flush();
	  }

}
