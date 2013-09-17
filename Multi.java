public class Multi {
	
	public static void main(String[] args) {
		int[][] a = { {1, 2, 3, 4, 5}, 
					  {6, 7, 8, 9, 10}, 
					  {11, 12, 13, 14, 15} };

		System.out.println("Sum of row 0: " + sumOfRow(a, 0));
		System.out.println("Sum of column 0: " + sumOfColumn(a, 0));
		System.out.println("Sum of array: " + sum(a));
		// System.out.println("Reversed row 0: ");
		// print(reverseRow(a, 0));
		System.out.println("Reversed column 0: ");
		print(reverseColumn(a, 0));

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
}