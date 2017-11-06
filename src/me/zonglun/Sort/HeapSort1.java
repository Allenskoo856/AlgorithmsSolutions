/*
 * Copyright (C), 2015-2017
 * FileName: HeapSort1
 * Author:   Administrator
 * Date:     2017/11/6 0006 17:33
 * Description: 堆排序的第一个版本    
 */

package me.zonglun.Sort;

/**
 * 〈一句话功能简述〉<br>
 * 〈堆排序的第一个版本〉
 *
 * @author Administrator
 * @create 2017/11/6 0006
 * @since 1.0.0
 */
public class HeapSort1 {
    private HeapSort1() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<>(n);
        for (Comparable i : arr) {   // 最大堆之中放入所有的元素
            maxHeap.insert(i);
        }
        for (int i = n - 1; i >= 0; i--) {  // 从后往前面便利以或者排序是从小到大
            arr[i] = maxHeap.extractMac();
        }
    }

    // 测试 HeapSort1
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("me.zonglun.Sort.HeapSort1", arr);
    }

}
