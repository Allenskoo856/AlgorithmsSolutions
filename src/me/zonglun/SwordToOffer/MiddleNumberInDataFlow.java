package me.zonglun.SwordToOffer;

import java.util.LinkedList;

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

    private LinkedList<Integer> list = new LinkedList<>();

    /**
     * 将数据插入到linkList
     * @param num
     */
    public void insert(Integer num) {
        if (list.isEmpty() || num < list.getFirst()) {
            list.addFirst(num);
        } else {
            boolean isInsertSuccess = false;
            for (Integer i : list) {
                if (num < i) {
                    int index = list.indexOf(i);
                    list.add(index, num);
                    isInsertSuccess = true;
                    break;
                }
            }
            if (!isInsertSuccess) {
                list.addLast(num);
            }
        }
    }

    public Double GetMedian() {
        if(list.isEmpty()) {
            return null;
        }

        int mid = list.size() / 2;

        // 如果长度是偶数
        if((list.size() & 1) == 0) {
            Integer first = list.get(mid - 1);
            Integer second = list.get(mid);
            return Double.valueOf(first + second) / 2.0;
        }

        return Double.valueOf(list.get(mid));
    }
}
