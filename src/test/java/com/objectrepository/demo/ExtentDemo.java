package com.objectrepository.demo;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class ExtentDemo {
	
static ExtentTest test;
static ExtentReports report;
WebDriver driver;

@BeforeClass
public static void startTest()
{
	
	 String extentReportPath = System.getProperty("user.dir")+"\\reports\\extentreport.html";
	 ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
	 report = new ExtentReports();
	 report.attachReporter(reporter);
		test = report.createTest("ExtentDemo");
}
@Test
public void extentReportsDemo() throws InterruptedException
{

//System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\JMeter\\chromedriver.exe");

		 WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
		 //WebDriver driver = new ChromeDriver();
driver.get("https://www.google.co.in");

Thread.sleep(5000);
if(((driver.getTitle()).trim()).equals("Google"))
{
	System.out.println(driver.getTitle());
	System.out.println("enterted");
test.log(Status.PASS, "Navigated to the specified URL");
}
else
{
	
test.log(Status.FAIL, "Test Failed");
}
driver.close();
report.flush();
}
/*@AfterClass
public static void endTest()
{
//report.endTest(test);

	System.out.println("final");
report.flush();


}*/
}

