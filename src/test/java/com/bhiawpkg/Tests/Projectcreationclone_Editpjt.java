package com.bhiawpkg.Tests;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
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
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.TestBase.TestBase;
import com.bhiawpkg.Utility.XLUTILS;

public class Projectcreationclone_Editpjt extends TestBase  {
	private static Logger logger = LoggerHelper.getLogger(Projectcreationclone_Editpjt.class);
	ProjectPage prpg;
	Config con;

	@BeforeMethod
	public void Login() {
		LoginPage bhilogin = new LoginPage(driver);

		con = new Config(pr);
		bhilogin.Login(con.Getusername(), con.Getpassword());
		// Thread.sleep(4000);
		logger.info("--------Login is doing------------");
		bhilogin.Clickbox();
		logger.info("==============login is sucessful=========================");

	}
	
/*	@Test(dataProvider ="ProjectDetails")
  public void ProjectCreation_cloneEdit(String Projectname,String Clientname,String Billable,String Status,String PjtstartDate, String PjtendDate,String Budget,String TotalSquareFeet,
		  String AssignedPjtmanagers,String Description,String milestonetitle,String milestonepjt,String PjtMstartDate,String PjtMendDate,
		  String taskpjt,String tasktitle,String taskmilestone,String TaskstartDate, String TaskendDate, String Areatitle,String AreaPjt,String Areastatus,String WorkTypepjt,String Worktype1,String Worktyperank,
		  String sitename,String sitepjt,String sitelattitude,String sitelongitude,String assignedsiteusers,String punchinradius) throws InterruptedException, IOException, FindFailed */
  @Test
  public void ProjectCreation_cloneEdit() throws InterruptedException
	{
	  JavascriptHelper jspjt=new JavascriptHelper(driver);
 		logger.info("******************************PROJECT CREATION SECTION**********************************");
		 prpg=new ProjectPage(driver);
		prpg.clickProjectsMenu();
		logger.info("-------Clik Project Menu-------");	
		prpg.clickProjectscr();
		logger.info("-------Going to project section-------");
		String clonepjtname=con.Getclonepjt();
		Thread.sleep(2000);
		prpg.typepjtnamegrd(clonepjtname);
		logger.info("-------user type the clone project name-------");
		Thread.sleep(2000);
		prpg.clickpjtgrdEdit();
		logger.info("-------User click Edit button -------");
		prpg.clickmaintasktab();
		logger.info("-------User click the main task tab-------");
		prpg.clickmaintskgrd();
		//prpg.GetallEditMaintask();
		//for(int j=0;j<=4;j++)
		//{		
		
/*		List<WebElement> editelms=driver.findElements(By.xpath("//*[@id='tasks-grid']//table//tbody//tr//td[7]"));
	    //	try {
	//	for(int i=0;i<editelms.size();i++)
		for(WebElement we:editelms)
		{
			System.out.println("count of the row to edit"+editelms.size());
			//Iterator<WebElement>we=editelms.iterator();
			//while(we.hasNext())
			//{
				//WebElement mile_tskelm=we.next();
			//WebElement mile_tskelm =editelms.get(i) ;
			//mile_tskelm.click();
			try {
			we.click();
			Thread.sleep(2000);
			edittskfn();
			
			
			}
			catch(Exception ex)
			{
				System.out.println("cannot edit all clone data");
			}
			//prpg.clickmaintasktab();
			//driver.findElements(By.xpath("//*[@id='tasks-grid']//table//tbody//tr//td[7]"));
			//driver.navigate().refresh();
			//prpg.clickmaintasktab();
			//
			Thread.sleep(2000);
			//List<WebElement> editelms1=driver.findElements(By.xpath("//*[@id='tasks-grid']//table//tbody//tr//td[7]"));
			
		}*/
		prpg.clickMilestone();
		Thread.sleep(2000);
		logger.info("--------click milestone --------------");
		prpg.clickEditmilestonegrd();
		Thread.sleep(2000);
		logger.info("--------------click edit in the millestone grid---------------------------");
	
	    	
  }
	
	public void edittskfn() throws InterruptedException
	{
		WebElement tskenddate=driver.findElement(By.xpath("//*[@id='Tasks_due_date']"));
		LocalDate Today_date=java.time.LocalDate.now();
		tskenddate.clear();
		tskenddate.sendKeys(""+Today_date.plusWeeks(2));
		tskenddate.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Tasks_ranking']")).clear();
		
		driver.findElement(By.xpath("//*[@id='Tasks_ranking']")).sendKeys(""+RandomStringUtils.randomNumeric(2));
		driver.findElement(By.xpath("//*[@value='Save & Add Main Task']")).click();
		Thread.sleep(2000);
		JavascriptHelper js=new JavascriptHelper(driver);
		js.scrollDownByPixel();
		
	}
	

		public void Verifysuccessfull() throws IOException, InterruptedException {
			boolean status = prpg.verifysuccessfull();
			Thread.sleep(2000);
			if (status == true) {
				logger.info("-----------------successfully -----------------------");
				Assert.assertTrue(true);

			} else {
				captureScreen(driver, "Project Creation");
				logger.info("-----------------Data creation failed -----------------------");
				Assert.assertTrue(false, "---------------Data creation failed----------------------");
			}
		}

		@AfterMethod
		public void Logout() throws InterruptedException {
			Thread.sleep(2000);
			LogoutPage logout = new LogoutPage(driver);
			logout.clickusericon();
			logout.clickLogout();
		}
}
