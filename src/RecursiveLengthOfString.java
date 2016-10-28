/**
 * 
 */
/**
 * @author nishantsalvi
 *
 */
public class RecursiveLengthOfString 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{


		int[] array = {1,2,3,11,11,12};
		System.out.println(pair_star("waatever"));
	}
	public static int recursive_length(String s)
	{
		if(s.equals(""))
		{
			return 0;
		}
		else
		{
			return 1+ recursive_length(s.substring(1));
		}
	}
	public static int reucrsive_product(int n, int m)
	{
		if(m == n)
		{
			return n;
		}
		else return m * reucrsive_product( n, m-1);
	}
	public static int recursive_factorial(int n)
	{
		if(n == 1)
		{
			return 1;
		}
		else return n * recursive_factorial(n-1);
	}
	public static int recursive_bunny(int n)
	{
		if(n ==1)
		{
			return 2;
		}
		else if( n % 2 == 0)
		{
			return 3 + recursive_bunny(n-1) ;
		}
		else return 2 + recursive_bunny(n-1);
	}
	public static int recursive_seven(int n)
	{
		if(n ==0)
		{
			return 0;
		}
		else if(n % 10 ==7)
		{
			return 1 + recursive_seven(n/10);
		}
		else return 0 + recursive_seven(n/10);
	}
	public static int countX(String s)
	{
		if(s.equals(""))
		{
			return 0;
		}
		else if(s.substring(0, 1).equals("x"))
		{
			return 1 + countX(s.substring(1, s.length()));
		}
		else return 0 + countX(s.substring(1, s.length()));
	}
	public static String replacePi(String s)
	{
		if(s.equals(""))
		{
			return "";
		}
		else if(s.length() == 1)
		{
			return s; 
		}
		//System.out.println(s.substring(0,2));

		else if(s.substring(0,2).equals("pi"))
		{
			System.out.println("Entered");
			return "3.14" + replacePi(s.substring(2,s.length()));
		}
		else return s.substring(0,1) + replacePi(s.substring(1,s.length()));

	}

	public static int countEleven(int[] numbers, int index)
	{
		return index ==0 && numbers[index]!= 11 ?  0 : index ==0 && numbers[index] ==11 ? 1 :numbers[index]!= 11  ? 0 + countEleven(numbers, index -1)  :  1 + countEleven(numbers, index -1) ; 

	}

	public static String pairStar(String s)
	{
		return s.length() == 2 && s.charAt(0)!= s.charAt(1) ? s : 
			s.length() == 1 ? s :

				s.substring(0,2).charAt(0) == s.substring(0,2).charAt(1) ? s.substring(0,1) + "*" +  s.substring(1,2) + pairStar(s.substring(1, s.length())) :
					s.substring(0,1) + s.substring(1,2) + pairStar(s.substring(2, s.length()));
	}

	public static String pair_star(String s)
	{
		if(s.length() == 2 && s.charAt(0)!= s.charAt(1))
		{
			System.out.println("ENtered");
			return s;
		}
		else if(s.length() == 1)
		{
			System.out.println("ENtered");
			return s;
		}
		else if(s.substring(0,2).charAt(0) == s.substring(0,2).charAt(1))
		{
			System.out.println("ENtered");
			return s.substring(0,1) + "*"  + pair_star(s.substring(1, s.length())) ;
		}

		else 
		{
			System.out.println(s.substring(0,2).charAt(0) + " " + s.substring(0,2).charAt(1) );
			return s.substring(0,1)  + pair_star(s.substring(1, s.length()));
		}
	}
}

