package weather;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.TreeSet;

public class WeatherTester {

	private static boolean testBasicClassesExist()
	{
		// Collect names of missing classes.
		String[] basicNames = { "Cloud", "CirrusCloud", "CumulusCloud", "StratusCloud", "Sky" };
		Set<String> missing = new TreeSet<>();
		for (String name: basicNames)
		{
			String fullName = "weather." + name;
			try
			{
				Class.forName(fullName);
			}
			catch (LinkageError x)
			{
				System.out.println("Phil says this should never happen.");
			}
			catch (ClassNotFoundException x)
			{
				missing.add(name);
			}
		}	
		// Nothing missing.
		if (missing.isEmpty())
			System.out.println("All the basic class are present");	
		// 1 or more basic (i.e. not Sky2) classes are missing.
		else
		{
			System.out.println("The following class(es) are missing:");
			for (String m: missing)
				System.out.println( m + " ");
		}
		return missing.isEmpty();
	}
	
	
	public static boolean testSky2Exists()
	{
		try
		{
			Class.forName("weather.Sky2");
		}
		catch (LinkageError x)
		{
			System.out.println("This should never happen.");
			return false;
		}
		catch (ClassNotFoundException x)
		{
			System.out.println("No class Sky2");
			return false;
		}
		System.out.println("Class Sky2 found");
		return true;
	}
	
	
	public static boolean testSkyStructure()
	{
		try
		{
			Class<?> clazz = Class.forName("weather.Sky");
			Field cloudsField = clazz.getDeclaredField("clouds");
			if (cloudsField.getType() != java.util.ArrayList.class)
			{
				System.out.println("Unexpected type for clouds in Sky: " + cloudsField.getType() +
						" should be ArrayList");
				return false;
			}
		}
		catch (NoSuchFieldException x)
		{
			System.out.println("No field clouds in class Sky");
			return false;
		}
		catch (ClassNotFoundException x)
		{
			System.out.println("No class Sky2");		// should be caught in testSky2Exists
			return false;
		}
		System.out.println("Sky2 structure is correct");
		return true;
	}
	
	
	public static boolean testSkyBehavior()
	{
		StratusCloud strat = new StratusCloud(100, 1000);
		if (!strat.rain().startsWith("It is raining"))
		{
			System.out.println("Bad StratusCloud::rain");
			return false;
		}
		CumulusCloud cumu = new CumulusCloud(200, 2000);
		if (!cumu.rain().startsWith("It is raining"))
		{
			System.out.println("Bad CumulusCloud::rain");
			return false;
		}
		CirrusCloud cirr = new CirrusCloud(300, 3000);
		if (!cirr.rain().startsWith("I cannot make"))
		{
			System.out.println("Bad CirrusCloud::rain");
			return false;
		}
		Sky sky = new Sky();
		sky.add(strat);
		sky.add(cumu);
		sky.add(cirr);
		float mean = sky.getMeanHeight();
		if (mean < 1799  ||  mean > 1801)
		{
			System.out.println("In Sky, bad mean height for 3 clouds "
					+ "with bottom:top = { 100:1000, 200:2000, 300:3000 }");
			return false;
		}
		else
		{
			System.out.println("Sky gives correct mean");
			return true;
		}
	}
	
	
	public static boolean testSky2Structure()
	{
		try
		{
			Class.forName("weather.Sky2").getDeclaredField("clouds");		// should throw because clouds should not exist.
			System.out.println("Sky2 should not contain field clouds");
			return false;
		}
		catch (NoSuchFieldException|ClassNotFoundException x) { }
		
		try
		{
			Class<?> superclass = Class.forName("weather.Sky2").getSuperclass();
			if (superclass != java.util.ArrayList.class)
			{
				System.out.println("Sky2 does not extend ArrayList");
				return false;
			}
		}
		catch (ClassNotFoundException x) { }
		System.out.println("Sky2 structure is correct ");
		return true;
	}
	
	
	public static boolean testSky2Behavior()
	{
		StratusCloud strat = new StratusCloud(100, 1000);
		if (!strat.rain().startsWith("It is raining"))
		{
			System.out.println("Bad StratusCloud::rain");
			return false;
		}
		CumulusCloud cumu = new CumulusCloud(200, 2000);
		if (!cumu.rain().startsWith("It is raining"))
		{
			System.out.println("Bad CumulusCloud::rain");
			return false;
		}
		CirrusCloud cirr = new CirrusCloud(300, 3000);
		if (!cirr.rain().startsWith("I cannot make"))
		{
			System.out.println("Bad CirrusCloud::rain");
			return false;
		}
		Sky2 sky2 = new Sky2();
		sky2.add(strat);
		sky2.add(cumu);
		sky2.add(cirr);
		float mean = sky2.getMeanHeight();
		if (mean < 1799  ||  mean > 1801)
		{
			System.out.println("In Sky2, bad mean height for 3 clouds "
					+ "with bottom:top = { 100:1000, 200:2000, 300:3000 }");
			return false;
		}
		else
		{
			System.out.println("Sky2 gives correct mean");
			return true;
		}
	}
	
	
	public static boolean testCloudSubclassing()
	{
		String[] subClouds = { "CirrusCloud", "CumulusCloud", "StratusCloud" };
		String message = "";
		for (String subCloud: subClouds)
		{		
			try
			{
				Class<?> superclass = Class.forName("weather." + subCloud).getSuperclass();
				if (superclass != Class.forName("weather.Cloud"))
					message += subCloud + " does not extend Cloud. ";
			}
			catch (ClassNotFoundException x) { }
		}
		message = message.trim();
		if(!message.isEmpty()) 
			System.out.println(message);
		else
			System.out.println("Subclassing for all the cloud classes is correct");
		
		return message.isEmpty();
	}
	
	
	public static boolean testCloudCtors()
	{
		String[] allClouds = { "Cloud", "CirrusCloud", "CumulusCloud", "StratusCloud" };
		String message = "";
		Class<?>[] expectedArgTypes = { float.class, float.class };
		for (String cloud: allClouds)
		{
			try
			{
				Class.forName("weather." + cloud).getDeclaredConstructor(expectedArgTypes);
			}
			catch (ClassNotFoundException x) 
			{
				message += cloud + " not found.";
			}
			catch (NoSuchMethodException x)
			{
				message += cloud + " does not have a (float, float) ctor. ";
			}
		}
		message = message.trim();
		if (!message.isEmpty()) 
			System.out.println(message);
		else
			System.out.println("Ctors for all the cloud classes are correct");
		
		return message.isEmpty();
	}
	
	
	public static boolean testSkyAdd()
	{
		try
		{
			Class<?>[] expectedTypes = { Class.forName("weather.Cloud") };
			Class.forName("weather.Sky").getMethod("add", expectedTypes);
		}
		catch (ClassNotFoundException x)
		{
			System.out.println("No weather.Sky class");
			return false;
		}
		catch (NoSuchMethodException x)
		{
			System.out.println("No add(Cloud) method in Sky");
			return false;
		}
		
		return true;
	}
	
	
	public static void main(String[] args)
	{
		boolean pass = true;
		pass &= testBasicClassesExist();
		pass &= testSky2Exists();
		pass &= testSkyStructure();
		pass &= testSkyBehavior();
		pass &= testSky2Structure();
		pass &= testSky2Behavior();
		pass &= testCloudSubclassing();
		pass &= testCloudCtors();
		pass &= testSkyAdd();
		
		if (pass)
			System.out.println("\nEverything ok: 100 points");
		else
			System.out.println("\n0 points");
			
	}
}
