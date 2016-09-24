/*
ID: mohsinm4
LANG: JAVA
TASK: dualpal
*/



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class dualpal {

	public static final char[] arr = {'0','1','2','3','4','5','6','7','8','9'};
	
	public static boolean generate(int num)
	{
		int count = 0;
		for(int i = 2;i <= 10;++i)
		{
			if(isPalindrome(toBase(num,i)))
				++count;
			if(count == 2)
				break;
		}
		if(count == 2)
			return true;
		return false;
	}
	
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
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader("dualpal.in"));
		PrintWriter writer = new PrintWriter("dualpal.out");
		
		String input[] = reader.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int s = Integer.parseInt(input[1]);
		
		int count = 0;
		int num = s+1;
		while(count < n)
		{
			if(generate(num))
			{
				writer.println(num);
				++count;
			}
			++num;
		}
		writer.close();
		reader.close();
	}

}
