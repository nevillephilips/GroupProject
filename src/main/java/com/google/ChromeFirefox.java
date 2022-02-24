package com.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChromeFirefox {
	
public static WebDriver driver (String name) {
	WebDriver web=null;
	//String name="chrome";
	
	if (name.equalsIgnoreCase("chrome")) {
	
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\Driver.com\\chromedriver.exe");
	 web=new ChromeDriver ();
	}
	
	else if (name.equalsIgnoreCase("firefox")) {
	
	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\Driver.com\\geckodriver.exe");
	 web=new FirefoxDriver ();
	}
	else {
		System.out.println("Wrong Webbrowser Keyword");
	}
		
	return web;	
	}

}
