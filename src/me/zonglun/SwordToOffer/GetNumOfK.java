package me.zonglun.SwordToOffer;

/**
 * 统计一个数字在排序数组中出现的次数
 *
 * @author : Administrator
 * @Subject: 统计一个数字在排序数组中出现的次数
 *      例如输入排序数组{1，2，3，3，3，4，5} 数字3，输出为 4
 * @create 2018-04-20 15:30
 */
public class GetNumOfK {

    public int GetNumOFArray(int[] array,int k) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }
        int firstK = getFirstK(array, k, 0, length - 1);
        int lastK = getLastK(array, k, 0, length - 1);
        if (firstK != -1 && lastK != -1) {
            return lastK - firstK + 1;
        }
        return 0;
    }

    /**
     * 得到数组中第一个K的数值
     * @param array
     * @param k
     * @param start
     * @param end
     * @return
     */
    private int getFirstK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        // 第一个K在数组的前半部分
        if (array[mid] > k) {
            return getFirstK(array, k, start, mid - 1);
        } else if (array[mid] < k) {
            return getFirstK(array, k, mid + 1, end);
            // 如果中间的K相等，并且同时前一个元素也等于K，则说明第一个K在前面
        } else if (mid -1 >=0 && array[mid - 1] == k) {
            return getFirstK(array, k, start, mid - 1);
        } else {
            return mid;
        }
    }

    /**
     * 得到数组中最后的一个数值的K的值
     * @param array
     * @param k
     * @param start
     * @param end
     * @return
     */
    private int getLastK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        if (array[mid] > k) {
            return getLastK(array, k, start, mid - 1);
        } else if (array[mid] < k) {
            return getLastK(array, k, mid + 1, end);
            // 此时中间数不是最后一个K, 任然在最后半段
        } else if (mid + 1<array.length &&  array[mid + 1] == k) {
            return getLastK(array, k, mid + 1, end);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 3, 4, 5};
        int[] array2 = {1, 2, 3, 3, 4, 4, 5};
        System.out.println(new GetNumOfK().GetNumOFArray(array,3));
        System.out.println(new GetNumOfK().GetNumOFArray(array2,4));
    }
}
