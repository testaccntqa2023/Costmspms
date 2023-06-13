package com.BHIAW.Helper;


import java.io.IOException;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class Uploadhelper {

	private static final Logger log = LoggerHelper.getLogger(Uploadhelper.class);

	private WebDriver driver;
	public Uploadhelper(WebDriver driver) {
		this.driver = driver;
		log.debug("Uploadhelper : " + this.driver.hashCode());
	}
	
	public void Filetobeload(String scriptfilepath) throws IOException
	{
		Runtime.getRuntime().exec(scriptfilepath);
	}
	public void sikuliupload() throws InterruptedException, FindFailed
	{
		String imagefilepath=System.getProperty(("user.dir")+ "\\upload-sikuli\\");
		String inputfilepath=System.getProperty(("user.dir")+ "\\upload-sikuli\\");
		Screen s=new Screen();
		Pattern fileinputtextbox=new Pattern(imagefilepath+"Fileinputbox.PNG");
		Pattern openbutton=new Pattern(imagefilepath+"Openbtn.PNG");
		Thread.sleep(5000);
		s.wait(fileinputtextbox,20);
		s.type(fileinputtextbox,inputfilepath+"punch6.jpeg");
		s.click(openbutton);
	}
}
