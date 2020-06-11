package resources;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentSparkReporter reporter;
	static ExtentReports extent;
	public static ExtentReports getReportObject()
	{
        //yyyy_mm_dd hh:mm:ss	
		/*Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_mm_dd hh:mm:ss");
		sdf.format(d);*/
		//combining the above line of codes into the following one//
		String timestamp = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		String file = System.getProperty("user.dir") + "./Reports/ExtentReports"+ "_" + timestamp + ".html";
		reporter = new ExtentSparkReporter(file);
		reporter.config().setReportName("Extent Reporting Results");
		reporter.config().setDocumentTitle("ReddifMail");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("User Name", "Raktim Sarkar");
		extent.setSystemInfo("Environment", "DEV");
		
		return extent;
		
	}
	

}
