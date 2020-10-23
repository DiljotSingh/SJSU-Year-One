package cast;

public class Primitives {

	public static void dumpMaxValues()
	{
		
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Short.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Double.MAX_VALUE);
		System.out.println(Float.MAX_VALUE);
		
	}
	public static void main(String[] args)
	{
		dumpMaxValues();
		
		//long to int
		long l = Long.MAX_VALUE;
		int i = (int) l;
		System.out.println("long to int: " + l + ", " + i);
		
		//long to int
		long l1 = Long.MAX_VALUE - 5;
		int i1 = (int) l1;
		System.out.println("long to int: " + l1 + ", " + i1);
		
		//int to long
		int i2 = Integer.MAX_VALUE;
		long l2 = (long) i2;
		System.out.println("int to long: " + i2 + ", " + l2);
		
		//byte to double
		byte b = 100;
		double d =  b;
		System.out.println("byte to double: " + b + ", " + d);
		
		//double to byte
		double d1 = 45.67;
		byte b1 = (byte)d1;
		System.out.println("double to byte: " + d1 + ", " + b1);
		
		//double to byte
		double d2 = 456.789;
		byte b2 = (byte)d2;
		System.out.println("double to byte: " + d2 + ", " + b2);
		
		//float to long
		float f1 = 12345.6789f;
		long l3 = (long)f1;
		System.out.println("float to long: " + f1 + ", " + l3);
		
		//float to long
		float f2 = Float.MAX_VALUE;
		long l4 = (long) f2;
		System.out.println("float to long: " + f2 + ", " + l4);
		
		//long to float
		long l5 =  Long.MAX_VALUE;
		float f3 = (float) l5;
		System.out.println("long to float: " + l5 + ", " + f3);
		
		
		
	}
}
