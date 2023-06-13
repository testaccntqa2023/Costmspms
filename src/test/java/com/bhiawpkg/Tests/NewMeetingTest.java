package com.bhiawpkg.Tests;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BHIAW.Helper.JavascriptHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.NewMeetingsPage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.TestBase.TestBase;
import com.bhiawpkg.Utility.XLUTILS;
import com.sun.jna.platform.unix.X11.Window;

public class NewMeetingTest extends TestBase{
	private static Logger logger=LoggerHelper.getLogger(NewMeetingTest.class);
	NewMeetingsPage Newmeet;
	 LoginPage  bhilogin;
	 Config  con;
	 JavascriptHelper js;
	 ProjectPage prpg;
	@BeforeMethod 
	public void GetAddTask() throws InterruptedException 
	{
		con=new Config(pr); 
		bhilogin=new LoginPage(driver);
	    bhilogin.Login(con.Getusername(),con.Getpassword()); 
	    logger.info("--------Login is doing------------"); 
	    bhilogin.Clickbox();
	    logger.info("==============login is sucessful=========================");
	    
		Thread.sleep(2000);
	    logger.info("******************************New Meeting Test*******************************");
	  
	}
	 ///*-------------------------------------------------------
  @Test(dataProvider = "Newmeeting")
  public void CreateNewmeeting(String Meetpjt,String Meetste,String Meetdate,String Meetvenue,String Meettime,String Meetnumber,
		  String typecntent,String cntrname,String partname,String designation,String approvedby,String milestone,String title,String strtdate,String enddate,
		  String Actionby) throws InterruptedException {
	    prpg=new ProjectPage(driver);
		prpg.clickProjectsMenu();
		logger.info("-------Clik Project Menu-------");	
		prpg.clickProjectscr();
		logger.info("-------Going to project section-------");	
		String Projectname=prpg.Getgrdpjtname();
		prpg.clickgrideditpjt();
		Thread.sleep(2000);
		prpg.clickworksitetab();
		Thread.sleep(2000);
		JavascriptHelper js=new JavascriptHelper(driver);
		js.scrollDownVertically();
		String sitename=prpg.getpjtpunchsite();
		 Newmeet=new NewMeetingsPage(driver);
		  Newmeet.clickreports();
		  Thread.sleep(2000);
		  logger.info("--------user click report menu-----------------------");
		 Newmeet.clickmeetingminutes();
		 Thread.sleep(2000);
		  logger.info("--------user click meeting minutes----------------------"); 
		  Newmeet.clickNewmeeting();
		  Thread.sleep(2000);
		  logger.info("--------user click New Meeting----------------------"); 
	  Newmeet.selmeetpjt(Projectname);
	  Thread.sleep(2000);
	  logger.info("--------user select meeting projects----------------------"); 
	  Newmeet.selmeetsite(sitename);
	  Thread.sleep(2000);
	  logger.info("--------user select meeting site----------------------");
	  Newmeet.typemeetdate();
	  Thread.sleep(2000);
	  logger.info("--------user type meeting date----------------------");
	  Newmeet.typemeetvenue(Meetvenue);
	  Thread.sleep(2000);
	  logger.info("--------user type meeting venue----------------------");
	  Newmeet.typemeettime(Meettime);
	  Thread.sleep(2000);
	  logger.info("--------user type meeting time----------------------");
	  Newmeet.typemeetnumber(Meetnumber);
	  Thread.sleep(2000);
	  logger.info("--------user type meeting number----------------------");
	  Newmeet.meettoframe();
	  Thread.sleep(2000);
	  logger.info("--------user switch to typing frame----------------------");
	 // Newmeet.typecontent(typecntent);
	  logger.info("--------user typing the content----------------------");
	  Newmeet.selmeetcntractr(cntrname);
	  Thread.sleep(2000);
	  logger.info("--------user selecting the contractor name---------------------");
	  Newmeet.typeparticipant(partname);
	  Thread.sleep(2000);
	  logger.info("--------user type participant----------------------");
	//  driver.findElement(By.xpath("//*[@class='select2-selection select2-selection--multiple']//ul//li[@title='"+con.Getsiteusername()+"  (SITE ENGINEER)"+"']"));
	 // Newmeet.clickapproveby();
	  Newmeet.typepartidesgn(designation);
	  String appruser1="//*[@class='select2-selection select2-selection--multiple']//ul//li[@title='";
		String appruser2="']";
	//  driver.findElement(By.xpath("appruser1"+ "ciril  (SITE ENGINEER)"+"+appruser2")).click();
	  Newmeet.selusersapproveby(approvedby);
	  Thread.sleep(2000);
	  Newmeet.clicknextbtn();
	  logger.info("--------user click next button----------------------");
	  Thread.sleep(3000);
	 // Newmeet.clickstep2();
	 // logger.info("--------user click step2----------------------");
	  Newmeet.selmeetmilestone(milestone);
	  logger.info("----------user select milestone--------------------------");
	  Thread.sleep(2000);
	  Newmeet.Typemeettitle(title);
	  logger.info("----------user type title-------------------------");
	  Newmeet.typestrtdate();
	  logger.info("----------user type start date-------------------------");
	  Newmeet.typeenddate();
	  logger.info("----------user type end date-------------------------");
	  Newmeet.pointdiscussed();
	  logger.info("----------user enter points to discuss------------------------");
	  Thread.sleep(2000);
	  Newmeet.selactionby(Actionby);
	  Thread.sleep(2000);
	  logger.info("----------user select action by user------------------------");
	  js=new JavascriptHelper(driver);
		js.executeScript("window.scrollBy(0,140)");
		 Thread.sleep(2000);
	  Newmeet.clickmilestonenxt();
	 logger.info("----------user click next button------------------------");
	  js.scrollUpByPixel();
	  Thread.sleep(2000);
	  Newmeet.selrept();
	  Thread.sleep(2000);
	  Newmeet.clickgobtn();
	  Thread.sleep(2000);
	  js.scrollDownVertically();
	  Newmeet.clicksubmit();
	  Thread.sleep(2000);
	 // Newmeet.clicksavebtn();
	   logger.info("----------new meeting creation done successfully-----------------------");
	   js.scrollUpVertically();
	  Newmeet.clickstep4();
	  Thread.sleep(2000);
	  logger.info("--------user click step4----------------------");
	  Newmeet.typenextmeetdate();
	  Thread.sleep(2000);
	  logger.info("--------user enter next meet date---------------------");
	  Newmeet.typenxtmeettime("09:00");
	  Thread.sleep(2000);
	  logger.info("--------user enter next meet time---------------------");
	  Newmeet.typenextmeetlocation("Kochi");
	  Thread.sleep(2000);
	  logger.info("--------user enter next meet location---------------------");
	  Newmeet.Nextmeetingcontent();
	  Thread.sleep(2000);
	  logger.info("--------user enter next meet content---------------------");
	  js.scrollDownVertically();
	  Thread.sleep(2000);
	 // js=new JavascriptHelper(driver);
	// js.executeScript("window.scrollBy(0,170)");
	  
	  Newmeet.clicknextmeetsavebtn();
	  Thread.sleep(3000);
	  logger.info("--------user click save button---------------------");
	  logger.info("--------Next meeting creation done successfully---------------------");
  }
  

  @DataProvider(name="Newmeeting")
  public Object[][] gettaskdetails() throws InvalidFormatException, IOException
  {
	  String path=System.getProperty("user.dir")+ "/src/test/java/com/bhiawpkg/Testdata/ashlypmsdata.xlsx";
	  logger.info("file is getting!!!!!");
		  int rowcnt=XLUTILS.getrowcount(path, "NewMeeting");
		  int colcnt=XLUTILS.getcellcount(path, "NewMeeting",1);
		  Object [][]AddTaskdetails=new Object[rowcnt][colcnt];
		  for(int i=1;i<=rowcnt;i++)
		   {
			  for(int j=0;j<colcnt;j++)
			  {
				  AddTaskdetails[i-1][j]=XLUTILS.getCellData(path, "NewMeeting", i, j);
			  }
		  }
		  logger.info("Excel data is returned");
		  return AddTaskdetails;
  }
  
  

  @Test
  public void MinutesOf_MeetingApproval() throws InterruptedException, IOException
  {
	  prpg=new ProjectPage(driver);
		prpg.clickProjectsMenu();
		logger.info("-------Clik Project Menu-------");	
		prpg.clickProjectscr();
		logger.info("-------Going to project section-------");	
		String Projectname=prpg.Getgrdpjtname();
		Thread.sleep(2000);
		String username=prpg.Getgrdpjtusername();
		Thread.sleep(2000);
		 Newmeet=new NewMeetingsPage(driver);
		  Newmeet.clickreports();
		  Thread.sleep(2000);
		  logger.info("--------user click report menu-----------------------");
		 Newmeet.clickmeetingminutes();
		 Thread.sleep(2000);
		  logger.info("--------user click meeting minutes----------------------"); 
		  Newmeet.shiftuser(username);
		  Thread.sleep(2000);
		  Newmeet.selgrdmeetpjtname(Projectname);
		  Thread.sleep(2000);
		  int pendingstatuscnt = driver.findElements(By.xpath("//*[@id='site-meetings-grid']//table//tbody//tr//td[7]//div//span[text()='Pending']")).size();
		  String momstatus=Newmeet.getstatusmom();
		  try {
		  if(momstatus.equals("Pending"))
		  {
			  Newmeet.selpendingstatus("Pending");//----
			  Thread.sleep(2000);
		   for(int i=1;i<=1;i++)
		   {
			   Newmeet.clickpendchkmom();
			   Thread.sleep(2000);
			   Newmeet.typeadvsearch();
			   Newmeet.clickapprovebtn();
			Assert.assertTrue(true);
		   }
		  }
		  }catch(Exception ex)
		  {
			  captureScreen(driver, "MOM_APPROVAL");
			  Assert.assertTrue(false, "----------No pending status exist or user does not create project detailed report----------------------------");
		  }
		
  }
//--------------------------------------------------------------------*/
	@Test
	  public void Edit_Meeting() throws InterruptedException
	  {
		    prpg=new ProjectPage(driver);
			prpg.clickProjectsMenu();
			logger.info("-------Clik Project Menu-------");	
			prpg.clickProjectscr();
			logger.info("-------Going to project section-------");	
			String Projectname=prpg.Getgrdpjtname();
			prpg.clickgrideditpjt();
			Thread.sleep(2000);
			prpg.clickworksitetab();
			Thread.sleep(2000);
			JavascriptHelper js=new JavascriptHelper(driver);
			js.scrollDownVertically();
			String sitename=prpg.getpjtpunchsite();
			 Newmeet=new NewMeetingsPage(driver);
			  Newmeet.clickreports();
			  Thread.sleep(2000);
			  logger.info("--------user click report menu-----------------------");
			 Newmeet.clickmeetingminutes();
			 Thread.sleep(2000);
			  logger.info("--------user click meeting minutes----------------------"); 
			  Newmeet.selgrdmeetpjtname(Projectname);
			  Thread.sleep(2000);
			  Newmeet.clickupdtebtn();
			  logger.info("------------click update button--------------------------");
			  Newmeet.clicknextbtn();
			  Thread.sleep(2000);
			  Newmeet.clickgrdeditbtn();
			  Thread.sleep(2000);
			  js.scrollUpVertically();
			  Thread.sleep(2000);
			  Newmeet.editpointdiscussed();
			  Thread.sleep(2000);
			  js.scrollDownVertically();
			  Thread.sleep(2000);
			  Newmeet.clickstep2nxtbtn();
			  Thread.sleep(2000);
			  js.scrollUpVertically();
			  Thread.sleep(2000);
			  Newmeet.clickstep4();
			  Thread.sleep(2000);
			  logger.info("--------user click step4----------------------");
			  js.scrollDownVertically();
			  Thread.sleep(2000);
			  Newmeet.clickupdatestep4savebtn();
			  Thread.sleep(3000);
			  logger.info("--------user click save button---------------------");
			  logger.info("--------meeting updated successfully---------------------");
			  
	  }
  @Test
  public void MinutesOf_Meetingaddtask() throws InterruptedException, IOException
  {
	  prpg=new ProjectPage(driver);
		prpg.clickProjectsMenu();
		logger.info("-------Clik Project Menu-------");	
		prpg.clickProjectscr();
		logger.info("-------Going to project section-------");	
		String Projectname=prpg.Getgrdpjtname();
		Thread.sleep(2000);
		String username=prpg.Getgrdpjtusername();
		Thread.sleep(2000);
		prpg.clickgrideditpjt();
		Thread.sleep(2000);
		prpg.clickworksitetab();
		Thread.sleep(2000);
		JavascriptHelper js=new JavascriptHelper(driver);
		js.scrollDownVertically();
		String sitename=prpg.getpjtpunchsite();
		 Newmeet=new NewMeetingsPage(driver);
		Newmeet=new NewMeetingsPage(driver);
		  Newmeet.clickreports();
		  Thread.sleep(2000);
		  logger.info("--------user click report menu-----------------------");
		 Newmeet.clickmeetingminutes();
		 Thread.sleep(2000);
		  logger.info("--------user click meeting minutes----------------------");
		  Newmeet.selgrdmeetpjtname(Projectname);
		  Thread.sleep(2000);
		 // int pendingstatuscnt = driver.findElements(By.xpath("//*[@id='site-meetings-grid']//table//tbody//tr//td[7]//div//span[text()='Approved']")).size();
		  String apprstatus=driver.findElement(By.xpath("//*[@id='site-meetings-grid']//table//tbody//tr//td[7]//div//span")).getText();
		 // String momstatus=Newmeet.getstatusmom();
		  try {
		  if(apprstatus.equals("Approved"))
		  {
			  Newmeet.clickupdtebtn();
			  logger.info("------------click update button--------------------------");
			  Newmeet.clickstep2();
			  logger.info("------------user click step2 button--------------------------");
			  Thread.sleep(2000);
			  js.scrollDownVertically();
			  Newmeet.clickaddtaskstep2();
			  logger.info("------------click add button--------------------------");
			  Thread.sleep(2000);
			  //Newmeet.Toframe();
			  Thread.sleep(2000);
			  Newmeet.selformpjt(Projectname);
			  logger.info("------------user select the project--------------------------");
			  Thread.sleep(2000);
			  Newmeet.selformmaintsk();
			  logger.info("------------user select main task--------------------------");
			  Thread.sleep(2000);
			  Newmeet.typeformtitle("Roof covering"+RandomStringUtils.randomAlphabetic(2));
			  logger.info("------------user type title--------------------------");
			  Thread.sleep(2000);
			  Newmeet.typequantity();
			  logger.info("------------user type quantity--------------------------");
			  Thread.sleep(2000);
			  Newmeet.seltskunit("Sq Ft");
			  logger.info("------------user select unit--------------------------");
			  Thread.sleep(2000);
			  Newmeet.typeformtskrate();
			  logger.info("------------user type rate--------------------------");
			  Thread.sleep(2000);
			  Newmeet.selformsite(sitename);//
			  logger.info("------------user select site-------------------------");
			  Thread.sleep(2000);
			  Newmeet.selformarea();
			  logger.info("------------user select the area-------------------------");
			  Thread.sleep(2000);
			  js.scrollDownByPixel();
			  Newmeet.selformworktype("TOUGHEN GLASS WORKS");
			  logger.info("------------user choose  work type--------------------------");
			  Thread.sleep(2000);
			  Newmeet.typeformmaxwrks();
			  logger.info("------------user type maximum workers--------------------------");
			  Newmeet.selformassgnto(username);
			  logger.info("------------user choose assigned users--------------------------");
			  Thread.sleep(2000);
			  Newmeet.selformcontractor("Astle");
			  logger.info("------------user select the contractor name--------------------------");
			  Thread.sleep(2000);
			 // js.scrollDownByPixel();
			  Newmeet.typeformemail("diva123@gmail.com");
			  logger.info("------------user type email--------------------------");
			  Newmeet.clickcreatebtn();
			  logger.info("-------------user click the create button------------------");
			  Thread.sleep(3000);
			  logger.info("-------------task added successfully------------------");
			  Thread.sleep(2000);
			  Assert.assertTrue(true);
		  }
		 }
		  catch(Exception ex)
		  {
			  captureScreen(driver, "MOM_ADDTASK");
			  Assert.assertTrue(false, "----------something went wrong , user cannot add task from the MOM section----------------------------");
		  
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




