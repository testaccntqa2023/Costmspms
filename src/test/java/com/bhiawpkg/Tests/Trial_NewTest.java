package com.bhiawpkg.Tests;

import java.awt.color.ProfileDataException;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BHIAW.Helper.AlertHelper;
import com.BHIAW.Helper.Dateselectionhelper;
import com.BHIAW.Helper.DropdownHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.BHIAW.Helper.Report_downloadHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.AMSPage;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.Pages.Reportpage;
import com.bhiawpkg.Pages.TimeEntryPage;
import com.bhiawpkg.Pages.WPRPage;
import com.bhiawpkg.TestBase.TestBase;
import com.bhiawpkg.Utility.XLUTILS;

public class Trial_NewTest extends TestBase{
	
	private static Logger logger=LoggerHelper.getLogger(Trial_NewTest.class);
 // @Test(dataProvider = "logindata")
	//File folder;
	
	/*@BeforeMethod
	public void Downloadsetup()
	{
		folder=new File(UUID.randomUUID().toString());
		folder.mkdir();
		ChromeOptions options=new ChromeOptions();
		Map<String, Object>prefs=new HashMap<String,Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", folder.getAbsolutePath());
		options.setExperimentalOption("prefs", prefs);
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		//driver=new ChromeDriver(cap);
	}*/
	
	@Test
  public void Trial() throws InterruptedException, IOException, FindFailed {
		
		//DateFormat date=new 
		///-----------------------------------------------------------------------------
		LoginPage bhilogin=new LoginPage(driver);
		 
		Config con=new Config(pr);
		 // bhilogin.Login(username, password);
		  bhilogin.Login(con.Getusername(), con.Getpassword());
		  Thread.sleep(2000);
		  logger.info("--------Login is doing------------");
		  bhilogin.Clickbox();
		  logger.info("==============login is sucessful=========================");
		  Thread.sleep(2000);
		  
		  ProjectPage prpg=new ProjectPage(driver);
			prpg.clickProjectsMenu();
			logger.info("-------Clik Project Menu-------");	
			prpg.clickProjectscr();
			logger.info("-------Going to project section-------");	
			prpg.clickAddproject();
			logger.info("-------Click Add Project-------");	
			
		  
		 // con=new Config(pr);
		 // wpr.shiftuser(con.Getsiteusername());
		 // Thread.sleep(2000);
		  WPRPage wpr=new WPRPage(driver);
		  wpr.clickWPRMenu();
		  Thread.sleep(1000);
		  wpr.clickDailyworkprogress();
		  logger.info("-------User Cliked Daily Work Progress-------");
		  WebElement selpjt=driver.findElement(By.xpath("//*[@id='daily-work-progress-grid']//table//thead//tr//td[4]//select"));
		 DropdownHelper dpselpjt=new DropdownHelper(driver) ;
		 dpselpjt.SelectUsingVisibleText(selpjt, "Horizon");
		 Thread.sleep(3000);
		  int wprrowno= driver.findElements(By.xpath("//*[@id='daily-work-progress-grid']//table//tbody//tr")).size();
		  TimeEntryPage TE=new TimeEntryPage(driver);
		  TE.clicktimeentrymenu();
		  TE.clicktimentry();
		  Thread.sleep(2000);
		//  TE.selectuser(con.Getsiteusername());
		//  TE.Clickaddtime();
		//  Thread.sleep(2000);
		  
		 int timentryrowno=driver.findElements(By.xpath("//*[@id='status_table']//tbody//tr")).size();
		 if(wprrowno>0||timentryrowno>0)
		 {
			 
		 }
		  /*-----------------------------------------------------------------------------*/
		//LocalDate Today_date=java.time.LocalDate.now();
		
				//System.out.println("Today date is---"+Today_date);
				
				
				//LocalDate mydate = LocalDate.now(); // Or whatever you want
				//mydate = mydate.minusMonths(1);
				
				//Calendar cal = Calendar.getInstance();
				//cal.add(Calendar.MONTH, -1);
				//Date result = cal.getTime();
				//System.out.println("One month before from the Today date is---"+Today_date.minusMonths(1));
		/*-----------------------------------------------------------------------------
		LoginPage bhilogin=new LoginPage(driver);
		 
		Config con=new Config(pr);
		 // bhilogin.Login(username, password);
		  bhilogin.Login(con.Getusername(), con.Getpassword());
		  Thread.sleep(2000);
		  logger.info("--------Login is doing------------");
		  bhilogin.Clickbox();
		  logger.info("==============login is sucessful=========================");
		  Thread.sleep(2000);
		  
		  AMSPage amspg=new AMSPage(driver);
		  amspg.ClickAMSMenu();
		  Thread.sleep(2000);
		  logger.info("==============User clicked AMS menu=========================");
		  amspg.clickdailypunchlog();
		  logger.info("==============User clicked Daily punch log=========================");
		  amspg.clickdailypunchdate();
		  logger.info("==============User click date=========================");
		  LocalDate currentdate = LocalDate.now();
	      System.out.println("Current date: "+currentdate);
		  amspg.clickdailypunchdate();
		  /*-----------------------------------------------------------------------------
		 // amspg.selectpunchdate(currentdate);
			/*-----------------------------------------------------------------------------	
		  Reportpage rptpg=new Reportpage(driver);
		  rptpg.clickreports();
		  logger.info("==============user click reports menu=========================");
		 // rptpg.clickpjtrepts();
		 // logger.info("==============user click project report========================");
		  rptpg.selpjt(con.Getactionproject());
		  logger.info("==============user select project ========================");
		  rptpg.clickreporttype();
		  logger.info("==============user click  report type========================");
		  rptpg.selrpttype("Consolidated Report");
		  logger.info("==============user consolidated report=======================");
		  rptpg.clickfromdate();
		  
			/*-----------------------------------------------------------------------------			  
		  
	/*-----------------------------------------------------------------------------	  
		 	  
		  driver.findElement(By.linkText("AMS")).click();
			//driver.findElement(By.linkText("Photo Punch request")).click();
			//AMSPage amspg=new AMSPage(driver);
			//amspg.selempname(con.Getsiteusername());
			// String punchtype=amspg.Getpunchtype();
			 // logger.info("-----------user get punch type status-----------------");
			 // amspg.switchuser(con.Getsiteusername());
			 driver.findElement(By.xpath("//li//a[text()='Punching Report']")).click();
			 
			 driver.findElement(By.xpath("//*[@name='exportpdf']")).click();
			 Thread.sleep(8000);
			// Report_downloadHelper reptdnld=new Report_downloadHelper();
			 //reptdnld.chkfiledownload();
			 
			
			 File listOfFiles[] = folder.listFiles();
		        Assert.assertTrue(listOfFiles.length>0);

		        for(File file: listOfFiles){
		            Assert.assertTrue(file.length()>0);
		        }
------------------------------------------------------------------------------------------------------------*/
				
			 
			 
			 
			 
			 
			 
			//*[@id='photo-punch']//table//tbody//tr//td//span
			//driver.findElement(By.linkText("Photo Punch")).click();
	/*------------------------------------------------------------------------		
			System.out.println(driver.findElement(By.xpath("//*[@id='photo-punch']//table//tbody//tr[1]//td[10]")).getText());
			
			String punchtype=driver.findElement(By.xpath("//*[@id='photo-punch']//table//tbody//tr[1]//td[10]")).getText();
			if(punchtype.equals("Out"))
			{
				driver.findElement(By.linkText("AMS")).click();
				driver.findElement(By.linkText("Photo Punch")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='upfile']")).click();
				
				Thread.sleep(2000);
			}
			else if(punchtype.equals("In"))
			{
				driver.findElement(By.linkText("AMS")).click();
				driver.findElement(By.linkText("Photo Punch")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='upfile2']")).click();
				Thread.sleep(2000);
			}
==============================================--------------------------*/			
			//boolean status=driver.findElement(By.xpath("//*[@class='capture-label']")).isDisplayed();
		/*	if(driver.findElement(By.xpath("//*[@class='capture-label']")).isDisplayed()||driver.findElement(By.xpath("//*[@class='capture-label2']")).isDisplayed())
			{
				driver.findElement(By.xpath("//*[@id='upfile']")).click();
				Thread.sleep(2000);
				Assert.assertTrue(true);
			}
			else if(driver.findElement(By.xpath("//*[@class='capture-label2']")).isDisplayed())
			{
				driver.findElement(By.xpath("//*[@id='upfile2']")).click();
				Thread.sleep(2000);
				Assert.assertTrue(false);
			}*?
			
			
			
			
			
			
			
			
			
			/*
			 * if(driver.findElement(By.xpath("//*[@class='row detail-box-shadow']")).
			 * isDisplayed()) { driver.findElement(By.xpath("//*[@id='upfile2']")).click();
			 * Thread.sleep(2000); } else {
			 * driver.findElement(By.xpath("//*[@id='upfile']")).click();
			 * Thread.sleep(2000); }
			 */
			/*
			 * //WebElement
			 * punchin=driver.findElement(By.xpath("//*[@class='capture-label']"));
			 * //WebElement
			 * punchout=driver.findElement(By.xpath("//*[@class='capture-label2']"));
			 * //String punchintxt=punchin.getText();
			 * //System.out.println("Punch text is "+punchin.getText());
			 * 
			 * if(punchin.getText().equals("Punch In")) {
			 * 
			 * driver.findElement(By.xpath("//*[@id='upfile']")).click();
			 * Thread.sleep(2000); Assert.assertTrue(true); } else
			 * if(punchout.getText().equals("Punch Out")) {
			 * driver.findElement(By.xpath("//*[@id='upfile2']")).click();
			 * Thread.sleep(2000); Assert.assertTrue(true); } else {
			 * logger.info("-------------------punch have some issues------------"); }
			 */
			  
			  
			
			//driver.findElement(By.xpath("//*[@id='upfile']")).click();
			//Runtime.getRuntime().exec("C:\\Users\\divya\\OneDrive\\Desktop\\Works\\PMS_WORKSPACE\\photopunch\\photopunch_developer1.exe");
			
			//Runtime.getRuntime().getRuntime().exec("C:\\Users\\divya\\OneDrive\\Desktop\\Works\\PMS_WORKSPACE\\photopunch\\photopunch_developer1.exe");
			//Thread.sleep(3000);
			//driver.findElement(By.xpath("//*[@value='Submit']")).click();
			//Thread.sleep(3000);
			//  LogoutPage logout=new LogoutPage(driver); logout.clickusericon();
			//  logout.clickLogout();
			 
			//driver.get("http://stagepms.ashlyerp.xyz/index.php?r=site/login");
		  
			//*[@id='upfile']
  }
 /* @DataProvider(name="logindata")
  public String[][] getlogindetails() throws InvalidFormatException, IOException
  {
 	  String path="C:\\Users\\divya\\OneDrive\\Desktop\\Works\\PMS_WORKSPACE\\Testdata_ashlypms\\login.xlsx";
 	  logger.info("file is getting!!!!!");
 		  int rowcnt=XLUTILS.getrowcount(path, "logindata");
 		  int colcnt=XLUTILS.getcellcount(path, "logindata",1);
 		  String [][]login=new String[rowcnt][colcnt];
 		  for(int i=1;i<=rowcnt;i++)
 		   {
 			  for(int j=0;j<colcnt;j++)
 			  {
 				 login[i-1][j]=XLUTILS.getCellData(path, "logindata", i, j);
 			  }
 		  }
 		  logger.info("Excel data is returned");
 		  return login;
  }*/
  @AfterMethod
  public void Aftermethod() throws InterruptedException
  {
		/*
		 * Thread.sleep(2000); LogoutPage logout=new LogoutPage(driver);
		 * logout.clickusericon(); logout.clickLogout();
		 * driver.get("http://stagepms.ashlyerp.xyz/index.php?r=site/login");
		 */

  }
}
  /*	
  ProjectPage prpg=new ProjectPage(driver);
			prpg.clickProjectsMenu();
			logger.info("-------Clik Project Menu-------");	
			prpg.clickProjectscr();
			logger.info("-------Going to project section-------");	
			prpg.clickAddproject();
			logger.info("-------Click Add Project-------");	
			prpg.clickstartdatepicker();
			logger.info("-------Project Start Date picker is clicked-------");
			prpg.selectstartdate("11","October", "2021");
			logger.info("-------Project Start Date is selected-------");
			
		  
		  
		  
		  TimeEntryPage  timepg=new TimeEntryPage(driver);
		  timepg.clicktimeentrymenu();
		  logger.info("----------user clicked time entry menu--------------------");
		  timepg.clicktimentry();
		  logger.info("--------user select time entry in time entry menu----------------");
		  timepg.selectuser(con.Getsiteusername());
		  logger.info("--------user switched to another user------------------");
		  timepg.Clickaddtime();
		  Thread.sleep(2000);
		  logger.info("--------user clicked add time ------------------");
		  timepg.selecttask("FRPJTBHI06INT02");
		  logger.info("--------user select the task name ------------------");
		  timepg.selectwrktype("ALUMINUM DOORS");
		  logger.info("--------user select the work type ------------------");
		  timepg.clickentrydate();
		  logger.info("--------user clicked entry date ------------------");
		 Dateselectionhelper datesel=new Dateselectionhelper(driver);
		 //datesel.selectDate1("11", "October,", "2021");
		 // String[] currentmonth=currentdate.split(" ");
		//  System.out.println("Splitted value is "+currentmonth[0]);
		  
		 // String cumonth=getMonthYear[0];
		  //String cuyear=getMonthYear[1];
		 // System.out.println("Expected month is "+cumonth); 
		 // System.out.println("Expected year is "+cuyear);
		//	String expMonth="October" ;
		//	String expYear="2021";
		 
		  
		  /*  timepg.selecttimedate("05", "October", "2021");
		  logger.info("--------user typed the date------------------");
		  timepg.typeprogress("1");
		  logger.info("--------user enter the internal task progress ------------------");
		  timepg.selecttimestatus("In-progress");
		  logger.info("--------user select the status ------------------");
		  timepg.typetimeentryhours("00:01");
		  logger.info("--------user enter the hours ------------------");
		  timepg.typetimeentrydescr("time entry description");
		  logger.info("--------user enter the description ------------------");
		  timepg.clickcreatebutton();
		  logger.info("--------user clicked the create button ------------------");
		  Thread.sleep(2000);

		  String Monthyearvalue= driver.findElement(By.xpath("//*[@class='calendar']//thead//tr[1]//td[2]")).getText();
		  System.out.println("Curent date is "+Monthyearvalue); 
  }	
  
  public void seldate(String exDay,String exMonth,String exYear)
  {
	  if(exMonth.equals("February")&&Integer.parseInt(exDay)>29)
	  {
			System.out.println("Wrong Date:"+exMonth+":"+exDay);
			return;
		}
		if(Integer.parseInt(exDay)>31)
		{
			System.out.println("Wrong Date:"+exMonth+":"+exDay);
			return;
		}
		String monthYearVal=driver.findElement(By.xpath("//*[@class='calendar']//thead//tr[1]//td[2]")).getText();
		System.out.println(monthYearVal);
		 String [] month =monthYearVal.split(",");
		  String expmonth=month[0];
		  System.out.println("Expected month is"+expmonth);
		  String exyear=month[1];
		  System.out.println("Expected year is "+exyear);
	//(!(expmonth.equals(exMonth)&&exyear.equals(exYear)))
		  String actmonth = "September";
		  String actyear = "2021";
		  while(!(actmonth.equals(exMonth)&& actyear.equals(exYear)))
				
	  {
		  System.out.println("--------------------------------------sss");
		  driver.findElement(By.xpath("//*[@class='calendar']//thead//tr[2]//td[4]")).click();
		  String[] actvalue=monthYearVal.split(",");
			 
		   actmonth=actvalue[0];
		   actyear=actvalue[1];
		  monthYearVal= driver.findElement(By.xpath("//*[@class='calendar']//thead//tr[1]//td[2]")).getText();
		  
		 // System.out.println(expMonth+expYear);
		  //Monthyearvalue="October 2021";
	  }
		  try 
		  {
			  System.out.println("--------------------------------------sss");
			 
		  }
		  catch(Exception e)
		  {
			  System.out.println(e.getStackTrace());
		  }
	  
  }
  public   String[] getMonthYear(String monthYearVal )
	{
		return monthYearVal.split(",");
		
	}*/
 
/*====================================================================================================	
 * 
 /*
		  logger.info("******************************WPR  SECTION**********************************");
		  WPRPage wpr=new WPRPage(driver);
		 // wpr=new WPRPage(driver);
		  con=new Config(pr);
			 driver.navigate().to(driver.getCurrentUrl());
			 Thread.sleep(2000);
			 wpr=new WPRPage(driver);
			 wpr.clickWPRMenu();
			 Thread.sleep(2000);
			 logger.info("-------User Cliked WPR Menu-------");
			 wpr.clickWPRpendinrequest();
			 Thread.sleep(2000);
			 logger.info("-------User Cliked Pending request-------");
			 wpr.shiftuser(con.Getadminusername());
			 Thread.sleep(2000);
			 logger.info("-------Switched to another User -------");
			 String selpjt=con.Getactionproject();
			 wpr.selectpendpjt(selpjt);
			 Thread.sleep(2000);
			 logger.info("-------select the project from properties------------");
		  	 int rows=driver.findElements(By.xpath("//*[@class='table table-bordered']//tbody//tr")).size();
			  System.out.println("Total number of rows "+rows);
			    String beforexpath="//*[@class='table table-bordered']//tbody//tr[";
		  String afterxpath="]//td[4]";
		  String tskafterpath="]//td[5]";
		 // String expectedtskname=driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr[1]//td[5]")).getText();
		  for(int i=1;i<=rows;i++)
		  {
			  String expectedtskname=driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr[1]//td[5]")).getText();
				
			 String EXproject= con.Getactionproject();
			  String Projectname=driver.findElement(By.xpath(beforexpath+i+afterxpath)).getText();
			  String ActTaskname=driver.findElement(By.xpath(beforexpath+i+tskafterpath)).getText();
			  System.out.println("Project name is "+Projectname);
			//  wpr.selectpendpjt("MPJT04");
			  Thread.sleep(2000);
			  if(Projectname.contentEquals(EXproject)&&expectedtskname.contentEquals(ActTaskname))
			  {
				WebElement chkbox=driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr["+i+"]//td[1]"));
			   chkbox.click();
			   Thread.sleep(2000);
			   driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr[\"+i+\"]//td[13]//a[@title='Approve']")).click();
			  // Thread.sleep(2000);
			   AlertHelper alert=new AlertHelper(driver);
			   alert.AcceptAlertIfPresent();
			   Thread.sleep(2000);
			 //*[@class='table table-bordered']//tbody//tr["+i+"]//td[13]//a[@title='Approve']
				/*
				 * String ch1=driver.findElement(By.
				 * xpath("//*[@class='table table-bordered']//tbody//tr[\"+i+\"]//td[1]//span"))
				 * .getAttribute("class"); System.out.println(ch1); boolean sel;
				 * if(chkbox.isSelected()) { sel=true; System.out.println(sel); } else {
				 * sel=false; System.out.println(sel); }
				 */  
			
		  
/*=======================================================================================================================		  
		 //  WebElement chkbox=driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr[1]//td[1]"));
		 //   System.out.println(chkbox.isSelected());
		//*[@class='table table-bordered']//tbody//tr[1]//td[1]
		 // chkbox.click();
		  //Thread.sleep(2000);
		//  System.out.println(chkbox.isSelected());
		 
		//String check=  driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr//td//following::span")).getAttribute("class");
		 
		  
		//  boolean staus=false;
		
		
		
		/*if(chkbox.isSelected())
		  {
			  boolean status = true;
			  if(status==true)
			  {
				  Assert.assertTrue(true);
				  logger.info("-------check box is selected-------");
			  }
			  else
			  {
				  logger.info("-------check box is not selected-------");
				  Assert.assertTrue(false);
				  captureScreen(driver,"Pending request");
			  }
		  }*/
		  
		 /* for(int r=1;r<=rows;r++)
		  {
			  String Project= driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr["+r+"]//td[4]")).getText();
			 
			   String Task= driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr["+r+"]//td[5]")).getText();
			   System.out.println("Project name is ="+Project+  "   "+   "   "+"Task is ="+Task);
				 
		  }*/
		  
		  
		  
		  
		  
		  
		  
		  
	/*	  boolean status=bhilogin.verifysuccessfull();
		  	  if(status==true){
				Assert.assertTrue(true);
				//Thread.sleep(2000);
				bhilogin.Clickbox();
				logger.info("-------login is sucessful-------");	
				ProjectPage prpg=new ProjectPage(driver);
				prpg.clickProjectsMenu();
				logger.info("-------Clik Project Menu-------");	
				prpg.clickProjectscr();
				logger.info("-------Going to project section-------");	
				prpg.clickAddproject();
				logger.info("-------Click Add Project-------");	
				prpg.typeprojectname("WEDPJT");
				logger.info("-------Entered Project name-------");	
				prpg.selectclient("THCLIENT");
				logger.info("-------Client selected-------");	
				//driver.findElement(By.xpath("//*[@id='Projects_billable']//input[1]")).click();
				prpg.selectbillable();
				logger.info("-------Billable yes/No selected-------");
				prpg.selectStaus();
				logger.info("-------Stauts is selected-------");
				//driver.findElement(By.id("Projects_start_date")).sendKeys("02-Sep-21");
			
			}
			else{
				captureScreen(driver,"loginTest");
				 // Assert.assertTrue(false);
				Assert.assertTrue(false, "-------login is not sucessful-------");
			}*/
		  	//con.Geturl();
		 
 
  
  
  

