
import java.io.*;

//
// Reads lines from a BufferedReader and builds a FastqRecord.
//

public class FastqReader {
	private BufferedReader theBufferedReader;

	/**
	 * Constructs a FastqReader which takes a single argument (a BufferedReader)
	 * 
	 * @param br the BufferedReader to initialize the instance variable to
	 */
	public FastqReader(BufferedReader br) {
		theBufferedReader = br;
	}

	// Returns next record in the file, or null if EOF (end-of-file).
	public FastqRecord readRecord() throws IOException, RecordFormatException {
		// Read the defline from the BufferedReader. Return null if you read null,
		// indicating end of file.
		String defline = theBufferedReader.readLine();
		if (defline == null) {
			return null;
		}

		// Read the next 3 lines from the buffered reader. Construct and return
		// a FastqRecord.
		String sequence = theBufferedReader.readLine(); // the sequence line
		String separator = theBufferedReader.readLine(); // the "+" separator
		String quality = theBufferedReader.readLine(); // the quality line
		return new FastqRecord(defline, sequence, quality); // returns a new FastqRecord from the stored information

	}

}
