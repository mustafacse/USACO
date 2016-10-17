import java.util.HashMap;
import java.util.Map;

public class check {

	int i;
	String str;
	public check(int t,String s)
	{
		i = t;
		str = s;
	}
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + ((str == null) ? 0 : str.hashCode());
		return result;
	}*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		check other = (check) obj;
		if (i != other.i)
			return false;
		if (str == null) {
			if (other.str != null)
				return false;
		} else if (!str.equals(other.str))
			return false;
		return true;
	}
	
	public static void main(String args[])
	{
		Map<Integer,check> map = new HashMap<Integer,check>();
		map.put(1,new check(1,"abc"));
		map.put(2, new check(1,"abc"));
		
		System.out.println(map.entrySet());
	}
}
