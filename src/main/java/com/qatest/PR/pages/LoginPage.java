package com.qatest.PR.pages;


import org.openqa.selenium.By;

/**
 * *********************************************************************************
 * Author: Salma Akhter
 * Class Name: Login page
 * Description: This class will store all the locator and methods of Login page
 * Reviewer Name:
 * Comments:
 * **********************************************************************************
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;




public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver){
	   this.driver = driver;	
	   }
	
	// WebElements - login page
	@FindBy(name="email") WebElement Username;
    @FindBy(name="password") WebElement Password;
	@FindBy(name="on_submit") WebElement LoginBtn;
	
@Test ()  // Login into the system with valid credentials
public void LoginPageElementsAndMethods(String un, String pass) {
	   try {
		    Thread.sleep(4000); // Wait statement
	            Username.sendKeys(un); // Enter valid username into the field
	            Password.sendKeys(pass); // Enter valid password into the field
	
	            Thread.sleep(4000); // Wait statement
	      
	            // Create object of WebDriverWait class
	             WebDriverWait waitLoginBtn = new WebDriverWait(driver,360);
	             // Wait till element is visible
	             waitLoginBtn.until(ExpectedConditions.elementToBeClickable(LoginBtn));
	
	             LoginBtn.click(); // Click on the Sign In button to login.
	             
	             Thread.sleep(6000);
	             
	             // Validate user login
	        	  WebElement WaystoFile = driver.findElement(By.linkText("Ways to File"));	 
	       	  Assert.assertTrue(WaystoFile.isDisplayed(), "WaystoFile webelement is not displayed"); 
	
        } catch (InterruptedException e) {
      }	
   }

}

/**
 * *********************************************************************
 * End of the file
 * *********************************************************************
 */
