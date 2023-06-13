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

public class ItemEstimationTest extends TestBase{
	private static Logger loger=LoggerHelper.getLogger(ItemEstimationTest.class);
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
  public void ItemEstimation() throws InterruptedException, IOException {
	  loger.info("******************************PROJECT MAPPING SECTION**********************************");
	  prpg=new ProjectPage(driver);
	  prpg.clickProjectsMenu();
	  loger.info("-------Clik Project Menu-------");
	  prpg.clickProjectscr();
	  loger.info("---click projects menu----");
	  String pjtname=prpg.Getprojectname();
	  prpg.clickProjectsMenu();
	  loger.info("-------Clik Project Menu-------");
	  prpg.clickItemestimate();
	  loger.info("----click item estimate -----");
	  prpg.selItemEstimatepjt(pjtname);
	  impliciteWait(30);
	  loger.info("------select item estimate project------");
	  prpg.clickitmestmGobutton();
	  loger.info("------click Itmestimate Go button----");
	  impliciteWait(30);
	  prpg.ADDitemquantity();
	  loger.info("--click create button---"); 
	  prpg.clickitemestimatesavebtn();	  
	  loger.info("----click item estimate button---");
	  impliciteWait(30);
		Verifysuccessfull();
		impliciteWait(30);
}
public void Verifysuccessfull() throws IOException, InterruptedException
{
	  boolean status=prpg.verifysuccessfull();
	  impliciteWait(30);
	  if(status==true)
	{
		  loger.info("-----------------successfully -----------------------");
		Assert.assertTrue(true);
		
	}
	else
	{
		captureScreen(driver, "Item estimation");
		loger.info("-----------------Data creation failed -----------------------");
		Assert.assertTrue(false,"---------------Data creation failed----------------------");
	}

  }
  
	  /*
	  @Test
	  public void Additemestimate() throws InterruptedException
	  {
		  loger.info("-------To get project name------");	
		   prpg=new ProjectPage(driver);
		   
			prpg.clickProjectsMenu();
			loger.info("-------Clik Project Menu-------");	
			prpg.clickProjectscr();
			loger.info("-------Going to project section-------");	
			String Projectname=prpg.Getgrdpjtname();
			AssignedtaskPage AT=new AssignedtaskPage(driver);
			  AT.clickAssignedTaskMenu();
			  loger.info("-------User Clik Assigned Tasks-------");
			  AT.selpjtfrmasstsk(Projectname);
			  impliciteWait(30);
			  AT.AddItemEstimation(Projectname);
			  loger.info("--click item estimation---");
			 AT.clickitmCreatebtn();
			 loger.info("--click create button---"); 
	  }
	  */
  @AfterMethod
  public void Logout() throws InterruptedException
  {
	  impliciteWait(30);
 	  LogoutPage logout=new LogoutPage(driver);
 	  logout.clickusericon();
 	  logout.clickLogout();
  } 
}
