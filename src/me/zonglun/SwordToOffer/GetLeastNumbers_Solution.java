package me.zonglun.SwordToOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最小的K的个数
 *
 * @author : Administrator
 * @subject :   输入n个整数，找出其中 最小的 K 个数。
 *              例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @create 2018-03-23 20:31
 */
public class GetLeastNumbers_Solution {


    /**
     *  采用堆排序的最大堆来做
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> getLeastNumber_solutions(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k > input.length || k == 0) {
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());

        for (int anInput : input) {
            if (maxHeap.size() != k) {
                maxHeap.offer(anInput);
            } else if (maxHeap.peek() > anInput) {
                Integer temp = maxHeap.poll();
                maxHeap.offer(anInput);
            }
        }

        result.addAll(maxHeap);
        return result;
    }

    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        GetLeastNumbers_Solution gs = new GetLeastNumbers_Solution();
        System.out.println(gs.getLeastNumber_solutions(input,4));
    }
}
