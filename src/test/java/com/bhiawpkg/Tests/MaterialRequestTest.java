package com.bhiawpkg.Tests;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BHIAW.Helper.AlertHelper;
import com.BHIAW.Helper.JavascriptHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.AssignedtaskPage;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.MonthlyTaskPage;
import com.bhiawpkg.Pages.MyTaskPage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.Pages.WPRPage;
import com.bhiawpkg.TestBase.TestBase;

public class MaterialRequestTest extends TestBase{
	private static Logger logger=LoggerHelper.getLogger(MaterialRequestTest.class);
	WPRPage wpr;
	Config con;
	ProjectPage prpg;
	MonthlyTaskPage mnthtskpage;
	String Projectname;
	MyTaskPage mytskpg;
	AssignedtaskPage AT;
	JavascriptHelper js;
 @BeforeMethod
  public void Login() throws InterruptedException {
	  LoginPage bhilogin=new LoginPage(driver);
	   con=new Config(pr);
		  bhilogin.Login(con.Getusername(), con.Getpassword());
		  Thread.sleep(4000);
		  logger.info("--------Login is doing------------");
		 bhilogin.Clickbox();
		  logger.info("==============login is sucessful=========================");	
		  js=new JavascriptHelper(driver);
		  js.scrollUpByPixel();
		  Thread.sleep(2000);
		/*  prpg=new ProjectPage(driver);
			prpg.clickProjectsMenu();
			Thread.sleep(2000);
			logger.info("-------Clik Project Menu-------");	
			prpg.clickProjectscr();
			Thread.sleep(2000);
			logger.info("-------Going to project section-------");	
			 Projectname=prpg.Getgrdpjtname();*/
			
		 } 
  
  @Test
  public void MaterialRequest() throws InterruptedException, IOException, AWTException {
	  logger.info("******************************Material Request SECTION**********************************");
	  prpg=new ProjectPage(driver);
	  prpg.clickProjectsMenu();
	  Thread.sleep(2000);
	  logger.info("-------Clik Project Menu-------");
	  prpg.clickProjectscr();
	  Thread.sleep(2000);
	  logger.info("---click projects menu----");
	  String pjtname=prpg.Getprojectname();
	  Thread.sleep(2000);
	  AT=new AssignedtaskPage(driver);
	  AT.clickAssignedTaskMenu();
	  Thread.sleep(2000);
	  logger.info("-------User Clik Assigned Tasks-------");
	  AT.selpjtfrmgrd(pjtname);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
	  Thread.sleep(2000); 
	  AT.ApplymaterialRequest();
	  Thread.sleep(2000); 
	  
}
  /*
  @Test
  public void ApproveMaterialRequest() throws InterruptedException
  {
	  logger.info("******************************Approve Material Request**********************************");
	  prpg=new ProjectPage(driver);
	  prpg.clickProjectsMenu();
	  logger.info("-------Clik Project Menu-------");
	  prpg.clickProjectscr();
	  logger.info("---click projects menu----");
	  String pjtname=prpg.Getprojectname();
	  mytskpg=new MyTaskPage(driver);
	  mytskpg.clickmytskmenu();
	  Thread.sleep(2000);
	  logger.info("-------------------user click my task menu--------------------------------------");
	   logger.info("------click monthly task menu-----");
	   mytskpg.clickmaterialrequest();
	   Thread.sleep(2000);
	   logger.info("------click monthly task menu-----");
	   mytskpg.selpjtfrmtable(pjtname);
	   Thread.sleep(2000);
	   mytskpg.clickapprovebtn();
	   Thread.sleep(2000);
	  AlertHelper alert=new AlertHelper(driver);
	  alert.AcceptAlertIfPresent();
	  Thread.sleep(2000);
  }
  
  @Test
  public void MaterialRequesition() throws InterruptedException
  {
	  
	  
  }
  */
}