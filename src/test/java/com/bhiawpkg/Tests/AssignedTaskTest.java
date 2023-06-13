package com.bhiawpkg.Tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
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
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.TestBase.TestBase;
import com.bhiawpkg.Utility.XLUTILS;

public class AssignedTaskTest extends TestBase{
	private static Logger logger=LoggerHelper.getLogger(AssignedTaskTest.class);
	ProjectPage prpg;
	 AssignedtaskPage AT;
	 LoginPage  bhilogin;
	 Config  con;
		
@BeforeMethod 
public void GetAddTask() 
{
			con=new Config(pr); 
			bhilogin=new LoginPage(driver);
		    bhilogin.Login(con.Getusername(),con.Getpassword()); 
		   logger.info("--------Login is doing------------");
		 //  bhilogin.Clickbox();
		   logger.info("==============login is sucessful=========================");
		  // logger.info("******************************Task CREATION SECTION*******************************");
		  
}
		 
  @Test(dataProvider ="Assignedtask")
  public void AssignedTask(String Pjtname,String tsktypeEx,String maintsk,String title,String quantity,String unit,String rate,
		  String amount,String location,String area,String TaskstartDate,String TaskendDate,String tskduration, String dailytrgt,
		  String worktype,String requiredwrkr,String maxworkr,String priority,String assignedto,String coordinator,
		   String tskowner,String currprogs, String milstone, String contractor,String email,String descr) throws InterruptedException, IOException, AWTException
  {
		 logger.info("******************************Task CREATION SECTION**********************************"); 
		 logger.info("-------To get project name and site name-------");	
		    prpg=new ProjectPage(driver);
			prpg.clickProjectsMenu();
			logger.info("-------Clik Project Menu-------");	
			con=new Config(pr);
			 String pjtname= con.Getactionproject();
			prpg.clickProjectscr();
			logger.info("-------Going to project section-------");	
			prpg.searchPjtname(pjtname);
			impliciteWait(30);
			//String Projectname=prpg.Getgrdpjtname();
			prpg.clickgrideditpjt();
			impliciteWait(30);
			prpg.clickworksitetab();
			impliciteWait(30);
			String sitename=prpg.getpjtpunchsite();
			impliciteWait(30);
		  AT=new AssignedtaskPage(driver);
		  AT.clickAssignedTaskMenu();
		  logger.info("-------User Clik Assigned Tasks-------");	
		  Robot robo=new Robot();
		  robo.keyPress(KeyEvent.VK_CONTROL);
		  robo.keyPress(KeyEvent.VK_MINUS);
		  robo.keyRelease(KeyEvent.VK_CONTROL);
		  robo.keyRelease(KeyEvent.VK_MINUS);
		  robo.keyPress(KeyEvent.VK_CONTROL);
		  robo.keyPress(KeyEvent.VK_MINUS);
		  robo.keyRelease(KeyEvent.VK_CONTROL);
		  robo.keyRelease(KeyEvent.VK_MINUS);
		  AT.clickAddTask();
		  logger.info("-------User clicked Add Task-------");	
		  impliciteWait(20);
		   AT.Toframe();	
		  logger.info("-------User switching to frame-------");	
		  impliciteWait(30);
		  AT.selecttaskpjt(pjtname);
		  logger.info("-------User selecting the project-------");	
		  AT.clickExternal();
		  logger.info("-------User click task type external-------");
		   AT.selectmaintask(maintsk);
		  logger.info("-------User selecting the main task-------");	
		  AT.typetasktitle(title);	
		  logger.info("----------User type the task title---------------");
		  AT.typetskquantity(quantity);
		  logger.info("----------User type the task quantity---------------");
		/*  try {
			  if(!AT.Gettaskexist().isDisplayed())
			  {*/
				  
			impliciteWait(30);
		  AT.selectunit(unit);
		  logger.info("----------User type the task quantity---------------");
		  AT.typetaskrate(rate);
		  logger.info("----------User type the task rate---------------");
		  AT.typetaskamount(amount);
		  logger.info("----------User type the task amount---------------");
		 AT.seltsklocation(sitename);	
		 logger.info("----------User select the task location---------------");
		 AT.seltaskarea(area);
		 logger.info("----------User select the task area---------------");
		 AT.clicktaskstrtdate();
		 logger.info("----------User click  the task start date---------------");
		 //AT.selecttaskstartdate(TaskstartExday, TaskstartExMon, TaskstartExYear);
		 AT.selecttaskstartdate1();
		 logger.info("----------User selected  the task start date---------------");
		 AT.clicktaskenddate();
		 logger.info("----------User click the task end date---------------");
		// AT.selecttaskenddate(TaskendExday, TaskendExMon, TaskendExYear);	
		 AT.selecttaskenddate1();
		 impliciteWait(30);
		 logger.info("----------User select the task end date---------------");
		 AT.typetskduration();
		 impliciteWait(30);
		 logger.info("----------User type the task duration---------------");
		 AT.dailytrgt();
		 logger.info("----------User get the task daily target---------------");
		 //AT.seltaskworktype(worktype);//	Electrical works
		 AT.seltaskworktype("Electrical works");
		 impliciteWait(30);
		 logger.info("----------User select the task work type---------------");
		 AT.typetaskreqworkers();
		 logger.info("----------User get the required workers---------------");
		 AT.typemaxtskworkers(maxworkr);
		 logger.info("----------User get the max workers---------------");
		 AT.seltskpriority(priority);
		 logger.info("----------User select the priority---------------");
		 AT.seltassignedto(assignedto);
		 logger.info("----------User select the assigned users ---------------");
		 AT.seltskcoordinator(coordinator);
		 logger.info("----------User select the task coordinator ---------------");
		 AT.seltskowner(tskowner);
		 logger.info("----------User select the task owner---------------");
		 AT.seltskprogress(currprogs);
		 logger.info("----------User select the current progress ---------------");
		 AT.seltskmilestone(milstone);
		 logger.info("----------User select the task milestone ---------------");
		 AT.seltskcontractor(contractor);
		 impliciteWait(30);
		 logger.info("----------User select the task contractors ---------------");
		 AT.typeemail(email);
		 logger.info("-------------user enter task email------------------");
		 AT.typetaskdecription(descr);	
		 logger.info("-------------user enter task description------------------");
		 impliciteWait(30);
		 WebElement elem=driver.findElement(By.xpath("//*[@class='btn blue save_btn']"));
		 JavascriptHelper jscr=new JavascriptHelper(driver);
		 jscr.scrollDownByPixel();
		 impliciteWait(30);
			jscr.scrollToElemet(elem);
			  robo=new Robot();
			  robo.keyPress(KeyEvent.VK_CONTROL);
			  robo.keyPress(KeyEvent.VK_MINUS);
			  robo.keyRelease(KeyEvent.VK_CONTROL);
			  robo.keyRelease(KeyEvent.VK_MINUS);
			  robo.keyPress(KeyEvent.VK_CONTROL);
			  robo.keyPress(KeyEvent.VK_MINUS);
			  robo.keyRelease(KeyEvent.VK_CONTROL);
			  robo.keyRelease(KeyEvent.VK_MINUS);
			  AT.clickcreatetskbtn();
			  logger.info("----------User click the create button ---------------");
			  impliciteWait(30);
	
  }

 
  @DataProvider(name="Assignedtask")
  public Object[][] gettaskdetails() throws InvalidFormatException, IOException
  {
	  String path=System.getProperty("user.dir")+ "/src/test/java/com/bhiawpkg/Testdata/ashlypmsdata.xlsx";
	  logger.info("file is getting!!!!!");
		  int rowcnt=XLUTILS.getrowcount(path, "AddTask");
		  int colcnt=XLUTILS.getcellcount(path, "AddTask",1);
		  Object [][]AddTaskdetails=new Object[rowcnt][colcnt];
		  for(int i=1;i<=rowcnt;i++)
		   {
			  for(int j=0;j<colcnt;j++)
			  {
				  AddTaskdetails[i-1][j]=XLUTILS.getCellData(path, "AddTask", i, j);
			  }
		  }
		  logger.info("Excel data is returned");
		  return AddTaskdetails;
  }
  @AfterMethod
  public void Verifysuccessful(ITestResult result) throws IOException, InterruptedException
  {
	   AT=new AssignedtaskPage(driver);
	  boolean taskstatus=AT.verifysuccessfull();
	  impliciteWait(30);
		logger.info("-------Verifying "+result.getName()+ " -------");
		//impliciteWait(30);
		if(taskstatus==true)
		{
		logger.info("********"+result.getName() +" Details added successfully!!************");
		impliciteWait(30);
		logger.info("**********************************************************************************************************");
		Assert.assertTrue(true);
		}
	else
	{
	captureScreen(driver,result.getName());
	 // Assert.assertTrue(false);
	Assert.assertTrue(false, "********"+result.getName() +" Details added  failed!!************");
	}
		impliciteWait(30);
		LogoutPage logout=new LogoutPage(driver);
		logout.clickusericon();
		impliciteWait(30);
		logout.clickLogout();
		impliciteWait(30);
		driver.get("http://stagepms.ashlyerp.xyz/index.php?r=site/login");
  }
}
