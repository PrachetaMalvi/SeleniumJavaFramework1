package test;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pom.GoogleSearchPage;

public class TestNGDemo {
	WebDriver driver = null;

	@BeforeTest
	public void setupTest() {
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath = " + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void googleSearch() {
		// goto googlee.com

		driver.get("https://google.com");

		// enter text in search textbox

		// driver.findElement(By.name("q")).sendKeys("Automation step by step");
		GoogleSearchPage.textbox_search(driver).sendKeys("Automation step by step");

		// click on search button

		// driver.findElement(By.name("btnK")).click();
		// driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);

		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);

		// close browser

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		System.out.println("Test completed successfully");
	}
}
