package sort;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		 int[] arr = new int[]{3,5,3,0,8,6,1,5,8,6,2,4,9,4,7,0,1,8,9,7,3,1,2,5,9,7,4,0,2,6};        
	      new HeapSort(arr);
	      HeapSort.sort();        
	      System.out.println(Arrays.toString(arr));
	}
	
	private static int[] arr;

	public HeapSort (int[] arr) {
		HeapSort.arr = arr;
	}

	public static void exchange(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
 	}

	public static void heapfied(int index, int heapsize) {
		int imax = index;
		int left = 2*index - 1;
		int right = 2*index + 2;

		if (left < heapsize && arr[index] < arr[left])
			imax = left;
		if (right < heapsize && arr[imax] < arr[right])
			imax = right;
		if (imax != index)  {
			exchange(imax, index);

			heapfied(imax, heapsize);
		}
	}

	public static void bulidMaxheap() {
		int length = arr.length;
		int heapsize = length ;
		int iparent = length / 2 - 1;
		for (int i = iparent; i >= 0; i--) {
			heapfied(i, heapsize);
		}
	}

	public static int[] sort() {
		bulidMaxheap();
		int heapsize = arr.length;
		for (int i = heapsize - 1; i > 0; i--) {
			exchange(0, i);
			heapfied(0, i);
		}
		return arr;
	}
}