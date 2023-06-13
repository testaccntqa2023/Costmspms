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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.bhiawpkg.TestBase.TestBase;


public class Reporting extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	WebDriver driver;
	TestBase baseclass;
	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String Reportname="Test-Report-CostmsPMS  "+timeStamp+".html";
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "//test-output/"+Reportname);//specify location of the report
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Company Name", "Blue Horizon Infotech");
		extent.setSystemInfo("Application","CostmsPMS");
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("Tester","DIVYA");
		
		htmlReporter.config().setDocumentTitle("BHICostmsPMS"); // Title of report
		htmlReporter.config().setReportName("CostmsPMS -- Functional Test Automation Report"); // name of the report
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
	
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		logger.fail(tr.getMethod().getMethodName()+ " is failed ");
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots1/" +tr.getName()+ ".png";
		File f=new File(screenshotPath);	
		
		if(f.exists())
		{
			
		try {
			//String screenshotpath1=getScreenshot1(driver, tr.getName());
			String screenshotpath1=baseclass.getScreenShot(tr.getName());
			logger.addScreenCaptureFromPath(screenshotpath1);
			logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotpath1));
			
			} 
		catch (IOException e) 
				{
				e.printStackTrace();
				} catch (Exception e) {
			// TODO Auto-generated catch block
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
public String getScreenShot(String imageName) throws IOException{
		
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
	}

}
