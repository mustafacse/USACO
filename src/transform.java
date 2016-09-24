/*
ID: mohsinm4
LANG: JAVA
TASK: transform
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class transform {

	public static char[][] transpose(char mat[][])
	{
		char newMat[][] = new char[mat.length][mat.length];
		for(int i = 0;i < mat.length;++i)
		{
			for(int j = 0;j < mat.length;++j)
			{
				newMat[j][mat.length-i-1] = mat[i][j];
			}
		}
		return newMat;
	}
	
	public static char[][] reflect(char mat[][])
	{
		char newMat[][] = new char[mat.length][mat.length];
		for(int i = 0;i < mat.length;++i)
		{
			for(int j = 0;j < mat.length;++j)
			{
				newMat[i][mat.length-j-1] = mat[i][j];
			}
		}
		return newMat;
	}
	
	public static void print(char [][]arr)
	{
		for(int i = 0;i < arr.length;++i)
		{
			for(int j = 0;j < arr.length;++j)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		/*char [][]mat = {{'a','b','c'},{'d','e','f'},{'g','h','i'}};
		print(mat);
		char [][]trans = transpose(mat);
		char [][]ref = reflect(mat);
		print(trans);
		print(ref);*/
		
		BufferedReader reader = new BufferedReader(new FileReader("transform.in"));
		PrintWriter writer = new PrintWriter("transform.out");
		
		int n = Integer.parseInt(reader.readLine());
		char input[][] = new char[n][n];
		for(int row = 0;row < n;++row)
		{
			String str = reader.readLine();
			for(int col = 0;col < n;++col)
				input[row][col] = str.charAt(col);
		}
		
		char target[][] = new char[n][n];
		for(int row = 0;row < n;++row)
		{
			String str = reader.readLine();
			for(int col = 0;col < n;++col)
				target[row][col] = str.charAt(col);
		}
		
		if(Arrays.deepEquals(transpose(input),target))
			writer.println(1);
		else if(Arrays.deepEquals(transpose(transpose(input)),target))
			writer.println(2);
		else if(Arrays.deepEquals(transpose(transpose(transpose(input))),target))
			writer.println(3);
		else if(Arrays.deepEquals(reflect(input),target))
			writer.println(4);
		else if(Arrays.deepEquals(transpose(reflect(input)),target)||Arrays.deepEquals(transpose(transpose(reflect(input))),target) || Arrays.deepEquals(transpose(transpose(transpose(reflect(input)))),target))
			writer.println(5);
		else if(Arrays.deepEquals(input,target))
			writer.println(6);
		else
			writer.println(7);
		reader.close();
		writer.close();
		
	}
}
