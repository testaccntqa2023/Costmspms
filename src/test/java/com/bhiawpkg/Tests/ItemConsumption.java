package com.bhiawpkg.Tests;

import java.io.IOException;

import org.apache.log4j.Logger;
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

public class ItemConsumption extends TestBase
	 {
	private static Logger loger=LoggerHelper.getLogger(ItemConsumption.class);
	ProjectPage prpg;
	Config con;
	WPRPage wpr;
	 @BeforeMethod
	  public void Login() throws InterruptedException, IOException
	 {
		  LoginPage bhilogin=new LoginPage(driver);
		  Config con=new Config(pr);
		  bhilogin.Login(con.Getusername(), con.Getpassword());
		  Thread.sleep(4000);
		  loger.info("--------Login is doing-----------");
		  boolean status=bhilogin.verifysuccessfull();
		  	  if(status==true){
				Assert.assertTrue(true);
				Thread.sleep(2000);
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
  public void WPRItemconsumption() throws InterruptedException, IOException 
	{
	  
		  prpg=new ProjectPage(driver);
		  prpg.clickProjectsMenu();
		  loger.info("-------Clik Project Menu-------");
		  prpg.clickProjectscr();
		  loger.info("---click projects menu----");
		  String pjtname=prpg.Getprojectname();
		  wpr=new WPRPage(driver);
		  con=new Config(pr);
		  wpr.shiftuser(con.Getsiteusername());
		  Thread.sleep(2000);
		  wpr.clickWPRMenu();
		  Thread.sleep(2000);
		  wpr.clickDailyworkprogress();
		  loger.info("-------User Cliked Daily Work Progress-------");
		 wpr.clickadddailyworkprgs();
		  loger.info("-------User Cliked Add -- Daily Work Progress-------");
		  Thread.sleep(2000);
		 
		  wpr.selectdwppjt(pjtname);
		  loger.info("-------User select the project-------");
		  wpr.clickdate();
		  loger.info("-------User Clik the date------");
		  //wpr.selectdate(DwpExDay,DwpExMonth,DwpExYear);
		 // wpr.selectdate(DwpExDay,DwpExMonth,DwpExYear);
		  wpr.selwprdate();
		  loger.info("-------User select the date-------");
		  Thread.sleep(1000);
		  wpr.seltask1();
		  Thread.sleep(1000);
		  loger.info("-------User select the sub task-------");
		  wpr.typequantity("2");
		  loger.info("-------User typed the quantity-------");
		  wpr.seledwpworktype1();
		  loger.info("-------User select the work type-------");
		  wpr.seldwpstatus("In-progress");
		  loger.info("-------User select the status-------");
		  wpr.typedescription("test");
		  loger.info("-------User type description-------");
		  wpr.clickwprimgbtn();
		  Thread.sleep(2000);
		  wpr.callupload(con.Getphotopunchpath());
		  Thread.sleep(2000);
		  wpr.typeimglabel("Painting second floor");
		  wpr.clicksubmit();
		  Thread.sleep(2000);
	 
	
	

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
