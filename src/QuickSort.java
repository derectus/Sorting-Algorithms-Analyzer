import java.util.Random;

/**
 * Sorts arrays via QuickSort, for more details about QuickSort see
 * <a href="https://en.wikipedia.org/wiki/Quicksort" >Quick Sort Wiki</a>
 * 
 * @author Nuri Çilengir
 *         <li>nuriilengir@protonmail.com</li>
 *         <li>github.com/derectus</li>
 *         <li>Dept. of Computer Engineering at Dokuz Eylül University</li>
 */

public class QuickSort {
	/**
	 * Sorts an {@code int[]} in ascending order using quick sort.
	 * <p>
	 * This method sorts the array in-place.
	 * 
	 * @param array takes an integer array as input.
	 */

	public static void quicksort(int array[], String quickSortVersion) {
		if (quickSortVersion.equals("FirstElement")) {
			System.out.println("sa");
			quicksortV1(array, 0, array.length - 1);
		}
		if (quickSortVersion.equals("RandomElement")) {
			Random rand = new Random();
			if (array.length > 1) {
				quicksortV2(array, 0, array.length - 1, rand);
			}
		}
		if (quickSortVersion.equals("MidOfFirstMidLastElement")) {
			quicksortV3(array, 0, array.length - 1);
		}
	}

	/**
	 * Divides the arrays into smaller parts while placing one element at its
	 * <b>true</b> sorted position in the array.
	 * <p>
	 * The recursion tree can grow quite long for large input and this might cause
	 * {@link java.lang.StackOverflowError} errors.
	 * </p>
	 * 
	 * @param array the array to be sorted.
	 * @param low   the first index of the subarray.
	 * @param high  the last index of the subarray.
	 * @throws java.lang.StackOverflowError
	 * @see java.lang.StackOverflowError
	 */
	private static void quicksortV1(int array[], int low, int high) {
		if (low < high) {
			int pivot = partitionFirstElement(array, low, high);
			quicksortV1(array, low, pivot - 1);
			quicksortV1(array, pivot + 1, high);
		}

	}

	/**
	 * Partitions the elements into two ideally equal parts while placing one
	 * element at its correct position relative to the sorted array.
	 * 
	 * <p>
	 * The index at that element <b>must</b> not participate in any further
	 * recursion levels.
	 * </p>
	 * 
	 * @param array the array to be sorted.
	 * @param low   the first index of the subarray.
	 * @param high  the last index of the subarray.
	 * @return the index of the element which got placed in its final position.
	 */
	public static int partitionFirstElement(int array[], int low, int high) {
		int pivot = array[high];
		int i = low - 1;

		for (int j = low; j <= high - 1; j++)
			if (array[j] <= pivot)
				Utils.swap(array, ++i, j);

		Utils.swap(array, i + 1, high);
		return i + 1;
	}

	/**
	 * Instead of always using A[r] as the pivot, we will select a randomly chosen
	 * element from the subarray A[p..r].
	 * <p>
	 * The recursion tree can grow quite long for large input and this might cause
	 * {@link java.lang.StackOverflowError} errors.
	 * </p>
	 * 
	 * @param A the array to be sorted.
	 * @param p the first index of the subarray.
	 * @param r the last index of the subarray.
	 * @throws java.lang.StackOverflowError
	 * @see java.lang.StackOverflowError
	 */
	private static void quicksortV2(int[] A, int p, int r, Random rand) {
		if (p < r) {
			int q = partitionRandomized(A, p, r, rand);
			quicksortV2(A, p, q - 1, rand);
			quicksortV2(A, q + 1, r, rand);
		}
	}

	/**
	 * Partitions the elements into two ideally equal parts while placing one
	 * element at its correct position relative to the sorted array.
	 * 
	 * <p>
	 * The index at that element <b>must</b> not participate in any further
	 * recursion levels.
	 * </p>
	 * 
	 * @param array the array to be sorted.
	 * @param low   the first index of the subarray.
	 * @param high  the last index of the subarray.
	 * @return the index of the element which got placed in its final position.
	 */
	private static int partitionRandomized(int[] A, int p, int r, Random rand) {
		int index = rand.nextInt(r - p + 1) + p;
		Utils.swap(A, index, r);

		// choose a pivot
		int pivot = A[r];

		// keep track of top index of filtered vals
		int q = p;

		// do the filtering
		for (int i = p; i < r; i++) {
			if (A[i] <= pivot) {
				Utils.swap(A, i, q);
				q++;
			}
		}
		Utils.swap(A, r, q);
		return q;
	}

	private static int partitionMidOfFirstMidLastElement(int[] A, int p, int r) {
		int middle = p + (r - p) / 2;
		int pivot = A[middle];
		int i = p - 1;
		for (int j = p; j <= r - 1; j++)
			if (A[j] <= pivot)
				Utils.swap(A, ++i, j);

		Utils.swap(A, i + 1, r);
		return i + 1;
	}

	private static void quicksortV3(int array[], int low, int high) {
		if (low < high) {
			int pivot = partitionFirstElement(array, low, high);
			quicksortV3(array, low, pivot - 1);
			quicksortV3(array, pivot + 1, high);
		}

	}



}
