package sort;

import edu.princeton.cs.algs4.StdOut;

public class InsertionSort {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,44,38,5,47,15,36,26,27,2,46,4,19,50, 12,48,78};
		int[] ms = sort(a);
		for (int i = 0; i < ms.length; i++) {
			StdOut.print(ms[i] + " ");
		}
	}
	
	public static int[] sort(int[] a) {
		int N = a.length;
		int temp;
		for (int i = 0; i < N; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j - 1]) {
					temp = a[j -1];
					a[j -1] = a[j];
					a[j] = temp;				
				}
			}
		}
		return a;
	}
}
