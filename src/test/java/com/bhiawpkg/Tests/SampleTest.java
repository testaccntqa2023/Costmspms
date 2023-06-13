package com.bhiawpkg.Tests;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import com.BHIAW.Helper.LoggerHelper;
import com.bhiawpkg.Config.Config;
import com.bhiawpkg.Pages.LoginPage;
import com.bhiawpkg.Pages.ProjectPage;
import com.bhiawpkg.TestBase.TestBase;

public class SampleTest  {
	
	private static Logger logger=LoggerHelper.getLogger(Trial_NewTest.class);
	
	
	
	@Test
	public void Datecompare()
	{
		
		String taskenddate=null;
		//Date date1=taskenddate
	}
	
  @Test
  public void Test() throws ParseException, InterruptedException, FindFailed {
	  
	/*
	 
	SIKULI UPLOAD********************************************
	  String  imagefilepath="C:\\Users\\divya\\OneDrive\\Desktop\\Works\\PMS_WORKSPACE\\BHIAW\\upload-sikuli\\";
	 
	 String inputfilepath="C:\\Users\\divya\\OneDrive\\Desktop\\Works\\PMS_WORKSPACE\\BHIAW\\upload-sikuli\\";
	Screen s=new Screen();
	Pattern	fileinputtextbox=new Pattern(imagefilepath+"Fileinputbox.PNG");
	Pattern openbutton=new Pattern(imagefilepath+"Openbtn.PNG");
	Thread.sleep(5000);
	
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://easyupload.io/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//*[@class='dz-button']")).click();
	  s.wait(fileinputtextbox,20);
		s.type(fileinputtextbox,inputfilepath+"punch6.jpeg");
		s.click(openbutton);
	 // sikuliupload();
		*/
		
		
	/*  LoginPage bhilogin=new LoginPage(driver);
		 
		Config con=new Config(pr);
		 // bhilogin.Login(username, password);
		  bhilogin.Login(con.Getusername(), con.Getpassword());
		  Thread.sleep(2000);
		  logger.info("--------Login is doing------------");
		  bhilogin.Clickbox();
		  logger.info("==============login is sucessful=========================");
		  Thread.sleep(2000);
	 ProjectPage prpg=new ProjectPage(driver);
	 prpg.clickProjectsMenu();
	 prpg.clickProjectscr();
	 prpg.clickAddproject();
	 Thread.sleep(2000);
	 driver.findElement(By.id("ytProjects_report_image")).click();*/
	  
	 
	  
  }
  public void sikuliupload() throws InterruptedException, FindFailed
	{
		
		
	}
	 
	  
	 /* Date date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse("Feb");
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    int month = cal.get(Calendar.MONTH);
	    System.out.println("month is   "+month);
	    System.out.println(month == Calendar.FEBRUARY);*/
	 
	  //System.out.println(new SimpleDateFormat("MMMM").format(date));
	  
	  
	    
/*	  DateTimeFormatter format =  DateTimeFormat.forPattern("dd/MMM/yyyy").withLocale(Locale.ENGLISH);
	  DateTime instance = format.parseDateTime("23/September/2021");  
	  String month_number = String.valueOf(instance.getMonthOfYear());
	    System.out.println("Month in integer ---"+"0"+month_number);*/
	    
	 // Date Today_date=new Date(0, 0, 0)
		
		
	/*	Calendar cal = Calendar.getInstance();
		cal.roll(Calendar.DATE, -1);

		if (myDate.before(cal.getTime())) {
		    //  myDate must be yesterday or earlier
		} else {
		    //  myDate must be today or later
		}
		*/
		
		 Calendar cal1 = Calendar.getInstance();
		 int Currentyear=cal1.getWeekYear();
		 int Currentmonth=cal1.MONTH;
		 
	     // System.out.println("Current year is---"+cal1.getWeekYear());
	     
	       /*   SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
	          Date d1 = sdformat.parse("2021-04-15");
	          
	          Date d2 = sdformat.parse("2021-08-10");
	          System.out.println("The date 1 is: " + sdformat.format(d1));
	          System.out.println("The date 2 is: " + sdformat.format(d2));
	          
	          if(d1.compareTo(d2) > 0) {
	             System.out.println("Date 1 occurs after Date 2--"+sdformat.format(d1));
	          } else if(d1.compareTo(d2) < 0) {
	             System.out.println("Date 1 occurs before Date 2--"+sdformat.format(d2));
	          } else if(d1.compareTo(d2) == 0) {
	             System.out.println("Both dates are equal");
	          }*/
	     // LocalDate Today_date=java.time.LocalDate.now();
		/*  System.out.println("Today date is---"+Today_date); 
	      String dateStr1 = Today_date.toString();
	      System.out.println("========================"+dateStr1);
	      String dateStr2 = "2021-10-01";
	      LocalDate date1 = LocalDate.parse(dateStr1);//------------today date
	      LocalDate date2 = LocalDate.parse(dateStr2);//------------expected date
	      Boolean bool1 = date1.isAfter(date2);  //today date after expected date
	      Boolean bool2 = date1.isBefore(date2); //today date before expected date
	      Boolean bool3 = date1.isEqual(date2); //today date is equal to expected date
	      if(bool1){
	          System.out.println(dateStr1+" is after "+dateStr2);
	       }else if(bool2){
	          System.out.println(dateStr1+" is before "+dateStr2);
	       }else if(bool3){
	          System.out.println(dateStr1+" is equal to "+dateStr2);
	       }
	        */  
	          
	          
	    /*  Date date=new Date();
	      SimpleDateFormat simpleDateFormat= new SimpleDateFormat();
	      Date today = new Date(date.getTime() + TimeUnit.DAYS.toMillis(0 ));
	      DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	      String todaydDate=dateFormat.format(today);
	      System.out.println(todaydDate);
	     */
	      
		
		//LocalDate mydate = LocalDate.now(); // Or whatever you want
		//mydate = mydate.minusMonths(1);
  
}
