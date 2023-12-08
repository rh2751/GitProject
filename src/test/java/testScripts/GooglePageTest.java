package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GooglePageTest {
  @Test
  public void javaSearchTest() {
	  	WebDriver driver = new ChromeDriver();
	  	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(driver.getTitle(), "Google1");
		driver.get("https://www.google.com/");
		WebElement srcBox = driver.findElement(By.id("APjFqb"));
		srcBox.sendKeys("Java Tutorial");
		srcBox.submit();
		softAssert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
		driver.close();
		//to be included at end of method in case of soft assert used
		softAssert.assertAll();
  }
  
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
