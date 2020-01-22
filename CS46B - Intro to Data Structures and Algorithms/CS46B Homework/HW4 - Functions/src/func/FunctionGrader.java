package func;

import java.lang.reflect.*;


public class FunctionGrader 
{
	private final static int		POINTS_PER_FUNCTION		= 15;
	private final static int		POINTS_FOR_COMPLEX		= 100 - POINTS_PER_FUNCTION*5;
	
	private static int				points = 100;
	
	
	private static class GoldenComplex
	{
		double			real;
		double			imaginary;
		
		public GoldenComplex(double real, double imaginary)
		{
			this.real = real;
			this.imaginary = imaginary;
		}
		
		public GoldenComplex(GoldenComplex source)
		{
			this.real = source.real;
			this.imaginary = source.imaginary;
		}
		
		public static GoldenComplex add(GoldenComplex c1, GoldenComplex c2)
		{
			return new GoldenComplex(c1.real+c2.real, c1.imaginary+c2.imaginary);
		}
		
		public static GoldenComplex multiply(GoldenComplex c1, GoldenComplex c2)
		{
			double r = c1.real*c2.real - c1.imaginary*c2.imaginary;
			double i = c1.real*c2.imaginary + c1.imaginary*c2.real;
			return new GoldenComplex(r, i);
		}
			
		public double length()
		{
			return Math.hypot(real, imaginary);
		}
		
		public String toString()
		{
			if (real == 0)
				return imaginary + "i";
			else if (imaginary == 0)
				return real + "";
			
			return real + (imaginary > 0 ? "+" : "-") + imaginary;
		}
	}
	
	
	private static void failComplex(String message)
	{
		sop("Failure in Complex class: " + message);
		sop("Deducting " + POINTS_FOR_COMPLEX + " points");
		points -= POINTS_FOR_COMPLEX;
		return;
	}
	
	
	private static Class complexClass = null;
	private static Constructor twoDoublesCtor = null;
	private static Constructor copyCtor = null;
	private static Method getRealMethod = null;
	private static Method getImaginaryMethod = null;
	private static Method addMethod = null;
	private static Method multiplyMethod = null;
	private static Method normMethod = null;

	
	private static Object makeComplex(double r, double i)
	{
		try
		{
			return twoDoublesCtor.newInstance(r, i);
		}
		catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException x)
		{
			sop("????? " + x.getMessage() + "\n" + twoDoublesCtor);
			return null;
		}
	}
	
	
	private static Object makeComplex(Object src)
	{
		try
		{
			double dr = (double)getRealMethod.invoke(src);
			double di = (double)getImaginaryMethod.invoke(src);
			return makeComplex(dr, di);
		}
		catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException x)
		{
			sop("????? " + x.getMessage() + "\n" + twoDoublesCtor);
			return null;
		}
	}
	
	
	private static boolean closeEnough(double d1, double d2)
	{
		return Math.abs(d1-d2) < 0.001;
	}
	

	private static void checkComplex()
	{
		//
		//	Structure.
		//
		try 
		{
			complexClass = Class.forName("func.Complex");
		}
		catch (ClassNotFoundException x)
		{
			failComplex("No func.Complex class");
			return;
		}
		for (Constructor c: complexClass.getConstructors())
		{
			if (c.getGenericParameterTypes().length == 2   &&
					c.getGenericParameterTypes()[0].toString().equals("double")   &&
					c.getGenericParameterTypes()[0].toString().equals("double"))
				twoDoublesCtor = c;
			if (c.getGenericParameterTypes().length == 1   &&
					c.getGenericParameterTypes()[0].toString().contains("Complex"))
				copyCtor = c;
		}
		if (twoDoublesCtor == null)
		{
			failComplex("No (double, double) ctor in Complex class");
			return;
		}
		if (copyCtor == null)
		{
			failComplex("No copy ctor in Complex class");
			return;
		}
		
		try
		{
			getRealMethod = complexClass.getMethod("getReal", null);
		}
		catch (Exception x) 
		{
			failComplex("No getReal(no-args) method");
		}
		
		try
		{
			getImaginaryMethod = complexClass.getMethod("getImaginary", null);
		}
		catch (Exception x) 
		{
			failComplex("No getImaginary(no-args) method");
		}		
		
		try
		{
			addMethod = complexClass.getMethod("add", complexClass, complexClass);
		}
		catch (Exception x) 
		{
			failComplex("No add(complex, complex) method");
		}	
		
		try
		{
			multiplyMethod = complexClass.getMethod("multiply", complexClass, complexClass);
		}
		catch (Exception x) 
		{
			failComplex("No multiply(complex, complex) method");
		}
		
		try
		{
			normMethod = complexClass.getMethod("norm");
		}
		catch (Exception x) 
		{
			failComplex("No norm() method");
		}
		
		assert getRealMethod != null  &&  getImaginaryMethod != null;
		
		//
		// Check double,double ctor.
		//		
		for (int r=-100; r<=100; r++)
		{
			for (int i=-100; i<=100; i++)
			{
				Object c = makeComplex(r, i);
				if (c == null)
				{
					failComplex("Couldn't construct: new Complex(" + r + "," + i + ")");
					return;
				}
				try
				{
					double dr = (double)getRealMethod.invoke(c);
					if (!closeEnough(r, dr))
					{
						String err = "c = new Complex(" + r + ", " + i + "; c.getReal() + returned " + dr + ", expected " + r;
						failComplex(err);
						return;
					}
					double di = (double)getImaginaryMethod.invoke(c);
					if (!closeEnough(di, i))
					{
						String err = "c = new Complex(" + r + ", " + i + "; c.getImaginary() + returned " + di + ", expected " + i;
						failComplex(err);
						return;
					}
				}
				catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException x)
				{
					sop("Grader trouble...not your problem");
					sop(x.getMessage());
					assert false;
				}
			}
		}


		// Check copy ctor. Assumes simple ctor works.
		for (int r=-100; r<=100; r++)
		{
			for (int i=-100; i<=100; i++)
			{
				Object c1 = makeComplex(r, i);
				Object c2 = makeComplex(c1);
				try
				{
					double retrievedR = (double)getRealMethod.invoke(c2);
					if (!closeEnough(retrievedR, r))
					{
						failComplex("c1 = new Complex(" + r + ", " + i + "); c2 = new Complex(c1); c2.getReal() returned " + retrievedR + ", should be " + r);
						return;
					}
					double retrievedI = (double)getImaginaryMethod.invoke(c2);
					if (!closeEnough(retrievedI, i))
					{
						failComplex("c1 = new Complex(" + r + ", " + i + "); c2 = new Complex(c1); c2.getImaginary() returned " + retrievedI + ", should be " + i);
						assert false;
						return;
					}
				}
				catch (IllegalAccessException | InvocationTargetException x) { }		// never
			}
		}
		
		// Check static addition method.
		for (int r1=-10; r1<=10; r1++)
		{
			for (int i1=-10; i1<=10; i1++)
			{
				for (int r2=-10; r2<=10; r2++)
				{
					for (int i2=-10; i2<=10; i2++)
					{
						Object c1 = makeComplex(r1, i1);
						Object c2 = makeComplex(r2, i2);
						try
						{
							Object sum = addMethod.invoke(null, c1, c2);
							double sumR = (double)getRealMethod.invoke(sum);
							double sumI = (double)getImaginaryMethod.invoke(sum);
							if (!closeEnough(sumR, r1+r2))
							{
								String err = "c1 = new Complex(" + r1 + ", " + i1 + ");\n";
								err += "c2 = new Complex(" + r2 + ", " + i2 + ");\n";
								err += "Complex.add(c1, c2) returned " + sumR + " + " + sumI + "i\n";
								err += "Should be " + (r1+r2) + " + " + (i1+i2) + "i\n";
								failComplex(err);
								return;
							}
						}
						catch (InvocationTargetException | IllegalAccessException x) { }
					}
				}
			}
		}
		
		// Check static multiply method.
		for (int r1=-10; r1<=10; r1++)
		{
			for (int i1=-10; i1<=10; i1++)
			{
				for (int r2=-10; r2<=10; r2++)
				{
					for (int i2=-10; i2<=10; i2++)
					{
						try
						{
							Object c1 = makeComplex(r1, i1);
							Object c2 = makeComplex(r2, i2);
							Object prod = multiplyMethod.invoke(null, c1, c2);
							double prodR = (double)getRealMethod.invoke(prod);
							double prodI = (double)getImaginaryMethod.invoke(prod);
							GoldenComplex golden = GoldenComplex.multiply(new GoldenComplex(r1, i1), new GoldenComplex(r2, i2));
							if (Math.abs(prodR - golden.real) > 1.0e-6  ||  Math.abs(prodI - golden.imaginary) > 1.0e-6)
							{
								String err = "c1 = new Complex(" + r1 + ", " + i1 + ");\n";
								err += "c2 = new Complex(" + r2 + ", " + i2 + ");\n";
								err += "Complex.multiply(c1, c2) returned " + new GoldenComplex(prodR, prodI) + ", should be " + golden;
								failComplex(err);
								return;
							}
						}
						catch (InvocationTargetException | IllegalAccessException x) { }
					}
				}
			}
		}
		
		// Check norm method.
		int[][] pairs = { {3, 4}, {4, 3}, {5, 12}, {12, 5} };
		int[] lens = {5, 5, 13, 13};
		for (int n=0; n<2; n++)
		{
			int real = pairs[n][0];
			int im = pairs[n][1];
			int goldenLen = lens[n];
			for (int rCoeff=-1; rCoeff<=1; rCoeff+=2)
			{
				for (int iCoeff=-1; iCoeff<=1; iCoeff+=2)
				{
					int useReal = rCoeff * real;
					int useIm = iCoeff * im;
					try
					{
						Object c = makeComplex(useReal, useIm);
						double len = (double)normMethod.invoke(c);
						if (Math.abs(len-goldenLen) > 1.0e-6)
						{
							String err = "c = new Complex(" + useReal + ", " + useIm + ");\n";
							err += "c.length() returned " + len + ", should be " + goldenLen + "\n";
							failComplex(err);
							return;
						}
					}
					catch (InvocationTargetException | IllegalAccessException x) { }	// never
				}
			}
		}
	}
	
	
	private static Class<?> interfaceClass = null;
	
	
	private static void checkFunctions()
	{
		try 
		{
			interfaceClass = Class.forName("func.DoubleFunctionOfTwoInts");	
		}
		catch (ClassNotFoundException x)
		{
			sop("No DoubleFunctionOfTwoInts interface, deducting " + 100);
			points -= 100;
			return;
		}
		
		checkSubtract();
		checkMod();
		checkHypot();
		checkComplexNorm();
		checkComplexSquared();
	}
	
	
	private static boolean implementsTheInterface(Class<?> clazz)
	{
		for (Class intf: clazz.getInterfaces())
			if (intf == interfaceClass)
				return true;
		return false;
	}
	
	
	private static void checkSubtract()
	{
		Class<?> clazz = null;
		Constructor ctor = null;
		DoubleFunctionOfTwoInts f = null;
		
		try 
		{
			clazz = Class.forName("func.SubtractionFunction");
			if (!implementsTheInterface(clazz))
			{
				sop("SubtractionFunction class doesn't declare that it implements the interface, deducting " + POINTS_PER_FUNCTION);
				points -= POINTS_PER_FUNCTION;
				return;		
			}
		}
		catch (ClassNotFoundException x)
		{
			sop("No SubtractionFunction class, deducting " + POINTS_PER_FUNCTION);
			points -= POINTS_PER_FUNCTION;
			return;
		}
		
		try
		{
			ctor = clazz.getConstructor(new Class[0]);
		}
		catch (NoSuchMethodException x)
		{
			sop("Can't construct an instance of SubtractionFunction ... make sure it has a no-args ctor.");
			sop("Deducting " + POINTS_PER_FUNCTION);
			points -= POINTS_PER_FUNCTION;
			return;
		}
		
		try
		{
			f = (DoubleFunctionOfTwoInts)ctor.newInstance();
			for (int x=-100; x<=100; x++)
			{
				for (int y=-100; y<=100; y++)
				{
					if (f.fOfXY(x, y) != x - y )
					{
						sop("SubtractionFunction FAILED for x=" + x + ", y=" + y);
						sop("Your code returned " + f.fOfXY(x, y) + ", should be " + (x-y));
						sop("Deducting " + POINTS_PER_FUNCTION + " points");
						points -= POINTS_PER_FUNCTION;
						return;
					}
				}
			}
		}
		catch (Exception x) { }				// 5 obscure exceptions that should never get thrown
		
		sop("SubtractionFunction PASSED");
	}
	
	
	private static void checkMod()
	{
		Class<?> clazz = null;
		Constructor ctor = null;
		DoubleFunctionOfTwoInts f = null;
		
		try 
		{
			clazz = Class.forName("func.ModFunction");
			if (!implementsTheInterface(clazz))
			{
				sop("ModFunction class doesn't declare that it implements the interface, deducting " + POINTS_PER_FUNCTION);
				points -= POINTS_PER_FUNCTION;
				return;		
			}
		}
		catch (ClassNotFoundException x)
		{
			sop("No ModFunction class, deducting " + POINTS_PER_FUNCTION);
			points -= POINTS_PER_FUNCTION;
			return;
		}
		
		try
		{
			ctor = clazz.getConstructor(new Class[0]);
		}
		catch (NoSuchMethodException x)
		{
			sop("Can't construct an instance of SubtractionFunction ... make sure it has a no-args ctor.");
			sop("Deducting " + POINTS_PER_FUNCTION);
			points -= POINTS_PER_FUNCTION;
			return;
		}
		
		try
		{
			f = (DoubleFunctionOfTwoInts)ctor.newInstance();
			for (int x=-100; x<=100; x++)
			{
				for (int y=-100; y<=100; y++)
				{
					if (y == 0)
						continue;
					if (f.fOfXY(x, y) != x % y )
					{
						sop("ModFunction FAILED for x=" + x + ", y=" + y);
						sop("Your code returned " + f.fOfXY(x, y) + ", should be " + (x-y));
						sop("Deducting " + POINTS_PER_FUNCTION + " points");
						points -= POINTS_PER_FUNCTION;
						return;
					}
				}
			}
		}
		catch (Exception x)	{ }		// never
		
 		sop("ModFunction PASSED");
	}
	
	
	private static void checkHypot()
	{
		Class<?> clazz = null;
		Constructor ctor = null;
		DoubleFunctionOfTwoInts f = null;
		
		try 
		{
			clazz = Class.forName("func.HypotFunction");
			if (!implementsTheInterface(clazz))
			{
				sop("HypotFunction class doesn't declare that it implements the interface, deducting " + POINTS_PER_FUNCTION);
				points -= POINTS_PER_FUNCTION;
				return;		
			}
		}
		catch (ClassNotFoundException x)
		{
			sop("No HypotFunction class, deducting " + POINTS_PER_FUNCTION);
			points -= POINTS_PER_FUNCTION;
			return;
		}
		
		try
		{
			ctor = clazz.getConstructor(new Class[0]);
		}
		catch (NoSuchMethodException x)
		{
			sop("Can't construct an instance of HypotFunction ... make sure it has a no-args ctor.");
			sop("Deducting " + POINTS_PER_FUNCTION);
			points -= POINTS_PER_FUNCTION;
			return;
		}
		
		try
		{
			f = (DoubleFunctionOfTwoInts)ctor.newInstance();
			for (int x=-100; x<=100; x++)
			{
				for (int y=-100; y<=100; y++)
				{
					double golden = Math.hypot(x, y);
					double vut = f.fOfXY(x, y);
					if (Math.abs(golden-vut) > 1.0e-6)
					{
						sop("HypotFunction FAILED for x=" + x + ", y=" + y);
						sop("Your code returned " + vut + ", should be " + golden);
						sop("Deducting " + POINTS_PER_FUNCTION + " points");
						points -= POINTS_PER_FUNCTION;
						return;
					}
				}
			}
		}
		catch (Exception x) { }		// never
		
		sop("HypotFunction PASSED");
	}
	
	
	private static void checkComplexNorm()
	{
		Class<?> clazz = null;
		Constructor ctor = null;
		DoubleFunctionOfTwoInts f = null;
		
		try 
		{
			clazz = Class.forName("func.ComplexNormFunction");
			if (!implementsTheInterface(clazz))
			{
				sop("ComplexNormFunction class doesn't declare that it implements the interface, deducting " + POINTS_PER_FUNCTION);
				points -= POINTS_PER_FUNCTION;
				return;		
			}
		}
		catch (ClassNotFoundException x)
		{
			sop("No ComplexNormFunction class, deducting " + POINTS_PER_FUNCTION);
			points -= POINTS_PER_FUNCTION;
			return;
		}
		
		try
		{
			ctor = clazz.getConstructor(new Class[0]);
		}
		catch (NoSuchMethodException x)
		{
			sop("Can't construct an instance of ComplexNormFunction ... make sure it has a no-args ctor.");
			sop("Deducting " + POINTS_PER_FUNCTION);
			points -= POINTS_PER_FUNCTION;
			return;
		}
		
		try
		{
			f = (DoubleFunctionOfTwoInts)ctor.newInstance();
			for (int x=-100; x<=100; x++)
			{
				for (int y=-100; y<=100; y++)
				{
					double golden = Math.hypot(x, y);
					double vut = f.fOfXY(x, y);
					if (Math.abs(golden-vut) > 1.0e-6)
					{
						sop("ComplexNormFunction FAILED for x=" + x + ", y=" + y);
						sop("Your code returned " + vut + ", should be " + golden);
						sop("Deducting " + POINTS_PER_FUNCTION);
						points -= POINTS_PER_FUNCTION;
						return;
					}
				}
			}
		}
		catch (Exception x)		{ }		// never
		
		sop("ComplexNormFunction PASSED");	
	}
	
	
	private static void checkComplexSquared()
	{
		Class<?> clazz = null;
		Constructor ctor = null;
		DoubleFunctionOfTwoInts f = null;
		
		try 
		{
			clazz = Class.forName("func.ComplexSquaredNormFunction");
			if (!implementsTheInterface(clazz))
			{
				sop("ComplexSquaredNormFunction class doesn't declare that it implements the interface, deducting " + POINTS_PER_FUNCTION);
				points -= POINTS_PER_FUNCTION;
				return;		
			}
		}
		catch (ClassNotFoundException x)
		{
			sop("No ComplexSquaredNormFunction class, deducting " + POINTS_PER_FUNCTION);
			points -= POINTS_PER_FUNCTION;
			return;
		}
		
		try
		{
			ctor = clazz.getConstructor(new Class[0]);
		}
		catch (NoSuchMethodException x)
		{
			sop("Can't construct an instance of ComplexSquaredNormFunction ... make sure it has a no-args ctor.");
			sop("Deducting " + POINTS_PER_FUNCTION);
			points -= POINTS_PER_FUNCTION;
			return;
		}
		
		try
		{
			f = (DoubleFunctionOfTwoInts)ctor.newInstance();
			for (int r=-100; r<=100; r++)
			{
				for (int i=-100; i<=100; i++)
				{
					double c2_real = (r * r) - (i * i);
					double c2_im = 2 * r * i;
					double golden = Math.hypot(c2_real, c2_im);
					double vut = f.fOfXY(r, i);
					if (Math.abs(golden-vut) > 1.0e-6)
					{
						sop("ComplexSquaredLengthFunction FAILED for x=" + r + ", y=" + i);
						sop("Your code returned " + vut + ", should be " + golden);
						sop("Deducting " + POINTS_PER_FUNCTION + " points");
						points -= POINTS_PER_FUNCTION;
						return;
					}
				}
			}
		}
		catch (Exception x)		{ }		// never
		
		sop("ComplexSquaredLengthFunction PASSED");	
	}
	
	
	private static void sop(Object x)		{ System.out.println(x); }
	
	
	public static void main(String[] args)
	{
		sop("ASSIGNMENT 3 GRADER");
		sop("\n----------------\nCHECKING Complex class:");
		checkComplex();
		sop("\n----------------\nCHECKING interface implementations:");
		checkFunctions();
		sop("\n-----------------\nTOTAL POINTS = " + points);
	}
}

