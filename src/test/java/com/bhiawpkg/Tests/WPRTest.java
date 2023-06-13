package com.bhiawpkg.Tests;

import java.io.IOException;
import java.text.ParseException;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.BHIAW.Helper.AlertHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.Pages.WPRPage;
import com.bhiawpkg.TestBase.TestBase;
import com.bhiawpkg.Utility.XLUTILS;

public class WPRTest extends TestBase{
	private static Logger logger=LoggerHelper.getLogger(WPRTest.class);
	WPRPage wpr;
	Config con;
	ProjectPage prpg;
	String Projectname;
 @BeforeMethod
  public void Login() throws InterruptedException {
	  LoginPage bhilogin=new LoginPage(driver);
	   con=new Config(pr);
		  bhilogin.Login(con.Getusername(), con.Getpassword());
		  logger.info("--------Login is doing------------");
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
		  
		  logger.info("******************************WPR  SECTION**********************************");
	 } 
///*----------------------------------------
 @Test(dataProvider="Dailyworkprogres")
 public void AddDailyworkprogress(String Pjtname,String DwpExDate,String Task,
		 String	Quantity,String	Worktype, String Status,String	Description) throws InterruptedException, IOException, ParseException
 {
	 prpg=new ProjectPage(driver);
	  prpg.clickProjectsMenu();
	  logger.info("-------Clik Project Menu-------");
	  con=new Config(pr);
	  String pjtname= con.Getactionproject();
	  prpg.clickProjectscr();
	  logger.info("---click projects menu----");
	  wpr=new WPRPage(driver);
	  con=new Config(pr);
	  wpr.shiftuser(con.Getsiteusername());
	  impliciteWait(30);
	  wpr.clickWPRMenu();
	  impliciteWait(30);
	  wpr.clickDailyworkprogress();
	  logger.info("-------User Cliked Daily Work Progress-------");
	 wpr.clickadddailyworkprgs();
	  logger.info("-------User Cliked Add -- Daily Work Progress-------");
	  impliciteWait(30);
	   wpr.selectdwppjt(pjtname );//Projectname
	  impliciteWait(30);
	  logger.info("-------User select the project-------");
	    wpr.clickdate();
	  logger.info("-------User Clik the date------");
	 wpr.selwprdate();
	  logger.info("-------User select the date-------");
	  impliciteWait(30);
	  wpr.seltask1();
	  logger.info("-------User select the sub task-------");
	  wpr.typequantity(Quantity);
	  logger.info("-------User typed the quantity-------");
	  logger.info("-------User select the work type-------");
	  wpr.seldwpstatus(Status);
	  logger.info("-------User select the status-------");
	  wpr.typedescription(Description);
	  logger.info("-------User type description-------");
	  wpr.clickwprimgbtn();
	  impliciteWait(30);
	  wpr.callupload(con.Getphotopunchpath());
	  impliciteWait(30);
	  wpr.typeimglabel("Painting second floor");
	  wpr.selconsumeditems();
	  impliciteWait(30);
	  wpr.clicksubmit();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
	impliciteWait(30);
	  
	 /* WebElement sucemsg=driver.findElement(By.xpath("//*[@class='alert ']"));
	  waitForElementWithPollingInterval(driver, 20, sucemsg);*/
 /*------------------------------------------------
	  boolean addwprstaus=wpr.verifysuccessfull();
	 // impliciteWait(30);
	  if(addwprstaus==true)
	  	{
		  logger.info("------Daily work progress added successfully------");
		  Assert.assertTrue(true, "-------Daily work progress added successfully!!!!--------------");
	  	}
 		else
 		{
 			captureScreen(driver, "Add Daily work progress");
 		Assert.assertTrue(false, "-------Daily work progress added failed--------------");
 		}
 -----------------------------------------------*/
 }

 @DataProvider(name="Dailyworkprogres")
 public String[][] getdwprdetails() throws InvalidFormatException, IOException
 {
	 String path=System.getProperty("user.dir")+ "/src/test/java/com/bhiawpkg/Testdata/ashlypmsdata.xlsx";
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
 
 
 @Test
 public void ApproveDailyWrok() throws InterruptedException, IOException
 {
	
	 con=new Config(pr);
	//driver.navigate().to(driver.getCurrentUrl());
	// impliciteWait(30);
	 wpr=new WPRPage(driver);
	 wpr.clickWPRMenu();
	impliciteWait(30);
	 logger.info("-------User Cliked WPR Menu-------");
	// waitForElement(driver, 30, wpr.WPRPendingrequest);
	 //waitForElementWithPollingInterval(driver, 30, wpr.WPRPendingrequest);
	 con=new Config(pr);
	  String pjtname= con.Getactionproject();
	 wpr.clickWPRpendinrequest();
	 impliciteWait(30);
	 logger.info("-------User Cliked Pending request-------");
	 wpr.shiftuser(con.Getadminusername());
	 impliciteWait(30);
	 logger.info("-------Switched to another User -------");
	 //String selpjt=con.Getactionproject();
	 impliciteWait(30);
	 try {
	 wpr.selectpendpjt(pjtname);
	 impliciteWait(30);
	 logger.info("-------select the project from grid------------");
  	 int rows=driver.findElements(By.xpath("//*[@class='table table-bordered']//tbody//tr")).size();
	 System.out.println("Total number of rows "+rows);
	  String beforexpath="//*[@class='table table-bordered']//tbody//tr[";
	 String afterxpath="]//td[4]";
	 String tskafterpath="]//td[5]";
		  for(int i=1;i<=1;i++)
		  {
			  String expectedtskname=driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr[1]//td[5]")).getText();
				
			 String EXproject= Projectname;//con.Getactionproject();
			  String Projectname=driver.findElement(By.xpath(beforexpath+i+afterxpath)).getText();
			  String ActTaskname=driver.findElement(By.xpath(beforexpath+i+tskafterpath)).getText();
			  System.out.println("Project name is "+Projectname);
			//  wpr.selectpendpjt("MPJT04");
			  impliciteWait(30);
			  if(Projectname.contentEquals(EXproject)&&expectedtskname.contentEquals(ActTaskname))
			  {
				WebElement chkbox=driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr["+i+"]//td[1]"));
			   chkbox.click();
			   impliciteWait(30);
			   driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr["+i+"]//td[13]//a[@title='Approve']")).click();
			   impliciteWait(30);
			  // wpr.typerejectreason("invalid work progress data");
			  // impliciteWait(30);
			     AlertHelper alert=new AlertHelper(driver);
			   alert.AcceptAlertIfPresent();
			   impliciteWait(30);
		   logger.info("------------Alert is accepted-------------------");
		   impliciteWait(30);
		   if(wpr.getaftrappr().isDisplayed())
		   {
			   Assert.assertTrue(true);
		   }
		   else
		   {
			   captureScreen(driver, "WPR APPROVAL");
			   Assert.assertTrue(false, "------------------WPR Approve failed----------------------------------");
		   }
			  }
		  } 
	 }catch(Exception e)
	 {
		 captureScreen(driver, "WPR APPROVAL");
		   Assert.assertTrue(false, "--------WPR Approve failed, No WPR data Exist----------------------------------");
	 }
		 
 }
  @Test
 public void RejectDWP() throws InterruptedException, IOException
 {
 	
	 con=new Config(pr);
	 driver.navigate().to(driver.getCurrentUrl());
	 impliciteWait(30);
	 wpr=new WPRPage(driver);
	 wpr.clickWPRMenu();
	 impliciteWait(30);
	 logger.info("-------User Cliked WPR Menu-------");
	 con=new Config(pr);
	  String pjtname= con.Getactionproject();
	 wpr.clickWPRpendinrequest();
	 impliciteWait(30);
	 logger.info("-------User Cliked Pending request-------");
	 wpr.shiftuser(con.Getadminusername());
	 impliciteWait(30);
	 logger.info("-------Switched to another User -------");
	 //String selpjt=con.Getactionproject();
	 //impliciteWait(30);
	 try {
	 //wpr.selectpendpjt(con.Getactionproject());
		 wpr.selectpendpjt(pjtname);
		 impliciteWait(40);
	 logger.info("-------select the project from properties------------");

	
	  	 int rows=driver.findElements(By.xpath("//*[@class='table table-bordered']//tbody//tr")).size();
		 System.out.println("Total number of rows "+rows);
		  String beforexpath="//*[@class='table table-bordered']//tbody//tr[";
		 String afterxpath="]//td[4]";
		 String tskafterpath="]//td[5]";
		 // String expectedtskname=driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr[1]//td[5]")).getText();
		  for(int i=1;i<=1;i++)
		  {
			
			 String expectedtskname=driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr[1]//td[5]")).getText();
				
			 String EXproject= Projectname;//con.Getactionproject();
			  String Projectname=driver.findElement(By.xpath(beforexpath+i+afterxpath)).getText();
			  String ActTaskname=driver.findElement(By.xpath(beforexpath+i+tskafterpath)).getText();
			  System.out.println("Project name is "+Projectname);
			//  wpr.selectpendpjt("MPJT04");
			  impliciteWait(30);
			  if(Projectname.contentEquals(EXproject)&&expectedtskname.contentEquals(ActTaskname))
			  {
				  
				WebElement chkbox=driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr["+i+"]//td[1]"));
			   chkbox.click();
			   logger.info("--------------Check box is clicked to Reject--------------------");
			   impliciteWait(30);
			   driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr[\"+i+\"]//td[13]//a[@title='Reject']")).click();
			   logger.info("--------------user clicked Reject--------------------");
			   wpr.typerejectreason("Not valid");
			   impliciteWait(30);
			   wpr.clickrejectbtn();
			   impliciteWait(30);
			   boolean status=wpr.verifyRejection();
			   impliciteWait(30);
			   if(status==true)
			   {
				   logger.info("------------Rejection done successfully!!!-------------------");
				   Assert.assertTrue(true,"------------Rejection done successfully!!!-------------------");
			   }
			   else 
			   {
				   captureScreen(driver, "WPR Rejection");
				  Assert.assertTrue(false,"------------Rejection process failed!!! -------------------");
			   }
			  }	   
			  
			 }
		  }
	 catch(Exception e)
	 {
		 captureScreen(driver, "WPR Rejection");
		  Assert.assertTrue(false,"------Rejection process failed!!!Data Does not exist -------------------");  
	 }
}
  @Test
 public void RejectDWPRecall() throws InterruptedException, IOException
 {
	 con=new Config(pr);
	 driver.navigate().to(driver.getCurrentUrl());
	 impliciteWait(30);
	 wpr=new WPRPage(driver);
	 wpr.clickWPRMenu();
	 impliciteWait(30);
	 logger.info("-------User Cliked WPR Menu-------");
	 con=new Config(pr);
	  String pjtname= con.Getactionproject();
	 wpr.clickDailyworkprogress();
	  logger.info("-------User Cliked Daily Work Progress-------");
	  try {
	  wpr.selpjtpunchout(pjtname);//con.Getactionproject()
	  impliciteWait(30);
	  wpr.selapprovestatus("Rejected");
	  impliciteWait(30);
	  wpr.getrecalelm().click();
	  impliciteWait(30);
	  AlertHelper alert=new AlertHelper(driver);
	   alert.AcceptAlertIfPresent();
	   impliciteWait(30);
       logger.info("------------Alert is accepted-------------------");
       impliciteWait(30);
       logger.info("------------Recall successfull------------------");
       Assert.assertTrue(true,"------------Recall Successful-------------------");
	  }
	  catch(Exception ex)
	  {
		  captureScreen(driver, "Recall Rejected WPR---");
		  Assert.assertTrue(false, "---------------Recall failed. no rejected data Exist -----------------------");
	  }
       
	  
 }
 ///*----------------------------------------------------------
 @Test
 public void ViewDWP() throws InterruptedException, IOException
 {
 	
	 con=new Config(pr);
	 driver.navigate().to(driver.getCurrentUrl());
	 impliciteWait(30);
	 wpr=new WPRPage(driver);
	 wpr.clickWPRMenu();
	 impliciteWait(30);
	 logger.info("-------User Cliked WPR Menu-------");
	 con=new Config(pr);
	  String pjtname= con.Getactionproject();
	 wpr.clickWPRpendinrequest();
	 impliciteWait(30);
	 logger.info("-------User Cliked Pending request-------");
	 wpr.shiftuser(con.Getadminusername());
	 impliciteWait(30);
	 logger.info("-------Switched to another User -------");
	 //String selpjt=Projectname;
	 wpr.selectpendpjt(pjtname);
	 impliciteWait(30);
	 logger.info("-------select the project from properties------------");
	 try {
  	 int rows=driver.findElements(By.xpath("//*[@class='table table-bordered']//tbody//tr")).size();
	 System.out.println("Total number of rows "+rows);
	  String beforexpath="//*[@class='table table-bordered']//tbody//tr[";
	 String afterxpath="]//td[4]";
	 String tskafterpath="]//td[5]";
		  for(int i=1;i<=1;i++)
		  {
			  String expectedtskname=driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr[1]//td[5]")).getText();
				
			 String EXproject= Projectname;
			  String Projectname=driver.findElement(By.xpath(beforexpath+i+afterxpath)).getText();
			  String ActTaskname=driver.findElement(By.xpath(beforexpath+i+tskafterpath)).getText();
			  System.out.println("Project name is "+Projectname);
			  impliciteWait(30);
			  if(Projectname.contentEquals(EXproject)&&expectedtskname.contentEquals(ActTaskname))
			  {
				WebElement chkbox=driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr["+i+"]//td[1]"));
			   chkbox.click();
			   logger.info("--------------Check box is clicked to View--------------------");
			   impliciteWait(30);
			   driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr[\"+i+\"]//td[13]//a[@title='View']")).click();
			   logger.info("--------------clicked View--------------------");
			 //  boolean viewstatus=wpr.getviewpanel();
			/*  boolean viewclosebtn=wpr.Getelmview().isDisplayed();
			  impliciteWait(30);
			   if(viewclosebtn==true)
			   {
				   Assert.assertTrue(true,"------------View panel is displayed. Successful-------------------");
			   }
			   else
			   {
				   Assert.assertTrue(false,"------------WPR view is failed!!-------------------"); 
			   }
			   //wpr.closeviewpanel();
			   logger.info("----------------user closed view panel----------------");
			  */
 ///*----------------------------------------------------------==========
			  impliciteWait(30);
			   driver.navigate().back();
			 
			  }
 	     }
	 }catch(Exception e)
	 {
		 captureScreen(driver, "WPR View failed");
		  Assert.assertTrue(false,"------------View process failed!!! -------------------");
	 }
	
}

 
 //----------------------------------------------------------*/
 @AfterMethod
 public void Logout()
 {
	  LogoutPage logout=new LogoutPage(driver);
	  logout.clickusericon();
	  logout.clickLogout();
 }
	
 
}