package dna;

//

// FastqRecord contains the defline, sequence, and quality string
// from a record in a fastq file.
//

public class FastqRecord implements DNARecord

{
	private String defline;
	private String sequence;
	private String quality;

	/**
	 * Constructs a FastqRecord that has a defline, sequence, and quality
	 * 
	 * @param defline  the first line in the fastq file, must start with "@"
	 * @param sequence a String containing the letters "A, C, G, T" in some order.
	 * @param quality  a String with the same length as sequence, encodes the
	 *                 sequencing machine's confidence for correctness in the
	 *                 corresponding sequence character
	 * @throws RecordFormatException
	 */
	public FastqRecord(String theDefline, String theSequence, String theQuality) throws RecordFormatException {

		
		if (!(theDefline.startsWith("@"))) // checks if defline starts with "@" or not, throws an
															// exception if it does not
		{
			throw new RecordFormatException(
					"Bad 1st char in defline in " + theDefline + ". Saw " + theDefline.charAt(0) + ", expected @");
		}
		else
		{
			this.defline = theDefline;
		}
		this.sequence = theSequence;
		this.quality = theQuality;
	}

	/**
	 * Getter method for defline
	 * 
	 * @return defline
	 */
	public String getDefline() {
		return defline;
	}

	/**
	 * Getter method for sequence
	 * 
	 * @return sequence;
	 */
	public String getSequence() {
		return sequence;
	}

	/**
	 * Checks if this FastqRecord is equal to another one by comparing their
	 * defline, sequence, and quality
	 * 
	 * @param Object o, the object to take in and cast as a FastqRecord
	 * 
	 * @return boolean true or false depending on whether the test passed (return
	 *         true) or not (return false)
	 */
	public boolean equals(Object o) {
		FastqRecord that = (FastqRecord) o;
		return this.defline.equals(that.defline) && this.sequence.equals(that.sequence)
				&& this.quality.equals(that.quality);

	}

	/**
	 * Checks to see if the quality line contains at least one "!" or "#" character, indicating low quality
	 * 
	 * @return boolean true or false depending on whether the test for low quality passed or not
	 */
	public boolean qualityIsLow() {
		if (quality.contains("!") || quality.contains("#")) {
			return true;
		}
		return false;

	}

	/**
	 * Returns the hashCode by adding all the hashCodes of the String instance
	 * variables (defline, sequence, quality)
	 * 
	 * @return int the hashCode
	 */
	public int hashCode() {
		return defline.hashCode() + sequence.hashCode() + quality.hashCode();

	}

}
