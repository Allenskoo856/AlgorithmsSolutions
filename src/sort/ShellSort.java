package sort;

public class ShellSort {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] sort(int[] arry) {
		int N = arry.length;
		int h = 1;
		while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364
		while (h >= 1){
			for (int i = h; i < N; i++){
				
			}
		}
		return arry;
	}
	
	public static void shellInsertSort(int beginIndex, int increament, int[] arry) {
		
		
	}
}
