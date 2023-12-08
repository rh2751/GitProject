package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
import org.testng.annotations.*;

public class SampleTest1 {
  WebDriver driver;
  
//  @BeforeMethod
  @BeforeTest
  public void setup() {
	  driver = new ChromeDriver();
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
  }
	
  @Test(enabled = false)
  public void cucmberSearchTest() {
	  	driver.get("https://www.google.com/");
		WebElement srcBox = driver.findElement(By.id("APjFqb"));
		srcBox.sendKeys("Cucumber Tutorial");
		srcBox.submit();
		Assert.assertEquals(driver.getTitle(), "Cucumber Tutorial - Google Search");
  }
  
  @Test(priority = -1)
  public void seleniumSearchTest() {
	  	driver.get("https://www.google.com/");
		WebElement srcBox = driver.findElement(By.id("APjFqb"));
		srcBox.sendKeys("Selenium Tutorial");
		srcBox.submit();
		Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search");
  }
  
  @Test(priority = 2)
  public void appiumSearchTest() {
	  	driver.get("https://www.google.com/");
		WebElement srcBox = driver.findElement(By.id("APjFqb"));
		srcBox.sendKeys("Appium Tutorial");
		srcBox.submit();
		Assert.assertEquals(driver.getTitle(), "Appium Tutorial - Google Search");
  }
  
  @Test(priority = -2)
  public void pythonSearchTest() {
	  	driver.get("https://www.google.com/");
		WebElement srcBox = driver.findElement(By.id("APjFqb"));
		srcBox.sendKeys("Python Tutorial");
		srcBox.submit();
		Assert.assertEquals(driver.getTitle(), "Python Tutorial - Google Search");
  }
//  @AfterMethod
  @AfterTest
  public void tearDown() {
	  driver.close();
  }
}
