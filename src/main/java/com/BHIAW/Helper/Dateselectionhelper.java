package com.BHIAW.Helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dateselectionhelper {
	
	private WebDriver driver;
	private Logger Log = LoggerHelper.getLogger(Dateselectionhelper.class);

	public Dateselectionhelper(WebDriver driver) {
		this.driver = driver;
		Log.debug("Dateselectionhelper : " + this.driver.hashCode());
	}
	public   String[] getMonthYear(String monthYearVal )
	{
		return monthYearVal.split(" ");
		
	}
	
public static String getCurrentDateTime() {
		

		DateFormat dateFormat = new SimpleDateFormat("_yyyy-MM-dd_HH-mm-ss");
	
		Calendar cal = Calendar.getInstance();
		String time = "" + dateFormat.format(cal.getTime());
		return time;
	}

	public static String getCurrentDate() {
		return getCurrentDateTime().substring(1, 11);
	}

	
	public  void selectDatewpr(String exDay,String exMonth,String exYear)
	{
		
		if(exMonth.equals("February")&&Integer.parseInt(exDay)>29)
		{
			System.out.println("Wrong Date:"+exMonth+":"+exDay);
			return;
		}
		if(Integer.parseInt(exDay)>31)
		{
			System.out.println("Wrong Date:"+exMonth+":"+exDay);
			return;
		}
		String monthYearVal=driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println(monthYearVal);
		String ExpMnthYear=exMonth + exYear;
		System.out.println("Expected month and Year is "+ExpMnthYear);
		
		while(!(getMonthYear(monthYearVal)[0].equals(exMonth)&&getMonthYear(monthYearVal)[1].equals(exYear)))
		{
		   driver.findElement(By.xpath("//a[@title='Prev']")).click();
			monthYearVal=driver.findElement(By.className("ui-datepicker-title")).getText();
		}
		try
		{
			//driver.findElement(By.xpath("//a[text()='"+exDay+"']")).click();
			driver.findElement(By.xpath("//*[@class='ui-datepicker-calendar']//tr//td//a[contains(text(),"+exDay+")]")).click();
		}
		catch(Exception e)
		{
			System.out.println("Wrong date :"+exMonth+":"+exDay);
		}
		
	}
	public  void selectDate(String exDay,String exMonth,String exYear)
	{
		
		if(exMonth.equals("February")&&Integer.parseInt(exDay)>29)
		{
			System.out.println("Wrong Date:"+exMonth+":"+exDay);
			return;
		}
		if(Integer.parseInt(exDay)>31)
		{
			System.out.println("Wrong Date:"+exMonth+":"+exDay);
			return;
		}
		String monthYearVal=driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println(monthYearVal);
		String ExpMnthYear=exMonth + exYear;
		System.out.println("Expected month and Year is "+ExpMnthYear);
		
		while(!(getMonthYear(monthYearVal)[0].equals(exMonth)&&getMonthYear(monthYearVal)[1].equals(exYear)))
		{
		   driver.findElement(By.xpath("//a[@title='Next']")).click();
			monthYearVal=driver.findElement(By.className("ui-datepicker-title")).getText();
		}
		try
		{
			//driver.findElement(By.xpath("//a[text()='"+exDay+"']")).click();
			driver.findElement(By.xpath("//*[@class='ui-datepicker-calendar']//tr//td//a[contains(text(),"+exDay+")]")).click();
		}
		catch(Exception e)
		{
			System.out.println("Wrong date :"+exMonth+":"+exDay);
		}
		
	}
	public   String[] getMonthYear1(String monthYearValue)
	{
		return monthYearValue.split(", ");
		
	}
	
	public  void selectDate_TimeEntry(String exDay,String exMonth,String exYear)
	{
		
		if(exMonth.equals("February")&&Integer.parseInt(exDay)>29)
		{
			System.out.println("Wrong Date:"+exMonth+":"+exDay);
			return;
		}
		if(Integer.parseInt(exDay)>31)
		{
			System.out.println("Wrong Date:"+exMonth+":"+exDay);
			return;
		}
		String monthYearValue=driver.findElement(By.xpath("//*[@class='calendar']//thead//tr[1]//td[2]")).getText();
		System.out.println(monthYearValue);
		while(!(getMonthYear1(monthYearValue)[0].equals(exMonth)&&getMonthYear1(monthYearValue)[1].equals(exYear)))
		{
			driver.findElement(By.xpath("//*[@class='calendar']//thead//tr[2]//td[4]")).click();
			monthYearValue=driver.findElement(By.xpath("//*[@class='calendar']//thead//tr[1]//td[2]")).getText();;
		}
		try
		{
			//driver.findElement(By.xpath("//a[text()='"+exDay+"']")).click();
			driver.findElement(By.xpath("//*[@class='calendar']//table//tbody/tr//td[contains(text(),"+exDay+")]")).click();
			
			//driver.findElement(By.xpath("//*[@class='ui-datepicker-calendar']//tr//td//a[contains(text(),"+exDay+")]")).click();
		}
		catch(Exception e)
		{
			System.out.println("Wrong date :"+exMonth+":"+exDay);
		}
	
		
	}
	
	public void selpjtfromreportdate(String exMonth,String exYear, String exDay)
	{
		WebElement dpmonth=driver.findElement(By.xpath("//*[@class='ui-datepicker-title']//select[@class='ui-datepicker-month']"));
		  String fullmonth=dpmonth.getText();
		  DropdownHelper dpselmonth=new DropdownHelper(driver);
		  dpselmonth.SelectUsingVisibleText(dpmonth, exMonth);
		  WebElement dpyear=driver.findElement(By.xpath("//*[@class='ui-datepicker-title']//select[@class='ui-datepicker-year']"));
	       DropdownHelper dpselyear=new DropdownHelper(driver);
	       dpselyear.SelectUsingVisibleText(dpyear, exYear);
	       driver.findElement(By.xpath("//*[@class='ui-datepicker-calendar']//tbody//tr//td//a[contains(text(),"+exDay+")]")).click();
	}
	
	
	
	public void selectdate1(String exDay,String exMonth,String exYear) throws ParseException
	{
		
		
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String exdate=exDay+"/"+exMonth+"/"+exYear;
		LocalDate Today_date=java.time.LocalDate.now();
		  System.out.println("Today date is---"+Today_date); 
		if(sdf.format(exdate).equals(sdf.format(Today_date)))
		{
			
		}
		
		
		/*LocalDate Today_date=java.time.LocalDate.now();
		  System.out.println("Today date is---"+Today_date); 
	      String dateStr1 = Today_date.toString();
	      System.out.println("========================"+dateStr1);
	      String dateStr2 = "2021-10-01";
	      String exdate=exDay+"/"+exMonth+"/"+exYear;
	     // DateTimeFormatter format1=DateTimeFormat.forPattern(exdate)
	      DateTimeFormatter format =  DateTimeFormat.forPattern("dd/MMM/yyyy").withLocale(Locale.ENGLISH);
		  DateTime instance = format.parseDateTime(exdate);  
		  String month_number = String.valueOf(instance.getMonthOfYear());
		  
		    System.out.println("Month in integer ---"+"0"+month_number);
	      
		    
		
	     
	      
	      
  	      System.out.println("(((((((((((((((("+exdate);
	      LocalDate date1 =LocalDate.parse(dateStr1);//------------today date
	    		  //LocalDate.parse(dateStr1);
	      String exdate1=exYear+"-"+month_number+"-"+exDay;
	      System.out.println("compare month is "+exdate1);
	     // System.out.println(new SimpleDateFormat("MMMM").format(exdate));
	      LocalDate date2 = LocalDate.parse(exdate1);//------------expected date
	     
	      Boolean bool1 = date1.isAfter(date2);  //today date after expected date
	      Boolean bool2 = date1.isBefore(date2); //today date before expected date
	      Boolean bool3 = date1.isEqual(date2); //today date is equal to expected date
	      if(bool1){
	          System.out.println(dateStr1+" is after "+dateStr2);
	       }else if(bool2){
	          System.out.println(dateStr1+" is before "+dateStr2);
	       }else if(bool3){
	          System.out.println(dateStr1+" is equal to "+dateStr2);
	       }*/
	}
	
	
}
