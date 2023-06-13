package com.bhiawpkg.Tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.BHIAW.Helper.Dateselectionhelper;
import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.TimeEntryPage;
import com.bhiawpkg.TestBase.TestBase;

public class LocalTest extends TestBase{
	private static Logger loger=LoggerHelper.getLogger(LocalTest.class);

  @Test
  public void f() throws InterruptedException {
	  
	 Config con=new Config(pr); 
	LoginPage	bhilogin=new LoginPage(driver);
	    bhilogin.Login(con.Getusername(),con.Getpassword());
	    loger.info("--------Login is doing------------");
	    bhilogin.Clickbox();
	    loger.info("==============login is sucessful=========================");
	    TimeEntryPage  timepg=new TimeEntryPage(driver);
		  timepg.clicktimeentrymenu();
		  loger.info("----------user clicked time entry menu--------------------");
		  timepg.clicktimentry();
	  
	     int rows=driver.findElements(By.xpath("//*[@class='table table-bordered']//tbody//tr")).size();
		 System.out.println("Total number of rows "+rows);
		  String beforexpath="//*[@class='table table-bordered']//tbody//tr[";
		 String afterxpath="]//td[2]";
		
		 for(int i=1;i<=rows;i++)
		  {
			  String taskname=driver.findElement(By.xpath(beforexpath+i+afterxpath)).getText();
			 System.out.println("Taskname is "+taskname); 
			 driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr["+i+"]//td[9]//a[1]")).click(); 
			 System.out.println("user cliked Edit menu");
			// Thread.sleep(2000);
			// driver.findElement(By.xpath("//*[@class='icon-arrow-up']")).click();
		   
		  }
			
	 
  }
  }
	  
/* --------------------------------------------------------------

	  Dateselectionhelper date1=new Dateselectionhelper(driver);
	 System.out.println("Current date is "+date1.getCurrentDate());
	  
	  String date2 = date1.getCurrentDate();
	  String[] cudate=date2.split("-");
	  String exYear=cudate[0];
	  String exMonth=cudate[1];
		DateFormat datef=new SimpleDateFormat();
		//DateTime date1 = DateTime.now();
		//String month = date1.toString("MMM");
	  System.out.println("Exp year is"+exYear);
	  System.out.println("Exp month is"+exMonth);	  
	  
	-------------------------------------------------------------------------------------- */  
	  
	  
	  
	  
	  
	 /* --------------------------------------------------------------------------------------------------------
	  Config con=new Config(pr);
	  
	   con.Geturl();
	   LoginPage bhilogin=new LoginPage(driver);
	   bhilogin.Login(con.Getusername(), con.Getpassword());
	   bhilogin.Clickbox();
		  loger.info("==============login is sucessful=========================");
		  Thread.sleep(2000);
		 TimeEntryPage timepg=new TimeEntryPage(driver);
		 timepg.clicktimeentrymenu();
		  loger.info("----------user clicked time entry menu--------------------");
		  timepg.clickpendingrequest();
		  loger.info("---------click pending request------------------");
	      WebElement elem=driver.findElement(By.xpath("//*[@id='time-entry-grid']//table//thead//tr//td[8]"));
	      elem.click();
	      Dateselectionhelper dtse=new Dateselectionhelper(driver);
	      LocalDate date=LocalDate.now();
	      String getdate=date.toString();
	      System.out.println("Today date is "+getdate);
	      String[] ymddate=getdate.split(",");
	      
	      String exYear=ymddate[0];
	      String exMonth=ymddate[1];
	      String exDay=ymddate[2];
	      
	      
	      
	      
	      dtse.selectDate(exDay, exMonth, exYear);
 --------------------------------------------------------------------------------------------------------------- */
	      
  











