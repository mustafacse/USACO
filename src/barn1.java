
/*
ID: mohsinm4
LANG: JAVA
TASK: barn1
*/


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*class ABC implements Comparator<Integer>
{

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1.intValue() > o2.intValue())
			return -1;
		else if(o1.intValue() < o2.intValue())
			return 1;
		return 0;
	}
	
}*/
public class barn1 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("barn1.in"));
		PrintWriter writer = new PrintWriter("barn1.out");
		
		String input = reader.readLine();
		String seg[] = input.split(" ");
		int M = Integer.parseInt(seg[0]);
		int S = Integer.parseInt(seg[1]);
		int C = Integer.parseInt(seg[2]);
		
		int arr[] = new int[C];
		Integer diff[] = new Integer[C-1];
		for(int i = 0;i < C;++i)
		{
			arr[i] = Integer.parseInt(reader.readLine());
		}
		
		Arrays.sort(arr);
		
		
		
		for(int i = 1;i < C;++i)
			diff[i-1] = arr[i]-arr[i-1];
		
		
		
		Arrays.sort(diff,Collections.reverseOrder());
		
		/*for(int i = 0;i < C-1;++i)
		{
			System.out.print(diff[i]+" ");
		}*/
		int sum = 0;
		for(int i = 0;i < M-1 && i < C-1;++i)
		{
			sum += diff[i]-1;
		}
		writer.println(arr[C-1]-arr[0]+1-sum);
		writer.close();
		reader.close();
			
		
		
	}

}
