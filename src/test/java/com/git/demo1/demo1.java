package com.git.demo1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demo1 {
	
	WebDriver driver;
	
	@FindBy(css=".lnXdpd")
	WebElement imgGoogle;
	
	@BeforeMethod
	public void init_driver() {
		
		driver = new ChromeDriver();		
		driver.get("https://www.google.com/");
		
		PageFactory.initElements(driver, this);
			
	}
	
	@Test (priority = 1)
	public void verifyTitleTest() {
		
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "Google";
		
		Assert.assertEquals(actualTitle, expectedTitle,"Title does not match");
		
		System.out.println("verifyTitleTest executed...");
		
	}
	
	@Test (priority = 2)
	public void verifyIsImageDisplayedTest() {

		Assert.assertTrue(imgGoogle.isDisplayed(),"Google image does not displayed");
		
		System.out.println("verifyIsImageDisplayedTest executed...");
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	

}
