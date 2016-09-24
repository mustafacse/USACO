/*
ID: mohsinm4
LANG: JAVA
TASK: milk
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class packet
{
	int price;
	int unit;
	
	public packet(int p,int u)
	{
		price = p;
		unit = u;
	}
}

class sortFarmers implements Comparator<packet>
{

	@Override
	public int compare(packet p1, packet p2) {
		if(p1.price < p2.price)
			return -1;
		else if(p1.price > p2.price)
			return 1;
		return 0;
	}
	
}

public class milk {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("milk.in"));
		PrintWriter writer = new PrintWriter("milk.out");
		String str = reader.readLine();
		String NM[] = str.split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		ArrayList<packet> packets = new ArrayList<packet>();
		
		for(int i = 0;i < M;++i)
		{
			str = reader.readLine();
			String info[] = str.split(" ");
			packets.add(new packet(Integer.parseInt(info[0]),Integer.parseInt(info[1])));
		}
		Collections.sort(packets,new sortFarmers());
		
		int counter = 0;
		long amount = 0;
		for(int i = 0;i < M && counter < N;++i)
		{
			packet curr = packets.get(i);
			int required = N-counter;
			if(required >= curr.unit){
				amount += (curr.price*curr.unit);
				counter += curr.unit;
			}
			else{
				amount += (curr.price*required);
				counter += required;
			}
			
		}
		writer.println(amount);
		
		reader.close();
		writer.close();
	}

}
