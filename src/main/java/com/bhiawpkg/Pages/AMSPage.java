package com.bhiawpkg.Pages;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.BHIAW.Helper.AlertHelper;
import com.BHIAW.Helper.Dateselectionhelper;
import com.BHIAW.Helper.DropdownHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.BHIAW.Helper.Uploadhelper;

public class AMSPage {
	WebDriver driver;
	Properties pr=new Properties();
	private final Logger logger=LoggerHelper.getLogger(AMSPage.class);
	@FindBy(xpath ="//li//a[text()='AMS']")public WebElement AMSMenu;
	@FindBy(xpath ="//li//a[text()='Photo Punch']")public WebElement AMSphotopunch;
	@FindBy(xpath ="//*[@id='upfile']")public WebElement upfileicon;
	@FindBy(xpath ="//*[@id='upfile2']")public WebElement upfileicon2;
	@FindBy(xpath ="//*[@class='punch_detail_sec']//div//input[@value='Submit']")public WebElement submitphotopunch;
	@FindBy(xpath ="//li//a[text()='Photo Punch request']")public WebElement PhotopunchRequest;
	@FindBy(xpath ="//table//thead//tr//td//select[@name='Photopunch[empid]']")public WebElement punchuser;
	@FindBy(xpath ="//*[@id='photo-punch']//div//table//tbody//tr[1]//td[1]")public WebElement chkboxapprove;
	@FindBy(xpath ="//*[@id='photo-punch']//div//table//tbody//tr[1]//td[13]//a[@title='Approve/Reject']")public WebElement Approve_Rejectphotopunch;
	@FindBy(xpath ="//*[@id='punch_site']")public WebElement punch_site;
	@FindBy(xpath ="//*[@id='photo-punch']//table//tbody//tr[1]//td[10]")public WebElement punchtype;
	@FindBy(xpath ="//*[@id='photo-punch']//table//thead//tr//td[4]")public WebElement punchempname;
	@FindBy(xpath ="//*[@id='photo-punch']//table//tbody//tr//td[4]")public WebElement punchallempname;
	@FindBy(xpath ="//*[@id='photo-punch']//table//thead//tr//td[4]//select")public WebElement selpunchempname;
	@FindBy(xpath ="//*[@id='photo-punch']//table//tbody//tr[1]//td[5]")public WebElement punchdate;
	
	
	@FindBy(xpath ="//*[@class='switch-user-custom']//select")public WebElement switchuser;
	@FindBy(xpath ="//*[@id='photo-punch']//table//tbody//tr//td//span")public WebElement photopunchgrid;
	@FindBy(xpath ="//*[contains(text(),'Open Task')]")public WebElement opentskmsg;
	
	
	@FindBy(id="punch_site")public WebElement punchsite;
	@FindBy(xpath ="//*[@class='punch_details panel panel-primary']//div//textarea[@id='reason_value']")public WebElement Punchreason;
	@FindBy(xpath ="//*[@class='punch_details panel panel-primary']//div//input[@id='shi_approve']")public WebElement Approvebtn;
	@FindBy(xpath ="//table//thead//tr//td//select[@name='Photopunch[approved_status]']")public WebElement photopunchstatus;
	@FindBy(xpath="//*[@class='punch_details panel panel-primary']//div//input[@id='shi_reject']")public WebElement Rejectbtn;
	
	@FindBy(xpath="//li//a[text()='Daily Punch log']")public WebElement dailypunchlog;
	@FindBy(xpath="//*[@id='reportdate']")public WebElement dailypunchdate;
	@FindBy(xpath="//*[@id='contact-form']//input[@value='Submit']")public WebElement submitbtn;
	@FindBy(xpath="//*[@name='attendance_type']")public WebElement attendencetype;
	@FindBy(xpath="//*[@id='content']//div//td[3]//a[text()='Export ']")public WebElement pdfexport;
	@FindBy(xpath="//*[@id='content']//div//td[4]//a[text()='Export ']")public WebElement excelexport;
	@FindBy(xpath="//li//a[text()='Punching Report']")public WebElement punchingrpt;
	@FindBy(xpath="//*[@id='sdate']")public WebElement strtdatepunchingrpt;
	@FindBy(xpath="//*[@id='edate']")public WebElement enddatepunchingrpt;
	@FindBy(xpath="//*[@name='code[]']")public WebElement punchuserrpt;
	@FindBy(xpath="//*[@id='search']")public WebElement searchbtn;
	@FindBy(xpath="//*[@name='exportpdf']")public WebElement pdfexportpunch;
	@FindBy(xpath="//*[@name='exportexcel']")public WebElement excelpunchrpt;
	@FindBy(xpath="//h3[text()='Open Task ']")public WebElement opentsk;
//-----------------------------ELEMENT SECTION------------------------------------
	
	public AMSPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void ClickAMSMenu()
	{
		this.AMSMenu.click();
		logger.info("---------clicked AMS menu------------------");
	}
	public void ClickAMSphotopunch()
	{
		this.AMSphotopunch.click();
		logger.info("---------clicked AMSphotopunch option------------------");
	}
	public void Clickupfileicon()
	{
		this.upfileicon.click();
		logger.info("---------click upfile icon--------------");
	}
	public void Clickupfileicon2()
	{
		this.upfileicon2.click();
		logger.info("---------click upfile icon--------------");
	}
	public void callupload(String scrfilepath) throws IOException
	{
		Uploadhelper upload=new Uploadhelper(driver);
		upload.Filetobeload(scrfilepath);
	}
	public void Clicksubmitpunch()
	{
		this.submitphotopunch.click();
		logger.info("-----------click submit for photot punch-----------------");
	}
	public void clickphotopunchrequest()
	{
		this.PhotopunchRequest.click();
		logger.info("--------------click photo punch request-----------------");
	}
	public void selectuser(String punchuser)
	{
		DropdownHelper dpselpunchuser=new DropdownHelper(driver);
		dpselpunchuser.SelectUsingVisibleText(this.punchuser, punchuser);
		logger.info("----------select punch user--------------");
	}
	public String Getactuser()
	{
		logger.info("--------Get actual user for approve---------------");
		return this.punchuser.getText();
		
	}
	public void Clickchkbox()
	{
		this.chkboxapprove.click();
		logger.info("------------clicked check box-------------------------");
	}
	public void ClickphotopunchApprove_Reject()
	{
		this.Approve_Rejectphotopunch.click();
		logger.info("----------------click Approve/Reject button-----------------------------");
	}
	public void Typereason()
	{
		this.Punchreason.sendKeys("ON/OFF TIME");
		logger.info("-------------Enter punch reason------------------");
	}
	public void clickApprove()
	{
		this.Approvebtn.click();
		logger.info("-------------click approve button---------------------------");
	}
	public void clickAlert()
	{
		AlertHelper alertpunch=new AlertHelper(driver);
		alertpunch.getAlert();
		alertpunch.AcceptAlertIfPresent();
		logger.info("-------Accept alert----------");
	}
	public void SelectpunchStatus(String punchstatus)
	{
		DropdownHelper dpselstatus=new DropdownHelper(driver);
		 dpselstatus.SelectUsingVisibleText(this.photopunchstatus, punchstatus);
		logger.info("--------------------select photo punch status------------------------------");
	}
	public String Getstatus()
	{
		logger.info("-------Status getting---------------------");
		return this.photopunchstatus.getText();
	}
	public void clickReject()
	{
		this.Rejectbtn.click();
		logger.info("-----------click reject button-------------------------");
	}
	public void selpunchsite(String pusitename)
	{
		DropdownHelper dpselpusite=new DropdownHelper(driver);
		dpselpusite.SelectUsingVisibleText(this.punch_site, pusitename);
		logger.info("----------select punch site-----------------");
	}
	public String getpunchsite1()
	{
		// WebElement sitename=driver.findElement(By.id("punch_site"));
		 Select s1=new Select(this.punch_site);
		 WebElement sitename_selected= s1.getFirstSelectedOption();
		 String selsitename=sitename_selected.getText();
		 return selsitename;
	}
	public String Getpunchtype()
	{
		logger.info("---------punch type getting------------------");
		return this.punchtype.getText();
		
	}
	public String Getpunchdate()
	{
		logger.info("----------Getting punch date------------- ");
		return this.punchdate.getText();
	}
	
	public String Getpunchempname()
	{
		logger.info("---------punch empname getting------------------");
		return this.punchempname.getText();
		
	}
	public String Getallpunchempname()
	{
		logger.info("---------punch all empname getting------------------");
		return this.punchallempname.getText();
		
	}
	public void selempname(String empname)
	{
		DropdownHelper dpselemname=new DropdownHelper(driver);
		dpselemname.SelectUsingVisibleText(this.selpunchempname, empname);
		logger.info("--------- getting all punch empnames-----------------");
	}
	public void switchuser(String switchusers)
	{
	 DropdownHelper dpselswitchuser=new DropdownHelper(driver);
	 dpselswitchuser.SelectUsingVisibleText(this.switchuser, switchusers);
	 logger.info("--------- switch to another user-----------------");
	}
	public String Getpunchgridtxt()
	{
		logger.info("--------- Grid text getting-----------------");
		return this.photopunchgrid.getText();
	}
	public WebElement getopentskmsg()
	{
		return this.upfileicon2;
	}
	public void clickdailypunchlog()
	{
		this.dailypunchlog.click();
		logger.info("-------------click  daily punch log--------------------");
	}
	public void clickdailypunchdate()
	{
		this.dailypunchdate.click();
		logger.info("---------------click daily punch date------------------------------");
	}
	public void selectpunchdate()
	{
		this.dailypunchdate.getText();
		logger.info("---------------select punch date------------------------------");
	}
	public void selatttype(String attendtype)
	{
		DropdownHelper dpselatttype=new DropdownHelper(driver);
		dpselatttype.SelectUsingVisibleText(this.attendencetype, attendtype);
		logger.info("----------------select attendence type---------------------------------");
	}
	public void clicksubmit()
	{
		this.submitbtn.click();
		logger.info("-----------user click submit button----------------------");
	}
	public void clickpdfexport()
	{
		this.pdfexport.click();
		logger.info("----------click pdf export------------------------");
		
	}
	public void clickexcelexport()
	{
		this.excelexport.click();
		logger.info("----------click Excel export------------------------");
	}
	public void clickpunchingreport()
	{
		this.punchingrpt.click();
		logger.info("----------click punching report------------------------");
	}
	public void clickstartpunchrptdate()
	{
		this.strtdatepunchingrpt.click();
		logger.info("----------click punching report start date-----------------------");
	}
	public void selstrtpunchdate(String exDay,String exMonth,String exYear)
	{
		Dateselectionhelper dpselpunchdate=new Dateselectionhelper(driver);
		dpselpunchdate.selectDate_TimeEntry(exDay,exMonth,exYear);
		logger.info("----------select punching report start date-----------------------");
	}
	public void selpunchrptstrtdate()
	{
		
		this.strtdatepunchingrpt.clear();
		LocalDate Today_date=java.time.LocalDate.now();
		this.strtdatepunchingrpt.sendKeys(""+Today_date.minusMonths(1));
		logger.info("----------select punching report start date-----------------------");
	}
	public void selpunchrptenddate()
	{
		this.enddatepunchingrpt.clear();
		LocalDate Today_date=java.time.LocalDate.now();
		this.enddatepunchingrpt.sendKeys(""+Today_date);
		logger.info("----------select punching report end date-----------------------");
	}
	public void clickendatepunchingrpt()
	{
		this.enddatepunchingrpt.click();
		logger.info("----------click punching report end date------------------------");
	}
	public void selectpunchuser(String punchuser)
	{
		DropdownHelper dpselpunchuser=new DropdownHelper(driver);
		dpselpunchuser.SelectUsingVisibleText(this.punchuserrpt, punchuser);
		logger.info("---------- select punch user------------------------");
	}
	public void clicksearchbtn()
	{
		this.searchbtn.click();
		logger.info("---------- click search button------------------------");
	}
	public void clickpdfexportpunch()
	{
		this.pdfexportpunch.click();
		logger.info("---------- click pdf export button------------------------");
	}
	public void clickexcelexportpunch()
	{
		this.excelpunchrpt.click();
		logger.info("---------- click excel export button------------------------");
	}
	public WebElement getwebelopentsk()
	{
		logger.info("---------- get open tasks ------------------------");
		return this.opentsk;
	}
	public String Getpunchsite()
	{
		logger.info("---------get punch site-------------------");
		return this.punchsite.getText();
	}
	public void selectpunchsite(String pnchsite)
	{
		DropdownHelper dpselpunchsite=new DropdownHelper(driver);
		dpselpunchsite.SelectUsingVisibleText(this.punchsite, pnchsite);
		logger.info("---------- SELECT the punch site ------------------------");
	}
}
