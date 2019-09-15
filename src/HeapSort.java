
/**
 * Sorts arrays via HeapSort, for more details about Heapsort see
 * <a href="http://en.wikipedia.org/wiki/Heap_sort" >Heap Sort Wiki</a>
 * 
 * @author Nuri Çilengir
 *         <li>nuriilengir@protonmail.com</li>
 *         <li>github.com/derectus</li>
 *         <li>Dept. of Computer Engineering at Dokuz Eylül University</li>
 */
public class HeapSort {

	/**
	 * Builds a min-heap of the given array and heapsize.
	 * 
	 * @param array    whose min heap is to be formed
	 * @param heapsize the total size of the heap. <b>Note that heapsize &#8804;
	 *                 length of the array.</b>
	 * @see #maxHeapify(int[],int,int)
	 */
	private static void buildMaxHeap(int array[]) {
		int heapMaxIdx = array.length - 1;
		for (int i = heapMaxIdx / 2; i >= 0; i--) {
			maxHeapify(array, i, heapMaxIdx);
		}
	}

	/**
	 * Builds a heap of the array from the given index and heapsize.
	 * <p>
	 * This method tries to place the largest element from the sub-tree rooted at
	 * index at index.
	 * </p>
	 * 
	 * @param A        the array whose heap must be computed.
	 * @param i        the root of the subtree where the largest index element be
	 *                 kept.
	 * @param heapsize the heapsize of the subtree.
	 * 
	 */
	public static void maxHeapify(int[] A, int i, int heapSize) {
		int left = leftChild(i);
		int right = rightChild(i);
		int largest = i;

		if (left <= heapSize && A[left] > A[i])
			largest = left;
		if (right <= heapSize && A[right] > A[largest])
			largest = right;

		if (largest != i) {
			Utils.swap(A, i, largest);
			maxHeapify(A, largest, heapSize);
		}
	}

	/**
	 * Sorts an {@code int[]} in ascending order using heap sort.
	 * 
	 * @param A takes a integer array as input
	 */
	public static void heapSort(int[] A) {
		int heapMaxIdx = A.length - 1;
		buildMaxHeap(A);
		for (int i = A.length - 1; i > 0; i--) {
			Utils.swap(A, 0, i);
			heapMaxIdx--;
			maxHeapify(A, 0, heapMaxIdx);
		}
	}


	/**
	 * Gets the parent of the given child node.
	 * 
	 * @return the parent index of the given child
	 */
	@SuppressWarnings("unused")
	private static int parent(int i) {
		return (i - 1) / 2;
	}

	/**
	 * Gets the left child of the given parent node.
	 * 
	 * @return the left index of the given parent node.
	 */
	private static int leftChild(int i) {
		return 2 * i + 1;
	}

	/**
	 * Gets the right child of the given parent node.
	 * 
	 * @return the right index of the given parent node.
	 */
	private static int rightChild(int i) {
		return 2 * i + 2;
	}

}
