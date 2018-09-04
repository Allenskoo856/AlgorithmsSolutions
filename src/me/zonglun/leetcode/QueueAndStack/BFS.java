package me.zonglun.leetcode.QueueAndStack;

import me.zonglun.SwordToOffer.util.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先搜索算法
 *
 * @author : Administrator
 * @create 2018-08-30 15:42
 */
public class BFS {
    class Node {
        int row; // 行列
        int column; // 列
        int round;  // 圈数

        public Node(int row, int column, int round) {
            this.row = row;
            this.column = column;
            this.round = round;
        }
    }

    // 上下左右
    private int[][] direct = {{-1, 0}, {1, 0}, {0, 1}, {0, 1}};
    private int[][] book = new int[4][4];
    private int[][] array = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
    };

    public void BSTAlgorithms() {
        Node start = new Node(0, 0, 0);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);
        book[0][0] = 1;
        while (queue.size() > 0) {
            // 出对对出队元素进行搜索
            Node temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int tx = temp.row + direct[i][0];
                int ty = temp.column + direct[i][1];
                if (tx < 0 || ty < 0 || tx >= 4 || ty >= 4) {
                    continue;
                }
                if (book[tx][ty] == 1) {
                    continue;
                }
                Node next = new Node(tx, ty, temp.round + 1);
                book[tx][ty] = 1;
                queue.offer(next);
                System.out.println("数值："+array[tx][ty]+",轮次："+(temp.round+1));
            }
        }
    }

    public static void main(String[] args) {
        new BFS().BSTAlgorithms();
    }
}
