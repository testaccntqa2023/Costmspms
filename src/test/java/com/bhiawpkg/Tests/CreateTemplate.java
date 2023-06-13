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

public class CreateTemplate extends TestBase{
	private static Logger loger=LoggerHelper.getLogger(CreateTemplate.class);
	ProjectPage prpg=new ProjectPage(driver);
	JavascriptHelper js;
	TemplatePage tmpPage=new TemplatePage(driver);
	
	
	  @BeforeMethod
	  public void Login() throws InterruptedException, IOException {
		  LoginPage bhilogin=new LoginPage(driver);
		  Config con=new Config(pr);
		  bhilogin.Login(con.Getusername(), con.Getpassword());
		  impliciteWait(30);
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
		  }
	 
@Test
public void Templatecreation() throws InterruptedException
{
	  tmpPage=new TemplatePage(driver);
	 tmpPage.clicksettingsmenu();
	  impliciteWait(30);	
	  loger.info("-------click settings menu-----------");
	  tmpPage.clickTemplate();
	  loger.info("-------click template-----------");
	
	  tmpPage.clicknewtemplate();
	  loger.info("-------click new template-----------");
	  tmpPage.typetemplatename();
	  loger.info("-------click template name-----------");
	  tmpPage.typetmpitemname();
	  loger.info("-------click item name-----------");
	  tmpPage.typetmprefcolumn();
	  loger.info("-------click type ref column-----------");
	  tmpPage.selectpuritems();
	  loger.info("-------select purchase item-----------");
	  tmpPage.addtemplateitems();
	  impliciteWait(30);
	  js=new JavascriptHelper(driver);
	  js.scrollDownByPixel();
	  tmpPage.clickcreatebtn();
	  impliciteWait(30);
}

@Test
public void Templateupdation() throws InterruptedException
{
	   tmpPage=new TemplatePage(driver);
	    String tmpname=tmpPage.Getlatesttemplatename();
	    impliciteWait(30);
	 	prpg=new ProjectPage(driver);
		prpg.clickProjectsMenu();
		loger.info("-------Clik Project Menu-------");	
		prpg.clickProjectscr();
		loger.info("-------Going to project section-------");
		prpg.clickpjtgrdEdit();
		loger.info("--click edit button on the project grid---");
	    js=new JavascriptHelper(driver);
	    js.scrollDownByPixel();
	    prpg.seltemplate(tmpname);
	    loger.info("---select template name-");
	    prpg.clickupdatebtn();
	    loger.info("---click update project button-");
		impliciteWait(30);
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
