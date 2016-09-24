/*
ID: mohsinm4
LANG: JAVA
TASK: milk2
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

class Interval
{
	private int start;
	private int end;
	
	Interval(int s,int e)
	{
		start = s;
		end = e;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	
}

public class milk2{

	public static void main(String[] args) throws NumberFormatException, IOException {


		BufferedReader reader = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter writer = new PrintWriter("milk2.out");
		
		Stack<Interval> s = new Stack<Interval>();
		ArrayList<Interval> arr = new ArrayList<Interval>();
		int size = Integer.parseInt(reader.readLine());
		for(int i = 0;i < size;++i)
		{
			String currLine = reader.readLine();
			String arguments[] = currLine.split(" ");
			arr.add(new Interval(Integer.parseInt(arguments[0]),Integer.parseInt(arguments[1])));
		}
		Collections.sort(arr,new XYZ());
		
		/*for(Interval i : arr)
		{
			System.out.println(i.getStart()+" "+i.getEnd());
			
		}*/
		s.push(arr.get(0));
		for(int ind = 1;ind < size;++ind)
		{
			Interval curr = arr.get(ind);
			Interval top = s.peek();
			if(top.getEnd() >= curr.getStart())
			{
				if(top.getEnd() < curr.getEnd()){
					top.setEnd(curr.getEnd());
					s.pop();
					s.push(top);
				}
			}
			else
				s.push(curr);
		}
		
		int maxWork = 0;
		int maxIdeal = 0;
		Interval prev = null;
		Interval temp = null;
		while(!s.empty())
		{
			temp = s.peek();
			//System.out.println(temp.getStart()+" "+temp.getEnd());
			s.pop();
			int diff  = temp.getEnd() - temp.getStart();
			if(maxWork < (diff))
				maxWork = diff;
			if(prev != null)
			{
				if(prev.getStart() < temp.getStart())
				{
					diff = temp.getStart() - prev.getEnd();
				}
				else
				{
					diff = prev.getStart() - temp.getEnd();
				}
				if(diff > maxIdeal)
					maxIdeal = diff;
			}
			prev = temp;
		}
		writer.println(maxWork+" "+maxIdeal);
		reader.close();
		writer.close();
	}

}
class XYZ implements Comparator<Interval>
{

	@Override
	public int compare(Interval arg0, Interval arg1) {
		if(arg0.getStart() <= arg1.getStart())
			return -1;
		return 1;
	}
	
}
