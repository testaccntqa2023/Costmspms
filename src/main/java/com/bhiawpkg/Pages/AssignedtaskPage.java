package com.bhiawpkg.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.BHIAW.Helper.AlertHelper;
import com.BHIAW.Helper.Dateselectionhelper;
import com.BHIAW.Helper.DropdownHelper;
import com.BHIAW.Helper.JavascriptHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;

public class AssignedtaskPage {
	WebDriver driver;
	Properties  pr=new Properties();
	Config con=new Config(pr);
	JavascriptHelper js;
	private final Logger logger=LoggerHelper.getLogger(AssignedtaskPage.class);
	@FindBy(linkText ="Assigned Tasks")public WebElement assignedtask;
	@FindBy(linkText ="Add Task")public WebElement AddTAsk;
	@FindBy(id="cru-frame")public WebElement frameid;
	@FindBy(id="Tasks_project_id")public WebElement taskpjt;
	@FindBy(css="#Tasks_project_id")public WebElement taskpjt1;
	@FindBy(id="Tasks_task_type_0")public WebElement External;
	@FindBy(id="Tasks_task_type_1")public WebElement Internal;
	@FindBy(xpath="//*[@id='main_task']")public WebElement selmaintask;
	
	@FindBy(id="Tasks_title")public WebElement tasktitle;
	@FindBy(id="Tasks_quantity")public WebElement taskquantity;
	@FindBy(id="Tasks_unit")public WebElement taskunit;
	@FindBy(id="Tasks_rate")public WebElement taskrate;
	@FindBy(id="Tasks_amount")public WebElement taskamount;
	@FindBy(id="Tasks_clientsite_id")public WebElement tasklocation;
	@FindBy(xpath="//*[@id='Tasks_clientsite_id']")public WebElement tasklocation1;
	
	@FindBy(id="Tasks_area")public WebElement taskarea;
	@FindBy(xpath="//*[@id='Tasks_area']")public WebElement taskarea1;
	
	@FindBy(id="Tasks_title_em")public WebElement titleexist;
	/*---------------dependent task area starts------------*/
	@FindBy(id="add_dependancy_div")public WebElement dependaddbtn;
	@FindBy(xpath="//body/div[@id='page-wrapper']/div[1]/div[1]/div[1]/form[1]/div[10]/div[1]/div[1]/select[1][@id='dependant_taskid']")public WebElement seldependtask;
	@FindBy(xpath="//form[1]/div[10]/div[1]/div[2]/input[1][@id='Tasks_dependancy_percenatge']")public WebElement dependenttskpercnt;
	@FindBy(id="dependancy_type")public WebElement dependentdate;
	/*---------------dependent task area- end------------*/
	@FindBy(id="Tasks_start_date")public WebElement taskstartdate;
	@FindBy(id="due_date")public WebElement taskenddate;
	@FindBy(id="Tasks_task_duration")public WebElement taskduration;
	@FindBy(id="Tasks_daily_target")public WebElement taskdailytarget;
	@FindBy(xpath="//*[@id='Tasks_daily_target']")public WebElement taskdailytarget1;
	@FindBy(id="Tasks_work_type_id")public WebElement taskworktype;
	@FindBy(id="Tasks_required_workers")public WebElement taskreqwkr;
	@FindBy(xpath ="//*[@id='Tasks_required_workers']") public WebElement reqwrkers; 
	@FindBy(id="Tasks_allowed_workers")public WebElement taskmaxworkrs;
	@FindBy(id="Tasks_priority")public WebElement taskpriority;
	@FindBy(id="Tasks_assigned_to")public WebElement taskassignedto;
	@FindBy(xpath="//html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[19]/div[1]/select[1]")public WebElement taskassignedto1; 
	
	@FindBy(id="Tasks_coordinator")public WebElement taskcoordinator;
	@FindBy(id="Tasks_report_to")public WebElement taskowner;
	@FindBy(id="Tasks_status")public WebElement taskstatus;
	@FindBy(id="Tasks_milestone_id")public WebElement taskmilestone;
	@FindBy(id="Tasks_contractor_id")public WebElement taskcontractor;
	@FindBy(id="Tasks_email")public WebElement taskemail;
	@FindBy(id="Tasks_description")public WebElement taskdescr;
	@FindBy(xpath="//*[@class='btn blue save_btn']")public WebElement createtsk;
	@FindBy(xpath="//*[@id='content']/div[2]/div[2]")public WebElement tskcreatesuccessmsg;
	
	@FindBy(xpath="//*[@id='tasks-grid']//table//thead//tr//td[4]//select")public WebElement tskassignedto;
	@FindBy(xpath="//*[@id='tasks-grid']//table//thead//tr//td[15]//select")public WebElement tsktypeinternal;
	@FindBy(xpath ="//*[@class='table table-bordered newcolor']//tbody//tr")public WebElement getgridrow;
	@FindBy(xpath ="//*[@id='tasks-grid']//table//tbody//tr//td//span")public WebElement getgridrowmsg;
	
//--------------------------------------------------------------------------------------------------------------------
	@FindBy(xpath="//*[@class='pull-right']//a[text()='Download ']")public WebElement taskdownload;
//====================================================================================================================	
	@FindBy(xpath="//*[@id='tasks-grid']//table//thead//tr[2]//td[4]//select[@id='Tasks_assigned_to']")public WebElement assigneduname;
	@FindBy(xpath="//*[@id='tasks-grid']//table//thead//tr[2]//td[4]//select")public WebElement grdselassignuname;
//====================================================================================================================	
//------------------------------------------------filter section--------------------------------------------------------------------	
	@FindBy(id="uniform-list_change_closed")public WebElement completedtask;
	@FindBy(id="uniform-list_change")public WebElement expiredtask;
	@FindBy(id="uniform-list_change_main_tasks")public WebElement maintskschkbox;
	@FindBy(id="uniform-list_change_sub_tasks")public WebElement subtasks;
	@FindBy(id="uniform-list_change_expired_tasks")public WebElement expiredtasks;
	@FindBy(xpath="//*[@id='tasks-grid']//table//tbody//tr[1]//td[3]")public WebElement grdpjtname;
//--------------------------------------------------------------------------------------------------------------------	
//------------------------------------------------change status --------------------------------------------------------------------	
		@FindBy(xpath="//*[@id='tasks-grid']//table//tbody//tr[3]//td[1]")public WebElement grdchkbox;
		@FindBy(xpath="//*[@class='pull-left filter-form status_change_btn']//button[contains(text(),'Change Status')]")
																							public WebElement changestatusbtn;
		
		@FindBy(xpath="//*[@id='tasks-grid']//table//tbody//tr[2]//td[14]")public WebElement currentstatus;
		
		@FindBy(xpath="//*[@class='pull-left filter-form status_change_btn']//div//div[2]//textarea[@id='status_description']")
		                                                                                     public WebElement statusdecription;
		
		@FindBy(xpath="//*[@class='pull-left filter-form status_change_btn']//div//div[2]//div//button[text()='Submit']")
																						public WebElement changestatussubmitbtn;
		@FindBy(xpath="//*[@class='pull-left filter-form']//button[contains(text(),'Date Extension')]")
																					public WebElement changedateextensionbtn;
		@FindBy(xpath="//*[@id='tasks-grid']//table//tbody//tr[2]//td[12]")public WebElement currentstrtdate;
		@FindBy(xpath="//*[@id='tasks-grid']//table//tbody//tr[1]//td[13]")public WebElement currentenddate;
		
		@FindBy(xpath="//*[@class='popover fade bottom in']//div[2]//div[1]//div[1]//button[1][text()=' Prepone By']")
																		public WebElement preponedateby;
		@FindBy(xpath="//*[@class='popover fade bottom in']//div[2]//div[1]//div[1]//button[2][text()='Postpone By']")
																		public WebElement postponedateby;
		
		@FindBy(xpath="//*[@class='popover fade bottom in']//div[2]//div[1]//div[2]//button[1][text()=' Start Date']")
																	    public WebElement dateextensionstrtdate;
		@FindBy(xpath="//*[@class='popover fade bottom in']//div[2]//div[1]//div[2]//button[2][text()='End Date']")
																		public WebElement dateextensionenddate;
	
		@FindBy(xpath="//*[@class='popover fade bottom in']//div[2]//div[1]//div[3]//input[@id='change_value']")
																		public WebElement dtextnoofdays;
		
		@FindBy(xpath="//*[@class='popover fade bottom in']//div[2]//div[2]//input")public WebElement dateextsubmitbtn;
		@FindBy(xpath="//*[@class='pull-left filter-form assignee-form']//button[contains(text(),'Change Assignee')]")
																		public WebElement Changeassigneebtn;
		@FindBy(xpath="//*[@class='popover fade bottom in']//div[2]//div[1]//select[@id='assigne_change']")
																		public WebElement chngeassgnuser;
		
		@FindBy(xpath="//*[@class='popover fade bottom in']//div[2]//div[1]//div[1]//input[@value='Submit']")
		public WebElement chngeassgnusersubmitbtn;
		
		public AssignedtaskPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
//**************************************************Assigned Task*********************************************//		
	public void clickAssignedTaskMenu()
	{
		this.assignedtask.click();
		logger.info("----Assigned task is clicked------");
	}
	public void clickAddTask()
	{
		this.AddTAsk.click();
		logger.info("----Click Add task ------");
		
	}
	public void Toframe()
	{
		driver.switchTo().frame(frameid);
	}
	public void selecttaskpjt(String seltaskpjt)
	{
		logger.info("-----selecting the task  project------");
		DropdownHelper dpclient=new DropdownHelper(driver);
		dpclient.SelectUsingVisibleText(taskpjt1,seltaskpjt );
	
	}
	public void clickExternal()
	{
		this.External.click();
		logger.info("-----------click external-----------------");
	}
	public void clickInternal()
	{
		this.Internal.click();
		logger.info("------------click internal----------------");
	}
	public void selectmaintask(String selmatsk)
	{
		DropdownHelper dpselmaintdk=new DropdownHelper(driver);
		dpselmaintdk.SelectUsingVisibleText(selmaintask, selmatsk);
		logger.info("--------main task selection----------");
	}
	public void selectmaintask1() throws InterruptedException 
	{
		DropdownHelper dpselmaintdk=new DropdownHelper(driver);
		dpselmaintdk.SelectUsingIndex(selmaintask, 1);
		Thread.sleep(2000);
		logger.info("--------main task selection----------");
	}
	public void typetasktitle(String tsktitle)
	{
		this.tasktitle.sendKeys(tsktitle);
		logger.info("-------type task title-------");
	}
	
	public void typetskquantity(String tskquantity)
	{
		this.taskquantity.sendKeys(tskquantity);
		logger.info("----------type task quantity----------------");
		
	}
	public void selectunit(String tskunit)
	{
		DropdownHelper dpseltskunit=new DropdownHelper(driver);
		dpseltskunit.SelectUsingVisibleText(taskunit, tskunit);
		logger.info("-----------selecting the task unit----------------");
	}
	public void seltsklocation(String tsklocation)
	{
		DropdownHelper dpseltskloc=new DropdownHelper(driver);
		dpseltskloc.SelectUsingVisibleText(tasklocation1, tsklocation);
		logger.info("---------selecting the task location-----------------");
	}
	
	public void typetaskrate(String taskrate)
	{
		this.taskrate.sendKeys(taskrate);
		
		logger.info("-------------type task rate---------------");
	}
	public void typetaskamount(String tskamount)
	{
		this.taskamount.sendKeys(tskamount);
		logger.info("Task amount is ="+this.taskamount.getText());
	}
	public void seltaskarea(String area)
	{
		DropdownHelper dpseltskarea=new DropdownHelper(driver);
		dpseltskarea.SelectUsingVisibleText(taskarea, area);
		logger.info("selecting the task area-");
	}
	public void seltaskarea1()
	{
		DropdownHelper dpseltskarea=new DropdownHelper(driver);
		dpseltskarea.SelectUsingIndex(taskarea1, 1);
		logger.info("--------selecting the task area----------------");
	}
	public void seltaskarea_depndtsk()
	{
		DropdownHelper dpseltskarea=new DropdownHelper(driver);
		dpseltskarea.SelectUsingIndex(taskarea, 1);
		logger.info("--------selecting the task area----------------");
	}
	public void seltaskworktype(String tskworktype) 
	{
		logger.info("-----selecting the work type in to the project------");
		DropdownHelper dpselworktype=new DropdownHelper(driver);
		dpselworktype.SelectUsingVisibleText(taskworktype, tskworktype);
	}
	public void clicktaskstrtdate()
	{
		JavascriptHelper js=new JavascriptHelper(driver);
		js.scrollDownByPixel();
		this.taskstartdate.click();
		logger.info("--------click start task date------------");
	}
	public void clicktaskenddate()
	{
		this.taskenddate.click();
		logger.info("--------click end task date---------------------");
	}
	public void selecttaskstartdate(String tskstrtexday,String tskstrtexmonth,String tskstrtexyear )
	{
		Dateselectionhelper dpselstrttskdate=new Dateselectionhelper(driver);
		dpselstrttskdate.selectDate(tskstrtexday, tskstrtexmonth,tskstrtexyear);
		logger.info("-------select task start date-----------");
	}
	public void selecttaskstartdate1()
	{
		this.taskstartdate.clear();
		logger.info("--------clear start task date---------------------");
		LocalDate Today_date=java.time.LocalDate.now();
		this.taskstartdate.sendKeys(""+Today_date);
		this.taskstartdate.sendKeys(Keys.ENTER);
		logger.info("--------enter task start date--------------------");
	}
	public void selecttaskstartdate2()
	{
		this.taskstartdate.clear();
		logger.info("--------clear start task date---------------------");
		LocalDate Today_date=java.time.LocalDate.now();
		this.taskstartdate.sendKeys(""+Today_date.minusDays(5));
		this.taskstartdate.sendKeys(Keys.ENTER);
		logger.info("--------enter task start date--------------------");
	}
	public void selecttaskenddate1( )
	{
		this.taskenddate.clear();
		logger.info("-----------clear end task date--------- ");
		LocalDate today_date=java.time.LocalDate.now();
		this.taskenddate.sendKeys(""+today_date.plusDays(30));
		
		this.taskenddate.sendKeys(Keys.ENTER);
		logger.info("--------enter end task date---------------------");
	}
	public void selecttaskenddate2( )
	{
		this.taskenddate.clear();
		
		LocalDate Today_date=java.time.LocalDate.now();
		this.taskenddate.sendKeys(""+Today_date.minusDays(1));
		logger.info("--------clear end task date---------------------");
		
		this.taskenddate.sendKeys(Keys.ENTER);
		logger.info("--------enter end task date---------------------");
	}
	public void selecttaskenddate_dependtsk( )
	{
		this.taskenddate.clear();
		logger.info("--------clear end task date---------------------");
		LocalDate Today_date=java.time.LocalDate.now();
		this.taskenddate.sendKeys(""+Today_date.plusDays(20));
		
		this.taskenddate.sendKeys(Keys.ENTER);
		logger.info("--------enter end task date---------------------");
	}
	public void selecttaskenddate(String tskendexday,String tskendexmonth,String tskendexyear)
	{
		Dateselectionhelper dpselendtskdate=new Dateselectionhelper(driver);
		dpselendtskdate.selectDate(tskendexday, tskendexmonth,tskendexyear);
		logger.info("-------select task end date-----------");
	}
	public void typetskduration()
	{
		this.taskduration.sendKeys(this.taskduration.getText());
		logger.info("Task duration is="+this.taskduration.getText());
	}
	public void dailytrgt()
	{
		this.taskdailytarget.click();
		this.taskdailytarget.sendKeys(this.taskdailytarget.getText());
		logger.info("Daily target is="+this.taskdailytarget.getText());
	}
	public void typetaskreqworkers()
	{
		this.taskreqwkr.sendKeys(this.taskreqwkr.getText());
		logger.info("Required workers---"+this.taskreqwkr.getText());
	}
	public void typemaxworkers() throws InterruptedException
	{
		WebElement elem1=driver.findElement(By.xpath("//*[@id='Tasks_daily_target']"));
		 String dailytarget=elem1.getAttribute("value");
		 Thread.sleep(2000);
		String [] extrnumeralvalue=dailytarget.toString().split("[.]");
		logger.info("The daily target is "+extrnumeralvalue);
		String actualdailytarget=extrnumeralvalue[0].toString();
		Thread.sleep(2000);
		int actualdailytarget1=Integer.parseInt(actualdailytarget);
		Thread.sleep(2000);
		int maxworkers=actualdailytarget1+2;
		Thread.sleep(2000);
		this.taskmaxworkrs.sendKeys(""+maxworkers);
		Thread.sleep(2000);
		
	}
	public void typemaxtskworkers(String maxtskworkers)
	{
		this.taskmaxworkrs.sendKeys(maxtskworkers);
		logger.info("----------enter maximum workers----------------");
	}
	public void seltskpriority(String tskpriority)
	{
		DropdownHelper dpseltskpriority=new DropdownHelper(driver);
		dpseltskpriority.SelectUsingVisibleText(taskpriority, tskpriority);
		logger.info("-------------select task priority------------------");
	}
	public void seltassignedto(String tskassignedto)
	{
		DropdownHelper dpseltskassigne=new DropdownHelper(driver);
		dpseltskassigne.SelectUsingVisibleText(taskassignedto, tskassignedto);
		logger.info("-------------select task assigned to------------------");
	}
	public void seltassignedto1(String tskassignedto1)
	{
		DropdownHelper dpseltskassigne=new DropdownHelper(driver);
		dpseltskassigne.SelectUsingVisibleText(taskassignedto1, tskassignedto1);
		logger.info("-------------select task assigned to------------------");
	}
	public void seltskcoordinator(String tskcoordinator)
	{
		DropdownHelper dpseltskcoordinator=new DropdownHelper(driver);
		dpseltskcoordinator.SelectUsingVisibleText(taskcoordinator, tskcoordinator);
		logger.info("-------------select task coordinator------------------");
	}public void seltskowner(String tskowner)
	{
		DropdownHelper dpseltskowner=new DropdownHelper(driver);
		dpseltskowner.SelectUsingVisibleText(taskowner, tskowner);
		logger.info("-------------select task owner------------------");
	}public void seltskprogress(String tskprogress)
	{
		DropdownHelper dpseltaskstatus=new DropdownHelper(driver);
		dpseltaskstatus.SelectUsingVisibleText(taskstatus, tskprogress);
		logger.info("-------------select task progress------------------");
	}
	public void seltskmilestone(String tskmilestone)
	{
		DropdownHelper dpseltskmilestoney=new DropdownHelper(driver);
		dpseltskmilestoney.SelectUsingVisibleText(taskmilestone, tskmilestone);
		logger.info("-------------select task milestone------------------");
	}
	public void seltskmilestone1()
	{
		DropdownHelper dpseltskmilestoney=new DropdownHelper(driver);
		dpseltskmilestoney.SelectUsingIndex(taskmilestone, 1);
		logger.info("-------------select task milestone------------------");
	}
	public void seltskcontractor(String tskcontractor)
	{
		DropdownHelper dpseltskcontractor=new DropdownHelper(driver);
		dpseltskcontractor.SelectUsingVisibleText(taskcontractor, tskcontractor);
		logger.info("-------------select task contractor------------------");
	}
	public void typeemail(String email)
	{
		this.taskemail.sendKeys(email);
		logger.info("-------------enter task email------------------");
	}
	public void typetaskdecription(String desc)
	{
		this.taskdescr.sendKeys(desc);
		logger.info("-------------enter task description------------------");
	}
	public void clickcreatetskbtn()
	{
		this.createtsk.click();
		logger.info("-----------Clik the create button-----------");
		
	}
	public boolean verifysuccessfull()
	{
		logger.info("----------------verify--------------------");
		return driver.getPageSource().contains("Successfully created.");
	}
	public void seltskassignedto(String assigneusername)
	{
		DropdownHelper dpselassitskname=new DropdownHelper(driver);
		dpselassitskname.SelectUsingVisibleText(tskassignedto, assigneusername);
		logger.info("-----------select task assigned person name-----------");
		
	}
	public void selinternaltsk(String inttsk)
	{
		DropdownHelper dpselinttsk=new DropdownHelper(driver);
		dpselinttsk.SelectUsingVisibleText(tsktypeinternal, inttsk);
		logger.info("-----------select internal task type-----------");
		
	}
	public String Getgridmsg()
	{
		logger.info("--------- Grid text getting-----------------");
		return this.getgridrowmsg.getText();
	}
	public void clicktaskdownload()
	{
		this.taskdownload.click();
		logger.info("---------------click task download------------------------");
	}
//----------------------------------------------------------------------------------------------------------
	public void seleassigneduser(String assgnuser)
	{
		DropdownHelper dpselassgnun=new DropdownHelper(driver);
		dpselassgnun.SelectUsingVisibleText(this.assigneduname, assgnuser);
		logger.info("---------------select assigned user name------------------------");
	}
	public void seleassigneduserdel(String assgnduser)
	{
		DropdownHelper dpselassgnun=new DropdownHelper(driver);
		dpselassgnun.SelectUsingVisibleText(this.grdselassignuname, assgnduser);
		logger.info("---------------select assigned user name------------------------");
	}
//------------------------------------------filter section----------------------------------------------------------------	
	public void clickcompletedtsk()
	{
		this.completedtask.click();
		logger.info("-----------click completed task--------------");
	}
	public void clickhideexpiredtsk()
	{
		this.expiredtask.click();
		logger.info("-----------click Hide expired task task--------------");
	}
	public void clickmaintask()
	{
		this.maintskschkbox.click();
		logger.info("-----------click main task ------------");
	}
	public void clicksubtasks()
	{
		this.subtasks.click();
		logger.info("-----------click subtask ---------------------");
	}
	
	//maintask
	public String getgrdpjtname()
	{
		logger.info("--------get grid project name-----------------");
		return this.grdpjtname.getText();
		
	}
	public void clickexpiredtask()
	{
		this.expiredtasks.click();
		logger.info("--------click expired task check box-----------------");
	}
	public void clickgrdchkbox()
	{
		this.grdchkbox.click();
		logger.info("--------click grid check box -----------------");
	}
	public void clickchangestatus()
	{
		this.changestatusbtn.click();
		logger.info("-------click change status ------------------");
	}
	public String Getcurrentstatus()
	{
		logger.info("-------get current status ------------------");
		return this.currentstatus.getText();
	}
	public void typestatusdescription(String statusdesc)
	{
		this.statusdecription.sendKeys(statusdesc);
		logger.info("---------------entering status description---------------------");
	}
	public void clickchangestatussbmtbutton()
	{
		this.changestatussubmitbtn.click();
		logger.info("-----------click change status submot button--------------------");
	}
	public void clickchangedateextension()
	{
		this.changedateextensionbtn.click();
		logger.info("-------click change date extension ------------------");
	}
	public void clickpreponedate()
	{
		this.preponedateby.click();
		logger.info("-------click prepone date-----------------");
	}
	public void clickpostponedate()
	{
		this.postponedateby.click();
		logger.info("-------click postpone date-------------------");
	}
	public String Getcurrentstartdate()
	{
		logger.info("-------get current start date------------------");
		return this.currentstrtdate.getText();
	}
	public String Getcurrentenddate()
	{
		logger.info("-------get current end date------------------");
		return this.currentenddate.getText();
	}
	public void clickdateextstartdate()
	{
		this.dateextensionstrtdate.click();
		logger.info("---------------click start date--------------------------------");
	}
	public void clickdateextenddate()
	{
		this.dateextensionenddate.click();
		logger.info("---------------click date extension end date--------------------------------");
	}
	public void typedtextnoofdays(String noofdays)
	{
		this.dtextnoofdays.sendKeys(noofdays);
		logger.info("---------------type date extension no of days--------------------------------");
	}
	public void clickdateextsubmitbtn()
	{
		this.dateextsubmitbtn.click();
		logger.info("---------------click date extension submit button--------------------------------");
		AlertHelper handlealert=new AlertHelper(driver);
		handlealert.AcceptAlertIfPresent();
		logger.info("---------------Alert is accepted--------------------------------");
	}
	public void clickchangeassbtn()
	{
		this.Changeassigneebtn.click();
		logger.info("-------------click change assigne button-----------------------");
	}
	public void selchngeassgnusers(String chnguser)
	{
		DropdownHelper dpselchnguser=new DropdownHelper(driver);
		dpselchnguser.SelectUsingVisibleText(this.chngeassgnuser, chnguser);
		logger.info("-------selecting the user to change-------------");
	}
	public void clickchngassgneebtn() throws InterruptedException
	{
		this.chngeassgnusersubmitbtn.click();
		Thread.sleep(2000);
		AlertHelper handlealert=new AlertHelper(driver);
		handlealert.AcceptAlertIfPresent();
		Thread.sleep(2000);
		logger.info("-------user click submit button-------------");
		
	}
	//***************************Dependency task*********************************
	public void clickdependaddbtn()
	{
		this.dependaddbtn.click();
		logger.info("-----------------click ADD button for dependent task ----------------");
	}
	public void selectdepenttsk(String tasknme) throws InterruptedException
	{
		JavascriptHelper js=new JavascriptHelper(driver);
		js.scrollDownByPixel();
		Thread.sleep(2000);
		String maintask=this.selmaintask.getText();
		DropdownHelper dpseltsk=new DropdownHelper(driver);
		dpseltsk.SelectUsingVisibleText(this.seldependtask, tasknme);
		logger.info("----------select the dependent task----------");
	}
	public void typedependtskperc(String tskpercentage)
	{
		this.dependenttskpercnt.click();
		this.dependenttskpercnt.sendKeys(""+tskpercentage);
		logger.info("-----------type the dependent task percentage-------------------------");
	}
	public void clickpercentage()
	{
		this.dependenttskpercnt.click();
	}
	public void selectdepenttskdate()
	{
		Select selecttskdate=new Select(this.dependentdate);
		selecttskdate.getFirstSelectedOption();
		logger.info("----------select the dependent task date----------");
	}
	//task exist or not
	public WebElement Gettaskexist()
	{
		return this.titleexist;
	}
	public void seldepndtsklocation(String location)
	{
		DropdownHelper dpsellocation=new DropdownHelper(driver);
		dpsellocation.SelectUsingVisibleText(this.tasklocation, location);
		logger.info("--------------select the location---------------------");
	}
//	********************Item estimate*******************************
	@FindBy(xpath="//table//thead//tr[2]//td[3]//select[@id='Tasks_project_id']") public WebElement selpjtfrmassignedtsk;
	@FindBy(xpath = "//a[text()='Create']")public WebElement itmestcreatebtn;
	public void selpjtfrmasstsk(String asgndtsk)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selpjtfrmassignedtsk, asgndtsk);
		logger.info("--select pjt from assigned task filter---");
	}
	public void AddItemEstimation(String pjtname) throws InterruptedException
	{
		List<WebElement> tsklist=driver.findElements(By.xpath("//table//tbody//tr"));
		for(int i=1;i<=tsklist.size();i++)
		{
			WebElement elem=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[18]//a[@title='Item Estimation']"));
			elem.click();
			
			Thread.sleep(2000);
			String attributvalue=driver.findElement(By.xpath("//body/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[2]")).getAttribute("id");
			WebElement elem1=driver.findElement(By.cssSelector("div.page-wrapper:nth-child(1) div.page-container div.page-content div.container-fluid.content_sec div.portlet.light div.portlet-body div.task-item-estimate-sec:nth-child(2) div.panel.panel-default.ScrollStyle:nth-child(3) div.panel-heading.clearfix div.row:nth-child(1) div.col-md-3:nth-child(2) > input.form-control.item_qty:nth-child(2)"));
			if(attributvalue=="")
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].setAttribute('id',"+ 20 +")",elem1);
	       	}
			
		}
	}
	
	public void clickitmCreatebtn()
	{
		this.itmestcreatebtn.click();
		logger.info("---click the create button---");
	}
//10-01-2023
//	*************************Material Request***************************************
	
	@FindBy(xpath="//*[@id='Tasks_project_id']")public WebElement selgrdpjt;
	@FindBy(xpath="//*[@id='create_mr']")public WebElement clickmrcreatebtn;
	@FindBy(xpath="//*[@id='requisition_item']")public WebElement mrselitem;
	@FindBy(xpath="//*[@id='requisition_unit']")public WebElement mrselunit;
	@FindBy(xpath="//*[@id='requisition_quantity']")public WebElement mrquantity;
	@FindBy(xpath="//*[@id='requisition_date']")public WebElement mrdate;
	@FindBy(xpath="//*[@id='requisition_remarks']")public WebElement mrremarks;
	
	
	public void selpjtfrmgrd(String pjt)
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingVisibleText(this.selgrdpjt,pjt );
	}
	public void selmritem(int index) throws AWTException
	{
		
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.mrselitem,index );
		logger.info("---------select material request item-----------");
	}
	public void selmritem1()
	{
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.mrselitem, 2);
		logger.info("---------select material request item-----------");
	}
	public void selmrunit()
	{
		
		DropdownHelper dpsel=new DropdownHelper(driver);
		dpsel.SelectUsingIndex(this.mrselunit, 1);
	}
	public void typequantity()
	{
		this.mrquantity.sendKeys(""+5);
		logger.info("------Type the quantity------");
	}
	public void Typemrdate()
	{
		LocalDate Today_date=java.time.LocalDate.now();
		  this.mrdate.sendKeys(""+Today_date);
		this.mrdate.sendKeys(Keys.ENTER);
		logger.info("-----Entering MR date ------");
		
	}
	public void Typemrremarks()
	{
		this.mrremarks.sendKeys("--Material requested!--------");
	}
	public void ApplymaterialRequest() throws InterruptedException, AWTException
	{
		List<WebElement>lst=driver.findElements(By.xpath("//table//tbody//tr"));
		Thread.sleep(2000);
		for(int i=1;i<=lst.size();i++)
		{
			//
			int j=i+2;
			driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[18]//a[4]")).click();
			Thread.sleep(2000);
			logger.info("--------click MAterial request--------------");
			this.clickmrcreatebtn.click();
			Thread.sleep(2000);
			logger.info("--------click create button--------------");
			WebElement elem=driver.findElement(By.xpath("//span[@id='select2-requisition_item-container']"));
			driver.findElement(By.xpath("//*[@id='requisition_item']//option[@value="+j+"]")).click();
			String itmtext=driver.findElement(By.xpath("//span[@id='select2-requisition_item-container']")).getText();
			DropdownHelper dpsel=new DropdownHelper(driver);
			dpsel.SelectUsingVisibleText(this.mrselitem, itmtext);
			
			
			//-------------------
			
			//String expr = "//*[contains(@id='select2-requisition_item-result-'sometext[a-z]+-text')]"; 
			//driver. findElement(By.xpath(expr)).click();
			selmrunit();
			
			
			
			//--------------
			
			
			
			//driver.findElement(By.xpath("//*[@id='requisition_item']//option[@value="+j+"]")).click();
			//selmritem(+(i+1));
			//driver.navigate().refresh();
			//Thread.sleep(2000);
			//this.clickmrcreatebtn.click();
			//Thread.sleep(2000);
			driver.findElement(By.xpath("//body/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/span[1]/span[1]/span[1]/span[2]")).click();
			//driver.findElement(By.xpath("//*[@id='requisition_item']//option[@value="+j+"]")).click();
			//driver.findElement(By.xpath("//span//ul//li[@id='select2-requisition_item-result-ldv1-1']")).click();
            //selmritem(+(i+1));
			//Thread.sleep(2000);
			selmritem(+(j));
			logger.info("--------Select item for request--------------");
			
			//driver.findElement(By.xpath("//body/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/span[1]/span[1]/span[1]/span[2]")).click();
			driver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys(itmtext);
			
			driver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys(Keys.RETURN);
			/*Robot robo=new Robot();
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);*/
			selmrunit();
			Thread.sleep(2000);
			logger.info("--------select unit of the item--------------");
			typequantity();
			logger.info("--------Type quantity--------------");
			Typemrdate();
			logger.info("--------Type MAterial request date--------------");
			Typemrremarks();
			logger.info("--------Type Material request Remarks--------------");
			driver.navigate().back();
			
		}
	}
	public void Typetaskstartdate(String startdate)//01-02-2023
	{
		this.taskstartdate.clear();
		this.taskstartdate.sendKeys(""+startdate);
	}
	public void Typetaskendate(String enddate)//01-02-2023
	{
		this.taskenddate.clear();
		
		this.taskenddate.sendKeys(""+enddate);
		this.taskenddate.sendKeys(Keys.ENTER);
	}
	public void selexpintrnaltskenddate(String startdate)
	{
		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
		 String date = startdate;

		  //convert String to LocalDate 2023-03-17
		 // LocalDate localDate = LocalDate.parse(date, formatter);
		this.taskenddate.clear();
		logger.info("--------clear end task date---------------------");
		LocalDate Today_date=java.time.LocalDate.now();
		this.taskenddate.sendKeys(""+date);
		
		this.taskenddate.sendKeys(Keys.ENTER);
		logger.info("--------enter end task date---------------------");
	}
	//-----------------03-02-2023-------------------
	public void ClickDeleteTask() throws InterruptedException, AWTException
	{
		List<WebElement>lst=driver.findElements(By.xpath("//table//tbody//tr"));
		Thread.sleep(2000);
		int j=0;
		for(int i=1;i<=lst.size();i++)
		{
			int k=0;
			 j=i;
			 try {
			driver.findElement(By.xpath("//table//tbody//tr["+j+"]//td[18]//a[5]")).click();
			Thread.sleep(2000);
			}
			 catch(Exception ex)
			 {
				 k=i-1;
				 driver.findElement(By.xpath("//table//tbody//tr["+k+"]//td[18]//a[5]")).click();
					Thread.sleep(2000);
			 }
			AlertHelper alert=new AlertHelper(driver);
			alert.AcceptAlertIfPresent();
			Thread.sleep(2000);
			boolean status=false;
			try {
			String deletemsg=driver.findElement(By.xpath("//*[@id='content']/div[3]/text()[1]")).getText();
			if(deletemsg.contains("Cannot Delete ! This record alredy in use."))
			{
				logger.info("------Task cannot delete, -------------");
				j=j;
			}
			else
			{
				
				k=i-1;
			}
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public void DeleteAssignedtasks()
	{// //table//tbody//tr//td[18]//a[5]
		List<WebElement>lst=driver.findElements(By.xpath("//table//tbody//tr"));
		for(int i=1;i<=lst.size();i++)
		{
			driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[18]//a[5]")).click();
		}
	}
	
}












