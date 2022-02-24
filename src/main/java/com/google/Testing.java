package com.google;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.tools.sjavac.Log;

public class Testing extends Primary {
	
	public static Logger Log = Utility.getlog(Testing.class);
	
	@BeforeSuite
	public static void bsuite() {
		Log.info("before suite");
	}
	@AfterSuite
	public static void asuite() {
		Log.info("after suite");
	}
	@BeforeTest
	public static void btest() {
		Log.info("before test");
	}
	@AfterTest
	public static void atest() {
		Log.info("after test");
	}
	@BeforeClass
	public static void bclass() {
		Log.info("before class");
	}
	@AfterClass
	public static void aclass() {
		Log.info("after class");
	}
	@Test(priority=1)
	public void verifytest () throws InterruptedException {
		String actualvalue="Welcome - LambdaTest";
		web.get("https://accounts.lambdatest.com/login");
		web.findElement(By.id("email")).sendKeys("sdsajeeb73@gmail.com");
		web.findElement(By.name("password")).sendKeys("4!fFKtBNRfR9wYz");
		web.findElement(By.id("login-button")).click();
		Thread.sleep(5000);
		String expectedvalue=web.getTitle();
		Log.info(expectedvalue);
		Utility.utils(actualvalue, expectedvalue);
	}
	@Test(dataProvider="OSA",dataProviderClass=Utility.class)
	public void RealTimeBrowserTest (String name, String Pass) throws InterruptedException {
		String actualvalue="Realtime Browser Test";
		web.get("https://accounts.lambdatest.com/login");
		web.findElement(By.id("email")).sendKeys(name);
		web.findElement(By.name("password")).sendKeys(Pass);
		web.findElement(By.id("login-button")).click();
		Thread.sleep(4000);
		web.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div[2]/a")).click();
		Thread.sleep(5000);
		String expectedvalue=web.getTitle();
		Log.info("the title is "+expectedvalue);
		Utility.utils(actualvalue, expectedvalue);
	}
	

}
