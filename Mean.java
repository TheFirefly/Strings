import java.util.Random;

public class Mean {

	private static Random r = new Random(5345);
	
	public static void main(String[] args) {
		int[] randomArray = makeRandom(1000, 100);
		System.out.println("Mean of Array: " + mean(randomArray));
		System.out.println("Mean of Array from index 40 to index 45: " + meanOfRange(randomArray, 40, 45));
		System.out.println("Standard Deviation: " + standardDeviation(randomArray));
	}

	private static double mean(int[] a) {
		return meanOfRange(a, 0, (a.length - 1));
	}

	private static double meanOfRange(int[] a, int startIndex, int endIndex) {
		double sum = 0.0;
		int n = (endIndex - startIndex) + 1;
		for (int i = startIndex ; i <= endIndex ; i++) {
			sum += a[i];
		}

		return (sum / n);
	}

	private static double standardDeviation(int[] a) {
		double sum = 0;
		double mean = mean(a);

		for (int i = 0 ; i < a.length ; i++) {
			sum += Math.pow(mean - a[i], 2);
		}

		sum /= a.length - 1;

		return Math.sqrt(sum);
	}

	private static int[] makeRandom(int size, int range) {
		int[] a = new int[size];
		for (int i = 0 ; i < a.length ; i++) {
			a[i] = r.nextInt(range + 1);
		}

		return a;
	}
}