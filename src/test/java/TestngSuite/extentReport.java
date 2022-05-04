package TestngSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReport {
		 static ExtentReports extent;
		public  extentReport() {
			extent=new ExtentReports();
	    ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/Spark.html");
	   
	    extent.attachReporter(spark);
//	    ExtentTest exetrepo = extent.createTest("SampleTest");
//	    exetrepo.log(Status.PASS ,"enter user");
//	    return extent.createTest("SampleTest");
//	    	return extent; 
		}
		
}
