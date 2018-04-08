package me.zonglun.SwordToOffer;

/**
 * @author : Administrator
 * @subject : 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 *              输入一个数组,求出这个数组中的逆序对的总数P。
 *              并将P对 1000000007 取模的结果输出。 即输出 P%1000000007
 * @example: 题目保证输入的数组中没有的相同的数字
                数据范围：
            对于%50的数据,   size <= 10^4
            对于%75的数据,   size <= 10^5
            对于%100的数据,  size <= 2*10^5
 * @create 2018-04-05 20:23
 */
public class InversePairs {

    private int result;

    public int solutions(int [] array) {
        result = 0;
        if (array != null) {
            mergeSortUpToDown(array, 0, array.length - 1);
        }
        return result;
    }

    /**
     * 归并排序，从上往下
     * @param array
     * @param start
     * @param end
     */
    private void mergeSortUpToDown(int[] array, int start, int end) {
        if (start >= end){
            return;
        }
        int mid = (end - start) / 2;
        mergeSortUpToDown(array, start, mid);
        mergeSortUpToDown(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    /**
     *
     * @param array
     * @param start
     * @param mid
     * @param end
     */
    private void merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            }
        }
    }
}
