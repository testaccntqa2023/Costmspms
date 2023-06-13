package com.bhiawpkg.Tests;

import java.awt.AWTException;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
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

/**
 * @author divya
 *
 */
public class DeleteAssignedTaskTest  extends TestBase{
	private static Logger logger=LoggerHelper.getLogger(AssignedTaskTest.class);
	ProjectPage prpg;
	 AssignedtaskPage AT;
	 LoginPage  bhilogin;
	 Config  con;
		
@BeforeMethod 
public void Login() 
{
			con=new Config(pr); 
			bhilogin=new LoginPage(driver);
		    bhilogin.Login(con.Getusername(),con.Getpassword()); 
		   logger.info("--------Login is doing------------");
		  // bhilogin.Clickbox();
		   logger.info("==============login is sucessful=========================");
		  // logger.info("******************************Task CREATION SECTION*******************************");
		  
}
  @Test
  public void DeleteAssignedTask() throws InterruptedException, AWTException {
	  
	  prpg=new ProjectPage(driver);
		prpg.clickProjectsMenu();
		logger.info("-------Clik Project Menu-------");	
		con=new Config(pr);
		  String pjtname= con.Getactionproject();
		 impliciteWait(30);
		logger.info("-----Getting the project name-------");
		 AT=new AssignedtaskPage(driver);
		  AT.clickAssignedTaskMenu();
		 impliciteWait(30);
		  logger.info("-------User Clik Assigned Tasks-------");
		  AT.selpjtfrmgrd(pjtname);
		 impliciteWait(30);
		  logger.info("--------user select the project from the table dropdown----------");
		 AT.ClickDeleteTask(); 
		impliciteWait(30);
		 logger.info("---------user click delete button-----------------");
  }
  @AfterMethod
  public void Verifysuccessful(ITestResult result) throws IOException, InterruptedException
  {
	   
		LogoutPage logout=new LogoutPage(driver);
		logout.clickusericon();
		Thread.sleep(2000);
		logout.clickLogout();
		Thread.sleep(2000);
		
  }
}
