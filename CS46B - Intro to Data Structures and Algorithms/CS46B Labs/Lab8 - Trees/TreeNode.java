
package trees;

import java.util.*;

class TreeNode<T> {
	private T data;
	private TreeNode<T> parent;
	private ArrayList<TreeNode<T>> children;

	public TreeNode(T name) {
		this.data = name;
		children = new ArrayList<>();
	}

	T getData() {
		return data;
	}

	void addChild(TreeNode<T> childNode) {
		// Add childNode to this node's children list. Also
		// set childNode's parent to this node.
		this.children.add(childNode);
		childNode.parent = this;
	}

	// Searches subtree at this node for a node
	// with the given name. Returns the node, or null if not found.
	TreeNode<T> getNodeWithName(String targetName) {
		// Does this node have the target name?
		if (this.getData().equals(targetName))
			return this;

		// No, recurse. Check all children of this node.
		for (TreeNode<T> child : children) {
			// If child.getNodeWithName(targetName) returns a non-null node,
			// then that's the node we're looking for. Return it.
			TreeNode<T> found = child.getNodeWithName(targetName);
			if (found != null) {
				return found;
			}
		}

		// Not found anywhere.
		return null;
	}

	// Returns a list of ancestors of this TreeNode, starting with this node's
	// parent and
	// ending with the root. Order is from recent to ancient.
	ArrayList<TreeNode<T>> collectAncestorsToList() {
		ArrayList<TreeNode<T>> ancestors = new ArrayList<>();

		// ????? Collect ancestors of this TreeNode into the array list. HINT: going up
		// the nodes of a tree is like traversing a linked list. If that isn't clear,
		// draw a tree, mark any leaf node, and then mark its ancestors in order from
		// recent to ancient. Expect a question about this on the final exam.
		TreeNode<T> temp = this.parent;
		while (temp != null) {
			ancestors.add(temp);
			temp = temp.parent;

		}
		return ancestors;
	}

	public String toString() {
		return toStringWithIndent("");
	}

	

	private String toStringWithIndent(String indent) {
		String s = indent + data + "\n";
		indent += "  ";
		for (TreeNode<T> childNode : children)
			s += childNode.toStringWithIndent(indent);
		return s;
	}
}
