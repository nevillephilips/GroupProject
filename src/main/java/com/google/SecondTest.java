package com.google;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.sun.tools.sjavac.Log;

public class SecondTest extends Primary{
	
	public static Logger Log = Utility.getlog(SecondTest.class);
	
	@Test(priority=3)
	public void RealDevice () throws InterruptedException {
		String actualvalue="LambdaTest";
		web.get("https://accounts.lambdatest.com/login");
		web.findElement(By.id("email")).sendKeys("sdsajeeb73@gmail.com");
		web.findElement(By.name("password")).sendKeys("4!fFKtBNRfR9wYz");
		web.findElement(By.id("login-button")).click();
		Thread.sleep(4000);
		web.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div[5]/a[2]")).click();
		Thread.sleep(5000);
		String expectedvalue=web.getTitle();
		Log.info("the title for real device "+expectedvalue);
		Utility.utils(actualvalue, expectedvalue);
	}

}
