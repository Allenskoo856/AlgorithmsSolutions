/*
 * Copyright (C), 2015-2017
 * FileName: MaxHeap
 * Author:   Administrator
 * Date:     2017/11/5 0005 20:53
 * Description: 最大堆的类    
 */

package me.zonglun.Sort;

/**
 * 〈一句话功能简述〉<br>
 * 〈最大堆的类〉
 *
 * @author Administrator
 * @create 2017/11/5 0005
 * @since 1.0.0
 */
public class MaxHeap<T extends Comparable> {
    public T[] data;   // 堆里的数据类型
    public int count;  // 堆里面的元素数量
    private int capacity;

    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public MaxHeap(int capacity) {
        data = (T[]) new Comparable[capacity + 1];  // 放进数组的索引是从1 开始的， 所以空间应该加一
        count = 0;
        this.capacity = capacity;
    }

    // 构造函数, 通过一个给定数组创建一个最大堆
    // 此外堆的Heapify过程，用来构造数组为堆
    // 该构造堆的过程, 时间复杂度为O(n)
    public MaxHeap(T arr[]) {
        int n = arr.length;
        data = (T[]) new Comparable[n + 1];
        capacity = n;
        System.arraycopy(arr, 0, data, 1, n);
        count = n;
        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    // 像最大堆中插入一个新的元素 item
    public void insert(T item) {
        data[count + 1] = item;         // 堆的索引是从1开始的，所以需要在 count + 1 上插入元素
        count++;                // 多了一个元素
        shiftUp(count);         // 用shiftUP 函数来上移动 ，维持堆的定义
    }

    // 从最大堆中取出堆顶元素, 即堆中所存储的最大数据
    public T extractMac() {
        assert count > 0;
        T max = data[1];    // 获得索引为1 的元素的值

        swap(1, count);
        count--;
        shiftDown(1);
        return max;     // 将堆顶的元素的值进行返回
    }

    //********************
    //* 最大堆核心辅助函数
    //********************
    private void shiftDown(int i) {
        while (2 * i <= count) {    // 条件是他有左孩子，即意味着左孩子索引小于最大count
            int j = 2 * i;       // 在此轮循环中,data[i]和data[j]交换位置
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0) // 如果存在右节点，并且右节点的值比左节点的值最大
                j += 1;         // 此时把j 变成了他的右孩子
            if (data[i].compareTo(data[j]) >= 0)    // 如果父节点比它的子节点要大，则不用继续了
                break;
            swap(i, j);         // 交换父节点和子节点的数值大小
            i = j;      // 索引值一并交换
        }
    }

    //********************
    //* 最大堆核心辅助函数
    //********************
    private void shiftUp(int k) {
        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {  // 当此元素的父节点比其小时候不符合堆定义
            // 防止索引越界的情况产生
            swap(k, k / 2);
            k = k / 2;  // 换元素之后，需要更新索引值
        }
    }

    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
//        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);  // 有100个存贮空间，但是没有元素
//        System.out.println(maxHeap.size());     // 0
//
//        int N = 50; // 堆中元素个数
//        int M = 100; // 堆中元素取值范围[0, M)
//        for (int i = 0; i < N; i++)
//            maxHeap.insert((int) (Math.random() * M));
//        System.out.println(maxHeap.size());
        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);
        int N = 100; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for (int i = 0; i < N; i++)
            maxHeap.insert((int) (Math.random() * M));

        Integer[] arr = new Integer[N];
        // 将MaxHeap中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        for (int i = 0; i < N; i++) {
            arr[i] = maxHeap.extractMac();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从大到小排列的
        for (int i = 1; i < N; i++)
            assert arr[i - 1] >= arr[i];
    }
}
