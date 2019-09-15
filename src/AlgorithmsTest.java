import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AlgorithmsTest {
	public static Random rand = new Random();
	private static int[] OneThousand = new int[1000];
	private static int[] TenThousand = new int[10000];
	private static int[] OneHundredThousand = new int[100000];
	private static long startTime, endTime;
	private static Scanner io;

	public static void main(String[] args) {
		io = new Scanner(System.in);
		System.out.println("Equals Integers : (1) \nRandom Integers : (2)"
				+ " \nIncreasing Integers : (3) \nDecreasing Integers : (4)"
				+ "\nPlease enter a number to select a scenario :");
		int in = io.nextInt();

		if (in == 1)
			fillWithEqualInteger();
		else if (in == 2)
			fillWithRandomIntegers();
		else if (in == 3)
			fillWithIncreasingIntegers();
		else if (in == 4)
			fillWithDecreasingIntegers();
		System.out.println("A Thousand : (1) \nTen Thousand : (2) \nOne Hundred Thousand : (3)"
				+ "\nPlease Choice your array Size : ");
		int size = io.nextInt();
		System.out.print("HeapSort : (1) \nQuickSort : (2) \nDualPivotQuickSort : (3) \nIntroSort : (4)"
				+ "\nWhich sort method will you use?");
		int sortType = io.nextInt();
		System.out.println();
		if (size == 1) {
			System.out.println("[Before] \n"+Arrays.toString(OneThousand));
		}else if (size == 2) {
			System.out.println("[Before] \n"+Arrays.toString(TenThousand));
		}else if (size == 3) {
			//System.out.println("[Before] \n"+Arrays.toString(OneHundredThousand));
		}
		System.out.println();
		if (sortType == 1) {
			if (size == 1) {
				System.out.println("[Sorting operation have just started]");
				startTime = System.currentTimeMillis();
				HeapSort.heapSort(OneThousand);
				endTime = System.currentTimeMillis();

			} else if (size == 2) {
				System.out.println("[Sorting operation have just started]");
				startTime = System.currentTimeMillis();
				HeapSort.heapSort(TenThousand);
				endTime = System.currentTimeMillis();
			} else if (size == 3) {
				System.out.println("[Sorting operation have just started]");
				startTime = System.currentTimeMillis();
				HeapSort.heapSort(OneHundredThousand);
				endTime = System.currentTimeMillis();
			}
		} else if (sortType == 2) {
			System.out.println(
					"FirstElement, RandomElement, MidOfFirstMidLastElement" + "Which quick sort method will you use?");
			String quickSortVersion = io.next();
			if (size == 1) {
				System.out.println("[Sorting operation have just started]");
				startTime = System.currentTimeMillis();
				QuickSort.quicksort(OneThousand, quickSortVersion);
				endTime = System.currentTimeMillis();
			} else if (size == 2) {
				System.out.println("[Sorting operation have just started]");
				startTime = System.currentTimeMillis();
				QuickSort.quicksort(TenThousand, quickSortVersion);
				endTime = System.currentTimeMillis();
			} else if (size == 3) {
				System.out.println("[Sorting operation have just started]");
				startTime = System.currentTimeMillis();
				QuickSort.quicksort(OneHundredThousand, quickSortVersion);
				endTime = System.currentTimeMillis();
			}
		} else if (sortType == 3) {
			if (size == 1) {
				System.out.println("[Sorting operation have just started]");
				startTime = System.currentTimeMillis();
				QuickSort_DualPivot.DualPivotQuickSort(OneThousand);
				endTime = System.currentTimeMillis();
			} else if (size == 2) {
				System.out.println("[Sorting operation have just started]");
				startTime = System.currentTimeMillis();
				QuickSort_DualPivot.DualPivotQuickSort(TenThousand);
				endTime = System.currentTimeMillis();
			} else if (size == 3) {
				System.out.println("[Sorting operation have just started]");
				startTime = System.currentTimeMillis();
				QuickSort_DualPivot.DualPivotQuickSort(OneHundredThousand);
				endTime = System.currentTimeMillis();
			}

		} else if (sortType == 4) {
			if (size == 1) {
				System.out.println("[Sorting operation have just started]");
				startTime = System.currentTimeMillis();
				IntroSort.introsort(OneThousand);
				endTime = System.currentTimeMillis();
			} else if (size == 2) {
				System.out.println("[Sorting operation have just started]");
				startTime = System.currentTimeMillis();
				IntroSort.introsort(TenThousand);
				endTime = System.currentTimeMillis();
			} else if (size == 3) {
				System.out.println("[Sorting operation have just started]");
				startTime = System.currentTimeMillis();
				IntroSort.introsort(OneHundredThousand);
				endTime = System.currentTimeMillis();
			}
		}
		System.out.println();
		if (size == 1) {
			System.out.println("[After] \n"+Arrays.toString(OneThousand));
		}else if (size == 2) {
			System.out.println("[After] \n"+Arrays.toString(TenThousand));
		}else if (size == 3) {
			//System.out.println("[After] \n"+Arrays.toString(OneHundredThousand));
		}
		System.out.println();
		
		
		if (in == 1)
			System.out.println("Equals Integer Ordered Sorting Time : " + ((double) endTime - (double) startTime)
					+ " milliseconds");
		else if (in == 2)
			System.out.println("Random Integers Ordered Sorting Time : " + ((double) endTime - (double) startTime)
					+ " milliseconds");
		else if (in == 3)
			System.out.println("Increasing Integers Ordered Sorting Time : " + ((double) endTime - (double) startTime)
					+ " milliseconds");
		else if (in == 4)
			System.out.println("Decreasing Integers Ordered Sorting Time : " + ((double) endTime - (double) startTime)
					+ " milliseconds");
		
	}

	public static void fillWithRandomIntegers() {
		Random random = new Random();
		for (int i = 0; i < 100000; i++) {
			if (i < 1000)
				OneThousand[i] = random.nextInt(1000);
			if (i < 10000)
				TenThousand[i] = random.nextInt(10000);
			if (i < 100000)
				OneHundredThousand[i] = random.nextInt(100000);
		}
	}

	public static void fillWithEqualInteger() {
		Random random = new Random();
		int equalIntegers = random.nextInt(10000);
		for (int i = 0; i < 100000; i++) {
			if (i < 1000)
				OneThousand[i] = equalIntegers;
			if (i < 10000)
				TenThousand[i] = equalIntegers;
			if (i < 100000)
				OneHundredThousand[i] = equalIntegers;
		}
	}

	public static void fillWithIncreasingIntegers() {
		for (int i = 0; i < 100000; i++) {
			if (i < 1000)
				OneThousand[i] = i;
			if (i < 10000)
				TenThousand[i] = i;
			if (i < 100000)
				OneHundredThousand[i] = i;
		}
	}

	public static void fillWithDecreasingIntegers() {
		int j = 0; int k = 999, l = 9999, m = 999999;
		for (int i = 100000 - 1; i >= 0; i--) {
			if (j < 1000)
				OneThousand[j] = k;
			if (j < 10000)
				TenThousand[j] = l;
			if (j < 100000)
				OneHundredThousand[j] = m;
			j++; k--; l--; m--;
		}
	}

}
