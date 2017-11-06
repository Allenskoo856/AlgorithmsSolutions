/*
 * Copyright (C), 2015-2017
 * FileName: IndexMaxHeap
 * Author:   Administrator
 * Date:     2017/11/6 0006 21:23
 * Description: 最大索引堆    
 */

package me.zonglun.Sort;

/**
 * 〈一句话功能简述〉<br>
 * 〈最大索引堆〉
 *
 * @author Administrator
 * @create 2017/11/6 0006
 * @since 1.0.0
 */
public class IndexMaxHeap<T extends Comparable> {
    protected T[] data;     // 最大索引堆中的数据
    protected int[] indexes;    // 最大索引堆中的索引
    protected int count;  // 最大索引堆之中的数据个数
    protected int capacity;

    public IndexMaxHeap(int capacity) {
        data = (T[]) new Comparable[capacity + 1];
        indexes = new int[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    // 返回索引堆中的元素个数
    public int size(){
        return count;
    }
    // 返回一个布尔值, 表示索引堆中是否为空
    public boolean isEmpty(){
        return count == 0;
    }
    // 向最大索引堆中插入一个新的元素, 新元素的索引为i, 元素为item
    // 传入的i对用户而言,是从0索引的
    public void insert(int i, T item){
        assert count + 1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;

        i += 1;
        data[i] = item;
        indexes[count+1] = i;
        count ++;
        shiftUp(count);
    }

    // 获取最大索引堆中的堆顶元素
    public T getMax(){
        assert count > 0;
        return data[indexes[1]];
    }

    // 获取最大索引堆中的堆顶元素的索引
    public int getMaxIndex(){
        assert count > 0;
        return indexes[1]-1;
    }

    // 获取最大索引堆中索引为i的元素
    public T getItem( int i ){
        assert i + 1 >= 1 && i + 1 <= capacity;
        return data[i+1];
    }

    // 将最大索引堆中索引为i的元素修改为newItem
    public void change( int i , T newItem ){

        i += 1;
        data[i] = newItem;

        // 找到indexes[j] = i, j表示data[i]在堆中的位置
        // 之后shiftUp(j), 再shiftDown(j)
        for( int j = 1 ; j <= count ; j ++ )
            if( indexes[j] == i ){
                shiftUp(j);
                shiftDown(j);
                return;
            }
    }

    // 交换索引堆中的索引i和j
    private void swapIndexes(int i, int j){
        int t = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = t;
    }

    //********************
    //* 最大索引堆核心辅助函数
    //********************

    // 索引堆中, 数据之间的比较根据data的大小进行比较, 但实际操作的是索引
    private void shiftUp(int k){

        while( k > 1 && data[indexes[k/2]].compareTo(data[indexes[k]]) < 0 ){
            swapIndexes(k, k/2);
            k /= 2;
        }
    }

    // 索引堆中, 数据之间的比较根据data的大小进行比较, 但实际操作的是索引
    private void shiftDown(int k){

        while( 2*k <= count ){
            int j = 2*k;
            if( j+1 <= count && data[indexes[j+1]].compareTo(data[indexes[j]]) > 0 )
                j ++;
            if( data[indexes[k]].compareTo(data[indexes[j]]) >= 0 )
                break;
            swapIndexes(k, j);
            k = j;
        }
    }

    // 从最大索引堆中取出堆顶元素, 即索引堆中所存储的最大数据
   public T extractMax(){
        assert count > 0;

        T ret = data[indexes[1]];
        swapIndexes( 1 , count );
        count --;
        shiftDown(1);

        return ret;
    }
}
