package com.bhiawpkg.Pages;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BHIAW.Helper.DropdownHelper;
import com.BHIAW.Helper.JavascriptHelper;
import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;

public class GalleryPage {
	WebDriver driver;
	Config config;
	Properties pr=new Properties();
	private final Logger logger=LoggerHelper.getLogger(GalleryPage.class);
	public GalleryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Element lcators
	@FindBy(xpath = "//li//a[text()='Gallery']") public WebElement gallery;
	@FindBy(xpath = "//*[@id='daily-work-progress-grid']//table//tbody//tr//td[4][text()='")public WebElement pjtnmebeforepath;
	@FindBy(xpath = "']")public WebElement pjtnmeafterpath;
	@FindBy(xpath = "//*[@id='include_report']")public WebElement btnincluderpt;
	@FindBy(xpath = "//*[@id='project_id']")public WebElement selgallerypjt;
	@FindBy(xpath = "//*[@value='Go']")public WebElement gobtn;
	
	public void clickgallery()
	{
		this.gallery.click();
		logger.info("----------user click gallery----------------------");
	}
 public void setpjtname()
 {
	 String getgallerypjtname=this.pjtnmebeforepath+config.Getactionproject()+pjtnmeafterpath.getText();
	 
 }
/* public void clickchkboxpjtname() throws InterruptedException
 {
	 config=new Config(pr);
	 List<WebElement>elmgallery=driver.findElements(By.xpath("//*[@id='daily-work-progress-grid']//table//tbody//tr//td[4]"));
	
	 for(int i=1;i<=elmgallery.size();i++)
	 {
		 
		String pjtnamerow= driver.findElement(By.xpath("//*[@id='daily-work-progress-grid']//table//tbody//tr["+i+"]//td[4]")).getText();
		String actpjt=config.Getactionproject();
		if(pjtnamerow.equals(config.Getactionproject()))
		{
			WebElement currentelm=driver.findElement(By.xpath("//*[@id='daily-work-progress-grid']//table//tbody//tr["+i+"]//td[1]"));
			currentelm.click();
			Thread.sleep(2000);
			break;
		}
	 }
 }*/
 public void clickincrptbtn() throws InterruptedException
 {
	 JavascriptHelper js=new JavascriptHelper(driver);
	 
	 try {
		 js.scrollUpByPixel();
		 Thread.sleep(2000);
		 this.btnincluderpt.click();
		 logger.info("--------------click include report--------------------");
	 }
	 catch (Exception e) {
		
		 js.scrollDownByPixel();
		 Thread.sleep(2000);
		 this.btnincluderpt.click();
		 logger.info("--------------click include report--------------------");
	}
	 
 }
 public void selgallerypjt(String gallerypjt)
 {
	 DropdownHelper dpgallerypjt=new DropdownHelper(driver);
	 dpgallerypjt.SelectUsingVisibleText(this.selgallerypjt, gallerypjt);
	 logger.info("-----------------selecting the project from gallery-----------------------------");
 }
 public void clickGobtn()
 {
	 this.gobtn.click();
	 logger.info("--------click go button------------");
 }
 
}
