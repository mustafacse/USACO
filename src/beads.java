

/*
ID: mohsinm4
LANG: JAVA
TASK: beads
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class beads {

	static int count = 2;
	static int max = 0;
	static String str;
	static int left;
	static int right;
	static char ch;
	static int len;
	
	public static void leftTraverse()
	{
		while(true)
		{
			if(left - 1 < 0)
			{
				left = len-1;
			}
			else
				--left;
			if(left == right)
				break;
			if(ch == 'w')
			{
				ch = str.charAt(left);
				++count;
			}
			else if(str.charAt(left) == 'w' || (ch == str.charAt(left)))
			{
				++count;
			}
			else
			{
				break;
			}
		}
		
	}
	
	public static void rightTraverse()
	{
		while(true)
		{
			if(right+1 == len)
			{
				right = 0;
			}
			else
				right++;
			if(right == left)
				break;
			if(ch == 'w')
			{
				ch = str.charAt(right);
				++count;
			}
			else if(ch == str.charAt(right) || (str.charAt(right) == 'w'))
			{
				++count;
			}
			else
			{
				break;
			}
		}
	}
	public static void main(String gargs[]) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader("beads.in"));
		PrintWriter writer = new PrintWriter("beads.out");
		
		len = Integer.parseInt(reader.readLine());
		str = reader.readLine();
		
		max = 0;
		for(int i = 0;i < len-1;++i)
		{
			count = 2;
			left = i;
			right = i+1;
			ch = str.charAt(left);
			leftTraverse();
			if(left != right){
				++left;
			ch = str.charAt(right);
			rightTraverse();
			}
			if(count > max)
				max = count;
		}
		writer.println(max);
		writer.close();
		reader.close();
	}
}
