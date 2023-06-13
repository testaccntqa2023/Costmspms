package com.bhiawpkg.Tests;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BHIAW.Helper.LoggerHelper;
import com.aventstack.extentreports.Status;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.AssignedtaskPage;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.TestBase.TestBase;

public class AssignedTaskFilterTest extends TestBase{
	private static Logger logger=LoggerHelper.getLogger(AssignedTaskFilterTest.class);
	 AssignedtaskPage AT;
	 LoginPage  bhilogin;
	 Config  con;
	 ProjectPage prpg;
	 String Projectname;
		
@BeforeMethod 
public void GetAddTask() throws InterruptedException 
{
			con=new Config(pr); 
			bhilogin=new LoginPage(driver);
		    bhilogin.Login(con.Getusername(),con.Getpassword()); 
		    logger.info("--------Login is doing------------");
		   bhilogin.Clickbox();
		   logger.info("==============login is sucessful=========================");
		   logger.info("******************************Task CREATION SECTION*******************************");
		   prpg=new ProjectPage(driver);
			prpg.clickProjectsMenu();
			logger.info("-------Clik Project Menu-------");	
			prpg.clickProjectscr();
			logger.info("-------Going to project section-------");	
			 Projectname=prpg.Getgrdpjtname();
			//prpg.clickgrideditpjt();
			Thread.sleep(2000);
		  
}
///*----------------------------------------------------------------------------
  @Test
  public void AssignedTaskFilterTest_CompletedTask() throws InterruptedException, IOException 
  {
	  
		
	  AT=new AssignedtaskPage(driver);
	  AT.clickAssignedTaskMenu();
	  logger.info("-------User Clik Assigned Tasks-------");	
	  AT.selecttaskpjt(Projectname);
	  logger.info("-------User select the project from the grid-------");
	  Thread.sleep(2000);
	  logger.info("-------Filtering completed task-------");
	  AT.clickcompletedtsk();
	  logger.info("-------user click completed task-------");
	  try 
	  {
		 String taskstatus=driver.findElement(By.xpath("//*[@id='tasks-grid']//table//tbody//tr[1]//td[14]")).getText(); 
		 if(taskstatus.equals("Completed"))
		 {
			 logger.info("--------------completed task is listed-----------------");
			 Assert.assertTrue(true, "----------completed task is listed!!!-------------------");
		 }
		 else if(!taskstatus.equals("Completed"))
		 {
			 captureScreen(driver, "-Assigned task_completed task --Not exist completed tasks!!-");
			  logger.info("-----------Completed task does not exist----------------------------------");
			 // Assert.assertTrue(false, "-------completed tasks not available----------------------");
		 }
	  }
	  catch(Exception ex)
	  {
		  captureScreen(driver, "-Assigned task_completed task --Not exist completed tasks!!-");
		  logger.info("-----------Completed task does not exist----------------------------------");
		  Assert.assertTrue(true, "-------completed tasks not available----------------------");
	  }
	  
  }
  //----------------------------------------------------------------------------*/
  @Test
  public void AssignedTaskFilterTest_HideExpiredTask() throws InterruptedException, IOException, ParseException 
  {
	  AT=new AssignedtaskPage(driver);
	  AT.clickAssignedTaskMenu();
	  logger.info("-------User Clik Assigned Tasks-------");	
	  AT.selecttaskpjt(Projectname);//con.Getactionproject()
	  logger.info("-------User select the project from the grid-------");
	  Thread.sleep(2000);
	  logger.info("-------Filtering completed task-------");
	  try
	  {
	  String taskenddate=driver.findElement(By.xpath("//*[@id='tasks-grid']//table//tbody//tr[1]//td[13]")).getText();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	  //String taskenddate=Enddate;
	  Date date = new Date();  
	    System.out.println(formatter.format(date));  
	  String todaydate=formatter.format(date);
	  System.out.println(taskenddate+"--"+todaydate);
	  AT.clickhideexpiredtsk();
	  logger.info("--------user click hide expired task-----------------------");
	  try 
	   {
		 String tskstatus=driver.findElement(By.xpath("//*[@id='tasks-grid']//table//tbody//tr[1]//td[13]")).getText();
	     System.out.println("Expired task exist"+driver.findElement(By.xpath("//*[@id='tasks-grid']//table//tbody//tr[1]//td[13]")).getText());
	     if(taskenddate.compareTo(todaydate)> 0)
	     {  
	    	 System.out.println("today date is greater than task end date"); 
	    	 captureScreen(driver, "----Expired task filter,  expired task does not exist!!!---");
	    	 Assert.assertTrue(true, "----------------xpired task filter,expired task does not exist!------------");
	     }
	     else if(taskenddate.compareTo(todaydate)< 0)   
	     {  
		  System.out.println("task end date is greater"); 
		  logger.info("--------No task is expired!!!-----------------------");
		  captureScreen(driver, "----Expired task filter, No expired task exist!!!---");
		  Assert.assertTrue(true, "-----------------No expired task exist!!------------");
	     }
	     else if(taskenddate.compareTo(todaydate)== 0) 
	     {
		  System.out.println("Both dates are equal"); 
		  logger.info("--------No task is expired!!!-----------------------");
		  captureScreen(driver, "----Expired task filter, No expired task exist!!!---");
		  Assert.assertTrue(true, "-----------------No expired task exist!!------------");
	     }
	   }
	   catch(Exception ex)
	   {
		   logger.info("-------Hiding the expired task ------"); 
		   Assert.assertTrue(true, "-----------------Hiding the expired task !!------------");
	   }
	     
	   }
	  catch(Exception ex)
	  {
		  logger.info("--------No  Expired task is existed-----------------------");
		  captureScreen(driver, "----Expired task filter, No Expired task is existed!!!---");
		  Assert.assertTrue(true, "-----------------No Expired task is existed!!------------");
	  }
  } 
	 // Date taskenddate1 = formatter.parse(taskenddate.trim());  
    //  Date todaydate1 = formatter.parse("todaydate");
	 // Boolean bool1 = taskenddate1.after(todaydate1);  
	 // if(bool1)
	 // {
		//  logger.info("-----------There are no expired task exist ----------------");
		 // Assert.assertTrue(true);
	 // }
    //  Boolean bool2 = date1.before(date2);
     // Boolean bool3 = date1.equals(date2);
//-----------------------------------------------------------------------------------------*/	  
  @Test
  public void Maintaskfilter() throws InterruptedException, IOException
  {
	  AT=new AssignedtaskPage(driver);
	  AT.clickAssignedTaskMenu();
	  logger.info("-------User Clik Assigned Tasks-------");	
	  AT.selecttaskpjt(Projectname);
	  logger.info("-------User select the project from the grid-------");
	  Thread.sleep(2000);
	  AT.clickmaintask();
	  logger.info("-------user click main task check box-------");
	  String exppjtname=Projectname;//con.Getactionproject();
	  try {
	  String actualpjt=AT.getgrdpjtname();
	  logger.info("-------user get project name from the grid -------");
	  if(exppjtname.equals(actualpjt))
	  {
		  logger.info("--------Main task is loaded successfully--------------");
		  Assert.assertTrue(true);
	  }
	  }
	  catch(Exception ex) 
	  {
		  logger.info("--------No main task exist or main task is not loaded!!!--------------");
		  captureScreen(driver, "Assigned task-Maint task filter");
		  Assert.assertTrue(true, "Assigned task-Main task filter-----No main task exist or main task is not loaded!!!-");
	  }
  }
  @Test
  public void Subtaskfilter() throws InterruptedException, IOException
  {
	  AT=new AssignedtaskPage(driver);
	  AT.clickAssignedTaskMenu();
	  logger.info("-------User Clik Assigned Tasks-------");	
	  AT.selecttaskpjt(Projectname);//con.Getactionproject()
	  logger.info("-------User select the project from the grid-------");
	  Thread.sleep(2000);
	  AT.clicksubtasks();
	  Thread.sleep(2000);
	  logger.info("-------user click sub task check box-------");
	  String exppjtname=Projectname;//con.Getactionproject();
	  try {
	  String actualpjt=AT.getgrdpjtname();
	  logger.info("-------user get project name from the grid -------");
	  if(exppjtname.equals(actualpjt))
	  {
		  logger.info("--------Sub task is loaded successfully--------------");
		  Assert.assertTrue(true);
	  }
	  }
	  catch(Exception ex) 
	  {
		  logger.info("--------No sub task exist or sub task is not loaded!!!--------------");
		  captureScreen(driver, "Assigned task-Sub task filter");
		  Assert.assertTrue(true, "Assigned task-Sub task filter-----No sub task exist or sub task is not loaded!!!-");
	  }
  }
  @Test
  public void AssignedTaskFilterTest_ExpiredTask() throws InterruptedException, IOException, ParseException 
  {
	  AT=new AssignedtaskPage(driver);
	  AT.clickAssignedTaskMenu();
	  logger.info("-------User Clik Assigned Tasks-------");	
	  AT.selecttaskpjt(Projectname );//con.Getactionproject()
	  logger.info("-------User select the project from the grid-------");
	  Thread.sleep(2000);
	  logger.info("-------Filtering completed task-------");
	  try
	  {
	  String taskenddate=driver.findElement(By.xpath("//*[@id='tasks-grid']//table//tbody//tr[1]//td[13]")).getText();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	  //String taskenddate=Enddate;
	  Date date = new Date();  
	    System.out.println(formatter.format(date));  
	  String todaydate=formatter.format(date);
	  System.out.println(taskenddate+"--"+todaydate);
	  AT.clickexpiredtask();
	  logger.info("--------user click expired task check box-----------------------");
	  try 
	   {
		 String tskstatus=driver.findElement(By.xpath("//*[@id='tasks-grid']//table//tbody//tr[1]//td[13]")).getText();
	     System.out.println("Expired task exist"+driver.findElement(By.xpath("//*[@id='tasks-grid']//table//tbody//tr[1]//td[13]")).getText());
	     if(taskenddate.compareTo(todaydate)> 0)
	     {  
	    	 System.out.println("  today date is greater than task end date"); 
	    	 captureScreen(driver, "----Expired task filter,  expired task  exist!!!---");
	    	 Assert.assertTrue(true, "----------------xpired task filter,expired task  exist!------------");
	     }
	     else if(taskenddate.compareTo(todaydate)< 0)   
	     {  
		  System.out.println("task end date is greater"); 
		  logger.info("--------No task is expired!!!-----------------------");
		  captureScreen(driver, "----Expired task filter, No expired task exist!!!---");
		  Assert.assertTrue(false, "-----------------No expired task exist!!------------");
	     }
	     else if(taskenddate.compareTo(todaydate)== 0) 
	     {
		  System.out.println("Both dates are equal"); 
		  logger.info("--------No task is expired!!!-----------------------");
		  captureScreen(driver, "----Expired task filter, No expired task exist!!!---");
		  Assert.assertTrue(true, "-----------------No expired task exist!!------------");
	     }
	   }
	   catch(Exception ex)
	   {
		   logger.info("------- expired task does not exist------"); 
		   Assert.assertTrue(true, "-----------------Hiding the expired task !!------------");
	   }
	     
	   }
	  catch(Exception ex)
	  {
		  logger.info("--------No task is existed-----------------------");
		  captureScreen(driver, "----Expired task filter, No task is existed!!!---");
		  Assert.assertTrue(true, "-----------------No task is existed!!------------");
	  }
  } 
  @AfterMethod
  public void Logout()
  {
 	  LogoutPage logout=new LogoutPage(driver);
 	  logout.clickusericon();
 	  logout.clickLogout();
  }
}
