package TestngSuite;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
		protected static ExtentReports extent;
		protected static WebDriver driver;
		public ExtentTest ExtentReport;
		
		@BeforeTest
		public
		 void setupExtent() {
			System.out.println("berfore Test");
//			System.setProperty("webdriver.chrome.driver", "./jars/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			extent=new ExtentReports();
			extent.setSystemInfo("Author", "Shaik321");
			extent.setSystemInfo("Porject", "Cucumber junit");
			extent.setSystemInfo("Build", "Maven");
			
		    ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/SparkNew.html");
		    extent.attachReporter(spark);
		}
		
		@AfterTest
		public void endExtent() {
			System.out.println("after Test");
			
			
		
		}
		
		@BeforeSuite
		public void one() {
			System.out.println("BeforeSuite");
		}
		
		@AfterSuite
	public void two() {
			System.out.println("AfterSuite");
			extent.flush();driver.quit();
		}
		
		@BeforeClass
	public void three() {
			System.out.println("BeforeClass");
	}
		@AfterClass
	public void four() {
			System.out.println("AfterClass");
	}
		@BeforeMethod
	public void five() {
			System.out.println("BeforeMethod");
			System.out.println(this.getClass().getCanonicalName().toString());
			ExtentReport=extent.createTest(this.getClass().getCanonicalName().toString());
	}
//		@AfterMethod
	//public void six() {
//			System.out.println("AfterMethod");
//			
	//}

		
		
		
//		@BeforeMethod
//		public static  ExtentTest setupTest() {
//			return extent.createTest(testoneauto.class.getName());
//		}
		
		static public String capturescreenshot() {
			System.out.println("Screen catureing");
			TakesScreenshot clickshot=(TakesScreenshot)driver;
			 String dtamp = new SimpleDateFormat("ddmmyyhhmmss").format(new Date());
			File actpath= new File("./target/screenshot/capture"+dtamp+".png");
					File cappath = clickshot.getScreenshotAs(OutputType.FILE);
			  try {
				FileUtils.copyFile(cappath, actpath);
			} catch (IOException e) {
				System.out.println("Failed to capture screen");
			}
			  return actpath.getAbsolutePath();
		}
		
		@AfterMethod
		public void teardown(ITestResult result) {
			System.out.println("After method at test");
			
			if(result.getStatus()==ITestResult.FAILURE) {
				ExtentReport.log(Status.FAIL, "Test failed to verify for "+result.getName());
//			 String capturefile = capturescreenshot().getAbsolutePath();
				 String caputeimg = ExtentReport.addScreenCaptureFromPath(capturescreenshot()).toString();
				 ExtentReport.log(Status.FAIL,caputeimg );
		}
			else if (result.getStatus()==ITestResult.SUCCESS) {
				ExtentReport.log(Status.PASS, "Test passed to verify for "+result.getName());
			String caputeimg = ExtentReport.addScreenCaptureFromPath(capturescreenshot()).toString();
			ExtentReport.log(Status.PASS,caputeimg );
		}
			else if (result.getStatus()==ITestResult.SKIP)
				ExtentReport.log(Status.SKIP, "Test skipped to verify for "+result.getName());
			
		}
}
