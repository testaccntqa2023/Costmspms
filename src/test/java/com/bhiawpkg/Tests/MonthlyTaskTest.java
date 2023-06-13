package com.bhiawpkg.Tests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.AssignedtaskPage;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.MonthlyTaskPage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.Pages.WPRPage;
import com.bhiawpkg.TestBase.TestBase;

public class MonthlyTaskTest extends TestBase{
	private static Logger logger=LoggerHelper.getLogger(MonthlyTaskTest.class);
	WPRPage wpr;
	Config con;
	ProjectPage prpg;
	MonthlyTaskPage mnthtskpage;
	String Projectname;
 @BeforeMethod
  public void Login() throws InterruptedException {
	  LoginPage bhilogin=new LoginPage(driver);
	   con=new Config(pr);
		  bhilogin.Login(con.Getusername(), con.Getpassword());
		  logger.info("--------Login is doing------------");
		  logger.info("==============login is sucessful=========================");	
		  prpg=new ProjectPage(driver);
			prpg.clickProjectsMenu();
			impliciteWait(30);
			logger.info("-------Clik Project Menu-------");	
			prpg.clickProjectscr();
			impliciteWait(30);
			logger.info("-------Going to project section-------");	
			 Projectname=prpg.Getgrdpjtname();
			impliciteWait(30);
		  
		  logger.info("******************************WPR  SECTION**********************************");
	 } 
  @Test
  public void FilterMonthlyTask() throws InterruptedException {
	  prpg=new ProjectPage(driver);
	  prpg.clickProjectsMenu();
	  logger.info("-------Clik Project Menu-------");
	  prpg.clickProjectscr();
	  logger.info("---click projects menu----");
	  String pjtname=prpg.Getprojectname();
	  impliciteWait(30);
	  prpg.clickgrideditpjt();
		impliciteWait(30);
		prpg.clickworksitetab();
		impliciteWait(30);
		String sitename=prpg.getpjtpunchsite();
		impliciteWait(30);
	   mnthtskpage=new MonthlyTaskPage(driver);
	   mnthtskpage.clickmonthlytsk();
	   impliciteWait(30);
	   logger.info("------click monthly task menu-----");
	   mnthtskpage.selpjtmnthlytskmenu(pjtname);
	   impliciteWait(30);
	   logger.info("-----select project for monthly task-----");
	   mnthtskpage.clickGobtn();
	   logger.info("-----click Go button----");
	   impliciteWait(30);
	   mnthtskpage.clickAddtaskbtn();
	   impliciteWait(30);
	   logger.info("----click add task button----");
	   AssignedtaskPage AT=new AssignedtaskPage(driver);
	   AT.Toframe();	
	   impliciteWait(30);
		  logger.info("-------User switching to frame-------");	
		  impliciteWait(30);
		  AT.selecttaskpjt(Projectname);
		  logger.info("-------User selecting the project-------");	
		  AT.clickExternal();
		  logger.info("-------User click task type external-------");
		   AT.selectmaintask("Painting");
		  logger.info("-------User selecting the main task-------");	
		  AT.typetasktitle("Coding");	
		  logger.info("----------User type the task title---------------");
		  AT.typetskquantity("20");
		  logger.info("----------User type the task quantity---------------");
		/*  try {
			  if(!AT.Gettaskexist().isDisplayed())
			  {*/
				  
			impliciteWait(30);
		  AT.selectunit("Sq Ft");
		  logger.info("----------User type the task quantity---------------");
		  AT.typetaskrate("200");
		  logger.info("----------User type the task rate---------------");
		  AT.typetaskamount("500");
		  logger.info("----------User type the task amount---------------");
		 AT.seltsklocation(sitename);	
		 logger.info("----------User select the task location---------------");
		 AT.seltaskarea("Third floor");
		 logger.info("----------User select the task area---------------");
		 AT.clicktaskstrtdate();
		 logger.info("----------User click  the task start date---------------");
		 //AT.selecttaskstartdate(TaskstartExday, TaskstartExMon, TaskstartExYear);
		 AT.selecttaskstartdate1();
		 logger.info("----------User selected  the task start date---------------");
		 AT.clicktaskenddate();
		 logger.info("----------User click the task end date---------------");
		// AT.selecttaskenddate(TaskendExday, TaskendExMon, TaskendExYear);	
		 AT.selecttaskenddate1();
		 impliciteWait(30);
		 logger.info("----------User select the task end date---------------");
		// AT.typetskduration("29");
		 AT.typetskduration();
		 impliciteWait(30);
		 logger.info("----------User type the task duration---------------");
		 //AT.dailytrgt("20.29");
		 AT.dailytrgt();
		 logger.info("----------User get the task daily target---------------");
		 //AT.seltaskworktype(worktype);//	Electrical works
		 AT.seltaskworktype("Electrical works");
		 impliciteWait(30);
		 logger.info("----------User select the task work type---------------");
		 //AT.typetaskreqworkers("29");
		 AT.typetaskreqworkers();
		 logger.info("----------User get the required workers---------------");
		 AT.typemaxtskworkers("18");
		 logger.info("----------User get the max workers---------------");
		 AT.seltskpriority("Medium");
		 logger.info("----------User select the priority---------------");
		 AT.seltassignedto("dinil");
		 logger.info("----------User select the assigned users ---------------");
		 AT.seltskcoordinator("BHI Developer");
		 logger.info("----------User select the task coordinator ---------------");
		 AT.seltskowner("BHI Developer");
		 logger.info("----------User select the task owner---------------");
		 AT.seltskprogress("In-progress");
		 logger.info("----------User select the current progress ---------------");
		 AT.seltskmilestone("PRODUCTION");
		 logger.info("----------User select the task milestone ---------------");
		 AT.seltskcontractor("Astle");
		 impliciteWait(30);
		 logger.info("----------User select the task contractors ---------------");
		 AT.typeemail("divya.abish1003@gmail.com");
		 logger.info("-------------user enter task email------------------");
		 AT.typetaskdecription("test");	
		 logger.info("-------------user enter task description------------------");
		 impliciteWait(30);
		 
		 AT.clickcreatetskbtn();
		 logger.info("----------User click the create button ---------------");
		 impliciteWait(30);
  }
  @AfterMethod
  public void Logout()
  {
 	  LogoutPage logout=new LogoutPage(driver);
 	  logout.clickusericon();
 	  logout.clickLogout();
  }
 	
}
