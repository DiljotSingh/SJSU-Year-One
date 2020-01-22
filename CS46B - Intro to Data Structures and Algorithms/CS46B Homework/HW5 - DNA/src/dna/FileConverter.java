package dna;

import java.io.*;
import java.util.*;

public class FileConverter {
	private File fastq;
	private File fasta;

	/**
	 * Constructs a FileConverter which takes two arguments of type File to
	 * initialize the fastq and fasta instance variables to
	 * 
	 * @param theFastq
	 * @param theFasta
	 */
	public FileConverter(File theFastq, File theFasta) {
		this.fastq = theFastq;
		this.fasta = theFasta;
	}

	//
	// Writes a fasta file consisting of conversion of all records from the fastq
	// which have sufficient quality and unique defline.
	//
	public void convert() throws IOException {
		// Build chain of readers.
		FileReader fr = new FileReader(fastq);
		BufferedReader br = new BufferedReader(fr);
		FastqReader fqr = new FastqReader(br);

		// Build chain of writers.
		FileWriter fw = new FileWriter(fasta);
		PrintWriter pw = new PrintWriter(fw);
		FastaWriter faw = new FastaWriter(pw);

		// Read, translate, write.
		boolean done = false; // Creates a boolean to help control the while loop
		while (!done) {
			try {
				FastqRecord fqRecord = fqr.readRecord(); // Passes the file into the readRecord() method inside of
															// FastqReader which conducts the necessary tests and passes
															// it into FastqRecord which also conducts some tests to
															// ensure this is a valid FastqRecord

				if (fqRecord == null) { // If the file is null then you have reached the end
					done = true;
				} else if (!fqRecord.qualityIsLow()) { // Checks if the quality of the FastqRecord is low, if it is not
														// then you write it as a FastaRecord
					faw.writeRecord(new FastaRecord(fqRecord));
				}
			} catch (RecordFormatException e) {
				System.out.println(e.getMessage());
			}

		}
		// Closes the readers and writers in reverse order of creation
		pw.close();
		fw.close();
		br.close();
		fr.close();

	}
	//Main method to test the FileConverter
	public static void main(String[] args) throws RecordFormatException {
		System.out.println("Starting");
		try {
			File fastq = new File("data/HW5.fastq");
			if (!fastq.exists()) {
				System.out.println("Can't find input file " + fastq.getAbsolutePath());
				System.exit(1);
			}
			File fasta = new File("data/HW5.fasta");
			FileConverter converter = new FileConverter(fastq, fasta);
			converter.convert();
		} catch (IOException x) {
			System.out.println(x.getMessage());
		}
		System.out.println("Done");
	}
}
