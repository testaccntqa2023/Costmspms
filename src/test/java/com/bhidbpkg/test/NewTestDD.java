package com.bhidbpkg.test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BHIAW.Helper.JavascriptHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.TestBase.TestBase;
import com.bhiawpkg.Utility.XLUTILS;

public class NewTestDD extends TestBase {
	private static Logger logger=LoggerHelper.getLogger(NewTestDD.class);
	ProjectPage prpg;
	Config con;
	
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
	
	@Test(dataProvider ="ProjectDetails")
	  public void ProjectCreation(String Projectname,String Clientname,String Billable,String Status,String PjtstartDate, String PjtendDate,String Budget,String TotalSquareFeet,
			  String AssignedPjtmanagers,String Description,String milestonetitle,String milestonepjt,String PjtMstartDate,String PjtMendDate,
			  String taskpjt,String tasktitle,String taskmilestone,String TaskstartDate, String TaskendDate, String Areatitle,String AreaPjt,String Areastatus,String WorkTypepjt,String Worktype1,String Worktyperank,
			  String sitename,String sitepjt,String sitelattitude,String sitelongitude,String assignedsiteusers,String punchinradius) throws InterruptedException, IOException, FindFailed 
	  {
		  JavascriptHelper jspjt=new JavascriptHelper(driver);
		 // LoginPage bhilogin=new LoginPage(driver);
			 
			// con=new Config(pr);
			//  bhilogin.Login(con.Getusername(), con.Getpassword());
			 // Thread.sleep(4000);
			 // logger.info("--------Login is doing------------");
			  //bhilogin.Clickbox();
		  		//logger.info("==============login is sucessful=========================");	
		  		logger.info("******************************PROJECT CREATION SECTION**********************************");
				 prpg=new ProjectPage(driver);
				prpg.clickProjectsMenu();
				logger.info("-------Clik Project Menu-------");	
				prpg.clickProjectscr();
				logger.info("-------Going to project section-------");	
				prpg.clickAddproject();
				logger.info("-------Click Add Project-------");	
				prpg.typeprojectname(Projectname);
				logger.info("-------Entered Project name-------");	
				prpg.selectclient(Clientname);
				logger.info("-------Client selected-------");	
				prpg.selectbillable();
				logger.info("-------Billable yes/No selected-------");
				prpg.selectStaus();
				logger.info("-------Stauts is selected-------");
				prpg.clickstartdatepicker();
				logger.info("-------Project Start Date picker is clicked-------");
				//driver.findElement(By.id("Projects_start_date")).clear();
				//driver.findElement(By.id("Projects_start_date")).sendKeys(PjtstartDate);
				prpg.selectpjtstrtdate1();
				prpg.clickenddatepicker();
				logger.info("-------Project End Date picker is clicked-------");
				prpg.selectpjtenddate1();
				logger.info("-------Project End Date is selected-------");
				prpg.typeprojectbudget(Budget);
				logger.info("-------Project budget entered-------");
				prpg.typeprojectsquarefeet(TotalSquareFeet);
				logger.info("-------Project squarefeet entered-------");
				prpg.clickpjtimg();
				Thread.sleep(2000);
				logger.info("-------user click project image-------");
				prpg.callupload(con.Getphotopunchpath());
				Thread.sleep(3000);
				logger.info("-------user click project image-------");
				prpg.clickpjtrptimg();
				Thread.sleep(2000);
				//prpg.selectProjetimage();
				
				prpg.callupload(con.Getphotopunchpath());
				logger.info("-------user click project image-------");
				Thread.sleep(4000);
				prpg.assignedpjtmanagers(AssignedPjtmanagers);
				logger.info("-------Assigned Project manager-------");
				prpg.typeprojectdescription(Description);
				logger.info("-------User entering description-------");
				prpg.clickSaveproject();
				Thread.sleep(3000);
				logger.info("-------User click save and add project-------");
				jspjt.scrollUpByPixel();
				//driver.navigate().to(driver.getCurrentUrl());
				 Verifysuccessfull();
				Thread.sleep(2000);
// **********************************Milestone details*********************************************************//
				
				prpg.clickMilestone();
			    logger.info("-------User clicked milestonedetails------------------");
			    prpg.typemilestonetittle(milestonetitle);
			    logger.info("-------User entered milestone title------------------");
			    Thread.sleep(1000);
			    prpg.selectmilestoneproject(milestonepjt);
			   
			    logger.info("-------User select project------------------");
			    prpg.clickmilestonestartdate();
				logger.info("-------Milestone Start Date picker is clicked-------");
				prpg.selectmilestonestartdate1();
				logger.info("-------Milestone Start Date is selected-------");
				prpg.clickmilestoneenddate();
				logger.info("-------Milestone End Date picker is clicked-------");
				//prpg.selectmilestoneenddate(PjtMendExDay, PjtMendExMonth, PjtMendExYear);
				prpg.selectmilestoneenddate1();
				logger.info("-------Milestone End Date is selected-------");
				prpg.typemilestoneranking(1);
				logger.info("-------Milestone ranking entered-------");
				prpg.selectmilestonestatus("Enable");
				logger.info("-------Milestone status is selected-------");	
				prpg.clickSavetmilestone();
				logger.info("-------Milestone details saved!!-------");	
				Thread.sleep(2000);
				driver.navigate().refresh();
				jspjt.scrollUpByPixel();
				 Verifysuccessfull();
				Thread.sleep(2000);
// **********************************Main task details***************************************************//
				
				//driver.navigate().refresh();
				
				prpg.clickmaintasktab();
				
			    logger.info("-------User clicked maintask------------------");
			    Thread.sleep(2000);
			    prpg.selecttaskpjt(taskpjt);
			    logger.info("-------------------selected task project---------------------");
			    Thread.sleep(2000);
			   prpg.typetasktitle(tasktitle);
			   logger.info("-------------------Typed task title---------------------");
			  prpg.selecttaskmilestone(taskmilestone);
			  logger.info("-------------------selected task milestone---------------------");
			  Thread.sleep(2000);
			  prpg.clicktaskstartdate();
			  logger.info("-------------------user clicked task start date---------------------");
			  prpg.selecttaskstartdate1();
			  logger.info("-------------------user selected task start date---------------------");
			  Thread.sleep(2000);
			  prpg.clicktaskenddate();
			  logger.info("-------------------user clicked task end date---------------------");
			  prpg.selecttaskenddate1();
			  logger.info("-------------------user selected task end date---------------------");
			  Thread.sleep(2000);
			  prpg.typetaskranking(1);
			  logger.info("-------------------user entered task ranking---------------------");
			  prpg.clicksavetask();
			  logger.info("-------------------user saved main task details ---------------------");
			  Verifysuccessfull();
			   Thread.sleep(3000);
//***********************************************Area Details*********************************************

			   driver.navigate().refresh();
			   jspjt.scrollUpByPixel();
				  prpg.clickareatab();
				  logger.info("-------User clicked area details tab ------------------");
				   prpg.typeareatitle(Areatitle);
				  logger.info("-------User type area title ------------------");  
				  prpg.selectareaproject(AreaPjt);
				  logger.info("-------User selected area project ------------------");  
				  prpg.selectareastatus(Areastatus);
				  logger.info("-------User select area status ------------------");  
				  prpg.clicksavearea();
				  logger.info("-------User saved area details ------------------"); 
				  Verifysuccessfull();
				  Thread.sleep(2000);
//***********************************************Work Type  Details*********************************************

				 driver.navigate().to(driver.getCurrentUrl());
				  prpg.clickworktypetab();
				  Thread.sleep(2000);
				  logger.info("-------User clicked work type details tab ------------------");  
				  prpg.selectworktypeproject(WorkTypepjt);
				  Thread.sleep(1000);
				  logger.info("-------User selected work type project ------------------"); 
				  prpg.selectworktype(Worktype1);
				  Thread.sleep(1000);
				  logger.info("-------User selected work type ------------------");  
				  prpg.typeworktyperanking(Worktyperank);
				  logger.info("-------User entered work type ranking ------------------"); 
				  prpg.clicksaveworktype();
				  logger.info("-------User entered work type ranking ------------------"); 
				  Thread.sleep(2000);
				  Verifysuccessfull();
//***********************************************Site  Details*********************************************/
				  driver.navigate().to(driver.getCurrentUrl());
				  prpg.clickworksitetab();
				   logger.info("-------User clicked work site details tab ------------------"); 
				  prpg.typesitename(sitename);
				  logger.info("-------User entered work site  ------------------"); 
				   prpg.selectsiteproject(sitepjt);
				   Thread.sleep(2000);
				   logger.info("-------User select pjt ------------------"); 
				  prpg.typelattitude(sitelattitude);
				  logger.info("-------User entered lattitude ------------------"); 
				  Thread.sleep(2000);
				   prpg.typelongitude(sitelongitude);
				   logger.info("-------User entered longitude  ------------------"); 
				   Thread.sleep(2000);
				  prpg.assignedsiteusers(assignedsiteusers);
				  logger.info("-------User entered site engineers ------------------"); 
				  Thread.sleep(2000);
				   prpg.typepunchingradius( punchinradius);
				   logger.info("-------User entered punching radius  ------------------"); 
					 prpg.clicksavesitedetails();
					 Thread.sleep(2000);
					 logger.info("-------User click save and add site  ------------------"); 
					 Thread.sleep(3000); 
					  Verifysuccessfull();
					  Thread.sleep(2000);
					  logger.info("===============================Project created successfully==========="); 
  }
  
  @DataProvider(name="ProjectDetails")
  public Object[][] getProjectDetails() throws InvalidFormatException, IOException
  {
	  String path=System.getProperty("user.dir")+ "/src/test/java/com/bhiawpkg/Testdata/ashlypmsdata.xlsx";
	  logger.info("file is getting!!!!!");
		  int rowcnt=XLUTILS.getrowcount(path, "Projectdetails");
		  int colcnt=XLUTILS.getcellcount(path, "Projectdetails",1);
		  Object [][]Projectdetails=new Object[rowcnt][colcnt];
		  for(int i=1;i<=rowcnt;i++)
		   {
			  for(int j=0;j<colcnt;j++)
			  {
				  Projectdetails[i-1][j]=XLUTILS.getCellData(path, "Projectdetails", i, j);
			  }
		  }
		  logger.info("Excel data is returned");
		  return Projectdetails;
  }
  public void Verifysuccessfull() throws IOException, InterruptedException
  {
	  boolean status=prpg.verifysuccessfull();
	  Thread.sleep(2000);
	  if(status==true)
  	{
  		logger.info("-----------------successfully -----------------------");
  		Assert.assertTrue(true);
  		
  	}
  	else
  	{
  		captureScreen(driver, "Project Creation");
  		logger.info("-----------------Data creation failed -----------------------");
  		Assert.assertTrue(false,"---------------Data creation failed----------------------");
  	}
  }
  @AfterMethod
  public void Logout() throws InterruptedException
  {
	  Thread.sleep(2000);
 	  LogoutPage logout=new LogoutPage(driver);
 	  logout.clickusericon();
 	  logout.clickLogout();
  }
}
