package dna;

public class RecordFormatException extends Exception
{
	/**
	 * Constructs a RecordFormatException which takes a String message
	 * @param message the String to display if the superclass calls the .getMessage() method
	 */
	public RecordFormatException(String message)
	{
		super(message);
	}

}
