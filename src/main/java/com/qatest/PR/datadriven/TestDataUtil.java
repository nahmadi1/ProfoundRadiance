package com.qatest.PR.datadriven;

import java.util.ArrayList;
import com.qatest.PR.util.Excel_Reader;

public class TestDataUtil {
	
	static Excel_Reader reader;
	
	    public static ArrayList<Object[]> getLoginTestData() {
	      ArrayList<Object[]> myData = new ArrayList<Object[]>();
	        try {
	                reader = new Excel_Reader("./TestData/testdata.xlsx");
	               }catch (Exception e) {
	                System.out.println("Unable to get data  >>"+ e.getMessage());
	            }
	        
	        for (int rowCnt = 2; rowCnt <= reader.getRowCount("LoginTestData"); rowCnt++) {
	        
	        String UserID = reader.getCellData("LoginTestData", "Username", rowCnt);
	        String Passwd = reader.getCellData("LoginTestData", "Password", rowCnt);        
	        
	          
	        Object ob[] = {UserID, Passwd};
	          
	        myData.add(ob);
	     
	     }
	return myData;
	    }
	
	

}
