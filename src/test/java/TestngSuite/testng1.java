package TestngSuite;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class testng1 extends baseClass{

	
//	public ExtentTest ExtentReport;

	@Test
	public void firsttest(){
		System.out.println("test 1");
//		ExtentReports extent = new ExtentReports();
//	    ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/Spark.html");
//	    extent.attachReporter(spark);
//		baseTest base=new baseTest();
//		base.setupExtent();
//		 ExtentReport = extent.createTest("firsttest");
		
	    driver.get("https://www.selenium.dev/downloads/");
	    ExtentReport.log(Status.PASS, "Enter url");
		driver.manage().window().maximize();
		ExtentReport.log(Status.PASS, "do maximize");
		System.out.println(driver.getTitle());
		ExtentReport.log(Status.PASS, "get title");
//		ExtentReport.fail(MediaEntityBuilder.createScreenCaptureFromPath("sample.png").build());
	}
	
	@Test
	public void secondtest() {
		System.out.println("test 2");
//		ExtentReport = extent.createTest("test2");
		
		driver.get("https://www.selenium.dev/downloads/");
		driver.findElement(By.xpath("//*[@id='selenium_logo']")).click();
		Assert.assertEquals(driver.getTitle(), "Selenium");
	}
	

	
//	@AfterTest
//	public void testtoano() {
//		System.out.println("@ after test");
//		extent.flush();
//		driver.quit();
//	}
		
}
