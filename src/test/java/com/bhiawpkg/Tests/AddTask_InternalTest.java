package com.bhiawpkg.Tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.AssignedtaskPage;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.TestBase.TestBase;
import com.bhiawpkg.Utility.XLUTILS;

public class AddTask_InternalTest extends TestBase {
	private static Logger loger=LoggerHelper.getLogger(AddTask_InternalTest.class);
	 AssignedtaskPage AT;
	 LoginPage  bhilogin;
	 Config  con;
	 ProjectPage prpg;
	@BeforeMethod 
	public void GetAddTask() 
	{
		con=new Config(pr); 
		bhilogin=new LoginPage(driver);
	    bhilogin.Login(con.Getusername(),con.Getpassword()); // Thread.sleep(4000);
	    loger.info("--------Login is doing------------"); 
	    //bhilogin.Clickbox();
	    loger.info("==============login is sucessful=========================");
	    loger.info("******************************Task CREATION SECTION*******************************");
	  
	}
	@Test(dataProvider ="Assignedtask")
	  public void AssignedTask_internal(String Pjtname,String tsktypeIn, String maintsk,String title,String quantity,String unit,String rate,
			  String amount,String location,String area,String TaskstartDate, String TaskendDate,
			  String tskduration, String dailytrgt,
			  String worktype,String requiredwrkr,String maxworkr,String priority,String assignedto,String coordinator,
			   String tskowner,String currprogs, String milstone, String contractor,String email,String descr) throws InterruptedException, AWTException
	  {
			   
			  loger.info("******************************Task CREATION SECTION**********************************"); 
			  loger.info("-------To get project name and site name-------");	
			    prpg=new ProjectPage(driver);
				prpg.clickProjectsMenu();
				loger.info("-------Clik Project Menu-------");	
				con=new Config(pr);
				String pjtname= con.Getactionproject();
				impliciteWait(30);
				prpg.clickProjectscr();
				loger.info("-------Going to project section-------");	
				prpg.searchPjtname(pjtname);
				impliciteWait(30);
				//String Projectname=prpg.Getgrdpjtname();
				prpg.clickgrideditpjt();
				impliciteWait(30);
				 prpg.clickworktypetab();
				impliciteWait(30);
				loger.info("-------User clicked work type details tab ------------------");  
				String worktypename=prpg.getworktypename();
				impliciteWait(30);
				prpg.clickworksitetab();
				impliciteWait(30);
				String sitename=prpg.getpjtpunchsite();
				impliciteWait(30);
				impliciteWait(30);
				prpg.clickareatab();
				impliciteWait(30);
				loger.info("-------User clicked area details tab ------------------");
				String areaname=prpg.getpjtpuncharea();
				impliciteWait(30);
			  AT=new AssignedtaskPage(driver);
			  AT.clickAssignedTaskMenu();
			  loger.info("-------User Clik Assigned Tasks-------");	
			  AT.clickAddTask();
			  loger.info("-------User clicked Add Task-------");	
			  Thread.sleep(1000);
			  AT.Toframe();	
			  loger.info("-------User switching to frame-------");	
			  impliciteWait(30);
			  AT.selecttaskpjt(pjtname);
			  loger.info("-------User selecting the project-------");	
			  AT.clickInternal();
			  loger.info("-------User click task type external-------");
			 //  AT.selectmaintask(maintsk);
			 // loger.info("-------User selecting the main task-------");	
			  AT.typetasktitle(title);	
			  loger.info("----------User type the task title---------------");
			  AT.typetskquantity(quantity);
			  loger.info("----------User type the task quantity---------------");
			  AT.selectunit(unit);
			  loger.info("----------User type the task quantity---------------");
			 // AT.typetaskrate(rate);
			 // loger.info("----------User type the task rate---------------");
			 // AT.typetaskamount(amount);
			//  loger.info("----------User type the task amount---------------");
			// AT.seltsklocation(sitename);	
			// loger.info("----------User select the task location---------------");
			// AT.seltaskarea(area);
			// loger.info("----------User select the task area---------------");
			 AT.clicktaskstrtdate();
			 loger.info("----------User click  the task start date---------------");
			// AT.selecttaskstartdate(TaskstartExday, TaskstartExMon, TaskstartExYear);
			// AT.selecttaskstartdate1();
			 loger.info("----------User selected  the task start date---------------");
			// AT.Typetaskstartdate(pjtstart_date);
				impliciteWait(30);
				 loger.info("----------User selected  the task start date---------------");
				// AT.clicktaskenddate();
				 loger.info("----------User click the task end date---------------");
				// AT.selecttaskenddate(TaskendExday, TaskendExMon, TaskendExYear);	
				// AT.selecttaskenddate1();
				// AT.selecttaskenddate1(rate);tskduration, dailytrgt
				// AT.Typetaskendate(pjtend_date);
				 impliciteWait(30);
			 loger.info("----------User select the task end date---------------");
			 AT.typetskduration();
			 impliciteWait(20);
			 loger.info("----------User type the task duration---------------");
			 AT.dailytrgt();
			 impliciteWait(20);
			 loger.info("----------User get the task daily target---------------");
			// AT.seltaskworktype(worktype);
			 loger.info("----------User select the task work type---------------");
			// AT.typetaskreqworkers(requiredwrkr);
			 loger.info("----------User get the required workers---------------");
			// AT.typemaxtskworkers(maxworkr);
			 loger.info("----------User get the max workers---------------");
			 AT.seltskpriority(priority);
			 loger.info("----------User select the priority---------------");
			// AT.seltassignedto(assignedto);
			AT.seltassignedto1(assignedto);
			 loger.info("----------User select the assigned users ---------------");
			 AT.seltskcoordinator(coordinator);
			 loger.info("----------User select the task coordinator ---------------");
			 AT.seltskowner(tskowner);
			 loger.info("----------User select the task owner---------------");
			 AT.seltskprogress(currprogs);
			 loger.info("----------User select the current progress ---------------");
			 AT.seltskmilestone(milstone);
			 loger.info("----------User select the task milestone ---------------");
			 AT.seltskcontractor(contractor);
			 loger.info("----------User select the task contractors ---------------");
			 AT.typeemail(email);
			 loger.info("-------------user enter task email------------------");
			 AT.typetaskdecription(descr);	
			 loger.info("-------------user enter task description------------------");
			 Robot robo=new Robot();
			  robo.keyPress(KeyEvent.VK_CONTROL);
			  robo.keyPress(KeyEvent.VK_MINUS);
			  robo.keyRelease(KeyEvent.VK_CONTROL);
			  robo.keyRelease(KeyEvent.VK_MINUS);
			  robo.keyPress(KeyEvent.VK_CONTROL);
			  robo.keyPress(KeyEvent.VK_MINUS);
			  robo.keyRelease(KeyEvent.VK_CONTROL);
			  robo.keyRelease(KeyEvent.VK_MINUS);
			 AT.clickcreatetskbtn();
			 loger.info("----------User click the create button ---------------");
			 Thread.sleep(3000);
	  }
	  @DataProvider(name="Assignedtask")
	  public Object[][] gettaskdetails() throws InvalidFormatException, IOException
	  {
		  String path=System.getProperty("user.dir")+ "/src/test/java/com/bhiawpkg/Testdata/ashlypmsdata.xlsx";
		  loger.info("file is getting!!!!!");
			  int rowcnt=XLUTILS.getrowcount(path, "AddTask_Internal");
			  int colcnt=XLUTILS.getcellcount(path, "AddTask_Internal",1);
			  Object [][]AddTaskdetails=new Object[rowcnt][colcnt];
			  for(int i=1;i<=rowcnt;i++)
			   {
				  for(int j=0;j<colcnt;j++)
				  {
					  AddTaskdetails[i-1][j]=XLUTILS.getCellData(path, "AddTask_Internal", i, j);
				  }
			  }
			  loger.info("Excel data is returned");
			  return AddTaskdetails;
	  }
@AfterMethod
	  public void Verifysuccessful(ITestResult result) throws IOException, InterruptedException
	  {
		   AT=new AssignedtaskPage(driver);
		  boolean taskstatus=AT.verifysuccessfull();
			loger.info("-------Verifying "+result.getName()+ " -------");
			//impliciteWait(30);
			if(taskstatus==true)
			{
			loger.info("********"+result.getName() +" Details added successfully!!************");
			loger.info("**********************************************************************************************************");
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
			driver.get("http://costmspms.bhiapp.net/pms/");
	  }

}
