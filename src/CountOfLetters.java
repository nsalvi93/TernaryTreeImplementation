import java.util.*;

public class CountOfLetters 
{
	public static void main(String[] args)
	{
		charCount("janak");
	}

	public void method()
	{
		Comparator<Integer> compare = new Comparator<Integer>()
		{

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return 0;
			}

		};
		PriorityQueue<Integer> pQueue = new PriorityQueue<>(compare);
	}

	public static void charCount(String s)
	{
		Map<Character, Integer> charCount = new TreeMap<>();
		StringBuffer sb = new StringBuffer();
		char[] chars = s.toCharArray();
		for(char c : chars)
		{
			if(charCount.keySet().contains(c))
			{
				int count = charCount.get(c);
				charCount.put(c, count++);
			}
			else
			{ 
				charCount.put(c, 1);
			}
		}

		for(char c : charCount.keySet())
		{
			sb.append(c + "" + charCount.get(c));
			//sb.append(charCount.get(c));
		}

		System.out.println(sb.toString());
	}

}
