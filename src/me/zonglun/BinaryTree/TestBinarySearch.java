/*
 * Copyright (C), 2015-2017
 * FileName: TestBinarySearch
 * Author:   Administrator
 * Date:     2017/11/8 0008 10:38
 * Description:  比较非递归和递归写法的二分查找的效率    
 */

package me.zonglun.BinaryTree;

/**
 * 〈一句话功能简述〉<br>
 * 〈 比较非递归和递归写法的二分查找的效率〉
 *
 * @author Administrator
 * @create 2017/11/8 0008
 * @since 1.0.0
 */
public class TestBinarySearch {

    private TestBinarySearch() {
    }

    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++)
            arr[i] = i;


        // 测试非递归二分查找法
        long startTime = System.currentTimeMillis();

        // 对于我们的待查找数组[0...N)
        // 对[0...N)区间的数值使用二分查找，最终结果应该就是数字本身
        // 对[N...2*N)区间的数值使用二分查找，因为这些数字不在arr中，结果为-1
        for (int i = 0; i < 2 * N; i++) {
            int v = BinarySearch.find(arr, i);
            if (i < N)
                assert v == i;
            else
                assert v == -1;
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Binary Search (Without Recursion): " + (endTime - startTime) + "ms");


        // 测试递归的二分查找法
        startTime = System.currentTimeMillis();

        // 对于我们的待查找数组[0...N)
        // 对[0...N)区间的数值使用二分查找，最终结果应该就是数字本身
        // 对[N...2*N)区间的数值使用二分查找，因为这些数字不在arr中，结果为-1
        for (int i = 0; i < 2 * N; i++) {
            int v = BinarySearch2.find(arr, i);
            if (i < N)
                assert v == i;
            else
                assert v == -1;
        }
        endTime = System.currentTimeMillis();
        System.out.println("Binary Search (With Recursion): " + (endTime - startTime) + "ms");

    }

}
