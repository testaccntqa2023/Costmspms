package com.bhiawpkg.Tests;

import java.io.IOException;
import java.time.LocalDate;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.AllWorkProgressfilterPage;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.LogoutPage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.Pages.TimeEntryPage;
import com.bhiawpkg.Pages.WPRPage;
import com.bhiawpkg.TestBase.TestBase;

public class AllWorkProgressfilterTest extends TestBase {
	 private static Logger logger=LoggerHelper.getLogger(AllWorkProgressfilterTest.class);
	 LoginPage  bhilogin;
	 Config  con;
	 WPRPage wprpg;
	 String Projectname;
	 ProjectPage prpg;
	 AllWorkProgressfilterPage awrkpgrfiltrpg;
	 @BeforeMethod
public void Login() 
{
	con=new Config(pr); 
	bhilogin=new LoginPage(driver);
    bhilogin.Login(con.Getusername(),con.Getpassword());
    logger.info("--------Login is doing------------");
    bhilogin.Clickbox();
    logger.info("==============login is sucessful=========================");
		    
}
//	 /*-------------------------------------------------------------------------------
  @Test
  public void AllWorkProgressFilter() throws InterruptedException, IOException 
  {
	  try {
		  prpg=new ProjectPage(driver);
		  prpg.clickProjectsMenu();
			logger.info("-------Clik Project Menu-------");	
			prpg.clickProjectscr();
			logger.info("-------Going to project section-------");	
			 Projectname=prpg.Getgrdpjtname();
			prpg.clickgrideditpjt();
			Thread.sleep(2000);
	 wprpg=new WPRPage(driver);
	 wprpg.clickWPRMenu();
	 logger.info("---------------------user click wpr menu---------------------------");
	 wprpg.clickallworkprogress();
	 Thread.sleep(2000);
	 logger.info("---------------------user click all work progress--------------------------");
	 awrkpgrfiltrpg=new AllWorkProgressfilterPage(driver);
	 awrkpgrfiltrpg.selwrkprgpjt(Projectname);
	 logger.info("---------------------user select the project--------------------------");
	 Thread.sleep(2000);
	 String pjtname=Projectname;
	 driver.navigate().refresh();
	 awrkpgrfiltrpg.seltask();
	 Thread.sleep(2000);
	 logger.info("---------------------user select the task--------------------------");
	 //Thread.sleep(2000);
	// String createduser=awrkpgrfiltrpg.Getuser();
	 awrkpgrfiltrpg.selwprprguser(con.Getsiteusername());
	 Thread.sleep(2000);
	 logger.info("---------------------user select the user--------------------------");
	// String grddate=awrkpgrfiltrpg.Getdate();
	 awrkpgrfiltrpg.Typefromdate();
	 logger.info("---------------------user type from date --------------------------");
	 Thread.sleep(2000);
	 awrkpgrfiltrpg.Typetodate();
	 Thread.sleep(2000);
	 awrkpgrfiltrpg.clickgobtn();
	 Thread.sleep(2000);
	 logger.info("-------------All WORK PROGRESS SEARCHING DONE SUCCESSFULLY!!! --------------------------");
	 Assert.assertTrue(true);
	
	  }
	  catch(Exception e)
	  {
		  captureScreen(driver, "All Work Progress Filter Section");
		  logger.info("-------------NO DATA EXIST OR All WORK PROGRESS SEARCHING FAILED --------------------------");
		  Assert.assertTrue(false, "-----NO DATA EXIST OR All WORK PROGRESS SEARCHING FAILED --------------");
	  }
	 
  }
//  /------------------------------------------------------------------------------*/
  @Test
  public void ClearWorkProgressFilter() throws InterruptedException
  {
	  prpg=new ProjectPage(driver);
	  prpg.clickProjectsMenu();
		logger.info("-------Clik Project Menu-------");	
		prpg.clickProjectscr();
		logger.info("-------Going to project section-------");	
		 Projectname=prpg.Getgrdpjtname();
	     wprpg=new WPRPage(driver);
		 wprpg.clickWPRMenu();
		 logger.info("---------------------user click wpr menu---------------------------");
		 wprpg.clickallworkprogress();
		 logger.info("---------------------user click all work progress--------------------------");
		 awrkpgrfiltrpg=new AllWorkProgressfilterPage(driver);
		 awrkpgrfiltrpg.selwrkprgpjt(Projectname);
		 logger.info("---------------------user select the project--------------------------");
		 Thread.sleep(2000);
		 String pjtname=Projectname;
		 driver.navigate().refresh();
		 awrkpgrfiltrpg.seltask();
		 logger.info("---------------------user select the task--------------------------");
		 Thread.sleep(2000);
		// String createduser=awrkpgrfiltrpg.Getuser();
		 awrkpgrfiltrpg.selwprprguser(con.Getsiteusername());
		 Thread.sleep(2000);
		 logger.info("---------------------user select the user--------------------------");
		// String grddate=awrkpgrfiltrpg.Getdate();
		 awrkpgrfiltrpg.Typefromdate();
		 logger.info("---------------------user type from date --------------------------");
		 Thread.sleep(2000);
		 awrkpgrfiltrpg.Typetodate();
		 Thread.sleep(2000);
		 awrkpgrfiltrpg.clickclearbutton();
		 Thread.sleep(2000);
	     awrkpgrfiltrpg.Clearwrkpgrssearchfilter();
	     Thread.sleep(2000);
	     logger.info("---------------------Filter section cleared successfully!!!-------------------------");
  }
  @AfterMethod
  public void Logout()
  {
	  LogoutPage logout=new LogoutPage(driver);
	  logout.clickusericon();
	  logout.clickLogout();
  }
  
}
