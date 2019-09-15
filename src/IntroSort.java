
public class IntroSort {
	public static void introsort(int[] arrayToSort) {
		int depth = ((int) Math.log(arrayToSort.length)) * 2;
		sort(arrayToSort, depth, 0, arrayToSort.length - 1);
	}

	private static void sort(int[] arrayToSort, int depth, int start, int end) {
		int length = arrayToSort.length;
		if (length <= 1) {
			return;
		} else if (depth == 0) {
			HeapSort.heapSort(arrayToSort);
		} else {
			if (start >= end)
				return;
			int index = QuickSort.partitionFirstElement(arrayToSort, start, end);
			sort(arrayToSort, start, index, depth - 1);
			sort(arrayToSort, index + 1, end, depth - 1);
		}
	}

}
