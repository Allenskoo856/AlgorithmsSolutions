/*
 * Copyright (C), 2015-2017
 * FileName: QuickSort2Ways
 * Author:   Administrator
 * Date:     2017/11/4 0004 20:23
 * Description: QuickSort2Ways     
 */

package me.zonglun.Sort;

/**
 * 〈一句话功能简述〉<br>
 * 〈QuickSort2Ways 〉
 * 快排的索引值视图
 * <1>   ![mark](http://ojd94jpsx.qnssl.com/blog/20171104/202441189.png)
 * <2>   ![mark](http://ojd94jpsx.qnssl.com/blog/20171104/202550225.png)
 * <3>   ![mark](http://ojd94jpsx.qnssl.com/blog/20171104/202644348.png)
 * <4>   ![mark](http://ojd94jpsx.qnssl.com/blog/20171104/202752738.png)
 * <5>   ![mark](http://ojd94jpsx.qnssl.com/blog/20171104/202909189.png)
 *
 * @author Administrator
 * @create 2017/11/4 0004
 * @since 1.0.0
 */
public class QuickSort2Ways {
    private QuickSort2Ways() {
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    static void sort(Comparable[] arr, int l, int r) {
        // 对于小规模数组, 使用插入排序
        if (l < r) return;
       /* if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }*/

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static int partition(Comparable[] arr, int l, int r) {
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
        Comparable v = arr[l];

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l + 1, j = r;
        while (true) {
            // 注意这里的边界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0
            while (i <= r && arr[i].compareTo(v) < 0)
                i++;
            // 如果条件相等的时候回将，这些会集中在某一端，从而会造成树的大量的不平衡
            //  see more details in http://coding.imooc.com/learn/questiondetail/4920.html
            // 注意这里的边界, arr[j].compareTo(v) > 0, 不能是arr[j].compareTo(v) >= 0
            while (j >= l + 1 && arr[j].compareTo(v) > 0)
                j--;
            if (i > j) break;   // 当 i > j 的时候循环应该停止
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l ,j);
        return j;
    }

    // 测试 QuickSort
    public static void main(String[] args) {

        // 双路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("me.zonglun.Sort.QuickSort2Ways", arr);
    }
}
