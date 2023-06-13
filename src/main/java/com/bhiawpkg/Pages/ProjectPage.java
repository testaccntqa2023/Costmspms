package com.bhiawpkg.Pages;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.jsoup.parser.ParseError;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.testng.Assert;

import com.BHIAW.Helper.Dateselectionhelper;
import com.BHIAW.Helper.DropdownHelper;
import com.BHIAW.Helper.GenericHelper;
import com.BHIAW.Helper.JavascriptHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.BHIAW.Helper.Radiobuttonhelper;
import com.BHIAW.Helper.Uploadhelper;

import bsh.This;

public class ProjectPage {
	    WebDriver driver;
		Properties pr=new Properties();
		JavascriptHelper js;
		private final Logger logger=LoggerHelper.getLogger(ProjectPage.class);
		@FindBy(linkText ="Projects")public WebElement Projectsmenu;
		@FindBy(xpath="//*[@class='nav navbar-nav navbar-right']//ul[1]//li[4]//ul//li//a[contains(text(),'Projects')]")public WebElement Projectcr;
		@FindBy(xpath ="//*[@class='add link pull-right']")public WebElement Addprojectbtn;
		@FindBy(id ="Projects_name")public WebElement projectName;
		@FindBy(id ="Projects_client_id")public WebElement projectclient;
		@FindBy(xpath="//*[@id='Projects_billable']//input[2]")public WebElement Yesrdbtn;
		@FindBy(xpath="//*[@id='Projects_billable']//input[1]")public WebElement Nordbtn;
		@FindBy(xpath="//*[@id='Projects_status']//input[1]")public WebElement Activestatus;
		@FindBy(xpath="//*[@id='Projects_status']//input[2]")public WebElement InActivestatus;
		@FindBy(id="Projects_start_date")public WebElement Projectstartdate;
		@FindBy(id="Projects_end_date")public WebElement Projectenddate;
		@FindBy(id="Projects_budget")public WebElement Projectbudget;
		@FindBy(id="Projects_total_square_feet")public WebElement Projectsqurefeet;
		@FindBy(xpath="//*[@id='Projects_report_image']")public WebElement Projectimg1;
		//@FindBy(xpath="//form[@id='projects-form']/div[4]/div[2]/input[2][@id='Projects_report_image']")public WebElement Pjtrptimg;
		@FindBy(xpath="/html/body/div[1]/div[2]/div[3]/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/form/div[4]/div[2]/input[2]")public WebElement Pjtrptimg;
		
		@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[4]/div[1]/input[2]")public WebElement Projectimg;
		@FindBy(xpath="//*[@id='Projects_assigned_to']")public WebElement assignedpjtmanagers;
		@FindBy(id="Projects_description")public WebElement pjtdescription;
		@FindBy(xpath="//*[@id='Projects_architect']")public WebElement pjtarchitect;
		
		@FindBy(xpath="//*[@value='Save & Add Project']")public WebElement savepjtbtn;
		@FindBy(xpath ="//*[@id='success_message' and contains(text(),'Successfully created..')]")public WebElement projectsuccessmsg;
		@FindBy(xpath ="//*[@id='projects-grid']//table//thead//tr[2]//td[3]//input[@id='Projects_name']")public WebElement gridpjtname;
		@FindBy(xpath ="//*[@id='projects-grid']//table//tbody//tr//td[13]//a[@title='Edit']")public WebElement editpjtgrid;
		@FindBy(xpath="//*[@value='Update']")public WebElement updatepjtbtn;
		
		@FindBy(id="Projects_name_em_")public WebElement pjtnameexist;
		@FindBy(xpath="//*[@id='projects-grid']//table//tbody//tr[1]//td[3]")public WebElement grdpjtname;
		@FindBy(xpath="//*[@id='projects-grid']//table//tbody//tr[1]//td[6]")public WebElement grdpjtusername;
// **********************************Milestone details*********************************************************//
		@FindBy(id="milestone_details")public WebElement milestonedetails;
		@FindBy(id="Milestone_milestone_title")public WebElement milestonetitle;
		@FindBy(xpath="//*[@name='Milestone[start_date]']")public WebElement milestonestartdate;
		@FindBy(xpath="//*[@name='Milestone[end_date]']")public WebElement milestoneenddate;
		@FindBy(id="Milestone_project_id")public WebElement selectmilestonepjt;
		@FindBy(xpath ="//*[@id='Milestone_budget_id']")public WebElement selmilstonebudhead;
		
		@FindBy(id="Milestone_ranking")public WebElement milestoneranking;
		@FindBy(id="Milestone_status")public WebElement milestonestatus;
		@FindBy(xpath="//*[@value='Save & Add Milestone']")public WebElement savemilestone;
		
// **********************************Main task details***************************************************//	
		@FindBy(xpath="//*[@id='main_task_details']")public WebElement maintasktab;
		@FindBy(xpath="//*[@id='Tasks_project_id']")public WebElement selecttaskpjt;
		@FindBy(xpath="//*[@id='Tasks_title']")public WebElement tasktitle;
		@FindBy(xpath="//*[@name='Tasks[milestone_id]']")public WebElement selecttaskmilestone;
		@FindBy(xpath="//*[@id='Tasks_start_date']")public WebElement taskstartdate;
		@FindBy(xpath="//*[@id='Tasks_due_date']")public WebElement taskenddate;
		@FindBy(xpath="//*[@id='Tasks_ranking']")public WebElement taskranking;
		@FindBy(xpath="//*[@value='Save & Add Main Task']")public WebElement savemaintasks;
//*******************************************************************************************************//	
//***********************************************Area Details*********************************************//
		@FindBy(xpath="//*[@id='area_details']")public WebElement areadetailstab;
		@FindBy(xpath="//*[@id='Area_area_title']")public WebElement areatitle;
		@FindBy(xpath="//*[@id='Area_project_id']")public WebElement selareaproject;
		@FindBy(xpath="//*[@id='Area_status']")public WebElement areastatus;
		@FindBy(xpath="//*[@value='Save & Add Area']")public WebElement saveareadetails;
//*******************************************************************************************************//	
//***********************************************Work Type Details*********************************************//
		@FindBy(xpath="//*[@id='worktype_details']")public WebElement worktypedetailstab;
		@FindBy(xpath="//*[@id='ProjectWorkType_project_id']")public WebElement selworktypeproject;
		@FindBy(xpath="//*[@id='ProjectWorkType_work_type_id']")public WebElement selworktype;
		@FindBy(xpath="//*[@id='ProjectWorkType_ranking']")public WebElement worktyperanking;
		@FindBy(xpath="//*[@value='Save & Add Work type']")public WebElement saveworktype;
		
//*******************************************************************************************************//	
//***********************************************Site Details*********************************************//
	    @FindBy(xpath="//*[@id='worksite_details']")public WebElement worksitedetailstab;
	    @FindBy(xpath="//*[@id='Clientsite_site_name']")public WebElement sitename;
	    @FindBy(xpath="//*[@id='Clientsite_pid']")public WebElement selsiteproject;
	    @FindBy(xpath="//*[@id='Clientsite_latitude']")public WebElement site_latitude;
	    @FindBy(xpath="//*[@id='Clientsite_longitude']")public WebElement site_longitude;
	    @FindBy(xpath="//*[@id='user_assign_model_ids']")public WebElement assignsiteusers;
	    @FindBy(xpath="//*[@id='Clientsite_distance']")public WebElement punchingradius;
	    @FindBy(xpath="//*[@value='Save & Add Site']")public WebElement saveandaddsite;
	    @FindBy(xpath="//*[@id='clientsite-grid']//table//tbody//tr[1]//td[2]")public WebElement pnchsitename;
//*******************************************************************************************************//
	    @FindBy(xpath="//li//a[text()='Gantt Chart']")public WebElement pjtganttchart;
	    @FindBy(id="project_id")public WebElement selpjtGanttChart;
	    @FindBy(xpath="//*[@class='main_content']//a[text()='Excel']")public WebElement pjtGanttChartexceldown;
	    @FindBy(xpath="//*[@class='main_content']//a[text()='PDF']")public WebElement pjtGanttChartpdfdownload;
		
 //*******************************************************************************************************//	
	    @FindBy(linkText ="Master Schedule")public WebElement ProjectsMasterschedule;
	    @FindBy(id ="project_id")public WebElement selPjtsMasterschedule;
	    @FindBy(xpath ="//*[@value='Submit']")public WebElement submitPjtsMasterschedule;	
 //*******************************************************************************************************// 
 //***********************************Project_clone*****************************************************//
	    @FindBy(id ="project_clone_id")public WebElement selpjtclone;
	    //DBTEST
	    @FindBy(xpath ="//*[@id='projects-grid']//table//thead//tr[2]//td[3]//input[@id='Projects_name']")
	    					public WebElement	typepjtname;
	    @FindBy(xpath ="//*[@id='projects-grid']//table//tbody//tr[1]//td[13]//a[@title='Edit']")
	    	   					public WebElement	Pjtgrdedit;
	    
	    @FindBy(xpath ="//*[@id='milestone-grid']//table//tbody//tr//td[8]")public WebElement editmilestonegrd;
	    @FindBy(id ="project_details")public WebElement projectdetailstab;
	    @FindBy(id ="save_btn")public WebElement savebtn;
	    //*****************************************update template**************************//
	    @FindBy(id="Projects_template_id")public WebElement templatename;
	  //***********************************MOM approval*****************************************************//
	  //****************************************project mapping**************************// 
	    @FindBy(xpath="//a[text()='Project Mapping']")public WebElement projectmappinglnk;
	    @FindBy(xpath="//*[@id='acc_project_0']")public WebElement accntspjtname;
	    
	   @FindBy(xpath = "//li//a[text()='Budget Head']") public WebElement budgettab;
	   @FindBy(id="BudgetHead_budget_head_title")public WebElement budgetheadname;
	   @FindBy(xpath = "//*[@id='BudgetHead_project_id']")public WebElement selbudgetpjt;
	   @FindBy(xpath = "//*[@id='BudgetHead_start_date']")public WebElement budgtheadstrtdate;
	   @FindBy(xpath = "//*[@id='BudgetHead_end_date']")public WebElement budgtheadendate;
	   @FindBy(xpath = "//*[@id='BudgetHead_ranking']")public WebElement budgetheadranking;
	   @FindBy(xpath = "//*[@value='Save & Add Budget Head']")public WebElement saveandbudgethead;
	   @FindBy(xpath="//*[@id='projects-grid']//table//tbody//tr[1]//td[8]")public WebElement grdpjtstartdate;
		@FindBy(xpath="//*[@id='projects-grid']//table//tbody//tr[1]//td[9]")public WebElement grdpjtenddate;
	 
		public ProjectPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
//**************************************************Project creation*********************************************//		
		public void clickProjectsMenu()
		{
			this.Projectsmenu.click();
			logger.info("----Projects option is clicked------");
		}
		public void clickProjectscr()
		{
			logger.info("------Going to click projects to create projects-------");
			this.Projectcr.click();
		}
		public void clickAddproject()
		{
			logger.info("------ click Addprojects to create projects-------");
			this.Addprojectbtn.click();
		}
		public void typeprojectname(String pjtname)
		{
			//+RandomStringUtils.randomAlphabetic(2);
			this.projectName.sendKeys(pjtname);
			logger.info("------ Entered project Name-------");
		}
		public void selectclient(String clientname)
		{
			logger.info("-----selecting the client------");
			DropdownHelper dpclient=new DropdownHelper(driver);
			dpclient.SelectUsingVisibleText(projectclient, clientname);
		}
		public void selectbillable()
		{
			Radiobuttonhelper rdbtn=new Radiobuttonhelper(driver);
			rdbtn.clickradiobutton(Yesrdbtn);
			logger.info("-----selecting the billable YES ------");
		}
		public void selectStaus()
		{
			Radiobuttonhelper rdbtn=new Radiobuttonhelper(driver);
			rdbtn.clickradiobutton(Activestatus);
			logger.info("-----selecting the Status - Activestatus ------");
		}
		public void clickstartdatepicker()
		{
			logger.info("-----click the datepicker------");
			this.Projectstartdate.click();
		}
		public void selectstartdate(String exDay, String exMonth, String exYear)
		{
			Dateselectionhelper dmy=new Dateselectionhelper(driver);
			dmy.selectDate(exDay,exMonth,exYear);
			logger.info("-----selecting the startDate ------");
		}
		public void clickenddatepicker()
		{
			logger.info("-----click the datepicker------");
			this.Projectenddate.click();
		}
		public void selectenddate(String exDay, String exMonth, String exYear)
		{
			Dateselectionhelper dmy=new Dateselectionhelper(driver);
			dmy.selectDate(exDay,exMonth,exYear);
			logger.info("-----selecting the EndDate ------");
		}
		public void selectpjtstrtdate1()
		{
			this.Projectstartdate.clear();
			//this.Projectenddate.sendKeys();
			LocalDate Today_date=java.time.LocalDate.now();
			  this.Projectstartdate.sendKeys(""+Today_date);
			this.Projectstartdate.sendKeys(Keys.ENTER);
			logger.info("-----selecting the EndDate ------");
		}
		public String Getpjtstrtdate()
		{
			return   this.Projectstartdate.getText();
		}
		public String Getpjtenddate()
		{
			return   this.Projectstartdate.getText();
		}
		public void selectpjtenddate1()
		{
			this.Projectenddate.clear();
			//this.Projectenddate.sendKeys();
			LocalDate Today_date=java.time.LocalDate.now();
			  this.Projectenddate.sendKeys(""+Today_date.plusDays(31));
			this.Projectenddate.sendKeys(Keys.ENTER);
			logger.info("-----selecting the EndDate ------");
		}
		
		public void typeprojectbudget(String pjtbudget)
		{
			this.Projectbudget.sendKeys(pjtbudget);
			logger.info("------ Entered project  budget-------");
		}
		public void typeprojectsquarefeet(String pjtsqurefeet)
		{
			this.Projectsqurefeet.sendKeys(pjtsqurefeet);
			logger.info("------ Entered project  squarefeet-------");
		}
		public void clickpjtimg() throws InterruptedException
		{
		
			WebElement element = driver.findElement(By.xpath("//*[@id='Projects_img_path']"));
		    JavascriptExecutor executor = (JavascriptExecutor)driver;
		    executor.executeScript("arguments[0].click();", element);
		    Thread.sleep(2000);
			//this.Projectimg1.click();
			logger.info("------click report image button--------------");
			
		}
		public void clickpjtrptimg() throws InterruptedException
		{
			
			//JavascriptHelper jspjtrptim=new JavascriptHelper(driver);
			//jspjtrptim.scrollDownByPixel();
			//Thread.sleep(2000);
				//WebElement element = driver.findElement(By.xpath("//*[@id='Projects_report_image']"));
			//	JavascriptExecutor executor = (JavascriptExecutor)driver;
		    //	executor.executeScript("arguments[0].click();", element);
		    //	Thread.sleep(2000);
			//this.Projectimg1.sendKeys("");
			logger.info("------click report image button--------------");
			driver.findElement(By.xpath("//*[@id='Projects_report_image']")).sendKeys("C:\\Users\\divya\\OneDrive\\Desktop\\Works\\PMS_WORKSPACE\\photopunch\\pc33.jpeg");
			
		}
		public void callupload(String scrfilepath) throws IOException
		{
			Uploadhelper upload=new Uploadhelper(driver);
			upload.Filetobeload(scrfilepath);
		}
		public void assignedpjtmanagers(String pjtmanagername) throws InterruptedException
		{
			js=new JavascriptHelper(driver);
			js.scrollDownByPixel();
			Thread.sleep(2000);
			DropdownHelper dpclient=new DropdownHelper(driver);
			dpclient.SelectUsingVisibleText(this.assignedpjtmanagers, pjtmanagername);
			logger.info("-----selecting the assigned users------");
		}
		public void typeprojectdescription(String pjtdescription)
		{
			this.pjtdescription.sendKeys(pjtdescription);
			logger.info("------ Entering project description-------");
		}

		public void clickSaveproject()
		{
			JavascriptHelper js=new JavascriptHelper(driver);
			js.scrollDownByPixel();
			logger.info("------ click save projects-------");
			this.savepjtbtn.click();
		}
		public boolean verifysuccessfull1()
		{
		return	this.projectsuccessmsg.getText().equals("Successfully created..");
		}
		public void selectProjetimage() throws FindFailed, InterruptedException 
		{
			JavascriptHelper js=new JavascriptHelper(driver);
			js.scrollDownByPixel();
			this.Projectimg.click();
			Uploadhelper sikuupload=new Uploadhelper(driver);
			sikuupload.sikuliupload();
			
		}
		public void callsikuliupload() throws FindFailed, InterruptedException
		{
			Uploadhelper sikuupload=new Uploadhelper(driver);
			sikuupload.sikuliupload();
		}
		public void typepjtarchitect(String architect)
		{
			js=new JavascriptHelper(driver);
			js.scrollDownByPixel();
			this.pjtarchitect.sendKeys(architect);
			logger.info("-----type architect name----------------------------");
		}
		
	//*********************************************Milestone details*********************************************//
		public void clickMilestone()
		{
			logger.info("---------Click milestone tab-------------");
			this.milestonedetails.click();
		}
		public void typemilestonetittle(String milesttitle)
		{
			this.milestonetitle.sendKeys(milesttitle);
			logger.info("---------Enter milestone title-------------");
		}
		
		public void selectmilestoneproject(String milestonepjt)
		{
			logger.info("-----selecting the milestone  project------");
			DropdownHelper dpclient=new DropdownHelper(driver);
			dpclient.SelectUsingVisibleText(selectmilestonepjt,milestonepjt );
		}
		public void selectmolestopjtbudgthead()
		{
			DropdownHelper dpsel=new DropdownHelper(driver);
			dpsel.SelectUsingIndex(this.selmilstonebudhead, 1);
			logger.info("-select milestone budget head---");
		}
		public void clickmilestonestartdate()
		{
			logger.info("-----Milestone start date is clicked-----");
			this.milestonestartdate.click();
		}
		public void clickmilestoneenddate()
		{
			logger.info("-----Milestone end date is clicked-----");
			this.milestoneenddate.click();
		}
		public void selectmilestonestartdate(String exDay, String exMonth, String exYear)
		{
			Dateselectionhelper dmy=new Dateselectionhelper(driver);
			dmy.selectDate(exDay,exMonth,exYear);
			logger.info("-----selecting the milestone startDate ------");
		}
		public void selectmilestonestartdate1() throws InterruptedException
		{
			this.milestonestartdate.clear();
			Thread.sleep(2000);
			LocalDate Today_date=java.time.LocalDate.now();
		   this.milestonestartdate.sendKeys(""+Today_date);
			this.milestonestartdate.sendKeys(Keys.ENTER);
			
		}
		public void selectmilestoneenddate1() throws InterruptedException
		{
			this.milestoneenddate.clear();
			Thread.sleep(2000);
			LocalDate Today_date=java.time.LocalDate.now();
			this.milestoneenddate.sendKeys(""+Today_date.plusDays(30));
			//this.Projectenddate.sendKeys(""+Today_date.plusMonths(1));
			this.milestoneenddate.sendKeys(Keys.ENTER);//this.Projectenddate.sendKeys(""+Today_date.plusMonths(1));
		}
		public void selectmilestoneenddate(String exDay, String exMonth, String exYear)
		{
			Dateselectionhelper dmy=new Dateselectionhelper(driver);
			dmy.selectDate(exDay,exMonth,exYear);
			logger.info("-----selecting the milestone endDate ------");
		}
		public void typemilestoneranking(int milestoneranking)
		{
			this.milestoneranking.sendKeys(""+milestoneranking);
			logger.info("-----Entering milestone ranking------");
		}
		public void typemilestoneranking_pjtclone(String milestoneranking)
		{
			this.milestoneranking.sendKeys(""+milestoneranking);
			logger.info("-----Entering milestone ranking------");
		}
		public void selectmilestonestatus(String milestostatus)
		{
			logger.info("-----selecting the milestone status------");
			DropdownHelper dpmilestonestatus=new DropdownHelper(driver);
			dpmilestonestatus.SelectUsingVisibleText(milestonestatus,milestostatus );
		}
		public void clickSavetmilestone()
		{
			//JavascriptHelper js=new JavascriptHelper(driver);
			//js.scrollDownByPixel();
			logger.info("------ click save milestonedetails-------");
			this.savemilestone.click();
		}
//***********************************************Main Task Details*********************************************//
		public void clickmaintasktab()
		{
			this.maintasktab.click();
			logger.info("---------------------Main tasg tab clicked----------------");
		}
		public void selecttaskpjt(String taskpjt)
		{
			logger.info("-----selecting the task  project------");
			DropdownHelper dptaskselct=new DropdownHelper(driver);
			dptaskselct.SelectUsingVisibleText(selecttaskpjt,taskpjt );
		}
		public void typetasktitle(String tasktitle)
		{
			logger.info("----------------enter task title----------------");
			this.tasktitle.sendKeys(tasktitle);
		}
		public void selecttaskmilestone(String taskmilestone)
		{
			logger.info("-----------------select task milestone----------------");
			DropdownHelper dptaskmilestone=new DropdownHelper(driver);
			dptaskmilestone.SelectUsingVisibleText(selecttaskmilestone, taskmilestone);
		}
		public void clicktaskstartdate()
		{
			logger.info("---------click task start date -------------");
			this.taskstartdate.click();
		}
		public void clicktaskenddate()
		{
			this.taskenddate.click();
			logger.info("---------click task end date -------------");
			
		}
		public void selecttaskstartdate(String exDay, String exMonth, String exYear)
		{
			Dateselectionhelper selecttaskstartdate=new Dateselectionhelper(driver);
			selecttaskstartdate.selectDate(exDay, exMonth, exYear);
			logger.info("---------select task start date -------------");
		}
		public void selecttaskstartdate1() throws InterruptedException
		{
			this.taskstartdate.clear();
			Thread.sleep(2000);
			LocalDate Today_date=java.time.LocalDate.now();
			  this.taskstartdate.sendKeys(""+Today_date);
			this.taskstartdate.sendKeys(Keys.ENTER);
			
		}
		public void selecttaskenddate1() throws InterruptedException
		{
			this.taskenddate.clear();
			Thread.sleep(2000);
			LocalDate Today_date=java.time.LocalDate.now();
			  this.taskenddate.sendKeys(""+Today_date.plusDays(30));
			this.taskenddate.sendKeys(Keys.ENTER);
		}
		public void selecttaskenddate(String exDay, String exMonth, String exYear)
		{
			Dateselectionhelper selecttaskenddate=new Dateselectionhelper(driver);
			selecttaskenddate.selectDate(exDay, exMonth, exYear);
			logger.info("---------select task end date -------------");
		}
		public void typetaskranking(int taskranking)
		{
			this.taskranking.sendKeys(""+taskranking);
			logger.info("-----------------------typing task ranking-------------");
			
		}
		
		public void typetaskranking_pjtclone(String taskranking)
		{
			this.taskranking.sendKeys(""+taskranking);
			logger.info("-----------------------typing task ranking-------------");
			
		}
		public void clicksavetask()
		{
			this.savemaintasks.click();
			logger.info("------------click save and add main task --------------- ");
			
		}
//***********************************************Main Task Details END*********************************************//
//***********************************************Area Details*********************************************//
		public void clickareatab()
		{
		//	areadetailstab.sendKeys(Keys.F5);
			this.areadetailstab.click();
			logger.info("----------------click area details tab------------------------");
		}
		public void typeareatitle(String areatitle)
		{
			this.areatitle.sendKeys(areatitle);
			logger.info("----------------type area title------------------------");
		}
		public void selectareaproject(String areapjt)
		{
			logger.info("-----selecting the area  project------");
			DropdownHelper dpareaselct=new DropdownHelper(driver);
			dpareaselct.SelectUsingVisibleText(selareaproject,areapjt );
		}
		
		public void selectareastatus(String arestatus)
		{
			DropdownHelper dpareastatus=new DropdownHelper(driver);
			dpareastatus.SelectUsingVisibleText(areastatus, arestatus);
			logger.info("----------------select area status------------------------");
		}
		public void clicksavearea()
		{
			this.saveareadetails.click();
			logger.info("---------save area details-------------");
		}
//***********************************************Area Details END*********************************************//
//***********************************************Work Type Details*********************************************//
		public void clickworktypetab()
		{
			this.worktypedetailstab.click();
			logger.info("----------------------Work type details tab clicked---------");
		}
		public void clickmaintask()
		{
			
		}
		
		public void selectworktypeproject(String worktypepjt)
		{
			logger.info("-----selecting the project in a Work type details------");
			DropdownHelper dpworktypepjt=new DropdownHelper(driver);
			dpworktypepjt.SelectUsingVisibleText(selworktypeproject,worktypepjt );
			logger.info("--------------Select the work type project-------------------");
		}	
		/*public void selectworktype(String worktype)
		{
			logger.info("-----selecting the work type in to the project------");
			DropdownHelper dpworktype=new DropdownHelper(driver);
			dpworktype.SelectUsingIndex(selworktype, 3);
			//dpworktype.SelectUsingVisibleText(selworktype,worktype );
		}*/
		public void selectworktype(String wrktype)
		{
			DropdownHelper dpselwrktype=new DropdownHelper(driver);
			dpselwrktype.SelectUsingVisibleText(selworktype, wrktype);
			logger.info("--------------Select the work type-------------------");
			
		}
		public void typeworktyperanking(String worktyperanking)
		{
			this.worktyperanking.sendKeys(worktyperanking);
			logger.info("--------------Enter work type ranking-------------------");
		}
		public void clicksaveworktype()
		{
			logger.info("------------click save and add work type-------------");
			this.saveworktype.click();
		}
//***********************************************Work Type Details END*********************************************//
//***********************************************Site  Details*****************************************************//
		public void clickworksitetab()
		{
			this.worksitedetailstab.click();
			logger.info("----------------------Work site details tab clicked---------");
		}
		public void typesitename(String sitename)
		{
			//+RandomStringUtils.randomAlphabetic(1);
			this.sitename.sendKeys(sitename);
			logger.info("--------------Enter site name-------------------");
		}
		
		public void selectsiteproject(String sitepjt)
		{
			logger.info("-----selecting the site project ------");
			DropdownHelper dpworktypepjt=new DropdownHelper(driver);
			dpworktypepjt.SelectUsingVisibleText(selsiteproject,sitepjt );
		}	
		//public void typelattitude(int lattitude)
		public void typelattitude(String lattitude)
		{
			//this.site_latitude.sendKeys(""+lattitude);
			this.site_latitude.sendKeys(lattitude);
			logger.info("--------------Enter site lattitude-------------------");
		}
		//public void typelongitude(int longitude)
		public void typelongitude(String longitude)
		{
			//this.site_longitude.sendKeys(""+longitude);
			this.site_longitude.sendKeys(longitude);
			logger.info("--------------Enter site longitude-------------------");
		}
		public void assignedsiteusers(String assignsiteuser)
		{
			logger.info("-----selecting the site users------");
			DropdownHelper dpsiteuser=new DropdownHelper(driver);
			dpsiteuser.SelectUsingVisibleText(assignsiteusers, assignsiteuser);
		}
		//public void typepunchingradius(int punchingradius)
		public void typepunchingradius(String punchingradius)
		{
			//this.punchingradius.sendKeys(""+punchingradius);
			this.punchingradius.sendKeys(punchingradius);
			
			logger.info("--------------Enter punching radius-------------------");
		}
		public void clicksavesitedetails()
		{
			logger.info("------------click save and add sitedetails-------------");
			this.saveandaddsite.click();
		}
		
		   
	    public void Clickpjtganttchart()
	    {
	    	this.pjtganttchart.click();
	    	logger.info("------click pjt gantt chart ---------");
	    }
	    public void selganttpjt(String pjtganttname)
	    {
	    	DropdownHelper dpselpjtganttchart=new DropdownHelper(driver);
	    	dpselpjtganttchart.SelectUsingVisibleText(selpjtGanttChart, pjtganttname);
	    	
	    }
	    public void clickExcelgantt()
	    {
	    	this.pjtGanttChartexceldown.click();
	    	logger.info("----------click excel gantt chart -------------------------");
	    }
	    public void clickpdfganttchart()
	    {
	    	this.pjtGanttChartpdfdownload.click();
	    	logger.info("----------click  for pdf gantt chart -------------------");
	    }
	    public String getpjtpunchsite() throws InterruptedException
	    {
	    	logger.info("----------select project punch site -------------------");
	    	Thread.sleep(2000);
	    	return this.pnchsitename.getText();
	    	
	    
	    }
	    
	    public void getgridpjtname(String grdpjtnme)
	    {
	    	this.gridpjtname.sendKeys(grdpjtnme);
	    	logger.info("----------select pjt from pjt grid-------------------");
	    }
	    public void clickgrideditpjt()
	    {
	    	this.editpjtgrid.click();
	    	logger.info("----------click edit in grid----------------");
	    }
//***********************************Master Schedule********************************************************
	    public void clickPjtmasterschedule()
	    {
	    	this.ProjectsMasterschedule.click();
	    	logger.info("-------click project master schedule--------------");
	    }
	    public void selepjtmstrschedule(String selpjtmstrsche)
	    {
	    	DropdownHelper dpselpjtmstrsch=new DropdownHelper(driver);
	    	dpselpjtmstrsch.SelectUsingVisibleText(this.selPjtsMasterschedule, selpjtmstrsche);
	    	logger.info("-----------------select project from project schedule-----------------------");
	    }
	    public void clicksubmitpjtmstrschedule()
	    {
	    	this.submitPjtsMasterschedule.click();
	    	logger.info("-----------------select project from project schedule-----------------------");
	    }
	  //***********************************verify successful********************************************************
	    public boolean verifysuccessfull()
	    {
	    	return driver.getPageSource().contains("Successfully created..");
	    	
	    			
	    }
	    public void typepjtnamegrd(String pjtnme)
	    {
	    	this.typepjtname.sendKeys(pjtnme);
	    	this.typepjtname.sendKeys(Keys.ENTER);
	    }
//---------------------------clone pjt
	    public void selpjtclone(String clonepjt)
	    {
	    	DropdownHelper dpselpjt=new DropdownHelper(driver);
	    	dpselpjt.SelectUsingVisibleText(selpjtclone, clonepjt);
	    	logger.info("------select the  existing project---------------");
	    }
	    public String getdefaultvalueclonepjt()
	    {
	    	Select select = new Select(this.selpjtclone);
	    	WebElement option = select.getFirstSelectedOption();
	    	String defaultItem = option.getText();
	    	System.out.println(defaultItem );
	    	return defaultItem;
	    }
	    public String Getpjtname()
	    {
	    	String pjtname=this.projectName.getText();
	    	return pjtname;
	    }
	    public void clearfiled()
	    { 
	    	this.projectName.clear();
	    	//this.Projectstartdate.clear();
	    	//this.Projectenddate.clear();
	    	this.Projectbudget.clear();
	    	this.Projectsqurefeet.clear();
	    	this.pjtdescription.clear();
	    }
	    //chk pjt exist
	    public WebElement Getelement()
	    {
	    		return this.pjtnameexist;
	    }
	    public void clickpjtgrdEdit()
	    {
	    	this.Pjtgrdedit.click();
	    	logger.info("------------click edit button----------------");
	    }
	    public void GetallEditMaintask() throws InterruptedException
	    {
	    	List<WebElement> editelms=driver.findElements(By.xpath("//*[@id='tasks-grid']//table//tbody//tr//td[7]"));
	    //	try {
	    	Iterator<WebElement>editelmoptions=editelms.iterator();
	    	while (editelmoptions.hasNext()) 
	    	{
				WebElement mile_tskelm = editelmoptions.next();
				mile_tskelm.click();
	    		Thread.sleep(2000);
				LocalDate Today_date=java.time.LocalDate.now();
				this.taskenddate.clear();
				this.taskenddate.sendKeys(""+Today_date.plusDays(20));
				this.taskenddate.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				this.taskranking.clear();
				this.taskranking.sendKeys(""+RandomStringUtils.randomNumeric(2));
				this.savemaintasks.click();
				Thread.sleep(2000);
			}
	    	//for(WebElement we:editelms)
	    	//{
	    		//System.out.println("edit elements"+we);
	    		
	    		
	    		//}
	    		
	    //	}
	    /*	catch(Exception ex)
    		{
    			System.out.println("Element notgetting---");
    		}*/
	    }
	    public void clickmaintskgrd() throws InterruptedException
	    {
	    	List<WebElement> editelms=driver.findElements(By.xpath("//*[@id='tasks-grid']//table//tbody//tr//td[7]"));
	    	System.out.println("count of the row to edit"+editelms.size());
	    	for(int i=1;i<=editelms.size();i++)
			{
	    		js=new JavascriptHelper(driver);	
	    		js.scrollDownByPixel();
					WebElement grdelm=driver.findElement(By.xpath("//*[@id='tasks-grid']//table//tbody//tr["+i+"]//td[7]"));
					grdelm.click();
					Thread.sleep(2000);
					LocalDate Today_date=java.time.LocalDate.now();
					this.taskenddate.clear();
					this.taskenddate.sendKeys(""+Today_date.plusWeeks(2));
					this.taskenddate.sendKeys(Keys.TAB);
					Thread.sleep(2000);
					this.taskranking.clear();
					this.taskranking.sendKeys(""+RandomStringUtils.randomNumeric(2));
					this.savemaintasks.click();
					Thread.sleep(2000);
			}
	    	js.scrollUpVertically();
	    }
	    
	    public void clickEditmilestonegrd() throws InterruptedException
	    {
	    	ProjectPage pjtpg=new ProjectPage(driver);
	    	List<WebElement>milestoneedit=driver.findElements(By.xpath("//*[@id='milestone-grid']//table//tbody//tr//td[8]"));
	    	for(int i=1;i<=milestoneedit.size();i++)
	    	{
	    		js=new JavascriptHelper(driver);	
	    		js.scrollDownByPixel();
	    		WebElement milgrdelm=driver.findElement(By.xpath("//*[@id='milestone-grid']//table//tbody//tr["+i+"]//td[8]"));
	    		
	    		milgrdelm.click();
	    		logger.info("----------click edit milestone--------------------");
	    		this.milestoneenddate.clear();
	    		LocalDate Today_date=java.time.LocalDate.now();
				this.milestoneenddate.sendKeys(""+Today_date.plusWeeks(2));
				Thread.sleep(2000);
	    		this.savemilestone.click();
	    		
	    		
	    	}
	    	js.scrollUpVertically();
	    }
	    
	    
	    public void clickpjtdettab()
	    {
	    	this.projectdetailstab.click();
	    	logger.info("------click project details tab---------------------");
	    }
	    public void updatepjtclone() throws InterruptedException
	    {
	    	this.Projectenddate.clear();
	    	LocalDate Today_date=java.time.LocalDate.now();
	    	this.Projectenddate.sendKeys(""+Today_date.plusWeeks(2));
	    	Thread.sleep(2000);
	    	this.savebtn.click();
	    }
	    public String Getgrdpjtname()
	    {
	    return this.grdpjtname.getText();
	    }
	    public String Getgrdpjtusername()
	    {
	    return this.grdpjtusername.getText();
	    }
	    public void seltemplate(String templatename)
	    {
	    	DropdownHelper dpsel=new DropdownHelper(driver);
	    	dpsel.SelectUsingVisibleText(this.templatename, templatename );
	    }
	    public void clickupdatebtn()
	    {
	    	this.updatepjtbtn.click();
	    	logger.info("--click update button---");
	    }
	   
	    public void clickbudgethead()
	    {
	    	this.budgettab.click();
	    	logger.info("-click budget head tab--");
	    }
	    public void typebudgethead()
	    {
	    	this.budgetheadname.sendKeys("BH"+RandomStringUtils.randomNumeric(2));
	    	logger.info("--enter budget head name--");
	    }
	    public void selbudgetheadpjt(String pjtname)
	    {
	    	DropdownHelper dpsel=new DropdownHelper(driver);
	    	dpsel.SelectUsingVisibleText(selbudgetpjt, pjtname);
	    	logger.info("---select budget head project---");
	    }
	    public void selectbudgetstartdate() throws InterruptedException
		{
			this.budgtheadstrtdate.clear();
			Thread.sleep(2000);
			LocalDate Today_date=java.time.LocalDate.now();
		   this.budgtheadstrtdate.sendKeys(""+Today_date);
			this.budgtheadstrtdate.sendKeys(Keys.ENTER);
			logger.info("--select budget start date--");
		}
		public void selectbudgetenddate() throws InterruptedException
		{
			this.budgtheadendate.clear();
			Thread.sleep(2000);
			LocalDate Today_date=java.time.LocalDate.now();
			this.budgtheadendate.sendKeys(""+Today_date.plusDays(30));
			//this.Projectenddate.sendKeys(""+Today_date.plusMonths(1));
			this.budgtheadendate.sendKeys(Keys.ENTER);//this.Projectenddate.sendKeys(""+Today_date.plusMonths(1));
			logger.info("--select budget end date--");
		}
		public void typebudgtheadranking()
		{
			this.budgetheadranking.sendKeys("1");
			logger.info("--type budget head--");
		}
		public void clicksaveandaddbudgethead()
		{
			this.saveandbudgethead.click();
			logger.info("--click save and add budget head----");
		}
		
		
//-------------------------------------------------------------------------------------------
		//16-12-2022  **********Project Mapping***************
		@FindBy(xpath = "//li//a[text()='Project Mapping']")public WebElement projectmapping;
		@FindBy(xpath = "//table//tbody//tr[1]//td[5]//select[@id='acc_project_0']")public WebElement selpjtmapping;
		@FindBy(xpath = "//table//tbody//tr[1]//td[6]//input[@value='Save']")public WebElement savebtnpjtmap;
				
		 public void clickprojectmapping()
		    {
		    	this.projectmapping.click();
		    }
		    public void selacntspjtname(String acntspjtname)
		    {
		    	List<WebElement>lstpjts=driver.findElements(By.xpath("//table//tbody//tr//td[3]"));
		    	for(int i=1;i<=lstpjts.size();i++)
		    	{
		    		String pjtnme=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[3]")).getText();
		    		if(pjtnme.equals(acntspjtname))
		    		{
		    			WebElement elem=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[5]"));
		    			DropdownHelper dpsel=new DropdownHelper(driver);
		    	    	dpsel.SelectUsingVisibleText(elem, acntspjtname);
		    	    	break;
		    		}
		    	
		    	}
		    }
	    public String Getprojectname()
	    {
	    	String pjtname=null;
	    	pjtname=driver.findElement(By.xpath("//table//tbody//tr[1]//td[3]")).getText();
	    	return pjtname;
	    }
	    public void selpjtformapping(String pjtname)
	    {
	    	//List<WebElement>pjtlst=driver.findElements(By.xpath("//table//tbody//tr[1]//td[3]"))
	    	String pjtnme=driver.findElement(By.xpath("//table//tbody//tr[1]//td[3]")).getText();
	    	if(pjtname.equals(pjtnme))
	    	{
	    		driver.findElement(By.xpath("//*[@id='Projects_name']")).sendKeys(pjtnme);
	    		driver.findElement(By.xpath("//*[@id='Projects_name']")).sendKeys(Keys.ENTER);
	    		//DropdownHelper dpsel=new DropdownHelper(driver);
	    		//dpsel.SelectUsingVisibleText(selpjtmapping, pjtnme);
	    		//dpsel.SelectUsingIndex(selpjtmapping, 1);
	    	}
	    	logger.info("-select the project for mapping----");
	    }
	    public void clicksavebtn()
	    {
	    	this.savebtnpjtmap.click();
	    	logger.info("--click save button---");
	    }
	    
//****************************************Item Estimation**********************************************************
	   @FindBy(xpath = "//li//a[text()='Item Estimation']")public WebElement itemestimate;
	   @FindBy(xpath = "//*[@id='project_id']")public WebElement selitemestimatepjt;
	   @FindBy(xpath = "//*[@id='generate_handson_tbl']")public WebElement itemestgobtn;
	   @FindBy(xpath = "//*[@id='save']")public WebElement itmestsavebtn;
	   @FindBy(xpath = "//a[text()='Create']")public WebElement itmestcreatebtn;
	   @FindBy(css="#save")public WebElement itemestimatesavebtn;
	 
	   public void clickItemestimate()
	   {
		   this.itemestimate.click();
	   }
	    public void selItemEstimatepjt(String pjtname)
	    {
	    	DropdownHelper dpsel=new DropdownHelper(driver);
	    	dpsel.SelectUsingVisibleText(this.selitemestimatepjt,pjtname );
	    	
	    }
	    public void clickitmestmGobutton()
	    {
	    	this.itemestgobtn.click();
	    }
	    public void clickitmestsavebtn()
	    {
	    	this.itmestsavebtn.click();
	    }
	    
	    public String setAttribute( String value) {
	        try {
	            WebElement hraw = driver.findElement(By.xpath("//table//tbody//tr[1]//td[3]"));


	            if (hraw != null) {
	                JavascriptExecutor js = (JavascriptExecutor) driver;
	               // js.executeScript("arguments[0].setAttribute('class','"+ value +"')",hraw);
	                js.executeScript("arguments[0].value=’value’", hraw);
	            }
	        } catch (Exception e) {
	            logger.error("EXCEPTION: In setAttribute: ");
	        }
	        return null;
	    }
	  
		public void clickitmCreatebtn()
		{
			this.itmestcreatebtn.click();
			logger.info("---click the create button---");
		}
		public void clickitemestimatesavebtn()
		{
			this.itemestimatesavebtn.click();
		}
		public void ADDitemquantity() throws InterruptedException
		{
			int rawcnt=driver.findElements(By.xpath("//table//tbody//tr")).size();
			
			for(int i=1;i<=rawcnt;i++)
			{
				int columncnt=driver.findElements(By.xpath("//table//tbody//tr["+i+"]//td")).size();
				for(int j=3;j<=columncnt;j++)
				{
			WebElement itmqtyelement = driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td["+j+"]"));
		
			Thread.sleep(2000);
			Actions actionsqty = new Actions(driver);
			// and some variation of this:
			actionsqty.moveToElement(itmqtyelement, 10, 5)
			.moveByOffset(2, 0).clickAndHold().release()
			.sendKeys("25").perform();
				}
			}
		}
//****************************************Warehouse linking**********************************************************
		@FindBy(xpath = "//li//a[text()='Warehouse Site Linking']")public WebElement warehousesitelink;
		@FindBy(xpath = "//*[@id='warehouse_id']")public WebElement selwarehousename;  
		@FindBy(xpath = "//*[@id='site_id']")public WebElement selwarehousesite;
		@FindBy(css = "#save_btn")public WebElement warehousesavebtn;
		/*
		   #save_btn
		   @FindBy(cs = "")public WebElement
		   @FindBy(xpath = "")public WebElement
		   @FindBy(xpath = "")public WebElement
		   @FindBy(xpath = "")public WebElement
		   @FindBy(xpath = "")public WebElement
		   @FindBy(xpath = "")public WebElement*/
		public void clickwarehousesitelink()
		{
			this.warehousesitelink.click();
		}
		public void selwarehousesite(String warehousesite)
		{
			DropdownHelper dpsel=new DropdownHelper(driver);
			dpsel.SelectUsingVisibleText(selwarehousesite, warehousesite);
		}
		public void selwarehouse() throws InterruptedException
		{
			//this.selwarehousename.click();
			DropdownHelper dpsel=new DropdownHelper(driver);
			dpsel.SelectUsingIndex(selwarehousename, 1);
			Thread.sleep(2000);
		}
		public void clickwarehousesavebtn()
		{
			this.warehousesavebtn.click();
		}
		
		 public String Getgrdpjtstartdate()
		    {
				return this.grdpjtstartdate.getText();
		    	
		    }
		    public String Getgrdpjtenddate()
		    {
		    	return this.grdpjtenddate.getText();
		    	
		    }
		 /* 
		   @FindBy(xpath = "//li//a[text()='Warehouse Site Linking']")public WebElement
		   @FindBy(xpath = "")public WebElement
		   @FindBy(xpath = "")public WebElement
		   */
		    
	//--------------------------------------------Expired Task ----------------------
		    //-------------------16-03-2023---------------------------------
		    @FindBy(xpath = "//*[@id='Projects_name']")public WebElement searchpjtname;
		    @FindBy(xpath = "//*[@id='area-grid']//table//tbody//tr[1]//td[2]")public WebElement areaname;
		    @FindBy(xpath = " //*[@id='worktype-grid']//table//tbody//tr[1]//td[3]")public WebElement worktypename;
		    @FindBy(xpath = "//*[@id='tasks-grid']//table//tbody//tr[1]//td[2]")public WebElement maintaskname;
		  
		    public void searchPjtname(String Pjtname) throws InterruptedException
		    {
		    	this.searchpjtname.sendKeys(Pjtname);
		    	this.searchpjtname.sendKeys(Keys.ENTER);
		    	Thread.sleep(2000);
		    }
		    
		    public String getpjtpuncharea()
		    {
		    	logger.info("----------select pjt punch site -------------------");
		    	return this.areaname.getText();
		     }
		    public String getworktypename() throws InterruptedException
		    {
		    	logger.info("----------select pjt punch site -------------------");
		    	Thread.sleep(2000);
		    	return this.worktypename.getText();
		     }
		    public String getmaintaskname() throws InterruptedException
		    {
		    	logger.info("----------select pjt punch site -------------------");
		    	Thread.sleep(2000);
		    	return this.maintaskname.getText();
		    }
}

















