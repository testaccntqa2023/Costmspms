package com.bhiawpkg.Tests;

import java.io.IOException;
import java.text.ParseException;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BHIAW.Helper.JavascriptHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.AssignedtaskPage;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.MyTaskPage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.Pages.WPRPage;
import com.bhiawpkg.TestBase.TestBase;
import com.bhiawpkg.Utility.XLUTILS;

public class ExpiredExternalWPRTest extends TestBase{
	private static Logger logger=LoggerHelper.getLogger(ExpiredExternalWPRTest.class);
	WPRPage wpr;
	Config con;
	ProjectPage prpg;
	String Projectname;
	MyTaskPage mytskpg;
 @BeforeMethod
  public void Login() throws InterruptedException {
	  LoginPage bhilogin=new LoginPage(driver);
	   con=new Config(pr);
		  bhilogin.Login(con.Getusername(), con.Getpassword());
		 // Thread.sleep(4000);
		  logger.info("--------Login is doing------------");
		// bhilogin.Clickbox();
		  logger.info("==============login is sucessful=========================");	
		  prpg=new ProjectPage(driver);
			prpg.clickProjectsMenu();
			Thread.sleep(2000);
			logger.info("-------Clik Project Menu-------");	
			con=new Config(pr);
			  String pjtname= con.Getactionproject();
			  Thread.sleep(2000);
			/*
			 * logger.info("-------Clik Project Menu-------"); prpg.clickProjectscr();
			 * Thread.sleep(2000); logger.info("-------Going to project section-------");
			 * Projectname=prpg.Getgrdpjtname(); Thread.sleep(2000);
			 */
		  
		  logger.info("******************************WPR  SECTION**********************************");
	 } 
///*----------------------------------------
 @Test(dataProvider="Dailyworkprogres")
 public void ExpiredTask_AddDailyworkprogress(String Pjtname,String DwpExDate,String Task,
		 String	Quantity,String	Worktype, String Status,String	Description) throws InterruptedException, IOException, ParseException
 {
	 prpg=new ProjectPage(driver);
	  prpg.clickProjectsMenu();
	  logger.info("-------Clik Project Menu-------");
	  con=new Config(pr);
	  String pjtname= con.Getexpiredproject();
	 // prpg.clickProjectscr();con.Getactionproject();
	  logger.info("---click projects menu----");
	 // String pjtname=prpg.Getprojectname();
	  
	  mytskpg=new MyTaskPage(driver);
	  mytskpg.clickmytskmenu();
	  Thread.sleep(2000);
	  logger.info("-------------------user click my task menu--------------------------------------");
	  mytskpg.clickmytaskoption();
	  Thread.sleep(2000);
	  mytskpg.selmytskpjt(pjtname);//con.Getactionproject()
	  Thread.sleep(2000);
	  logger.info("-------------------user select the project--------------------------------------");
	  mytskpg.seltaskstatus("In-progress");
	  Thread.sleep(2000);
	 mytskpg.seltasktype("External");
	  Thread.sleep(2000);
	 mytskpg.Getexpiredtask();
	  
	  
	  //mytskpg.clickexpiredmytaskview();
	  Thread.sleep(2000);
	 // mytskpg.seltasktype("External");
	 // Thread.sleep(2000);In-progress
	  
	 // mytskpg.clickmytaskview();
	  Thread.sleep(2000);
	//  
	  con=new Config(pr);
	  mytskpg.shiftuser(con.Getsiteusername());
	   Thread.sleep(2000);
	 mytskpg.clickAdddailywprbutton();
	 Thread.sleep(2000);
	 wpr=new WPRPage(driver);
	 wpr.typewprquantity();
	 wpr.seldwpstatus(Status);
	  logger.info("-------User select the status-------");
	  wpr.typedescription(Description);
	  logger.info("-------User type description-------");
	  JavascriptHelper js=new JavascriptHelper(driver);
	  js.scrollDownByPixel();
	  Thread.sleep(2000);
	  wpr.clicksubmit();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
	  Thread.sleep(2000);

  }
 @DataProvider(name="Dailyworkprogres")
 public String[][] getdwprdetails() throws InvalidFormatException, IOException
 {
	 String path=System.getProperty("user.dir")+ "/src/test/java/com/bhiawpkg/Testdata/ashlypmsdata1.xlsx";
	  logger.info("file is getting!!!!!");
		  int rowcnt=XLUTILS.getrowcount(path, "Dailyworkprogress");
		  int colcnt=XLUTILS.getcellcount(path, "Dailyworkprogress",1);
		  String [][]Dailywrkpr=new String[rowcnt][colcnt];
		  for(int i=1;i<=rowcnt;i++)
		   {
			  for(int j=0;j<colcnt;j++)
			  {
				  Dailywrkpr[i-1][j]=XLUTILS.getCellData(path, "Dailyworkprogress", i, j);
			  }
		  }
		  logger.info("Excel data is returned");
		  return Dailywrkpr;
 }
 @AfterMethod
 public void Logout()
 {
	  LogoutPage logout=new LogoutPage(driver);
	  logout.clickusericon();
	  logout.clickLogout();
 }
 
}
