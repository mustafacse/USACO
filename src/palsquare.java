/*
ID: mohsinm4
LANG: JAVA
TASK: palsquare
*/



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class palsquare {

	
	public static char arr[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J'};
	public static boolean isPalindrome(String str)
	{
		int len = str.length();
		int start = 0,end = len-1;
		while(start < end)
		{
			if(str.charAt(start) != str.charAt(end))
				return false;
			++start;
			--end;
		}
		return true;
	}
	
	public static String toBase(int square,int base)
	{
		StringBuilder str = new StringBuilder("");
		int val = square;
		while(val >= base)
		{
			str.insert(0,arr[val%base]);
			val /= base;
		}
		str.insert(0,arr[val]);
		return new String(str);
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader("palsquare.in"));
		PrintWriter writer = new PrintWriter("palsquare.out");
		
		int base = Integer.parseInt(reader.readLine());
		for(int num = 1;num <= 300;++num)
		{
			int square = num*num;
			String str = toBase(square,base);
			if(isPalindrome(str))
				writer.println(toBase(num,base)+" "+str);
		}
		
		reader.close();
		writer.close();
	}
}
