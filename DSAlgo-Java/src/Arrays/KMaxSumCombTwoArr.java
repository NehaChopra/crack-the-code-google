//https://www.geeksforgeeks.org/k-maximum-sums-non-overlapping-contiguous-sub-arrays/
package Arrays;

public class KMaxSumCombTwoArr {
	public static void main(String[] args) {
		// int arr1[] = { 4, 1, 1, -1, -3, -5, 6, 2, -6, -2 };
		// int k = 3;
		int arr1[] = { 5, 1, 2, -6, 2, -1, 3, 1 };
		int k = 2;
		int farr[] = KMaxSumCombTwoArr(arr1, k);
		for (int index = 0; index < farr.length; index++) {
			System.out.println(farr[index]);
		}
	}

	public static int[] KMaxSumCombTwoArr(int aarr[], int k) {
		int farr[] = new int[k];
		int prevElement = 0;
		for (int index = 0; index < aarr.length; index++) {
			int element = aarr[index];
			if (element < 0) {
				if (prevElement > 0 && prevElement >= farr[0]) {
					farr[0] = prevElement;
					prevElement = 0;
					heapSort(farr);
				}
				if (farr[0] <= 0 && (element > farr[0] || farr[0] == 0)) {
					farr[0] = element;
					heapSort(farr);
				}
			} else {
				prevElement = prevElement + element;
			}
		}
		return farr;
	}

	public static void heapSort(int[] inputArray) {
		for (int index = inputArray.length / 2 - 1; index >= 0; index--) {
			heapify(index, inputArray.length, inputArray);
		}

		for (int index = inputArray.length - 1; index >= 0; index--) {
			swap(0, index, inputArray);
			heapify(0, index, inputArray);
		}
	}

	public static void heapify(int index, int end, int[] inputArray) {
		int largest = index;
		int left = leftChild(index);
		int right = rightChild(index);
		if (left < end && inputArray[left] > inputArray[largest]) {
			largest = left;
		}
		if (right < end && inputArray[right] > inputArray[largest]) {
			largest = right;
		}
		if (largest != index) {
			swap(index, largest, inputArray);
			heapify(largest, end, inputArray);
		}
	}

	public static int leftChild(int index) {
		return ((2 * index) + 1);
	}

	public static int rightChild(int index) {
		return ((2 * index) + 2);
	}

	public static void swap(int iIndex, int jIndex, int[] inputArray) {
		int temp = inputArray[iIndex];
		inputArray[iIndex] = inputArray[jIndex];
		inputArray[jIndex] = temp;
	}

}
