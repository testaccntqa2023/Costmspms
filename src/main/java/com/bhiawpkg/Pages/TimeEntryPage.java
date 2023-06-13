package com.bhiawpkg.Pages;

import java.time.LocalDate;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BHIAW.Helper.AlertHelper;
import com.BHIAW.Helper.Dateselectionhelper;
import com.BHIAW.Helper.DropdownHelper;
import com.BHIAW.Helper.LoggerHelper;

public class TimeEntryPage {
	WebDriver driver;
		Properties pr=new Properties();
		private final Logger logger=LoggerHelper.getLogger(TimeEntryPage.class);
		@FindBy(xpath="//*[contains(text(),'Time Entry')]")public WebElement timeentrymenu;
		@FindBy(xpath="//ul/li[1]/a[contains(text(),'Time Entry')]")public WebElement timeentry;
		@FindBy(xpath="//ul//li[2]//a[contains(text(),'Pending Requests')]")public WebElement pendingrequest_timeentry;	
		@FindBy(id="resource_sheets")public WebElement switchtimeentruser;
		@FindBy(xpath="//*[@id='shift_userid']")public WebElement shiftuser;
		@FindBy(xpath="//div//a[text()='Add Time']")public WebElement Add_Time;
		@FindBy(id="TimeEntry_tskid")public WebElement timetask;
		@FindBy(id="TimeEntry_work_type")public WebElement Timewrktype;
		@FindBy(id="TimeEntry_entry_date")public WebElement clickTimeEntrydate;
		@FindBy(id="TimeEntry_completed_percent")public WebElement TimeEntryprogress;
		@FindBy(id="TimeEntry_current_status")public WebElement Timeentrycustatus;
		@FindBy(id="TimeEntry_hours")public WebElement Timeentryhours;
		@FindBy(id="TimeEntry_description")public WebElement Timeentrydescr;
		@FindBy(xpath="//*[@name='yt0']")public WebElement Timeentrycreatebtn;
		@FindBy(xpath="//*[@id='project_name']")public WebElement pjtname;
		@FindBy(xpath="//*[@id='search_project']")public WebElement searchpjtbtn;
		
		@FindBy(xpath="//*[@id='box']")public WebElement Project_timeentry;
		@FindBy(xpath="//*[@id='expand-projects']//div[@class='container custom-container']//div//h2[text()='")public WebElement selprojbeforeelm;
		@FindBy(xpath="']")public WebElement selprojafterelm;
		@FindBy(xpath="//*[@class='table table-bordered']//tbody//tr//td[8]")public WebElement expectedapprovedate;
		@FindBy(xpath="//*[@class='table table-bordered']//thead//tr//td[8]//input[@id='TimeEntry_entry_date']")public WebElement Approvedate;
		@FindBy(xpath="//*[@id='time-entry-grid']//table//thead//tr//td[8]//input")public WebElement expapprovedate;
		@FindBy(xpath="//*[@id='time-entry-grid']//table//tr//td//a[@title='Approve']")public WebElement approvetimeentry;
		@FindBy(xpath="//*[@id='time-entry-form']//div//input[@value='Save']")public WebElement savebtn;
		@FindBy(xpath="//*[@class='project_text']")public WebElement btmpjt;
		@FindBy(xpath ="//*[@class='switch-user-custom']//select")public WebElement switchuser;
		@FindBy(xpath="//*[@id='time-entry-grid']//table//tbody//tr//td//span")public WebElement Timeentryapprgrdtxt;
		//@FindBy(xpath="//*[@id='expand-projects']//div[@class='caption']//h2[text()='Modern']")public WebElement pjtbox;
		public TimeEntryPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		public void clicktimeentrymenu() 
		{
			this.timeentrymenu.click();
			logger.info("----------Click time entry------------");
		}
		public void clicktimentry()
		{
			this.timeentry.click();
			logger.info("-------click time entry in time entry menu--------------------");
		}
		public void shiftuser(String shftuser)
		{
			DropdownHelper dpseltimeuser=new DropdownHelper(driver);
			dpseltimeuser.SelectUsingVisibleText(shiftuser, shftuser);
			logger.info("----------shift user---------------");
		}
		public void selectuser(String timeentryuser)
		{
			DropdownHelper dpseltimeuser=new DropdownHelper(driver);
			dpseltimeuser.SelectUsingVisibleText(switchtimeentruser, timeentryuser);
			logger.info("----------Change user---------------");
		}
		public void Clickaddtime()
		{
			this.Add_Time.click();
			logger.info("---------clicked add time----------------");
			this.clickTimeEntrydate.clear();
		}
		public void selecttask(String timetsk)
		{
			DropdownHelper dpseltsk=new DropdownHelper(driver);
			dpseltsk.SelectUsingVisibleText(timetask, timetsk);
			logger.info("-------------select the task-------------------");
			
		}
		public void selectwrktype(String timewrktype)
		{
			DropdownHelper dpselwrktype=new DropdownHelper(driver);
			dpselwrktype.SelectUsingVisibleText(Timewrktype, timewrktype);
			logger.info("-------------select the timeworktype-------------------");
		}
		public void clickentrydate() throws InterruptedException
		{
			//this.clickTimeEntrydate.click();
			LocalDate Today_date=java.time.LocalDate.now();
			this.clickTimeEntrydate.clear();
			//Thread.sleep(2000);
		   // this.clickTimeEntrydate.sendKeys(""+Today_date);
		  
		  
			//this.clickTimeEntrydate.click();
			logger.info("-------------click the Entry date-------------------");
			
		}
		public void seltimeentrydate()
		{
			this.clickTimeEntrydate.clear();
			LocalDate todaydate=LocalDate.now();
			this.clickTimeEntrydate.sendKeys(""+todaydate);
			logger.info("-------------Enter time entry date-------------------");
			this.clickTimeEntrydate.sendKeys(Keys.ENTER);
		}
		public void selecttimedate(String timexday,String timexmonth,String timeExyear) throws InterruptedException
		{
			Dateselectionhelper seltimedate=new Dateselectionhelper(driver);
			seltimedate.selectDate_TimeEntry(timexday, timexmonth, timeExyear);
			Thread.sleep(2000);
			logger.info("-------------select the timeentry date-------------------");
		}
		public void selecttimestatus(String timestatus)
		{
			DropdownHelper dpseltimestatus=new DropdownHelper(driver);
			dpseltimestatus.SelectUsingVisibleText(Timeentrycustatus, timestatus);
			logger.info("-------------select the time entry status-------------------");
		}
		public void typeprogress(String typeprogress)
		{
			this.TimeEntryprogress.clear();
			this.TimeEntryprogress.sendKeys(typeprogress);
			logger.info("-------------Enter the time entry progress------------------");
			
		}
		public void typetimeentryhours(String typetime)
		{
			this.Timeentryhours.sendKeys(typetime);
			logger.info("-------------Enter the time entry hours------------------");
		}
		public void typetimeentrydescr(String timedescr)
		{	this.Timeentrydescr.clear();
			this.Timeentrydescr.sendKeys(timedescr);
			logger.info("-------------Enter the time entry description------------------");
		}
		public void typetimeentryeditdescr(String timedescr)
		{	this.Timeentrydescr.clear();
			this.Timeentrydescr.sendKeys(timedescr+RandomStringUtils.randomAlphabetic(4));
			logger.info("-------------Enter the time entry description------------------");
		}
		public void clickcreatebutton()
		{
			this.Timeentrycreatebtn.click();
			logger.info("-------------click the time entry create button------------------");
		}
		public void clickproject()
		{
			this.Project_timeentry.click();
			logger.info("-----click project section--------------");
		}
		public String selectproject(String pjtname)
		{
			String selprojbeforeelm="//*[@id='expand-projects']//div[@class='container custom-container']//div//h2[text()='";
			String selprojafterelm="']";
			String getpjtname=driver.findElement(By.xpath(selprojbeforeelm+pjtname+selprojafterelm)).getText();
			return getpjtname;
		}
//*******************************************PENDING REQUEST*&APPROVE ****************************************************************
		public void clickpendingrequest()
		{
			this.pendingrequest_timeentry.click();
			logger.info("----------click pending request in time entry---------------------");
		}
		public void clickApprovedate(String actdate) throws InterruptedException
		{
			this.Approvedate.click();
			this.Approvedate.clear();
			//LocalDate Today_date=java.time.LocalDate.now();
			// this.Approvedate.sendKeys(""+Today_date);
			this.Approvedate.sendKeys(""+actdate);
			//Thread.sleep(2000);
			this.Approvedate.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			logger.info("---------Click the date in the grid--------");
		}
		public void Getactapprdate(String actdate)
		{
			//DropdownHelper dpselactapprdate=new DropdownHelper(driver);
			//dpselactapprdate.SelectUsingVisibleText(this.expapprovedate, actdate);
			this.expapprovedate.sendKeys(actdate);
			logger.info("-------------get the actdate date-------------------");
			
		}
		public void selectdateapprove(String exDay,String exMonth,String exYear)
		{
			Dateselectionhelper seltimedate=new Dateselectionhelper(driver);
			seltimedate.selectDate(exDay, exMonth, exYear);
			logger.info("-------------select the grid date-------------------");
		}
		public void clickApprove()
		{
			this.approvetimeentry.click();
			logger.info("----------------click approve button--------------------");
		}
		public void clickAlert()
		{
			AlertHelper alert=new AlertHelper(driver);
			alert.getAlert();
			alert.AcceptAlertIfPresent();
			logger.info("-------Accept alert----------");
		}
		public void Clicksavebtn()
		{
			this.savebtn.click();
			logger.info("----------- clicked save button-----------");
		}
		public String Getexpapprovedate()
		{
			logger.info("---------getting expected approve  date------------------");
			return this.expectedapprovedate.getText();
			
		}
		public int Gettimeentryrowno()
		{
			int timeentryrowno=driver.findElements(By.xpath("//*[@id='status_table']//tbody//tr")).size();
			logger.info("---------getting time entry row number------------------");
			return timeentryrowno;
		}
		public void clickbtmproject() throws InterruptedException
		{
			this.btmpjt.click();
			Thread.sleep(2000);
			logger.info("-------------go to select project-------------------");
			
		}
		public void switchuser(String switchusers)
		{
		 DropdownHelper dpselswitchuser=new DropdownHelper(driver);
		 dpselswitchuser.SelectUsingVisibleText(this.switchuser, switchusers);
		 logger.info("--------- switch to another user-----------------");
		}
		public boolean verifysuccessfull()
		{
			logger.info("----------------verify--------------------");
			return driver.getPageSource().contains("Successfully");
		}
		public String Gettimeentrygrtxt()
		{
			logger.info("---------get grd text from time entry ------------");
			return this.Timeentryapprgrdtxt.getText();
			
		}
		public WebElement gridtxtelm()
		{
			return this.Timeentryapprgrdtxt;
		}
		public int getgridrowno()
		{
			logger.info("---------get grd row number  from time entry grid------------");
			int rowno=driver.findElements(By.xpath("//*[@id='time-entry-grid']//table//tbody//tr")).size();
			return rowno;
		}
		public void typepjtname(String serchpjtname)
		{
			this.pjtname.sendKeys(serchpjtname);
			logger.info("---------type the pjt name--------------");
		}
		public void clicksearchpjtbtn()
		{
			this.searchpjtbtn.click();
			logger.info("--------click serach button---------------");
		}
}
