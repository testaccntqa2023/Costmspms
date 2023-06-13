package com.bhiawpkg.Tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BHIAW.Helper.JavascriptHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.Pages.TemplatePage;
import com.bhiawpkg.TestBase.TestBase;

public class ProjectMapping extends TestBase{
	private static Logger loger=LoggerHelper.getLogger(CreateTemplate.class);
	ProjectPage prpg=new ProjectPage(driver);
	JavascriptHelper js;
	TemplatePage tmpPage=new TemplatePage(driver);
	
	
	  @BeforeMethod
	  public void Login() throws InterruptedException, IOException {
		  LoginPage bhilogin=new LoginPage(driver);
		  Config con=new Config(pr);
		  bhilogin.Login(con.Getusername(), con.Getpassword());
		  impliciteWait(40);
		  loger.info("--------Login is doing-----------");
		  boolean status=bhilogin.verifysuccessfull();
		  	  if(status==true){
				Assert.assertTrue(true);
				impliciteWait(30);
				//bhilogin.Clickbox();
				loger.info("==============login is sucessful=========================");
				
			}
			else{
				captureScreen(driver,"loginTest");
				 // Assert.assertTrue(false);
				Assert.assertTrue(false, "==============login is not sucessful=========================");
			}
		  	//con.Geturl();
		 }
	  @Test
	  public void Projectmapping() throws InterruptedException
	  {
		  loger.info("******************************PROJECT MAPPING SECTION**********************************");
		  prpg=new ProjectPage(driver);
		  prpg.clickProjectsMenu();
		  loger.info("-------Clik Project Menu-------");
		  prpg.clickProjectscr();
		  loger.info("---click projects menu----");
		  String pjtname=prpg.Getprojectname();
		  impliciteWait(30);
		  prpg.clickProjectsMenu();
		  loger.info("-------Clik Project Menu-------");
		  prpg.clickprojectmapping();
		  loger.info("-------Clik Project Mapping-------");
		 prpg.selpjtformapping(pjtname);
		 impliciteWait(30);
		 loger.info("-------select Project for Mapping-------");
		 prpg.clicksavebtn();
		 loger.info("-------Clik save pjt Mapping-------");
		  loger.info("--Project mapping completed successfully!!--");
	  }
	  @AfterMethod
	  public void Logout() throws InterruptedException
	  {
		  impliciteWait(30);
	 	  LogoutPage logout=new LogoutPage(driver);
	 	  logout.clickusericon();
	 	  logout.clickLogout();
	  } 
}
