package com.capgemini.Test;

import java.util.ArrayList;

import com.capgemini.DatePOJO.MyDate;
import com.capgemini.Service.DateDifferencrProvider;

public class DateDifferenceTestClass {
	
	
	public static void main(String[] args) {
		
		ArrayList<MyDateTestRecords> testRecords=new ArrayList<>();
		testRecords.add(new MyDateTestRecords(new MyDate(6, 4, 2011), new MyDate(6, 4, 2011), 0));
		
		testRecords.add(new MyDateTestRecords(new MyDate(6, 4, 2011), new MyDate(18, 4, 2011), 12));
		testRecords.add(new MyDateTestRecords(new MyDate(6, 4, 2011), new MyDate(18, 5, 2011), 42));
		testRecords.add(new MyDateTestRecords(new MyDate(6, 4, 2011), new MyDate(18, 6, 2011), 73));
		testRecords.add(new MyDateTestRecords(new MyDate(6, 4, 2011), new MyDate(18, 12, 2011), 256));
		testRecords.add(new MyDateTestRecords(new MyDate(6, 4, 2011), new MyDate(18, 12, 2012), 622));
		testRecords.add(new MyDateTestRecords(new MyDate(6, 4, 2011), new MyDate(18, 12, 2013), 987));
		testRecords.add(new MyDateTestRecords(new MyDate(6, 4, 2011), new MyDate(18, 12, 2113), 37511));
		testRecords.add(new MyDateTestRecords(new MyDate(6, 4, 2011), new MyDate(18, 12, 2413), 147084));
		testRecords.add(new MyDateTestRecords(new MyDate(6, 4, 2011), new MyDate(18, 12, 2813), 293181));
		
		
		
		testRecords.add(new MyDateTestRecords(new MyDate(6, 1, 2011), new MyDate(6, 3, 2011), 59));
		testRecords.add(new MyDateTestRecords(new MyDate(6, 1, 2012), new MyDate(6, 3, 2012), 60));
		testRecords.add(new MyDateTestRecords(new MyDate(6, 2, 2012), new MyDate(6, 3, 2012), 29));
		testRecords.add(new MyDateTestRecords(new MyDate(22, 1, 2012), new MyDate(15, 11, 2012), 298));
		testRecords.add(new MyDateTestRecords(new MyDate(6, 2, 2012), new MyDate(6, 12, 2012), 304));
		
		for(MyDateTestRecords testCase : testRecords ){
            MyDate startDate=testCase.startDate;
            MyDate endDate=testCase.endDate;
            long expectedResult=testCase.expectedResult;
            long obtainedResult=DateDifferencrProvider.getDateDifference(startDate, endDate);
            
            if(expectedResult == obtainedResult)
                  System.out.println("test "+(1+testRecords.lastIndexOf(testCase)) + " passed " + obtainedResult+ "=obtainedResult " +expectedResult+ "=expectedResult");
            else
                  System.err.println("test "+(1+testRecords.lastIndexOf(testCase)) + " failed " + obtainedResult+ "=obtainedResult " +expectedResult+ "=expectedResult");
     }

	}
	
	

}
