package com.google;




import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



public class Primary {
	
	public static Logger Log = Utility.getlog(Primary.class);
	
	public WebDriver web;
	
	@BeforeMethod
	@Parameters("browser")
	public void openbrowser (String browser) {
		
		web=ChromeFirefox.driver(browser);
		web.get("https://accounts.lambdatest.com/login");
		web.manage().window().maximize();
		Log.info("Open Browser");
		Log.info(web.getTitle());
		
	}
	
	@AfterMethod
	public void closebrowser () {
		web.close();
		Log.info("Close Browser");
	}

}
