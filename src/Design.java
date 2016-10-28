// default methods: Can be used with this (object can call it) keyword. Basically even interface can have method bodies now
// static methods: The usual global like methods, can be called without the help of any object 
// difference between abstract class and interface with default methods --> abstract class can have a constructor
interface House_methods
{
	public default double getArea(double latitude, double longitude)
	{
		return latitude*longitude;
	}
	
	public static double getArea1(double latitude, double longitude)
	{
		return latitude*longitude;
	}
	public static double getWatever()
	{
		return 0;
	}
}
abstract class ScenicProperties
{
	public ScenicProperties()
	{
	}
	public void dummyMethod()
	{
	}
}
class Dummy extends ScenicProperties
{
}
class Property
{
	double latitude;
	double longitude;
	public Property(double x, double y)
	{
		this.latitude = x;
		this.longitude = y;
	}
}
class Condo extends Property implements House_methods
{
	int rooms;
	public Condo(double x, double y, int rooms) 
	{
		super(x, y);
		this.rooms = rooms;
	}
	public void method()
	{
		this.getArea(this.latitude, this.longitude);
	}
	
	public void method1()
	{
		House_methods.getArea1(this.latitude, this.longitude);
	}
}
public class Design implements House_methods
{
	Property house = new Condo(1,2,3);
	Condo house123 = new Condo(1,2,3);
	Condo house1234 = (Condo) new Property(1,2);
	public static void main(String[] args)
	{
		Design object = new Design();
		House_methods.getWatever();
		object.house1234.method();
	}
}
