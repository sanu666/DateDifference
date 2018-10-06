package com.capgemini.Test;

import com.capgemini.DatePOJO.MyDate;

public class MyDateTestRecords {
	public MyDate startDate;
	public MyDate endDate;
	public int expectedResult;
	
	public MyDateTestRecords(MyDate startDate, MyDate endDate, int expectedResult) {	
		this.startDate = startDate;
		this.endDate = endDate;
		this.expectedResult = expectedResult;
	}
	
	
	

}
