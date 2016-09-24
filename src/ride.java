/*
ID: mohsinm4
LANG: JAVA
TASK: ride
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class ride {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader reader = new BufferedReader(new FileReader("ride.in"));
		PrintWriter writer = new PrintWriter("ride.out");
		
		
		String comet = null;
		String group = null;
		
		comet = reader.readLine();
		group = reader.readLine();
		int len1 = comet.length();
		int len2 = group.length();
		int index1 = 0,index2 = 0;
		int sum1 = 1,sum2 = 1;
		while(index1 < len1 || index2 < len2)
		{
			if(index1 < len1){
			sum1 *= (comet.charAt(index1)-'A'+1);
			sum1 %= 47;
			}
			if(len2 > index2){
			sum2 *= (group.charAt(index2)-'A'+1);
			sum2 %= 47;
			}
			++index1;
			++index2;
		}
		if(sum1 == sum2){
//			System.out.print("GO");
			writer.println("GO");
		}
		else{
//			System.out.print("STAY");
			writer.println("STAY");
		}
		writer.close();
		reader.close();
	}

}
