package test;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemoWithTestNG {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;

	@BeforeSuite
	public void setup() {
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@BeforeTest
	public void setupTest() {
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath = " + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void test1() throws Exception {
		// creates a toggle for the given test, adds all log events under it    
        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");

        driver.get("https://google.com");
        test.pass("Navigate to google.com");
        // log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");

        // info(details)
        test.info("This step shows usage of info(details)");
        
        // log with snapshot
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
	}

	@Test
	public void test2() throws Exception {
		// creates a toggle for the given test, adds all log events under it    
        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");

        // log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");

        // info(details)
        test.info("This step shows usage of info(details)");
        
        // log with snapshot
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
	}

	@AfterSuite
	public void tearDown() {
		 // calling flush writes everything to the log file
        extent.flush();
	}

	@AfterTest
	public void tearDownTest() {
		driver.close();
		System.out.println("Test completed successfully");
	}
}
