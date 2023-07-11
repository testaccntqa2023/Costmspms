package com.bhiawpkg.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.BHIAW.Helper.LoggerHelper;
import com.BHIAW.Helper.WaitHelper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.bhiawpkg.Config.Config;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	private final Logger log = LoggerHelper.getLogger(TestBase.class);
	File properties;
	FileInputStream fin;
	protected Properties pr;
	protected static WebDriver driver;
	ExtentHtmlReporter htmlreport;
	ExtentReports extreport;
	ExtentTest test;
	WaitHelper waitHelper ;
	public File folder;
	
	@BeforeClass
	//=======@Parameters("browser")//-----------------------
	public void Launchbrowser() throws IOException
	{
		 LoadProperties();
		 Config co=new Config(pr);
		 GetBrowser(co.Getbrowser());
		 log.info("-----------Browser is launching---------");
		 log.info("-----------URL is getting---------");
		 driver.get(co.Geturl());
		 MAximizewindow();
		 waitHelper = new WaitHelper(driver);
		 waitHelper.setImplicitWait(co.getImplicitWait(), TimeUnit.SECONDS);
		 waitHelper.setPageLoadTimeout(co.getPageLoadTimeOut(), TimeUnit.SECONDS);
		// co.getImplicitwait();
		 log.info("-----------Application is loaded----------------");
	}
public String getScreenShot(String imageName) throws IOException{
		
		if(imageName.equals("")){
		imageName = "blank";
		}
		File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imagelocation = System.getProperty("user.dir")+"/Screenshots1/";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualImageName = imagelocation+imageName+"_"+formater.format(calendar.getTime())+".png";
		File destFile = new File(actualImageName);
		
		FileUtils.copyFile(image, destFile);
		return actualImageName;
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		getScreenShot(tname);
		/*TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots1/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");*/
	}
	
	public void MAximizewindow()
	{
		driver.manage().window().maximize();
	}
  public void LoadProperties() throws IOException
  {
	  String log4jConfPath = "./Resources/log4j.properties";
		PropertyConfigurator.configure(log4jConfPath); 
	  properties=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\bhiawpkg\\Properties\\common.properties");
	  fin=new FileInputStream(properties);
	  pr=new Properties();
	  pr.load(fin);
  }
  public void GetBrowser(String browser)
  {
	    folder=new File(UUID.randomUUID().toString());
		folder.mkdir();
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		Map<String, Object>prefs=new HashMap<String,Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", folder.getAbsolutePath());
		options.setExperimentalOption("prefs", prefs);
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		if(System.getProperty("os.name").contains("Window")){
			if(browser.equalsIgnoreCase("chrome"))
				{
					driver=new ChromeDriver(cap);
				}
				else if(browser.equalsIgnoreCase("edge"))
				{
					System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\drivers\\msedgedriver.exe");
					driver = new EdgeDriver();
				}
	  		}
  }
  public WebElement waitForElement(WebDriver driver,long time,WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/*
	public WebElement waitForElementWithPollingInterval(WebDriver driver,long time,WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	*/
	public void impliciteWait(long time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

@AfterClass
public void teardown()
{
	
	 for(File file:folder.listFiles())
    {
  	  file.delete();
    }
    folder.delete();
   
    driver.quit();
}
}
