/*
ID: mohsinm4
LANG: JAVA
TASK: gift1
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map.Entry;


public class gift1 {

	static public LinkedHashMap<String,Integer> hm = new LinkedHashMap<String,Integer>();
	
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter writer = new PrintWriter("gift1.out");
		
		int noOfFriends = Integer.parseInt(reader.readLine());
		int lineNo = 0;
		while(lineNo < noOfFriends)
		{
			hm.put(reader.readLine(),0);
			++lineNo;
		}
		
		while(true)
		{
			String giver = reader.readLine();
			if(giver == null)
				break;
			String amountPlusNoOfCandidates = reader.readLine();
			String arr[] = amountPlusNoOfCandidates.split(" ");
			int amount = Integer.parseInt(arr[0]);
			int noOfCandidates = Integer.parseInt(arr[1]);
			if(amount == 0 || noOfCandidates == 0)
			{
				for(int index = 0;index < noOfCandidates;++index){
					String input = reader.readLine();
				}
			}else{
			int giftAmount = amount/noOfCandidates;
			if(amount != (giftAmount*noOfCandidates))
				amount = (giftAmount*noOfCandidates);
			if(hm.get(giver) == null)
			hm.put(giver,-amount);
			else
			{
				int temp = hm.get(giver);
				hm.put(giver,temp-amount);
			}
			for(int index = 0;index < noOfCandidates;++index){
				String input = reader.readLine();
				if(hm.get(input) == null)
					hm.put(input,giftAmount);
				else
				{
					int temp = hm.get(input);
					hm.put(input, temp+giftAmount);
				}
			}
			}
		}
		
		for (Entry<String,Integer> entry : hm.entrySet()) {
			writer.println(entry.getKey() + " " + entry.getValue());
		     System.out.println(entry.getKey() + " " + entry.getValue());
		}
		writer.close();
		reader.close();
	}
}
