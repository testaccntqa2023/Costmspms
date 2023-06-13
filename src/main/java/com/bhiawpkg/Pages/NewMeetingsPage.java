package com.bhiawpkg.Pages;

import java.time.LocalDate;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BHIAW.Helper.AlertHelper;
import com.BHIAW.Helper.DropdownHelper;
import com.BHIAW.Helper.JavascriptHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;

public class NewMeetingsPage {
	WebDriver driver;
	Properties  pr=new Properties();
	Config con=new Config(pr);
	JavascriptHelper js=new JavascriptHelper(driver);
	
	private final Logger logger=LoggerHelper.getLogger(NewMeetingsPage.class);
	@FindBy(xpath ="//li[8]//a[text()='Reports']")public WebElement reports;
	@FindBy(xpath="//li[8]//a[text()='Meeting Minutes']")public WebElement Meetingminutes;
	@FindBy(xpath="//a[text()='New Meeting']")public WebElement Newmeeting;
	@FindBy(id="SiteMeetings_project_id")public WebElement selmeetpjt;
	@FindBy(xpath="//*[@name='SiteMeetings[site_id]']")public WebElement selmeetsite;
	@FindBy(id="SiteMeetings_date")public WebElement meetingdate;
	@FindBy(id="SiteMeetings_venue")public WebElement meetvenue;
	@FindBy(id="SiteMeetings_meeting_time")public WebElement stemeettime;
	@FindBy(id="SiteMeetings_meeting_number")public WebElement meetnumber;
	@FindBy(xpath="//*[@id='cke_1_contents']")public WebElement contenttype;
	@FindBy(id="MeetingParticipants_participants")public WebElement participants;
	@FindBy(xpath="//*[@id='cke_1_contents']//iframe[@title='Rich Text Editor, SiteMeetings_objective']")public WebElement meetframe;
	@FindBy(xpath="//select[@name='MeetingParticipants[contractor_id][]']")public WebElement selmetcntractr;
	@FindBy(xpath="//*[@id='save_btn']")public WebElement nextbtn;
	@FindBy(xpath="//li//a[text()='Step 2']")public WebElement step2;
	@FindBy(id="MeetingMinutes_milestone_id")public WebElement meetmilestone;
	@FindBy(id="MeetingMinutes_title")public WebElement meettitle;
	@FindBy(id="MeetingMinutes_start_date")public WebElement meetstrtdate;
	@FindBy(id="MeetingMinutes_end_date")public WebElement meetenddate;
	//@FindBy(xpath="//div[@class='col-md-4']//select[@name='MeetingMinutes[users][]']")public WebElement actionby;
	@FindBy(xpath="//*[@id='meeting-minutes-form']//select[@name='MeetingMinutes[users][]']")public WebElement actionby;
	@FindBy(xpath="//body/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[2]/div[1]/input[1]")public WebElement milestonenxtbtn; 
	@FindBy(xpath="//*[@id='meeting-detailed-reports-form']//div//input[@id='save_btn']")public WebElement savebtn;
	 
	
	@FindBy(xpath="//li//a[text()='Step 4']")public WebElement step4;
	@FindBy(id="SiteMeetings_next_meeting_date")public WebElement nextmeetdate;
	@FindBy(id="SiteMeetings_next_meeting_time")public WebElement nextmeettime;
	@FindBy(id="SiteMeetings_location")public WebElement nextmeetlocation;
	@FindBy(xpath="//body/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/form[1]/div[2]/div[1]/input[1]")public WebElement nxtmeetsavebtn;
	                   
	//html/body/div[1]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[4]/form/div[2]/div/input
	//@FindBy(xpath="//*[@id='site-meetings-form-2']//div//input[@id='c']")public WebElement nxtmeetsavebtn;
	
	@FindBy(xpath="//*[@id='MeetingParticipants_designation']")public WebElement desgnparticipants;
	@FindBy(xpath="//*[@id='MeetingDetailedReports_report_id']")public WebElement rptsel;
	
	@FindBy(xpath="//*[@class='select2-search__field' and @placeholder='Approved By']")public WebElement approveby;
	@FindBy(xpath="//*[@id='Meeting_users']")public WebElement selapprby;
	@FindBy(xpath="//*[@class='select2-selection select2-selection--multiple']//ul//li[@title='")public WebElement selapproveusers;
	@FindBy(xpath="//*[@class='save_btn btn blue btn-sm generate_report margin-top-5']")public WebElement gobtn;
	@FindBy(xpath="//input[@name='submit']")public WebElement submit;
	//update meet
	@FindBy(xpath="//*[@id='site-meetings-grid']//table//thead//td[3]//select[@name='SiteMeetings[project_id]']")
										public WebElement grdmeetpjtname;
	@FindBy(xpath="//*[@id='site-meetings-grid']//table//tbody//tr[1]//td[9]//a[@title='Update']")
	public WebElement updatebtn;
	
	@FindBy(xpath="//*[@id='meeting-minutes-grid']//table//tbody//tr[1]//td[6]")
	public WebElement grdeditbtn;
	
	@FindBy(xpath="//*[@id='step_2_info']//form[@id='meeting-minutes-form']//div//input[@id='save_btn']")
	public WebElement step2nxtbtn;
	
	@FindBy(xpath="//*[@id='step_4_info']//form[@id='site-meetings-form-2']//div//input[@id='save_btn']")
	public WebElement updatestep4savebtn;
	
	@FindBy(xpath="//*[@id='site-meetings-grid']//table//tbody//tr//td[7]//div//span[text()='Pending']")
	public WebElement pendingmom;
	@FindBy(xpath ="//*[@id='shift_userid']")public WebElement shiftuser;
	@FindBy(xpath ="//*[@id='site-meetings-grid']//table//tbody//tr//td[1]")public WebElement pendchkbox;
	@FindBy(xpath ="//*[@name='reason']")public WebElement advsearch;
	
	@FindBy(xpath ="//*[@name='approve']")public WebElement approvebtn;
	@FindBy(xpath ="//div//a[text()='Add Task']")public WebElement step2addtsk;
	@FindBy(id="cru-frame")public WebElement frameid;
	@FindBy(xpath="//*[@id='Tasks_project_id']")public WebElement formselpjt;
	@FindBy(xpath="//*[@id='main_task']")public WebElement formmaintsk;
	//@FindBy(xpath ="//*[@class='task_section']//form[@id='tasks-form']//select[@id='Tasks_project_id']")public WebElement formselpjt;
	
	//@FindBy(xpath ="//*[@class='task_section']//form[@id='tasks-form']//select[@id='main_task']")public WebElement formmaintsk;
	//*[@class='task_section']//form[@id='tasks-form']//input[@id='Tasks_title']
	@FindBy(xpath ="//input[@id='Tasks_title']")public WebElement formtitle; 
	//*[@class='task_section']//form[@id='tasks-form']//input[@id='Tasks_quantity']
	@FindBy(xpath ="//input[@id='Tasks_quantity']")public WebElement formquantity;
	//*[@class='task_section']//form[@id='tasks-form']//select[@id='Tasks_unit']
	@FindBy(xpath ="//select[@id='Tasks_unit']")public WebElement formtskunit;
	@FindBy(xpath ="//input[@id='Tasks_rate']")public WebElement formtskrate;
	@FindBy(xpath ="//select[@id='Tasks_clientsite_id']")public WebElement formsite;
	@FindBy(xpath ="//select[@id='Tasks_area']")public WebElement formarea;
	@FindBy(xpath ="//select[@id='Tasks_work_type_id']")public WebElement formworktype;
	@FindBy(xpath ="//input[@id='Tasks_allowed_workers']")public WebElement formmaxwrkers;
	
	@FindBy(xpath ="//select[@id='Tasks_assigned_to']")public WebElement formassgnto;
	@FindBy(xpath ="//select[@id='Tasks_contractor_id']")public WebElement formselcontractor;
	//@FindBy(xpath ="//*[@class='task_section']//form[@id='tasks-form']//div[@class='form-group']//input[@value='Create']")public WebElement formcreatebtn;
	@FindBy(xpath ="//*[@id='Tasks_email']")public WebElement formemail;
	@FindBy(css="input.btn.blue.save_btn.save_task.meeting_task")public WebElement createtsk;
	
	
	@FindBy(xpath = "//*[@id='site-meetings-grid']//table//thead//td[7]//select[@name='SiteMeetings[approved_status]']")public WebElement selpendingstatus;
	//@FindBy(xpath="//*[@class='btn blue save_btn save_task meeting_task']")public WebElement createtsk;
	
	
	
	
	//*[@class='select2-selection select2-selection--multiple']//ul//li[@title='ADVIN  (SITE ENGINEER)']
	public NewMeetingsPage(WebDriver driver)
	{
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
	}
	
	 public void clickreports()
	    {
	    	this.reports.click();
	    	logger.info("-----------click reports menu--------------------");
	    }
	 public void clickmeetingminutes()
	 {
		 this.Meetingminutes.click();
		 logger.info("----------------click meeting minutes------------------------");
	 }
	 public void clickNewmeeting()
	 {
		 this.Newmeeting.click();
		 logger.info("-----click new meeting-------");
	 }
	 public void selmeetpjt(String meetpjt)
	 {
		 DropdownHelper dpselmeetpjt=new DropdownHelper(driver);
		 dpselmeetpjt.SelectUsingVisibleText(this.selmeetpjt, meetpjt);
		 logger.info("----------select meeting project-------------");
	 }
	 public void selmeetsite(String selmeetste)
	 {
		 DropdownHelper dpselmeetsite=new DropdownHelper(driver);
		 dpselmeetsite.SelectUsingVisibleText(this.selmeetsite, selmeetste);
		 logger.info("-----------select meeting site-----------------------");
	 }
	// public void typemeetdate(String meetdate)
	 public void typemeetdate()
	 {
		 this.meetingdate.clear();
		 LocalDate todaydate=LocalDate.now();
		 this.meetingdate.sendKeys(""+todaydate);
		 this.meetingdate.sendKeys(Keys.ENTER);
		 logger.info("---------type meeting date---------------");
	 }
	 public void typemeetvenue(String meetvenue)
	 {
		 this.meetvenue.sendKeys(meetvenue);
		 logger.info("---------type meeting venue---------------");
	 }
	 public void typemeettime(String meettime)
	 {
		 this.stemeettime.sendKeys(meettime);
		 this.stemeettime.sendKeys(Keys.ENTER);
		 logger.info("---------type meeting time---------------");
	 }
	 public void typemeetnumber(String meetnumber)
	 {
		 this.meetnumber.sendKeys(meetnumber);
		 logger.info("---------type meeting number---------------");
	 }
	 public void meettoframe() throws InterruptedException
	 {
		 driver.switchTo().frame(0);
		 logger.info("------------switching to meeting frame----------------------");
		 WebElement el  =  driver.switchTo().activeElement();
		 new Actions(driver).moveToElement(el).perform();
		 driver.findElement(By.xpath("/html/body")).sendKeys("Discussion regarding HT and LT works\r\n"
		 		+ "● Discussion regarding ELV and STP");
		 driver.switchTo().defaultContent();
	 }
	 public void typecontent(String content)
	 {
		 this.contenttype.sendKeys(content);
		 logger.info("-------type meeting content-------------");
	 }
	 public void selmeetcntractr(String meetcntr) throws InterruptedException
	 {
		 JavascriptHelper js=new JavascriptHelper(driver);
		 js.scrollDownByPixel();
		 Thread.sleep(2000);
		 DropdownHelper dpselmeetcntr=new DropdownHelper(driver);
		 dpselmeetcntr.SelectUsingVisibleText(selmetcntractr, meetcntr);
		 logger.info("--------------------------");
	 }
	 public void typeparticipant(String partname)
	 {
		 this.participants.sendKeys(partname);
		 logger.info("-----------entering participants--------------------");
	 }
	 public void clicknextbtn()
	 {
		 this.nextbtn.click();
		 logger.info("-------clicking next button-----------");
	 }
	 public void clickstep2()
	 {
		 this.step2.click();
		 logger.info("-------click step2----------");
	 }
	 public void selmeetmilestone(String metmilestone) throws InterruptedException
	 {
		 JavascriptHelper js=new JavascriptHelper(driver);
		 js.scrollUpByPixel();
		 Thread.sleep(2000);
		 DropdownHelper dpselmeetmile=new DropdownHelper(driver);
		 dpselmeetmile.SelectUsingVisibleText(meetmilestone, metmilestone);
		 logger.info("------------select milestone------------------");
	 }
	 public void Typemeettitle(String meettitle)
	 {
		 this.meettitle.sendKeys(meettitle);
		 logger.info("-----------type title----------------");
	 }
	 public void typestrtdate()
	 {
		 this.meetstrtdate.clear();
		 LocalDate todaydate=LocalDate.now();
		 this.meetstrtdate.sendKeys(""+ todaydate);
		 this.meetstrtdate.sendKeys(Keys.ENTER);
		 logger.info("---------type meeting  date---------------");
		// this.meetstrtdate.sendKeys(Keys.ENTER);
		 logger.info("--------enter start date-----------------");
	 }
	 public void typeenddate()
	 {
		 this.meetenddate.clear();
		 LocalDate todaydate=LocalDate.now();
		 this.meetenddate.sendKeys(""+ todaydate);
		 this.meetenddate.sendKeys(Keys.ENTER);
		
		 logger.info("--------enter end date-----------------");
	 }
	 public void selactionby(String actby) throws InterruptedException
	 {
		 JavascriptHelper js=new JavascriptHelper(driver);
		js.executeScript("window.scrollBy(0,170)");
		// js.scrollDownByPixel();
		 Thread.sleep(2000); 
		 DropdownHelper dpselactby=new DropdownHelper(driver);
		 dpselactby.SelectUsingVisibleText(actionby, actby);
		 driver.switchTo().defaultContent();
		 logger.info("-------select action by user-------------------");
	 }
	 public void pointdiscussed() throws InterruptedException
	 {
		 driver.switchTo().frame(1);
		 logger.info("------------switching to meeting frame----------------------");
		 WebElement el  =  driver.switchTo().activeElement();
		 new Actions(driver).moveToElement(el).perform();
		 driver.findElement(By.xpath("/html/body")).sendKeys("Architect informed that BOQ of DG, Transformer,\r\n"
		 		+ "Bus Duct will be issued soon.\r\n"
		 		+ " Electrical contractor pointed out that the electrical\r\n"
		 		+ "scheme approval will take at least 45 days after\r\n"
		 		+ "the submission of scheme. He also agreed to\r\n"
		 		+ "submit scheme on or before 06/06/2020");
		 driver.switchTo().defaultContent();
	 }
	 public void clickmilestonenxt() throws InterruptedException
	 {
			js=new JavascriptHelper(driver);
			js.executeScript("arguments[0].click();", this.milestonenxtbtn);
			Thread.sleep(2000);
		// this.milestonenxtbtn.click();
		 logger.info("----------click milestone next button----------------------");
	 }
	 public void clicksavebtn()
	 {
		 this.savebtn.click();
		 logger.info("---------click save button---------------");
	 }
	 //-----------------------------Next Meetings
	 public void clickstep4()
	 {
		 
		 this.step4.click();
		 logger.info("-------click step2----------");
	 }
	 public void typenextmeetdate() throws InterruptedException
	 {
		 this.nextmeetdate.clear();
		 LocalDate Today_date=java.time.LocalDate.now();
	    	this.nextmeetdate.sendKeys(""+Today_date.plusDays(2));
	    	this.nextmeetdate.sendKeys(Keys.ENTER);
	    	Thread.sleep(2000);
	    	logger.info("-----------Type next meet date-------------------");
	 }
	 public void typenxtmeettime(String nxtmeettime)
	 {
		 this.nextmeettime.sendKeys(nxtmeettime);
		 this.nextmeettime.sendKeys(Keys.ENTER);
		 logger.info("---------type  next meeting time---------------");
	 }
	 public void Nextmeetingcontent() throws InterruptedException
	 {
		 driver.switchTo().frame(2);
		 logger.info("------------switching to meeting frame----------------------");
		 WebElement el  =  driver.switchTo().activeElement();
		 new Actions(driver).moveToElement(el).perform();
		 driver.findElement(By.xpath("/html/body")).sendKeys("Next meeting");
		 driver.switchTo().defaultContent();
		 Thread.sleep(2000);
	 }
	 public void typenextmeetlocation(String nxtmeetloc)
	 {
		 this.nextmeetlocation.sendKeys(nxtmeetloc);
		 logger.info("---------type next meet location--------------------");
	 }
	 public void clicknextmeetsavebtn() throws InterruptedException
	 {
		 js=new JavascriptHelper(driver);
			js.executeScript("arguments[0].click();", this.nxtmeetsavebtn);
			Thread.sleep(2000);
		 //this.nxtmeetsavebtn.click();
		 logger.info("-----------click save button-----------------");
	 }
	 public void clickapproveby()
	 {
		 this.approveby.click();
		 logger.info("----------------click approve by-----------------------");
	 }
	 public void selusersapproveby(String selapproveby)
	 {
		 DropdownHelper dpsel=new DropdownHelper(driver);
		 dpsel.SelectUsingVisibleText(this.selapprby, selapproveby);
		 logger.info("----------select approve by users----------------");
	 }
	 public void typepartidesgn(String desgnparti)
	 {
		 this.desgnparticipants.sendKeys(desgnparti);
		 logger.info("-----------type participant designation----------------");
	 }
	 public void selrept()
	 {
		 DropdownHelper dpselrpt=new DropdownHelper(driver);
		 dpselrpt.SelectUsingIndex(this.rptsel, 1);
		 logger.info("------------select the report------------------------");
	 }
	 public void clickgobtn()
	 {
		 this.gobtn.click();
		 logger.info("------------click go button------------------------");
	 }
	 public void clicksubmit()
	 {
		 this.submit.click();
		 logger.info("------------click submit button------------------");
	 }
	 public void selgrdmeetpjtname(String meetnme)
	 {
		 DropdownHelper dpselmeenme=new DropdownHelper(driver);
		 dpselmeenme.SelectUsingVisibleText(this.grdmeetpjtname, meetnme);
	 }
	 public void selpendingstatus(String status)
	 {
		 DropdownHelper dpselpendst=new DropdownHelper(driver);
		 dpselpendst.SelectUsingVisibleText(this.selpendingstatus, status);
	 }
	 public void clickupdtebtn()
	 {
		 this.updatebtn.click();
		 logger.info("-------------click update button--------------------");
	 }
	 public void clickgrdeditbtn()
	 {
		 this.grdeditbtn.click();
		 logger.info("--------click grid edit button-------------");
	 }
	 public void editpointdiscussed() throws InterruptedException
	 {
		 driver.switchTo().frame(1);
		 logger.info("------------switching to meeting frame----------------------");
		 WebElement el  =  driver.switchTo().activeElement();
		 new Actions(driver).moveToElement(el).perform();
		 driver.findElement(By.xpath("/html/body")).clear();
		 driver.findElement(By.xpath("/html/body")).sendKeys("Black shade granite can be used for the lift facia\r\n"
		 		+ " chamfering should be done in joints");
		 driver.switchTo().defaultContent();
	 }
	 public void clickstep2nxtbtn()
	 {
		 this.step2nxtbtn.click();
	 }
	 public void clickupdatestep4savebtn()
	 {
		 this.updatestep4savebtn.click();
	 }
	 public String getstatusmom()
	 {
		String momstatus=this.pendingmom.getText();
		return momstatus;
	 }
	 //--------------------Approval
	 public void shiftuser(String user)
		{
			DropdownHelper dpshiftuser=new DropdownHelper(driver);
			dpshiftuser.SelectUsingVisibleText(shiftuser, user);
			logger.info("--------------------shift user--------------");
		
		}
	 public void clickpendchkmom()
	 {
		 this.pendchkbox.click();
	 }
	 public void typeadvsearch()
	 {
		 this.advsearch.sendKeys("yes");
	 }
	 public void clickapprovebtn()
	 {
		 this.approvebtn.click();
		 AlertHelper alert=new AlertHelper(driver);
		 alert.AcceptAlertIfPresent();
	 }
	 //------------Add task in MOM
	 public void clickaddtaskstep2()
	 {
		 this.step2addtsk.click();
	 }
	 public void Toframe()
		{
			driver.switchTo().frame(frameid);
		}
	 public void selformpjt(String pjtnme)
	 {
		 DropdownHelper dpselpjt=new DropdownHelper(driver);
		 dpselpjt.SelectUsingVisibleText(this.formselpjt, pjtnme);
		 
	 }
	 public void selformmaintsk()
	 {
		 DropdownHelper dpselpjt=new DropdownHelper(driver);
		 dpselpjt.SelectUsingIndex(this.formmaintsk, 1);
	 }
	 public void typeformtitle(String title)
	 {
		 this.formtitle.sendKeys(title);
	 }
	 public void typequantity()
	 {
		 this.formquantity.sendKeys(""+10);
	 }
	 public void seltskunit(String unit)
	 {
		 DropdownHelper dpselunit=new DropdownHelper(driver);
		 dpselunit.SelectUsingVisibleText(this.formtskunit, unit);
	 }
	 public void typeformtskrate()
	 {
		 this.formtskrate.sendKeys(""+100);
	 }
	 public void selformsite(String site)
	 {
		 DropdownHelper dpselunit=new DropdownHelper(driver);
		 dpselunit.SelectUsingVisibleText(this.formsite, site);
	 }
	 public void selformarea()
	 {
		 DropdownHelper dpselpjt=new DropdownHelper(driver);
		 dpselpjt.SelectUsingIndex(this.formarea, 1);
	 }
	 public void selformworktype(String wrktype)
	 {
		 DropdownHelper dpselunit=new DropdownHelper(driver);
		 dpselunit.SelectUsingVisibleText(this.formworktype, wrktype);
	 }
	 public void typeformmaxwrks()
	 {
		 this.formmaxwrkers.sendKeys(""+2);
	 }
	 public void selformassgnto(String assignto)
	 {
		 DropdownHelper dpselunit=new DropdownHelper(driver);
		 dpselunit.SelectUsingVisibleText(this.formassgnto, assignto);
	 }
	 public void selformcontractor(String contractor)
	 {
		 DropdownHelper dpselunit=new DropdownHelper(driver);
		 dpselunit.SelectUsingVisibleText(this.formselcontractor, contractor);
	 }
	 public void typeformemail(String email)
	 {
		 this.formemail.sendKeys(email);
	 }
	 public void clickcreatebtn()
	 {
		 this.createtsk.click();
	 }
}
