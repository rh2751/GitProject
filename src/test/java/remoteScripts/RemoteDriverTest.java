package remoteScripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class RemoteDriverTest {
	
	@Test
	public void sampleTest() throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
//		EdgeOptions options = new EdgeOptions();
//		options.addArguments("headless");
		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
//		options.setCapability(CapabilityType.BROWSER_VERSION, "115");
		String strHub = "";
		RemoteWebDriver driver = new RemoteWebDriver(new URL(strHub), options);
		
		driver.get("https://www.google.com/");
		WebElement srcBox = driver.findElement(By.id("APjFqb"));
		srcBox.sendKeys("Selenium Tutorial");
		srcBox.submit();
		System.out.println(driver.getTitle());
		
	}

}
