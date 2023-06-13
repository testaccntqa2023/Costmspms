package com.bhiawpkg.Tests;

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
import com.bhiawpkg.TestBase.TestBase;
import com.bhiawpkg.Utility.XLUTILS;

public class AssignedTaskTest2 extends TestBase{
	private static Logger loger=LoggerHelper.getLogger(AssignedTaskTest2.class);
	 AssignedtaskPage AT;
	 LoginPage  bhilogin;
	 Config  con;
		
@BeforeMethod 
public void GetAddTask() 
{
			con=new Config(pr); 
			bhilogin=new LoginPage(driver);
		    bhilogin.Login(con.Getusername(),con.Getpassword()); // Thread.sleep(4000);
		   loger.info("--------Login is doing------------"); bhilogin.Clickbox();
		   loger.info("==============login is sucessful=========================");
		   loger.info("******************************Task CREATION SECTION*******************************");
		  
}
		 
  @Test(dataProvider ="Assignedtask")
  public void AssignedTask(String Pjtname,String tsktypeEx,String tsktypeIn, String maintsk,String title,String quantity,String unit,String rate,
		 String location,String area,String TaskstartExday, String TaskstartExMon,String TaskstartExYear,String TaskendExday,
		  String TaskendExMon,String TaskendExYear,String worktype,String maxworkr,String priority,String assignedto,String coordinator,
		   String tskowner,String currprogs, String milstone, String contractor,String email,String descr) throws InterruptedException
  {
		  loger.info("******************************Task CREATION SECTION**********************************"); 
		  AT=new AssignedtaskPage(driver);
		  AT.clickAssignedTaskMenu();
		  loger.info("-------User Clik Assigned Tasks-------");	
		  AT.clickAddTask();
		  loger.info("-------User clicked Add Task-------");	
		  Thread.sleep(1000);
		  AT.Toframe();	
		  loger.info("-------User switching to frame-------");	
		  Thread.sleep(2000);
		  AT.selecttaskpjt(Pjtname);
		  loger.info("-------User selecting the project-------");	
		  AT.clickExternal();
		  loger.info("-------User click task type external-------");
		  
		  AT.selectmaintask(maintsk);
		  loger.info("-------User selecting the main task-------");	
		  AT.typetasktitle(title);	
		  loger.info("----------User type the task title---------------");
		  AT.typetskquantity(quantity);
		  loger.info("----------User type the task quantity---------------");
		  AT.selectunit(unit);
		  loger.info("----------User type the task quantity---------------");
		  AT.typetaskrate(rate);
		  loger.info("----------User type the task rate---------------");
		//  AT.typetaskamount(amount);
		  loger.info("----------User type the task amount---------------");
		 AT.seltsklocation(location);	
		 loger.info("----------User select the task location---------------");
		 AT.seltaskarea(area);
		 loger.info("----------User select the task area---------------");
		 AT.clicktaskstrtdate();
		 loger.info("----------User click  the task start date---------------");
		 AT.selecttaskstartdate(TaskstartExday, TaskstartExMon, TaskstartExYear);
		 loger.info("----------User selected  the task start date---------------");
		 AT.clicktaskenddate();
		 loger.info("----------User click the task end date---------------");
		 AT.selecttaskenddate(TaskendExday, TaskendExMon, TaskendExYear);	
		 loger.info("----------User select the task end date---------------");
		// AT.typetskduration(tskduration);
		 loger.info("----------User type the task duration---------------");
		// AT.dailytrgt(dailytrgt);
		 loger.info("----------User get the task daily target---------------");
		 AT.seltaskworktype(worktype);
		 loger.info("----------User select the task work type---------------");
		// AT.typetaskreqworkers(requiredwrkr);
		 loger.info("----------User get the required workers---------------");
		 AT.typemaxtskworkers(maxworkr);
		 loger.info("----------User get the max workers---------------");
		 AT.seltskpriority(priority);
		 loger.info("----------User select the priority---------------");
		 AT.seltassignedto(assignedto);
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
		 AT.clickcreatetskbtn();
		 loger.info("----------User click the create button ---------------");
		 Thread.sleep(2000);
  }
  @DataProvider(name="Assignedtask")
  public Object[][] gettaskdetails() throws InvalidFormatException, IOException
  {
	  //String path="C:\\Users\\divya\\OneDrive\\Desktop\\Works\\PMS_WORKSPACE\\Testdata_ashlypms\\ashlypmsdata.xlsx";
	  String path=System.getProperty("user.dir")+ "/src/test/java/com/bhiawpkg/Testdata/ashlypmsdata.xlsx";
	  loger.info("file is getting!!!!!");
		  int rowcnt=XLUTILS.getrowcount(path, "AddTask1");
		  int colcnt=XLUTILS.getcellcount(path, "AddTask1",1);
		  Object [][]AddTaskdetails=new Object[rowcnt][colcnt];
		  for(int i=1;i<=rowcnt;i++)
		   {
			  for(int j=0;j<colcnt;j++)
			  {
				  AddTaskdetails[i-1][j]=XLUTILS.getCellData(path, "AddTask1", i, j);
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
		//Thread.sleep(2000);
		if(taskstatus==true)
		{
			Assert.assertTrue(true);
		loger.info("********"+result.getName() +" Details added successfully!!************");
		loger.info("**********************************************************************************************************");
		}
	else
	{
	captureScreen(driver,result.getName());
	 // Assert.assertTrue(false);
	Assert.assertTrue(false, "********"+result.getName() +" Details added  failed!!************");
	}
		Thread.sleep(2000);
		LogoutPage logout=new LogoutPage(driver);
		logout.clickusericon();
		logout.clickLogout();
		driver.get("http://stagepms.ashlyerp.xyz/index.php?r=site/login");
  }
}
