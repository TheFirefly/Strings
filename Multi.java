public class Multi {
	
	public static void main(String[] args) {
		int[][] a = { {1, 2, 3, 4, 5}, 
					  {6, 7, 8, 9, 10}, 
					  {11, 12, 13, 14, 15} };

		int[][] b = { {4, 5, 5},
					  {6, 7, 8},
					  {9, 10, 11} }; //Should be 3

		int[] c = {1, 2, 3, 4, 5, 6};

		// System.out.println("Sum of row 0: " + sumOfRow(a, 0));
		// System.out.println("Sum of column 0: " + sumOfColumn(a, 0));
		// System.out.println("Sum of array: " + sum(a));
		// System.out.println("Reversed row 0: ");
		// print(reverseRow(a, 0));
		// System.out.println("Reversed column 0: ");
		// print(reverseColumn(a, 0));
		// System.out.println("Snake draft of a: ");
		// print(snakeDraft(10, 3));
		// System.out.println("Rectangularization of c: ");
		// print(rectangularize(c, 3, 2));
		System.out.println("Determinant of b: " + determinant(b));

	}

	private static void print(int[][] a) {
		for (int r = 0 ; r < a.length ; r++) {
			for (int c = 0 ; c < a[r].length ; c++) {
				System.out.print(a[r][c] + " ");
			}
			System.out.println();
		}
	}

	private static int sumOfRow(int[][] a, int row) {
		int sum = 0;

		for (int i = 0 ; i < a[row].length ; i++) {
			sum += a[row][i];
		}

		return sum;
	}

	private static int sumOfColumn(int[][] a, int column) {
		int sum = 0;

		for (int r = 0 ; r < a.length ; r++) {
			sum += a[r][column];
		}

		return sum;
	}

	private static int sum(int[][] a) {
		int sum = 0;

		for (int r = 0 ; r < a.length ; r++) {
			sum += sumOfRow(a, r);
		}

		return sum;
	}

	private static int[][] reverseRow(int[][] a, int row) {
		for (int i = 0, j = a[row].length - 1; i < a[row].length / 2 ; i++, j--) {
			int temp = a[row][j];
			a[row][j] = a[row][i];
			a[row][i] = temp;
		}

		return a;
	}

	private static int[][] reverseColumn(int[][] a, int column) {
		for (int r = 0, j = a.length - 1; r < a.length / 2; r++, j--) {
			int temp = a[j][column];
			a[j][column] = a[r][column];
			a[r][column] = temp;
		}

		return a;
	}

	private static int[][] getSubArray(int[][] a, int rowIndex, int columnIndex) {
		int[][] sub = new int[a.length - 1][a.length - 1];
		int row = 0;
		int col = 0;
		for (int r = rowIndex + 1 ; r < a.length ; r++) {
			for (int c = 0 ; c < a[row].length ; c++) {
				if (c != columnIndex) {
					sub[row][col] = a[r][c];
					col++;
				}
			}
			row++;
			col = 0;
		}

		return sub;
	}

	private static boolean isSquareMatrix(int[][] a) {
		for (int i = 0 ; i < a.length ; i++) {
			if (a.length != a[i].length) {
				return false;
			}
		}

		return true;
	}

	private static int determinant(int[][] a) {
		if (!isSquareMatrix(a)) {
			throw new IllegalArgumentException("Two-dimensional array given must be square!");
		}

		int determinant = 0;
		int multiplyFactor = 1;
		int size = a.length;

		if (size == 1) {
			//1 by 1 matrix
			return a[0][0];
		} else if (size == 2) {
			//2 by 2 matrix
			return a[0][0]*a[1][1] - a[0][1]*a[1][0];
		} else {
			//n by n matrix
			for (int c = 0 ; c < size ; c++) {
				int number = a[0][c];
				int[][] sub = getSubArray(a, 0, c);

				determinant += multiplyFactor * (number * determinant(sub));
				multiplyFactor *= -1;
			}
		}

		return determinant;
	}

	private static int[][] snakeDraft(int players, int rounds) {
		int[][] a = new int[rounds][players];

		for (int r = 0 ; r < a.length ; r++) {
			for (int c = 0 ; c < a[r].length ; c++) {
				a[r][c] = (r * 10) + (c + 1);
			}
		}

		for (int r = 0 ; r < a.length ; r++) {
			if (r % 2 != 0) {
				//Reverse row
				a = reverseRow(a, r);
			}
		}

		return a;
	}

	private static int[][] rectangularize(int[] a, int rows, int columns) {
		if (rows * columns != a.length) {
			throw new IllegalArgumentException("Row and column dimensions must match array size.");
		}

		int[][] b = new int[rows][columns];

		for (int i = 0, r = 0, c = 0; i < a.length ; i++) {
			b[r][c] = a[i];

			if (c < columns - 1) {
				c++;
			} else {
				c = 0;
				r++;
			}
		}
		return b;
	}
}