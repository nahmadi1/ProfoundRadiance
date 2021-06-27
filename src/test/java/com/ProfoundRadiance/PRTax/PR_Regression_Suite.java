package com.ProfoundRadiance.PRTax;

/**
 * *********************************************************************
 * Author: Salma Akhter
 * Class Name: PR_Regression_Suite
 * Description: This class will navigate to user to login to the system
 * Reviewer Name:
 * Comments:
 * *********************************************************************
 */

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class PR_Regression_Suite {
	
	public WebDriver driver;
    public String baseurl = "https://www.aydentax.com/login.php";

  @Test
  public void PRuserInOfficeAppointment() throws InterruptedException {
	  
	  
	  // User Login
	  driver.findElement(By.name("email")).sendKeys("akhtersalma68@gmail.com");
      driver.findElement(By.name("password")).sendKeys("SanjidHasan04$");
      Thread.sleep(3000);
      driver.findElement(By.name("on_submit")).click(); 
      Thread.sleep(6000);
      
      // Validate user login
 	  WebElement WaystoFile = driver.findElement(By.linkText("Ways to File"));	 
	  Assert.assertTrue(WaystoFile.isDisplayed(), "WaystoFile webelement is not displayed"); 
	  Thread.sleep(6000);
	  
      // Click on the pop-up
	  driver.findElement(By.linkText("I Accept")).click();
	  Thread.sleep(4000);
  
	  // IN-OFFICE APPOINTMENT
	  driver.findElement(By.linkText("Ways to File")).click(); 
	  Thread.sleep(2000);
	  
	  //driver.switchTo().alert().accept();
	  driver.findElement(By.linkText("IN-OFFICE APPOINTMENT")).click();
	  Thread.sleep(4000);
	  
      WebElement makeAnAppointment = driver.findElement(By.xpath("//h1[contains(text(), 'Make An Appointment')]"));
      Assert.assertTrue(makeAnAppointment.isDisplayed(), "makeAnAppointment webelement is not displayed");
      
      
      driver.findElement(By.name("filing_case_appointment_date")).sendKeys("04/24/2021");
      Thread.sleep(8000);
      driver.findElement(By.xpath("//input[@type ='radio' and @value ='7']")).click();
      
      driver.findElement(By.name("user_address_line1")).sendKeys("6256 Blue Dart Pl");
      driver.findElement(By.name("user_city")).sendKeys("Columbia");
      driver.findElement(By.name("user_state")).sendKeys("Maryland");
      driver.findElement(By.name("user_zipcode")).sendKeys("21045");
      driver.findElement(By.name("user_ssn")).sendKeys("8853");
      Thread.sleep(4000);
      
      
      driver.findElement(By.xpath("//input[@type ='checkbox' and @value ='1']")).click();
      Thread.sleep(4000);
      
      driver.findElement(By.name("on_submit")).click();
      Thread.sleep(2000);
      WebElement completeSchedule = driver.findElement(By.linkText("Complete Schedule"));
      Assert.assertTrue(completeSchedule.isDisplayed(), "completeSchedule webelement is not displayed");
      
      driver.findElement(By.linkText("Complete Schedule")).click();
      
      WebElement appointTime = driver.findElement(By.xpath("//p[contains(text(), 'Appointment Time: 02:00 PM')]"));
      Assert.assertTrue(appointTime.isDisplayed(), "appointTime webelement is not displayed");
  
  }
  
  /*
  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }
  
*/
  @BeforeClass
  public void beforeClass() throws InterruptedException {
	  
	WebDriverManager.chromedriver().setup();
	//WebDriverManager.firefoxdriver();
	//WebDriverManager.iedriver();
	  
	 driver = new ChromeDriver();
	 
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
	 driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	 driver.get(baseurl); // Navigate to the expected URL
	 Thread.sleep(6000);
	 
	 WebElement syslogo = driver.findElement(By.linkText("Profound Radiance"));	 
	 Assert.assertTrue(syslogo.isDisplayed(), "syslogo webelement is not displayed");
	 Thread.sleep(6000);
	 
	 
  } 
}


/**
 * *********************************************************************
 * End of the file
 * *********************************************************************
 */
