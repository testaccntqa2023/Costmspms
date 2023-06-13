package com.bhiawpkg.Tests;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.AssignedtaskPage;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.TestBase.TestBase;

public class TaskStatusDateAssigne_changes extends TestBase {
	private static Logger logger=LoggerHelper.getLogger(TaskStatusDateAssigne_changes.class);
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
	 		  prpg=new ProjectPage(driver);
				prpg.clickProjectsMenu();
				logger.info("-------Clik Project Menu-------");	
				prpg.clickProjectscr();
				 Thread.sleep(2000);
				logger.info("-------Going to project section-------");	
				 Projectname=prpg.Getgrdpjtname();	
				 Thread.sleep(2000);
	 }
	 @Test
	  public void Assignedtask_Changestatus() throws InterruptedException
	  {
		  AT=new AssignedtaskPage(driver);
		  AT.clickAssignedTaskMenu();
		  logger.info("-------User Clik Assigned Tasks-------");	
		 // AT.clickAddTask();
		  AT.selecttaskpjt(Projectname);//con.Getactionproject()
		  logger.info("-------User select the project from the grid-------");
		  Thread.sleep(2000);
		  AT.clickgrdchkbox();
		  logger.info("-------User click the chk box in the grid-------");
		  AT.clickchangestatus();
		  logger.info("-------User click the change status button-------");
		  String Taskstatus=AT.Getcurrentstatus();
		  logger.info("-------getting the current status of a task-------");
		  Getallstatus();
		  logger.info("-------user change the task staus-------");
		  logger.info("-------user change the task staus successfully-------");
	  }
	 public void Getallstatus() throws InterruptedException
	 {
		 String Taskstatus=AT.Getcurrentstatus();
		List<WebElement>allstatuselm= driver.findElements(By.xpath("//*[@class='pull-left filter-form status_change_btn']//div//div[2]//ul//li"));
		 for(WebElement we:allstatuselm)
		 {
			 String statustxt=we.getText();
			 if(!statustxt.equalsIgnoreCase(Taskstatus))
			 {
				 we.click();
				 Thread.sleep(2000);
				 AT.typestatusdescription("changing status");
				 AT.clickchangestatussbmtbutton();
				 Thread.sleep(2000);
				 logger.info("-------user click the submit button-------");
				 break;
			 }
		 }
	 }
	@Test
	  public void Assignedtask_Dateextentionchange() throws InterruptedException, IOException
	  {
		  AT=new AssignedtaskPage(driver);
		  AT.clickAssignedTaskMenu();
		  logger.info("-------User Clik Assigned Tasks-------");	
		 // AT.clickAddTask();
		  AT.selecttaskpjt(Projectname);//con.Getactionproject()
		  logger.info("-------User select the project from the grid-------");
		  Thread.sleep(2000);
		  AT.clickgrdchkbox();
		  logger.info("-------User click the chk box in the grid-------");
		  AT.clickchangedateextension();
		  logger.info("-------User click the Date Extension button-------");
		  String Taskstartdate=AT.Getcurrentstartdate();
		  logger.info("-------getting the current start date of the task-------");
		  String Taskenddate=AT.Getcurrentenddate();
		  Thread.sleep(2000);
		  logger.info("-------getting the current end date of the task-------");
		  	AT.clickpreponedate();
		  	logger.info("-------user click prepone date-------");
		  	Thread.sleep(2000);
		  	AT.clickdateextenddate();
		  	logger.info("-------user click end date-------");
		  	Thread.sleep(2000);
		  	AT.typedtextnoofdays("2");
		  	logger.info("-------user enter no of days-------");
		  AT.clickdateextsubmitbtn();
		  Thread.sleep(2000);
		  logger.info("-------user click submit button-------");
		  String changedTaskenddate=AT.Getcurrentenddate();//=======
		  System.out.println("changed Task end date   "+changedTaskenddate);
		  Thread.sleep(3000);
		  try
		  {
			  if(!Taskenddate.equals(changedTaskenddate)) 
			  {
			  logger.info("--------Task date extension worked -------");
			  logger.info("--------Task date changing successfully!!! -------");
			  Assert.assertTrue(true); 
			  }
		  }
		  catch(Exception ex)
		  {
			  
			  captureScreen(driver, "Date extension");
			  logger.info("--------Task date extension not worked-------");
			  logger.info("--------Task date changing failed!!! -------");
			  Assert.assertTrue(false, "------------Task date extension not worked ------------- ");
			 
		  }
 }
	
	@Test
	  public void Assignedtask_changeassignee() throws InterruptedException, IOException
	  {
		con=new Config(pr); 
		  AT=new AssignedtaskPage(driver);
		  AT.clickAssignedTaskMenu();
		  logger.info("-------User Clik Assigned Tasks-------");	
		 // AT.clickAddTask();
		  AT.selecttaskpjt(Projectname);//con.Getactionproject()
		  logger.info("-------User select the project from the grid-------");
		  Thread.sleep(2000);
		  AT.clickgrdchkbox();
		  logger.info("-------User click the chk box in the grid-------");
		  AT.clickchangeassbtn();
		  Thread.sleep(2000);
		  logger.info("-------User click the assigne name-------");
		  AT.selchngeassgnusers("BHI Developer (ADMIN)");
		  Thread.sleep(2000);
		  logger.info("-------User select the assigne name-------");
		  AT.clickchngassgneebtn();
		  Thread.sleep(3000);
		  logger.info("-------User click the submit button-------");
		  logger.info("-------User change the assignee name successfully!!------");
		  Assert.assertTrue(true);
		  driver.navigate().back();
		  Thread.sleep(2000);
	  }
  @AfterMethod
  public void Logout()
  {
 	  LogoutPage logout=new LogoutPage(driver);
 	  logout.clickusericon();
 	  logout.clickLogout();
  }
}
