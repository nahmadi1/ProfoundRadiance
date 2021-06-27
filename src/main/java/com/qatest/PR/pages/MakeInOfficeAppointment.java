package com.qatest.PR.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MakeInOfficeAppointment {

	public WebDriver driver;
	public MakeInOfficeAppointment(WebDriver driver){
		this.driver = driver;	
	}

//  Web Elements - <<Make An Appointment For In-office Appointment>> form
	@FindBy(linkText="I Accept") WebElement iAcceptBtn;
	@FindBy(linkText="IN-OFFICE APPOINTMENT") WebElement inOfficeAppmnt;
	@FindBy(xpath="//h1[contains(text(), 'Make An Appointment')]") WebElement makeAppmntPgTitle;

	@Test ()   // Methods - <<Make An Appointment For In-office Appointment>> form
	public void makeInOfficeAppointmentElementsAndMethods() {
		try {
			System.out.println("I am here inside the methode:.......");
			Thread.sleep(4000); // Wait statement
			iAcceptBtn.click();
			Thread.sleep(4000); // Wait statement
			inOfficeAppmnt.click();
			Thread.sleep(6000);
			Assert.assertTrue(makeAppmntPgTitle.isDisplayed(), 
					"<<Make An Appointment For In-office Appointment form>> page title is not displayed"
			);

		} catch (InterruptedException e) {
		}	
	}

}

/**
 * *********************************************************************
 * End of the file
 * *********************************************************************
 */



