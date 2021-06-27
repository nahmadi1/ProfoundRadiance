package com.qatest.PR.base;

/**
 * ********************************************************************************************************************
 * Author: Salma Akhter
 * Class Name: Base Class
 * Description: This class will store precondition (open browser) and post condition (open browser) of all the scripts
 * Reviewer Name:
 * Comments:
 * *********************************************************************************************************************
 */

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.qatest.PR.datadriven.TestDataUtil;
import com.qatest.PR.util.BrowserFactory;
import com.qatest.PR.util.ConfigDataProvider;
import com.qatest.PR.util.Helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class BaseClass {

	
	public WebDriver driver;
	public ConfigDataProvider config;
	
	  @BeforeSuite
	  public void setUpSuite() {
		
		config = new ConfigDataProvider();
	}
		
	   @BeforeClass
	   public void StartBrowser() {	
		  try {
			  
		     driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL());
		  
		    Thread.sleep(2000);
   //       System.out.println(driver.getTitle());
		    Assert.assertEquals(driver.getTitle(), "aydentax.com/");	
		    driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	     }  catch (InterruptedException e) {
	     }
	   } 
	 
	   @AfterClass
	   public void CloseBrowser() {	
		  BrowserFactory.closeBrowser(driver);	 
		 }
		 
	
	   
	  @AfterMethod
	      public void tearDownMethod (ITestResult result) {
	      
	         if (result.getStatus()== ITestResult.FAILURE) {
	        	  Helper.captureScreenshot(driver);
	         }        
       }
	  
	  @DataProvider
	  public Iterator<Object[]> getLoginTestData() { 
		     ArrayList<Object[]> testData = TestDataUtil.getLoginTestData(); 
		     return testData.iterator(); }  
  
	   
}

/**
 * *********************************************************************
 * End of the file
 * *********************************************************************
 */
