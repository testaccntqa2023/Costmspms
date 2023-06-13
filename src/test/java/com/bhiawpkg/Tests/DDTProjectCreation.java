package com.bhiawpkg.Tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BHIAW.Helper.JavascriptHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.TestBase.TestBase;
import com.bhiawpkg.Utility.XLUTILS;

public class DDTProjectCreation extends TestBase {
	private static Logger logger=LoggerHelper.getLogger(Project_CreationTest.class);
	
	  @Test(dataProvider ="ProjectDetails")
	  public void ProjectCreation(String Projectname,String Clientname,String Billable,String Status,String PjtstartExDay,String PjtstartExMonth, String PjtstartExYear, String PjtendExDay,String PjtendExMonth, String PjtendExYear,String Budget,String TotalSquareFeet,
			  String AssignedPjtmanagers,String Description,String milestonetitle,String milestonepjt,String PjtMstartExDay,String PjtMstartExMonth,String PjtMstartExYear,String PjtMendExDay,String PjtMendExMonth,String PjtMendExYear,
			  String taskpjt,String tasktitle,String taskmilestone,String TaskstartExDay,String TaskstartExMonth, String TaskstartExYear, String TaskendExDay,String TaskendExMonth, String TaskendExYear,
			  String Areatitle,String AreaPjt,String Areastatus,String WorkTypepjt,String Worktype1,String Worktyperank,
			  String sitename,String sitepjt,String sitelattitude,String sitelongitude,String assignedsiteusers,String punchinradius) throws InterruptedException, IOException, FindFailed 
	  {
		  JavascriptHelper jspjt=new JavascriptHelper(driver);
		  LoginPage bhilogin=new LoginPage(driver);
			 
			Config con=new Config(pr);
			  bhilogin.Login(con.Getusername(), con.Getpassword());
			  Thread.sleep(4000);
			  logger.info("--------Login is doing------------");
			  bhilogin.Clickbox();
		  		logger.info("==============login is sucessful=========================");	
		  		logger.info("******************************PROJECT CREATION SECTION**********************************");
				ProjectPage prpg=new ProjectPage(driver);
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
				prpg.selectstartdate(PjtstartExDay,PjtstartExMonth, PjtstartExYear);
				logger.info("-------Project Start Date is selected-------");
				prpg.clickenddatepicker();
				logger.info("-------Project End Date picker is clicked-------");
				prpg.selectenddate(PjtendExDay, PjtendExMonth, PjtendExYear);
				logger.info("-------Project End Date is selected-------");
				prpg.typeprojectbudget(Budget);
				logger.info("-------Project budget entered-------");
				prpg.typeprojectsquarefeet(TotalSquareFeet);
				logger.info("-------Project squarefeet entered-------");
				
				//prpg.selectProjetimage();
				Thread.sleep(2000);
				logger.info("-------user click project image-------");
				prpg.assignedpjtmanagers(AssignedPjtmanagers);
				logger.info("-------Assigned Project manager-------");
				prpg.typeprojectdescription(Description);
				logger.info("-------User entering description-------");
				prpg.clickSaveproject();
				Thread.sleep(3000);
				logger.info("-------User click save and add project-------");
				jspjt.scrollUpByPixel();
				//driver.navigate().to(driver.getCurrentUrl());
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
				prpg.selectmilestonestartdate(PjtMstartExDay, PjtMstartExMonth, PjtMstartExYear);
				
				logger.info("-------Milestone Start Date is selected-------");
				prpg.clickmilestoneenddate();
				logger.info("-------Milestone End Date picker is clicked-------");
				prpg.selectmilestoneenddate(PjtMendExDay, PjtMendExMonth, PjtMendExYear);
				logger.info("-------Milestone End Date is selected-------");
				prpg.typemilestoneranking(1);
				logger.info("-------Milestone ranking entered-------");
				prpg.selectmilestonestatus("Enable");
				logger.info("-------Milestone status is selected-------");	
				prpg.clickSavetmilestone();
				logger.info("-------Milestone details saved!!-------");	
				Thread.sleep(2000);
// **********************************Main task details***************************************************//	
				
				jspjt.scrollUpByPixel();
				Thread.sleep(2000);
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
			  prpg.clicktaskstartdate();
			  logger.info("-------------------user clicked task start date---------------------");
			  prpg.selecttaskstartdate(TaskstartExDay, TaskstartExMonth, TaskstartExYear);
			  logger.info("-------------------user selected task start date---------------------");
			  prpg.clicktaskenddate();
			  logger.info("-------------------user clicked task end date---------------------");
			  prpg.selecttaskenddate(TaskendExDay, TaskendExMonth, TaskendExYear);
			  logger.info("-------------------user selected task end date---------------------");
			  prpg.typetaskranking(1);
			  logger.info("-------------------user entered task ranking---------------------");
			  prpg.clicksavetask();
			  logger.info("-------------------user saved main task details ---------------------");
			   Thread.sleep(3000);
//***********************************************Area Details*********************************************//
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
				  Thread.sleep(2000);
//***********************************************Work Type  Details*********************************************//
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
//***********************************************Site  Details*********************************************//
		  
				  prpg.clickworksitetab();
				   logger.info("-------User clicked work site details tab ------------------"); 
				  prpg.typesitename(sitename);
				  logger.info("-------User entered work site  ------------------"); 
				   prpg.selectsiteproject(sitepjt);
				   logger.info("-------User select pjt ------------------"); 
				  prpg.typelattitude(sitelattitude);
				  logger.info("-------User entered lattitude ------------------"); 
				   prpg.typelongitude(sitelongitude);
				   logger.info("-------User entered longitude  ------------------"); 
				  prpg.assignedsiteusers(assignedsiteusers);
				  logger.info("-------User entered site engineers ------------------"); 
				   prpg.typepunchingradius( punchinradius);
				   logger.info("-------User entered punching radius  ------------------"); 
					 prpg.clicksavesitedetails();
					 logger.info("-------User click save and add site  ------------------"); 
					 Thread.sleep(2000); 
		/*		 boolean projectstatus=prpg.verifysuccessfull();
					logger.info("-------Verifying Project_CreationTest  -------");
				//Thread.sleep(2000);
				if(projectstatus==true)
					{
						Assert.assertTrue(true);
					logger.info("********"+Project_CreationTest.class +"  details added successfully!!************");
					logger.info("**********************************************************************************************************");
					}
				else
				{
				captureScreen(driver,"Project_CreationTest");
				 // Assert.assertTrue(false);
				Assert.assertTrue(false, "********Project_CreationTest  details added  failed!!************");
				}*/
			
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
				  Projectdetails[i-i][j]=XLUTILS.getCellData(path, "Projectdetails", i, j);
			  }
		  }
		  logger.info("Excel data is returned");
		  return Projectdetails;
  }
@AfterMethod
  public void Verifysuccessful(ITestResult result) throws IOException, InterruptedException
  {
	  ProjectPage prpg=new ProjectPage(driver);
	  boolean projectstatus=prpg.verifysuccessfull1();
		logger.info("-------Verifying "+result.getName()+ " -------");
		//Thread.sleep(2000);
		if(projectstatus==true)
		{
			Assert.assertTrue(true);
		logger.info("********"+result.getName() +"Milestone,Maintask,Work Type,Site Details   added successfully!!************");
		logger.info("**********************************************************************************************************");
		}
	else
	{
	captureScreen(driver,result.getName());
	 // Assert.assertTrue(false);
	Assert.assertTrue(false, "********"+result.getName() +" Milestone,Maintask,Work Type,Site Details added  failed!!************");
	}
  }
}
