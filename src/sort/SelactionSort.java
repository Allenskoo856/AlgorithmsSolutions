package sort;

import edu.princeton.cs.algs4.StdOut;

public class SelactionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long begin = System.currentTimeMillis(); // 定义开始运行时间
		int[] a = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
		int[] ms = sort(a);
		long end = System.currentTimeMillis(); 
		StdOut.println(end - begin);
		for (int i = 0; i < ms.length; i++) {
			StdOut.print(ms[i] + " ");
		}
	}
	
	
	public static int[] sort(int [] a) {
		
		int N = a.length;
		int temp;
		for (int i = 0; i < N -1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < N; j++) {
				if (a[j] < a[minIndex])
					minIndex = j;
			}			
			temp = a[i];
			a[i] = a[minIndex];
			a[minIndex] = temp;
		}
		return a;
	}
}
