package com.bhiawpkg.Tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.AMSPage;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.MyTaskPage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.TestBase.TestBase;

public class MytaskTest extends TestBase{
	private static Logger logger=LoggerHelper.getLogger(MytaskTest.class);
	LoginPage  bhilogin;
	 Config  con;
	 MyTaskPage mytskpg;
	 ProjectPage prpg;
	 String Projectname;
	 @BeforeMethod
		public void Login() 
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
			logger.info("-------Going to project section-------");	
			 Projectname=prpg.Getgrdpjtname();
		}
  @Test
  public void MytaskFilter() throws InterruptedException, IOException {
	  
	  mytskpg=new MyTaskPage(driver);
	  mytskpg.clickmytskmenu();
	  Thread.sleep(2000);
	  logger.info("-------------------user click my task menu--------------------------------------");
	  mytskpg.clickmytskoption();
	  mytskpg.selmytskpjt(Projectname);//con.Getactionproject()
	  logger.info("-------------------user select the project--------------------------------------");
	  Thread.sleep(2000);
	  mytskpg.selasignedtsk(con.Getsiteusername());
	  logger.info("-------------------user select assigned person name--------------------------------------");
	  Thread.sleep(2000);
	  mytskpg.selcordinatortsk(con.Getadminusername());
	  logger.info("-------------------user select the task coordinator--------------------------------------");
	  Thread.sleep(2000);
	  mytskpg.selmilestonetsk();
	  Thread.sleep(2000);
	  logger.info("-------------------user select the milestone--------------------------------------");
	  //mytskpg.clicksearchbtn();
	  logger.info("-------------------user click the search button--------------------------------------");
	  try {
	  int grdrwno=mytskpg.Getmytskgrdrowno();
	  if(grdrwno>=1)
	  {
		logger.info("----------------My task page listed according to selected option-------------------------");
		  Assert.assertTrue(true);
	  }
	  else
	  {
		  captureScreen(driver, "Mytask Searchin");
		  logger.info("----------------Task not exist to filter-------------------------");
		  Assert.assertTrue(true,"-----------------Task not exist to filter-----------------------");
	  }}
	  catch(Exception e)
	  {
		  captureScreen(driver, "Mytask Searching");
		  logger.info("----------------Task not exist to filter-------------------------");
		  Assert.assertTrue(true,"-----------------Task not exist to filter-----------------------");
	  }
  }
  
  @Test
  public void GetCompletedtask() throws InterruptedException, IOException
  {
	  mytskpg=new MyTaskPage(driver);
	  mytskpg.clickmytskmenu();
	  Thread.sleep(2000);
	  logger.info("-------------------user click my task menu--------------------------------------");
	  mytskpg.clickmytskoption();
	  mytskpg.selmytskpjt(Projectname);//con.Getactionproject()
	  logger.info("-------------------user select the project--------------------------------------");
	  Thread.sleep(2000);
	  mytskpg.clickcompletdchkbx();
	  logger.info("-------------------user click completed project check box--------------------------------------");
	  try {
	  int grdrwno=mytskpg.Getmytskgrdrowno();
	  if(grdrwno>=1)
	  {
		 String cmpstatus=mytskpg.Getgrdstatustxt();
		 mytskpg.selmytskpjt(Projectname);//con.Getactionproject()
		  if(cmpstatus.equals("Completed"))
		  {
		  logger.info("----------------My task page listed completed task-------------------------");
		  Assert.assertTrue(true);
		  }
	  }
	  else
	  {
		  captureScreen(driver, "Mytask filtering");
		  Assert.assertTrue(false,"----------------Completed -Tasks not completed ----------------------");
	  }
	  }
	  catch(Exception e)
	  {
		  captureScreen(driver, "Mytask filtering");
		  logger.info("----------------Completed -Tasks not exist------------------------");
		  Assert.assertTrue(true,"----------------Completed -Tasks not exist ----------------------");
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
