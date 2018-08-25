package me.zonglun.SwordToOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 把数组拍成最小的数
 *
 * @author : Administrator
 * @subject : 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *      例如输入数组 {3，32，321}， 则打印出这三个数字能排成的最小数字为 321323 。
 * @create 2018-03-25 13:32
 */
public class PrintMinNumber {

    /**
     * 先对数组进行排序，对任意数字a，b，排序的规则如下：
     * a、b能拼接成数字ab或ba，
     * 如果ab <= ba， 则a排在b前面；
     * 如果ba < ab， 则b排在a前面；
     * Step2. 把排序后的数字依次打印出来，拼接数字
     * 排序借用Java中的Collections.sort()完成，需要自定义Comparator。排序的平均时间复杂度为O(nlogn)
     * 最后还需要从头遍历一遍数组，需要O(n)的时间
     * 因此总的时间复杂度为O(nlogn)
     * @param numbers
     * @return
     */
    public String printMinNumber(int[] numbers) {
        int n;
        String s = "";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });
        for (int j : list) {
            s += j;
        }
        return s;
    }
}
