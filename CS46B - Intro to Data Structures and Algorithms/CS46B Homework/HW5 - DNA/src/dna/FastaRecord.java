package dna;

public class FastaRecord implements DNARecord {
	private String defline;
	private String sequence;

	/**
	 * Constructs a FastaRecord that has a defline that starts with ">" and a
	 * sequence
	 * 
	 * @param defline  the first line in the fasta file, must start with ">"
	 * @param sequence a String containing the letters "A, C, G, T" in some order.
	 * @throws RecordFormatException
	 */
	public FastaRecord(String theDefline, String theSequence) throws RecordFormatException {

		if (!((theDefline).startsWith(">"))) { // throws an exception if the defline argument does not match FastaRecord
												// syntax of starting with an ">"
			throw new RecordFormatException(
					"Bad 1st char in defline in	" + theDefline + ". Saw " + theDefline.charAt(0) + ",expected >");
		}
		this.defline = theDefline;
		this.sequence = theSequence;

	}

	/**
	 * Constructs a FastaRecord using the information from a FastqRecord passed as an argument
	 * 
	 * @param FastqRecord fastQrec, the FastqRecord to obtain the defline and sequence from in order to construct a FastaRecord
	 */
	public FastaRecord(FastqRecord fastqRec) {
		this.defline = ">" + fastqRec.getDefline().substring(1); // replaces the "@" in fastqRec with a ">" to
		// conform to the syntax
		this.sequence = fastqRec.getSequence();
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
	 * @return sequence
	 */
	public String getSequence() {
		return sequence;
	}

	/**
	 * Checks if this FastaRecord is equal to another one by comparing their defline
	 * and sequence
	 * 
	 * @param Object o, the object to take in and cast as a FastqRecord
	 * 
	 * @return boolean true or false depending on whether the test passed (return
	 *         true) or not (return false)
	 */
	public boolean equals(Object o) {
		FastaRecord that = (FastaRecord) o;
		return this.defline.equals(that.defline) && this.sequence.equals(that.sequence);
	}

	/**
	 * Returns the hashCode by adding the hashCodes of the instance variables
	 * defline and sequence
	 * 
	 * @return int the hashCode
	 */
	public int hashCode() {
		return defline.hashCode() + sequence.hashCode();
	}
}
