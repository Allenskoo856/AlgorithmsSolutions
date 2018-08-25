package me.zonglun.SwordToOffer;

import java.util.ArrayList;

/**
 * 丑数
 *
 * @author : Administrator
 * @subject : 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 *          例如6、8 都是丑数，但 14 不是，因为它包含因子7。
 *          习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @create 2018-03-26 15:42
 */
public class GetUglyNumber_Solution {

    /**
     * 丑数解决--办法
     * @param index 数组
     * @return 数字
     */
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        // add 进第一个丑数
        list.add(1);
        // 三个下标用来记录丑数的位置
        int i2 = 0, i3 = 0, i5 = 0;
        while (list.size() < index) {
            // 三个数都是可能的丑数，取最小的放进丑数数组里面
            int n2 = list.get(i2) * 2;
            int n3 = list.get(i3) * 3;
            int n5 = list.get(i5) * 5;
            int min = Math.min(n2, Math.min(n3,n5));
            list.add(min);
            if (min == n2)
                i2++;
            if (min == n3) {
                i3++;
            }
            if (min == n5) {
                i5++;
            }
        }
        return list.get(list.size() - 1);
    }
}
