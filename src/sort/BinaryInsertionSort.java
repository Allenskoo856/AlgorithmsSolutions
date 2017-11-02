package sort;


import edu.princeton.cs.algs4.StdOut;

public class BinaryInsertionSort {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
		int[] ms = sort(a);
		for (int i = 0; i < ms.length; i++) {
			StdOut.print(ms[i] + " ");
		}
	}

	public static int[] sort(int[] arry) {
		int len = arry.length;
		for (int i = 0; i < len -1; i++) {
			int temp = arry[i];
			if (temp > arry[i + 1]){
				int inserterIndex = binarySearch(0,	 i -1, temp, arry);
				for (int j = i; j > inserterIndex; j--) {
					arry[inserterIndex + 1]  = arry[inserterIndex];
				}
				arry[inserterIndex] = temp;
			}
		}
		return arry;
	}
	
	
	public static int binarySearch(int lowerBound,int upperBound,int target,int[] array){  
	       int curIndex;   
	       while(lowerBound<upperBound){  
	          curIndex= (lowerBound+upperBound)/2;  
	          if(array[curIndex]>target){  
	              upperBound= curIndex - 1;  
	          }else{  
	              lowerBound= curIndex + 1;  
	          }  
	       }  
	       return lowerBound;  
	   }  
}
