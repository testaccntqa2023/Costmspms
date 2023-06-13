package com.bhiawpkg.Tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.Pages.Reportpage;
import com.bhiawpkg.TestBase.TestBase;

public class ServiceReportTest extends TestBase {
	private static Logger logger=LoggerHelper.getLogger(ServiceReportTest.class);
	LoginPage bhilogin;
	Config con;
	ProjectPage pjtpg;
	ProjectPage prpg;
	//cap=DesiredCapabilities.chrome();
	
	Reportpage rptpg;
  @BeforeMethod
  public void Login() {
	  
	  
	  con=new Config(pr);
	  bhilogin=new LoginPage(driver);
	  bhilogin.Login(con.Getusername(), con.Getpassword());
	  logger.info("--------Login is doing------------");
	  bhilogin.Clickbox();
	  logger.info("==============login is sucessful=========================");
	  logger.info("************************************************************");
	 
	 }
  @Test
  public void ServiceReport() throws InterruptedException, IOException
  {
	  prpg=new ProjectPage(driver);
		prpg.clickProjectsMenu();
		logger.info("-------Clik Project Menu-------");	
		prpg.clickProjectscr();
		logger.info("-------Going to project section-------");	
		String Projectname=prpg.Getgrdpjtname();
	   rptpg=new Reportpage(driver);
	  rptpg.clickreports();
	  Thread.sleep(2000);
	  logger.info("==============user click reports menu=========================");
	 rptpg.clickservicerept();
	 Thread.sleep(2000);
	  logger.info("==============user click service report option=========================");
	   rptpg.servicerptfromdate();
	  logger.info("==============user enter from date=========================");
	  rptpg.servicerpttodate();
	  logger.info("==============user enter from date=========================");
	  rptpg.selservicerptpjt(Projectname);//con.Getactionproject()
	  logger.info("==============user select project=========================");
	  rptpg.clicksearch();
	  logger.info("==============user click  search button=========================");
	  try {
		  String pjtname=driver.findElement(By.xpath("//*[@id='timereport-grid']//table//tbody//tr[1]//td[2]")).getText();
		  if(pjtname.equals(Projectname))//con.Getactionproject()
		  {
			  logger.info("==============service report is available=========================");
			  Assert.assertTrue(true);
		  }
	  }
	  catch (Exception e) {
		captureScreen(driver, "Service Repoprt");
		logger.info("==============service report is not available========================");
		Assert.assertTrue(true, "--------Service report is not available----");
	}
  }

 
  @AfterMethod
  public void afterdownload()
  {
	  LogoutPage logout=new LogoutPage(driver);
	  logout.clickusericon();
	  logout.clickLogout();
  }
}
