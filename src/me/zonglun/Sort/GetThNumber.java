/*
 * Copyright (C), 2015-2017
 * FileName: GetThNumber
 * Author:   Administrator
 * Date:     2017/11/4 0004 22:18
 * Description: 取出数组中第N大的元素    
 */

package me.zonglun.Sort;

/**
 * 〈一句话功能简述〉<br>
 * 〈取出数组中第N大的元素〉
 *
 * @author Administrator
 * @create 2017/11/4 0004
 * @since 1.0.0
 * @subject 取出一个数组中第N大的元素
 */
public class GetThNumber {
    private GetThNumber() {}

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    // partition 过程, 和快排的partition一样
    // 思考: 双路快排和三路快排的思想能不能用在selection算法中? :)
    private static int partition(Comparable[] arr, int l, int r){

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l , (int)(Math.random()*(r-l+1))+l );

        Comparable v = arr[l];

        int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v
        for( int i = l + 1 ; i <= r ; i ++ )
            if( arr[i].compareTo(v) < 0 ){
                j ++;
                swap(arr, j, i);
            }

        swap(arr, l, j);

        return j;
    }

    // 求出nums[l...r]范围里第k小的数
    private static Comparable solve(Comparable[] nums, int l, int r, int k){

        if( l == r )
            return nums[l];

        // partition之后, nums[p]的正确位置就在索引p上
        int p = partition(nums, l, r);

        if( k == p )    // 如果 k == p, 直接返回nums[p]
            return nums[p];
        else if( k < p )    // 如果 k < p, 只需要在nums[l...p-1]中找第k小元素即可
            return solve( nums, l, p-1, k);
        else // 如果 k > p, 则需要在nums[p+1...r]中找第k小元素
            return solve( nums, p+1, r, k );
    }
    // 寻找nums数组中第k小的元素
    public static Comparable solve(Comparable nums[], int n, int k) {

        assert k >= 0 && k < n;
        return solve(nums, 0, n - 1, k);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试 Selection
    public static void main(String[] args) {

        // 生成一个大小为n, 包含0...n-1这n个元素的随机数组arr
        int N = 10000;
        Integer[] arr = SortTestHelper.generateOrderedArray(N);

        // 验证selection算法, 对arr数组求第i小元素, 应该为i
        for( int i = 0 ; i < N ; i ++ ){
            System.out.println("test " + i + " complete.");
        }
    }
}
