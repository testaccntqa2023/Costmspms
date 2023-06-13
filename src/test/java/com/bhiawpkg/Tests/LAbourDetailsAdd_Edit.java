package com.bhiawpkg.Tests;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.Pages.WPRPage;
import com.bhiawpkg.TestBase.TestBase;
import com.bhiawpkg.Utility.XLUTILS;

public class LAbourDetailsAdd_Edit extends TestBase{
	private static Logger logger=LoggerHelper.getLogger(LAbourDetailsAdd_Edit.class);
	WPRPage wpr;
	Config con;
	ProjectPage prpg;
	String Projectname;
 @BeforeMethod
  public void WPR() throws InterruptedException {
	  LoginPage bhilogin=new LoginPage(driver);
	  
		Config con=new Config(pr);
		  bhilogin.Login(con.Getusername(), con.Getpassword());
		 // Thread.sleep(4000);
		  logger.info("--------Login is doing------------");
		  bhilogin.Clickbox();
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
		  logger.info("******************************Daily labour SECTION**********************************");
	 } 

 @DataProvider(name="LaborReport")
 public String[][] getlbrdetails() throws InvalidFormatException, IOException
 {
	 String path=System.getProperty("user.dir")+ "/src/test/java/com/bhiawpkg/Testdata/ashlypmsdata.xlsx";
	  logger.info("file is getting!!!!!");
		  int rowcnt=XLUTILS.getrowcount(path, "Dailylaborreport");
		  int colcnt=XLUTILS.getcellcount(path, "Dailylaborreport",1);
		  String [][]Dailylbr=new String[rowcnt][colcnt];
		  for(int i=1;i<=rowcnt;i++)
		   {
			  for(int j=0;j<colcnt;j++)
			  {
				  Dailylbr[i-1][j]=XLUTILS.getCellData(path, "Dailylaborreport", i, j);
			  }
		  }
		  logger.info("Excel data is returned");
		  return Dailylbr;
 }
 
 
 @Test(dataProvider ="LaborReport")
 public void DailyLaborDetails_Add(String Project,String LbrExDate,String LbrTask,
		 String Lbrworktype,String Skilledworker,String	Unskilledworkers,String	Description) throws InterruptedException, IOException
 {
	 wpr=new WPRPage(driver);
	 con=new Config(pr);
	 try {
		 
	  wpr.shiftuser(con.Getsiteusername());//
	  impliciteWait(30);
	  wpr.clickWPRMenu();
	  impliciteWait(30);
	  con=new Config(pr);
	  String pjtname= con.Getactionproject();
	  wpr.clickdailylabourreport();
	  logger.info("-------User Cliked Daily Labour reports-------");
	  wpr.sellbrpjt(pjtname);
	  impliciteWait(30);
	  logger.info("-------User select the project-------");
	  wpr.clicklbrdate();
	  logger.info("-------User Cliked Date-------");
	  // wpr.sellbrdate(LbrExDay, LbrExMonth, LbrExYear);
	  wpr.selelbrdate(LbrExDate);
	  impliciteWait(30);
	 logger.info("-------User select the date-------");
	wpr.sellbrtask1();
	  //wpr.sellbrtask(LbrTask);
	  impliciteWait(30);
	  logger.info("-------User select the labor task-------");
	// wpr.sellbrwrktype(Lbrworktype);
	//  wpr.sellbrwrktype1();
	 impliciteWait(30);
	 logger.info("-------User select the labor work type-------");
	  wpr.typeskilledworkers(Skilledworker);
	  impliciteWait(30);
	  logger.info("-------User type the skilled workers------");
	  wpr.typeunskilledworkers(Unskilledworkers);
	  impliciteWait(30);
	  logger.info("-------User type the unskilled workers-------");
	   wpr.typelbrdescription(Description);
	   logger.info("-------User type labor description-------");
//labourtype----06-03-2023
	   wpr.sellbrtype();
	   logger.info("-------select labour type-------");
	   wpr.typelbrcnt();
	   logger.info("-------enter labour count-------");
	   wpr.typelbrwage();
	   logger.info("-------type labour wage-------");
	   wpr.sellbrtype1();
	   logger.info("-------select next labour type-------");
	   wpr.typelbrcnt();
	   logger.info("-------enter labour count-------");
	   wpr.typelbrwage();
	   logger.info("-------type labour wage-------");
		 wpr.clickAddlbr();
		 logger.info("-------User Cliked ADD button-------");
		 impliciteWait(30);
		 boolean addlbrstaus=wpr.verifysuccessfulllbr();
		  if(addlbrstaus==true)
		  	{
			  logger.info("-------Daily labor details added successfully!!!!--------");
			  Assert.assertTrue(true, "-------Daily labor details added successfully!!!!--------------");
	 		}
	 		else if(driver.getPageSource().contains("Task already entered"))
	 		{
	 			captureScreen(driver, "Add labor details");
	 			 logger.info("-------Daily labor details ADD failed, Data Already exist!!!!--------");
	 		Assert.assertTrue(true, "-------Daily labor details ADD failed,Data Already exist!!--------------");
	 		}
       }
		  catch (Exception e) {
			// captureScreen(driver, "WPR Rejection");
		Assert.assertTrue(false,"------------Daily labor details ADD failed-!!! Task not loaded-------------------");
		}
	 
 }
 
 @Test(dataProvider ="LaborReport")
 public void DailyLaborDetails_Edit(String Project,String LbrExDate,String LbrTask,String Lbrworktype,String Skilledworker,
		 String	Unskilledworkers,String	Description) throws InterruptedException, IOException
 {
	 wpr=new WPRPage(driver);
	 con=new Config(pr);
	 // wpr.shiftuser(con.Getsiteusername());---choose user
	  impliciteWait(30);
	  wpr.clickWPRMenu();
	  impliciteWait(30);
	  wpr.clickdailylabourreport();
	  logger.info("-------User Cliked Daily Labour reports-------");
	 // wpr.clearfield();
	  try {
	  wpr.sellbrgrdpjt(Projectname);
	  logger.info("-------User select the project-------");
	 wpr.clickEditbtn();
	 logger.info("----------user click edit button------------------------");
	 impliciteWait(30);
	 wpr.clearfield();
	 wpr.sellbrpjt(Projectname);
	 impliciteWait(30);
	 String lbrdate=wpr.getgrdlbrdate();
	 impliciteWait(30);
	 wpr.typeeditdate(lbrdate);
	 logger.info("----------user click edit button------------------------");
	// wpr.sellbrtask(LbrTask);
	 wpr.seleditlbrtask();
	 impliciteWait(30);
	 logger.info("-------User select the labor task-------");
	 wpr.sellbrwrktype(Lbrworktype);
	 impliciteWait(30);
	 logger.info("-------User select the labor work type-------");
	  wpr.typeskilledworkers(Skilledworker);
	  impliciteWait(30);
	  logger.info("-------User type the skilled workers------");
	  wpr.typeunskilledworkers(Unskilledworkers);
	  logger.info("-------User type the unskilled workers-------");
	  wpr.typelbrdescription(Description);
	  logger.info("-------User type labor description-------");
	 wpr.clicksavebtn();
	 impliciteWait(30);
	 logger.info("--------user click save button------------");
	 boolean status=wpr.verifyeditsuccessful();
	 impliciteWait(30);
	 if(status==true)
	 {
		 logger.info("---------Edit successfull-------------");
		 Assert.assertTrue(true);
		 impliciteWait(30);
	 }
	 else 
	 {
		 logger.info("---------Edit successfull-------------");
		 Assert.assertTrue(false,"-------Edit successful msg is not get--------------");
	 }
	}
	  catch(Exception ex)
	  {
		  captureScreen(driver, "--Edit Labour Details---");
		  impliciteWait(30);
		  logger.info("------Editting is not possible. Data does not Exist --------------");
		  Assert.assertTrue(false,"-------Editting labour details failed----Not exist labour details----------");
	  }
 }
 @AfterMethod
 public void Logout()
 {
	  LogoutPage logout=new LogoutPage(driver);
	  logout.clickusericon();
	  logout.clickLogout();
 }
		 
 
}