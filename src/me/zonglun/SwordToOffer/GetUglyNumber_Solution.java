package me.zonglun.SwordToOffer;

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

    // todo false answer
    public static int solutions(int index) {
        if (index <= 0) {
            return 0;
        }
        int result = 0;
        int uglyTar = 0;
        while (uglyTar < index) {
            uglyTar++;
            if (isUglyNumber(uglyTar)) {
                result++;
            }
        }
        return result;
    }

    private static boolean isUglyNumber(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return number == 1;
    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution.solutions(14));
    }
}
