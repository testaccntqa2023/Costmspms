package com.bhiawpkg.Tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.MyTaskPage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.Pages.TimeEntryPage;
import com.bhiawpkg.TestBase.TestBase;
import com.bhiawpkg.Utility.XLUTILS;

public class ExpiredInternalTaskTest extends TestBase {
	private static Logger loger=LoggerHelper.getLogger(ExpiredInternalTaskTest.class);
	 LoginPage  bhilogin;
	 Config  con;
	 TimeEntryPage timepg;
	 ProjectPage prpg;
	 MyTaskPage mytskpg;
	 @BeforeMethod
	public void GetAddTask() throws InterruptedException 
	{
		con=new Config(pr); 
		bhilogin=new LoginPage(driver);
	    bhilogin.Login(con.Getusername(),con.Getpassword());
	    loger.info("--------Login is doing------------");
	    Thread.sleep(2000);
	 //   bhilogin.Clickbox();
	    loger.info("==============login is sucessful=========================");
	    Thread.sleep(2000);
	}
//-----------------------------------------------------------------------------------------------------------------------------------	 
  @Test(dataProvider ="TimeEntry", description = "If the time entry details can add")
 public void ExpiredTask_AddTimeEntry(String Taskname ,String WorkType,String TimeExDate,String Progress,
		  String Currentstatus,String Hours,String Description ) throws InterruptedException, IOException
 {
	  prpg=new ProjectPage(driver);
	  prpg.clickProjectsMenu();
	  loger.info("-------Clik Project Menu-------");
	  con=new Config(pr);
	 // String pjtname= con.Getactionproject();
	  String pjtname= con.Getexpiredproject();
	 // prpg.clickProjectscr();
	  loger.info("---click projects menu----");
	 // String pjtname=prpg.Getprojectname();
	  mytskpg=new MyTaskPage(driver);
	  mytskpg.clickmytskmenu();
	  Thread.sleep(2000);
	  loger.info("-------------------user click my task menu--------------------------------------");
	  mytskpg.clickmytaskoption();
	  Thread.sleep(2000);
	  mytskpg.selmytskpjt(pjtname);//con.Getactionproject()
	  Thread.sleep(2000);
	  loger.info("-------------------user select the project--------------------------------------");
	  //mytskpg.seltasktype("External");
	 // Thread.sleep(2000);
	 // mytskpg.clickmytaskview();
	  Thread.sleep(2000);
	//  
	  mytskpg.seltaskstatus("In-progress");
	  Thread.sleep(2000);
	  mytskpg.clickexpiredinternalmytaskview();
	  Thread.sleep(2000);
	  con=new Config(pr);
	  mytskpg.shiftuser(con.Getsiteusername());
	   Thread.sleep(2000);
	  mytskpg.clickAddTimebtn();
	   timepg=new TimeEntryPage(driver);
	  timepg.typeprogress(Progress);
	  loger.info("--------user enter the internal task progress ------------------");
	  timepg.selecttimestatus(Currentstatus);
	  loger.info("--------user select the status ------------------");
	  timepg.typetimeentrydescr(Description);
	  loger.info("--------user enter the description ------------------");
	  timepg.clickcreatebutton();
	  loger.info("--------user clicked the create button ------------------");
	  Thread.sleep(2000);
	  
	  /*
	  
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
	  */
	  /*WebElement statuselm=driver.findElement(By.xpath("//*[@id='status_table']")) ;
	  waitForElementWithPollingInterval(driver, 30, statuselm);*/
	//  loger.info("--------Add time entry section ------------------");
	 // Thread.sleep(2000); 
}
//-------------------------------------------------------------------------------------------*/----------------------------------------
 @DataProvider(name="TimeEntry")
 public String[][] gettimeentrydetails() throws InvalidFormatException, IOException
 {
	  String path=System.getProperty("user.dir")+ "/src/test/java/com/bhiawpkg/Testdata/ashlypmsdata1.xlsx";
	  loger.info("file is getting!!!!!");
		  int rowcnt=XLUTILS.getrowcount(path,"TimeEntry");
		  int colcnt=XLUTILS.getcellcount(path,"TimeEntry",1);
		  String [][]TimeEntry=new String[rowcnt][colcnt];
		  for(int i=1;i<=1;i++)
		   {
			  for(int j=0;j<colcnt;j++)
			  {
				  TimeEntry[i-1][j]=XLUTILS.getCellData(path,"TimeEntry", i, j);
			  }
		  }
		  loger.info("Excel data is returned");
		  return TimeEntry;
 }
 @AfterMethod
 public void Logout()
 {
	  LogoutPage logout=new LogoutPage(driver);
	  logout.clickusericon();
	  logout.clickLogout();
 }

}
