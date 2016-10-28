
public class Solution 
{
	//public static StringContainsException object = new StringContainsException();
	public static void main(String[] args) throws StringContainsException
	{
		Solution object = new Solution();
		long n = parseLong("123.4");
		System.out.println(n);
	}

	public static long parseLong(String s) throws StringContainsException 
	{
		char[] array = s.toCharArray(); boolean is_neg = false;
		
		long n = 0; int i=0;
		if (array[0] == '-') 
		{
			if (array.length == 1) 
			{
				System.out.println("exception ...");
			}
			i = 1;
			is_neg = true;
		}
		for(; i< array.length; i++)
		{

			if(array[i] == ' '  || array[i] < '0' || array[i] > '9' || array[i] == ',')
			{
				throw new StringContainsException();
				
			}
			else
			{
				int difference = array[i] - '0';
				n = (n * 10) + difference;
			}
		}

		if(is_neg) return -n;
		else return n;
	}


}

 class StringContainsException extends Exception
{
	public StringContainsException()
	{
		super("Not a valid string");
	}
}
