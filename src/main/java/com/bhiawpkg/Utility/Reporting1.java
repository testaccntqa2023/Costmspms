package com.bhiawpkg.Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/*import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;*/
/*----------------------------------------------
public class Reporting1 extends TestListenerAdapter {
	//public ExtentHtml htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	WebDriver driver;
	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String Reportname="Test-Report-"+timeStamp+".html";
		
		//htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "//test-output/"+Reportname);//specify location of the report
		//htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		extent=new ExtentReports(System.getProperty("user.dir")+ "//test-output/"+Reportname);
		
		//extent.attachReporter(htmlReporter);
		extent.addSystemInfo("Company Name", "Blue Horizon Infotech");
		extent.addSystemInfo("Host name","localhost");
		extent.addSystemInfo("Environemnt","QA");
		extent.addSystemInfo("Tester","DIVYA");
		
		htmlReporter.config().setDocumentTitle("BHIAshlyPMS"); // Title of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
		//logger.pass(tr.getName()+"-Passed");
		logger.pass(tr.getMethod().getMethodName()+ " is Passed ");
		tr.getMethod().getDescription();
	}
	public  String getScreenshot1(WebDriver driver,String screenshotname) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/Screenshots1/"+screenshotname+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	public void onTestFailure(ITestResult tr)
	{
		//driver=this.driver;
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		//logger.fail(tr.getName()+"-failed");
		
		try {
			String screenshotpath1=getScreenshot1(driver, tr.getName());
			logger.addScreenCaptureFromPath(screenshotpath1);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
	/*	try {
			logger.fail(getScreenshot1(driver, tr.getMethod()));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
/*--------------------------------------
		logger.fail(tr.getMethod()+ " is failed ");
		//-----------------------------
		//File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//-----------------------
		
		//TakesScreenshot ts =((TakesScreenshot)driver);
	//	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		//File source = ts.getScreenshotAs(OutputType.FILE);
		
		
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots1/" +tr.getName()+ ".png";
		File f=new File(screenshotPath);
		String screenshotpath2;
		try {
			screenshotpath2 = getScreenshot1(driver, tr.getName());
			logger.log(Status.FAIL, (Markup) logger.addScreencastFromPath(screenshotpath2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		if(f.exists())
		{
			
		try {
			//-----------------------------------------
			// String screenshotPath = ExtentReportsClass.getScreenshot(driver, result.getName());
			//logger.addScreenCaptureFromPath(screenshotPath, "Test case failure sccreenshot");
			//-----------------------------------------
			logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			
			} 
		catch (IOException e) 
				{
				e.printStackTrace();
				}
		}
		
	}
	
	
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
		logger.fail(tr.getName()+"-skipped");
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	--------------------------------------*/
/*public String getScreenShot(String imageName) throws IOException{
		
		if(imageName.equals("")){
		imageName = "blank";
		}
		File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imagelocation = System.getProperty("user.dir")+"\\src\\main\\java\\com\\BHI\\Screenshots/";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualImageName = imagelocation+imageName+"_"+formater.format(calendar.getTime())+".png";
		File destFile = new File(actualImageName);
		
		FileUtils.copyFile(image, destFile);
		return actualImageName;
	}}*/



