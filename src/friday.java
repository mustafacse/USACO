/*
ID: mohsinm4
LANG: JAVA
TASK: friday
*/



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class friday {

	public static int prevNoOfDays = 0;
	
	public static boolean isLeapYear(int year)
	{
		if(year % 400 == 0)
			return true;
		else if(year % 4 == 0 && year % 100 != 0)
			return true;
		else
			return false;
	}
	
	public static int noOfDaysInMonth(int year,int month)
	{
		boolean flag = isLeapYear(year);
		if(flag && month == 2)
			return 29;
		if(month == 2)
			return 28;
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			return 31;
		return 30;
	}
	
	public static int resultantDay(int year,int month)
	{
		int startDay = prevNoOfDays%7;
		int res = (startDay+12)%7;
		return res;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader reader = new BufferedReader(new FileReader("friday.in"));
		PrintWriter writer = new PrintWriter("friday.out");
		
		int countArray[] = new int[7];
		int n = Integer.parseInt(reader.readLine());
		int range = n+1900-1;
		for(int year = 1900;year <= range;++year)
		{
			for(int month = 1;month <= 12;++month)
			{
				++countArray[resultantDay(year,month)];
				prevNoOfDays += noOfDaysInMonth(year,month);
			}
			//System.out.println(prevNoOfDays);
		}
		
		writer.println(countArray[5]+" "+countArray[6]+" "+countArray[0]+" "+countArray[1]+" "+countArray[2]+" "+countArray[3]+" "+countArray[4]);
		//System.out.println(prevNoOfDays);
		
		reader.close();
		writer.close();
	}

}
