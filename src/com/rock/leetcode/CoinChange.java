package com.rock.leetcode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yanshi
 * Date: 2020-05-27
 * Time: 10:30
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        int count = 0;
        for (int i = coins.length; i >= 0; i--) {

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1, 2, 5}, 11));
    }

}
