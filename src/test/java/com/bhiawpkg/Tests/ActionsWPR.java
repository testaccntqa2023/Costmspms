package com.bhiawpkg.Tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BHIAW.Helper.AlertHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.WPRPage;
import com.bhiawpkg.TestBase.TestBase;

public class ActionsWPR extends TestBase{
	private static Logger loger=LoggerHelper.getLogger(WPRTest.class);
	WPRPage wpr;
	Config con;
 @BeforeMethod
  public void WPR() throws InterruptedException
 {
	  LoginPage bhilogin=new LoginPage(driver);
	   con=new Config(pr);
		  bhilogin.Login(con.Getusername(), con.Getpassword());
		 // Thread.sleep(4000);
		  loger.info("--------Login is doing------------");
		  bhilogin.Clickbox();
		  loger.info("==============login is sucessful=========================");	
		  loger.info("******************************WPR  SECTION**********************************");
		  wpr=new WPRPage(driver);
		 	 wpr.clickWPRMenu();
		 	 Thread.sleep(2000);
		 	 loger.info("-------User Cliked WPR Menu-------");
		 	 wpr.clickWPRpendinrequest();
		 	 Thread.sleep(2000);
		 	 loger.info("-------User Cliked Pending request-------");
	 } 
 

  @Test(priority = 2)
  public void ApproveDailyWrok() throws InterruptedException
  {
 	int a;
 	 con=new Config(pr);
 	 driver.navigate().to(driver.getCurrentUrl());
 	 Thread.sleep(2000);
		/*
		 * wpr=new WPRPage(driver); wpr.clickWPRMenu(); Thread.sleep(2000);
		 * loger.info("-------User Cliked WPR Menu-------");
		 * wpr.clickWPRpendinrequest(); Thread.sleep(2000);
		 * loger.info("-------User Cliked Pending request-------");
		 */
 	 wpr.shiftuser(con.Getadminusername());
 	 Thread.sleep(2000);
 	 loger.info("-------Switched to another User -------");
 	 String selpjt=con.Getactionproject();
 	 wpr.selectpendpjt(selpjt);
 	 Thread.sleep(2000);
 	 loger.info("-------select the project from properties------------");
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
 		   loger.info("------------Alert is accepted-------------------");
 		   
 		   Thread.sleep(2000);
 			  }
 		  }
  	}
  @Test(priority = 3)
  public void RejectionDWP() throws InterruptedException
  {
	  wpr.shiftuser(con.Getadminusername());
		 Thread.sleep(2000);
		 loger.info("-------Switched to another User -------");
		 String selpjt=con.Getactionproject();
		 wpr.selectpendpjt(selpjt);
		 Thread.sleep(2000);
		 loger.info("-------select the project from properties------------");
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
				   loger.info("--------------Check box is clicked to Reject--------------------");
				   Thread.sleep(2000);
				   driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr[\"+i+\"]//td[13]//a[@title='Reject']")).click();
				   loger.info("--------------clicked Reject--------------------");
				   AlertHelper alert=new AlertHelper(driver);
				   alert.AcceptAlertIfPresent();
				   loger.info("------------Alert is accepted-------------------");
				   Thread.sleep(2000);
				  }
		 	}
  		}
  @Test(priority = 1)
  public void ViewDWP() throws InterruptedException
  {
	  wpr.shiftuser(con.Getadminusername());
		 Thread.sleep(2000);
		 loger.info("-------Switched to another User -------");
		 String selpjt=con.Getactionproject();
		 wpr.selectpendpjt(selpjt);
		 Thread.sleep(2000);
		 loger.info("-------select the project from properties------------");
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
				   loger.info("--------------Check box is clicked to View--------------------");
				   Thread.sleep(2000);
				   driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr[\"+i+\"]//td[13]//a[@title='View']")).click();
				   loger.info("--------------clicked View--------------------");
				   AlertHelper alert=new AlertHelper(driver);
				   alert.AcceptAlertIfPresent();
				   loger.info("------------Alert is accepted-------------------");
				   Thread.sleep(2000);
				  }
				  
				 
	 	}
  }
}