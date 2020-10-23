package trees;

import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class FamilyTree {
	private TreeNode root;

	//
	// Displays a file browser so that user can select the family tree file.
	//
	public FamilyTree() throws IOException, TreeException {
		// User chooses input file. This block doesn't need any work.
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Family tree text files", "txt");
		File dirf = new File("data");
		if (!dirf.exists())
			dirf = new File(".");
		JFileChooser chooser = new JFileChooser(dirf);
		chooser.setFileFilter(filter);
		if (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION)
			System.exit(1);
		File treeFile = chooser.getSelectedFile();

		// Parse the input file. Create a FileReader that reads treeFile. Create a
		// BufferedReader
		// that reads from the FileReader.
		FileReader fr = new FileReader(treeFile);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null)
			addLine(line);
		br.close();
		fr.close();
	}

	//
	// Line format is "parent:child1,child2 ..."
	// Throws TreeException if line is illegal.
	//
	private void addLine(String line) throws TreeException {
		// Extract parent and array of children.

		int colonIndex = line.indexOf(":"); // ?? should be the index of the colon in line.
		if (colonIndex < 0) {
			// throw a TreeException with a useful message
			throw new TreeException("No Root Found");
		}
		// ?? The substring of line that starts at char #0 and ends just before
		// colonIndex. Check the API for
		// class java.util.String, method substring(), if you need guidance.
		String parent = line.substring(0, colonIndex);
		// ?? The substring of line that starts just after colonIndex and goes through
		// the end of
		// the line. You'll use a different version of substring().

		String childrenString = line.substring(colonIndex + 1);

		// ?? Call childrenString.split(). Check the API for details. The result will be
		// an array
		// of strings, with the separating commas thrown away.
		String[] childrenArray = childrenString.split(",");

		// Find parent node. If root is null then the tree is empty and the
		// parent node must be constructed. Otherwise the parent node should be
		// somewhere in the tree.
		TreeNode parentNode;
		if (root == null)
			parentNode = root = new TreeNode(parent);
		else {
			parentNode = root.getNodeWithName(parent);
			if (parentNode == null) {
				throw new TreeException("Parent Node does not exist");
			}
			// There's a method in Node that searches for a named node.
			// ??? If the parent node wasn't found, there must have been something wrong in
			// the
			// data file. Throw an exception.
		}

		// Add child nodes to parentNode.
		// ?? For each name in childrenArray, create a new node and add that node to
		// parentNode.
		for (String x : childrenArray) {
			TreeNode newNode = new TreeNode(x);
			parentNode.addChild(newNode);
		}
	}

	// Returns the "deepest" node that is an ancestor of the node named name1, and
	// also is an
	// ancestor of the node named name2.
	//
	// "Depth" of a node is the "distance" between that node and the root. The depth
	// of the root is 0. The
	// depth of the root's immediate children is 1, and so on.
	//
	TreeNode getMostRecentCommonAncestor(String name1, String name2) throws TreeException {
		// Get nodes for input names.
		TreeNode node1 = root.getNodeWithName(name1); // node whose name is name1
		if (node1 == null) {
			// Throw a TreeException with a useful message
			throw new TreeException("The first node does not exist");
		}
		TreeNode node2 = root.getNodeWithName(name2); // node whose name is name2
		if (node2 == null) {
			// Throw TreeException with a useful message
			throw new TreeException("The second node does not exist");

		}

		// Get ancestors of node1 and node2.
		ArrayList<TreeNode> ancestorsOf1 = (root.getNodeWithName(name1)).collectAncestorsToList();
		ArrayList<TreeNode> ancestorsOf2 = (root.getNodeWithName(name2)).collectAncestorsToList();

		// Check members of ancestorsOf1 in order until you find a node that is also
		// an ancestor of 2.
		for (TreeNode n1 : ancestorsOf1)
			if (ancestorsOf2.contains(n1)) {
				return n1;
			}

		// No common ancestor.
		return null;
	}

	public String toString() {
		return "Family Tree:\n\n" + root;
	}

	public static void main(String[] args) {
		try {
			FamilyTree tree = new FamilyTree();
			System.out.println("Tree:\n" + tree + "\n**************\n");
			TreeNode ancestor = tree.getMostRecentCommonAncestor("Bilbo", "Frodo");
			System.out.println("Most recent common ancestor of Bilbo and Frodo is " + ancestor);
		} catch (IOException x) {
			System.out.println("IO trouble: " + x.getMessage());
		} catch (TreeException x) {
			System.out.println("Input file trouble: " + x.getMessage());
		}
	}
}
