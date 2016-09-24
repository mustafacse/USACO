import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadWriteFile {

	public static void main(String args[]) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader("D:\\Mohsin\\USACO\\InputOutputFiles\\dict.in"));
		PrintWriter writer = new PrintWriter("D:\\Mohsin\\USACO\\InputOutputFiles\\dict.out");
		
		while(true)
		{
			String str = reader.readLine();
			if(str == null)
				break;
			writer.println("\""+str+"\",");
		}
		writer.close();
		reader.close();
	}
}
