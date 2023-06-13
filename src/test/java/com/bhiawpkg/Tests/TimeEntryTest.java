package com.bhiawpkg.Tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.AssignedtaskPage;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.TimeEntryPage;
import com.bhiawpkg.TestBase.TestBase;
import com.bhiawpkg.Utility.XLUTILS;

public class TimeEntryTest extends TestBase {
	private static Logger loger=LoggerHelper.getLogger(TimeEntryTest.class);
	 LoginPage  bhilogin;
	 Config  con;
	 TimeEntryPage timepg;
	
	 @BeforeMethod
	public void GetAddTask() throws InterruptedException 
	{
		con=new Config(pr); 
		bhilogin=new LoginPage(driver);
	    bhilogin.Login(con.Getusername(),con.Getpassword());
	    loger.info("--------Login is doing------------");
	    Thread.sleep(2000);
	    bhilogin.Clickbox();
	    loger.info("==============login is sucessful=========================");
	    Thread.sleep(2000);
	}
//-----------------------------------------------------------------------------------------------------------------------------------	 
   @Test(dataProvider ="TimeEntry", description = "If the time entry details can add")
  public void AddTimeEntry(String Taskname ,String WorkType,String TimeExDate,String Progress,
		  String Currentstatus,String Hours,String Description ) throws InterruptedException, IOException
  {
	  timepg=new TimeEntryPage(driver);
	  timepg.clicktimeentrymenu();
	  loger.info("----------user clicked time entry menu--------------------");
	  //driver.navigate().refresh();
	  timepg.clicktimentry();
	  loger.info("--------user select time entry in time entry menu----------------");
	  driver.get(driver.getCurrentUrl());
	  Thread.sleep(2000);
	  //timepg.selectproject(con.Getactionproject());
	  //driver.navigate().refresh();
	  timepg.selectuser(con.Getsiteusername());
	  loger.info("--------user switched to another user------------------");
	  timepg.Clickaddtime();
	  Thread.sleep(3000);
	  loger.info("--------user clicked add time ------------------");
	  try {
	  timepg.selecttask(Taskname);
	  loger.info("--------user select the task name ------------------");
	  timepg.selectwrktype(WorkType);
	  Thread.sleep(2000);
	  loger.info("--------user select the work type ------------------");
	  timepg.clickentrydate();
	 // Thread.sleep(2000);
	  //loger.info("--------user clicked entry date ------------------");
	 // timepg.selecttimedate(TimeExDay, TimeExMonth, TimeExYear);
	  Thread.sleep(2000);
	 // timepg.selecttimedate("05", "October", "2021");
	 // timepg.seltimeentrydate(TimeExDate);
	  timepg.seltimeentrydate();
	  loger.info("--------user typed the date------------------");
	  timepg.typeprogress(Progress);
	  loger.info("--------user enter the internal task progress ------------------");
	  timepg.selecttimestatus(Currentstatus);
	  loger.info("--------user select the status ------------------");
	  timepg.typetimeentryhours(Hours);
	  loger.info("--------user enter the hours ------------------");
	  
	  timepg.typetimeentrydescr(Description);
	  loger.info("--------user enter the description ------------------");
	  timepg.clickcreatebutton();
	  loger.info("--------user clicked the create button ------------------");
	  Thread.sleep(2000);
	  boolean timeentrystatus=timepg.verifysuccessfull();
		loger.info("-------Verifying .....Time entry create Entry Failed -------");
		//Thread.sleep(2000);
		if(timeentrystatus==true)
		{
		Assert.assertTrue(true);
		loger.info("********Verifying ....Time entry creation done successfully!!************");
		loger.info("**********************************************************************************************************");
		}
		else
		{
			captureScreen(driver,"-------Time entry create------------------------");
			Thread.sleep(2000);
			Assert.assertTrue(false, "********---Time entry create process failed!!************");
		}
	  }
	  catch(Exception ex)
	  {
		  captureScreen(driver,"-------Time entry create failed, task not loaded-------");
			Thread.sleep(2000);
			Assert.assertTrue(false, "********---Time entry create process failed!!************");  
	  }
	  /*WebElement statuselm=driver.findElement(By.xpath("//*[@id='status_table']")) ;
	  waitForElementWithPollingInterval(driver, 30, statuselm);*/
	//  loger.info("--------Add time entry section ------------------");
	 // Thread.sleep(2000); 
 }
 //-------------------------------------------------------------------------------------------*/----------------------------------------
  @DataProvider(name="TimeEntry")
  public String[][] gettimeentrydetails() throws InvalidFormatException, IOException
  {
	  String path=System.getProperty("user.dir")+ "/src/test/java/com/bhiawpkg/Testdata/ashlypmsdata.xlsx";
 	  loger.info("file is getting!!!!!");
 		  int rowcnt=XLUTILS.getrowcount(path,"TimeEntry");
 		  int colcnt=XLUTILS.getcellcount(path,"TimeEntry",1);
 		  String [][]TimeEntry=new String[rowcnt][colcnt];
 		  for(int i=1;i<=rowcnt;i++)
 		   {
 			  for(int j=0;j<colcnt;j++)
 			  {
 				  TimeEntry[i-1][j]=XLUTILS.getCellData(path,"TimeEntry", i, j);
 			  }
 		  }
 		  loger.info("Excel data is returned");
 		  return TimeEntry;
  }
 // /*-----------------------------------------------------------------------------------------------------------------------------------
	 @Test(description = "If the time entry can Approve")
  public void ApproveTimeEntry() throws InterruptedException, IOException
  {
	  timepg=new TimeEntryPage(driver);
	  timepg.clicktimeentrymenu();
	  loger.info("----------user clicked time entry menu--------------------");
	  timepg.clicktimentry();
	  loger.info("--------user select time entry in time entry menu----------------");
	  String expapprovedate=timepg.Getexpapprovedate();
	  System.out.println("expected approve date is "+expapprovedate);
	  timepg.clicktimeentrymenu();
	  timepg.clickpendingrequest();
	  Thread.sleep(2000);
	  loger.info("---------click pending request------------------");
	  
      // timepg.selectdateapprove("15", "September", "2021");
     // timepg.Getactapprdate(expapprovedate);
	  timepg.clickApprovedate(expapprovedate);
	   Thread.sleep(2000);
     loger.info("----------------user click the grid date-------------");
      loger.info("--------user select the date--------------");
      
     // boolean grdtime=timepg.gridtxtelm().isDisplayed();
     // Thread.sleep(2000);
    //  String gridtxt=timepg.Gettimeentrygrtxt();
      Thread.sleep(2000);
      int rowno=timepg.getgridrowno();
      if(rowno>=1)
      {
    	  timepg.clickApprove();
          Thread.sleep(2000);
          loger.info("---------------user click approve button---------------------------");
          timepg.clickAlert();
          loger.info("-------user given approval---------");
          Thread.sleep(2000);
          loger.info("--------Approve time entry section successfully!!------------------");
          Assert.assertTrue(true);
      }
      else
      {
      captureScreen(driver, "TimeEntry approve");
	  loger.info("-------- no data exist to Approve time entry section ------------------");
	  Assert.assertTrue(false, "--------------no data exist to approve-----------------------------");
      }
		
  }
  //--------------------------------------------------------------------------------------------*/
  @Test(dataProvider ="TimeEntry" ,description = "If the time entry details can edit")
  public void EditTimeEntry(String Taskname ,String WorkType,String TimeExDate,String Progress,
		  String Currentstatus,String Hours,String Description) throws InterruptedException, IOException
  {
	  
	    timepg=new TimeEntryPage(driver);
	  
	 
	/* 
	 timepg.clickbtmproject();
	  Thread.sleep(2000);
	  Thread.sleep(2000);
	  timepg.clicksearchpjtbtn();
	  Thread.sleep(2000);
	  String beforepathpjtnme="//*[@id='expand-projects']//div[@class='caption']//h2[text()='";
		 String afterpathpjtnme="']";
		  driver.findElement(By.xpath(beforepathpjtnme+con.Getactionproject()+afterpathpjtnme)).click();
		  Thread.sleep(2000);*/
	  timepg.clicktimeentrymenu();
	  loger.info("----------user clicked time entry menu--------------------");
	  timepg.clicktimentry();
	  Thread.sleep(2000);
	 // timepg.selectuser(con.Getsiteusername());
	  timepg.switchuser(con.Getsiteusername());
	  Thread.sleep(2000);
	  try
	  {
	     int rows=driver.findElements(By.xpath("//*[@class='table table-bordered']//tbody//tr")).size();
		 System.out.println("Total number of rows "+rows);
		 String beforexpath="//*[@class='table table-bordered']//tbody//tr[";
		 String afterxpath="]//td[1]";
		 String expectedtaskname=driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr[1]//td[1]")).getText();
		 Thread.sleep(2000);
		 if(expectedtaskname.contains("This week's timesheet does not have any time added"))
		 {
			 Assert.assertFalse(false, "------------------no data to edit--------------------------");
		 }
		 else
		 {
		// String expectedpjtname=driver.findElement(By.xpath(beforepathpjtnme+con.Getactionproject()+afterpathpjtnme)).getText();
		// expectedpjtname.click();
		
		 String expecteduser=con.Getsiteusername();
		 Thread.sleep(2000);
		 for(int i=1;i<=1;i++)
		  {
			 //String actuser=driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr[1]//td[1]")).getText();
			 String acttaskname=driver.findElement(By.xpath(beforexpath+i+afterxpath)).getText();
			 System.out.println("Taskname is "+acttaskname); 
			 if(expectedtaskname.equals(acttaskname))
			 {
			 driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr["+i+"]//td[9]//a[@title='Edit']")).click();
			 Thread.sleep(2000);
			 loger.info("---------user cliked Edit Option-------------------");
			 
			 //driver.findElement(By.xpath("//*[@class='icon-arrow-up']")).click();
			 timepg.selecttask(Taskname);
			 Thread.sleep(2000);
			  loger.info("--------user select the task name ------------------");
			  timepg.selectwrktype(WorkType);
			  Thread.sleep(2000);
			  loger.info("--------user select the work type ------------------");
			  timepg.clickentrydate();
			  timepg.seltimeentrydate();
			  Thread.sleep(2000);
			//  loger.info("--------user clicked entry date ------------------");
			//  timepg.selecttimedate(TimeExDay, TimeExMonth, TimeExYear);
			  
			 // timepg.selecttimedate("05", "October", "2021");
			  loger.info("--------user typed the date------------------");
			  timepg.typeprogress(Progress);
			  Thread.sleep(2000);
			  loger.info("--------user enter the internal task progress ------------------");
			  timepg.selecttimestatus(Currentstatus);
			  Thread.sleep(2000);
			  loger.info("--------user select the status ------------------");
			  timepg.typetimeentryhours(Hours);
			  loger.info("--------user enter the hours ------------------");
			  timepg.typetimeentryeditdescr(Description);
			  loger.info("--------user enter the description ------------------");
			  timepg.Clicksavebtn();
			  Thread.sleep(3000);
			  loger.info("----------user clicked save button-------------------");
			  loger.info("--------Edit time entry section passed ------------------");
		    }
		  }
			// timepg=new TimeEntryPage(driver);
		 boolean timeentrystatus=timepg.verifysuccessfull();
		 Thread.sleep(2000);
			loger.info("-------Verifying .....Edit time Entry Failed -------");
			
			if(timeentrystatus==true)
			{
			Assert.assertTrue(true);
			loger.info("********Verifying ....Edit done successfully!!************");
			loger.info("**********************************************************************************************************");
			}
			else
			{
				captureScreen(driver,"-------Edit time entry-------------------------");
				Thread.sleep(2000);
				Assert.assertTrue(false, "********---Edit process failed!!************");
			}
				
		  }
	  }
		 catch(Exception ex)
		 {
			 captureScreen(driver,"-------Edit time entry-------------------------");
			Thread.sleep(2000);
			Assert.assertTrue(false, "********---Edit process failed!!*No data Exist***********");
		 }
		 
 }
 
  ///*----------------------------------------------------------------------------------------------------------------------------------- 
  @Test(description = "If the time entry details can Delete")
  public void TimeEntry_Delete() throws InterruptedException, IOException
  {
	  TimeEntryPage  timepg=new TimeEntryPage(driver);
	  timepg.clicktimeentrymenu();
	  loger.info("----------user clicked time entry menu--------------------");
	  timepg.clicktimentry();
	  try {
	     int rows=driver.findElements(By.xpath("//*[@class='table table-bordered']//tbody//tr")).size();
		 System.out.println("Total number of rows "+rows);
		 String beforexpath="//*[@class='table table-bordered']//tbody//tr[";
		 String afterxpath="]//td[2]";
		 String expectedtaskname=driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr[1]//td[2]")).getText();
		 for(int i=1;i<=1;i++)
		  {
			 //String acttaskname=driver.findElement(By.xpath(beforexpath+i+afterxpath)).getText();
			 //System.out.println("Taskname is "+acttaskname); 
			// if(expectedtaskname.equals(acttaskname))
			 //{
			 driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr["+i+"]//td[10]//a[2]")).click(); 
			 Thread.sleep(2000);
			 loger.info("---------user cliked Delete Option-------------------");
			 timepg.clickAlert();
		      loger.info("-------user given Delete---------");
		      Thread.sleep(2000);
		      boolean timeentrystatus=timepg.verifysuccessfull();
				
				//Thread.sleep(2000);
				if(timeentrystatus==true)
				{
				Assert.assertTrue(true);
				loger.info("********Verifying ....Delete done successfully!!************");
				loger.info("**********************************************************************************************************");
				}
				else
				{
					captureScreen(driver,"-------Delete time entry-------------------------");
					Thread.sleep(2000);
					loger.info("-------Verifying .....Delete time Entry Failed -------");
					Assert.assertTrue(false, "********---Delete process failed!!************");
				}
		     
		     // }
		  }
	  }
	  catch(Exception ex)
	  {
		  captureScreen(driver,"-------Delete time entry-------------------------");
		  Thread.sleep(2000);
		  Assert.assertTrue(false, "********---Delete process failed!!*No data exist to delete***********");
	  }
	  
  }
 // /*-----------------------------------------------------------------------------------------------------------------------------------
 //---------------------------------------------------------------------------------------
 @AfterMethod
  public void Logout(ITestResult result) throws IOException, InterruptedException
  {
	 
	 LogoutPage logout=new LogoutPage(driver);
	  logout.clickusericon();
	  logout.clickLogout();
		
  }
  
  
}
