package com.bhiawpkg.Tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.Pages.WPRPage;
import com.bhiawpkg.TestBase.TestBase;

public class ProjectMasterSchedule extends TestBase {
	private static Logger logger=LoggerHelper.getLogger(ProjectMasterSchedule.class);
	WPRPage wpr;
	Config con;
	ProjectPage prpg;
	String Projectname;
 @BeforeMethod
  public void WPR() {
	  LoginPage bhilogin=new LoginPage(driver);
	  
		 con=new Config(pr);
		  bhilogin.Login(con.Getusername(), con.Getpassword());
		 // Thread.sleep(4000);
		  logger.info("--------Login is doing------------");
		  bhilogin.Clickbox();
		  logger.info("==============login is sucessful=========================");	
		  
	 } 

 @Test
 public void Masterschedule_Project() throws IOException, InterruptedException
 {
	 prpg=new ProjectPage(driver);
		prpg.clickProjectsMenu();
		logger.info("-------Clik Project Menu-------");	
		prpg.clickProjectscr();
		logger.info("-------Going to project section-------");	
		 Projectname=prpg.Getgrdpjtname();
		Thread.sleep(2000);
	
	  prpg.clickProjectsMenu();
	  logger.info("==============user click project menu=========================");
	  prpg.clickPjtmasterschedule();
	  Thread.sleep(2000);
	  logger.info("==============user click project master schedule=========================");
	  prpg.selepjtmstrschedule(Projectname);//con.Getactionproject()
	  Thread.sleep(2000);
	  logger.info("==============user select project master schedule=========================");
	  prpg.clicksubmitpjtmstrschedule();
	  Thread.sleep(2000);
	  logger.info("==============user click submit project master schedule=========================");
	  String pjtname= Projectname.toUpperCase();//con.Getactionproject()
	  //String pjtname=con.Getactionproject();
	  //pjtname.toUpperCase();
	  Thread.sleep(2000);
	 // String mstrschedule=driver.findElement(By.xpath("//*[@id='parent']//table//thead//th[text()="+pjtname+"]")).getText();
	  String mstrschedule=driver.findElement(By.xpath("//*[@id='parent']//table//thead//tr[1]//th[1]")).getText();
	  
	  Thread.sleep(2000);
	  if(mstrschedule.contains(pjtname))
	  {
		  logger.info("==============Project name is displayed, Master schedule is available=========================");
		  Assert.assertTrue(true, "=====Project name is displayed, Master schedule is available=====");
		  Thread.sleep(2000);
	  }
	  else
	  {
		  captureScreen(driver, "Project master Schedule");
		  logger.info("==============Project name is not displayed, Master schedule not available=========================");
		  Assert.assertTrue(false, "=====Project name is not displayed, Master schedule not available=====");
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
