
public class CirrusCloud extends Cloud
{
	//Constructs a CirrusCloud that has a bottom and top
	public CirrusCloud(float bottom, float top)
	{
		super(bottom,top);
	}
	
	/*
	 * Overrides the rain method in Cloud because CirrusClouds cannot make rain
	 */
	public String rain()
	{
		return "I cannot make rain";
	
	}
}
