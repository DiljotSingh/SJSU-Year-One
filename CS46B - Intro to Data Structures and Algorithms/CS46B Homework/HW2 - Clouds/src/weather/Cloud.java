package weather;
/*
 * 
 */
public class Cloud 
{
	private float bottom;
	private float top;
	
	//Constructs a Cloud that has a bottom and top
	public Cloud(float bottom, float top)
	{
		this.bottom = bottom;
		this.top = top;
	}
	/**
	 * Gets the height of this Cloud
	 * @return top-bottom, the top of the cloud minus the bottom
	 */
	public float getHeight()
	{
		return top-bottom;
	}
	/**
	 * Simulates the Cloud producing rain
	 * @return "It is raining" the statement which indicates when the Cloud is raining
	 */
	public String rain()
	{
		return "It is raining";
	}
}
