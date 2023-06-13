package com.bhiawpkg.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Sikulitest {
	public static void main(String[] args) throws InterruptedException, FindFailed {
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
	}

}
