package bubble;

import java.util.*;

public class Statistician {
	private final static int N_REPETITIONS = 5000;

	private static void getStats(int arrayLength) {
		ArrayList<Long> visitCounts = new ArrayList<>();
		ArrayList<Long> swapCounts = new ArrayList<>();

		for (int i = 0; i < N_REPETITIONS; i++) {
			int[] array = BubbleSortTestCaseMaker.buildRandom(arrayLength, arrayLength * 100);
			BubbleSorter sorter = new BubbleSorter(array);
			sorter.sort();
			// Assert that the sorter sorted correctly.
			assert (sorter.isSorted()) : "Not Sorted";
			// Append # visits and # swaps to the array lists.
			visitCounts.add(sorter.getNVisits());
			swapCounts.add(sorter.getNSwaps());
		}

		// Compute and print min/average/max number of visits.
		long minVisit = visitCounts.get(0);
		long averageVisit = 0;
		long maxVisit = visitCounts.get(0);
		for (Long x : visitCounts) {
			if (x < minVisit) {
				minVisit = x;
			}
			if (x > maxVisit) {
				maxVisit = x;
			}
			averageVisit = averageVisit + x;
		}
		averageVisit = averageVisit / visitCounts.size();

		// Compute and print min/average/max number of swaps.
		long minSwap = swapCounts.get(0);
		long averageSwap = 0;
		long maxSwap = swapCounts.get(0);
		for (Long y : swapCounts) {
			if (y < minSwap) {
				minSwap = y;
			}
			if (y > maxSwap) {
				maxSwap = y;
			}
			averageSwap = averageSwap + y;
		}
		averageSwap = averageSwap / swapCounts.size();
		
		
		System.out.println("Minimum visit: " + minVisit);
		System.out.println("Maximum visit: " + maxVisit);
		System.out.println("Average visit: " + averageVisit);
		System.out.println("Minimum swap: " + minSwap);
		System.out.println("Maximum swap: " + maxSwap);
		System.out.println("Average swap: " + averageSwap);
		
		

	}

	public static void main(String[] args) {
		System.out.println("500:");
		getStats(500);

		System.out.println("1500:");
		getStats(1500);
		
		
	}
}
