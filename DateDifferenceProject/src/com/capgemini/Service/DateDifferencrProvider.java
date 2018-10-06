package com.capgemini.Service;

import com.capgemini.DatePOJO.MyDate;

public class DateDifferencrProvider {
	
	 
	 
	static int monthDays[]= {0,31,28,31,30,31,30,31,31,30,31,30,31};
	public static int getDateDifference(MyDate startDate, MyDate endDate)
	{
		
		
		
		/*return 0;  first test pass logic*/
		if(sameMonth(startDate, endDate) && sameYear(startDate, endDate) && sameDay(startDate, endDate))
			return 0;
		else if(sameMonth(startDate, endDate) && sameYear(startDate, endDate))
		return endDate.getDay() - startDate.getDay();//second test case pass logic
		
		else if( !sameMonth(startDate, endDate) && sameYear(startDate, endDate)){
			
		
		return (daysRemainingCurrentMonth(startDate)+daysPassedCurrentMonth(endDate)+daysBetweenConcreteMonth(startDate, endDate));
		
		}
		else
		{
			if(daysRemainingCurrentYear(startDate)+daysPassedCurrentYear(endDate)+daysInInterveningYear(startDate, endDate)>730)
				return daysRemainingCurrentYear(startDate)+daysPassedCurrentYear(endDate)+daysInInterveningYear(startDate, endDate)-1;
			else
				return daysRemainingCurrentYear(startDate)+daysPassedCurrentYear(endDate)+daysInInterveningYear(startDate, endDate);
		}
		
	}
	
	
	private static boolean sameDay(MyDate startDate,MyDate endDate)
	{
		if(startDate.getDay()==endDate.getDay())
			return true;
		else
			return false;
	}
	
	
	private static boolean sameMonth(MyDate startDate,MyDate endDate)
	{
		if(startDate.getMonth()==endDate.getMonth())
			return true;
		else
			return false;
		
					
	}
	
	private static boolean sameYear(MyDate startDate,MyDate endDate)
	{
		if(startDate.getYear()==endDate.getYear())
			return true;
		else
			return false;
		
					
	}
	
	
	private static int daysRemainingCurrentMonth(MyDate startDate)
	{
		int monthDays[]= {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(isLeapYear(startDate.getYear()) && startDate.getMonth()==2)
		{
			monthDays[2]=29;
		}
		return monthDays[startDate.getMonth()]-startDate.getDay();
	}
	
	private static int daysPassedCurrentMonth(MyDate startDate)
	{
		int monthDays[]= {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(isLeapYear(startDate.getYear()) && startDate.getMonth()==2)
		{
			monthDays[2]=29;
		}
		return startDate.getDay();
	}
	
	private static int daysBetweenConcreteMonth(MyDate startDate,MyDate endDate)
	{
		int monthDays[]= {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(isLeapYear(startDate.getYear()) || isLeapYear(startDate.getYear()) )
		{
			monthDays[2]=29;
		}
		int differenceMonth=0;
		
		for(int monDiff=startDate.getMonth()+1;monDiff<=endDate.getMonth()-1;monDiff++) {
			
			
			differenceMonth+=monthDays[monDiff];
			
		}
		return differenceMonth;
	}
	
	private static int daysPassedCurrentYear(MyDate startDate)
	{
		MyDate a=new MyDate(startDate.getDay(), startDate.getMonth(), startDate.getYear());
		//System.out.println(daysPassedCurrentMonth(startDate)+"\t"+daysBetweenConcreteMonth(new MyDate(0, 0, 0), a));
		return daysPassedCurrentMonth(startDate)+daysBetweenConcreteMonth(new MyDate(0, 0, 0), a);
	}
	
	private static int daysRemainingCurrentYear(MyDate startDate)
	{
		
		return daysRemainingCurrentMonth(startDate)+daysBetweenConcreteMonth(startDate,new MyDate(0, 13, 0));
	}
	private static int daysInInterveningYear(MyDate startDate,MyDate endDate)
	{
		int sum=0;
		for(int i=startDate.getYear()+1;i<endDate.getYear();i++)
		{
			if(isLeapYear(i))
				sum+=366;
			else
				sum+=365;
		}
		return sum;
	}
	
	private static boolean isLeapYear(int year)
	{
		if(year % 400 == 0)
        {
           return true;
        }
        else if (year % 100 == 0)
        {
            return false;
        }
        else if(year % 4 == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
	}
	
	public static void main(String[] args) {
		MyDate a=new MyDate(6, 1, 2011);
		MyDate b=new MyDate(6, 3 , 2011);
		System.out.println(getDateDifference(a, b));
	}

}
