import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/*
ID: mohsinm4
LANG: JAVA
TASK: crypt1
*/

public class crypt1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader("crypt1.in"));
		PrintWriter writer = new PrintWriter("crypt1.out");
		
		Object obj = new Object();
		int arr[] = new int[10];
		int n = Integer.parseInt(reader.readLine());
		String input = reader.readLine();
		String numbers[] = input.split(" ");
		for(int i = 0;i < n;++i)
		{
			arr[Integer.parseInt(numbers[i])] = 1;
		}
		
		int k = 0;
		int p = 0;
		int count = 0;
		for(int a = 1;a <= 9;++a)
		{
			for(int b = 1;b <= 9;++b)
			{
				for(int c = 1;c <= 9;++c)
				{
					for(int d = 1;d <= 9;++d)
					{
						for(int e = 1;e <= 9;++e)
						{
							p = 0;
							if(arr[a] == 1 && arr[b] == 1 && arr[c] == 1 && arr[d] == 1 && arr[e] == 1)
								p = 1;
							else 
								p = 0;
							k = a*100+b*10+c;
							k *= d;
							if(k/1000 > 0) p = 0;
							while(k > 0)
							{
								if(arr[k%10] == 0) p = 0;
								k /= 10;
							}
							k = a*100+b*10+c;
							k *= e;
							if(k/1000 > 0) p = 0;
							while(k > 0)
							{
								if(arr[k%10] == 0) p = 0;
								k /= 10;
							}
							k = (a*100+b*10+c)*(d*10+e);
							if(k/10000 > 0) p = 0;
							while(k > 0)
							{
								if(arr[k%10] == 0) p = 0;
								k /= 10;
							}
							if(p == 1)
								++count;
						}
							
					}
				}
			}
		}
		writer.println(count);
		reader.close();
		writer.close();
				
	}

}
