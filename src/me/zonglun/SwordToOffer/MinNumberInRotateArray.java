/*
 * Copyright (C), 2015-2017
 * FileName: MinNumberInRotateArray
 * Author:   Administrator
 * Date:     2017/11/19 0019 20:09
 * Description: 旋转数组的最小数字    
 */

package me.zonglun.SwordToOffer;

/**
 * 〈一句话功能简述〉<br>
 * 〈旋转数组的最小数字〉
 *
 * @author Administrator
 * @subject 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *          输入一个非递减排序(递增)的数组的一个旋转，输出旋转数组的最小元素。
 *          例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *          NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @create 2017/11/19 0019
 * @since 1.0.0
 */
public class MinNumberInRotateArray {
    private static int minNumberInRotateArray(int[] array) {
        if (array.length == 0)
            return 0;
        for (int anArray : array) {
            if (anArray < 0)
                return -1;
        }
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > array[high])
                low = mid + 1;
            else if (array[mid] == array[high])
                high--;
            else
                high = mid;
        }
        return array[low];
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        int[] arr1 = {1, 0, 1, 1, 1};
        int[] arr2 = {1, 1, 1, 0, 1};
        System.out.println(MinNumberInRotateArray.minNumberInRotateArray(arr));
        System.out.println(MinNumberInRotateArray.minNumberInRotateArray(arr1));
        System.out.println(MinNumberInRotateArray.minNumberInRotateArray(arr2));
    }
}
