package sudoku;

import java.util.*;

public class Grid {
	private int[][] values;

	//
	// DON'T CHANGE THIS.
	//
	// Constructs a Grid instance from a string[] as provided by TestGridSupplier.
	// See TestGridSupplier for examples of input.
	// Dots in input strings represent 0s in values[][].
	//
	public Grid(String[] rows) {
		values = new int[9][9];
		for (int j = 0; j < 9; j++) {
			String row = rows[j];
			char[] charray = row.toCharArray();
			for (int i = 0; i < 9; i++) {
				char ch = charray[i];
				if (ch != '.')
					values[j][i] = ch - '0';
			}
		}
	}

	//
	// DON'T CHANGE THIS.
	//
	public String toString() {
		String s = "";
		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 9; i++) {
				int n = values[j][i];
				if (n == 0)
					s += '.';
				else
					s += (char) ('0' + n);
			}
			s += "\n";
		}
		return s;
	}

	//
	// DON'T CHANGE THIS.
	// Copy ctor. Duplicates its source. You'll call this 9 times in next9Grids.
	//
	Grid(Grid src) {
		values = new int[9][9];
		for (int j = 0; j < 9; j++)
			for (int i = 0; i < 9; i++)
				values[j][i] = src.values[j][i];
	}

	//
	// COMPLETE THIS
	//
	//
	// Finds an empty member of values[][]. Returns an array list of 9 grids that
	// look like the current grid,
	// except the empty member contains 1, 2, 3 .... 9. Returns null if the current
	// grid is full. Dont change
	// this grid. Build 9 new grids.
	//
	//
	// Example: if this grid = 
	// 1........
	// .........
	// .........
	// .........
	// .........
	// .........
	// .........
	// .........
	// .........
	//
	// Then the returned array list would contain:
	//
	// 11....... 12....... 13....... 14....... and so on 19.......
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	//
	public ArrayList<Grid> next9Grids() {
		int xOfNextEmptyCell = 0;
		int yOfNextEmptyCell = 0;
		boolean done = false;
		// Find x,y of an empty cell.
		for (int row = 0; row < 9 && !done; row++) { // outer loop for rows
			for (int column = 0; column < 9 && !done; column++) { // inner loop for columns
				if (values[row][column] == 0) { // finds empty cells
					xOfNextEmptyCell = column; // x (left to right) is the column value
					yOfNextEmptyCell = row; // y (up and down) is the row value
					done = true;
				}
			}
		}

		// Construct array list to contain 9 new grids.
		ArrayList<Grid> grids = new ArrayList<Grid>();
		// Create 9 new grids as described in the comments above. Add them to grids.
		for (int i = 1; i <= 9; i++) {
			Grid newGrid = new Grid(this); // Constructs a Grid with the exact same values as "this" grid, and replaces
											// the first empty value it finds with 1 through 9 in 9 different grids
			newGrid.values[yOfNextEmptyCell][xOfNextEmptyCell] = i;
			grids.add(newGrid);
		}
		return grids;
	}

	// // Returns true if this grid is legal. A grid is legal if no row, column, or
	// 3x3 block contains a repeated 1, 2, 3, 4, 5, 6, 7, 8, or 9.
	// @return boolean true if this sudoku puzzle is legal (has no repeated values
	// in a row, column, or 3x3 block)
	//
	public boolean isLegal() {
		// Checks Rows, Columns, and the 3x3 "blocks" for legality
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (checkRowsAndColumns(row, col, values[row][col]) == false) { // Uses helper method
																				// "checkRowsAndColumns()"
					return false;
				}

				if (checkSubgrid(row, col, values[row][col]) == false) { // Uses helper method "checkSubgrid()"
					return false;
				}

			}
		}
		// Returns true if everything in the sudoku is legal
		return true;
	}

	/**
	 * Checks to see if there is a repeated value in this specific row and column
	 * 
	 * @param row   The row currently being checked
	 * @param col   The column currently being checked
	 * @param value The value at that row and column parameter (values[row][column])
	 * @return boolean true if no non-zero values are repeated, false if there is
	 *         repetition
	 */
	public boolean checkRowsAndColumns(int row, int col, int value) {
		for (int i = 0; i < 9; i++) {
			int currentValueToCompare = values[i][col]; // Initializes the value, checks a column

			if ((currentValueToCompare == value) && (i != row) && (currentValueToCompare != 0)) { // If the value in the
																									// parameter and
																									// current value
																									// being compared
																									// match and they're
																									// not in the same
																									// location (i !=
																									// row) and this is
																									// a non-zero value,
																									// then this returns
																									// false,
																									// indicating that
																									// there is
																									// repetition in the
																									// column
				return false;
			}
		}
		for (int j = 0; j < 9; j++) {
			int currentValueToCompare = values[row][j]; // Same as above, but checks for reptition in a row instead of a
														// column; compares the value from the isLegal() method to all
														// other values in that row to see if there is any non-zero
														// reptition
			if ((currentValueToCompare == value) && (j != col) && (currentValueToCompare != 0)) {
				return false;
			}
		}
		return true; // Returns true if there was no reptition at all in the current row and column
						// being checked, isLegal() continues
	}

	public boolean checkSubgrid(int row, int col, int value) {
		int topLeftCornerRow = row - row % 3; // top left corner of the current 3x3 block in terms of the row
		int topLeftCornerColumn = col - col % 3; // top left corner of the current 3x3 block in terms of the column

		// Follows the same logic as the above loops through the rows and columns, the
		// only
		// difference being that it resets after the row/column is about to go outside
		// of the current 3x3 block.
		for (int r = topLeftCornerRow; r < topLeftCornerRow + 3; r++) { // Starts at the top left corner of the current
																		// 3x3 block
			for (int c = topLeftCornerColumn; c < topLeftCornerColumn + 3; c++) { // Starts at the top left corner of
																					// the current 3x3 block
				int currentValueToCompare = values[r][c];
				// Standard check to ensure that the current value is non-zero and is not at the
				// exact same location as the value being checked for duplicity
				if ((value == currentValueToCompare) && (r != row) && (c != col) && (currentValueToCompare != 0)) {
					return false; // Returns false if there WAS a duplicity in values inside the 3x3 block
				}
			}
		}
		return true; // Reaches this only if all 3x3 blocks contain 9 unique digits from 1-9
	}

	//
	// Returns true if every cell member of values[][] is a digit from 1-9.
	//
	public boolean isFull() {
		String allowedNumbers = "123456789"; // All the allowed numbers that constitute a Grid that is full
		for (int[] row : values) // loops through each row in the 2D array "values"
		{
			for (int value : row) // loops through each specific value in the row
			{
				if (!(allowedNumbers.contains("" + value))) // If the current value is not a number from 1-9 then this
															// returns false
				{
					return false;
				}
			}
		}
		return true; // return true if all the values looped through were from 1-9
	}

	//
	// COMPLETE THIS
	//
	// Returns true if x is a Grid and, for every (i,j),
	// x.values[i][j] == this.values[i][j].
	//
	public boolean equals(Object x) {
		Grid otherGrid = (Grid) x;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (this.values[i][j] != otherGrid.values[i][j]) { // Ensures all values are the same for both grids
					return false; // returns false if atleast one value doesn't match
				}
			}
		}
		return true; // returns true if the two grids are identical in terms of values
	}

	//Testing to make sure methods work properly
	public static void main(String[] args) {
		Grid testGrid = TestGridSupplier.getPuzzle1();
		System.out.println(testGrid.isFull()); // Should be false
		System.out.println(testGrid.isLegal()); // Should be true
		for (Grid x : testGrid.next9Grids()) // 9 grids with first value from 1, 2, 3, ... 9
		{
			System.out.println(x);
			
		}

	}
}