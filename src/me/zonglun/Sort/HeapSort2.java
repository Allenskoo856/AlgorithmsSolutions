/*
 * Copyright (C), 2015-2017
 * FileName: HeapSort2
 * Author:   Administrator
 * Date:     2017/11/6 0006 19:59
 * Description: HeapSort2     
 */

package me.zonglun.Sort;

/**
 * 〈一句话功能简述〉<br>
 * 〈HeapSort2 〉
 *
 * @author Administrator
 * @create 2017/11/6 0006
 * @since 1.0.0
 */
public class HeapSort2 {

    private HeapSort2() {}

    // 对整个arr数组使用HeapSort2排序
    // HeapSort2, 借助我们的heapify过程创建堆
    // 此时, 创建堆的过程时间复杂度为O(n), 将所有元素依次从堆中取出来, 实践复杂度为O(nlogn)
    // 堆排序的总体时间复杂度依然是O(nlogn), 但是比HeapSort1性能更优, 因为创建堆的性能更优
    public static void sort(Comparable[] arr){

        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<Comparable>(arr);
        for( int i = n-1 ; i >= 0 ; i -- )
            arr[i] = maxHeap.extractMac();
    }

    // 测试 HeapSort2
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("me.zonglun.Sort.HeapSort2", arr);
    }
}
