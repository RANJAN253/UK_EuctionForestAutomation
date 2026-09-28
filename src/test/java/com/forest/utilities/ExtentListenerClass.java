package com.forest.utilities;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentListenerClass {

	public ExtentSparkReporter htmlReporter; //( devendency version 3.1.1 supported for extethtmlreproter)
	public ExtentReports extent;  //specify the location of the report
	public ExtentTest test;  // What details should be populated in the report
	
	public void onStart(ITestContext testContext)
	{
		ReadConfig readconfig = new ReadConfig();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format( new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName); // Specity Location)
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("OS", "Window 11");
		extent.setSystemInfo("browser", readconfig.getBrowser());
		extent.setSystemInfo("Environement", "QA");
		extent.setSystemInfo("user", "Ranjan");
		
		htmlReporter.config().setDocumentTitle("Up Forest Test Project"); // Tile of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); // Tile of report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); // Location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
		
	}
	public void onTestSuccess(ITestResult tr)
	{
		test = extent.createTest(tr.getName());// create new report in the report
		test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));// send the passed information
	}
	public void onTestFailure(ITestResult tr)
	{
		test= extent.createTest(tr.getName()); //  Create new entry in the report
		test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // Send the passed information
		
		String screenshotPath= System.getProperty("user.dir")+"\\Screentshots\\"+tr.getName()+".png";
		
		File f = new File(screenshotPath);
		
		if(f.exists())
		{
			try
			{
				test.fail("Screenshot  is below:" + test.addScreenCaptureFromPath(screenshotPath));
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	public void onTestSkipped(ITestResult tr)
	{
		test=extent.createTest(tr.getName()); // create new entry in the report
		test.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	public void onFinish(ITestContext testContext)
	{
		System.out.println();
		extent.flush();//it is mandatory to call flush method to ensure information is written to the started reporter.
	}

}
