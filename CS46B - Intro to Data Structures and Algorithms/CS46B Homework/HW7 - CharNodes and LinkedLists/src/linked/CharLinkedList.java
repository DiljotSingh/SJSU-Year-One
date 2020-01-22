package linked;

import java.util.*;

public class CharLinkedList {
	private CharNode head; // Empty if head and
	private CharNode tail; // tail are null

	public CharLinkedList() {
	}

	public CharLinkedList(String s) {
		for (int i = s.length() - 1; i >= 0; i--)
			insertAtHead(s.charAt(i));
	}

	public void insertAtHead(char ch) {
		assert hasIntegrity(); // Precondition

		CharNode node = new CharNode(ch);
		node.setNext(head);
		head = node;
		if (tail == null)
			tail = node; // Corner case: inserting into empty node

		assert hasIntegrity(); // Postcondition
	}

	public String toString() {
		String s = "";
		CharNode node = head;
		while (node != null) {
			s += node.getData();
			node = node.getNext();
		}
		return s;
	}

	//
	// Returns true if this list has emptiness integrity, has tail integrity, has no
	// loops,
	// and tail is reachable from head.
	//
	// Caution: this checks for most but not all common integrity problems.
	//
	boolean hasIntegrity() {
		// Check emptiness. If either head or tail is null, the other must
		// also be null. Different logic from what you saw in lecture. Returns
		// immediately if this list is empty.
		if (head == null || tail == null)
			return head == null && tail == null;

		// Check tail integrity (tail.next must be null).
		if (tail.getNext() != null)
			return false;

		// Check for loops.
		Set<CharNode> visitedNodes = new HashSet<>();
		CharNode node = head;
		while (node != null) {
			if (visitedNodes.contains(node))
				return false; // Current node has been visited before, we must have a loop
			visitedNodes.add(node); // First visit to this node
			node = node.getNext();
		}

		// Make sure tail is reachable from head.
		node = head;
		while (node != null && node != tail)
			node = node.getNext();
		return node == tail;
	}

	/**
	 * Standard loop through linked list to find a match for the parameter
	 * 
	 * @param ch the data you are looking for
	 * @return the node which contains that data if it exists
	 */
	public CharNode find(char ch) {
		CharNode checker = head; // sets the starting point to the head
		while (checker != null) { // keeps looping until it reaches the point after the tail
			if (checker.getData() == ch) { // compares data to see if we have found the match
				return checker;
			}
			checker = checker.getNext(); // advances in the linked list by going to the next node
		}
		return null; // does not exist

	}

	/*
	 * Finds (using the find() method above) the first node in the list whose data
	 * is equal to ch. If there is no such node, throws an IllegalArgumentException
	 * with a useful message. If the node is found, creates a new node containing
	 * the same data, and inserts that node into the list either immediately before
	 * or immediately after the found node (your choice). Pay attention to corner
	 * cases: the node you find might be anywhere in the list – head, middle, or
	 * tail
	 */
	public void duplicate(char ch) {

		CharNode found = this.find(ch); // uses find to see if the data exists
		if (found == null) { // it doesn't exist, throws an exception
			throw new IllegalArgumentException("This character does not exist in the data set.");
		} else {
			CharNode newNode = new CharNode(ch); // Constructs a new Node with the target data to insert in the linked
													// list
			// if the target is the tail
			if (found.getNext() == null) {
				found.setNext(newNode); // sets the last node's next pointer to the new node to insert
				tail = newNode; // shifts tail pointer to the new node that is being added
			} else {
				// otherwise does not matter, adds the duplicate after the target
				newNode.setNext(found.getNext());
				found.setNext(newNode);
			}

		}
	}

	public static void main(String[] args) {
		CharLinkedList x = new CharLinkedList("Caterpillarz");
		System.out.println(x.toString());
		// System.out.println(x.find('z'));
		x.duplicate('a');
		System.out.println(x.toString());
		x.duplicate('r');
		System.out.println(x.toString());
		x.duplicate('z');
		System.out.println(x.toString());

	}
}
