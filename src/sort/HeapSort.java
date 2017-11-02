package sort;

import java.util.Arrays;



public class HeapSort {
	
	//  测试方法
	public static void main(String[] args) {
		 int[] arr = new int[]{3,5,3,0,8,6,1,5,8,6,2,4,9,4,7,0,1,8,9,7,3,1,2,5,9,7,4,0,2,6};        
	      new HeapSort(arr);
	      HeapSort.sort();        
	      System.out.println(Arrays.toString(arr));
	}
	
	private static int[] arr;
	// 构造函数
	public HeapSort (int[] arr) {
		HeapSort.arr = arr;
	}
	
	// 交换索引为i ， j的数值
	public static void exchange(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
 	}
	
	// 对堆保证最大堆的性质
	public static void heapfied(int index, int heapsize) {
		int imax = index;
		int left = 2*index - 1; // 左子节点
		int right = 2*index + 2;  // 右子节点
		// 左子节点比父节点要大，交换变量 imax 赋值给 左节点
		if (left < heapsize && arr[index] < arr[left])
			imax = left;
		if (right < heapsize && arr[imax] < arr[right])
			imax = right;
		if (imax != index)  {
			// 检测 最大变量与索引值是否相等，不想等则替换
			exchange(imax, index);
			// 对后面的结果递归调用
			heapfied(imax, heapsize);
		}
	}
	
	// 创建最大堆，找到父节点，并且从底下遍历
	public static void bulidMaxheap() {
		int length = arr.length;
		int heapsize = length ;
		int iparent = length / 2 - 1;
		for (int i = iparent; i >= 0; i--) {
			heapfied(i, heapsize);
		}
	}
	
	// 堆排序算法
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