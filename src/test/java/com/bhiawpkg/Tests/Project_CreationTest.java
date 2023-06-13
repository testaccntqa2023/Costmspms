package com.bhiawpkg.Tests;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.BHIAW.Helper.LoggerHelper;
import com.applitools.eyes.selenium.Eyes;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.TestBase.TestBase;

public class Project_CreationTest extends TestBase{
	private static Logger loger=LoggerHelper.getLogger(Project_CreationTest.class);
	
  @Test(priority=1)
  public void Project_Creation() throws InterruptedException, IOException {
	  
	LoginPage bhilogin=new LoginPage(driver);
	 
	Config con=new Config(pr);
	Eyes eyes=new Eyes();
	  eyes.setApiKey("agZAt2Duq5CZWqScbVRJ7gDihQY109Hu2oQbU1PkZVI1U110");
	  eyes.checkWindow("Home Page");                                                                                                                                                                                          
	  eyes.open(driver, "Hello","Hello World");
	  bhilogin.Login(con.Getusername(), con.Getpassword());
	  Thread.sleep(4000);
	  loger.info("--------Login is doing------------");
	 
	//  boolean status=bhilogin.verifysuccessfull();
	  	//  if(status==true){
			//Assert.assertTrue(true);                                                                                                                                     
			//Thread.sleep(2000);
	  		bhilogin.Clickbox();
	  		loger.info("==============login is sucessful=========================");	
	  		loger.info("******************************PROJECT CREATION SECTION**********************************");
			ProjectPage prpg=new ProjectPage(driver);
			prpg.clickProjectsMenu();
			loger.info("-------Clik Project Menu-------");	
			prpg.clickProjectscr();
			loger.info("-------Going to project section-------");	
			prpg.clickAddproject();
			loger.info("-------Click Add Project-------");	
			prpg.typeprojectname("PJT47");
			loger.info("-------Entered Project name-------");	
			prpg.selectclient("THCLIENT");
			loger.info("-------Client selected-------");	
			prpg.selectbillable();
			loger.info("-------Billable yes/No selected-------");
			prpg.selectStaus();
			loger.info("-------Stauts is selected-------");
			prpg.clickstartdatepicker();
			loger.info("-------Project Start Date picker is clicked-------");
			prpg.selectstartdate("03", "September", "2021");
			loger.info("-------Project Start Date is selected-------");
			prpg.clickenddatepicker();
			loger.info("-------Project End Date picker is clicked-------");
			prpg.selectenddate("03", "October", "2021");
			loger.info("-------Project End Date is selected-------");
			prpg.typeprojectbudget("22222");
			loger.info("-------Project budget entered-------");
			prpg.typeprojectsquarefeet("5000");
			loger.info("-------Project squarefeet entered-------");
			prpg.assignedpjtmanagers("Divya an (SITE ENGINEER)");
			loger.info("-------Assigned Project manager-------");
			prpg.typeprojectdescription("Located in Ernakulam");
			loger.info("-------User entering description-------");
			prpg.clickSaveproject();
			Thread.sleep(2000);
			loger.info("-------User click save and add project-------");
					
}	 
  @Test(priority=2)
  public void Milestonecreation() throws InterruptedException
  {		
	   	driver.navigate().to(driver.getCurrentUrl());
	    ProjectPage prpg=new ProjectPage(driver);
	    prpg.clickMilestone();
	    loger.info("-------User clicked milestonedetails------------------");
	    prpg.typemilestonetittle("PJT47M");
	    loger.info("-------User entered milestone title------------------");
	    prpg.selectmilestoneproject("PJT47");
	    loger.info("-------User select project------------------");
	    prpg.clickmilestonestartdate();
		loger.info("-------Milestone Start Date picker is clicked-------");
		prpg.selectmilestonestartdate("03", "September", "2021");
		loger.info("-------Milestone Start Date is selected-------");
		prpg.clickmilestoneenddate();
		loger.info("-------Milestone End Date picker is clicked-------");
		prpg.selectmilestoneenddate("03", "October", "2021");
		loger.info("-------Milestone End Date is selected-------");
		prpg.typemilestoneranking(1);
		loger.info("-------Milestone ranking entered-------");
		prpg.selectmilestonestatus("Enable");
		loger.info("-------Milestone status is selected-------");	
		prpg.clickSavetmilestone();
		loger.info("-------Milestone details saved!!-------");	
		Thread.sleep(2000);
		
  }
  
  @Test(priority = 3)
  public void Maintaskadd() throws InterruptedException
  {
	  ProjectPage prpg=new ProjectPage(driver);
	  prpg.clickmaintasktab();
	  loger.info("-------User clicked maintask------------------");
	  prpg.selecttaskpjt("PJT47");
	  loger.info("-------------------selected task project---------------------");
	  Thread.sleep(2000);
	  prpg.typetasktitle("PJT47T");
	  loger.info("-------------------Typed task title---------------------");
	  prpg.selecttaskmilestone("PJT47M");
	  loger.info("-------------------selected task milestone---------------------");
	  prpg.clicktaskstartdate();
	  loger.info("-------------------user clicked task start date---------------------");
	  prpg.selecttaskstartdate("03", "September", "2021");
	  loger.info("-------------------user selected task start date---------------------");
	  prpg.clicktaskenddate();
	  loger.info("-------------------user clicked task end date---------------------");
	  prpg.selecttaskenddate("03", "October", "2021");
	  loger.info("-------------------user selected task end date---------------------");
	  prpg.typetaskranking(1);
	  loger.info("-------------------user entered task ranking---------------------");
	  prpg.clicksavetask();
	  loger.info("-------------------user saved main task details ---------------------");
	   Thread.sleep(2000);
	  
	  
  }
  @Test(priority = 4)
  public void Area_Add() throws InterruptedException
  {
	  ProjectPage prpg=new ProjectPage(driver);
	  driver.navigate().to(driver.getCurrentUrl());
	  prpg.clickareatab();
	  loger.info("-------User clicked area details tab ------------------");  
	  prpg.typeareatitle("kaloor");
	  loger.info("-------User type area title ------------------");  
	  prpg.selectareaproject("PJT47");
	  loger.info("-------User selected area project ------------------");  
	  prpg.selectareastatus("Enable");
	  loger.info("-------User select area status ------------------");  
	  prpg.clicksavearea();
	  loger.info("-------User saved area details ------------------");  
	  Thread.sleep(2000);
  }
  @Test(priority = 5)
  public void WorkTypeDetails() throws InterruptedException
  {
	  ProjectPage prpg=new ProjectPage(driver);
	  //driver.navigate().to(driver.getCurrentUrl());
	  prpg.clickworktypetab();
	  loger.info("-------User clicked work type details tab ------------------");  
	  prpg.selectworktypeproject("PJT47");
	
	  loger.info("-------User selected work type project ------------------"); 
	  prpg.selectworktype("FLOOR TILES");
	  loger.info("-------User selected work type ------------------");  
	 // prpg.typeworktyperanking(1);
	  loger.info("-------User entered work type ranking ------------------"); 
	  prpg.clicksaveworktype();
	  loger.info("-------User entered work type ranking ------------------"); 
	  Thread.sleep(1000);	 
  }
  @Test(priority = 6)
  public void SiteuserDetails() throws InterruptedException
  {
	  ProjectPage prpg=new ProjectPage(driver);
	  prpg.clickworksitetab();
	  loger.info("-------User clicked work site details tab ------------------"); 
	  prpg.typesitename("kaloor32");
	  loger.info("-------User entered work site  ------------------"); 
	   prpg.selectsiteproject("PJT47");
	   loger.info("-------User select pjt ------------------"); 
	 // prpg.typelattitude(9);
	   prpg.typelattitude("9");
	  loger.info("-------User entered lattitude ------------------"); 
	 //  prpg.typelongitude(76);
	  prpg.typelongitude("76");
	   loger.info("-------User entered longitude  ------------------"); 
	  prpg.assignedsiteusers("THUSER thuser (SITE ENGINEER)");
	  loger.info("-------User entered site engineers ------------------"); 
	  // prpg.typepunchingradius(9000);
	  prpg.typepunchingradius("9000");
	   loger.info("-------User entered punching radius  ------------------"); 
		 prpg.clicksavesitedetails();
		 loger.info("-------User click save and add site  ------------------"); 
		 Thread.sleep(1000); 
  }
  @AfterMethod
  public void Verifysuccessful(ITestResult result) throws IOException, InterruptedException
  {
	  ProjectPage prpg=new ProjectPage(driver);
	  boolean projectstatus=prpg.verifysuccessfull1();
		loger.info("-------Verifying "+result.getName()+ " -------");
		//Thread.sleep(2000);
		if(projectstatus==true)
		{
		loger.info("********"+result.getName() +"  details added successfully!!************");
		loger.info("**********************************************************************************************************");
		}
	else
	{
	captureScreen(driver,result.getName());
	 // Assert.assertTrue(false);
	Assert.assertTrue(false, "********"+result.getName() +"  details added  failed!!************");
	}
  }
 
  
}

