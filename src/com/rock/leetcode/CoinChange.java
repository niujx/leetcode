package com.rock.leetcode;

import java.util.Arrays;

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
        return coinChange(0, coins, amount);
    }

    //使用回溯算法计算
    private int coinChange(int idxCoin, int[] coins, int amount) {
        if (amount == 0) return 0;
        if (idxCoin < coins.length && amount > 0) {
            int maxVal = amount / coins[idxCoin];
            int minCost = Integer.MAX_VALUE;
            for (int i = 0; i <= maxVal; i++) {
                if (amount >= i * coins[idxCoin]) {
                    int res = coinChange(idxCoin + 1, coins, amount - i * coins[idxCoin]);
                    if (res != -1) {
                        minCost = Math.min(minCost, res + i);
                    }
                }
            }
            return minCost == Integer.MAX_VALUE ? -1 : minCost;
        }

        return -1;
    }

    //f(s) = f(s-c)+1
    public int coinChangeDP(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChangeDP(coins, amount, new int[amount]);
    }

    public int coinChangeDP(int[] coins, int rem, int[] count) {
        if (rem == 0) return 0;
        if (rem < 0) return -1;
        if (count[rem - 1] != 0) return count[rem - 1];
        int minCost = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChangeDP(coins, rem - coin, count);
            if (res != -1) {
                minCost = Math.min(minCost, res + 1);
            }
        }
        count[rem - 1] = minCost == Integer.MAX_VALUE ? -1 : minCost;
        return count[rem - 1];
    }

    //f(1) = min(f(1-1),f(1-2),f(2-5)) +1
    //f(2) = min(f(2-1),f(2-2),f(2-5)) +1
    //f(3) = min(f(3-1),f(3-2),f(3-5)) +1
    public int coinChangeDP2(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new CoinChange().coinChange(new int[]{1}, 0));
        System.out.println(new CoinChange().coinChange(new int[]{1}, 1));
        System.out.println(new CoinChange().coinChange(new int[]{2}, 3));
        System.out.println(new CoinChange().coinChange(new int[]{186, 419, 83, 408}, 6249));

        System.out.println("--------------------------------------------------------------------");

        System.out.println(new CoinChange().coinChangeDP(new int[]{1, 2, 5}, 11));
        System.out.println(new CoinChange().coinChangeDP(new int[]{1}, 0));
        System.out.println(new CoinChange().coinChangeDP(new int[]{1}, 1));
        System.out.println(new CoinChange().coinChangeDP(new int[]{2}, 3));
        System.out.println(new CoinChange().coinChangeDP(new int[]{186, 419, 83, 408}, 6249));

        System.out.println("--------------------------------------------------------------------");

        System.out.println(new CoinChange().coinChangeDP2(new int[]{1, 2, 5}, 11));
        System.out.println(new CoinChange().coinChangeDP2(new int[]{1}, 0));
        System.out.println(new CoinChange().coinChangeDP2(new int[]{1}, 1));
        System.out.println(new CoinChange().coinChangeDP2(new int[]{2}, 3));
        System.out.println(new CoinChange().coinChangeDP2(new int[]{186, 419, 83, 408}, 6249));

    }

}
