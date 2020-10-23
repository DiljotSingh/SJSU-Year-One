package recursionstarterpk;

import java.io.*;

public class Lister {
	private File file;
	private boolean showHidden;

	public Lister(File file, boolean showHidden) {
		this.file = file;
		this.showHidden = showHidden;
	}

	public void list() {
		listRecurse(file, "");
	}

	// Print the indent string, followed by the name of the input file.
	// If the input file represents a directory, the method should print
	// a colon after the name, and then call itself once for each of its
	// contents.
	private void listRecurse(File file, String indent) {

		if (file.isDirectory()) {
			if (!file.isHidden() || (file.isHidden() && showHidden)) {

				System.out.println(indent + file.getName() + ":");
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					listRecurse(files[i], indent + " ");
				}
			}
		}

		else {
			if (!file.isHidden() || (file.isHidden() && showHidden)) {
				System.out.print(indent + file);
			}

		}
	}

	static void sop(Object x) {
		System.out.println(x);
	}

	public static void main(String[] args) {
		File f = new File("C:\\Users\\dsing\\Documents");
		Lister lister = new Lister(f, false);
		lister.list();

	}
}

/*
 * 1d) Discuss ways to implement list() without recursion.
 */
