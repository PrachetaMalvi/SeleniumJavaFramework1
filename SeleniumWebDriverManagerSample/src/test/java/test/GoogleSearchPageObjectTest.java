package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.GoogleSearchPageObjects;

public class GoogleSearchPageObjectTest {

	private static WebDriver driver = null;

	public static void main(String[] args) {
		googleSearchTest();
	}

	public static void googleSearchTest() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
		driver.get("https://google.com");
		searchPageObj.setTextInsearchBox("A B C D");
		searchPageObj.clickSearchButton();
		driver.close();
	}
}
