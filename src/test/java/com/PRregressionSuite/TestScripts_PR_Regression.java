package com.PRregressionSuite;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qatest.PR.base.BaseClass;
import com.qatest.PR.pages.LoginPage;
import com.qatest.PR.pages.MakeInOfficeAppointment;
import com.qatest.PR.util.Helper;

public class TestScripts_PR_Regression extends BaseClass {
	
	  @Test (priority = 0,dataProvider = "getLoginTestData") // Login into the system with valid credentials
	  public void loginValidation(String UserID, String Passwd){
//	  System.out.println("UserID --> " + UserID); 
//	  System.out.println("Passwd --> " + Passwd); 
	  LoginPage login = PageFactory.initElements(driver,LoginPage.class); 
	            login.LoginPageElementsAndMethods(UserID, Passwd);
	  Helper.captureScreenshot(driver); // screenshot
  }
	  @Test (priority = 1) // Login into the system with valid credentials
	  public void makeInOfficeAppointmentValidation(){
		  MakeInOfficeAppointment  makeInOfficeAppointment = PageFactory.initElements(driver,MakeInOfficeAppointment.class);
		  makeInOfficeAppointment.makeInOfficeAppointmentElementsAndMethods();
		  
		 // MakeInOfficeAppointment .LoginPageElementsAn();
	  Helper.captureScreenshot(driver); // screenshot
  }
	
}
