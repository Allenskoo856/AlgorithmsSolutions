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

    int count = 0;

    public int InversePairs(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        mergeSort(array, 0, array.length - 1);
        return count;
    }

    private void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) >> 1;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start,mid,end);
        }
    }

    /**
     * 将一个数组中的两个相邻有序区间合并成一个
     * @param array
     */
    private void merge(int[] array, int start, int mid ,int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
                count += mid - i + 1;
                count %= 1000000007;
            }
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= end) {
            temp[k++] = array[j++];
        }
        for (int l = 0; l < temp.length; l++) {
            array[start + l] = temp[l];
        }
    }
}
