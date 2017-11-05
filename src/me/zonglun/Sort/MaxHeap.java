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

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(T item) {
        data[count + 1] = item;         // 堆的索引是从1开始的，所以需要在 count + 1 上插入元素
        count++;                // 多了一个元素
        shiftUp(count);         // 用shiftUP 函数来上移动 ，维持堆的定义
    }

    //********************
    //* 最大堆核心辅助函数
    //********************
    private void shiftUp(int k) {
        while ( k >1 && data[k / 2].compareTo(data[k]) < 0) {  // 当此元素的父节点比其小时候不符合堆定义
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
        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);  // 有100个存贮空间，但是没有元素
        System.out.println(maxHeap.size());     // 0

        int N = 50; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for( int i = 0 ; i < N ; i ++ )
            maxHeap.insert((int) (Math.random() * M));
        System.out.println(maxHeap.size());
    }
}
