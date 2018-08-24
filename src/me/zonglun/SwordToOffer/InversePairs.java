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
    // todo
    public int InversePairs(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        mergeSort(array, 0, array.length - 1);
        return count;
    }

    private void mergeSort(int[] array, int i, int i1) {
        if (i < i1) {
            int mid = (i + i1) >> 1;
            mergeSort(array, i, mid);
            mergeSort(array, mid, i1);
            return;
        }
    }
}
