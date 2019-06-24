package de.cloudsurfers.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;

@Testcontainers
class SimpleJunit5TestcontainersSeleniumTest {

	@Container
	private static BrowserWebDriverContainer container = new BrowserWebDriverContainer().withCapabilities(new ChromeOptions())
			.withRecordingMode(BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL, new File("target"));


	@Test
	void simpleGoogleCall(){
		 var webDriver = container.getWebDriver();

		webDriver.get("https://www.google.com");

		WebElement elementQ = webDriver.findElement(By.name("q"));
		elementQ.sendKeys("cheese!");
		elementQ.submit();


		(new WebDriverWait(webDriver, 10)).until(driver -> true);


		webDriver.quit();
	}
}
