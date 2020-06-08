package com.rock.leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: yanshi
 * Date: 2020-05-29
 * Time: 11:27
 */
public class Rob {

    //动态规划 dp表
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int rob = rob(i, nums, cache);
            max = Math.max(max, rob);
        }
        return max;
    }

    private int rob(int start, int[] nums, int[] cache) {
        if (start >= nums.length) return 0;
        int maxCount = Integer.MIN_VALUE;
        if (cache[start] != -1) return cache[start];
        int sum = nums[start];
        for (int i = start + 2; i < nums.length; i++) {
            int res = rob(i, nums, cache);
            if (res != 0) {
                maxCount = Math.max(res + sum, maxCount);
            }
        }
        cache[start] = maxCount == Integer.MIN_VALUE ? sum : maxCount;
        return cache[start];
    }

    public int robDp(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.min(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }


    public static void main(String[] args) {
        System.out.println(new Rob().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new Rob().rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(new Rob().rob(new int[]{2, 1, 1, 2}));
        System.out.println(new Rob().rob(new int[]{1, 2}));

        System.out.println("===================");

        System.out.println(new Rob().robDp(new int[]{1, 2, 3, 1}));
        System.out.println(new Rob().robDp(new int[]{2, 7, 9, 3, 1}));
        System.out.println(new Rob().robDp(new int[]{2, 1, 1, 2}));
        System.out.println(new Rob().robDp(new int[]{1, 2}));
    }

}
