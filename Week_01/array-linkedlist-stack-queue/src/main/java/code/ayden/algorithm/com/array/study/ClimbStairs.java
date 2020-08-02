package code.ayden.algorithm.com.array.study;

/**
 * @description: 爬楼梯问题
 * @author: aydenwang@tencent.com
 * @create: 2020-07-28 09:12
 * @version: 1.0.0
 **/
public class ClimbStairs {

    /**
     * 思路一：递归（自顶向下）
     * 1.找到可以重复的规律：
     * 最后一级台阶，是倒数第二级台阶和倒数第一级台阶解法的和
     * 2.写出公式：
     * f(n) = f(n-1) + f(n-2)
     * 3.找出终结条件：
     * f(1) = 1, f(2) =2
     * 4.把公式和终结条件翻译为代码
     * 时间复杂度：O（2n）
     * <p>
     * 缺点是非常慢，而且会存在大量重复计算,f(n-2)在第一次需要计算，第二次递归时又需要算一次
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 思路二：动态规划(自底向上)
     * 1.最基础的情况
     * f(1) = 1, f(2) =1
     * 2.递推的规律，再往上的每一级台阶的走法，都是前两级台阶的和
     * f(n) = f(n-1) + f(n-2)
     * 3.如果要计算n级台阶的走法，从第1级起，依次计算每一级后，把倒数第1级和倒数第2级加起来就是最后一级台阶的走法
     * 4.翻译成代码
     * 可以用数组，按下标，依次记录每1级的走法，最后一级用前两个元素相加
     *
     * @param n
     * @return
     */
    public int climbStairsDp(int n) {
        if (n <= 2) {
            return n;
        }

        //数组下标0也算一级台阶
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;

        for (int i = 3; i <= n; i++) {
            result[i] = result[i - 2] + result[i - 1];
        }

        return result[n];
    }

    /**
     * 思路二：动态规划(自底向上)，优化
     * 动态规划的思想
     * 但是空间复杂度不是最优解
     * 考虑到最终的步数是只和数据最后两位相关，可以不用数组保存，而使用两个临时变量保存起来
     *
     * @param n
     * @return
     */
    public int climbStairsDpBetter(int n) {
        // n<=2的判断，其实可以不要
        if (n <= 2) {
            return n;
        }
        // p = n-2的走法，q=n-1的走法，r=n的走法
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

}
