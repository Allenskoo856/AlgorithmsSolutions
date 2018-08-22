package me.zonglun.SwordToOffer;

/**
 * 求1+2+3+...+N
 *
 * @author : Administrator
 * @subject :   求1+2+3+...+n，
 *          要求不能使用乘除法、for、while、if、else、switch、case 等关键字及条件判断语句 （A?B:C）
 * @create 2018-04-24 21:53
 */
public class Sum_SolutionN {

    /**
     * A&&B, 当A为false时，不去计算B的值而直接返回false；当A为true时，计算B的值。
     * 对于||，如果第一个值为false，那么还要计算第二个值，如果第一个值为true，那么第二个值不再计算；
     * 对于&和|操作符，两边无论如何都计算
     * 1.需利用逻辑与的短路特性实现递归终止。
     * 2. 当 n==0 时，(n>0)&&((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0；
     * 3. 当n>0 时，执行sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)。
     * @param n
     * @return
     */
    public int sum_solutions(int n) {
        int sum = n;
        boolean ans = (n > 0) && ((sum += sum_solutions(n - 1)) > 0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Sum_SolutionN().sum_solutions(5));
    }

}
