/*
 * Copyright (C), 2015-2017
 * FileName: IndexHeapSort
 * Author:   Administrator
 * Date:     2017/11/6 0006 21:43
 * Description: 使用最大索引堆进行堆排序, 来验证我们的最大索引堆的正确性    
 */

package me.zonglun.Sort;

/**
 * 〈一句话功能简述〉<br>
 * 〈使用最大索引堆进行堆排序, 来验证我们的最大索引堆的正确性〉
 *
 * @author Administrator
 * @create 2017/11/6 0006
 * @since 1.0.0
 */
// 在后续的图论中, 无论是最小生成树算法, 还是最短路径算法, 我们都需要使用索引堆进行优化:)
public class IndexHeapSort {

    // 我们的算法类不允许产生任何实例
    private IndexHeapSort(){}

    public static void sort(Comparable[] arr){

        int n = arr.length;

        IndexMaxHeap<Comparable> indexMaxHeap = new IndexMaxHeap<>(n);
        for( int i = 0 ; i < n ; i ++ )
            indexMaxHeap.insert( i , arr[i] );

        for( int i = n-1 ; i >= 0 ; i -- )
            arr[i] = indexMaxHeap.extractMax();
    }

    // 测试 Index Heap Sort
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("me.zonglun.Sort.IndexHeapSort", arr);

    }
}
