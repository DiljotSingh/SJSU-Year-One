
import java.io.*;



/**
 * Makes a PrintWriter to write Fasta Files
 * @author Diljot Singh
 *
 */
public class FastaWriter 
{
	private PrintWriter thePrintWriter;
	/**
	 * Constructs a FastaWriter that takes a PrintWriter as an argument to initialize the instance variable
	 * @param p the PrintWriter passed as an argument
	 */
	public FastaWriter(PrintWriter p)
	{
		this.thePrintWriter = p;
	}
	
	
	/**
	 * Writes the defline and sequence from the FastaRecord on separate lines in the PrintWriter
	 * @param rec the FastaRecord to write from
	 * @throws IOException
	 */
	public void writeRecord(FastaRecord rec) throws IOException
	{
		thePrintWriter.println(rec.getDefline());
		thePrintWriter.println(rec.getSequence());

	}
}
