package com.bhiawpkg.Tests;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BHIAW.Helper.AlertHelper;
import com.BHIAW.Helper.Dateselectionhelper;
import com.BHIAW.Helper.DropdownHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.AMSPage;
import com.bhiawpkg.Pages.AssignedtaskPage;
import com.bhiawpkg.Pages.GalleryPage;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.MenupermissionPage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.Pages.Reportpage;
import com.bhiawpkg.Pages.WPRPage;
import com.bhiawpkg.TestBase.TestBase;

public class Report_DownloadTest extends TestBase{
	private static Logger logger=LoggerHelper.getLogger(Report_DownloadTest.class);
	LoginPage bhilogin;
	Config con;
	ProjectPage pjtpg;
	//cap=DesiredCapabilities.chrome();
	String Projectname;
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
	  pjtpg=new ProjectPage(driver);
	  pjtpg.clickProjectsMenu();
		logger.info("-------Clik Project Menu-------");	
		pjtpg.clickProjectscr();
		logger.info("-------Going to project section-------");	
		 Projectname=pjtpg.Getgrdpjtname();
	 
	 }
  ///*--------------------------------------------------------------------------------------
  
  @Test
  public void Download_ProjectGanttchart() throws InterruptedException
  {
	   pjtpg=new ProjectPage(driver);
	  pjtpg.clickProjectsMenu();
	  logger.info("==============user click project menu=========================");
	  pjtpg.Clickpjtganttchart();
	  logger.info("==============user click project gantt chart=========================");
	  pjtpg.selganttpjt(Projectname);//con.Getactionproject()
	  Thread.sleep(2000);
	  logger.info("==============user select project to get gantt chart=========================");
	  pjtpg.clickExcelgantt();
	  logger.info("==============user click project gantt chart as excel=========================");
	  Thread.sleep(2000);
	  pjtpg.clickpdfganttchart();
	  logger.info("==============user click project gantt chart as pdf=========================");
	  Thread.sleep(3000);
  }
  
 
 
  @Test
  public void Download_Assignedtsk() throws InterruptedException
  {
	  AssignedtaskPage astskpg=new AssignedtaskPage(driver);
	  astskpg.clickAssignedTaskMenu();
	  astskpg.selecttaskpjt(Projectname);//con.Getactionproject()
	  Thread.sleep(2000);
	  astskpg.clicktaskdownload();
	  Thread.sleep(2000);
	  logger.info("==============user click assigned task pdf=========================");
	  	 
  }
 
  @Test
  public void CreateAndDownload_ProjectReport_Progress() throws InterruptedException, IOException
  {
	  
	//  con=new Config(pr);
	  /*--------------------------------------------------------------------------
	  WPRPage wpr=new WPRPage(driver);
	  wpr.clickWPRMenu();
	  Thread.sleep(2000);
	  wpr.clickWPRpendinrequest();
		 Thread.sleep(2000);
		 logger.info("-------User Cliked Pending request-------");
		 try {
		 wpr.selectpendpjt(con.Getactionproject());
		 Thread.sleep(2000);
		 logger.info("-------select the project -------------------");
		 int rows=driver.findElements(By.xpath("//*[@class='table table-bordered']//tbody//tr")).size();
		 System.out.println("Total number of rows "+rows);
		  String beforexpath="//*[@class='table table-bordered']//tbody//tr[";
		 String afterxpath="]//td[4]";
		 String tskafterpath="]//td[5]";
			  for(int i=1;i<=1;i++)
			  {
				  String expectedtskname=driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr[1]//td[5]")).getText();
					
				 String EXproject= con.Getactionproject();
				  String Projectname=driver.findElement(By.xpath(beforexpath+i+afterxpath)).getText();
				  String ActTaskname=driver.findElement(By.xpath(beforexpath+i+tskafterpath)).getText();
				  System.out.println("Project name is "+Projectname);
				//  wpr.selectpendpjt("MPJT04");
				  Thread.sleep(2000);
				  if(Projectname.contentEquals(EXproject)&&expectedtskname.contentEquals(ActTaskname))
				  {
					WebElement chkbox=driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr["+i+"]//td[1]"));
				   chkbox.click();
				   Thread.sleep(2000);
				   driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr[\"+i+\"]//td[13]//a[@title='Approve']")).click();
				   Thread.sleep(2000);
				  // wpr.typerejectreason("invalid work progress data");
				  // Thread.sleep(2000);
				     AlertHelper alert=new AlertHelper(driver);
				   alert.AcceptAlertIfPresent();
				   Thread.sleep(2000);
			   logger.info("------------Alert is accepted-------------------");
			   Thread.sleep(2000);
			   if(wpr.getaftrappr().isDisplayed())
			   {
				   Assert.assertTrue(true);
			   }
			   else
			   {
				   captureScreen(driver, "WPR APPROVAL");
				   Assert.assertTrue(false, "------------------WPR Approve failed----------------------------------");
			   }
	/--------------------------------------------------------------------------*/			    
	  WPRPage wpr=new WPRPage(driver);
		 wpr.clickWPRMenu();
		 logger.info("-------User Cliked WPR Menu-------");
		 wpr.clickWPRpendinrequest();
		 Thread.sleep(2000);
		 logger.info("-------User Cliked Pending request-------");
		 wpr.shiftuser(con.Getadminusername());
		 Thread.sleep(2000);
		 logger.info("-------Switched to another User -------");
		 String selpjt=Projectname;//con.Getactionproject();
		 Thread.sleep(2000);
		 try {
			 wpr.selectpendpjt(selpjt);
			 Thread.sleep(2000);
			 logger.info("-------select the project from grid------------");
			// wpr.selwprapprovestatus_pgsrpt("Not Approved");
			 Thread.sleep(2000);
			 logger.info("-------user selecting the not approve status-----------------------------");
			 driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody//tr[\"+i+\"]//td[13]//a[@title='Approve']")).click();
			   Thread.sleep(2000);
			   logger.info("-------user click the approved icon------------------ ");
			   AlertHelper alert=new AlertHelper(driver);
			   alert.AcceptAlertIfPresent();
			   Thread.sleep(2000);
		   logger.info("------------Alert is accepted-------------------");
		   Thread.sleep(2000);
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
	catch(Exception ex)
		 {
			captureScreen(driver, "Progress report ");
			Assert.assertTrue(false, "------------------WPR Approve failed., so progress report cannot generate----------------------------------");
		 }
			 
	  MenupermissionPage menupg=new MenupermissionPage(driver);
	  menupg.clickSettingsmenu();
	  Thread.sleep(2000);
	  logger.info("-----------click settings menu------------------------------");
	  GalleryPage gallerypg=new GalleryPage(driver);
	  gallerypg.clickgallery();
	  Thread.sleep(2000);
	  logger.info("-----------click gallery option from settings------------------------------");
	 // gallerypg.selgallerypjt(con.Getactionproject());
	 // Thread.sleep(2000);
	 // logger.info("---------select the project ------------");
	 // gallerypg.clickGobtn();
	//  Thread.sleep(2000);
	//  logger.info("------------click the go button-------------------");
	  clickchkboxpjtname();
	  Thread.sleep(2000);
	  logger.info("-----------click check box corresponding to the pjt---------------");
	  gallerypg.clickincrptbtn();
	  Thread.sleep(2000);
	  logger.info("-----------click include report------------------------");
	  
	  AlertHelper alrt=new AlertHelper(driver);
	  alrt.AcceptAlertIfPresent();
	  Thread.sleep(2000);
	  driver.navigate().refresh();
	  Reportpage rptpg=new Reportpage(driver);
	  rptpg.clickreports();
	  Thread.sleep(3000);
	  logger.info("==============user click reports menu=========================");
	  rptpg.clickpjtrepts();
	  Thread.sleep(2000);
	  logger.info("==============user click project report========================");
	  rptpg.selpjt(Projectname);//con.Getactionproject()
	  Thread.sleep(2000);
	  logger.info("==============user select project ========================");
	  rptpg.clickreporttype();
	  logger.info("==============user click  report type========================");
	  rptpg.selrpttype("Progress Report");
	  Thread.sleep(2000);
	  logger.info("==============user select report type as progress report=======================");
	  rptpg.clickfromdate();
	  rptpg.typepjtfrmdate();
	  Thread.sleep(2000);
	  logger.info("==============user select From Date=======================");
	  rptpg.clicktodate();
	  Thread.sleep(2000);
	  rptpg.typepjttodate();
	  Thread.sleep(2000);
	  rptpg.clickgenerate();
	  Thread.sleep(2000);
	  logger.info("==============user click generate button======================="); 
	  
	   rptpg.selpjtrpttype("Progress");
	  Thread.sleep(2000);
	  //Thread.sleep(3000);
	   logger.info("==============user select the project report type from grid=======================");
	   
	   rptpg.selpjtreport(Projectname);//con.Getactionproject()
		  Thread.sleep(2000);
		  logger.info("==============user select the project from grid=======================");
		 
	  rptpg.clickpdfrptdonload();
	  Thread.sleep(2000);
	  logger.info("==============user click to download pdf report from grid=======================");
	  //driver.navigate().back();
	  Thread.sleep(2000);
	  
		// } }} 
     /* catch(Exception e)
		 {
			 captureScreen(driver, "WPR APPROVAL DID NOT GET");
			   Assert.assertTrue(false, "--------WPR Approve failed, No WPR data Exist----------------------------------");
    	 }	*/ 
  }
  public void clickchkboxpjtname() throws InterruptedException
  {
 	 con=new Config(pr);
 	 List<WebElement>elmgallery=driver.findElements(By.xpath("//*[@id='daily-work-progress-grid']//table//tbody//tr//td[4]"));
 	
 	 for(int i=1;i<=elmgallery.size();i++)
 	 {
 		 
 		String pjtnamerow= driver.findElement(By.xpath("//*[@id='daily-work-progress-grid']//table//tbody//tr["+i+"]//td[4]")).getText();
 		String actpjt=Projectname;//con.Getactionproject();
 		if(pjtnamerow.equals(Projectname))//con.Getactionproject()
 		{
 			WebElement currentelm=driver.findElement(By.xpath("//*[@id='daily-work-progress-grid']//table//tbody//tr["+i+"]//td[1]"));
 			currentelm.click();
 			Thread.sleep(2000);
 			break;
 		}
 	 }
  }
  
  ///*------------------------------------------------------------------------------------------------
  @Test
  public void CreateAndDownload_ProjectReport_Consolidated() throws InterruptedException//---
  {
	  Reportpage rptpg=new Reportpage(driver);
	  rptpg.clickreports();
	  Thread.sleep(2000);
	  logger.info("==============user click reports menu=========================");
	  rptpg.clickpjtrepts();
	  logger.info("==============user click project report========================");
	  rptpg.selpjt(Projectname);//con.Getactionproject()
	  logger.info("==============user select project ========================");
	  rptpg.clickreporttype();
	  logger.info("==============user click  report type========================");
	  rptpg.selrpttype("Consolidated Report");
	  logger.info("==============user consolidated report=======================");
	  rptpg.clickfromdate();
	 // rptpg.Getpjtfrmrptdate(con.getpjtfrmexmonth(),con.getpjtrptfrmexyear(),con.getpjtrptfrmexday());
	  rptpg.typepjtfrmdate();
	  logger.info("==============user select From Date=======================");
	  rptpg.clicktodate();
	  rptpg.typepjttodate();
	 // rptpg.Getpjtfrmrptdate(con.getpjttoexmonth(),con.getpjtrpttoexyear(),con.getpjtrpttoexday());
	  logger.info("==============user select To Date=======================");
	  rptpg.clickgenerate();
	  Thread.sleep(2000);
	  logger.info("==============user click generate button======================="); 
	  rptpg.selpjtreport(Projectname);//con.Getactionproject()
	  Thread.sleep(2000);
	  logger.info("==============user select the project from grid=======================");
	  rptpg.selpjtrpttype("Consolidated");
	  Thread.sleep(3000);
	  logger.info("==============user select the project report type from grid=======================");
	  //Thread.sleep(2000);
	  rptpg.clickpdfrptdonload();
	  Thread.sleep(2000);
	  logger.info("==============user click to download pdf report from grid=======================");
	  driver.navigate().back();
	  Thread.sleep(2000);
  }
 //-------------------------------------------------
  @Test
  public void CreateAndDownload_ProjectReport_Detailed() throws InterruptedException//---
  {
	   rptpg=new Reportpage(driver);
	  rptpg.clickreports();
	  Thread.sleep(2000);
	  logger.info("==============user click reports menu=========================");
	  rptpg.clickpjtrepts();
	  logger.info("==============user click project report========================");
	  rptpg.selpjt(Projectname);
	  logger.info("==============user select project ========================");
	  rptpg.clickreporttype();
	  logger.info("==============user click  report type========================");
	  rptpg.selrpttype("Detailed Report");
	  logger.info("==============user consolidated report=======================");
	  rptpg.clickfromdate();
	 // rptpg.Getpjtfrmrptdate(con.getpjtfrmexmonth(),con.getpjtrptfrmexyear(),con.getpjtrptfrmexday());
	  rptpg.typepjtfrmdate();
	  logger.info("==============user select From Date=======================");
	  rptpg.clicktodate();
	 // rptpg.Getpjtfrmrptdate(con.getpjttoexmonth(),con.getpjtrpttoexyear(),con.getpjtrpttoexday());
	  rptpg.typepjttodate();
	  logger.info("==============user select To Date=======================");
	  rptpg.clickgenerate();
	  Thread.sleep(2000);
	  logger.info("==============user click generate button=======================");
	   rptpg.selpjtrpttype("Detailed");
	  Thread.sleep(3000);
	  logger.info("==============user select the project report type from grid=======================");
	  
	  rptpg.selpjtreport(Projectname);
	  Thread.sleep(2000);
	  logger.info("==============user select the project from grid=======================");
	 
	  Thread.sleep(2000);
	  rptpg.clickpdfrptdonload();
	  Thread.sleep(2000);
	  logger.info("==============user click to download pdf report from grid=======================");
	  driver.navigate().back();
  }
  /*-------------------------------------------------
 // ------------------------------------------------------------------------------------------------
  
  @Test
  public void Download_DailypunchlogReport() throws InterruptedException
  {
	  AMSPage amspg=new AMSPage(driver);
	  amspg.ClickAMSMenu();
	  Thread.sleep(2000);
	  logger.info("==============User clicked AMS menu=========================");
	  amspg.clickdailypunchlog();
	  logger.info("==============User clicked Daily punch log=========================");
	  amspg.clickdailypunchdate();
	  logger.info("==============User click date=========================");
	 // amspg.selectpunchdate(con.getpjtrpttoexday(),con.getpjttoexmonth(),con.getpjtrpttoexyear());
	  amspg.selectpunchdate();
	  logger.info("==============User select date=========================");
	  amspg.selatttype("Punched");
	  logger.info("==============User select attendence type=========================");
	  amspg.clicksubmit();
	  logger.info("==============User click submit =========================");
	  amspg.clickpdfexport();
	  logger.info("==============User click pdf export =========================");
	  Thread.sleep(3000);
	  amspg.clickexcelexport();
	  Thread.sleep(3000);
	  logger.info("==============User click excel export =========================");
  }
  
   
  @Test
  public void PunchingReport() throws InterruptedException
  {
	 AMSPage amspg=new AMSPage(driver);
	 amspg.ClickAMSMenu();
	 Thread.sleep(2000);
	 logger.info("==============User clicked AMS menu=========================");
	 amspg.clickpunchingreport();
	 logger.info("==============User clicked punching report=========================");
	 amspg.clickstartpunchrptdate();
	 logger.info("==============User clicked punching report start date================");
	 //amspg.selpunchrptstrtdate(con.getpunchrptstartdate());
	// LocalDate Today_date=java.time.LocalDate.now();
	 amspg.selpunchrptstrtdate();
	 logger.info("==============User selected punching report start date================");
	 amspg.clickendatepunchingrpt();
	 logger.info("==============User clicked punching report end date==================");
	 amspg.selpunchrptenddate();
	// amspg.selectpunchuser(con.Getpunchusername());
	 amspg.selectpunchuser(con.Getsiteusername());
	 logger.info("==============User  select punch user========================");
	 amspg.clicksearchbtn();
	 Thread.sleep(2000);
	 logger.info("==============User  click search button========================");
	 amspg.clickpdfexportpunch();
	 Thread.sleep(2000);
	 logger.info("==============User  clicked export pdf ========================");
	 amspg.clickexcelexportpunch();
	 Thread.sleep(2000);
	 logger.info("==============User  clicked export excel ========================");
 }

  @Test
  public void EmploymonthlyReport() throws InterruptedException
  {
	   rptpg=new Reportpage(driver);
	  rptpg.clickreports();
	  Thread.sleep(2000);
	  logger.info("==============user click reports menu=========================");
	  rptpg.clickempmnthrpt();
	  logger.info("==============user click employee monthly reports =========================");
	  rptpg.selstartempmnthrptdate();
	  logger.info("==============user select start emp  date =========================");
	  rptpg.selendempmnthrptdate();
	  logger.info("==============user select end emp month date =========================");
	  rptpg.seldepartment(con.getempdepartment());
	  Thread.sleep(2000);
	  logger.info("==============user select end emp department =========================");
	  rptpg.clicksubmitemprpt();
	  Thread.sleep(2000);
	  logger.info("==============user click submit =========================");
	  rptpg.clicksaveasexcel();
	  Thread.sleep(3000);
	  logger.info("==============user click save as excel =========================");
	  driver.navigate().back();
  }
// /--------------------------------------------------------------------------------------------
   //// -------------------------------------------------*/
  @AfterMethod
  public void afterdownload() throws InterruptedException
  {
	  File listOfFiles[] = folder.listFiles();
	  logger.info("==============make sure the directory is not empty=========================");
      Assert.assertTrue(listOfFiles.length>0);
      Thread.sleep(2000);
      logger.info("==============make sure that downloaded file is not empty=========================");
      for(File file: listOfFiles){
          Assert.assertTrue(file.length()>0);
           }
   for(File file:folder.listFiles())
      {
    	  file.delete();
      }
      folder.delete();
     // logger.info("==============make sure that downloaded file is delete from the directory=========================");
      LogoutPage logout=new LogoutPage(driver);
	  logout.clickusericon();
	  logout.clickLogout();
  }
 
}
