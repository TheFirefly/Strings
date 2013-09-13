public class Array {
	
	public static void main(String[] args) {
		int[] a = {1, 3, 7, 6, 5};
		int[] b = {6, 7, 8, 9, 10};

		printArray(sortA(a));

	}

	public static int[] doubleIt (int[] a) {
		for (int i = 0 ; i < a.length ; i++) {
			a[i] *= 2;
		}

		return a;
	}

	public static void printArray(int[] a) {
		for (int i = 0 ; i < a.length ; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void findTwoLargest(int[] a) {
		int largest = a[0];
		int nextLargest = a[0];

		for (int i = 0 ; i < a.length ; i++) {
			if (a[i] > largest) {
				largest = a[i];
			}
		}

		for (int i = 0 ; i < a.length ; i++) {
			if (a[i] > nextLargest && a[i] < largest) {
				nextLargest = a[i];
			}
		}

		System.out.println("Largest: " + largest + " Second Largest: " + nextLargest);
	}

	public static void sumCalc(int[] a) {
		int sumEven = 0;
		int sumOdd = 0;
		int sumAll = 0;
		for (int i = 0 ; i < a.length ; i++) {
			if (i == 0 || i % 2 == 0) {
				sumEven += a[i];
				sumAll += a[i];
			} else {
				sumOdd += a[i];
				sumAll += a[i];
			}
		}

		System.out.println("Sum of Even indecies: " + sumEven);
		System.out.println("Sum of Odd indecies: " + sumOdd);
		System.out.println("Sum of All indecies: " + sumAll);
	}

	public static int getSmallest(int[] a, int startingIndex) {
		int smallest = a[startingIndex];
		int index = startingIndex;
		for (int i = startingIndex ; i < a.length ; i++) {
			if (a[i] < smallest) {
				smallest = a[i];
				index = i;
			}
		}

		return index;
	}

	public static int[] smash(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		for (int i = 0 ; i < a.length ; i++) {
			c[i] = a[i];
		}

		for (int i = 0, j = a.length ; i < b.length ; i++, j++) {
			c[j] = b[i];
		}

		return c;
	}

	public static int[] sortA(int[] a) {
		int start = 0;
		for (int i = start ; i < a.length ; i++) {
			int index = getSmallest(a, start);
			int temp = a[start];
			a[start] = a[index];
			a[index] = temp;
			start++;
		}

		return a;
	}

}