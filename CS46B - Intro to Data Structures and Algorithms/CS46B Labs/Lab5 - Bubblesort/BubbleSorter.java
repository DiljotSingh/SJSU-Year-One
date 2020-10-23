package bubble;

import java.util.TreeSet;

public class BubbleSorter {
	private int[] a;
	private long nVisits;
	private long nSwaps;

	public BubbleSorter(int[] a) {
		this.a = a;
	}

	public void sort() {
		for (int i = 0; i < a.length; i++) {
			if (!isSorted()) {
				for (int j = a.length - 1; j > 0; j--) {
					nVisits += 2;
					if (a[j] < a[j - 1]) {
						int temp = a[j];
						a[j] = a[j - 1];
						a[j - 1] = temp;
						nSwaps++;
					}
				}
			}
		}
	}

	public String toString() {
		String s = nVisits + " visits, " + nSwaps + " swaps\n{";
		for (int n : a)
			s += " " + n;
		s += " }";
		return s;
	}

	public boolean isSorted() {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				return false;
			}
		}
		return true;

	}

	public long getNVisits() {
		return nVisits;
	}

	public long getNSwaps() {
		return nSwaps;
	}

	public int[] getArray() {
		return a;
	}

	public static void main(String[] args) {
		int[] a = BubbleSortTestCaseMaker.getAlreadySorted();

		BubbleSorter sorter = new BubbleSorter(a);
		sorter.sort();
		System.out.println(sorter);
		System.out.println(sorter.isSorted() ? "SORTED" : "NOT SORTED");
	}
}
