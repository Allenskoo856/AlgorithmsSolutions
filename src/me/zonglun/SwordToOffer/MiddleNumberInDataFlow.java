package me.zonglun.SwordToOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 *
 * @author : Administrator
 * @create 2018-08-22 20:49
 * @subject :
 *      如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 *      如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *      我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class MiddleNumberInDataFlow {
    int count;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            // PriorityQueue 默认是小顶堆，实现大顶堆要反转
            return o2.compareTo(o1);
        }
    });

    public void Insert(Integer num) {
        count++;
        if (count % 2 == 0) {
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                maxHeap.offer(num);
            }
            minHeap.offer(num);
        } else {
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public Double GetMedian() {
        if (count == 0) {
            throw new RuntimeException("no available numbers!");
        }
        double result = 0.0;
        if (count % 2 == 1) {
            result = maxHeap.peek();
        } else {
            result = (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return result;
    }
}
